package edu.bsu.cs222.cnj.homebrewyo2;

import java.util.ArrayList;

public class Ingredients {
    private ArrayList<Hop> listOfHops = new ArrayList<>();
    private ArrayList<Malt> listOfMalts = new ArrayList<>();
    private String yeast;

    public Ingredients(){
    }

    public void setYeast(String yeastDescription){
        yeast = yeastDescription;
    }

    public void addToMaltsList(Malt maltToAdd){
        listOfMalts.add(maltToAdd);
    }
    public void addToHopsList(Hop hopToAdd){
        listOfHops.add(hopToAdd);
    }

    public ArrayList<Hop> getListOfHops(){
        return listOfHops;
    }
    public ArrayList<Malt> getListOfMalts(){
        return listOfMalts;
    }
    public String getYeast(){
        return yeast;
    }

}
