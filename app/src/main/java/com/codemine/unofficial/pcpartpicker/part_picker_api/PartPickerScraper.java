package com.codemine.unofficial.pcpartpicker.part_picker_api;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class PartPickerScraper {

    public static String[][] getRawData(Document doc){
        String[][] rawData = new String[doc.getElementsByTag("tr").size()][];
        int j = 0;
        for (Element curr : doc.getElementsByTag("tr")) {
            int i = 0;
            rawData[j] = new String[curr.getElementsByTag("td").size() - 2];//one of the 2 base cases
            for (Element info : curr.getElementsByTag("td")) {
                if(info.text().equals("Add")) continue;
                if(info.text().matches("\\(\\d+\\)")) continue;//number between parenthesis, the ratings
                rawData[j][i] = info.text();
                i++;
            }
            j++;
        }
        return rawData;
    }

    public static ArrayList<String> getUrlsFromDoc(Document doc){
        ArrayList<String> urls = new ArrayList<>();
        Elements links = doc.getElementsByTag("a");
//        Pattern pattern = Pattern.compile("&quot;#(.*?)\\&quot;");
        Pattern pattern = Pattern.compile("&quot;#(.*?)\\\\");//should grab it without the annoying "\" at the end
        //the original is still there just in case ;)
        for (Element curr : links) {
            if(curr.text().equals("Add")){
                Matcher matcher = pattern.matcher(curr.toString());
                if(matcher.find()){
                    urls.add(matcher.group(1));
                }
            }
        }
        return urls;
    }

}
