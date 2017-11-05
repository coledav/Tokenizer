package parsetreenodes;

import java.util.ArrayList;

import interpreter.Tokenizer;

public class WriteStatement extends Statement {

    private IdList idList;

    public WriteStatement() {
        this.idList = null;
    }

    public void parseWrite() {
        int currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("write")) {
            throw new java.lang.Error(
                    "Expected string 'write', instead found: " + currentToken);
        }
        Tokenizer.skipToken();
        this.idList = new IdList();
        this.idList.parseIdList();

        currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get(";")) {
            throw new java.lang.Error(
                    "Expected string ';', instead found: " + currentToken);
        } else {
            Tokenizer.skipToken();
        }
    }

    @Override
    public void printStatement() {
        System.out.print("write ");
        this.idList.printIdList();
        System.out.print(";\n");
    }

    @Override
    public void execStatement() {
        ArrayList<Id> ids = this.idList.execIdList();
        for (Id id : ids) {
            if (id.isDeclared()) {
                if (id.isInitialized()) {
                    System.out.print(
                            id.getIdName() + " = " + id.getValue() + "\n");
                } else {
                    throw new java.lang.Error(
                            "ID that is being written is not initialized");
                }
            } else {
                throw new java.lang.Error("ID written is not delcared");
            }
        }
    }

}
