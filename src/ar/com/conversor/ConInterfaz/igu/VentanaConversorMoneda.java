package ar.com.conversor.ConInterfaz.igu;

import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;


import javax.swing.border.EmptyBorder;
import ar.com.conversor.ConInterfaz.modelo.ConversorDeMoneda;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class VentanaConversorMoneda extends JPanel {
	private JTextField textNumeroIngresado;
	private JButton btnConvertir;

	private  JComboBox cmbMonedas;
	private JLabel lblEtiquedaDeEntrada;
	private  JLabel lblTituloDelMenuComboBox;
	private  JLabel lblTituloCoversor;
	private ConversorDeMoneda convMoneda;
	

	public VentanaConversorMoneda() {
		convMoneda= new ConversorDeMoneda(this);
		setBackground(new Color(106, 106, 106));
		setForeground(new Color(255, 0, 0));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		lblTituloCoversor = new JLabel("Conversor de moneda");
		lblTituloCoversor.setForeground(new Color(255, 255, 255));
		lblTituloCoversor.setBounds(81, 11, 267, 36);
		lblTituloCoversor.setFont(new Font("Segoe UI Black", Font.PLAIN, 23));
		add(lblTituloCoversor);

		setLblEtiquedaDeEntrada(new JLabel("Ingrese el importe a convertir"));
		getLblEtiquedaDeEntrada().setForeground(new Color(255, 255, 255));
		getLblEtiquedaDeEntrada().setFont(new Font("Tahoma", Font.PLAIN, 15));
		getLblEtiquedaDeEntrada().setBounds(117, 68, 280, 30);
		add(getLblEtiquedaDeEntrada());

		setTextNumeroIngresado(new JTextField());
		getTextNumeroIngresado().setForeground(new Color(255, 255, 255));
		getTextNumeroIngresado().setHorizontalAlignment(SwingConstants.CENTER);
		getTextNumeroIngresado().setFont(new Font("Segoe UI Black", Font.BOLD, 19));
		getTextNumeroIngresado().setBackground(new Color(106, 106, 106));
		getTextNumeroIngresado().setBounds(10, 64, 97, 36);
		getTextNumeroIngresado().setToolTipText("");
		add(getTextNumeroIngresado());
		getTextNumeroIngresado().setColumns(10);

		lblTituloDelMenuComboBox = new JLabel(" Elija a que moneda a desea convertir su dinero");
		lblTituloDelMenuComboBox.setForeground(new Color(255, 255, 255));
		lblTituloDelMenuComboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTituloDelMenuComboBox.setBounds(62, 125, 286, 20);
		add(lblTituloDelMenuComboBox);

		setCmbMonedas(new JComboBox<String>());
		getCmbMonedas().setForeground(new Color(106, 106, 106));
		getCmbMonedas().setModel(new DefaultComboBoxModel<String>(monedas));

		getCmbMonedas().setBounds(30, 158, 211, 25);
		add(getCmbMonedas());

		btnConvertir = new JButton("Convertir");
		btnConvertir.setForeground(new Color(106, 106, 106));
		
		btnConvertir.addActionListener(convMoneda);
		btnConvertir.setBounds(257, 156, 129, 29);
		add(btnConvertir); 

	}

	public JButton getBtnConvertir() {
		return btnConvertir;
	}

	public void setBtnConvertir(JButton btnConvertir) {
		this.btnConvertir = btnConvertir;
	}

	public  JTextField getTextNumeroIngresado() {
		return textNumeroIngresado;
	}

	public void setTextNumeroIngresado(JTextField textNumeroIngresado) {
		this.textNumeroIngresado = textNumeroIngresado;
	}

	public  JComboBox getCmbMonedas() {
		return cmbMonedas;
	}

	public void setCmbMonedas(JComboBox<String> cmbMonedas) {
		this.cmbMonedas = cmbMonedas;
	}

	public  JLabel getLblEtiquedaDeEntrada() {
		return lblEtiquedaDeEntrada;
	}

	public void setLblEtiquedaDeEntrada(JLabel lblEtiquedaDeEntrada) {
		this.lblEtiquedaDeEntrada = lblEtiquedaDeEntrada;
	}

	private String[] monedas = new String[] { "De Pesos Argentinos a Dolar", "De Pesos a Euro",
			"De Pesos Artentinos a Libras Esterlinas", "De Pesos Argentinos a Yen Japones",
			"De Pesos Argentinos a Won surcoreano", "De Dolar a Pesos Argentinos", "De Euro a Pesos Argentinos",
			"De Libras Esterlinas  a Pesos Argentinos", "De Yen Japones a Pesos Argentinos",
			"De Won Surcoreano a Pesos Argentinos" 
			};
	}


