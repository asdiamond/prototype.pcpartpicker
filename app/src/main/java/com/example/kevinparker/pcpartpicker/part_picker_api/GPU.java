package com.example.kevinparker.pcpartpicker.part_picker_api;

import java.io.Serializable;

/**
 * Created by Aleksandr on 5/15/2017.
 * GPU clock is in MHz
 * series of GPU can be blank but not null.
 */
public class GPU implements Serializable, ComputerPart{
    private String name;
    private String series;
    private String chipSet;
    private int memory;
    private double clock;
    private double price;

    public GPU(String[] gpuData){
        name = gpuData[1];
        series = gpuData[2];
        chipSet = gpuData[3];
        memory = Integer.parseInt(gpuData[4].replace("GB", ""));
        if(gpuData[5].contains("GHz")) clock = Double.parseDouble(gpuData[5].replace("GHz", ""));
        else if (gpuData[5].contains("MHz")) clock = Double.parseDouble(gpuData[5].replace("MHz", "")) / 1000.0;

        try{
            price = Double.parseDouble(gpuData[6].replace("$", ""));
        } catch (NumberFormatException e){
            //no price
            price = 0.0;
        }
    }

    @Override
    public String toString() {
        return series + "\n" + chipSet + "\n" + memory + "\n" + clock;
    }

    public String getSeries() {
        return series;
    }

    public String getChipSet() {
        return chipSet;
    }

    public int getMemory() {
        return memory;
    }

    public double getClock() {
        return clock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
