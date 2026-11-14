package modele;

/** Robot posé sur un terrain. Responsabilité : connaître sa case et se déplacer. */
public class Robot {
    private final String marque;
    private final Terrain terrain;
    private Case position;

    public Robot(String marque, Terrain terrain, int x, int y) {
        this.marque = marque;
        this.terrain = terrain;
        this.position = terrain.getCase(x, y); // lève une exception si hors grille
    }

    /**
     * Déplace le robot d'une case.
     * @return true si le déplacement a eu lieu, false s'il sortirait de la grille (le robot ne bouge pas)
     */
    public boolean deplacer(Deplacement deplacement) {
        int nx = position.getX() + deplacement.getDx();
        int ny = position.getY() + deplacement.getDy();
        if (!terrain.contient(nx, ny)) {
            return false;
        }
        position = terrain.getCase(nx, ny);
        return true;
    }

    public Case getPosition() {
        return position;
    }

    public String getMarque() {
        return marque;
    }
}
