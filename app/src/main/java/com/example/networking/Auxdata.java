package com.example.networking;

/*
[
  {
    "ID": "mobilprog_k2",
    "name": "K2",
    "type": "brom",
    "company": "",
    "location": "The Karakoram range",
    "category": "",
    "size": 8611,
    "cost": 28251,
    "auxdata": {
      "wiki": "https://en.wikipedia.org/wiki/K2",
      "img": "https://en.wikipedia.org/wiki/K2#/media/File:K2_2006b.jpg"
    }
 */

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
