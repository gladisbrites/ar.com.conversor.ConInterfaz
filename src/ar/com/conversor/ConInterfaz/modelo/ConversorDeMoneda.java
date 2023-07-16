package ar.com.conversor.ConInterfaz.modelo;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ar.com.conversor.ConInterfaz.igu.VentanaConversorMoneda;

public class ConversorDeMoneda {
	public double dolar =264.57;
	public double euro =229.28;
	public double libras =346.34;
	public double yen =1.91;
	public double  won=0.21;
	public double valorEntrada=0.00;
	
	public ConversorDeMoneda() {
		
	}
	
       
        public void convertir() {
        	 
			if(validar(VentanaConversorMoneda.getTextNumeroIngresado().getText())) {
				String money =(String) VentanaConversorMoneda.getCmbMonedas().getSelectedItem();
				switch (money){
				case "De Pesos Argentinos a Dolar" :
					pesosAMoneda(dolar, " dolares");
					break;
				case "De Pesos a Euro" :
					pesosAMoneda(euro, " euros");
					break;
				case "De Pesos Artentinos a Libras Esterlinas":
					pesosAMoneda(libras, " libras");
					break;
				case "De Pesos Argentinos a Yen Japones":
					pesosAMoneda(yen, "yen Japonés");
					break;
				case "De Pesos Argentinos a Won surcoreano":
					pesosAMoneda(won,"Won Surcoreanos");
					break;
				case "De Dolar a Pesos Argentinos":
					monedaAPesos(dolar,"dolares son: ");
					break;
				case "De Euro a Pesos Argentinos":
					monedaAPesos(euro,"euros son: ");
					break;
				case "De Libras Esterlinas  a Pesos Argentinos":
					monedaAPesos(libras," libras son: ");
					break;
				case "De Yen Japones a Pesos Argentinos":
					monedaAPesos(yen, "Yen son: ");
					break;
				case "De Won Surcoreano a Pesos Argentinos":
					monedaAPesos(won, "Won son: ");
					break;
					
					
					
					default :
						throw new IllegalArgumentException(" Valor invalido: "+VentanaConversorMoneda.getCmbMonedas());
				}	
			};
		
		}
		public void pesosAMoneda(double moneda, String nombreMoneda) {
			double valorSalida = valorEntrada/moneda;
			
			VentanaConversorMoneda.getLblEtiquedaDeEntrada().setText("Pesos Argentinos son: "+redondear(valorSalida)+nombreMoneda);
			
			
		}

		public void monedaAPesos(double moneda , String nombreMoneda ) {
			double valorSalida = valorEntrada*moneda;
			VentanaConversorMoneda.getLblEtiquedaDeEntrada().setText(nombreMoneda+redondear(valorSalida)+" Pesos Argentinos");
			
		}
		public String redondear(double valor) {
			DecimalFormat df =new DecimalFormat("0.00");
			df.setRoundingMode(RoundingMode.HALF_UP);
			return df.format(valor);
		}
		public boolean validar(String texto) {
			try {
				double x = Double.parseDouble(texto);
					if (x >0);
						valorEntrada= x;
						return true;
					
			} catch(NumberFormatException e){
				VentanaConversorMoneda.getLblEtiquedaDeEntrada().setText("solamente numeros");
				return false;
			}
		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	