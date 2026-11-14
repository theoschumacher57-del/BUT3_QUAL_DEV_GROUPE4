package vue;

import modele.Deplacement;
import modele.Grille;
import modele.Robot;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/** Fenêtre : relie les touches du clavier aux déplacements du robot. */
public class FenetreRobot extends JFrame {
    private final Robot robot;
    private final GrillePanel panneau;
    private final JLabel statut = new JLabel();

    public FenetreRobot(Grille grille, Robot robot) {
        super("Robot");
        this.robot = robot;
        this.panneau = new GrillePanel(grille, robot);

        add(panneau, BorderLayout.CENTER);
        add(statut, BorderLayout.SOUTH);
        majStatut("Flèches ou ZQSD pour déplacer le robot");

        // Flèches + ZQSD (clavier AZERTY)
        associer(KeyEvent.VK_UP, Deplacement.HAUT);
        associer(KeyEvent.VK_Z, Deplacement.HAUT);
        associer(KeyEvent.VK_DOWN, Deplacement.BAS);
        associer(KeyEvent.VK_S, Deplacement.BAS);
        associer(KeyEvent.VK_LEFT, Deplacement.GAUCHE);
        associer(KeyEvent.VK_Q, Deplacement.GAUCHE);
        associer(KeyEvent.VK_RIGHT, Deplacement.DROITE);
        associer(KeyEvent.VK_D, Deplacement.DROITE);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void associer(int touche, Deplacement deplacement) {
        String nom = deplacement + "-" + touche;
        panneau.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(touche, 0), nom);
        panneau.getActionMap().put(nom, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean ok = robot.deplacer(deplacement);
                majStatut(ok ? "Position : " + robot.getPosition()
                        : "Déplacement impossible : bord de la grille");
                panneau.repaint();
            }
        });
    }

    private void majStatut(String texte) {
        statut.setText(" " + texte);
    }
}