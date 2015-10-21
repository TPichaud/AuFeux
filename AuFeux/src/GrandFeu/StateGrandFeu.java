package GrandFeu;

import Interface.Feu;

public abstract class StateGrandFeu implements Feu{

	protected GrandFeu gf;
	
	public abstract void reachState();
	public abstract void PFRouge();
}
