package com.example.watsplanning3;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class ActiviteitManager {
    private ArrayList<Activiteit> activiteitenLijst = ActiviteitenLijst.instance.getActiviteitenLijst();

    public void createActiviteit(String naam, int duratie, Image afbeelding){
        NormaalActiviteit activiteit = new NormaalActiviteit();
        activiteit.setNaam(naam);
        activiteit.setDuratie(duratie);
        activiteit.setAfbeelding(afbeelding);
        activiteitenLijst.add(activiteit);
    }

    public void createRoutine(String naam, int duratie, Image afbeelding, int vasteTijd){
        Routine activiteit = new Routine();
        activiteit.setNaam(naam);
        activiteit.setDuratie(duratie);
        activiteit.setAfbeelding(afbeelding);
        activiteit.setVasteTijd(vasteTijd);
        activiteitenLijst.add(activiteit);
    }

    public void deleteActiviteit(Activiteit activiteit){
        activiteitenLijst.remove(activiteit);

    }
}
