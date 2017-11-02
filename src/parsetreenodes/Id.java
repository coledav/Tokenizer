package parsetreenodes;

import java.util.ArrayList;

import interpreter.Tokenizer;

public class Id {

	private String name;
	private int value;
	private boolean declared;
	private boolean initialized;
	
	public static ArrayList<Id> currentIds = new ArrayList<Id>();
	
	public Id(String name){
		this.name = name;
		this.setDeclared(false);
		this.setInitialized(false);
	}
	
	public static Id parseId(){
		String idName = Tokenizer.idName();
		for(Id id : currentIds){
			if(id.name == idName){
				return id;
			}
		}
		
		Id newId = new Id(idName);
		currentIds.add(newId);
		return newId;
	}
	
	public String getIdName(){
		return this.name;
	}
	
	public int getValue(){
		if(this.initialized == true){
			return this.value;
		}else{
			throw new java.lang.Error("Tried to access an uninitialized variable: " + this.name);
		}
	}
	
	public void setValue(int newValue){
		this.value = newValue;
	}

	public boolean isDeclared() {
		return declared;
	}

	public void setDeclared(boolean declared) {
		this.declared = declared;
	}

	public boolean isInitialized() {
		return initialized;
	}

	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}
	
	
	public void printId(){
		System.out.print(this.name);
	}
	
	public void printIdValue(){
		System.out.print(this.value);
	}
}
