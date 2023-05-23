package com.example.watsplanning3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DagTest {

    @Test
    void checkMoment() {

        // arrange

        Dag dag = new Dag();
        ArrayList<Activiteit> activiteitenLijst = ActiviteitenLijst.getInstance().getActiviteitenLijst();
        Activiteit activiteitB = activiteitenLijst.get(0);

        NormaalActiviteit activiteit = new NormaalActiviteit();
        activiteit.setNaam("Dota 2");
        activiteit.setDuratie(60);

        Moment momentA = new Moment();
        Moment momentB = new Moment();
        Moment momentC = new Moment();
        Moment momentD = new Moment();

        Tijd tijdA = new Tijd(1230);
        Tijd tijdD = new Tijd(1500);

        // act

        momentA.setActiviteit(activiteitB);
        momentA.setBeginTijd(new Tijd(1300));
        momentA.setEindTijd(new Tijd(1300));

        momentB.setActiviteit(activiteitB);
        momentB.setBeginTijd(tijdD);
        momentB.setEindTijd(tijdD);

        momentC.setActiviteit(activiteitB);
        momentC.setBeginTijd(new Tijd(23455));
        momentC.setEindTijd(new Tijd(34545));

        momentD.setActiviteit(activiteit);
        momentD.setBeginTijd(new Tijd(1000));
        momentD.setEindTijd(new Tijd(1000));

        dag.addMoment(tijdA,activiteitB);

        // assert

        assertFalse(dag.checkMoment(momentA));
        assertTrue(dag.checkMoment(momentB));
        assertFalse(dag.checkMoment(momentC));
        assertFalse(dag.checkMoment(momentD));
    }
}