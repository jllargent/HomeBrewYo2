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
    private Ingredient yeast;

    public static class BeerBuilder{
        public Beer thisBeer;

        public Beer getBeer(){
            return thisBeer;
        }

        public void createBeer(){
            thisBeer = new Beer();
        }

        public void buildName(String name) {
            thisBeer.name = name;
        }

        public void buildDescription(String description) {
            thisBeer.description = description;
        }

        public void addMalt(Ingredient malt) {
            thisBeer.malts.add(malt);
        }

        public void addHop(Ingredient hop) {
            thisBeer.hops.add(hop);
        }

        public void buildYeast(Ingredient yeast){
            thisBeer.yeast = yeast;
        }

        public void buildTime(int time) {

            thisBeer.time = time;
        }

        public void buildTemp(int temp) {
            thisBeer.temperature = temp;
        }

        public void buildStyle(String style) {
            thisBeer.style = style;
        }

        public void buildFermentTemp(int fermentTemp) {
            thisBeer.fermentTemperature = fermentTemp;
        }

        public void buildABVPercent(double abvPercent) {
            thisBeer.abvPercent = abvPercent;
        }

        public void buildIBUValue(int ibuValue) {
            thisBeer.ibuValue = ibuValue;
        }

        public void buildTargetFinalGravity(double targetFinalGravity) {
            thisBeer.targetFinalGravity = targetFinalGravity;
        }

        public void buildTargetOriginalGravity(double targetOriginalGravity) {
            thisBeer.targetOriginalGravity = targetOriginalGravity;
        }
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public List<Ingredient> getMalts(){
        return new ArrayList<>(this.malts);
    }

    public List<Ingredient> getHops(){
        return new ArrayList<>(this.hops);
    }

    public int getTimeInMinutes(){
        return this.time;
    }

    public int getTemperatureInFahrenheit(){
        return this.temperature;
    }

    public String getStyle(){
        return this.style;
    }

    public int getFermentTemperature(){
        return this.fermentTemperature;
    }

    public double getABVPercent(){
        return this.abvPercent;
    }

    public Ingredient getYeast(){
        return this.yeast;
    }

    public int getIbuValue(){
        return this.ibuValue;
    }

    public double getTargetFinalGravity(){
        return this.targetFinalGravity;
    }

    public double getTargetOriginalGravity(){
        return this.targetOriginalGravity;
    }
}
