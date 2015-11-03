package Interface;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Feu extends Thread implements MyObservable, MyObserver{
	
	protected Clock c;
	
	protected FeuState currentState;
	
	protected FeuState vertState;
	protected FeuState vertOrangeState;
	protected FeuState orangeState;
	protected FeuState orangeRougeState;
	protected FeuState rougeState;
	protected FeuState rougeVertState;
	
	protected Collection<MyObserver> obs;
	
	public Feu(){
		obs=new ArrayList<>();
	}
	
	public int getClock() {
		return c.get();
	}
	public void resetClock(){
		c.reset();
	}
	
	public FeuState getVertState(){
		return vertState;
	}
	public FeuState getVertOrangeState(){
		return vertOrangeState;
	}
	public FeuState getOrangeState(){
		return orangeState;
	}
	public FeuState getOrangeRougeState(){
		return orangeRougeState;
	}
	public FeuState getRougeState(){
		return rougeState;
	}
	public FeuState getRougeVertState(){
		return rougeVertState;
	}
	
	public void setState(FeuState s){
		currentState = s;
		notifiyObservers(currentState);
		s.reachState();
	}
	
	public String toString(){
		return getClass().getSimpleName()+" on state "+ currentState.getClass().getSimpleName();
	}
	
	@Override
	public void addObserver(MyObserver o) {
		obs.add(o);
		c.addObserver(o);
	}

	@Override
	public void notifiyObservers(Object args) {
		for (MyObserver o : obs){
			o.update(this, args);
		}
	}
	
	@Override
	public void update(MyObservable mo, Object args){
		for (MyObserver o : obs){
			o.update(mo, args);
		}
	}
	
	// SIGNAUX
	public abstract void GFRouge();
	public abstract void PFRouge();
	
	public void voiture() {}
	public void PasVoiture() {}
	

	public void run(){
		System.out.println(this);
		c.start();
	}
}
