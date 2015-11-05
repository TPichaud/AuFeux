package Capteur;

import GrandFeu.GrandFeu;
import PetitFeu.PetitFeu;

/**
 * The Class StateCapteur.
 */
public abstract class StateCapteur {
	
	/** The capteur. */
	protected Capteur capteur;
	
	/** The gf. */
	protected GrandFeu gf;
	
	/** The pf. */
	protected PetitFeu pf;
	
	/**
	 * Instantiates a new state capteur.
	 *
	 * @param c the Capteur
	 * @param gf the GrandFeu
	 * @param pf the PetitFeu
	 */
	public StateCapteur(Capteur c, GrandFeu gf, PetitFeu pf) {
		this.capteur =c;
		this.gf=gf;
		this.pf=pf;
	}
	
	/**
	 * Reach state.
	 */
	public abstract void reachState();
}
