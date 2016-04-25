package edu.bsu.cs222.cnj.homebrewyo2;

public class Ingredient {

    protected String name;
    protected double amount;
    protected String type;

    public Ingredient(int typeNum){
        switch(typeNum){
            case 0:
                this.type = "Malt";
                break;
            case 1:
                this.type = "Hop";
                break;
            case 2:
                this.type = "Yeast";
                break;
            default:
                this.type = "DNE";
        }
    }
}

