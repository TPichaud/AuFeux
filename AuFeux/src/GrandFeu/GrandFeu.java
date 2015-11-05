package GrandFeu;

import Annexe.Clock;
import Annexe.Feu;
import PetitFeu.PetitFeu;

/**
 * The Class GrandFeu.
 */
public class GrandFeu extends Feu{
	
	PetitFeu pf;
	
	/**
	 * Instantiates a new grand feu.
	 */
	public GrandFeu(){
		this(null);
	}
	
	/**
	 * Instantiates a new grand feu.
	 *
	 * @param pf the PetitFeu
	 */
	public GrandFeu(PetitFeu pf) {
		super();
		this.pf=pf;
		c = new Clock(this);
		vertState = new VertGFState(this);
		rougeState = new RougeGFState(this);
		currentState = vertState;
	}
	
	/**
	 * Sets the petit feu.
	 *
	 * @param pf the new petit feu
	 */
	public void setPetitFeu(PetitFeu pf){
		this.pf=pf;
	}
	
	//SIGNALS
	
	/**
	 * @see Annexe.Feu#GFRouge()
	 */
	public void GFRouge(){
		pf.GFRouge();
	}
	
	/**
	 * @see Annexe.Feu#voiture()
	 */
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

	/**
	 * @see Annexe.Feu#PFRouge()
	 */
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
