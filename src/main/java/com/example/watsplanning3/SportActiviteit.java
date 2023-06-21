package com.example.watsplanning3;

public class SportActiviteit extends Activiteit{
    SportActiviteit(Tijd vasteTijd) {
        super("Sport Activiteit", vasteTijd);
    }

    @Override
    public void doActiviteit() {
        Activiteit voorbereiding = new NormaalActiviteit(new Tijd(0));
        voorbereiding.setNaam("Warming up");
        voorbereiding.setDuratie(30);
        voorbereiding.setAfbeelding(null);
        setVoorbereiding(voorbereiding);

        Activiteit afronding = new NormaalActiviteit(new Tijd(0));
        afronding.setNaam("Douchen");
        afronding.setDuratie(15);
        afronding.setAfbeelding(null);
        setAfronding(afronding);
    }
}
