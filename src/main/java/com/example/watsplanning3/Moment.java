package com.example.watsplanning3;

public class Moment {
    private Activiteit activiteit;
    private Tijd beginTijd;
    private Tijd eindTijd;

    public Activiteit getActiviteit(){
        return activiteit;
    }
    public void setActiviteit(Activiteit activiteit){
        this.activiteit = activiteit;
    }

    public Tijd getBeginTijd() {
        return beginTijd;
    }
    public void setBeginTijd(Tijd beginTijd){
        this.beginTijd = beginTijd;
    }

    public Tijd getEindTijd() {
        return eindTijd;
    }
    public void setEindTijd(Tijd beginTijd){
        this.eindTijd = beginTijd.tijdDuratie(activiteit.getDuratie());
    }
}
