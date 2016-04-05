package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.ArrayList;

public class XMLFileProcessor_New {
    private ArrayList<Beer_New> listOfBeers = new ArrayList<>();
    private Beer_New newBeer;
    private String text = null;
    private String currentEndTag;
    public XMLFileProcessor_New(Context context){
        try{
            XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser myParser = xmlFactoryObject.newPullParser();
            myParser.setInput(context.getResources().openRawResource(R.raw.beerrecipes), null);
            int event = myParser.getEventType();
            do{
                String name = myParser.getName();
                switch (event) {
                    case XmlPullParser.START_TAG:
                        if(name.equals("recipe")){
                            newBeer = new Beer_New();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        addInfoIntoBeerObject(name);
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

    public ArrayList<Beer_New> getListOfBeers(){
        return listOfBeers;
    }

    public static String getResourceString(String name, Context context) {
        int nameResourceID = context.getResources().getIdentifier(name, "xml", context.getApplicationInfo().packageName);
        if (nameResourceID == 0) {
            throw new IllegalArgumentException("No resource string found with name " + name);
        } else {
            return context.getString(nameResourceID);
        }
    }

    public void addInfoIntoBeerObject(String currentTag){
        currentEndTag = currentTag;
        if (checkCurrentEndTag("recipe")) {
            listOfBeers.add(newBeer);
        } else if (checkCurrentEndTag("name")) {
            newBeer.setTitleOfBeer(text);
        } else if (checkCurrentEndTag("style")) {
            newBeer.setStyleOfBeer(text);
        } else if (checkCurrentEndTag("description")) {
            newBeer.setDescriptionOfBeer(text);
        }else if (checkCurrentEndTag("temp")) {
            newBeer.setBoilDescription(text);
        }else if (checkCurrentEndTag("time")) {
            newBeer.setTimeInMins(text);
        }else if (checkCurrentEndTag("fermtemp")) {
            newBeer.setFermentTemperature(text);
        }else if (checkCurrentEndTag("abv")) {
            newBeer.setValueOfABV(text);
        }else if (checkCurrentEndTag("targetfg")) {
            newBeer.setFinalGravity(text);
        }else if (checkCurrentEndTag("targetog")) {
            newBeer.setOriginalGravity(text);
        }
    }

    public boolean checkCurrentEndTag(String tagToCheck){
        return currentEndTag.equalsIgnoreCase(tagToCheck);
    }
}
