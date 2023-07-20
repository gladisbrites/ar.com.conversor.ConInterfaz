package ar.com.conversor.ConInterfaz.igu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import ar.com.conversor.ConInterfaz.modelo.ConversorDeTemperatura;

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
	private ConversorDeTemperatura convTempt;

	

	public VentanaConversorTemperatura() {
		convTempt =new ConversorDeTemperatura(this);
		setBackground(new Color(0, 64, 128));
		setForeground(new Color(255, 0, 0));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		lblTituloCoversor = new JLabel("Conversor de Temperatura");
		lblTituloCoversor.setForeground(new Color(255, 255, 255));
		lblTituloCoversor.setBounds(62, 11, 324, 36);
		lblTituloCoversor.setFont(new Font("Segoe UI Black", Font.PLAIN, 23));
		add(lblTituloCoversor);

		lblEtiquedaDeEntrada = new JLabel("Ingrese la temperatura");
		lblEtiquedaDeEntrada.setForeground(new Color(255, 255, 255));
		lblEtiquedaDeEntrada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEtiquedaDeEntrada.setBounds(177, 68, 177, 20);
		add(lblEtiquedaDeEntrada);

		textNumeroIngresado = new JTextField();
		textNumeroIngresado.setForeground(new Color(255, 255, 255));
		textNumeroIngresado.setHorizontalAlignment(SwingConstants.CENTER);
		textNumeroIngresado.setFont(new Font("Segoe UI Black", Font.BOLD, 19));
		textNumeroIngresado.setBackground(new Color(0, 64, 128));
		textNumeroIngresado.setBounds(62, 58, 97, 36);
		textNumeroIngresado.setToolTipText("");
		add(textNumeroIngresado);
		textNumeroIngresado.setColumns(10);

		lblTituloDelMenuComboBox = new JLabel("Elija a que  medida a convertir");
		lblTituloDelMenuComboBox.setForeground(new Color(255, 255, 255));
		lblTituloDelMenuComboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTituloDelMenuComboBox.setBounds(136, 121, 201, 25);
		add(lblTituloDelMenuComboBox);

		cmbTemperaturas = new JComboBox<String>();
		cmbTemperaturas.setForeground(new Color(0, 0, 128));
		cmbTemperaturas.setModel(new DefaultComboBoxModel<String>(temperaturas));

		cmbTemperaturas.setBounds(30, 158, 211, 25);
		add(cmbTemperaturas);

		btnConvertir = new JButton("Convertir");
		btnConvertir.setForeground(new Color(0, 0, 128));
		btnConvertir.addActionListener(convTempt);
		/*btnConvertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				convertir();
			}
		});*/
		btnConvertir.setBounds(257, 156, 129, 29);
		add(btnConvertir);

	}

	String[] temperaturas = { "grados celsius a fahrenheit", "fahrenheit a grados celsius" };



	public JTextField getTextNumeroIngresado() {
		return textNumeroIngresado;
	}

	public void setTextNumeroIngresado(JTextField textNumeroIngresado) {
		this.textNumeroIngresado = textNumeroIngresado;
	}

	public JButton getBtnConvertir() {
		return btnConvertir;
	}

	public void setBtnConvertir(JButton btnConvertir) {
		this.btnConvertir = btnConvertir;
	}

	public JComboBox getCmbTemperaturas() {
		return cmbTemperaturas;
	}

	public void setCmbTemperaturas(JComboBox cmbTemperaturas) {
		this.cmbTemperaturas = cmbTemperaturas;
	}

	public JLabel getLblEtiquedaDeEntrada() {
		return lblEtiquedaDeEntrada;
	}

	public void setLblEtiquedaDeEntrada(JLabel lblEtiquedaDeEntrada) {
		this.lblEtiquedaDeEntrada = lblEtiquedaDeEntrada;
	}


	

	public String[] getTemperaturas() {
		return temperaturas;
	}

	public void setTemperaturas(String[] temperaturas) {
		this.temperaturas = temperaturas;
	}

	
}
