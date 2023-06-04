package com.example.watsplanning3;

public class SportActiviteit extends Activiteit{
    SportActiviteit(Tijd vasteTijd) {
        super("Sport", vasteTijd);
    }

    @Override
    public String doActiviteit() {
        return "Sport";
    }
}
