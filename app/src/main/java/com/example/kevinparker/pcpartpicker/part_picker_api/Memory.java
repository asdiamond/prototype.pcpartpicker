package com.example.kevinparker.pcpartpicker.part_picker_api;

import java.io.Serializable;

/**
 * Created by Aleksandr on 5/15/2017.
 */
public class Memory implements Serializable, ComputerPart{
    private String name;
    private String speed;
    private String type;
    private int cas;
    private String modules;
    private int size;
    private double pricePerGB;
    private double price;

    public Memory(String[] memData){
        name = memData[1];
        speed = memData[2];
        type = memData[3];
        cas = Integer.parseInt(memData[4]);
        modules = memData[5];
        size = Integer.parseInt(memData[6].replace("GB", ""));
        try {
            pricePerGB = Double.parseDouble(memData[7].replace("$", ""));
            price = Double.parseDouble(memData[8].replace("$", ""));
        }catch (NumberFormatException e){
            //there can be no price, and therefore sometimes no price per gb
            pricePerGB = 0.0;
            price = 0.0;
        }
    }

    @Override
    public String toString() {
        return name + "\n" + speed + "\n" + type + "\n" + cas + "\n" + modules + "\n" + size + "\n" + pricePerGB + "\n" + price;
    }

    public String getSpeed() {
        return speed;
    }

    public String getType() {
        return type;
    }

    public int getCas() {
        return cas;
    }

    public String getModules() {
        return modules;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public double getPricePerGB() {
        return pricePerGB;
    }

    public double getPrice() {
        return price;
    }
}
