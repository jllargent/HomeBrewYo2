package edu.bsu.cs222.cnj.homebrewyo2;

public class Hop {
    private String nameOfHop;
    private String amountOfHopsInGrams;
    private String timeToAddHop;

    Hop(){
    }

    public void setNameOfHop(String name){
        nameOfHop = name;
    }

    public void setAmountOfHopsInGrams(String weight){
        amountOfHopsInGrams = weight;
    }

    public void setTimeToAddHop(String time) {
        timeToAddHop = time;
    }

    public String getNameOfHop(){
        return nameOfHop;
    }
    public String getAmountOfHops(){
        return amountOfHopsInGrams;
    }
    public String getTimeToAddHop(){
        return timeToAddHop;
    }
}
