package edu.bsu.cs222.cnj.homebrewyo2;

public class Malt {
    private String nameOfMalt;
    private double amountOfMaltsInPounds = 0;

    public Malt(){
    }

    public void setNameOfMalt(String name){
        nameOfMalt = name;
    }
    public void setWeightOfMaltsInPounds(double weight){
        amountOfMaltsInPounds = weight;
    }

    public String getNameOfMalt(){
        return nameOfMalt;
    }
    public String getAmountOfMalt(){
        return amountOfMaltsInPounds + "lbs";
    }
}
