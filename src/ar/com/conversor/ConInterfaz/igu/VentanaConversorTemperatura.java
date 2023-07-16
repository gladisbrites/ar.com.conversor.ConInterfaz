package ar.com.conversor.ConInterfaz.igu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class VentanaConversorTemperatura extends JPanel {
	private JTextField textNumeroIngresado;
	private JButton btnConvertir;
	private JComboBox cmbTemperaturas;
	private JLabel lblEtiquedaDeEntrada;
	private JLabel lblTituloDelMenuComboBox;
	private JLabel lblTituloCoversor;

	public double valorEntrada = 0.00;

	public VentanaConversorTemperatura() {

		setBackground(new Color(255, 128, 255));
		setForeground(new Color(255, 0, 0));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		lblTituloCoversor = new JLabel("Conversor de Temperatura");
		lblTituloCoversor.setBounds(62, 11, 324, 36);
		lblTituloCoversor.setFont(new Font("Segoe UI Black", Font.PLAIN, 23));
		add(lblTituloCoversor);

		lblEtiquedaDeEntrada = new JLabel("Ingrese la temperatura");
		lblEtiquedaDeEntrada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEtiquedaDeEntrada.setBounds(177, 68, 177, 20);
		add(lblEtiquedaDeEntrada);

		textNumeroIngresado = new JTextField();
		textNumeroIngresado.setHorizontalAlignment(SwingConstants.CENTER);
		textNumeroIngresado.setFont(new Font("Segoe UI Black", Font.BOLD, 19));
		textNumeroIngresado.setBackground(new Color(255, 128, 255));
		textNumeroIngresado.setBounds(62, 58, 97, 36);
		textNumeroIngresado.setToolTipText("");
		add(textNumeroIngresado);
		textNumeroIngresado.setColumns(10);

		lblTituloDelMenuComboBox = new JLabel("Elija la  medida a convertir");
		lblTituloDelMenuComboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTituloDelMenuComboBox.setBounds(62, 120, 164, 25);
		add(lblTituloDelMenuComboBox);

		cmbTemperaturas = new JComboBox<String>();
		cmbTemperaturas.setModel(new DefaultComboBoxModel<String>(temperaturas));

		cmbTemperaturas.setBounds(30, 158, 211, 25);
		add(cmbTemperaturas);

		btnConvertir = new JButton("Convertir");
		btnConvertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				convertir();
			}
		});
		btnConvertir.setBounds(257, 156, 129, 29);
		add(btnConvertir);

	}

	String[] temperaturas = { "grados celsius a fahrenheit", "fahrenheit a grados celsius" };

	public void convertir() {
		if (validar(textNumeroIngresado.getText())) {
			String tempe = (String) cmbTemperaturas.getSelectedItem();
			switch (tempe) {
			case "grados celsius a fahrenheit":
				celsiusAFahrenheit();
				break;
			case "fahrenheit a grados celsius":
				fahrenheitAcelsius();
				break;
			default:
				throw new IllegalArgumentException(" Valor invalido: " + temperaturas);
			}
		}
		;

	}

	public void celsiusAFahrenheit() {
		double valorSalida = (valorEntrada * 9 / 5 + 32);
		lblEtiquedaDeEntrada.setText(redondear(valorSalida));

	}

	public void fahrenheitAcelsius() {
		double valorSalida = ((valorEntrada - 32) * 5 / 9);
		lblEtiquedaDeEntrada.setText(redondear(valorSalida));

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
			lblEtiquedaDeEntrada.setText("solamente numeros");
			return false;
		}
	}
}
