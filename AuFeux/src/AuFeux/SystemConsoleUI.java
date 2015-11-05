package AuFeux;

import java.util.Scanner;

import Annexe.Clock;
import Annexe.MyObservable;

/**
 * The Class SystemConsoleUI.
 */
public class SystemConsoleUI extends Systeme {
	
	/** If it displays clocks notifications. */
	private boolean displayClocks;

	/**
	 * Instantiates a new system console ui.
	 *
	 * @param b If it displays clocks notifications.
	 */
	public SystemConsoleUI(boolean b) {
		displayClocks = b;
	}
	
	/**
	 * @see Annexe.MyObserver#update(Annexe.MyObservable, java.lang.Object)
	 */
	@Override
	public void update(MyObservable o, Object args) {
		if (displayClocks || !(o instanceof Clock) )
			System.out.println(o);
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Time unit (ms): ");
		Systeme.GLOBAL_TIME_UNIT = sc.nextInt();
		
		System.out.println("Display clock (true/false): ");
		SystemConsoleUI scui = new SystemConsoleUI(sc.nextBoolean());
		
		sc.close();
		
		scui.run();
	}

}
