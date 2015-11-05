package AuFeux;

import Annexe.Clock;
import Annexe.MyObservable;

public class SystemConsoleUI extends Systeme {
	
	private boolean displayClocks;

	public SystemConsoleUI(boolean b) {
		displayClocks = b;
	}
	
	@Override
	public void update(MyObservable o, Object args) {
		if (displayClocks || !(o instanceof Clock) )
			System.out.println(o);
	}
	
	public static void main(String[] args) {
		SystemConsoleUI scui = new SystemConsoleUI(false);
		scui.run();
	}

}
