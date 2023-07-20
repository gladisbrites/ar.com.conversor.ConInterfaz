package ar.com.conversor.ConInterfaz.modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.event.MouseAdapter;

import ar.com.conversor.ConInterfaz.igu.VentanaConversorMoneda;

public class ConversorDeMoneda implements ActionListener {
	private double dolar = 264.57;
	private double euro = 229.28;
	private double libras = 346.34;
	private double yen = 1.91;
	private double won = 0.21;
	private double valorEntrada = 0.00;
    private VentanaConversorMoneda vcm;

	public ConversorDeMoneda(VentanaConversorMoneda vcm) {
		this.vcm=vcm;

	}
	 

	
	public void actionPerformed(ActionEvent event) {
		vcm.getBtnConvertir().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConversorDeMoneda cm = new ConversorDeMoneda(vcm);
				cm.convertir();
			}
			
		});
		
	}

	public  void convertir() {
			if (validar(vcm.getTextNumeroIngresado().getText())) {
				String money = (String) vcm.getCmbMonedas().getSelectedItem();
				switch (money) {
				case "De Pesos Argentinos a Dolar":
					pesosAMoneda(dolar, " dolares");
					break;
				case "De Pesos a Euro":
					pesosAMoneda(euro, " euros");
					break;
				case "De Pesos Artentinos a Libras Esterlinas":
					pesosAMoneda(libras, " libras");
					break;
				case "De Pesos Argentinos a Yen Japones":
					pesosAMoneda(yen, "yen Japonés");
					break;
				case "De Pesos Argentinos a Won surcoreano":
					pesosAMoneda(won, "Won Surcoreanos");
					break;
				case "De Dolar a Pesos Argentinos":
					monedaAPesos(dolar, "dolares son: ");
					break;
				case "De Euro a Pesos Argentinos":
					monedaAPesos(euro, "euros son: ");
					break;
				case "De Libras Esterlinas  a Pesos Argentinos":
					monedaAPesos(libras, " libras son: ");
					break;
				case "De Yen Japones a Pesos Argentinos":
					monedaAPesos(yen, "Yen son: ");
					break;
				case "De Won Surcoreano a Pesos Argentinos":
					monedaAPesos(won, "Won son: ");
					break;
	
				default:
					throw new IllegalArgumentException(" Valor invalido: " ); 
		
				}
		}
		

	}

	public void pesosAMoneda(double moneda, String nombreMoneda) {
		double valorSalida = valorEntrada / moneda;

		 vcm.getLblEtiquedaDeEntrada()
				.setText("Pesos Argentinos son: " + redondear(valorSalida) + nombreMoneda);

	}

	public void monedaAPesos(double moneda, String nombreMoneda) {
		double valorSalida = valorEntrada * moneda;
		 vcm.getLblEtiquedaDeEntrada()
				.setText(nombreMoneda + redondear(valorSalida) + " Pesos Argentinos");

	}

	public String redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}

	public boolean validar(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if (x > 0); 
				valorEntrada = x;
				return true;

		} catch (NumberFormatException e) {
			 vcm.getLblEtiquedaDeEntrada().setText("solamente numeros");
			 
			return false;
		}
	}

}
