package modele;

/**
 * Abstraction dont dépend Robot (Dependency Inversion) :
 * Robot ne connaît pas Grille, seulement ce contrat.
 */
public interface Terrain {
    boolean contient(int x, int y);

    Case getCase(int x, int y);
}
