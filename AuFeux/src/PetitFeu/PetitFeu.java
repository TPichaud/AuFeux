package PetitFeu;

import Annexe.*;
import GrandFeu.GrandFeu;

/**
 * The Class PetitFeu.
 */
public class PetitFeu extends Feu{

	private GrandFeu gf;
	
	/**
	 * Instantiates a new petit feu.
	 */
	public PetitFeu(){
		this(null);
	}
	
	/**
	 * Instantiates a new petit feu.
	 *
	 * @param gf the gf
	 */
	public PetitFeu(GrandFeu gf) {
		super();
		this.gf=gf;
		c = new Clock(this);
		vertState = new VertPFState(this);
		rougeState = new RougePFState(this);
		currentState = rougeState;
	}
	
	/**
	 * Sets the grand feu.
	 *
	 * @param gf the new grand feu
	 */
	public void setGrandFeu(GrandFeu gf){
		this.gf=gf;
	}
	
	/**
	 * @see Annexe.Feu#PasVoiture()
	 */
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
	
	/**
	 * @see Annexe.Feu#GFRouge()
	 */
	public void GFRouge(){
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!currentState.GFRouge()){}
			}
		});

		t.start();
	}

	/**
	 * @see Annexe.Feu#PFRouge()
	 */
	public void PFRouge(){
		gf.PFRouge();
	}

	
}
