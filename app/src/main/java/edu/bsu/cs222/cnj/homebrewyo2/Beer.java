package edu.bsu.cs222.cnj.homebrewyo2;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class Beer {
    private String name;
    private String description;
    private String style;
    private List<Malt> malts = new ArrayList<>();
    private List<Hop> hops = new ArrayList<>();
    private int time;
    private int temperature;
    private int fermentTemperature;
    private int ibuValue;
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

    protected void addMalt(Malt malt){
        this.malts.add(malt);
    }

    public List<Malt> getMalts(){
        return new ArrayList<>(this.malts);
    }

    protected void addHop(Hop hop){
        this.hops.add(hop);
    }

    public List<Hop> getHops(){
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
}
