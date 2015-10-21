package GrandFeu;

public class OrangeRougeGFState extends StateGrandFeu{

	public OrangeRougeGFState(GrandFeu gf) {
		this.gf=gf;
	}
	
	@Override
	public void voiture() {
	}

	@Override
	public void PasVoiture() {
	}

	@Override
	public void reachState() {
		gf.resetT();
		
		while(gf.getT()<1){}
		
		gf.setState(gf.getRougeGFState());
	
		gf.GFRouge();
	}

	@Override
	public void PFRouge() {}

}
