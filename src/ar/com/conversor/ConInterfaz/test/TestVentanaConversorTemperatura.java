package ar.com.conversor.ConInterfaz.test;

import javax.swing.JFrame;

import ar.com.conversor.ConInterfaz.igu.VentanaConversorTemperatura;

public class TestVentanaConversorTemperatura {
public static void main(String[] args) {
		
		JFrame frameDePrueba =new JFrame();
		frameDePrueba.setBounds(100, 100, 450, 300);
		VentanaConversorTemperatura v1= new VentanaConversorTemperatura();
		frameDePrueba.add(v1);
		frameDePrueba.setVisible(true);
		
	}


}
