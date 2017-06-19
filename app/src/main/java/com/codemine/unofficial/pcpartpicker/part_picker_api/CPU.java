package com.codemine.unofficial.pcpartpicker.part_picker_api;

import java.io.Serializable;

public class CPU implements ComputerPart, Serializable{
    private String name;
    private double clockSpeed;
    private int cores;
    private int tdp;
    private double price;

    public CPU(String[] cpuData){
        name = cpuData[1];
        clockSpeed = Double.parseDouble(cpuData[2].replace("GHz", ""));
        cores = Integer.parseInt(cpuData[3]);
        tdp = Integer.parseInt(cpuData[4].replace("W", ""));
        try {
            price = Double.parseDouble(cpuData[5].replace("$", ""));
        }catch (NumberFormatException e){
            price = 0.0;
        }
    }

    @Override
    public String toString() {
        return "name= " + this.name + "\nprice= " + this.getPrice() + "$\ncores= " + this.cores + "\ntdp= " + this.tdp
                + "W\nclockSpeed= " + this.clockSpeed + "GHz";
    }

    public double getPrice() {
        return price;
    }

    public int getCores(){
        return this.cores;
    }

    public double getClockSpeed(){
        return this.clockSpeed;
    }

    public double getTdp(){
        return this.tdp;
    }

    public String getName() {
        return name;
    }
}