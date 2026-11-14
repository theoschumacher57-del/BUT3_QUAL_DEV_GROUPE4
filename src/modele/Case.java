package modele;

import java.util.Objects;

/** Une case de la grille : immuable, identifiée par ses coordonnées. */
public final class Case {
    private final int x;
    private final int y;

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Case)) return false;
        Case autre = (Case) o;
        return x == autre.x && y == autre.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
