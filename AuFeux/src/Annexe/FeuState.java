package Annexe;

/**
 * The Class FeuState.
 */
public abstract class FeuState {
	
	/** The feu having this state*/
	protected Feu feu;
	
	/**
	 * On reach state.
	 */
	public void reachState(){}
	
	/**
	 * On car detect.
	 *
	 * @return true, if the state has handle the signal
	 */
	public boolean voiture(){
		return false;
	}
	
	/**
	 * On not detect car.
	 *
	 * @return true, if the state has handle the signal
	 */
	public boolean PasVoiture(){
		return false;
	}
	
	/**
	 * On Grand Feu rouge.
	 *
	 * @return true, if the state has handle the signal
	 */
	public boolean GFRouge(){
		return false;
	}

	/**
	 * On Petit Feu rouge.
	 *
	 * @return true, if the state has handle the signal
	 */
	public boolean PFRouge(){
		return false;
	}
}
