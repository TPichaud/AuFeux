package GrandFeu;

import Annexe.FeuState;
import AuFeux.Systeme;

/**
 * The Class VertGFState.
 */
public class VertGFState extends FeuState{

	/**
	 * Instantiates a new vert gf state.
	 *
	 * @param gf the gf
	 */
	public VertGFState(GrandFeu gf) {
		this.feu=gf;
	}
	
	/**
	 * @see Annexe.FeuState#voiture()
	 */
	@Override
	public boolean voiture() {
		while (feu.getClock()<30) {
			
			try {
				Thread.sleep(Systeme.GLOBAL_TIME_UNIT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		feu.resetClock();
		feu.setState(feu.getVertOrangeState());
		
		return true;
	}

	/**
	 * @see Annexe.FeuState#reachState()
	 */
	@Override
	public void reachState() {
		feu.resetClock();
	}

}
 