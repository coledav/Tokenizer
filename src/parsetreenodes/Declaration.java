package parsetreenodes;

import java.util.ArrayList;

import interpreter.Tokenizer;

public class Declaration {

    private IdList idList;

    public Declaration() {
        this.idList = null;
    }

    public void parseDeclaration() {
        Tokenizer.skipToken(); //skip 'int'
        if (Tokenizer.getToken() == Tokenizer.tokenNumbers.get("id")) {
            this.idList = new IdList();
            this.idList.parseIdList();
        } else {
            throw new java.lang.Error("Expected id list");
        }

//        for (Id id : this.idList.execIdList()) {
//            id.setDeclared(true);
//        }

        if (Tokenizer.getToken() != Tokenizer.tokenNumbers.get(";")) {
            throw new java.lang.Error("Expected semi-colon");
        }
        Tokenizer.skipToken();
    }

    public void printDeclaration() {
        System.out.print("int ");
        this.idList.printIdList();
        System.out.print(";\n");
    }

    public void execDeclaration() {
        ArrayList<Id> ids = this.idList.execIdList();
        for (Id id : ids) {
            if (!id.isDeclared()) {
                id.setDeclared(true);
            } else {
                throw new java.lang.Error(
                        "Id " + id.getIdName() + "was already declared");
            }
        }
    }
}
