package com.example.watsplanning3;

public class Moment {
    private Activiteit activiteit;
    private int beginTijd;
    private int eindTijd;

    public void setActiviteit(Activiteit activiteit){
        this.activiteit = activiteit;
    }

    public int getBeginTijd() {
        return beginTijd;
    }
    public void setBeginTijd(int beginTijd){
        this.beginTijd = beginTijd;
        this.eindTijd = beginTijd + activiteit.getDuratie();
    }

    public int getEindTijd() {
        return eindTijd;
    }
    public void setEindTijd(int eindTijd){
        this.eindTijd = eindTijd;
    }
}
