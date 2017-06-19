package com.codemine.unofficial.pcpartpicker.part_picker_api;

import java.io.Serializable;

public class CPUCooler implements Serializable, ComputerPart{
    private String name;
    private String fanRpm = "";
    private String noiseLevel = "";
    private double price;

    public CPUCooler(String[] coolerData){
        if(coolerData.length < 5) return;
        name = coolerData[1];
        fanRpm = coolerData[2];
        noiseLevel = coolerData[3];
        try {
            price = Double.parseDouble(coolerData[4].replace("$", ""));
        }catch (NumberFormatException e){
            //no price
            price = 0.0;
        }
    }

    @Override
    public String toString(){
        return "name = " +  this.name + "\nprice = " +this.getPrice() + "\nfan rpm = " + fanRpm + "\nnoise level = " + this.noiseLevel;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getFanRpm() {
        return fanRpm;
    }

    public String getNoiseLevel() {
        return noiseLevel;
    }


}
