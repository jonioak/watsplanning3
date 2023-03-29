package com.example.watsplanning3;

import java.util.ArrayList;

public class ActiviteitenLijst {
    static ActiviteitenLijst instance;
    private ArrayList<Activiteit> activiteitenLijst = new ArrayList<>();

    public static ActiviteitenLijst getInstance(){
        return instance;
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
}
