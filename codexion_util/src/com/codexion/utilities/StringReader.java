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

	private JTextField txtOne = null;

	private JLabel lblText = null;

	private JButton btnEnter = null;

	/**
	 * This method initializes txtUno	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtOne() {
		if (txtOne == null) {
			txtOne = new JTextField();
			txtOne.setBounds(new Rectangle(30, 41, 285, 22));
		}
		return txtOne;
	}

	/**
	 * This method initializes btnCalcular	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnEnter() {
		if (btnEnter == null) {
			btnEnter = new JButton();
			btnEnter.setBounds(new Rectangle(197, 73, 118, 26));
			btnEnter.setText("Enter");
			btnEnter.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Date datenow = new Date();
					String thetext = txtOne.getText();
					System.out.println(datenow + " => " + thetext);
					txtOne.setText("");
					txtOne.requestFocusInWindow();
				}
			});
		}
		return btnEnter;
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
		this.getRootPane().setDefaultButton(btnEnter);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(335, 140);
		this.setContentPane(getJContentPane());
		this.setTitle("String Reader");
		// Centers the window on the screen
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((screenSize.width-335)/2, (screenSize.height-140)/2, 335, 140);
		// Disables resizing of the window and removes the Maximize button
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
			lblText.setText("Write something and press Enter:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getTxtOne(), null);
			jContentPane.add(lblText, null);
			jContentPane.add(getBtnEnter(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
