package GrandFeu;

import Annexe.FeuState;
import AuFeux.Systeme;

public class VertGFState extends FeuState{

	public VertGFState(GrandFeu gf) {
		this.feu=gf;
	}
	
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

	@Override
	public void reachState() {
		feu.resetClock();
	}

}
 