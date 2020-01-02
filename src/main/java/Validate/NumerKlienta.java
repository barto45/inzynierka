package Validate;

import javafx.scene.control.TextField;

public class NumerKlienta extends TextField{
	 public void replaceText(int start, int end, String text) {
	        String old = getText();
	        if (text.matches("[0-9]*")) {
	            super.replaceText(start, end, text);
	        }
	        if (getText().length() > 5)
	            setText(old);
	        positionCaret(getText().length());
	    }

	    public void replaceSelection(String text) {
	        String old = getText();
	        if (text.matches("[0-9]*")) {
	            super.replaceSelection(text);
	        }
	        if (getText().length() > 5)
	            setText(old);
	        positionCaret(getText().length());
	    }
	}