package com.example.viewapp;

public class DataNote
{
    String title;
    String sub;
    int image;
    String menu;
    int imageMenu;

    public DataNote(String title, String sub, int image)
    {
        this.title = title;
        this.sub = sub;
        this.image = image;
    }

    public DataNote(String menu, int imageMenu)
    {
        this.menu = menu;
        this.imageMenu = imageMenu;
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