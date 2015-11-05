package AuFeux;

import java.util.Scanner;

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
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Time unit (ms): ");
		Systeme.GLOBAL_TIME_UNIT = sc.nextInt();
		
		System.out.println("Display clock (true/false): ");
		SystemConsoleUI scui = new SystemConsoleUI(sc.nextBoolean());
		
		sc.close();
		
		scui.run();
	}

}
