package Capteur;

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
	}
	
}
