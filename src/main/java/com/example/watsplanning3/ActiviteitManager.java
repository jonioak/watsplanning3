package com.example.watsplanning3;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Scanner;

public class ActiviteitManager implements Optie{

    @Override
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
                    ActiviteitenLijst.getInstance().printActiviteiten();
                    break;
                case 2:
                    System.out.println("Naam van activiteit");
                    scanner.nextLine();
                    String naam = scanner.nextLine();
                    System.out.println("Duratie van activiteit in minuten");
                    int duratie = scanner.nextInt();
                    Image a = null;
                    createActiviteit(naam,duratie,a);
                    break;
                case 3:
                    System.out.println("Naam van activiteit");
                    scanner.nextLine();
                    naam = scanner.nextLine();
                    System.out.println("Duratie van activiteit in minuten");
                    duratie = scanner.nextInt();
                    a = null;
                    System.out.println("Vaste tijd van activiteit");
                    while(true){
                        Tijd vasteTijd = new Tijd(scanner.nextInt());
                        if(vasteTijd.getMinuut() < 59 && vasteTijd.getUur() < 23){
                            createRoutine(naam,duratie,a,vasteTijd);
                            break;
                        }
                        System.out.println("Ongeldig tijdstip");
                    }

                    break;
                case 4:
                    System.out.println("Selecteer een activeit om te verwijderen");
                    ActiviteitenLijst.getInstance().printActiviteiten();
                    int activiteit = scanner.nextInt();
                    deleteActiviteit(activiteit);
                    break;
                default:
                    System.out.println("Probeer het opnieuw");
                    break;
            }
        }
    }



    public void createActiviteit(String naam, int duratie, Image afbeelding){
        NormaalActiviteit activiteit = new NormaalActiviteit();
        activiteit.setNaam(naam);
        activiteit.setDuratie(duratie);
        activiteit.setAfbeelding(afbeelding);
        ActiviteitenLijst.getInstance().getActiviteitenLijst().add(activiteit);
    }

    public void createRoutine(String naam, int duratie, Image afbeelding, Tijd vasteTijd){
        Routine activiteit = new Routine();
        activiteit.setNaam(naam);
        activiteit.setDuratie(duratie);
        activiteit.setAfbeelding(afbeelding);

        activiteit.setVasteTijd(vasteTijd);
        ActiviteitenLijst.getInstance().getActiviteitenLijst().add(activiteit);
    }


    public void deleteActiviteit(int activiteit){
        if (activiteit <= ActiviteitenLijst.getInstance().getActiviteitenLijst().size()){
            System.out.println(ActiviteitenLijst.getInstance().getActiviteitenLijst().get(activiteit-1).getNaam() + " is verwijderd");
            ActiviteitenLijst.getInstance().getActiviteitenLijst().remove(activiteit-1);
        }
        else{
            System.out.println("Ongeldige invoer");
        }
    }
}
