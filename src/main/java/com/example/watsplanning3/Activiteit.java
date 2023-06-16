package com.example.watsplanning3;


import javafx.scene.image.Image;

public abstract class Activiteit {
    private String categorie;
    private String naam;
    private int duratie;
    private Image afbeelding;
    private Boolean routine;
    private Tijd vasteTijd;



    Activiteit(String categorie, Tijd vasteTijd){
        this.categorie = categorie;

        if(vasteTijd!=null){
            routine = true;
        }
    }
    protected abstract String doActiviteit();

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

    public Boolean getRoutine() {
        return routine;
    }

    public void setRoutine(Boolean routine) {
        this.routine = routine;
    }

    public Tijd getVasteTijd() {
        return vasteTijd;
    }

    public void setVasteTijd(Tijd vasteTijd) {
        this.vasteTijd = vasteTijd;
        if(vasteTijd.getTijd()==0){
            routine = false;
        }
    }

    public String getCategorie() {
        return categorie;
    }
}
