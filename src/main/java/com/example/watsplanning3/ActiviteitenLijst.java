package com.example.watsplanning3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ActiviteitenLijst {
    private static ActiviteitenLijst instance;
    private ArrayList<Activiteit> activiteitenLijst = new ArrayList<>();
    private ArrayList<Activiteit> randomizedList = new ArrayList<>();
    private ArrayList<Activiteit> categorien = new ArrayList<>();

    ActiviteitenLijst(){
        NormaalActiviteit a = new NormaalActiviteit(null);
        a.setNaam("Schoonmaken");
        a.setDuratie(60);
        a.setAfbeelding(null);
        Activiteit b = new SportActiviteit(new Tijd(1700));
        b.setNaam("Hardlopen");
        b.setDuratie(60);
        b.setAfbeelding(null);
        activiteitenLijst.add(a);
        activiteitenLijst.add(b);

        categorien.add(new NormaalActiviteit(null));
        categorien.add(new SportActiviteit(null));
    }
    public ArrayList<Activiteit> getActiviteitenLijst() {
        return activiteitenLijst;
    }
    public void printActiviteiten(){
        int i=1;
        for (Activiteit activiteit : activiteitenLijst) {
            System.out.println(i + " Activiteit: " + activiteit.getNaam());
            System.out.println("Duratie: " + activiteit.getDuratie());
            if (activiteit.getRoutine()){
                System.out.println("Routine tijd: " + activiteit.getVasteTijd().getTijdString());
            }
            System.out.println();
            i++;
        }
    }
    public static ActiviteitenLijst getInstance() {
        if (instance == null) instance = new ActiviteitenLijst();
        return instance;
    }
    public void shuffle(){
        ArrayList<Activiteit> randomizedList = activiteitenLijst;
        Collections.shuffle(randomizedList);
        this.randomizedList = randomizedList;
    }
    public ArrayList<Activiteit> getRandomizeList() {
        return randomizedList;
    }
    public ArrayList<Activiteit> getCategorien() {
        return categorien;
    }
}
