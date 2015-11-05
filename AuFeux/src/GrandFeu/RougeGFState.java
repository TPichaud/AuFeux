package GrandFeu;

import Annexe.FeuState;

/**
 * The Class RougeGFState.
 */
public class RougeGFState extends FeuState{

	/**
	 * Instantiates a new rouge gf state.
	 *
	 * @param gf the GrandFeu
	 */
	public RougeGFState(GrandFeu gf) {
		this.feu=gf;
	}
	
	/**
	 * @see Annexe.FeuState#reachState()
	 */
	public void reachState(){
		feu.GFRouge();
	}

	/**
	 * @see Annexe.FeuState#PFRouge()
	 */
	@Override
	public boolean PFRouge() {
		feu.resetClock();
		feu.setState(feu.getRougeVertState());
		return true;
	}
	
}
