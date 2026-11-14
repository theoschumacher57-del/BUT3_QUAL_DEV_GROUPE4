package vue;

import modele.Case;
import modele.Grille;
import modele.Robot;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/** Vue : dessine la grille et le robot. Ne modifie jamais le modèle. */
public class GrillePanel extends JPanel {
    private static final int TAILLE_CASE = 80;

    private final Grille grille;
    private final Robot robot;

    public GrillePanel(Grille grille, Robot robot) {
        this.grille = grille;
        this.robot = robot;
        setPreferredSize(new Dimension(
                grille.getNbColonnes() * TAILLE_CASE,
                grille.getNbLignes() * TAILLE_CASE));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Cases (damier)
        for (int y = 0; y < grille.getNbLignes(); y++) {
            for (int x = 0; x < grille.getNbColonnes(); x++) {
                g2.setColor((x + y) % 2 == 0 ? new Color(235, 235, 235) : new Color(210, 220, 235));
                g2.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
                g2.setColor(Color.GRAY);
                g2.drawRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
            }
        }

        // Robot
        Case c = robot.getPosition();
        int marge = 12;
        int px = c.getX() * TAILLE_CASE + marge;
        int py = c.getY() * TAILLE_CASE + marge;
        int d = TAILLE_CASE - 2 * marge;
        g2.setColor(new Color(60, 151, 220));
        g2.fillOval(px, py, d, d);
        g2.setColor(Color.WHITE);
        FontMetrics fm = g2.getFontMetrics();
        String nom = robot.getMarque();
        g2.drawString(nom,
                px + (d - fm.stringWidth(nom)) / 2,
                py + (d + fm.getAscent()) / 2 - 2);
    }
}