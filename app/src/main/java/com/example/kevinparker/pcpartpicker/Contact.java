package com.example.kevinparker.pcpartpicker;

/**
 * Created by doter on 5/5/2017.
 */

public class Contact {
    public Contact(int image_id, String name, double clockspeed, String mobile)
    {
        this.setImage_id(image_id);
        this.setName(name);
        this.setClockspeed(clockspeed);
        this.setCores(cores);
        this.setTDP(tdp);
        this.setPrice(price)
    }
    private int image_id;
    private double clockspeed, tdp, price
    private String name, cores;

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClockspeed(double clockspeed){
        this.clockspeed = clockspeed;
    }

    public void setCores(String cores) {
        this.cores = cores;
    }

    public void setTDP(double tdp) {
        this.tdp = tdp;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getClockspeed() {
        return clockspeed;
    }

    public String getCores() {
        return cores;
    }

    public double getTdp() {
        return tdp;
    }

    public double getPrice() {
        return price;
    }
}
