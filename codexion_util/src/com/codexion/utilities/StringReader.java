package com.codexion.utilities;

import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JButton;

public class StringReader extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTextField txtUno = null;

	private JLabel lblText = null;

	private JButton btnCalcular = null;

	/**
	 * This method initializes txtUno	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtUno() {
		if (txtUno == null) {
			txtUno = new JTextField();
			txtUno.setBounds(new Rectangle(30, 41, 285, 22));
		}
		return txtUno;
	}

	/**
	 * This method initializes btnCalcular	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnCalcular() {
		if (btnCalcular == null) {
			btnCalcular = new JButton();
			btnCalcular.setBounds(new Rectangle(197, 73, 118, 26));
			btnCalcular.setText("Enter");
			btnCalcular.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Date ahora = new Date();
					String primero = txtUno.getText();
					System.out.println(ahora + " => " + primero);
					txtUno.setText("");
					txtUno.requestFocusInWindow();
				}
			});
		}
		return btnCalcular;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StringReader thisClass = new StringReader();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public StringReader() {
		super();
		initialize();
		this.getRootPane().setDefaultButton(btnCalcular);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(335, 140);
		this.setContentPane(getJContentPane());
		this.setTitle("Lector de texto");
		// Pone la ventana en el centro de la pantalla
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((screenSize.width-335)/2, (screenSize.height-140)/2, 335, 140);
		// Desactiva la capacidad de cambiar el tamaño de la ventana
		// y elimina el botón de maximizar
		this.setResizable(false);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblText = new JLabel();
			lblText.setBounds(new Rectangle(32, 12, 283, 19));
			lblText.setText("Introduzca texto y pulse Enter:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getTxtUno(), null);
			jContentPane.add(lblText, null);
			jContentPane.add(getBtnCalcular(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
