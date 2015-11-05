package PetitFeu;

import Annexe.FeuState;
import AuFeux.Systeme;

/**
 * The Class VertPFState.
 */
public class VertPFState extends FeuState{

	/**
	 * Instantiates a new vert pf state.
	 *
	 * @param pf the pf
	 */
	public VertPFState(PetitFeu pf){
		feu=pf;
	}
	
	/**
	 * @see Annexe.FeuState#PasVoiture()
	 */
	public boolean PasVoiture(){
		while (feu.getClock()<30){
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
}
