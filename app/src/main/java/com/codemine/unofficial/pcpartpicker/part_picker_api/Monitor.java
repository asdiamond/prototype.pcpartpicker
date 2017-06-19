package com.codemine.unofficial.pcpartpicker.part_picker_api;

import java.io.Serializable;

/**
 * Created by Aleksandr on 5/15/2017.
 */
public class Monitor implements Serializable, ComputerPart{
    private String name;
    private String resolution;
    private double size;
    private int responseTime;
    boolean ips = false;
    private double price;

    public Monitor(String[] monData){
        name = monData[1];
        resolution = monData[2];
        size = Double.parseDouble(monData[3].replace("\\\"", ""));
        responseTime = Integer.parseInt(monData[4].replace("ms", "").trim());
        if(monData[5].equals("Yes")) ips = true;
        try{
            price = Double.parseDouble(monData[6].replace("$", ""));
        }catch (NumberFormatException e){
            //NO PRICE
            price = 0;
        }
    }

    @Override
    public String toString() {
        return name + "\n" + resolution + "\n" + size + "\n" + responseTime + "\n" + ips + "\n" + price;
    }

    public String getResolution() {
        return resolution;
    }

    public double getSize() {
        return size;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public boolean isIps() {
        return ips;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
