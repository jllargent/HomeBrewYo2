package edu.bsu.cs222.cnj.homebrewyo2;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;

public class XMLFileProcessor {
    private ArrayList<Beer> listOfBeers = new ArrayList<>();
    private Beer beer;
    private Hop hop;
    private Malt malt;
    private String text = null;
    private String currentTag;
    private String parentTag = null;

    public XMLFileProcessor(){
        try{
            XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser myParser = xmlFactoryObject.newPullParser();
            ClassLoader classLoader = this.getClass().getClassLoader();
            InputStream resource = classLoader.getResourceAsStream("res/raw/beerrecipes.xml");
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

    private boolean isCurrentTag(String tagToCheck){
        return currentTag.equalsIgnoreCase(tagToCheck);
    }

    private void addInfoIntoBeerObject(){
        if (isCurrentTag("name")) {
            beer.setTitleOfBeer(text);
        } else if (isCurrentTag("style")) {
            beer.setStyleOfBeer(text);
        } else if (isCurrentTag("description")) {
            beer.setDescriptionOfBeer(text);
        }else if (isCurrentTag("temp")) {
            beer.setBoilDescription(text);
        }else if (isCurrentTag("time")) {
            beer.setTimeInMins(text);
        }else if (isCurrentTag("fermtemp")) {
            beer.setFermentTemperature(text);
        }else if (isCurrentTag("abv")) {
            beer.setValueOfABV(text);
        }else if (isCurrentTag("targetfg")) {
            beer.setFinalGravity(text);
        }else if (isCurrentTag("targetog")) {
            beer.setOriginalGravity(text);
        }
    }

    private void addInfoIntoMaltObject(){
        if (isCurrentTag("maltName"))
            malt.setNameOfMalt(text);
       else if (isCurrentTag("maltweight")) {
           malt.setWeightOfMaltsInPounds(text);
        }
    }

    private void addInfoIntoHopObject(){
        if(isCurrentTag("hopsName")){
            hop.setNameOfHop(text);
        }
        else if( isCurrentTag("hopsamount")){
            hop.setAmountOfHopsInGrams(text);
        }
        else if( isCurrentTag("hopstime")){
            hop.setTimeToAddHop(text);
        }
    }

    private void addBeerObjectToList(){
        if (isCurrentTag("recipe"))
            listOfBeers.add(beer);
    }

    private void addIngredientIntoRecipe() {
        if (isCurrentTag("maltIngredient"))
            beer.addMaltIngredient(malt);
        else if (isCurrentTag("hopingredient"))
            beer.addHopingredient(hop);
        else if (isCurrentTag("yeast"))
            beer.setYeastIngredient(text);
    }

    private void checkStartTagForNewObjectToCreate(){
        if (isCurrentTag("recipe")) {
            beer = new Beer();
            setParentTag();
        }  else if(isCurrentTag("maltIngredient")){
            malt = new Malt();
            setParentTag();
        } else if(isCurrentTag("hopingredient")){
            hop = new Hop();
            setParentTag();
        }
    }

    private void setParentTag(){
        parentTag = currentTag;
    }

    private boolean isActiveObject(String currentParentTag){
        return currentParentTag.equalsIgnoreCase(parentTag);
    }
}
