package Interface;

import AuFeux.Systeme;

public class OrangeRougeState extends FeuState{

	public OrangeRougeState(Feu gf) {
		this.feu=gf;
	}

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
