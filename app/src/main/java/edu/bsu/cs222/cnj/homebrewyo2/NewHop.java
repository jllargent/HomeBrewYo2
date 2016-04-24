

package edu.bsu.cs222.cnj.homebrewyo2;

public class NewHop extends Ingredient{

    private String timeToAddHop;

    public void setName(String nameOfHop){
        this.name = nameOfHop;
    }

    public void setAmountInGrams(String weight){
        this.amount = weight;
    }

    public void setTimeToAdd(String time) {
        this.timeToAddHop = time;
    }

    public String getName(){
        return this.name;
    }

    public String getAmount(){
        return this.amount;
    }

    public String getTimeToAdd(){
        return this.timeToAddHop;
    }
}

