package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.ArrayList;

public class XMLFileProcessor_New {
    private ArrayList<Beer_New> listOfBeers = new ArrayList<>();
    private Beer_New beer;
    private ArrayList<Ingredients> listOfIngredients;
    private Hop hop;
    private Malt malt;
    private String text = null;
    private String currentTag;

    public XMLFileProcessor_New(Context context){
        try{
            XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser myParser = xmlFactoryObject.newPullParser();
            myParser.setInput(context.getResources().openRawResource(R.raw.beerrecipes), null);
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
                        addInfoIntoBeerObject();

                        addIngredientIntoIngredientsObject();
                        addBeerObjectToList();
                        break;

                }
                event = myParser.next();
            }while(event != XmlPullParser.END_DOCUMENT );
            /*Log.i("Beer Count", String.valueOf(listOfBeers.size()));
            Log.i("Did it", listOfBeers.get(0).getTitleOfBeer() + " Was added");

            Log.i("Did it", listOfBeers.get(1).getTitleOfBeer() + " Was added");*/
        }catch(Exception e){
            Log.wtf("OOPS", e);
        }
    }

    public void addIngredientIntoIngredientsObject() {
        if (checkCurrentTag("maltIngredient"))
            listOfBeers.add(beer);
    }

    public ArrayList<Beer_New> getListOfBeers(){
        return listOfBeers;
    }

    public void addInfoIntoBeerObject(){
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

    public void addBeerObjectToList(){
        if (checkCurrentTag("recipe"))
            listOfBeers.add(beer);
    }

    public boolean checkCurrentTag(String tagToCheck){
        return currentTag.equalsIgnoreCase(tagToCheck);
    }

    public void checkStartTagForNewObjectToCreate(){
        if (checkCurrentTag("recipe")) {
            beer = new Beer_New();
        } else if(checkCurrentTag("ingredients")){
            listOfIngredients = new ArrayList<Ingredients>();
        } else if(checkCurrentTag("maltIngredient")){
            malt = new Malt();
        } else if(checkCurrentTag("hopingredient")){
            hop = new Hop();
        }
    }

}
