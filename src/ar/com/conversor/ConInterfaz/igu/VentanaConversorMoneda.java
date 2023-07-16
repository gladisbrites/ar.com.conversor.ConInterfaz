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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaConversorMoneda extends JPanel {
	private static JTextField textNumeroIngresado;
	private JButton btnConvertir;

	private static JComboBox cmbMonedas;
	private static JLabel lblEtiquedaDeEntrada;
	private static JLabel lblTituloDelMenuComboBox;
	private static JLabel lblTituloCoversor;

	public VentanaConversorMoneda() {

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
		btnConvertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConversorDeMoneda cm = new ConversorDeMoneda();
				cm.convertir();
			}
		});
		btnConvertir.setBounds(257, 156, 129, 29);
		add(btnConvertir);

	}

	public static JTextField getTextNumeroIngresado() {
		return textNumeroIngresado;
	}

	public void setTextNumeroIngresado(JTextField textNumeroIngresado) {
		this.textNumeroIngresado = textNumeroIngresado;
	}

	public static JComboBox getCmbMonedas() {
		return cmbMonedas;
	}

	public void setCmbMonedas(JComboBox cmbMonedas) {
		this.cmbMonedas = cmbMonedas;
	}

	public static JLabel getLblEtiquedaDeEntrada() {
		return lblEtiquedaDeEntrada;
	}

	public void setLblEtiquedaDeEntrada(JLabel lblEtiquedaDeEntrada) {
		this.lblEtiquedaDeEntrada = lblEtiquedaDeEntrada;
	}

	private String[] monedas = new String[] { "De Pesos Argentinos a Dolar", "De Pesos a Euro",
			"De Pesos Artentinos a Libras Esterlinas", "De Pesos Argentinos a Yen Japones",
			"De Pesos Argentinos a Won surcoreano", "De Dolar a Pesos Argentinos", "De Euro a Pesos Argentinos",
			"De Libras Esterlinas  a Pesos Argentinos", "De Yen Japones a Pesos Argentinos",
			"De Won Surcoreano a Pesos Argentinos" };

}
