package com.example.watsplanning3;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Scanner;

public class ActiviteitManager implements Optie{

    @Override
    public void chooseOptie(Scanner scanner){
        int optionA = 1;
        while(optionA != 0) {
            System.out.println("Kies een optie:");
            System.out.println("1: Bekijk alle activiteiten");
            System.out.println("2: Creëer activiteit");
            System.out.println("3: Verwijder activiteit");
            System.out.println("0: Vorige scherm");
            optionA = scanner.nextInt();
            if (optionA == 0) {
                break;
            } else if (optionA == 1) {
                ActiviteitenLijst.getInstance().printActiviteiten();
            } else if (optionA == 2) {
                createActiviteit(scanner);
            } else if (optionA == 3) {
                System.out.println("Selecteer een activiteit om te verwijderen");
                ActiviteitenLijst.getInstance().printActiviteiten();
                int activiteit = scanner.nextInt();
                deleteActiviteit(activiteit);
            } else {
                System.out.println("Probeer het opnieuw");
            }
        }
    }

    public void createActiviteit(Scanner scanner){
        System.out.println("Naam van activiteit");
        scanner.nextLine();
        String naam = scanner.nextLine();
        System.out.println("Wat voor soort activiteit is het?");
        int i = 1;
        for (Activiteit activiteit : ActiviteitenLijst.getInstance().getCategorien()){
            System.out.println(i+ ": " + activiteit.getCategorie());
            i++;
        }
        i=-1;
        int categorie = 0;
        System.out.println("0: Vorige scherm");
        while(i==-1){
            categorie = scanner.nextInt();
            if (categorie == 0) {
                i = 0;
            } else if (categorie == 1 || categorie == 2) {
                i = 1;
            } else {
                System.out.println("Ongeldig soort activiteit");
            }
        }
        if (i == 0) {
        }
        else {
            System.out.println("Duratie van activiteit in minuten");
            int duratie = scanner.nextInt();
            System.out.println("Wil je het een routine maken? \nZo ja, hoe laat wil je dat het begint?\nZo niet, toets 0");
            while(true){
                TijdMaker vasteTijd = new TijdMaker(scanner.nextInt());
                if(vasteTijd.checkTijd()){
                    createFactory(categorie, naam, duratie, null,vasteTijd.getTijd());
                    break;
                }
            }
        }
    }

    public void createFactory(int categorie, String naam, int duratie, Image afbeelding, Tijd vasteTijd){
        if(categorie == 1){
            ActiviteitFactory factory = new NormaalActiviteitFactory();
            ActiviteitenLijst.getInstance().getActiviteitenLijst().add(factory.maakActiviteit(naam, duratie, afbeelding, vasteTijd));
        }
        else if(categorie == 2){
            ActiviteitFactory factory = new SportActiviteitFactory();
            ActiviteitenLijst.getInstance().getActiviteitenLijst().add(factory.maakActiviteit(naam, duratie, afbeelding, vasteTijd));
        }
    }

    public void deleteActiviteit(int activiteit){
        if (activiteit <= ActiviteitenLijst.getInstance().getActiviteitenLijst().size() && activiteit > 0 ){
            System.out.println(ActiviteitenLijst.getInstance().getActiviteitenLijst().get(activiteit-1).getNaam() + " is verwijderd");
            ActiviteitenLijst.getInstance().getActiviteitenLijst().remove(activiteit-1);
        }
        else{
            System.out.println("Ongeldige invoer");
        }
    }
}
