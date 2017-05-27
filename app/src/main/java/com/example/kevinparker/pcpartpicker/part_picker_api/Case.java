package com.example.kevinparker.pcpartpicker.part_picker_api;

import java.io.Serializable;

/**
 * Created by Aleksandr on 5/15/2017.
 */
public class Case implements Serializable, ComputerPart{
    private String name;
    private String type;
    private int fiveInchSlots;
    private int threeInchSlots;
    private int powerSupply;
    private double price;

    public Case(String[] caseData){
        name = caseData[1];
        type = caseData[2];
        fiveInchSlots = Integer.parseInt(caseData[3]);
        threeInchSlots = Integer.parseInt(caseData[4]);
        if(caseData[5].contains("W")) powerSupply = Integer.parseInt(caseData[5].replace("W", ""));
        try{
            price = Double.parseDouble(caseData[6].replace("$", ""));
        }catch (NumberFormatException e){
            //no price
            price = 0;
        }
    }

    @Override
    public String toString() {
        return name + "\n" + type + "\n" + fiveInchSlots + "\n" + threeInchSlots + "\n" + powerSupply + "\n" + price;
    }

    public String getType() {
        return type;
    }

    public int getFiveInchSlots() {
        return fiveInchSlots;
    }

    public int getThreeInchSlots() {
        return threeInchSlots;
    }

    public int isPowerSupply() {
        return powerSupply;
    }

    public String getName() {
        return name;
    }

    public int getPowerSupply() {
        return powerSupply;
    }

    public double getPrice() {
        return price;
    }
}
