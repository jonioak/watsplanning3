package com.example.watsplanning3;

import java.util.*;

public class Planning implements Optie{

    private int tijd;
    private TijdTotMoment tijdTotMoment;

    @Override
    public void chooseOptie(Scanner scanner) {
        tijdTotMoment = new TijdTotMoment();
        int option = 1;
        while (option != 0) {
            System.out.println("Kies een dag uit");
            DagLijst.getInstance().printAlleDagen();
            System.out.println("0: Vorige scherm");
            option = scanner.nextInt();
            kiesDag(option);
        }
    }

    public void kiesDag(int option) {
        if(option > DagLijst.getInstance().getDagLijst().size() || option<0){
            System.out.println("Ongeldige dag");
        }
        else if(option==0){
        }
        else{
            Dag dag = DagLijst.getInstance().getDagLijst().get(option-1);
            PlanningPrinter planningPrinter = new PlanningPrinter();
            planningPrinter.printPlanning(dag);
            wanneer(tijdTotMoment.tijdTotMoment(dag.getMomenten(), tijd));
        }
    }

    public void wanneer(int afstand) {
        if (afstand == 0) {
            System.out.println("Dat is nu");
        } else if (afstand == 1) {
            System.out.println("Dat is best snel al");
        } else if (afstand == 2) {
            System.out.println("Dat duurt nog een tijdje");
        } else if (afstand == 3) {
            System.out.println("Het duurt nog een lange tijd tot je volgende activiteit");
        }
    }

    public void setTijd(int tijd){
        this.tijd = tijd;
    }
}