package PetitFeu;

import AuFeux.Systeme;
import Interface.FeuState;

public class VertPFState extends FeuState{

	public VertPFState(PetitFeu pf){
		feu=pf;
	}
	
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
