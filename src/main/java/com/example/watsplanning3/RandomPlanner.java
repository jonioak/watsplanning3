package com.example.watsplanning3;

import java.util.ArrayList;
import java.util.Date;

public class RandomPlanner implements Planner {
    private ArrayList<Dag> dagen = DagLijst.getInstance().getDagLijst();

    private Date datum;
    @Override
    public void createDag() {

    }
}
