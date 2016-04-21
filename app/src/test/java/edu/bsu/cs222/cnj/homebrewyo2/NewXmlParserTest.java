package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class NewXmlParserTest {


    NewXmlParser parser;

    @Before
    public void setUpParser() throws IOException, ParserConfigurationException, SAXException {
        File xmlFile = new File("src/main/res/raw/beerrecipes.xml");
        URL input = xmlFile.toURI().toURL();
        parser = new NewXmlParser(input.openStream());
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
    public void testThatThereAre10Recipies(){
        assertEquals(10, parser.recipeNodeList.getLength());
    }

    @Test
    public void testThatPunkIPAisinList(){
        assertEquals("Punk IPA", parser.recipeChildNodeList.item(1).getTextContent());
    }
}
