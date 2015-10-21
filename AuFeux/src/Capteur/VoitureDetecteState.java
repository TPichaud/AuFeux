package Capteur;

import GrandFeu.GrandFeu;
import PetitFeu.PetitFeu;

public class VoitureDetecteState extends StateCapteur{
	
	public VoitureDetecteState(Capteur c, GrandFeu gf, PetitFeu pf) {
		capteur =c;
		this.gf=gf;
		this.pf=pf;
	}

	@Override
	public void reachState() {
		gf.voiture();
		pf.voiture();
	}
}
