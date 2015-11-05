package GrandFeu;

import Annexe.FeuState;

public class RougeGFState extends FeuState{

	public RougeGFState(GrandFeu gf) {
		this.feu=gf;
	}
	
	public void reachState(){
		feu.GFRouge();
	}

	@Override
	public boolean PFRouge() {
		feu.resetClock();
		feu.setState(feu.getRougeVertState());
		return true;
	}
	
}
