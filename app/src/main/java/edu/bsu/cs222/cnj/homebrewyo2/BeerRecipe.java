package edu.bsu.cs222.cnj.homebrewyo2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BeerRecipe implements Serializable{
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
        private BeerRecipe thisBeerRecipe;

        public BeerRecipe getBeer(){
            return thisBeerRecipe;
        }

        public void createBeer(){
            thisBeerRecipe = new BeerRecipe();
        }

        public void buildName(String name) {
            thisBeerRecipe.name = name;
        }

        public void buildDescription(String description) {
            thisBeerRecipe.description = description;
        }

        public void addMalt(Ingredient malt) {
            thisBeerRecipe.malts.add(malt);
        }

        public void addHop(Ingredient hop) {
            thisBeerRecipe.hops.add(hop);
        }

        public void buildYeast(Ingredient yeast){
            thisBeerRecipe.yeast = yeast;
        }

        public void buildTime(int time) {

            thisBeerRecipe.time = time;
        }

        public void buildTemp(int temp) {
            thisBeerRecipe.temperature = temp;
        }

        public void buildStyle(String style) {
            thisBeerRecipe.style = style;
        }

        public void buildFermentTemp(int fermentTemp) {
            thisBeerRecipe.fermentTemperature = fermentTemp;
        }

        public void buildABVPercent(double abvPercent) {
            thisBeerRecipe.abvPercent = abvPercent;
        }

        public void buildIBUValue(int ibuValue) {
            thisBeerRecipe.ibuValue = ibuValue;
        }

        public void buildTargetFinalGravity(double targetFinalGravity) {
            thisBeerRecipe.targetFinalGravity = targetFinalGravity;
        }

        public void buildTargetOriginalGravity(double targetOriginalGravity) {
            thisBeerRecipe.targetOriginalGravity = targetOriginalGravity;
        }
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
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
