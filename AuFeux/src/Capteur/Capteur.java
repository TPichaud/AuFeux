package Capteur;

import java.util.ArrayList;
import java.util.Collection;

import Annexe.MyObservable;
import Annexe.MyObserver;
import AuFeux.Systeme;
import GrandFeu.GrandFeu;
import PetitFeu.PetitFeu;

/**
 * The Class Capteur.
 */
public class Capteur extends Thread implements MyObservable{

	/** The current state. */
	private StateCapteur currentState;
	
	private PasVoitureState pvs;
	private VoitureDetecteState vds;
	
	/** The observers. */
	private Collection<MyObserver> obs;
	
	/**
	 * Instantiates a new capteur.
	 *
	 * @param gf the GrandFeu
	 * @param pf the PetitFeu
	 */
	public Capteur(GrandFeu gf, PetitFeu pf) {
		obs = new ArrayList<>();
		pvs = new PasVoitureState(this, gf, pf);
		vds = new VoitureDetecteState(this, gf, pf);
		currentState = pvs;
	}
	
	/**
	 * Gets the PasVoitureState.
	 *
	 * @return pvs
	 */
	public PasVoitureState getPvs() {
		return pvs;
	}

	/**
	 * Gets the VoitureDetecteState.
	 *
	 * @return vds
	 */
	public VoitureDetecteState getVds() {
		return vds;
	}

	/**
	 * Sets the state.
	 *
	 * @param s the new state
	 */
	public void setState(StateCapteur s){
		currentState=s;
		notifiyObservers(currentState);
		currentState.reachState();
	}
	
	/**
	 * @see java.lang.Thread#toString()
	 */
	public String toString(){
		return getClass().getSimpleName()+" on state "+ currentState.getClass().getSimpleName();
	}
	
	/**
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		try {
			System.out.println(this);
			Thread.sleep(Systeme.GLOBAL_TIME_UNIT);
			setState(getVds());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//Pattern Observer
	
	/**
	 * @see Annexe.MyObservable#addObserver(Annexe.MyObserver)
	 */
	@Override
	public void addObserver(MyObserver o) {
		obs.add(o);
	}

	/**
	 * @see Annexe.MyObservable#notifiyObservers(java.lang.Object)
	 */
	@Override
	public void notifiyObservers(Object args) {
		for (MyObserver o : obs){
			o.update(this, args);
		}
	}
}
