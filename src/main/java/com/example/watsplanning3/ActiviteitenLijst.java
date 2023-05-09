package com.example.watsplanning3;

import java.util.ArrayList;

public class ActiviteitenLijst {
    private static ActiviteitenLijst instance;
    private ArrayList<Activiteit> activiteitenLijst = new ArrayList<>();

    ActiviteitenLijst(){
        NormaalActiviteit a = new NormaalActiviteit();
        a.setNaam("Schoonmaken");
        a.setDuratie(60);
        a.setAfbeelding(null);
        Routine b = new Routine();
        b.setNaam("Hardlopen");
        b.setDuratie(60);
        b.setVasteTijd(2);
        b.setAfbeelding(null);
        activiteitenLijst.add(a);
        activiteitenLijst.add(b);
    }

    public ArrayList<Activiteit> getActiviteitenLijst() {
        return activiteitenLijst;
    }

    public void addActiviteit(Activiteit activiteit){
        activiteitenLijst.add(activiteit);
    }

    public void deleteActiviteit(Activiteit activiteit){
        activiteitenLijst.remove(activiteit);
    }

    public void printActiviteiten(){
        int i=1;
        for (Activiteit activiteit : activiteitenLijst) {
            System.out.println(i + " Activiteit: " + activiteit.getNaam());
            System.out.println("Duratie: " + activiteit.getDuratie());
            if (activiteit instanceof Routine){
                System.out.println("Routine tijd: " + ((Routine) activiteit).getVasteTijd());
            }
            System.out.println();
            i++;
        }
    }

    public static ActiviteitenLijst getInstance() {
        if (instance == null) instance = new ActiviteitenLijst();
        return instance;
    }
}
