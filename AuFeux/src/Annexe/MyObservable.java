package Annexe;

public interface MyObservable {
	public void addObserver(MyObserver o);
	public void notifiyObservers(Object args);
}
