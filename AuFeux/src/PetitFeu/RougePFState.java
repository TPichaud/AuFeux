package PetitFeu;

import Annexe.FeuState;

/**
 * The Class RougePFState.
 */
public class RougePFState extends FeuState{

	/**
	 * Instantiates a new rouge pf state.
	 *
	 * @param pf the pf
	 */
	public RougePFState(PetitFeu pf) {
		this.feu=pf;
	}
	
	/**
	 * @see Annexe.FeuState#reachState()
	 */
	public void reachState(){
		feu.PFRouge();
	}

	/**
	 * @see Annexe.FeuState#GFRouge()
	 */
	@Override
	public boolean GFRouge() {
		feu.resetClock();
		feu.setState(feu.getRougeVertState());
		return true;
	}
	
}
