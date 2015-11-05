package Capteur;

import GrandFeu.GrandFeu;
import PetitFeu.PetitFeu;

/**
 * The Class VoitureDetecteState.
 */
public class VoitureDetecteState extends StateCapteur{
	
	/**
	 * Instantiates a new voiture detecte state.
	 *
	 * @param c the Capteur
	 * @param gf the GrandFeu
	 * @param pf the PetitFeu
	 */
	public VoitureDetecteState(Capteur c, GrandFeu gf, PetitFeu pf) {
		super(c,gf,pf);
	}

	/**
	 * @see Capteur.StateCapteur#reachState()
	 */
	@Override
	public void reachState() {
		gf.voiture();
		pf.voiture();
		
		capteur.setState(capteur.getPvs());
	}
}
