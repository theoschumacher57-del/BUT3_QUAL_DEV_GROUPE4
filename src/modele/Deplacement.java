package modele;

/**
 * Directions possibles. Chaque direction porte son propre décalage (dx, dy) :
 * ajouter une direction (ex. diagonale) ne demande aucune modification de Robot (Open/Closed).
 */
public enum Deplacement {
    HAUT(0, -1),
    BAS(0, 1),
    GAUCHE(-1, 0),
    DROITE(1, 0);

    private final int dx;
    private final int dy;

    Deplacement(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
