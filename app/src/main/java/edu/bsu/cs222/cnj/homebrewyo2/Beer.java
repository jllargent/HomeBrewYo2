package edu.bsu.cs222.cnj.homebrewyo2;

import java.sql.CallableStatement;

public class Beer {
    private String titleOfBeer;
    private String styleOfBeer;
    private String descriptionOfBeer;
    private int valueOfABV;
    private Gravity gravity;
    private int timeInMins;
    private int boilTemp;
    private int fermentTemperature;
    private int ibuValue;


    public Beer(String s){
        titleOfBeer = getTitleOfBeer();
        styleOfBeer = getStyleOfBeer();
        descriptionOfBeer = getDescriptionOfBeer();
    }




    public void setTitleOfBeer(String name){
        titleOfBeer = name;
    }
    public void setStyleOfBeer(String beerStyle){
        styleOfBeer = beerStyle;
    }
    public void setDescriptionOfBeer(String description){
        descriptionOfBeer = description;
    }
    public void setValueOfABV(int abvValue){
        valueOfABV = abvValue;
    }

    public void setTimeInMins(int time){
        timeInMins = time;
    }
    public void setBoilTemp(int temp){
        boilTemp = temp;
    }
    public void setFermentTemperature(int temp){
        fermentTemperature = temp;
    }
    public void setOriginalGravity(int value){
        gravity.setOriginalGravity(value);
    }
    public void setFinalGravity(int value){
        gravity.setFinalGravitiy(value);
    }

    public String getTitleOfBeer(){
        return titleOfBeer;
    }
    public String getStyleOfBeer(){
        return styleOfBeer;
    }
    public String getDescriptionOfBeer(){
        return descriptionOfBeer;
    }
    public String getValueOfABV(){
        return valueOfABV + "%";
    }
    public int getTimeInMins(){
        return timeInMins;
    }
    public String getBoilDescription(){
        return "Boil for " + timeInMins + " minutes at " + boilTemp + "F";
    }
    public String getFermentTemp(){
        return "Ferment at " + fermentTemperature + "F";
    }
    public String getOriginalGravity() {
        return "Original Gravity: " + gravity.getOriginalGravity();
    }
    public String getFinalGravity(){
        return "Final Gravity: " + gravity.getFinalGravity();
    }
}
