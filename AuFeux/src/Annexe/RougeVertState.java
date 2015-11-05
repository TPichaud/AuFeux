package Annexe;

import AuFeux.Systeme;

/**
 * The Class RougeVertState.
 */
public class RougeVertState extends FeuState{

	/**
	 * Instantiates a new rouge vert state.
	 *
	 * @param f the Feu
	 */
	public RougeVertState(Feu f) {
		this.feu=f;
	}

	/**
	 * @see Annexe.FeuState#reachState()
	 */
	@Override
	public void reachState() {
		
		while (feu.getClock()<1){
			try {
				Thread.sleep(Systeme.GLOBAL_TIME_UNIT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		feu.resetClock();
		feu.setState(feu.getVertState());
	}

}
