/**
 * CustomJTextarea.java - a JTextArea that allows control over the number of
 * words shown in it. Heavily based on Matthew Taylor's post on the coderanch
 * forum on 2005/08/16, see:
 * http://www.coderanch.com/t/341282/GUI/java/JTextArea
 * @author Lucas Vieites
 * @version 1.0
 */
package com.codexion.utilities;

import javax.swing.JTextArea;

public class CustomJTextarea extends JTextArea {
	/**
	 * Set a random version number
	 */
	private static final long serialVersionUID = -3041348754615853834L;

	/**
	 * Maximum words allowed in the textarea
	 */
	int maxWordCount;

	/**
	 * Default constructor
	 */
	public CustomJTextarea() {
		super();
	}

	/**
	 * Set the maximum number of words for this instance
	 * 
	 * @param i
	 *            An integer
	 */
	public void setMaxWordCount(int i) {
		maxWordCount = i;
	}

	/**
	 * Get the maximum number of words allowed in this instance
	 * 
	 * @return the number of allowed words for this instance
	 */
	public int getMaxWordCount() {
		return maxWordCount;
	}

	/**
	 * Control if the number of words in the textarea is higher than the maximum
	 * allowed
	 * 
	 * @return true or false
	 */
	public boolean isOverMaxWordCount() {
		if (getCurrentWordCount() > maxWordCount) {
			return true;
		}
		return false;
	}

	/**
	 * Remove the last word of the string in the textarea
	 */
	public void removeLastWord() {
		String txt = super.getText();
		txt = txt.substring(0, txt.lastIndexOf(" "));
		super.setText(txt);
	}

	/**
	 * Get the current number of words in the textarea
	 * 
	 * @return the number of word currently in the texarea
	 */
	public int getCurrentWordCount() {
		String txt = super.getText();
		return countWordsInString(txt);
	}

	/**
	 * Counts the words in the passed string
	 * 
	 * @param s
	 *            The string whose words will be counted
	 * @return the number of words in the passed string
	 */
	private int countWordsInString(String s) {
		String[] tmp = s.trim().split(" ");
		return tmp.length;
	}
}