package com.codexion.utilities;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class WordCounter extends JFrame {
	/**
	 * WordCounter.java - a little program to write 100 word texts, also known as
	 * "drabbles"
	 * @author Lucas Vieites
	 * @version 1.0
	 */
	
	/**
	 * Set a random version number
	 */
	private static final long serialVersionUID = 8819410241430015289L;

	/**
	 * A container to put all the UI elements in
	 */
	private Container contentPane;

	/**
	 * A customised JTextArea
	 */
	private CustomJTextarea textArea;

	/**
	 * A textfield to put messages in, especially the current word count
	 */
	private JTextField reportingField;

	/**
	 * Creates a new instance of WordCounter
	 */
	public WordCounter() {
		// Set the size of the JFrame
		setPreferredSize(new Dimension(400, 400));
		// We don't want it to become larger that this
		setMaximumSize(new Dimension(800, 800));
		// Set a title for the window
		setTitle("Wordcounter 100");
		// Put the window on the center of the screen
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
		this.setBounds((screenSize.width - 400) / 2,
				(screenSize.height - 400) / 2, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create the area we'll write in and tweak it a little bit to our
		// liking
		textArea = new CustomJTextarea();
		// Set max word count to 100
		textArea.setMaxWordCount(100);
		textArea.setLineWrap(true);
		textArea.setEditable(true);
		textArea.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent evt) {
				// Check if we have typed too many words
				if (textArea.isOverMaxWordCount()) {
					// Remove the last word so as to not exceed the max number
					// Commented out as it's not intuitive
					// textArea.removeLastWord();
					// Set color to red
					reportingField.setForeground(new Color(255, 0, 0));
				} else {
					// We're back under the max number
					// Set text color back to black
					reportingField.setForeground(new Color(0, 0, 0));
				}
				// Inform of the current number of words
				reportingField.setText("Words entered: "
						+ textArea.getCurrentWordCount());
			}

			public void keyReleased(KeyEvent evt) {
			}

			public void keyPressed(KeyEvent arg0) {

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
	 * Create a JFrame with the custom textarea in which we will write
	 * @param args
	 */
	public static void main(String[] args) {
		// Call the constructor
		new WordCounter();
	}
}