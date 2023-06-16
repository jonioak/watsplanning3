package com.example.watsplanning3;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RandomPlannerTest {
    @Test
    void testGenerateDag()
    {
        // arrange
        RandomPlanner planner = new RandomPlanner();

        ArrayList<Dag> dagLijst = new ArrayList<>(DagLijst.getInstance().getDagLijst());
        for(Dag d : DagLijst.getInstance().getDagLijst()){
            d.getMomenten().clear();
        }
        DagLijst.getInstance().getDagLijst().clear();

        ArrayList<Activiteit> activiteitenLijst = new ArrayList<>(ActiviteitenLijst.getInstance().getActiviteitenLijst());
        for (Activiteit a : activiteitenLijst){
            ActiviteitenLijst.getInstance().getActiviteitenLijst().remove(a);
        }

        LocalDate time = LocalDate.now().plusDays(1);
        Dag dag = new Dag();
        dag.setDatum(new Date(time.getYear(),time.getMonthValue(),time.getDayOfMonth()));


        Tijd TestA = new Tijd(1000);
        Tijd TestAA = new Tijd(2000);

        Tijd TestB1 = new Tijd (1800);
        Tijd TestB2 = new Tijd (1100);
        Tijd TestB3 = new Tijd (1500);

        Tijd TestE1 = new Tijd (1130);
        Tijd TestE2 = new Tijd (1830);


        NormaalActiviteit activiteit = new NormaalActiviteit();
        activiteit.setNaam("Test1");
        activiteit.setDuratie(30);

        Routine routine = new Routine();
        routine.setNaam("Test2");
        routine.setDuratie(60);
        int vasteTijd = 2000;
        routine.setVasteTijd(new Tijd(vasteTijd));


        // Leeg activiteitlijst
        // #1:
        planner.generateDag(TestA,TestAA);
        assertTrue(planner.generateDag(TestB1,TestE1));
        DagLijst.getInstance().getDagLijst().clear();

        // #4:
        assertTrue(planner.generateDag(TestB2,TestE1));

        // #5:
        planner.generateDag(TestA,TestAA);
        assertTrue(planner.generateDag(TestB3,TestE1));
        DagLijst.getInstance().getDagLijst().clear();


        // Met activiteit en routine
        ActiviteitenLijst.getInstance().getActiviteitenLijst().add(activiteit);
        ActiviteitenLijst.getInstance().getActiviteitenLijst().add(routine);

        // #2:
        assertTrue(planner.generateDag(TestB1,TestE2));

        // #3:
        planner.generateDag(TestA,TestAA);
        planner.generateDag(TestB2,TestE2);
        assertNotEquals(new Date(time.getYear(),time.getMonthValue(),time.getDayOfMonth()),DagLijst.getInstance().getDagLijst().get(1).getDatum());
        DagLijst.getInstance().getDagLijst().clear();


        //assertEquals(vasteTijd,DagLijst.getInstance().getDagLijst().get(0).getMomenten().get(DagLijst.getInstance().getDagLijst().get(0).getMomenten().size()-1).getBeginTijd().getTijd());
        //assertNotEquals(vasteTijd,DagLijst.getInstance().getDagLijst().get(0).getMomenten().get(0).getBeginTijd().getTijd());


        // #6:
        // Datum
        planner.generateDag(TestB3,TestE2);
        assertEquals(new Date(time.getYear(),time.getMonthValue(),time.getDayOfMonth()),DagLijst.getInstance().getDagLijst().get(0).getDatum());



        //assertFalse(planner.generateDag(TestA,TestB));
        //time = time.plusDays(1);
        //assertEquals(new Date(time.getYear(),time.getMonthValue(),time.getDayOfMonth()),DagLijst.getInstance().getDagLijst().get(1).getDatum());

        // Tijd tussen begin en eind tijd
//        assertFalse(planner.generateDag(TestA,TestB));
//        assertTrue(planner.generateDag(TestA, Test1));
//        assertTrue(planner.generateDag(Test2, TestB));


    }

}