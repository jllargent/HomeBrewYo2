package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class NewXmlParserTest {


    NewXmlParser parser;

    @Before
    public void setUpParser() throws IOException {
        File xmlFile = new File("src/main/res/raw/beerrecipes.xml");
        URL input = xmlFile.toURI().toURL();
        parser = new NewXmlParser(input.openStream());
    }

    @Test
    public void parserHasXmlFile(){
        assertNotEquals(null, parser.xmlData);
    }
}
