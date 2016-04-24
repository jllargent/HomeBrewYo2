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
}
