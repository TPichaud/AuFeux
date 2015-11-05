package Annexe;

import java.util.ArrayList;
import java.util.Collection;

import AuFeux.Systeme;

public class Clock extends Thread implements MyObservable{

	private int t;
	private Object owner;
	
	private Collection<MyObserver> obs;
	
	public Clock(Object owner){
		obs=new ArrayList<>();
		this.owner=owner;
		t=0;
	}
	
	public int get(){
		return t;
	}
	
	public void reset(){
		t=0;
		notifiyObservers(t);
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
	
	public String toString(){
		return owner.getClass().getSimpleName()+  " clock :"+t;
	}
	
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
