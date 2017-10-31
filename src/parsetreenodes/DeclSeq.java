package parsetreenodes;

import interpreter.Tokenizer;

public class DeclSeq {
    private Declaration decl;
    private DeclSeq ds;

    public DeclSeq() {
        this.decl = null;
        this.ds = null;
    }

    public void parseDeclSeq() {
    	this.decl = new Declaration();
    	this.decl.parseDeclaration();
    	
    	int currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get("int")) {
        	this.ds = new DeclSeq();
        	this.ds.parseDeclSeq();
        }
    }

    public void printDeclSeq() {
    	System.out.print(this.decl + " ");
    	if(this.ds != null){
    		System.out.print(this.ds + " ");
    	}
    }

    public void execDeclSeq() {
    	this.decl.execDeclaration();
    	if(this.ds != null){
    		this.ds.execDeclSeq();
    	}
    }

}
