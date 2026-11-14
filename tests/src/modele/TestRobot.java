package modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestRobot {
    private Grille grille;
    private Robot robot;

    @BeforeEach
    void setUp() {
        grille = new Grille(5, 5);
        robot = new Robot("R2D2", grille, 2, 2);
    }

    @Test
    void placementInitial() {
        assertEquals(new Case(2, 2), robot.getPosition());
    }

    @Test
    void placementHorsGrille() {
        assertThrows(IllegalArgumentException.class, () -> new Robot("X", grille, 5, 0));
    }

    @Test
    void deplacementHaut() {
        assertTrue(robot.deplacer(Deplacement.HAUT));
        assertEquals(new Case(2, 1), robot.getPosition());
    }

    @Test
    void deplacementBas() {
        assertTrue(robot.deplacer(Deplacement.BAS));
        assertEquals(new Case(2, 3), robot.getPosition());
    }

    @Test
    void deplacementGauche() {
        assertTrue(robot.deplacer(Deplacement.GAUCHE));
        assertEquals(new Case(1, 2), robot.getPosition());
    }

    @Test
    void deplacementDroite() {
        assertTrue(robot.deplacer(Deplacement.DROITE));
        assertEquals(new Case(3, 2), robot.getPosition());
    }

    @Test
    void robotNeSortPasDeLaGrille() {
        Robot coin = new Robot("Coin", grille, 0, 0);
        assertFalse(coin.deplacer(Deplacement.HAUT));
        assertFalse(coin.deplacer(Deplacement.GAUCHE));
        assertEquals(new Case(0, 0), coin.getPosition());

        Robot autreCoin = new Robot("Coin2", grille, 4, 4);
        assertFalse(autreCoin.deplacer(Deplacement.BAS));
        assertFalse(autreCoin.deplacer(Deplacement.DROITE));
        assertEquals(new Case(4, 4), autreCoin.getPosition());
    }

    @Test
    void enchainementDeDeplacements() {
        robot.deplacer(Deplacement.HAUT);
        robot.deplacer(Deplacement.DROITE);
        robot.deplacer(Deplacement.BAS);
        assertEquals(new Case(3, 2), robot.getPosition());
    }
}
