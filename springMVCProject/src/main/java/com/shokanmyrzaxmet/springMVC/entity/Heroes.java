package com.shokanmyrzaxmet.springMVC.entity;

public class Heroes {
    private int id;
    private String name;
    private String rang;

    public Heroes() {
    }

    public Heroes(int id, String name, String rang) {
        this.id = id;
        this.name = name;
        this.rang = rang;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRang() {
        return rang;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }
}

