package ar.com.conversor.ConInterfaz.modelo;
import ar.com.conversor.ConInterfaz.igu.*;
import java.awt.EventQueue;

/**
 * Launch the application "Conversor".
 */
public class Main {
	
	
	public static void main(String[] args) {
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VentanaMenu frame = new VentanaMenu();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		
		
		
	
	}
}
