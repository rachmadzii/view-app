package com.example.viewapp.adapter;

public class DataModel
{
    String title;
    String sub;
    int image;
    String menu;
    int imageMenu;

    public DataModel(String title, String sub, int image)
    {
        this.title = title;
        this.sub = sub;
        this.image = image;
    }

    public String getTitle()
    {
        return title;
    }

    public String getSub()
    {
        return sub;
    }

    public int getImage()
    {
        return image;
    }
}