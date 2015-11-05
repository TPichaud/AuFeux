package Annexe;

import Annexe.FeuState;
import AuFeux.Systeme;

public class OrangeState extends FeuState{

	public OrangeState(Feu f) {
		this.feu=f;
	}

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
