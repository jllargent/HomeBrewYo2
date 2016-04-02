package edu.bsu.cs222.cnj.homebrewyo2;

public class Hop {
    private String nameOfHop;
    private double amountOfHopsInGrams = 0;
    private String timeToAddHop;

    Hop(){
    }

    public void setNameOfHop(String name){
        nameOfHop = name;
    }

    public void setAmountOfHopsInGrams(double weight){
        amountOfHopsInGrams = weight;
    }

    public void setTimeToAddHop(String time) {
        timeToAddHop = time;
    }

    public String getNameOfHop(){
        return nameOfHop;
    }
    public String getAmountOfHops(){
        return amountOfHopsInGrams + "g";
    }
    public String getTimeToAddHop(){
        return timeToAddHop;
    }
}
