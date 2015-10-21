package GrandFeu;

import Interface.Feu;
import PetitFeu.PetitFeu;

public class GrandFeu extends Thread implements Feu{

	int t;
	StateGrandFeu currentState;
	
	VertGFState vertState;
	VertOrangeGFState vertOrangeState;
	OrangeGFState orangeState;
	OrangeRougeGFState orangeRougeState;
	RougeGFState rougeGFState;
	RougeVertGFState rougeVertGFState;
	
	PetitFeu pf;
	
	public int getT() {
		return t;
	}

	public void resetT(){
		t=0;
	}
	
	public GrandFeu() {
		t=0;
		vertState = new VertGFState(this);
		vertOrangeState = new VertOrangeGFState(this);
		orangeState=new OrangeGFState(this);
		orangeRougeState = new OrangeRougeGFState(this);
		rougeGFState = new RougeGFState(this);
		rougeVertGFState = new RougeVertGFState(this);
		setState(vertState);
	}
	
	public OrangeGFState getOrangeState() {
		return orangeState;
	}

	public OrangeRougeGFState getOrangeRougeState() {
		return orangeRougeState;
	}

	public RougeGFState getRougeGFState() {
		return rougeGFState;
	}

	public RougeVertGFState getRougeVertGFState() {
		return rougeVertGFState;
	}

	public void setState(StateGrandFeu s){
		currentState =s;
		s.reachState();
	}
	
	public VertGFState getVertState() {
		return vertState;
	}

	public VertOrangeGFState getVertOrangeState() {
		return vertOrangeState;
	}
	
	public void GFRouge(){
		pf.GFRouge();
	}
	
	@Override
	public void voiture() {
		currentState.voiture();
	}

	@Override
	public void PasVoiture() {
		currentState.PasVoiture();
	}

	public void PFRouge(){
		currentState.PFRouge();
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(1000);
				t++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
