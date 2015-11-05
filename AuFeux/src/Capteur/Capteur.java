package Capteur;

import java.util.ArrayList;
import java.util.Collection;

import Annexe.MyObservable;
import Annexe.MyObserver;
import AuFeux.Systeme;
import GrandFeu.GrandFeu;
import PetitFeu.PetitFeu;

public class Capteur extends Thread implements MyObservable{

	private StateCapteur currentState;
	private PasVoitureState pvs;
	private VoitureDetecteState vds;
	
	private Collection<MyObserver> obs;
	
	public Capteur(GrandFeu gf, PetitFeu pf) {
		obs = new ArrayList<>();
		pvs = new PasVoitureState(this, gf, pf);
		vds = new VoitureDetecteState(this, gf, pf);
		currentState = pvs;
	}
	
	public PasVoitureState getPvs() {
		return pvs;
	}

	public VoitureDetecteState getVds() {
		return vds;
	}

	public void setState(StateCapteur s){
		currentState=s;
		notifiyObservers(currentState);
		currentState.reachState();
	}
	
	public String toString(){
		return getClass().getSimpleName()+" on state "+ currentState.getClass().getSimpleName();
	}
	
	public void run(){
		try {
			System.out.println(this);
			Thread.sleep(Systeme.GLOBAL_TIME_UNIT);
			setState(getVds());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addObserver(MyObserver o) {
		obs.add(o);
	}

	@Override
	public void notifiyObservers(Object args) {
		for (MyObserver o : obs){
			o.update(this, args);
		}
	}
}
