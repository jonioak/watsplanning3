package com.example.watsplanning3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Dag {
    private Date datum;
    private ArrayList<Moment> momenten = new ArrayList<>();

    private ArrayList<Moment> alleMomenten = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void editDag(){
        int optie = 1;
        while(optie!=0){
            System.out.println("Kies een optie:");
            System.out.println("1: Bekijk alle momenten");
            System.out.println("2: Creëer een moment");
            System.out.println("3: Verwijder een moment");
            System.out.println("0: Vorige scherm");
            optie = scanner.nextInt();
            switch (optie){
                case 0:
                    break;
                case 1:
                    printMomenten();
                    break;
                case 2:
                    createMoment();
                    break;
                case 3:
                    System.out.println("Selecteer een moment die je wilt verwijderen");
                    printMomenten();
                    int moment = scanner.nextInt();
                    removeMoment(moment);
            }
        }
    }

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
//        if (checkMoment(moment))momenten.add(moment);
    }

    public void createMoment(){
        int optie = 1;
        while (optie!=0){
            System.out.println("Van welke activiteit wil je een moment maken?");
            ActiviteitenLijst.getInstance().printActiviteiten();
            System.out.println("0: Vorige scherm");
            optie = scanner.nextInt();
            if(optie==0){
                break;
            }
            if(optie>ActiviteitenLijst.getInstance().getActiviteitenLijst().size()){
                System.out.println("Ongeldig activiteit");
            }
            else{
                Activiteit activiteit = ActiviteitenLijst.getInstance().getActiviteitenLijst().get(optie-1);
                System.out.println("Hoe laat begint deze activiteit?");
                int invoer = scanner.nextInt();
                Tijd beginTijd = new Tijd(invoer);
                Moment moment = new Moment();
                moment.setActiviteit(activiteit);
                moment.setBeginTijd(beginTijd);
                moment.setEindTijd(beginTijd);
                if (checkMoment(moment)){
                    momenten.add(moment);
                }
            }
        }
    }

    public boolean checkMoment(Moment moment){
        if(moment.getBeginTijd().getMinuut()>59 || moment.getBeginTijd().getUur()>23){
            System.out.println("Ongeldige tijd");
            return false;
        }
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

    public void printMomenten(){
        int i=1;
        for (Moment moment : momenten){
            System.out.print(i++ + " ");
            System.out.println("Activiteit: " + moment.getActiviteit().getNaam());
            System.out.println("Begin tijd: " + moment.getBeginTijd().getTijdString());
            System.out.println("Eind tijd: " + moment.getEindTijd().getTijdString());
            System.out.println();
        }
    }

    public void removeMoment(int moment){
        if (moment <= momenten.size()){
            System.out.println(momenten.get(moment-1).getActiviteit().getNaam() + " is verwijderd");
            momenten.remove(moment-1);
        }
        else{
            System.out.println("Ongeldige invoer");
        }
    }
}
