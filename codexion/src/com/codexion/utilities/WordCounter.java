package com.codexion.utilities;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class WordCounter extends JFrame {
	private static final long serialVersionUID = 8819410241430015289L;

	private Container contentPane;

	private CustomJTextarea textArea;

	private JTextField reportingField;

	/** Creates a new instance of WordCounter */
	public WordCounter() {
		setPreferredSize(new Dimension(400, 400));
		setMaximumSize(new Dimension(800, 800));
		setTitle("Wordcounter 100");
		// Put the window on the center of the screen
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((screenSize.width-400)/2, (screenSize.height-400)/2, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textArea = new CustomJTextarea();
		// Set max word count to 100
		textArea.setMaxWordCount(100);
		textArea.setLineWrap(true);
		textArea.setEditable(true);
		textArea.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent evt) {
				if (textArea.isOverMaxWordCount()) {
					//textArea.removeLastWord();
					// Set color to red
					reportingField.setForeground(new Color(255,0,0));
				} else {
					// Set text color back to black
					reportingField.setForeground(new Color(0,0,0));
				}
				reportingField.setText("Words entered: "
						+ textArea.getCurrentWordCount());
			}

			public void keyReleased(KeyEvent evt) {
			}

			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		reportingField = new JTextField();
		contentPane = this.getContentPane();
		contentPane.add(textArea, BorderLayout.CENTER);
		contentPane.add(reportingField, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WordCounter();
	}
}