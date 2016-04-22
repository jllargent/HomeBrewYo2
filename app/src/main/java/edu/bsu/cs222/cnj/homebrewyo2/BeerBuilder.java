package edu.bsu.cs222.cnj.homebrewyo2;

public class BeerBuilder {
    public Beer thisBeer;
    public BeerBuilder(){
        thisBeer = new Beer("test");
    }

    public Beer returnBeer(){
        return thisBeer;
    }
}
