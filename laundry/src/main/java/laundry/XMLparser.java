package laundry;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLparser extends Main {
    public List<Clothes> parser() throws ParserConfigurationException, IOException, SAXException {

        List<Clothes> clothes = new ArrayList<Clothes>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("src/data/clothes.xml");

        NodeList items = doc.getElementsByTagName("item");


        for (int temp = 0; temp < items.getLength(); temp++) {

            Node nNode = items.item(temp);
            Element eElement = (Element) nNode;
            NodeList nNodeChilds = eElement.getElementsByTagName("*");


                String name = nNodeChilds.item(0).getTextContent();

                String color = nNodeChilds.item(1).getTextContent();

                String material = nNodeChilds.item(2).getTextContent();

                String sclean = nNodeChilds.item(3).getTextContent();
                Boolean clean = Boolean.valueOf(sclean);

                String sdry = nNodeChilds.item(4).getTextContent();
                Boolean dry = Boolean.valueOf(sdry);

                String ssrink = nNodeChilds.item(5).getTextContent();
                Boolean srink = Boolean.valueOf(ssrink);

                Clothes cloth = new Clothes(name, color, material, clean, dry, srink);
                clothes.add(cloth);


            }
        return clothes;
    }

    public void writetoXML(){

    }

}
