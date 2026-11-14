package modele;

import enumerations.EDirection;
import interfaces.IRobot;

/***
 * Attention n'est pas SOLID (SRP).
 * A créer une classe manager.
 * @author stephane.joyeux
 *
 */
public class Tondeuse implements IRobot {

	// Une tondeuse se déplace sur une pelouse.
	private Grille pelouse;

	// Départ de la tondeuse :
	private Case caseDepart;

	// Arrivée :
	private Case caseFinale;

	// Sens de la tondeuse :
	private EDirection sens;

	public Case getCaseFinale() {
		return caseFinale;
	}
	public EDirection getSens() {
		return sens;
	}

	public Tondeuse(int lignes, int colonnes, int posX, int posY, EDirection sens) {
		this.setPelouse(new Grille(lignes, colonnes));
		this.caseDepart = this.getPelouse().getCase(posX, posY);
		this.caseFinale = this.getPelouse().getCase(posX, posY);
		this.setCaseFinale(this.getPelouse().getCase(posX, posY));
		this.setSens(sens);
	}

	@Override
	public String toString() {
		return "Ma position finale est X = " + this.getCaseFinale().getX() + ", Y = " + this.getCaseFinale().getY()
				+ " et je suis orientée : " + this.getSens();
	}

	public void setSens(EDirection sens) {
		this.sens = sens;
	}

	public void setCaseFinale(Case caseFinale) {
		this.caseFinale = caseFinale;
	}

	public Grille getPelouse() {
		return pelouse;
	}

	public void setPelouse(Grille pelouse) {
		this.pelouse = pelouse;
	}
}
