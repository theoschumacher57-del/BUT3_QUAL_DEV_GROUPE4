package modele;

import enumerations.EDirection;
import exceptions.DeplacementException;
import org.junit.Assert;
import org.junit.Test;
import service.RobotManager;

import static enumerations.EDeplacement.*;
import static enumerations.EDeplacement.D;
import static enumerations.EDirection.EAST;
import static enumerations.EDirection.NORTH;
import static org.junit.Assert.assertEquals;

public class TestTondeuse {

    private RobotManager manager;

    @Test
    public void testDeplacementTondeuse() throws DeplacementException {
        Tondeuse tondeuse = new Tondeuse(5, 5, 1, 2, NORTH);
        manager = new RobotManager(tondeuse);
        manager.deplacement(G);
        manager.deplacement(A);
        manager.deplacement(G);
        manager.deplacement(A);
        manager.deplacement(G);
        manager.deplacement(A);
        manager.deplacement(G);
        manager.deplacement(A);
        manager.deplacement(A);
        assertEquals(1, tondeuse.getCaseFinale().getX());
        assertEquals(1, tondeuse.getCaseFinale().getY());
        assertEquals(NORTH, tondeuse.getSens());
    }

    @Test
    public void testUnAutreDeplacementTondeuse() throws DeplacementException {
        Tondeuse tondeuse = new Tondeuse(5, 5, 3, 3, EAST);
        manager = new RobotManager(tondeuse);
        manager.deplacement(A);
        manager.deplacement(A);
        manager.deplacement(D);
        manager.deplacement(A);
        manager.deplacement(A);
        manager.deplacement(D);
        manager.deplacement(A);
        manager.deplacement(D);
        manager.deplacement(D);
        manager.deplacement(A);
        assertEquals(5, tondeuse.getCaseFinale().getX());
        assertEquals(5, tondeuse.getCaseFinale().getY());
        assertEquals(EAST, tondeuse.getSens());
    }

}
