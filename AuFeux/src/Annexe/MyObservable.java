package Annexe;

/**
 * The Interface MyObservable.
 */
public interface MyObservable {
	
	/**
	 * Adds the observer.
	 *
	 * @param o the o
	 */
	public void addObserver(MyObserver o);
	
	/**
	 * Notifiy observers.
	 *
	 * @param args the args
	 */
	public void notifiyObservers(Object args);
}
