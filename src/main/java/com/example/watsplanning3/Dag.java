package com.example.watsplanning3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Dag {
    private Date datum;
    private ArrayList<Moment> momenten = new ArrayList<>();
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
                    addMoment();
                    break;

            }
        }



    }

    public Date getDatum(){
        return datum;
    }

    public void setDatum(Date datum){
        this.datum = datum;
    }

    public void addMoment(){
        int optie = 1;

        while (optie!=0){
            System.out.println("Van welke activiteit wil je een moment maken?");
            ActiviteitenLijst.getInstance().printActiviteiten();
            System.out.println("0: Vorige scherm");
            optie = scanner.nextInt();
            if(optie==0){
                break;
            }
            Activiteit activiteit = ActiviteitenLijst.getInstance().getActiviteitenLijst().get(optie-1);
            System.out.println("Hoe laat begint deze activiteit?");
            int beginTijd = scanner.nextInt();
            createMoment(beginTijd, activiteit);
        }
    }

    public void createMoment(int beginTijd, Activiteit activiteit){
        Moment moment = new Moment();
        moment.setActiviteit(activiteit);
        moment.setBeginTijd(beginTijd);
        momenten.add(moment);
    }

    public void printMomenten(){
        for (Moment moment : momenten){
            System.out.println("Activiteit: " + moment.getActiviteit().getNaam());
            System.out.println("Begin tijd: " + moment.getBeginTijd());
            System.out.println("Eind tijd: " + moment.getEindTijd());
            System.out.println();
        }
    }

    public void removeMoment(Moment moment){
        momenten.remove(moment);
    }
}
