

package edu.bsu.cs222.cnj.homebrewyo2;

public class NewMalt extends Ingredient {

    protected void setName(String nameOfMalt){
        this.name = nameOfMalt;
    }

    protected void setWeightInPounds(String weight){
        this.amount = weight;
    }

    public String getName(){
        return this.name;
    }

    public String getAmount(){
        return this.amount;
    }
}