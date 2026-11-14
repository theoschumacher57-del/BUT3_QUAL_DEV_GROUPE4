package modele;

/** Grille de cases. Seule responsabilité : connaître ses dimensions et ses cases. */
public class Grille implements Terrain {
    private final int nbLignes;
    private final int nbColonnes;
    private final Case[][] cases;

    public Grille(int nbLignes, int nbColonnes) {
        if (nbLignes <= 0 || nbColonnes <= 0) {
            throw new IllegalArgumentException("Les dimensions de la grille doivent être strictement positives");
        }
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.cases = new Case[nbLignes][nbColonnes];
        for (int y = 0; y < nbLignes; y++) {
            for (int x = 0; x < nbColonnes; x++) {
                cases[y][x] = new Case(x, y);
            }
        }
    }

    public int getNbLignes() {
        return nbLignes;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    @Override
    public boolean contient(int x, int y) {
        return x >= 0 && x < nbColonnes && y >= 0 && y < nbLignes;
    }

    @Override
    public Case getCase(int x, int y) {
        if (!contient(x, y)) {
            throw new IllegalArgumentException("Case hors de la grille : (" + x + ", " + y + ")");
        }
        return cases[y][x];
    }
}
