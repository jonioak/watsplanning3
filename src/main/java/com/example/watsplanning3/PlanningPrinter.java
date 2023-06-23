package com.example.watsplanning3;

public class PlanningPrinter {

    public void printPlanning(Dag dag){
        String[]planning = new String[24*4];
        int j;
        // Gaat langs alle momenten van de gekozen dag
        for (int i=0; i<dag.getMomenten().size(); i++){
            j=0;
            // Om elke 15 minuten van de dag tijd + activiteit
            for (int uur = 0; uur < 24; uur++) {
                for (int minuut = 0; minuut < 60; minuut += 15) {
                    // Checkt of tijd valt binnen het moment
                    if(momentCheck(uur,minuut,dag.getMomenten().get(i))){
                        planning[j]=String.format("%02d:%02d ", uur, minuut) + dag.getMomenten().get(i).getActiviteit().getNaam();
                    }
                    j++;
                }
            }
        }
        // Resterende tijd zonder moment
        j=0;
        for (int uur = 0; uur < 24; uur++)
        {
            for (int minuut = 0; minuut < 60; minuut += 15)
            {
                if(planning[j]==null){
                    planning[j]=String.format("%02d:%02d ", uur, minuut);
                }
                j++;
            }
        }
        for (j=0; j<planning.length; j++){
            System.out.println(planning[j]);
        }
    }

    public boolean momentCheck(int uur, int minuut, Moment moment){
        Tijd tijd = new Tijd(uur,minuut);
        if(moment.getBeginTijd().getTijd() >= tijd.getTijd() && moment.getBeginTijd().getTijd() <= tijd.getTijd()){
            return true;
        }
        if(moment.getBeginTijd().getTijd()<tijd.getTijd() && moment.getEindTijd().getTijd()>tijd.getTijd()){
            return true;
        }
        if(moment.getEindTijd().getTijd() >= tijd.getTijd() && moment.getEindTijd().getTijd() <= tijd.getTijd()){
            return true;
        }
        return false;
    }
}