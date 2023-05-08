package com.example.watsplanning3;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Scanner;

public class ActiviteitManager {
    private ArrayList<Activiteit> activiteitenLijst = ActiviteitenLijst.getInstance().getActiviteitenLijst();
    public void chooseOptie(Scanner scanner){
        int optionA = 1;
        while(optionA!=0) {
            System.out.println("Kies een optie:");
            System.out.println("1: Bekijk alle activiteiten");
            System.out.println("2: Creëer activiteit");
            System.out.println("3: Creëer routine");
            System.out.println("4: Verwijder activiteit");
            System.out.println("0: Vorige scherm");
            optionA = scanner.nextInt();
            switch (optionA){
                case 0:
                    break;
                case 1:
                    printActiviteiten();
                    break;
                case 2:
                    System.out.println("Naam van activiteit");
                    scanner.nextLine();
                    String naam = scanner.nextLine();
                    System.out.println("Duratie van activiteit");
                    int duratie = scanner.nextInt();
                    Image a = null;
                    createActiviteit(naam,duratie,a);
                    break;
                case 3:
                    System.out.println("Naam van activiteit");
                    scanner.nextLine();
                    naam = scanner.nextLine();
                    System.out.println("Duratie van activiteit");
                    duratie = scanner.nextInt();
                    a = null;
                    System.out.println("Vaste tijd van activiteit");
                    int vasteTijd = scanner.nextInt();
                    createRoutine(naam,duratie,a,vasteTijd);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Probeer het opnieuw");
                    break;
            }
        }
    }

    public void printActiviteiten(){
        for (Activiteit activiteit : activiteitenLijst) {
            System.out.println("Activiteit: " + activiteit.getNaam());
            System.out.println("Duratie: " + activiteit.getDuratie());
            if (activiteit instanceof Routine){
                System.out.println("Routine tijd: " + ((Routine) activiteit).getVasteTijd());
            }
            System.out.println();
        }
    }

    public void createActiviteit(String naam, int duratie, Image afbeelding){
        NormaalActiviteit activiteit = new NormaalActiviteit();
        activiteit.setNaam(naam);
        activiteit.setDuratie(duratie);
        activiteit.setAfbeelding(afbeelding);
        activiteitenLijst.add(activiteit);
    }

    public void createRoutine(String naam, int duratie, Image afbeelding, int vasteTijd){
        Routine activiteit = new Routine();
        activiteit.setNaam(naam);
        activiteit.setDuratie(duratie);
        activiteit.setAfbeelding(afbeelding);
        activiteit.setVasteTijd(vasteTijd);
        activiteitenLijst.add(activiteit);
    }

    public void deleteActiviteit(Activiteit activiteit){
        activiteitenLijst.remove(activiteit);

    }
}
