package com.example.watsplanning3;

import java.util.ArrayList;
import java.util.Date;

public class DagLijst {
    static DagLijst instance;
    private ArrayList<Dag> dagLijst = new ArrayList<>();

    DagLijst(){
        Dag a = new Dag();
        a.setDatum(new Date(2023,6,25));
        Activiteit activiteit = ActiviteitenLijst.getInstance().getActiviteitenLijst().get(0);
        a.addMoment(new Tijd(1400),activiteit);
        Dag b = new Dag();
        b.setDatum(new Date(2023,10,1));
        b.addMoment(new Tijd(1800),activiteit);
        dagLijst.add(a);
        dagLijst.add(b);
    }

    public static DagLijst getInstance() {
        if (instance == null) instance = new DagLijst();
        return instance;
    }

    public ArrayList<Dag> getDagLijst(){
        return dagLijst;
    }

    public void printAlleDagen(){
        int i = 1;
        for(Dag dag:dagLijst){
            System.out.println(i + " " + dag.getDatum().getDate() + "/" + dag.getDatum().getMonth());
            i++;
        }
    }

    public boolean checkDag(Date date){
        for (Dag dag : dagLijst){
            if(dag.getDatum().equals(date)){
                return true;
            }
        }
        return false;
    }


}
