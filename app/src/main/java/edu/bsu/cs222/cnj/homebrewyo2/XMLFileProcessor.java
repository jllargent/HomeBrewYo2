package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class XMLFileProcessor {
    private ArrayList<Beer> listOfBeers = new ArrayList<>();
    private Beer beer;
    private Hop hop;
    private Malt malt;
    private String text = null;
    private String currentTag;
    private String parentTag = null;
    private ClassLoader classLoader = this.getClass().getClassLoader();
    private InputStream resource = classLoader.getResourceAsStream("res/raw/beerrecipes.xml");

    public XMLFileProcessor(){
        try{
            XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser myParser = xmlFactoryObject.newPullParser();
            myParser.setInput(resource, null);
            int event = myParser.getEventType();

            do{
                currentTag = myParser.getName();

                switch (event) {
                    case XmlPullParser.START_TAG:
                        checkStartTagForNewObjectToCreate();
                        break;

                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if( isActiveObject("recipe") )
                            addInfoIntoBeerObject();
                        else if ( isActiveObject("maltIngredient") )
                            addInfoIntoMaltObject();
                        else if ( isActiveObject("hopingredient") )
                            addInfoIntoHopObject();
                        addIngredientIntoRecipe();
                        addBeerObjectToList();
                        break;

                    default:
                        break;
                }

                event = myParser.next();
            }while(event != XmlPullParser.END_DOCUMENT );
        }catch(Exception e){
            Log.wtf("OOPS", e);
        }
    }

    public ArrayList<Beer> getListOfBeers(){
        return listOfBeers;
    }

    private boolean checkCurrentTag(String tagToCheck){
        return currentTag.equalsIgnoreCase(tagToCheck);
    }

    private void addInfoIntoBeerObject(){
        if (checkCurrentTag("name")) {
            beer.setTitleOfBeer(text);
        } else if (checkCurrentTag("style")) {
            beer.setStyleOfBeer(text);
        } else if (checkCurrentTag("description")) {
            beer.setDescriptionOfBeer(text);
        }else if (checkCurrentTag("temp")) {
            beer.setBoilDescription(text);
        }else if (checkCurrentTag("time")) {
            beer.setTimeInMins(text);
        }else if (checkCurrentTag("fermtemp")) {
            beer.setFermentTemperature(text);
        }else if (checkCurrentTag("abv")) {
            beer.setValueOfABV(text);
        }else if (checkCurrentTag("targetfg")) {
            beer.setFinalGravity(text);
        }else if (checkCurrentTag("targetog")) {
            beer.setOriginalGravity(text);
        }
    }

    private void addInfoIntoMaltObject(){
        if (checkCurrentTag("maltName"))
            malt.setNameOfMalt(text);
       else if (checkCurrentTag("maltweight")) {
           malt.setWeightOfMaltsInPounds(text);
        }
    }

    private void addInfoIntoHopObject(){
        if(checkCurrentTag("hopsName")){
            hop.setNameOfHop(text);
        }
        else if( checkCurrentTag("hopsamount")){
            hop.setAmountOfHopsInGrams(text);
        }
        else if( checkCurrentTag("hopstime")){
            hop.setTimeToAddHop(text);
        }
    }

    private void addBeerObjectToList(){
        if (checkCurrentTag("recipe"))
            listOfBeers.add(beer);
    }

    private void addIngredientIntoRecipe() {
        if (checkCurrentTag("maltIngredient"))
            beer.addMaltIngredient(malt);
        else if (checkCurrentTag("hopingredient"))
            beer.addHopingredient(hop);
        else if (checkCurrentTag("yeast"))
            beer.setYeastIngredient(text);
    }

    private void checkStartTagForNewObjectToCreate(){
        if (checkCurrentTag("recipe")) {
            beer = new Beer();
            setParentTag();
        }  else if(checkCurrentTag("maltIngredient")){
            malt = new Malt();
            setParentTag();
        } else if(checkCurrentTag("hopingredient")){
            hop = new Hop();
            setParentTag();
        }
    }

    private void setParentTag(){
        parentTag = currentTag;
    }

    public boolean isActiveObject(String currentParentTag){
        return currentParentTag.equalsIgnoreCase(parentTag);
    }
}
