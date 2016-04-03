package edu.bsu.cs222.cnj.homebrewyo2;

public class Beer_New {
    private String titleOfBeer;
    private String styleOfBeer;
    private String descriptionOfBeer;
    private String valueOfABV;
    private String originalGravity;
    private String finalGravity;
    private String timeInMins;
    private String boilDescription;
    private String fermentTemperature;
    private String ibuValue;


    public Beer_New(){
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
    public void setValueOfABV(String abvValue){
        valueOfABV = abvValue;
    }
    public void setIBUValue(String info){
        ibuValue = info;
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
    public void setOriginalGravity(String gravity){
        originalGravity = gravity;
    }
    public void setFinalGravity(String gravity){
        finalGravity = gravity;
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
    public String getIBUValue(){
        return ibuValue;
    }
    public String getTimeInMins(){
        return timeInMins;
    }
    public String getBoilDescription(){
        return boilDescription;
    }
    public String getFermentTemp(){
        return fermentTemperature;
    }
    public String getOriginalGravity() {
        return originalGravity;
    }
    public String getFinalGravity(){
        return finalGravity;
    }
}
