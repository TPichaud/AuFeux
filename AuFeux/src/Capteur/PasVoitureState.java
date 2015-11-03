package Capteur;

import AuFeux.Systeme;
import GrandFeu.GrandFeu;
import PetitFeu.PetitFeu;

public class PasVoitureState extends StateCapteur {

	public PasVoitureState(Capteur c, GrandFeu gf, PetitFeu pf) {
		capteur =c;
		this.gf=gf;
		this.pf=pf;
	}

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
