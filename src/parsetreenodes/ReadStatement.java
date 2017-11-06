package parsetreenodes;

import java.util.ArrayList;

import interpreter.Interpreter;
import interpreter.Tokenizer;

public class ReadStatement extends Statement {
    private IdList idList;

    public ReadStatement() {
        this.idList = null;
    }

    public void parseRead() {
        int currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("read")) {
            throw new java.lang.Error(
                    "Expected string 'read', instead found: " + currentToken);
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
        System.out.print("read ");
        this.idList.printIdList();
        System.out.print(";\n");
    }

    @Override
    public void execStatement() {
        ArrayList<Id> ids = this.idList.execIdList();
        for (Id id : ids) {
            if (id.isDeclared()) {
                id.setValue(Interpreter.inputData.removeFirst());
                id.setInitialized(true);
            } else {
                throw new java.lang.Error(
                        "ID that is being read into is not delcared");
            }
        }
    }
}
