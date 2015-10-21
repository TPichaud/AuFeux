package GrandFeu;

public class OrangeGFState extends StateGrandFeu{

	public OrangeGFState(GrandFeu gf) {
		this.gf=gf;
	}
	
	@Override
	public void voiture() {}

	@Override
	public void PasVoiture() {}

	@Override
	public void reachState() {
		
		while (gf.getT()<=5){}
		
		gf.setState(gf.getOrangeRougeState());
		
		gf.resetT();
	}

	@Override
	public void PFRouge() {}

}
