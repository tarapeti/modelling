package laundry;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        System.out.println("simple washing machine");

        XMLparser parse = new XMLparser();
        List<Clothes> createList = null;
        try {
            createList = parse.parser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("commands: 1 - LIST, 2 - CREATE, 3 - REMOVE, 4 - betaRUN, 5 - QUIT");
            Scanner menuoptscanner = new Scanner(System.in);
            int options = menuoptscanner.nextInt();
            if (options == 5){
                break;
            }

            handleMenu(options, createList);
        }

    }

    private static void handleMenu(int options, List<Clothes> createList ) {


        switch (options){
            case 1:
                System.out.println("Currently in the xml");
                for (Clothes cloth : createList) {
                    System.out.println(cloth.toString());
                }
                break;
            case 2:
                Clothes testcreate = new Clothes();
                List<Clothes> allclothcreate = testcreate.createClothes(2);
                for (Clothes cloth : allclothcreate){
                    createList.add(cloth);
                }
                break;
            case 3:
                System.out.println("to be implemented");
                break;
            case 4:
                Basket testb = new Basket();
                int maxBasketSize = createList.size() + 1; // just for now
                List<Clothes> inbasket = testb.putinBasket(createList, maxBasketSize);
                System.out.println("Clothes in the basket:\n" + inbasket.toString());


                Washingmachine testim = new Washingmachine();
                List<Clothes> inmach = testim.putinOnebyOne(inbasket);
                System.out.println("Clothes in the machine:\n" + inmach.toString());


                Washingmachine testp = new Washingmachine();
                System.out.println("Choose a scent: CLASSIC," + "FLORAL," + "CITRUS," + "FRUITY");
                Scanner scentscanner = new Scanner(System.in);
                String scentscan = scentscanner.nextLine();
                Scents scents = Scents.valueOf(scentscan.toUpperCase());
                List<Clothes> washmach = testp.washProgramDefault(inmach, scents);
                System.out.println("Clothes after washing: \n"+ washmach.toString());

                Dryer testd = new Dryer();
                List<Clothes> dryr = testd.dryClothes(washmach);
                System.out.println("Clothes after drying:\n" + dryr.toString());
                break;
            case 5 :
                System.out.println("u r messy smh");
                break;
        }
    }
}
