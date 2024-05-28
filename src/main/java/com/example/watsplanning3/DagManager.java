package com.example.watsplanning3;

import java.util.ArrayList;
import java.util.Scanner;

public class DagManager implements Optie {

    private Dag dag;

    DagManager(Dag dag){
        this.dag = dag;
    }

    @Override
    public void chooseOptie(Scanner scanner) {
        int optie = 1;
        while(optie != 0){
            System.out.println("Kies een optie:");
            System.out.println("1: Bekijk alle momenten");
            System.out.println("2: Creëer een moment");
            System.out.println("3: Verwijder een moment");
            System.out.println("0: Vorige scherm");
            optie = scanner.nextInt();
            if (optie == 0) {
                break;
            } else if (optie == 1) {
                printMomenten();
            } else if (optie == 2) {
                createMoment(scanner);
            } else if (optie == 3) {
                System.out.println("Selecteer een moment die je wilt verwijderen");
                printMomenten();
                int moment = scanner.nextInt();
                removeMoment(moment);
                System.out.println("I'm debugging this lol");
            }
        }
    }

    public void printMomenten(){
        int i=1;
        for (Moment moment : dag.getMomenten()){
            System.out.print(i++ + " ");
            System.out.println("Activiteit: " + moment.getActiviteit().getNaam());
            System.out.println("Begin tijd: " + moment.getBeginTijd().getTijdString());
            System.out.println("Eind tijd: " + moment.getEindTijd().getTijdString() + "\n");
        }
    }

    public void createMoment(Scanner scanner){
        int optie = 1;
        while (optie != 0){
            System.out.println("Van welke activiteit wil je een moment maken?");
            ActiviteitenLijst.getInstance().printActiviteiten();
            System.out.println("0: Vorige scherm");
            optie = scanner.nextInt();
            if(optie == 0){
                break;
            }
            if(optie > ActiviteitenLijst.getInstance().getActiviteitenLijst().size()){
                System.out.println("Ongeldig activiteit");
            }
            else{
                Activiteit activiteit = ActiviteitenLijst.getInstance().getActiviteitenLijst().get(optie - 1);
                System.out.println("Hoe laat begint deze activiteit?");
                int tijd = scanner.nextInt();
                TijdMaker beginTijd = new TijdMaker(tijd);
                if(beginTijd.checkTijd()){
                    Moment moment = new Moment();
                    moment.setActiviteit(activiteit);
                    moment.setBeginTijd(beginTijd.getTijd());
                    moment.setEindTijd(beginTijd.getTijd());
                    if (dag.checkMoment(moment)){
                        dag.uitvoering(beginTijd.getTijd(), activiteit);
                    }
                }

            }
        }
    }

    public void removeMoment(int moment){
        if (moment <= dag.getMomenten().size()){
            System.out.println(dag.getMomenten().get(moment-1).getActiviteit().getNaam() + " is verwijderd");
            dag.getMomenten().remove(moment-1);
        }
        else{
            System.out.println("Ongeldige invoer");
        }
    }
}
