package edu.bsu.cs222.cnj.homebrewyo2;

public class Ingredient {

    protected String name;
    protected String amount;

    protected void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

