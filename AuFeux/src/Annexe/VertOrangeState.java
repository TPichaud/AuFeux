package Annexe;

import AuFeux.Systeme;

/**
 * The Class VertOrangeState.
 */
public class VertOrangeState extends FeuState{

	/**
	 * Instantiates a new vert orange state.
	 *
	 * @param f the Feu
	 */
	public VertOrangeState(Feu f) {
		this.feu = f;
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
		feu.setState(feu.getOrangeState());
	}

}
