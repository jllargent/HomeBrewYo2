

package edu.bsu.cs222.cnj.homebrewyo2;

public class NewHop extends Ingredient{

    private String timeToAddHop;

    public void setAmount(String weightInGrams){
        this.amount = weightInGrams;
    }

    public void setTimeToAdd(String time) {
        this.timeToAddHop = time;
    }

    public String getAmount(){
        return this.amount;
    }

    public String getTimeToAdd(){
        return this.timeToAddHop;
    }
}

