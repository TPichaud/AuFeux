package GrandFeu;

import Interface.Feu;
import Interface.OrangeRougeState;
import Interface.OrangeState;
import Interface.RougeVertState;
import Interface.VertOrangeState;
import Interface.Clock;
import PetitFeu.PetitFeu;

public class GrandFeu extends Feu{
	
	PetitFeu pf;
	
	public GrandFeu(){
		this(null);
	}
	
	public GrandFeu(PetitFeu pf) {
		super();
		this.pf=pf;
		c = new Clock(this);
		vertState = new VertGFState(this);
		vertOrangeState = new VertOrangeState(this);
		orangeState=new OrangeState(this);
		orangeRougeState = new OrangeRougeState(this);
		rougeState = new RougeGFState(this);
		rougeVertState = new RougeVertState(this);
		currentState = vertState;
	}
	
	public void setPetitFeu(PetitFeu pf){
		this.pf=pf;
	}
	
	public void GFRouge(){
		pf.GFRouge();
	}
	
	public void voiture() {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (!currentState.voiture()){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		t.start();
	}

	public void PFRouge(){
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!currentState.PFRouge()){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		t.start();
	}
}
