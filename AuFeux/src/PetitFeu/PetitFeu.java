package PetitFeu;

import GrandFeu.GrandFeu;
import Interface.*;

public class PetitFeu extends Feu{

	private GrandFeu gf;
	
	public PetitFeu(){
		this(null);
	}
	
	public PetitFeu(GrandFeu gf) {
		super();
		this.gf=gf;
		c = new Clock(this);
		vertState = new VertPFState(this);
		vertOrangeState = new VertOrangeState(this);
		orangeState=new OrangeRougeState(this);
		orangeRougeState = new OrangeRougeState(this);
		rougeState = new RougePFState(this);
		rougeVertState = new RougeVertState(this);
		currentState = rougeState;
	}
	
	public void setGrandFeu(GrandFeu gf){
		this.gf=gf;
	}
	
	public void PasVoiture() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!currentState.PasVoiture()){
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
	
	public void GFRouge(){
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!currentState.GFRouge()){}
			}
		});

		t.start();
	}

	public void PFRouge(){
		gf.PFRouge();
	}

	
}
