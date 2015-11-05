package Annexe;

/**
 * Interface MyObserver
 */
public interface MyObserver {
	
	/**
	 * Updates itself when an MyObservable has changed
	 *
	 * @param o the o
	 * @param args the args
	 */
	public void update(MyObservable o, Object args);
}
