package ar.com.conversor.ConInterfaz.test;

import javax.swing.JFrame;
import ar.com.conversor.ConInterfaz.igu.*;

public class TestVentanaConversor {

	public static void main(String[] args) {
		
		JFrame frameDePrueba =new JFrame();
		frameDePrueba.setBounds(100, 100, 450, 300);
		VentanaConversorMoneda v1= new VentanaConversorMoneda();
		frameDePrueba.add(v1);
		frameDePrueba.setVisible(true);
		
	}

	

}
