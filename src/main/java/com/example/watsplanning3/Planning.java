package com.example.watsplanning3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Planning {

    public static void chooseOptie(Scanner scanner){
        int option = 1;
        while(option!=0){
            System.out.println("Kies een dag uit");
            DagLijst.getInstance().printAlleDagen();
            System.out.println("0: Vorige scherm");
            option = scanner.nextInt();
            kiesDag(option);
        }
    }


    public static void kiesDag(int option) {
        if(option > DagLijst.getInstance().getDagLijst().size() || option<=0){
            System.out.println("Ongeldige dag");
        }
        else if(option==0){
        }
        else{
            Dag dag = DagLijst.getInstance().getDagLijst().get(option-1);
            String[]planning = new String[24*4];
            int j;
            for (int i=0; i<dag.getMomenten().size(); i++){
                j=0;
                for (int uur = 0; uur < 24; uur++) {
                    for (int minuut = 0; minuut < 60; minuut += 15) {
                        if(momentCheck(uur,minuut,dag.getMomenten().get(i))){
                            if(planning[j]==null){
                                planning[j]=String.format("%02d:%02d ", uur, minuut) + dag.getMomenten().get(i).getActiviteit().getNaam();
                            }
                            else if(planning[j].length() < 5){
                                planning[j]=String.format("%02d:%02d ", uur, minuut) + dag.getMomenten().get(i).getActiviteit().getNaam();
                            }
                        }
                        else planning[j]=String.format("%02d:%02d ", uur, minuut);
                        j++;
                    }
                }
                System.out.println(dag.getMomenten().get(i).getActiviteit().getNaam());
            }
            for (j=0; j<planning.length; j++){
                System.out.println(planning[j]);
            }
        }
    }

    public static boolean momentCheck(int uur, int minuut, Moment moment){
        int tijd = uur*100+minuut;

        if(moment.getBeginTijd().getTijd() >= tijd && moment.getBeginTijd().getTijd() <= tijd){
            return true;
        }
        if(moment.getBeginTijd().getTijd()<tijd && moment.getEindTijd().getTijd()>tijd){
            return true;
        }
        if(moment.getEindTijd().getTijd() >= tijd && moment.getEindTijd().getTijd() <= tijd){
            return true;
        }
        return false;
    }
}