package com.example.watsplanning3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanningTest {

    @Test
    void tijdTotMoment() {

        // arrange
        Planning planning = new Planning();

        Dag dagA = new Dag();
        Dag dagB = new Dag();
        Dag dagC = new Dag();

        int tijd = 0000;

        // act
        dagA.addMoment(new Tijd(0023),ActiviteitenLijst.getInstance().getActiviteitenLijst().get(0));
        dagB.addMoment(new Tijd(0100),ActiviteitenLijst.getInstance().getActiviteitenLijst().get(0));
        dagC.addMoment(new Tijd(0200),ActiviteitenLijst.getInstance().getActiviteitenLijst().get(0));

        // assert
        assertEquals(planning.tijdTotMoment(dagA,tijd), 1);
        assertEquals(planning.tijdTotMoment(dagB,tijd), 3);
        assertEquals(planning.tijdTotMoment(dagC,tijd), 3);

    }
}