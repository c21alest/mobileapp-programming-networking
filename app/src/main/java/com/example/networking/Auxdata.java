package com.example.networking;

public class Auxdata {
    private String wiki;
    private String img;

    public String getWiki() {
        if (wiki.equals("")) {
            return null;
        }
        else {
            return wiki;
        }
    }

    public String getImg() {
        if (img.equals("")) {
            return null;
        }
        else {
            return img;
        }
    }
}
