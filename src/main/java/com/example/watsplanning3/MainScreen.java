package com.example.watsplanning3;

import java.time.LocalTime;
import java.util.Scanner;

public class MainScreen implements Optie {

    ActiviteitManager activiteitManager = new ActiviteitManager();
    Planner customPlanner = new CustomPlanner();
    Planner randomPlanner = new RandomPlanner();
    Planning planning = new Planning();

    MainScreen(){
        Scanner scanner = new Scanner(System.in);
        chooseOptie(scanner);
    }

    @Override
    public void chooseOptie(Scanner scanner){
        int option = 1;
        while(option != 0){
            System.out.println("Kies een optie:");
            System.out.println("1: Activiteit aanmaken");
            System.out.println("2: Planning maken");
            System.out.println("3: Random planning maken");
            System.out.println("4: Planning bekijken");
            System.out.println("0: Stoppen");
            option = scanner.nextInt();
            if (option == 0) {
                System.out.println("Dag");
                break;
            } else if (option == 1) {
                activiteitManager.chooseOptie(scanner);
            } else if (option == 2) {
                customPlanner.chooseOptie(scanner);
            } else if (option == 3) {
                randomPlanner.chooseOptie(scanner);
            } else if (option == 4) {
                LocalTime time = LocalTime.now();
                planning.setTijd(time.getHour() * 100 + time.getMinute());
                planning.chooseOptie(scanner);
            } else {
                System.out.println("Ongeldige optie");
            }
        }
    }
}
