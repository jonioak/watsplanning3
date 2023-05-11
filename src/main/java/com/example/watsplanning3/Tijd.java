package com.example.watsplanning3;

public class Tijd
{
    private int uur;
    private int minuut;
    Tijd(int tijd){
        this.uur = tijd / 100;
        this.minuut = tijd % 100;
        if(minuut>60){
            minuut-=60;
            if(uur<24){
                uur+=1;
            }
        }

    }

    public Tijd tijdDuratie(Tijd tijd, int duratie){

        return tijd;
    }

    public int getUur()
    {
        return uur;
    }

    public int getMinuut()
    {
        return minuut;
    }
}
