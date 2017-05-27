package com.example.kevinparker.pcpartpicker.part_picker_api;

import java.io.Serializable;

/**
 * Created by Aleksandr on 5/15/2017.
 */
public class Motherboard implements Serializable, ComputerPart{
    private String name;
    private String socket;
    private String formFactor;
    private int ramSlots;
    private String maxRam;
    private double price;

    public Motherboard(String[] moboData){
        if(moboData.length < 6) return;
        name = moboData[1];
        socket = moboData[2];
        formFactor = moboData[3];
        ramSlots = Integer.parseInt(moboData[4]);
        maxRam = moboData[5];
        try {
            price = Double.parseDouble(moboData[6].replace("$", ""));
        }catch (NumberFormatException e){
            //no price
            price = 0.0;
        }
    }

    @Override
    public String toString() {
        return name + "\n" + socket + "\n" + formFactor + "\n" + ramSlots + "\n" + maxRam + "\n" + price;
    }

    public String getSocket() {
        return socket;
    }

    public int getRamSlots() {
        return ramSlots;
    }

    public String getMaxRam() {
        return maxRam;
    }

    public String getName() {
        return name;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public double getPrice() {
        return price;
    }

}
