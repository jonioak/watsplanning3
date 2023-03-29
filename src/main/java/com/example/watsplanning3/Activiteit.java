package com.example.watsplanning3;


import javafx.scene.image.Image;

public abstract class Activiteit {
    private String naam;
    private int duratie;
    private Image afbeelding;

    public String getNaam() {
        return naam;
    }
    public void setNaam(String naam){
        this.naam = naam;
    }

    public int getDuratie() {
        return duratie;
    }

    public void setDuratie(int duratie){
        this.duratie = duratie;
    }

    public Image getAfbeelding() {
        return afbeelding;
    }

    public void setAfbeelding(Image afbeelding){
        this.afbeelding = afbeelding;
    }
}
