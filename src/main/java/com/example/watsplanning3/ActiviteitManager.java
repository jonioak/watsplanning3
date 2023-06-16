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
            System.out.println("3: Verwijder activiteit");
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
                    System.out.println("Wat voor soort activiteit is het?\n0: Vorige scherm");
                    int i = 1;
                    for (Activiteit activiteit : ActiviteitenLijst.getInstance().getCategorien()){
                        System.out.println(i+ ": " + activiteit.getCategorie());
                        i++;
                    }
                    int categorie;
                    while(i!=0){
                        categorie = scanner.nextInt();
                        switch (categorie){
                            case 0:
                                i = 0;
                                break;
                            case 1:

                        }

                        break;
                    }
                    if(i==0)break;



                    System.out.println("Duratie van activiteit in minuten");
                    int duratie = scanner.nextInt();
                    Image a = null;
                    System.out.println("Wil je het een routine maken? \nZo ja, hoe laat wil je dat het begint?\nZo niet, toets 0");
                    while(true){
                        Tijd vasteTijd = new Tijd(scanner.nextInt());
                        if(vasteTijd.getMinuut() < 59 && vasteTijd.getUur() < 23){
                            createActiviteit(naam,duratie,a,vasteTijd);
                            break;
                        }
                        if(vasteTijd.getTijd()==0){
                            createActiviteit(naam,duratie,a,null);
                            break;
                        }
                        System.out.println("Ongeldig tijdstip");
                    }
                    break;
                case 3:
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

    public void createActiviteit(String naam, int duratie, Image afbeelding, Tijd vasteTijd){
        Activiteit activiteit = new NormaalActiviteit(vasteTijd);
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
