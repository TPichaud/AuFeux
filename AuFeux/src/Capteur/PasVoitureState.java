package Capteur;

import AuFeux.Systeme;
import GrandFeu.GrandFeu;
import PetitFeu.PetitFeu;

/**
 * The Class PasVoitureState.
 */
public class PasVoitureState extends StateCapteur {

	/**
	 * Instantiates a new pas voiture state.
	 *
	 * @param c the Capteur
	 * @param gf the GrandFeu
	 * @param pf the PetitFeu
	 */
	public PasVoitureState(Capteur c, GrandFeu gf, PetitFeu pf) {
		super(c,gf,pf);
	}

	/**
	 * @see Capteur.StateCapteur#reachState()
	 */
	@Override
	public void reachState() {
		gf.PasVoiture();
		pf.PasVoiture();
		
		//Attente de 200 unités de temps pour le passage d'une autre voiture
		try {
			Thread.sleep(200 * Systeme.GLOBAL_TIME_UNIT);
			capteur.setState(capteur.getVds());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
