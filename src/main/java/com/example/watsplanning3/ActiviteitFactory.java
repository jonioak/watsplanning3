package com.example.watsplanning3;

import javafx.scene.image.Image;

public abstract class ActiviteitFactory {
    abstract Activiteit maakActiviteit(String naam, int duratie, Image afbeelding, Tijd vasteTijd);
}
