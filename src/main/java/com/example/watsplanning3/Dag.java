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

    public void addMoment(){
        int optie = 1;
        System.out.println("Van welke activiteit wil je een moment maken?");
        ActiviteitenLijst.getInstance().printActiviteiten();
        while (optie!=0){
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
                int beginTijd = scanner.nextInt();
                createMoment(new Tijd(beginTijd), activiteit);
            }

        }
    }

    public void createMoment(Tijd beginTijd, Activiteit activiteit){
        if(beginTijd.getMinuut()>59 || beginTijd.getUur()>23){
            System.out.println("Ongeldige tijd");
        }
        else{
            Moment moment = new Moment();
            moment.setActiviteit(activiteit);
            moment.setBeginTijd(beginTijd);
            moment.setEindTijd(beginTijd);
            if (checkMoment(moment)){
                momenten.add(moment);
            }
            else{
                printMomenten();
                System.out.println("Moment overlapt met een andere moment(en)");
                System.out.println("Van welke activiteit wil je een moment maken?");
            }
        }

    }

    public boolean checkMoment(Moment moment){
        for (Moment moments : momenten){
            if(moment.getBeginTijd().getTijd() >= moments.getBeginTijd().getTijd() && moment.getBeginTijd().getTijd() <= moments.getEindTijd().getTijd()){
                return false;
            }
            if(moment.getEindTijd().getTijd() >= moments.getBeginTijd().getTijd() && moment.getEindTijd().getTijd() <= moments.getEindTijd().getTijd()){
                return false;
            }
        }
        return true;
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
