package com.example.watsplanning3;

import java.util.ArrayList;

public class DagLijst {
    static DagLijst instance;
    private ArrayList<Dag> dagLijst = new ArrayList<>();

    public static DagLijst getInstance() {
        return instance;
    }

    public ArrayList<Dag> getDagLijst(){
        return dagLijst;
    }


}
