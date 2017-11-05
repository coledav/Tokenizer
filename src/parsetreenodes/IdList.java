package parsetreenodes;

import java.util.ArrayList;

import interpreter.Tokenizer;

public class IdList {

    private Id id;
    private IdList idList;

    public IdList() {
        this.id = null;
        this.idList = null;
    }

    public void parseIdList() {
        this.id = Id.parseId(Tokenizer.idName());

        if (Tokenizer.getToken() == Tokenizer.tokenNumbers.get(",")) {
            Tokenizer.skipToken();
        }

        if (Tokenizer.getToken() == Tokenizer.tokenNumbers.get("id")) {
            this.idList = new IdList();
            this.idList.parseIdList();
        }
    }

    public void printIdList() {
        this.id.printId();
        if (this.idList != null) {
            System.out.print(", ");
            this.idList.printIdList();
        }
    }

    public ArrayList<Id> execIdList() {
        ArrayList<Id> arrayListIds = new ArrayList<Id>();
        arrayListIds.add(this.id);
        if (this.idList != null) {
            arrayListIds.addAll(this.idList.execIdList());
        }
        return arrayListIds;
    }
}
