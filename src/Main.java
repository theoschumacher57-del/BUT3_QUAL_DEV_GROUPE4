import modele.Grille;
import modele.Robot;
import vue.FenetreRobot;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Grille grille = new Grille(6, 8);
        Robot robot = new Robot("Robot", grille, 3, 3);

        SwingUtilities.invokeLater(() -> new FenetreRobot(grille, robot).setVisible(true));
    }
}