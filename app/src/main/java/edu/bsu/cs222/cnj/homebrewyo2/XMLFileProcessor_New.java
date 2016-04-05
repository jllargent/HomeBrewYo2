package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.ArrayList;

public class XMLFileProcessor_New {
    private ArrayList<Beer_New> listOfBeers = new ArrayList<>();
    private Beer_New newBeer;
    private Ingredients newIngredients;
    private Hop newHop;
    private Malt newMalt;
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
                        addInfoIntoIngredientsObject();

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

    private void addInfoIntoIngredientsObject() {

    }

    public ArrayList<Beer_New> getListOfBeers(){
        return listOfBeers;
    }

    public void addInfoIntoBeerObject(){
        if (checkCurrentTag("name")) {
            newBeer.setTitleOfBeer(text);
        } else if (checkCurrentTag("style")) {
            newBeer.setStyleOfBeer(text);
        } else if (checkCurrentTag("description")) {
            newBeer.setDescriptionOfBeer(text);
        }else if (checkCurrentTag("temp")) {
            newBeer.setBoilDescription(text);
        }else if (checkCurrentTag("time")) {
            newBeer.setTimeInMins(text);
        }else if (checkCurrentTag("fermtemp")) {
            newBeer.setFermentTemperature(text);
        }else if (checkCurrentTag("abv")) {
            newBeer.setValueOfABV(text);
        }else if (checkCurrentTag("targetfg")) {
            newBeer.setFinalGravity(text);
        }else if (checkCurrentTag("targetog")) {
            newBeer.setOriginalGravity(text);
        }

    }

    public void addBeerObjectToList(){
        if (checkCurrentTag("recipe"))
            listOfBeers.add(newBeer);
    }

    public boolean checkCurrentTag(String tagToCheck){
        return currentTag.equalsIgnoreCase(tagToCheck);
    }

    public void checkStartTagForNewObjectToCreate(){
        if (checkCurrentTag("recipe")) {
            newBeer = new Beer_New();
        } else if(checkCurrentTag("ingredients")){
            newIngredients = new Ingredients();
        } else if(checkCurrentTag("maltIngredient")){
            newMalt = new Malt();
        } else if(checkCurrentTag("hopingredient")){
            newHop = new Hop();
        }
    }

}
