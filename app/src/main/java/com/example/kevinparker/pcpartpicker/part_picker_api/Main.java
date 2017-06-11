package com.example.kevinparker.pcpartpicker.part_picker_api;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

/**
 * CPU link: https://pcpartpicker.com/products/cpu/fetch/?mode=list&xslug=&search=
 * CPU Cooler link: https://pcpartpicker.com/products/cpu-cooler/fetch/?mode=list&xslug=&search=
 * Motherboard link: https://pcpartpicker.com/products/motherboard/fetch/?mode=list&xslug=&search=
 * Memory link: https://pcpartpicker.com/products/memory/fetch/?mode=list&xslug=&search=
 * Storage link: https://pcpartpicker.com/products/internal-hard-drive/fetch/?mode=list&xslug=&search=
 * GPU link: https://pcpartpicker.com/products/video-card/fetch/?mode=list&xslug=&search=
 * Case link: https://pcpartpicker.com/products/case/fetch/?mode=list&xslug=&search=
 * Power Supply link: https://pcpartpicker.com/products/power-supply/fetch/?mode=list&xslug=&search=
 * Monitor link: https://pcpartpicker.com/products/monitor/fetch/?mode=list&xslug=&search=
 * */

public class Main {

    //experimentally public only
    public static String[][] getRawData(Document doc){
        String[][] rawData = new String[doc.getElementsByTag("tr").size()][];
        int j = 0;
        /*
        Elements links = doc.getElementsByTag("a");
        for (Element curr : links) {
            Log.i("", "pcpartpicker.com/product/" + curr.text());
        }
        */

        for (Element curr : doc.getElementsByTag("tr")) {
            int i = 0;
            rawData[j] = new String[curr.getElementsByTag("td").size() - 2];//one of the 2 base cases
            for (Element info : curr.getElementsByTag("td")) {
                if(info.text().equals("Add")) continue;
                if(info.text().matches("\\(\\d+\\)")) continue;//number between parenthesis, the ratings
                rawData[j][i] = info.text();
//                Log.i("", rawData[j][i]);
                i++;
            }
//            Log.i("", "\n");
            j++;
        }
        return rawData;
    }

    private static ArrayList<CPU> getCPUsFromDoc(Document doc){
        String[][] rawData = getRawData(doc);
        ArrayList<CPU> cpus = new ArrayList<>(rawData.length);

        for (int i = 0; i < rawData.length; i++) {
            cpus.add(i, new CPU(rawData[i]));
        }
        return cpus;
    }

    private static ArrayList<CPUCooler> getCPUCoolersFromDoc(Document doc){
        String[][] rawData = getRawData(doc);
        ArrayList<CPUCooler> coolers = new ArrayList<>(rawData.length);

        for (int i = 0; i < rawData.length; i++) {
            coolers.add(i, new CPUCooler(rawData[i]));
        }

        return coolers;
    }

    private static ArrayList<Motherboard> getMobosFromDoc(Document doc){
        String[][] rawData = getRawData(doc);
        ArrayList<Motherboard> motherboards = new ArrayList<>(rawData.length);

        for (int i = 0; i < rawData.length; i++) {
            motherboards.add(new Motherboard(rawData[i]));
            System.out.println(motherboards.get(i));
            System.out.println();
        }
        return motherboards;
    }

    private static ArrayList<Memory> getMemoryFromDoc(Document doc){
        String[][] rawData = getRawData(doc);
        ArrayList<Memory> rams = new ArrayList<>(rawData.length);
        for (int i = 0; i < rawData.length; i++) {
            rams.add(new Memory(rawData[i]));
        }
        return rams;
    }

    private static ArrayList<Storage> getStorageFromDoc(Document doc){
        String[][] rawData = getRawData(doc);
        ArrayList<Storage> drives = new ArrayList<>(rawData.length);
        for (int i = 0; i < rawData.length; i++) {
            drives.add(new Storage(rawData[i]));
        }
        return drives;
    }

    private static ArrayList<GPU> getGPUsFromDoc(Document doc){
        String[][] rawData = getRawData(doc);
        ArrayList<GPU> gpus = new ArrayList<>(rawData.length);
        for (int i = 0; i < rawData.length; i++){
            gpus.add(new GPU(rawData[i]));
        }
        return gpus;
    }

    private static ArrayList<Case> getCasesFromDoc(Document doc){
        String[][] rawData = getRawData(doc);
        ArrayList<Case> cases = new ArrayList<>(rawData.length);
        for (int i = 0; i < rawData.length; i++){
            cases.add(new Case(rawData[i]));
        }
        return cases;
    }

    private static ArrayList<PowerSupply> getPowerSuppliesFromDoc(Document doc){
        String[][] rawData = getRawData(doc);
        ArrayList<PowerSupply> powerSupplies = new ArrayList<>(rawData.length);
        for (int i = 0; i < rawData.length; i++){
            powerSupplies.add(new PowerSupply(rawData[i]));
        }
        return powerSupplies;
    }

    private static ArrayList<Monitor> getMonitorsFromDoc(Document doc){
        String[][] rawData = getRawData(doc);
        ArrayList<Monitor> monitors = new ArrayList<>(rawData.length);
        for (int i = 0; i < rawData.length; i++){
            monitors.add(new Monitor(rawData[i]));
        }
        return monitors;
    }

    public ArrayList<CPU> getCPUs() throws IOException {
        String url = "https://pcpartpicker.com/products/cpu/fetch/?mode=list&xslug=&search=";
        System.setProperty("http.agent", "Chrome");
        Document doc = Jsoup.parse(new URL(url).openStream(), "UTF-8", "", Parser.xmlParser());
        return getCPUsFromDoc(doc);
    }

    public ArrayList<CPUCooler> getCPUCoolers() throws IOException {
        String url = "https://pcpartpicker.com/products/cpu-cooler/fetch/?mode=list&xslug=&search=";
        System.setProperty("http.agent", "Chrome");
        Document doc = Jsoup.parse(new URL(url).openStream(), "UTF-8", "", Parser.xmlParser());
        return getCPUCoolersFromDoc(doc);
    }

    public ArrayList<Motherboard> getMotherboards() throws IOException {
        String url = "https://pcpartpicker.com/products/motherboard/fetch/?mode=list&xslug=&search=";
        System.setProperty("http.agent", "Chrome");
        Document doc = Jsoup.parse(new URL(url).openStream(), "UTF-8", "", Parser.xmlParser());
        return getMobosFromDoc(doc);
    }

    public ArrayList<Memory> getMemory() throws IOException {
        String url = "https://pcpartpicker.com/products/memory/fetch/?mode=list&xslug=&search=";
        System.setProperty("http.agent", "Chrome");
        Document doc = Jsoup.parse(new URL(url).openStream(), "UTF-8", "", Parser.xmlParser());
        return getMemoryFromDoc(doc);
    }

    public ArrayList<Storage> getStorage() throws IOException {
        String url = "https://pcpartpicker.com/products/internal-hard-drive/fetch/?mode=list&xslug=&search=";
        System.setProperty("http.agent", "Chrome");
        Document doc = Jsoup.parse(new URL(url).openStream(), "UTF-8", "", Parser.xmlParser());
        return getStorageFromDoc(doc);
    }

    public ArrayList<GPU> getGPUs() throws IOException {
        String url = "https://pcpartpicker.com/products/video-card/fetch/?mode=list&xslug=&search=";
        System.setProperty("http.agent", "Chrome");
        Document doc = Jsoup.parse(new URL(url).openStream(), "UTF-8", "", Parser.xmlParser());
        return getGPUsFromDoc(doc);
    }

    public ArrayList<Case> getCases() throws IOException {
        String url = "https://pcpartpicker.com/products/case/fetch/?mode=list&xslug=&search=";
        System.setProperty("http.agent", "Chrome");
        Document doc = Jsoup.parse(new URL(url).openStream(), "UTF-8", "", Parser.xmlParser());
        return getCasesFromDoc(doc);
    }

    public ArrayList<PowerSupply> getPowerSupplies() throws IOException {
        String url = "https://pcpartpicker.com/products/power-supply/fetch/?mode=list&xslug=&search=";
        System.setProperty("http.agent", "Chrome");
        Document doc = Jsoup.parse(new URL(url).openStream(), "UTF-8", "", Parser.xmlParser());
        return getPowerSuppliesFromDoc(doc);
    }

    public ArrayList<Monitor> getMonitors() throws IOException {
        String url = "https://pcpartpicker.com/products/monitor/fetch/?mode=list&xslug=&search=";
        System.setProperty("http.agent", "Chrome");
        Document doc = Jsoup.parse(new URL(url).openStream(), "UTF-8", "", Parser.xmlParser());
        return getMonitorsFromDoc(doc);
    }

}
