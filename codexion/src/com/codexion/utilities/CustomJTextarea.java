package com.codexion.utilities;

import javax.swing.JTextArea;

public class CustomJTextarea extends JTextArea {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3041348754615853834L;

	int maxWordCount;

	/**
	 * Creates a new instance of CustomJTextArea
	 */
	public CustomJTextarea() {
		super();
	}

	public void setMaxWordCount(int i) {
		maxWordCount = i;
	}

	public int getMaxWordCount() {
		return maxWordCount;
	}

	public boolean isOverMaxWordCount() {
		if (getCurrentWordCount() > maxWordCount) {
			return true;
		}
		return false;
	}

	public void removeLastWord() {
		String txt = super.getText();
		txt = txt.substring(0, txt.lastIndexOf(" "));
		super.setText(txt);
	}

	public int getCurrentWordCount() {
		String txt = super.getText();
		return countWordsInString(txt);
	}

	private int countWordsInString(String s) {
		String[] tmp = s.trim().split(" ");
		return tmp.length;
	}
}