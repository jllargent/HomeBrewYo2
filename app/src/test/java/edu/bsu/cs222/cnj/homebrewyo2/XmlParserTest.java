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

public class XmlParserTest{

    XmlParser parser;
    List<BeerRecipe> recipeList;

    @Before
    public void setUpParser() throws IOException, ParserConfigurationException, SAXException {
        File xmlFile = new File("src/main/res/raw/testbeerrecipes.xml");
        URL input = xmlFile.toURI().toURL();
        parser = new XmlParser(input.openStream());
        recipeList = parser.getBeerRecipeList();
    }

    @Test
    public void testHasXmlFile(){
        assertNotEquals(null, parser.xmlData);
    }

    @Test
    public void testThatThereAre2Recipies(){
        assertEquals(2, recipeList.size());
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
    public void testBadPixieDescription(){
        assertEquals("4.7% wheat ale with crushed juniper berries and citrus peel.", recipeList.get(0).getDescription());
    }

    @Test
    public void testBrixtonPorterDescription(){
        assertEquals("Brixton Porter delivers bold chocolate and coffee flavours with light smokiness and hints of autumn fruit all but built on a low ABV, lighter bodied backbone. Complex and intriguing, with spicy bitterness, but very sessionable.", recipeList.get(1).getDescription());
    }

    @Test
    public void testBadPixieBuildTime(){
        assertEquals(75, recipeList.get(0).getTimeInMinutes());
    }

    @Test
    public void testBrixtonPorterBuildTime(){
        assertEquals(75, recipeList.get(1).getTimeInMinutes());
    }

    @Test
    public void testBadPixieTemperature(){
        assertEquals(153, recipeList.get(0).getTemperatureInFahrenheit());
    }

    @Test
    public void testBrixtonPorterTemperature(){
        assertEquals(149,recipeList.get(1).getTemperatureInFahrenheit());
    }

    @Test
    public void testBadPixieStyle(){
        assertEquals("Wheat", recipeList.get(0).getStyle());
    }

    @Test
    public void testBadPixieFermentTemp(){
        assertEquals(66, recipeList.get(0).getFermentTemperature());
    }

    @Test
    public void testBadPixieABVPercent(){
        assertEquals(4.7, recipeList.get(0).getABVPercent(), 0);
    }

    @Test
    public void testBadPixieIBU(){
        assertEquals(45, recipeList.get(0).getIbuValue());
    }

    @Test
    public void testBadPixieTargetFinalGravity(){
        assertEquals(1010, recipeList.get(0).getTargetFinalGravity(),0);
    }

    @Test
    public void testBadPixieTargetOriginalGravity(){
        assertEquals(1047, recipeList.get(0).getTargetOriginalGravity(), 0);
    }

    @Test
    public void testThatThereIsABeerArrayList(){
        assertNotEquals(null, parser.beerRecipeList);
    }

    @Test
    public void testThatBeerHasMalt(){
        assertNotEquals(null, recipeList.get(0).getMalts());
    }

    @Test
    public void testYeastHasName(){
        assertEquals("Wyeast 1056 - American Ale", recipeList.get(0).getYeast().getName());
    }

    @Test
    public void testMaltHasName(){
        for(int i = 0; i < recipeList.get(1).getMalts().size(); i++){
            System.out.println(recipeList.get(1).getMalts().get(i).getName());
        }
        assertEquals("Wheat", recipeList.get(0).getMalts().get(0).getName());
    }
    @Test
    public void testMaltHasAmount(){
        assertEquals(8.40, recipeList.get(1).getMalts().get(0).getAmount(), 0);
    }

    @Test
    public void testHopsExist(){
        assertNotEquals(null, recipeList.get(0).getHops());
    }
    @Test
    public void testHopHasName(){
        assertEquals("Challenger", recipeList.get(1).getHops().get(2).getName());
    }
    @Test
    public void testHopHasAmount(){
        assertEquals(12.5, recipeList.get(1).getHops().get(0).getAmount(), 0);
    }
    @Test
    public void testHopHasTimeToAdd(){
        assertEquals("End", recipeList.get(0).getHops().get(1).getTimingToAdd());
    }

}
