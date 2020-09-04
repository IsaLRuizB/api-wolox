package com.prueba.api.wolox.dto;

public class Geo {

    private String lang;
    private  String lng;

    public Geo() {
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "lang='" + lang + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
