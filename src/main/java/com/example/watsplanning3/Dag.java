package com.example.watsplanning3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Dag {
    private Date datum;
    private ArrayList<Moment> momenten = new ArrayList<>();

    public void editDag(){
        Scanner scanner = new Scanner(System.in);

    }

    public Date getDatum(){
        return datum;
    }

    public void setDatum(Date datum){
        this.datum = datum;
    }

    public void createMoment(int beginTijd, Activiteit activiteit){
        Moment moment = new Moment();
        moment.setActiviteit(activiteit);
        moment.setBeginTijd(beginTijd);
        momenten.add(moment);
    }

    public void removeMoment(Moment moment){
        momenten.remove(moment);
    }
}
