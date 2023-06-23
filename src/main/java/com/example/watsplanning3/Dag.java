package com.example.watsplanning3;

import java.util.ArrayList;
import java.util.Date;

public class Dag{
    private Date datum;
    private ArrayList<Moment> momenten = new ArrayList<>();

    public Date getDatum(){
        return datum;
    }

    public ArrayList<Moment> getMomenten() {
        return momenten;
    }

    public void setDatum(Date datum){
        this.datum = datum;
    }

    public void addMoment(Tijd tijd, Activiteit activiteit){
        Moment moment = new Moment();
        moment.setActiviteit(activiteit);
        moment.setBeginTijd(tijd);
        moment.setEindTijd(tijd);
        momenten.add(moment);
    }

    public Tijd uitvoering(Tijd tijd, Activiteit activiteit){
        activiteit.uitvoeren();
        Tijd tijd2;
        if(activiteit.getVoorbereiding()!=null){
            addMoment(tijd,activiteit.getVoorbereiding());
            tijd2 = tijd.tijdDuratie(activiteit.getVoorbereiding().getDuratie());
            addMoment(tijd2,activiteit);
            tijd2 = tijd2.tijdDuratie(activiteit.getDuratie());
        }
        else{
            addMoment(tijd,activiteit);
            tijd2 = tijd.tijdDuratie(activiteit.getDuratie());
        }
        if(activiteit.getAfronding()!=null){
            addMoment(tijd2,activiteit.getAfronding());
            tijd2 = tijd2.tijdDuratie(activiteit.getAfronding().getDuratie());
        }
        return tijd2;
    }

    public boolean checkMoment(Moment moment){
        for (Moment moments : momenten){
            if(moment.getBeginTijd().getTijd() >= moments.getBeginTijd().getTijd() && moment.getBeginTijd().getTijd() <= moments.getEindTijd().getTijd()){
                System.out.println("Moment overlapt met een andere moment(en)");
                return false;
            }
            if(moment.getEindTijd().getTijd() >= moments.getBeginTijd().getTijd() && moment.getEindTijd().getTijd() <= moments.getEindTijd().getTijd()){
                System.out.println("Moment overlapt met een andere moment(en)");
                return false;
            }
        }
        for (Activiteit activiteit : ActiviteitenLijst.getInstance().getActiviteitenLijst()){
            if(moment.getActiviteit().equals(activiteit)){
                System.out.println("Moment voldoet aan alle eisen");
                return true;
            }
        }
        System.out.println("Activiteit niet gevonden in activiteitenLijst");
        return false;
    }
}
