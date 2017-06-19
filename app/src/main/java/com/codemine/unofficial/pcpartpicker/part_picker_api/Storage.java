package com.codemine.unofficial.pcpartpicker.part_picker_api;

import java.io.Serializable;

/**
 * Created by Aleksandr on 5/15/2017.
 */
public class Storage implements Serializable, ComputerPart{
    private String name;
    private String series;
    private String form;
    private String type;
    private String capacity;
    private int cache;
    private double pricePerGb;
    private double price;

    public Storage(String[] storData){
        name = storData[1];
        series = storData[2];
        form = storData[3];
        type = storData[4];
        capacity = storData[5];
        try {
            cache = Integer.parseInt(storData[6].replace("MB", ""));
        }catch (NumberFormatException e){
            //its an ssd, it has no cache
            cache = 0;
        }
        try {
            pricePerGb = Double.parseDouble(storData[7].replace("$", ""));
            price = Double.parseDouble(storData[8].replace("$", ""));
        }catch (NumberFormatException e){
            pricePerGb = 0.0;
            price = 0.0;
        }
    }

    @Override
    public String toString() {
        return name + "\n" + series + "\n" + form + "\n" + type + "\n" + capacity + "\n" + cache + "\n" + pricePerGb
                + "\n" + price;
    }

    public String getSeries() {
        return series;
    }

    public String getType() {
        return type;
    }

    public int getCache() {
        return cache;
    }

    public double getPricePerGb() {
        return pricePerGb;
    }

    public String getName() {
        return name;
    }

    public String getForm() {
        return form;
    }

    public String getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }

}
