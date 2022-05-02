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

public class Mountain {
    private String ID;
    private String name;
    private String type;
    private String company;
    private String location;
    private String category;
    private String size;
    private String cost;
    private Auxdata auxdata;

    public String getName() {
        // Om tomt skickas null annars hela oridinarie värde
        if (name.equals("")) {
            return null;
        }
        else {
            return name;
        }
    }

    public String getID() {
        if (ID.equals("")) {
            return null;
        }
        else {
            return ID;
        }
    }

    public String getType() {
        if (type.equals("")) {
            return null;
        }
        else {
            return type;
        }
    }

    public String getCompany() {
        if (company.equals("")) {
            return null;
        }
        else {
            return company;
        }
    }

    public String getLocation() {
        if (location.equals("")) {
            return null;
        }
        else {
            return location;
        }
    }

    public String getCategory() {
        if (category.equals("")) {
            return null;
        }
        else {
            return category;
        }
    }

    public String getSize() {
        if (size.equals("")) {
            return null;
        }
        else {
            return size;
        }
    }

    public String getCost() {
        if (cost.equals("")) {
            return null;
        }
        else {
            return cost;
        }
    }

    public Auxdata getAuxdata() {
        return auxdata;
    }
}
