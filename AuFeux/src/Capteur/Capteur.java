package Capteur;

import GrandFeu.GrandFeu;
import PetitFeu.PetitFeu;

public class Capteur extends Thread{

	StateCapteur currentState;
	PasVoitureState pvs;
	public PasVoitureState getPvs() {
		return pvs;
	}

	public VoitureDetecteState getVds() {
		return vds;
	}

	VoitureDetecteState vds;
	
	public Capteur(GrandFeu gf, PetitFeu pf) {
		pvs = new PasVoitureState(this, gf, pf);
		vds = new VoitureDetecteState(this, gf, pf);
		setState(pvs);
	}

	public void setState(StateCapteur s){
		currentState=s;
		currentState.reachState();
	}
	
	public void run(){
		while (true){
			try {
				int s= (int) Math.random()*10 + 1;
				Thread.sleep(s*1000);
				setState(vds);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
