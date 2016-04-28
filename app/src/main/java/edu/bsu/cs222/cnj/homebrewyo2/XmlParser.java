package edu.bsu.cs222.cnj.homebrewyo2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlParser {

    private final String RECIPE_TAG = "recipe";

    public InputStream xmlData;
    public Document document;
    private NodeList recipeNodeList;

    private int i = 0;

    private BeerRecipe.BeerBuilder beerBuilder = new BeerRecipe.BeerBuilder();
    private BeerRecipe currentBeerRecipe;

    private Ingredient.IngredientBuilder ingredientBuilder = new Ingredient.IngredientBuilder();

    public List<BeerRecipe> beerRecipeList = new ArrayList();
    private Element currentElement;

    public XmlParser(InputStream input) throws IOException, SAXException, ParserConfigurationException {
        this.xmlData = input;
        createXMLParser();
        for(int temp = 0; temp < recipeNodeList.getLength(); temp++){
            i =0;
            Node currentNode = recipeNodeList.item(temp);
            if(isFirstNode(currentNode)){
                continue;
            }
            currentElement = (Element) currentNode;

            beerBuilder.createBeer();
            beerBuilder.buildName(getElementStringValueByTag("name"));
            beerBuilder.buildDescription(getElementStringValueByTag("description"));
            beerBuilder.buildTime(getElementIntValueByTag("time"));
            beerBuilder.buildTemp(getElementIntValueByTag("temp"));
            beerBuilder.buildStyle(getElementStringValueByTag("style"));
            beerBuilder.buildFermentTemp(getElementIntValueByTag("fermtemp"));
            beerBuilder.buildABVPercent(getElementDoubleValueByTag("abvpercent"));
            beerBuilder.buildIBUValue(getElementIntValueByTag("ibu"));
            beerBuilder.buildTargetOriginalGravity(getElementDoubleValueByTag("targetog"));
            beerBuilder.buildTargetFinalGravity(getElementDoubleValueByTag("targetfg"));

            ingredientBuilder.createYeastIngredient();
            ingredientBuilder.buildName(getElementStringValueByTag("yeast"));
            Ingredient currentIngredient = ingredientBuilder.getIngredient();
            beerBuilder.buildYeast(currentIngredient);
            i = 0;
            do{
                ingredientBuilder.createMaltIngredient();
                ingredientBuilder.buildName(getElementStringValueByTag("maltName"));
                ingredientBuilder.buildAmount(getElementDoubleValueByTag("maltweight"));
                currentIngredient = ingredientBuilder.getIngredient();
                beerBuilder.addMalt(currentIngredient);
                i++;
            }while(i < currentElement.getElementsByTagName("maltIngredient").getLength());
            i=0;
            do{
                ingredientBuilder.createHopIngredient();
                ingredientBuilder.buildName(getElementStringValueByTag("hopsname"));
                ingredientBuilder.buildAmount(getElementDoubleValueByTag("hopsamount"));
                ingredientBuilder.buildTimeToAdd(getElementStringValueByTag("hopstime"));
                currentIngredient = ingredientBuilder.getIngredient();
                beerBuilder.addHop(currentIngredient);
                i++;
            }while(i < currentElement.getElementsByTagName("hopingredient").getLength());


            currentBeerRecipe = beerBuilder.getBeer();
            beerRecipeList.add(currentBeerRecipe);
        }
    }

    public List<BeerRecipe> getBeerRecipeList(){
        return new ArrayList<>(beerRecipeList);
    }

    private String getElementStringValueByTag(String tag){
         return currentElement.getElementsByTagName(tag).item(i).getTextContent();
    }
    private int getElementIntValueByTag(String tag){
        return Integer.parseInt(currentElement.getElementsByTagName(tag).item(i).getTextContent());
    }
    private double getElementDoubleValueByTag(String tag){
        return Double.parseDouble(currentElement.getElementsByTagName(tag).item(i).getTextContent());
    }

    private void createXMLParser()throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(xmlData);
        document.getDocumentElement().normalize();
        recipeNodeList = document.getElementsByTagName(RECIPE_TAG);
    }

    private boolean isFirstNode(Node currentNode){
        return currentNode.getNodeType() != Node.ELEMENT_NODE;
    }


}
