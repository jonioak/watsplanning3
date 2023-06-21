package com.example.watsplanning3;

import javafx.scene.image.Image;

public class SportActiviteitFactory extends ActiviteitFactory{
    @Override
    Activiteit maakActiviteit(String naam, int duratie, Image afbeelding, Tijd vasteTijd) {
        Activiteit activiteit = new SportActiviteit(vasteTijd);
        activiteit.setNaam(naam);
        activiteit.setDuratie(duratie);
        activiteit.setAfbeelding(afbeelding);
        activiteit.setVasteTijd(vasteTijd);
        return activiteit;
    }
}
