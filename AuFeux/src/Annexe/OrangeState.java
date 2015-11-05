package Annexe;

import Annexe.FeuState;
import AuFeux.Systeme;

/**
 * The Class OrangeState.
 */
public class OrangeState extends FeuState{

	/**
	 * Instantiates a new orange state.
	 *
	 * @param f the Feu
	 */
	public OrangeState(Feu f) {
		this.feu=f;
	}

	/**
	 * @see Annexe.FeuState#reachState()
	 */
	@Override
	public void reachState() {
		
		while (feu.getClock()<=5){
			try {
				Thread.sleep(Systeme.GLOBAL_TIME_UNIT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		feu.resetClock();
		feu.setState(feu.getOrangeRougeState());
	}

}
