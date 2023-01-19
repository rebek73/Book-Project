package com.book.demo.bookproject.model;

public enum Rating {

    ONE("\u2B50"),
    TWO("\u2B50"+"\u2B50"),
    THREE("\u2B50"+"\u2B50"+"\u2B50"),
    FOUR("\u2B50"+"\u2B50"+"\u2B50"),
    FIVE("\u2B50"+"\u2B50"+"\u2B50"+"\u2B50"+"\u2B50");

    private String icon;
    private Rating(String icon){
        this.icon=icon;
    }

    @Override
    public String toString() {
        return icon + " STARS ";
    }
}
