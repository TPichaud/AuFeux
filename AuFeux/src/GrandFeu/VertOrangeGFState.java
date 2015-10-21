package GrandFeu;

public class VertOrangeGFState extends StateGrandFeu{

	public VertOrangeGFState(GrandFeu gf) {
		this.gf=gf;
	}
	
	@Override
	public void voiture() {}

	@Override
	public void PasVoiture() {}

	@Override
	public void reachState() {
		while(gf.getT()<1){}
		
		gf.setState(gf.getOrangeState());
		
		gf.resetT();
	}

	@Override
	public void PFRouge() {}

}
