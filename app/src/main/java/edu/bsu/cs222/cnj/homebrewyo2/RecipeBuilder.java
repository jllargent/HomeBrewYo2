package edu.bsu.cs222.cnj.homebrewyo2;

public class RecipeBuilder extends BeerBuilder{
    @Override
    public void buildName(String name) {
        thisBeer.setName(name);
    }

    @Override
    public void buildDescription(String description) {
        thisBeer.setDescription(description);
    }

    @Override
    public void buildMalt(Ingredient malt) {
        thisBeer.addMalt(malt);
    }

    @Override
    public void buildHop(Ingredient hop) {
        thisBeer.addHop(hop);
    }

    @Override
    public void buildTime(int time) {

        thisBeer.setTimeInMinutes(time);
    }

    @Override
    public void buildTemp(int temp) {
        thisBeer.setTempInFahrenheit(temp);
    }

    @Override
    public void buildStyle(String style) {
        thisBeer.setStyle(style);
    }

    @Override
    public void buildFermentTemp(int fermentTemp) {
        thisBeer.setFermentTemp(fermentTemp);
    }

    @Override
    public void buildABVPercent(double abvPercent) {
        thisBeer.setAbvPercent(abvPercent);
    }

    @Override
    public void buildIBUValue(int ibuValue) {
        thisBeer.setIbuValue(ibuValue);
    }

    @Override
    public void buildTargetFinalGravity(double targetFinalGravity) {
        thisBeer.setTargetFinalGravity(targetFinalGravity);
    }

    @Override
    public void buildTargetOriginalGravity(double targetOriginalGravity) {
        thisBeer.setTargetOriginalGravity(targetOriginalGravity);
    }
}
