package Annexe;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The Class Feu.
 */
public abstract class Feu extends Thread implements MyObservable, MyObserver{
	
	/** The clock. */
	protected Clock c;
	
	/** The current state. */
	protected FeuState currentState;
	
	/** The vert state. */
	protected FeuState vertState;
	
	/** The vert orange state. */
	protected FeuState vertOrangeState;
	
	/** The orange state. */
	protected FeuState orangeState;
	
	/** The orange rouge state. */
	protected FeuState orangeRougeState;
	
	/** The rouge state. */
	protected FeuState rougeState;
	
	/** The rouge vert state. */
	protected FeuState rougeVertState;
	
	/** The observers. */
	protected Collection<MyObserver> obs;
	
	/**
	 * Instantiates a new feu.
	 */
	public Feu(){
		obs=new ArrayList<>();
		vertOrangeState = new VertOrangeState(this);
		orangeState=new OrangeState(this);
		orangeRougeState = new OrangeRougeState(this);
		rougeVertState = new RougeVertState(this);
	}
	
	/**
	 * Gets the clock.
	 *
	 * @return the clock
	 */
	public int getClock() {
		return c.get();
	}
	
	/**
	 * Reset clock.
	 */
	public void resetClock(){
		c.reset();
	}
	
	/**
	 * Gets the vert state.
	 *
	 * @return the vert state
	 */
	public FeuState getVertState(){
		return vertState;
	}
	
	/**
	 * Gets the vert orange state.
	 *
	 * @return the vert orange state
	 */
	public FeuState getVertOrangeState(){
		return vertOrangeState;
	}
	
	/**
	 * Gets the orange state.
	 *
	 * @return the orange state
	 */
	public FeuState getOrangeState(){
		return orangeState;
	}
	
	/**
	 * Gets the orange rouge state.
	 *
	 * @return the orange rouge state
	 */
	public FeuState getOrangeRougeState(){
		return orangeRougeState;
	}
	
	/**
	 * Gets the rouge state.
	 *
	 * @return the rouge state
	 */
	public FeuState getRougeState(){
		return rougeState;
	}
	
	/**
	 * Gets the rouge vert state.
	 *
	 * @return the rouge vert state
	 */
	public FeuState getRougeVertState(){
		return rougeVertState;
	}
	
	/**
	 * Sets the state.
	 *
	 * @param s the new state
	 */
	public void setState(FeuState s){
		currentState = s;
		notifiyObservers(currentState);
		s.reachState();
	}
	
	/**
	 * @see java.lang.Thread#toString()
	 */
	public String toString(){
		return getClass().getSimpleName()+" on state "+ currentState.getClass().getSimpleName();
	}
	
	//Observer pattern
	
	/**
	 * @see Annexe.MyObservable#addObserver(Annexe.MyObserver)
	 */
	@Override
	public void addObserver(MyObserver o) {
		obs.add(o);
		c.addObserver(o);
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
	
	/**
	 * @see Annexe.MyObserver#update(Annexe.MyObservable, java.lang.Object)
	 */
	@Override
	public void update(MyObservable mo, Object args){
		for (MyObserver o : obs){
			o.update(mo, args);
		}
	}
	
	// SIGNAUX
	
	/**
	 * Signal Grand Feu rouge.
	 */
	public abstract void GFRouge();
	
	/**
	 * Signal Petit Feu rouge.
	 */
	public abstract void PFRouge();
	
	/**
	 * Signal Voiture.
	 */
	public void voiture() {}
	
	/**
	 * Signal Pas de voiture.
	 */
	public void PasVoiture() {}
	

	/**
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		System.out.println(this);
		c.start();
	}
}
