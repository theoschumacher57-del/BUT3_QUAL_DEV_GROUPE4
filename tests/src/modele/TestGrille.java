package modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestGrille {

    @Test
    void initialisationDesDimensions() {
        Grille grille = new Grille(3, 4);
        assertEquals(3, grille.getNbLignes());
        assertEquals(4, grille.getNbColonnes());
    }

    @Test
    void dimensionsInvalides() {
        assertThrows(IllegalArgumentException.class, () -> new Grille(0, 5));
        assertThrows(IllegalArgumentException.class, () -> new Grille(5, -1));
    }

    @Test
    void contientVerifieLesBornes() {
        Grille grille = new Grille(3, 4);
        assertTrue(grille.contient(0, 0));
        assertTrue(grille.contient(3, 2));
        assertFalse(grille.contient(4, 0));
        assertFalse(grille.contient(0, 3));
        assertFalse(grille.contient(-1, 0));
    }

    @Test
    void getCaseHorsGrille() {
        assertThrows(IllegalArgumentException.class, () -> new Grille(3, 3).getCase(3, 3));
    }
}
