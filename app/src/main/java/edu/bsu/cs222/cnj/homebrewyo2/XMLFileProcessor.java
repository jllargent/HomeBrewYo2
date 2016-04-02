package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;
import android.util.Log;
import org.w3c.dom.*;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import javax.xml.parsers.*;
import java.io.*;

public class XMLFileProcessor{

    public XMLFileProcessor(Context context){
        String text = null;
        try{
            XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser myParser = xmlFactoryObject.newPullParser();
            myParser.setInput(context.getResources().openRawResource(R.raw.beerrecipes), null);
            int event = myParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT)
            {
                String name=myParser.getName();
                switch (event){
                    case XmlPullParser.START_TAG:
                        break;

                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if(name.equals("recipe")){
                            Log.i("We got a hit", "Found a recipe here");
                        }
                        if(name.equalsIgnoreCase("description")){
                            Log.i("Description", "Here's a description");
                            Log.i("Description", text);
                        }
                        break;
                }
                event = myParser.next();
            }
        }catch(Exception e){
            Log.wtf("OOPS", e);
        }
    }

    public static String getResourceString(String name, Context context) {
        int nameResourceID = context.getResources().getIdentifier(name, "xml", context.getApplicationInfo().packageName);
        if (nameResourceID == 0) {
            throw new IllegalArgumentException("No resource string found with name " + name);
        } else {
            return context.getString(nameResourceID);
        }
    }
}
