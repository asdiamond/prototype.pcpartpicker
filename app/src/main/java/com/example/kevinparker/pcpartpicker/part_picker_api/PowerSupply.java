package com.example.kevinparker.pcpartpicker.part_picker_api;

import java.io.Serializable;

/**
 * Created by Aleksandr on 5/15/2017.
 */
public class PowerSupply implements Serializable, ComputerPart{
    private String name;
    private String series;
    private String form;
    private String efficiency;
    private int watts;
    private String modular;
    private double price;

    public PowerSupply(String[] powData){
        name = powData[1];
        series = powData[2];
        form = powData[3];
        efficiency = powData[4];
        watts = Integer.parseInt(powData[5].replace("W", ""));
        modular = powData[6];
        try{
            price = Double.parseDouble(powData[7].replace("$", ""));
        }catch (NumberFormatException e){
            //no price
            price = 0;
        }
    }

    @Override
    public String toString() {
        return name + "\n" + series + "\n" + form + "\n" + efficiency + "\n" + watts + "\n" + modular + "\n" + price;
    }

    public String getSeries() {
        return series;
    }

    public String getForm() {
        return form;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public int getWatts() {
        return watts;
    }

    public String getModular() {
        return modular;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
