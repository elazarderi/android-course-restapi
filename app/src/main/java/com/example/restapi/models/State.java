package com.example.restapi.models;

import android.graphics.Bitmap;

import java.util.List;

public class State {

    private String name;
    private List<String> borders = null;
    private String nativeName;
    private Bitmap flag;

    public State(String name, List<String> borders, String nativeName, Bitmap flag) {
        this.name = name;
        this.borders = borders;
        this.nativeName = nativeName;
        this.flag = flag;
    }

    public State() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public Bitmap getFlag() {
        return flag;
    }

    public void setFlag(Bitmap flag) {
        this.flag = flag;
    }
}
