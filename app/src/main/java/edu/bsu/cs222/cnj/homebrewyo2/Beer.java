package edu.bsu.cs222.cnj.homebrewyo2;

import java.util.ArrayList;

public class Beer {
    private String titleOfBeer;
    private String styleOfBeer;
    private String descriptionOfBeer;
    private String valueOfABV;
    private String timeInMins;
    private String boilDescription;
    private String fermentTemperature;
    private Ingredients ingredients = new Ingredients();
    private Gravity gravity = new Gravity();

    public Beer(){
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
    public void setValueOfABV(String abvValue){
        valueOfABV = abvValue;
    }
    public void setTimeInMins(String time){
        timeInMins = time;
    }
    public void setBoilDescription(String boil){
        boilDescription = boil;
    }
    public void setFermentTemperature(String fermentInfo){
        fermentTemperature = fermentInfo;
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
        return valueOfABV;
    }
    public int getTimeInMins(){
        return Integer.parseInt(timeInMins);
    }
    public String getBoilDescription(){
        return boilDescription;
    }
    public String getFermentTemp(){
        return fermentTemperature;
    }

    public void setOriginalGravity(String oGravity){
        gravity.setOriginalGravity(oGravity);
    }
    public void setFinalGravity(String fGravity){
        gravity.setFinalGravitiy(fGravity);
    }
    public String getOriginalGravity() {
        return gravity.getOriginalGravity();
    }
    public String getFinalGravity(){
        return gravity.getFinalGravity();
    }

    public void addMaltIngredient(Malt malt){
        ingredients.addToMaltsList(malt);
    }
    public void addHopingredient(Hop hop){
        ingredients.addToHopsList(hop);
    }
    public void setYeastIngredient(String yeastIngredient){
        ingredients.setYeast(yeastIngredient);
    }

    public ArrayList<Malt> getMaltIngredients(){
        return ingredients.getListOfMalts();
    }
    public ArrayList<Hop> getHopIngredients(){
        return ingredients.getListOfHops();
    }
    public String getYeastIngredient(){
        return ingredients.getYeast();
    }

}
