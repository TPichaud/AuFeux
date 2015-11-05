package Annexe;

import java.util.ArrayList;
import java.util.Collection;

import AuFeux.Systeme;

/**
 * The Class Clock.
 */
public class Clock extends Thread implements MyObservable{

	private int t;
	
	/** The owner of the clock. */
	private Object owner;
	
	/** The observers. */
	private Collection<MyObserver> obs;
	
	/**
	 * Instantiates a new clock.
	 *
	 * @param owner the owner
	 */
	public Clock(Object owner){
		obs=new ArrayList<>();
		this.owner=owner;
		t=0;
	}
	
	/**
	 * Gets the current value
	 *
	 * @return the current value
	 */
	public int get(){
		return t;
	}
	
	/**
	 * Reset.
	 */
	public void reset(){
		t=0;
		notifiyObservers(t);
	}
	
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
	
	/**
	 * @see java.lang.Thread#toString()
	 */
	public String toString(){
		return owner.getClass().getSimpleName()+  " clock :"+t;
	}
	
	/**
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		while(true){
			try {
				Thread.sleep(Systeme.GLOBAL_TIME_UNIT);
				t++;
				notifiyObservers(t);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
