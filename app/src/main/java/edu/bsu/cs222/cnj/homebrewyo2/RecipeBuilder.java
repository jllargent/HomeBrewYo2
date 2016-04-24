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
    public void buildMalt(Malt malt) {
        thisBeer.addMalt(malt);
    }

    @Override
    public void buildHop(Hop hop) {
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
}
