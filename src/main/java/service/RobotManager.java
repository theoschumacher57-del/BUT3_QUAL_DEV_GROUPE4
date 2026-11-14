package service;

import enumerations.EDeplacement;
import exceptions.DeplacementException;
import interfaces.IRobot;

import static enumerations.EDirection.EAST;
import static enumerations.EDirection.NORTH;
import static enumerations.EDirection.SOUTH;
import static enumerations.EDirection.WEST;

public class RobotManager {

    private IRobot tondeuse;

    public RobotManager(IRobot tondeuse) {
        this.tondeuse = tondeuse;
    }

    public void deplacement(EDeplacement deplacement) throws DeplacementException {
        switch (deplacement) {
            case A:
                deplacerEnAvant();
                break;
            case D:
                deplacerADroite();
                break;
            case G:
                deplacerAGauche();
                break;
            default:
                break;
        }
    }

    private void deplacerADroite() {
        switch (this.tondeuse.getSens()) {
            case NORTH:
                this.tondeuse.setSens(EAST);
                break;
            case EAST:
                this.tondeuse.setSens(SOUTH);
                break;
            case WEST:
                this.tondeuse.setSens(NORTH);
                break;
            case SOUTH:
                this.tondeuse.setSens(WEST);
                break;
            default:
                break;
        }
    }

    private void deplacerAGauche() {
        switch (this.tondeuse.getSens()) {
            case NORTH:
                this.tondeuse.setSens(WEST);
                break;
            case EAST:
                this.tondeuse.setSens(NORTH);
                break;
            case WEST:
                this.tondeuse.setSens(SOUTH);
                break;
            case SOUTH:
                this.tondeuse.setSens(EAST);
                break;
            default:
                break;
        }
    }

    private void deplacerEnAvant() throws DeplacementException {
        int x = this.tondeuse.getCaseFinale().getX();
        int y = this.tondeuse.getCaseFinale().getY();
        switch (this.tondeuse.getSens()) {
            case NORTH:
                y = y - 1;
                break;
            case EAST:
                x = x + 1;
                break;
            case WEST:
                x = x - 1;
                break;
            case SOUTH:
                y = y + 1;
                break;
            default:
                break;
        }
        try {
            this.tondeuse.setCaseFinale(this.tondeuse.getPelouse().getCase(x, y));
        } catch (Exception e) {
            throw new DeplacementException("Déplacement Impossible !");
        }
    }

}
