package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class NewXmlParserTest {


    NewXmlParser parser;
    List<Beer> recipeList;


    @Before
    public void setUpParser() throws IOException, ParserConfigurationException, SAXException {
        File xmlFile = new File("src/main/res/raw/testbeerrecipes.xml");
        URL input = xmlFile.toURI().toURL();
        parser = new NewXmlParser(input.openStream());
        recipeList = parser.getBeerList();
    }

    @Test
    public void testHasXmlFile(){
        assertNotEquals(null, parser.xmlData);
    }

    @Test
    public void testBuilderExist(){
        assertNotEquals(null, parser.document);
    }

    @Test
    public void testThatThereAre2Recipies(){
        assertEquals(2, parser.recipeNodeList.getLength());
    }

    @Test
    public void testThatBadPixieIsInList(){
        assertEquals("Bad Pixie", recipeList.get(0).getName());
    }

    @Test
    public void testThatBrixtonPorterIsInList(){
        assertEquals("Brixton Porter", recipeList.get(1).getName());
    }

    @Test
    public void testThatThereIsABeerArrayList(){
        assertNotEquals(null, parser.beerList);
    }
}
