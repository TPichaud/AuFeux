package GrandFeu;

public class RougeGFState extends StateGrandFeu{

	public RougeGFState(GrandFeu gf) {
		this.gf=gf;
	}

	@Override
	public void voiture() {}

	@Override
	public void PasVoiture() {}

	@Override
	public void reachState() {}

	@Override
	public void PFRouge() {
		gf.resetT();
		gf.setState(gf.getRougeVertGFState());
	}
	
}
