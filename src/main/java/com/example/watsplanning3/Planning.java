package com.example.watsplanning3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Planning implements Optie{
    private static Planning instance;
    private int tijd;

    public static Planning getInstance() {
        if (instance == null) {
            instance = new Planning();
        }
        return instance;
    }

    @Override
    public void chooseOptie(Scanner scanner) {
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
        if(option > DagLijst.getInstance().getDagLijst().size() || option<=0){
            System.out.println("Ongeldige dag");
        }
        else if(option==0){
        }
        else{
            Dag dag = DagLijst.getInstance().getDagLijst().get(option-1);
            String[]planning = new String[24*4];
            int j;
            // Gaat langs alle momenten van de gekozen dag
            for (int i=0; i<dag.getMomenten().size(); i++){
                j=0;

                // Om elke 15 minuten van de dag tijd + activiteit
                for (int uur = 0; uur < 24; uur++) {
                    for (int minuut = 0; minuut < 60; minuut += 15) {
                        // Checkt of tijd valt binnen het moment
                        if(momentCheck(uur,minuut,dag.getMomenten().get(i))){
                            planning[j]=String.format("%02d:%02d ", uur, minuut) + dag.getMomenten().get(i).getActiviteit().getNaam();
                        }
                        j++;
                    }
                }
                System.out.println(dag.getMomenten().get(i).getActiviteit().getNaam());
            }

            // Resterende tijd zonder moment
            j=0;
            for (int uur = 0; uur < 24; uur++)
            {
                for (int minuut = 0; minuut < 60; minuut += 15)
                {
                    if(planning[j]==null){
                        planning[j]=String.format("%02d:%02d ", uur, minuut);
                    }
                    j++;
                }
            }

            for (j=0; j<planning.length; j++){
                System.out.println(planning[j]);
            }
            wanneer(tijdTotMoment(dag, tijd));
        }
    }

    public boolean momentCheck(int uur, int minuut, Moment moment){
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

    public void wanneer(int afstand){
        switch(afstand){
            case 0:
                System.out.println("Dat is nu");
                break;
            case 1:
                System.out.println("Dat is best snel al");
                break;
            case 2:
                System.out.println("Dat duurt nog een tijdje");
                break;
            case 3:
                System.out.println("Dat duurt nog een lange tijd");
                break;
        }
    }

    public int tijdTotMoment(Dag dag,int tijd){
        for (Moment moment : dag.getMomenten()){
            if(tijd < moment.getBeginTijd().getTijd()){
                Tijd y = new Tijd(tijd);
                int uur = moment.getBeginTijd().getUur() - y.getUur();
                int minuut = moment.getBeginTijd().getMinuut() - y.getMinuut();
                if(minuut<0){
                    uur=uur-1;
                    minuut = minuut+60;
                }
                int x = uur * 100 + minuut;
                Tijd over = new Tijd(x);
                System.out.println();
                System.out.println(over.getTijd());
                if (over.getUur()<1) {
                    System.out.println(moment.getActiviteit().getNaam() + " begint over: " + over.getMinuut() + " minuten");
                }
                else{
                    System.out.println(moment.getActiviteit().getNaam() + " begint over: " + over.getUur() + " uur en " + over.getMinuut() + " minuten");
                }

                if(over.getMinuut()==0)return 0;

                else if(over.getMinuut()<30 && over.getUur()<1) return 1;

                else if(over.getUur()<=2) return 2;

                break;
            }
        }
        return 3;
    }
    public void setTijd(int tijd)
    {
        this.tijd = tijd;
    }
}