package com.example.watsplanning3;

import java.util.ArrayList;
import java.util.Date;

public class Planning {
    private ArrayList<Dag> dagen = DagLijst.getInstance().getDagLijst();
    private Dag dag;

    public void displayPlanning() {

    }

    public void kiesDag(Date datum) {
        for(Dag a: dagen){
            if(dagen.contains(datum)){
                dag = a;
            }
        }
    }
}