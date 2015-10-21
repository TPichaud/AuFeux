package Capteur;

import GrandFeu.GrandFeu;
import PetitFeu.PetitFeu;

public abstract class StateCapteur {
	protected Capteur capteur;
	protected GrandFeu gf;
	protected PetitFeu pf;
	
	public abstract void reachState();
}
