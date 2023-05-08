package com.example.watsplanning3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CustomPlanner implements Planner{
    private ArrayList<Dag> dagen = DagLijst.getInstance().getDagLijst();
    private Date datum;

    public void chooseOptie(Scanner scanner){
        int option = 1;
        while(option!=0) {
            System.out.println("Kies een optie:");
            System.out.println("1: Bekijk alle dagen");
            System.out.println("2: Creëer een dag");
            System.out.println("3: Pas een dag aan");
            option = scanner.nextInt();
            switch (option){
                case 0:
                    break;
                case 1:
                    printAlleDagen();
                    break;
                case 2:
                    createDag();
                    break;
                case 3:
                    printAlleDagen();
                    System.out.println("Kies een dag die u wilt aanpassen");
                    int dag = scanner.nextInt();
                    if(dag <= DagLijst.getInstance().getDagLijst().size() && dag>0){
                        System.out.println(dag);
                    }
                    System.out.println("Geen geldige dag");


            }

        }
    }
    @Override
    public void createDag() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voor welke maand?");
        int maand = scanner.nextInt();
        System.out.println("Voor welke dag?");
        int datum = scanner.nextInt();
        Date date = new Date(2023,maand,datum);
        Dag dag = new Dag();
        dag.setDatum(date);
        dag.editDag();
    }

    @Override
    public Dag getDag() {
        for(Dag a: dagen){
            if(dagen.contains(datum)){
                return a;
            }
        }
        return null;
    }

    public void printAlleDagen(){
        int i = 1;
        for(Dag dag:dagen){
            System.out.println(i + " " + dag.getDatum().getDate() + "/" + dag.getDatum().getMonth());
            i++;
        }
    }


}
