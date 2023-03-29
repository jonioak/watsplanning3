package com.example.watsplanning3;

import java.util.ArrayList;
import java.util.Date;

public class CustomPlanner implements Planner{
    private ArrayList<Dag> dagen = DagLijst.getInstance().getDagLijst();
    private Date datum;

    @Override
    public void createDag() {
        Dag dag = new Dag();
    }

    @Override
    public Dag getDag() {
        for(Dag a: dagen){
            if(dagen.contains(datum)){
                return a;
            }
        }
        return null;
    }


}
