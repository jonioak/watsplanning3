package com.example.watsplanning3;

public class Tijd
{
    private int uur;
    private int minuut;
    Tijd(int tijd){
        this.uur = tijd / 100;
        this.minuut = tijd % 100;
    }
    Tijd(int uur, int minuut){
        this.uur = uur;
        this.minuut = minuut;
    }

    public Tijd tijdDuratie(int duratie){
        Tijd eindTijd = new Tijd(0);
        if(minuut+duratie>59){
            int uren = (minuut+duratie) / 60;
            eindTijd.setMinuut(minuut+duratie-uren*60);
            eindTijd.setUur(uur + uren);
            if(eindTijd.getUur()>23){
                eindTijd.setUur(eindTijd.getUur()-24);
            }
        }
        else{
            eindTijd.setMinuut(minuut+duratie);
            eindTijd.setUur(uur);
        }
        return eindTijd;
    }

    public int getUur()
    {
        return uur;
    }

    public void setUur(int uur){
        this.uur = uur;
    }

    public int getTijd(){
        return uur * 100 + minuut;
    }

    public String getTijdString(){
        return String.format("%02d", uur) + ":" + String.format("%02d",minuut);
    }

    public int getMinuut()
    {
        return minuut;
    }

    public void setMinuut(int minuut) {
        this.minuut = minuut;
    }
}
