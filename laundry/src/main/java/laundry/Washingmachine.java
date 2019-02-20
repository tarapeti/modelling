package laundry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Washingmachine {

    private int temperature;
    List<Clothes> inMachine = new ArrayList<Clothes>();

    //FILLING


    public List<Clothes> putinOnebyOne(List<Clothes> basketItems){
        for (Clothes cloth : basketItems){
            System.out.println("Would you like to put " + cloth.getName() + " in the machine?");
            Scanner q = new Scanner(System.in);
            String a = q.nextLine();
            if (a.equals("yes")){
                inMachine.add(cloth);
            } else {
                continue;
            }
        }
        return inMachine;
    }


    public List<Clothes> putinDefault(List<Clothes> basketItems){
        for (Clothes cloth : basketItems){
            inMachine.add(cloth);
        }
        return inMachine;
    }

    public List<Clothes> putinbyName(List<Clothes> basketItems, String name){
        for (Clothes cloth : basketItems){
            if (cloth.getName().equals(name)){
                inMachine.add(cloth);
            }
        }
        return inMachine;
    }

    public List<Clothes> putinbyColor(List<Clothes> basketItems, String color){
        for (Clothes cloth : basketItems){
            if (cloth.getColor().equals(color)){
                inMachine.add(cloth);
            }
        }
        return inMachine;
    }

    public List<Clothes> putinbyMaterial(List<Clothes> basketItems, String material){
        for (Clothes cloth : basketItems){
            if (cloth.getMaterial().equals(material)){
                inMachine.add(cloth);
            }
        }
        return inMachine;
    }

    //PROGRAMS

    public List<Clothes> washProgramDefault(List<Clothes> inMachine, Scents scents) {
        List<Clothes> afterWashingD = new ArrayList<Clothes>();

        for (Clothes cloth : inMachine) {
            Clothes clothd = new Clothes(cloth.getName(), cloth.getColor(), cloth.getMaterial(), true, false, cloth.isSrink());
            afterWashingD.add(clothd);
        }
        return afterWashingD;
    }

    public List<Clothes> washProgramForColors(List<Clothes> inMachine, Scents scents) {
        List<Clothes> afterWashingC = new ArrayList<Clothes>();

        List<String> allColors = new ArrayList<String>();
        for (Clothes cloth : inMachine) {
            allColors.add(cloth.getColor());
        }

        for (Clothes cloth : inMachine) {
            if (allColors.contains("red") && allColors.contains("white")) {
                if (cloth.getColor().equals("white")) {
                    Clothes ccloth = new Clothes(cloth.getName(), "pink", cloth.getMaterial(), true, false, false); //nem lehet boolt változtatni
                    afterWashingC.add(ccloth);
                }
            }
            Clothes ccloth = new Clothes(cloth.getName(), cloth.getColor(), cloth.getMaterial(), true, false, false);
            afterWashingC.add(ccloth);
        }
        return afterWashingC;
    }

    public List<Clothes> washProgramForMaterials(List<Clothes> inMachine, Scents scents, int temperature){
        List<Clothes> afterWashingM = new ArrayList<Clothes>();

        System.out.println("30/60/90 temp?");
        Scanner itstemp = new Scanner(System.in);
        String thistemp = itstemp.nextLine();
        int ftemp = Integer.parseInt(thistemp);

        for (Clothes cloth : inMachine){
            if (cloth.getMaterial().equals("akril") && ftemp > 30){
                Clothes mcloth = new Clothes(cloth.getName(), cloth.getColor(), cloth.getMaterial(), true, false, true);
                afterWashingM.add(mcloth);
            } else {
                Clothes mcloth = new Clothes(cloth.getName(), cloth.getColor(), cloth.getMaterial(), true, false, cloth.isSrink());
                afterWashingM.add(mcloth);
            }

            if (cloth.getMaterial().equals("cotton") && ftemp > 60){
                Clothes mcloth = new Clothes(cloth.getName(), cloth.getColor(), cloth.getMaterial(), true, false, true);
                afterWashingM.add(mcloth);
            } else {
                Clothes mcloth = new Clothes(cloth.getName(), cloth.getColor(), cloth.getMaterial(), true, false, cloth.isSrink());
                afterWashingM.add(mcloth);
            }

            if (cloth.getMaterial().equals("frottier") && ftemp > 60){
                Clothes mcloth = new Clothes(cloth.getName(), cloth.getColor(), cloth.getMaterial(), true, false, true);
                afterWashingM.add(mcloth);
            } else {
                Clothes mcloth = new Clothes(cloth.getName(), cloth.getColor(), cloth.getMaterial(), true, false, cloth.isSrink());
                afterWashingM.add(mcloth);
            }
        }
        return afterWashingM;
    }
}
