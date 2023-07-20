package ar.com.conversor.ConInterfaz.modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;


import ar.com.conversor.ConInterfaz.igu.VentanaConversorTemperatura;



public class ConversorDeTemperatura implements ActionListener{
	
	private double valorEntrada = 0.00;
	private VentanaConversorTemperatura vct;
	
	public ConversorDeTemperatura(VentanaConversorTemperatura vct){
		this.vct=vct;
	}

	public void convertir() {
		if (validar(vct.getTextNumeroIngresado().getText())) {
			String tempe = (String) vct.getCmbTemperaturas().getSelectedItem();
			switch (tempe) {
			case "grados celsius a fahrenheit":
				celsiusAFahrenheit();
				break;
			case "fahrenheit a grados celsius":
				fahrenheitAcelsius();
				break;
			default:
				throw new IllegalArgumentException(" Valor invalido: " );
			}
		}
		

	}

	public void celsiusAFahrenheit() {
		double valorSalida = (valorEntrada * 9 / 5 + 32);
		vct.getLblEtiquedaDeEntrada().setText((redondear(valorSalida)+" Fahrenheit"));

	}

	public void fahrenheitAcelsius() {
		double valorSalida = ((valorEntrada - 32) * 5 / 9);
		vct.getLblEtiquedaDeEntrada().setText(redondear(valorSalida)+" Celsius");

	}

	public String redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.0000");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}

	public boolean validar(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if (x > 0)
				;
			valorEntrada = x;
			return true;

		} catch (NumberFormatException e) {
			vct.getLblEtiquedaDeEntrada().setText("solamente numeros");
			return false;
		}
	}

	@Override
	
	public void actionPerformed(ActionEvent event) {
		vct.getBtnConvertir().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConversorDeTemperatura ct = new ConversorDeTemperatura(vct);
				ct.convertir();
			}
			
		});
		
	}
	/*public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}*/

}

