package com.example.watsplanning3;
import java.time.LocalTime;
import java.util.*;

public class MainScreen implements Optie{
    ActiviteitManager activiteitManager = new ActiviteitManager();
    CustomPlanner customPlanner = new CustomPlanner();

    MainScreen(){
        Scanner scanner = new Scanner(System.in);
        chooseOptie(scanner);
    }

    @Override
    public void chooseOptie(Scanner scanner){
        int option = 1;
        while(option!=0){
            System.out.println("Kies een optie:");
            System.out.println("1: Activiteit aanmaken");
            System.out.println("2: Planning maken");
            System.out.println("3: Random planning maken");
            System.out.println("4: Planning bekijken");
            System.out.println("0: Stoppen");
            option = scanner.nextInt();
            switch (option){
                case 0:
                    System.out.println("Dag");
                    break;
                case 1:
                    activiteitManager.chooseOptie(scanner);
                    break;
                case 2:
                    customPlanner.chooseOptie(scanner);
                    break;
                case 3:
                    System.out.println("Kan nog niet");
                    break;
                case 4:
                    LocalTime time = LocalTime.now();
                    Planning.getInstance().setTijd(time.getHour()*100+time.getMinute());
                    Planning.getInstance().chooseOptie(scanner);
                    break;
                default:
                    System.out.println("Ongeldige optie");
                    break;
            }
        }
    }
}
