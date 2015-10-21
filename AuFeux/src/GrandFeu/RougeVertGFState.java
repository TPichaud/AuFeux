package GrandFeu;

public class RougeVertGFState extends StateGrandFeu{

	public RougeVertGFState(GrandFeu gf) {
		this.gf=gf;
	}
	
	@Override
	public void voiture() {}

	@Override
	public void PasVoiture() {}
	
	@Override
	public void PFRouge() {}

	@Override
	public void reachState() {
		
		while (gf.getT()<1){}
		
		gf.setState(gf.getVertState());
		
		gf.resetT();
	}

	

}
