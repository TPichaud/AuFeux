package Annexe;

import AuFeux.Systeme;

/**
 * The Class OrangeRougeState.
 */
public class OrangeRougeState extends FeuState{

	/**
	 * Instantiates a new orange rouge state.
	 *
	 * @param gf the Feu
	 */
	public OrangeRougeState(Feu f) {
		this.feu=f;
	}

	/**
	 * @see Annexe.FeuState#reachState()
	 */
	@Override
	public void reachState() {
		
		while(feu.getClock()<1){
			try {
				Thread.sleep(Systeme.GLOBAL_TIME_UNIT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		feu.resetClock();
		feu.setState(feu.getRougeState());
	}

}
