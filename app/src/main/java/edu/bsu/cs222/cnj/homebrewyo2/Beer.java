package edu.bsu.cs222.cnj.homebrewyo2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Beer implements Serializable{
    private String name;
    private String description;
    private String style;
    private List<Ingredient> malts = new ArrayList<>();
    private List<Ingredient> hops = new ArrayList<>();
    private int time;
    private int temperature;
    private int fermentTemperature;
    private int ibuValue;
    private double targetFinalGravity;
    private double targetOriginalGravity;
    private double abvPercent;

    protected void setName(String name){
        this.name = name;
    }

    protected void setDescription(String description){
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    protected void addMalt(Ingredient malt){
        this.malts.add(malt);
    }

    public List<Ingredient> getMalts(){
        return new ArrayList<>(this.malts);
    }

    protected void addHop(Ingredient hop){
        this.hops.add(hop);
    }

    public List<Ingredient> getHops(){
        return new ArrayList<>(this.hops);
    }

    protected void setTimeInMinutes(int minutes){
        this.time = minutes;
    }

    public int getTimeInMinutes(){
        return this.time;
    }

    protected void setTempInFahrenheit(int temp){
        this.temperature = temp;
    }

    public int getTemperatureInFahrenheit(){
        return this.temperature;
    }

    protected void setStyle(String beerStyle){
        this.style = beerStyle;
    }

    public String getStyle(){
        return this.style;
    }

    protected void setFermentTemp(int fermTemp){
        this.fermentTemperature = fermTemp;
    }

    public int getFermentTemperature(){
        return this.fermentTemperature;
    }

    protected void setAbvPercent(double abv){
        this.abvPercent = abv;
    }

    public double getABVPercent(){
        return this.abvPercent;
    }

    protected void setIbuValue(int ibu){
        this.ibuValue = ibu;
    }

    public int getIbuValue(){
        return this.ibuValue;
    }

    protected void setTargetFinalGravity(double targetFG){
        this.targetFinalGravity = targetFG;
    }

    public double getTargetFinalGravity(){
        return this.targetFinalGravity;
    }

    protected void setTargetOriginalGravity(double targetOG){
        this.targetOriginalGravity = targetOG;
    }

    public double getTargetOriginalGravity(){
        return this.targetOriginalGravity;
    }
}
