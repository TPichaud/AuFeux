package Interface;

public abstract class FeuState {
	
	protected Feu feu;
	
	public void reachState(){}
	
	public boolean voiture(){
		return false;
	}
	
	public boolean PasVoiture(){
		return false;
	}
	
	public boolean GFRouge(){
		return false;
	}

	public boolean PFRouge(){
		return false;
	}
}
