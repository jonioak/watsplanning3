package com.example.watsplanning3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TijdTotMoment {

    public int tijdTotMoment(ArrayList<Moment> momenten, int tijd){
        ArrayList<Moment> filteredMomenten = new ArrayList<>();

        for (Moment moment : momenten){
            if(tijd < moment.getBeginTijd().getTijd()){
                filteredMomenten.add(moment);
            }
        }
        Collections.sort(filteredMomenten, Comparator.comparingInt(o -> o.getBeginTijd().getTijd()));

        Moment moment = filteredMomenten.get(0);

        Tijd y = new Tijd(tijd);
        int uur = moment.getBeginTijd().getUur() - y.getUur();
        int minuut = moment.getBeginTijd().getMinuut() - y.getMinuut();
        if(minuut<0){
            uur=uur-1;
            minuut = minuut+60;
        }
        Tijd over = new Tijd(uur, minuut);
        if (over.getUur()<1) {
            System.out.println(moment.getActiviteit().getNaam() + " begint over: " + over.getMinuut() + " minuten");
        }
        else{
            System.out.println(moment.getActiviteit().getNaam() + " begint over: " + over.getUur() + " uur en " + over.getMinuut() + " minuten");
        }

        if(over.getMinuut()==0)return 0;

        else if(over.getMinuut()<=30 && over.getUur()<1) return 1;

        else if(over.getUur()<2) return 2;

        return 3;
    }
}
