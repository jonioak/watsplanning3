package com.example.watsplanning3;

import java.util.ArrayList;
import java.util.Date;

public class Dag {
    private Date datum;
    private ArrayList<Moment> momenten = new ArrayList<>();

    public Date getDatum(){
        return datum;
    }

    public void setDatum(Date datum){
        this.datum = datum;
    }

    public void createMoment(){
        Moment moment = new Moment();

        momenten.add(moment);
    }

    public void removeMoment(Moment moment){
        momenten.remove(moment);
    }
}
