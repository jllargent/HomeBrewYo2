package edu.bsu.cs222.cnj.homebrewyo2;

public class Ingredient {

    protected String name;
    protected double amount;
    protected String type;

    public Ingredient(int typeNum){
        switch(typeNum){
            case 0:
                this.type = "malt";
                break;
            case 1:
                this.type = "hop";
                break;
            case 2:
                this.type = "yeast";
                break;
            default:
                this.type = "DNE";
        }
    }
}

