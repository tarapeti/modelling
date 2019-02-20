package laundry;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class Clothes {
    // itt lesz a ruha állapota egyes methodok után

    private String name;
    private String color;
    private String material; //tul nagy hőfokon összemegy
    private boolean clean; // ne lehessen tiszta ruhát visszatenni a szenyyesbe
    private boolean dry;
    private boolean srink;



    public Clothes(String name, String color, String material, boolean clean, boolean dry, boolean srink) {
        this.name = name;
        this.color = color;
        this.material = material;
        this.clean = clean;
        this.dry = dry;
        this.srink = srink;

    }
    public Clothes(){

    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public boolean isClean() {
        return clean;
    }

    public boolean isDry() { return dry; }

    public boolean isSrink() { return srink; }

    @Override
    public String toString() {
        return "The name: '" + name + '\'' +
                ", The color: '" + color + '\'' +
                ", The material: '" + material + '\'' +
                ", If it's clean: " + clean;
    }

    public ArrayList createClothes(int amount) {
        ArrayList<Clothes> allClothes = new ArrayList<Clothes>(amount);
        while (amount > 0) {
            System.out.println("Enter the cloth's name");
            Scanner itsname = new Scanner(System.in);
            String thisname = itsname.nextLine();
            this.name = thisname;

            System.out.println("Enter it's color");
            Scanner itscolor = new Scanner(System.in);
            String thiscolor = itscolor.nextLine();
            this.color = thiscolor;

            System.out.println("Enter the material");
            Scanner itsmaterial = new Scanner(System.in);
            String thismaterial = itsmaterial.nextLine();
            this.material = thismaterial;

            System.out.println("Is it clean?");
            Scanner itsclean = new Scanner(System.in);
            Boolean thisclean = itsclean.nextBoolean();
            this.clean = thisclean;

            Boolean itsdry = true;
            Boolean itssrink = false;

            Clothes cloth = new Clothes(name, color, material, clean, itsdry, itssrink);
            allClothes.add(cloth);
            amount--;


        }
        System.out.println(allClothes);
        return allClothes;


    }
}
