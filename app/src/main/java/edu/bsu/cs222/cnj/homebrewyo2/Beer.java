package edu.bsu.cs222.cnj.homebrewyo2;

import java.sql.CallableStatement;

public class Beer {
    private String titleOfBeer;
    private String styleOfBeer;
    private String descriptionOfBeer;
    private int valueOfABV;


    public Beer(){
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
    public void setValueOfABV(int aBVValue){
        valueOfABV = aBVValue;
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


}
