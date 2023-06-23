package com.example.watsplanning3;

public class TijdMaker {
    private int minuut;
    private int uur;
    private Tijd tijd;
    TijdMaker(int tijd){
        this.uur = tijd / 100;
        this.minuut = tijd % 100;
    }

    public boolean checkTijd(){
        if((minuut>59 || uur > 23) || (minuut < 0 || uur < 0)){
            System.out.println("Ongeldige tijd");
            return false;
        }
        this.tijd = new Tijd(uur,minuut);
        return true;
    }

    public Tijd getTijd() {
        return tijd;
    }
}
