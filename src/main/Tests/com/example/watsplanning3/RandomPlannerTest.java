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
        Tijd TestB = new Tijd(2300);
        Tijd Test1 = new Tijd (0);
        Tijd Test2 = new Tijd (2230);


        NormaalActiviteit activiteit = new NormaalActiviteit();
        activiteit.setNaam("Test1");
        activiteit.setDuratie(30);

        Routine routine = new Routine();
        routine.setNaam("Test2");
        routine.setDuratie(60);
        int vasteTijd = 2000;
        routine.setVasteTijd(new Tijd(vasteTijd));

        // act

        assertTrue(planner.generateDag(TestA,TestB));

        ActiviteitenLijst.getInstance().getActiviteitenLijst().add(activiteit);
        ActiviteitenLijst.getInstance().getActiviteitenLijst().add(routine);

        //assert

        assertFalse(planner.generateDag(TestA,TestB));

        // routine test
        assertEquals(vasteTijd,DagLijst.getInstance().getDagLijst().get(0).getMomenten().get(DagLijst.getInstance().getDagLijst().get(0).getMomenten().size()-1).getBeginTijd().getTijd());

        assertEquals(new Date(time.getYear(),time.getMonthValue(),time.getDayOfMonth()),DagLijst.getInstance().getDagLijst().get(0).getDatum());


        assertFalse(planner.generateDag(TestA,TestB));
        time = time.plusDays(1);
        assertEquals(new Date(time.getYear(),time.getMonthValue(),time.getDayOfMonth()),DagLijst.getInstance().getDagLijst().get(1).getDatum());


        assertFalse(planner.generateDag(TestA,TestB));
        assertTrue(planner.generateDag(TestA, Test1));
        assertTrue(planner.generateDag(Test2, TestB));


    }

}