package PetitFeu;

import Annexe.FeuState;

public class RougePFState extends FeuState{

	public RougePFState(PetitFeu pf) {
		this.feu=pf;
	}
	
	public void reachState(){
		feu.PFRouge();
	}

	@Override
	public boolean GFRouge() {
		feu.resetClock();
		feu.setState(feu.getRougeVertState());
		return true;
	}
	
}
