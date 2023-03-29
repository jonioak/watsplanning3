package com.example.watsplanning3;

public class Moment {
    private Activiteit activiteit;
    private int beginTijd;
    private int eindTijd;

    public int getBeginTijd() {
        return beginTijd;
    }
    public void setBeginTijd(int beginTijd){
        this.beginTijd = beginTijd;
    }

    public int getEindTijd() {
        return eindTijd;
    }
    public void setEindTijd(int eindTijd){
        this.eindTijd = eindTijd;
    }
}
