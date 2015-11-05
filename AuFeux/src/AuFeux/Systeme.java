package AuFeux;

import Annexe.MyObserver;
import Capteur.Capteur;
import GrandFeu.GrandFeu;
import PetitFeu.PetitFeu;

/**
 * The Class Systeme.
 */
public abstract class Systeme implements MyObserver{
	
	/** The global time unit. */
	public static int GLOBAL_TIME_UNIT = 100;
	
	protected GrandFeu gf;
	protected PetitFeu pf;
	protected Capteur c;
	
	/**
	 * Instantiates a new systeme.
	 */
	public Systeme(){
		gf = new GrandFeu();
		gf.addObserver(this);
		pf = new PetitFeu(gf);
		pf.addObserver(this);
		gf.setPetitFeu(pf);
		
		c = new Capteur(gf,pf);
		c.addObserver(this);
	}
	
	/**
	 * Run the simulation.
	 */
	public void run(){
		gf.start();
		pf.start();
		c.start();
	}
}
