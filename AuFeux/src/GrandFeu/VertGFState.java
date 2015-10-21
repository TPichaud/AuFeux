package GrandFeu;

public class VertGFState extends StateGrandFeu{

	public VertGFState(GrandFeu gf) {
		this.gf=gf;
	}
	
	@Override
	public void voiture() {
		while (gf.getT()<30) {}
		
		gf.setState(gf.getVertOrangeState());
		gf.resetT();
	}

	@Override
	public void PasVoiture() {}

	@Override
	public void reachState() {
		gf.resetT();
	}

	@Override
	public void PFRouge() {}
	

}
