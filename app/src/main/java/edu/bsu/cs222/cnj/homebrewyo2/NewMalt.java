

package edu.bsu.cs222.cnj.homebrewyo2;

public class NewMalt extends Ingredient {

    public void setAmount(String weightInPounds){
        this.amount = weightInPounds;
    }

    public String getAmount(){
        return this.amount;
    }
}