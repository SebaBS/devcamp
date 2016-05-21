package com.finder.model;

import com.finder.model.Enum.Web;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 21.05.16.
 */
public class Engine {

    public static final String WWW = "www.";
    public static final String HTPP = "http://";
    public static final String HTPPS = "https://";
    public static final String LOCALE_PL = ".pl/";
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final String SLASH = "/";

    private List<String> paths;

    public Engine(){
        paths = new ArrayList<String>();
    }

    public String createPath(Web web, String value){
        String path = (HTPPS + WWW + web + LOCALE_PL + getPattern(web, value)).toLowerCase();
        paths.add(path);
        return path;
    }

    private String getPattern(Web web, String text){
        switch (web){
            case GOOGLE:
                return "#q=" + replaceSpaces(text, PLUS);
            case GOLDENLINE:
                return replaceSpaces(text, MINUS) + SLASH;
            default:
                return "";
        }
    }

    public String replaceSpaces(String text, char character) {
        String[] splitted = text.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitted.length; i++) {
            String part = splitted[i];
            if(i != splitted.length-1){
                sb.append(part + character);
            }else {
                sb.append(part);
            }
        }
        return sb.toString();
    }

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

}
