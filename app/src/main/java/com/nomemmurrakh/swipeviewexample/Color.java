package com.nomemmurrakh.swipeviewexample;

public class Color {

    private int id;

    private String colorName;

    private int colorCode;

    public Color(int id, String colorName, int colorCode){
        this.id = id;
        this.colorName = colorName;
        this.colorCode = colorCode;
    }

    public int getId() {
        return id;
    }

    public String getColorName() {
        return colorName;
    }

    public int getColorCode() {
        return colorCode;
    }
}
