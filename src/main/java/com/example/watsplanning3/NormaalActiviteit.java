package com.example.watsplanning3;

public class NormaalActiviteit extends Activiteit{
    NormaalActiviteit(Tijd vasteTijd) {
        super("Normaal activiteit", vasteTijd);
    }

    @Override
    protected void doActiviteit() {
    }
}
