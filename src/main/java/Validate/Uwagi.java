package Validate;

import javafx.scene.control.TextField;

public class Uwagi extends TextField{
	 public void replaceText(int start, int end, String text) {
	        String old = getText();
	        if (text.matches("[a-zA-Z¹æê³ñóœŸ¿¥Ê£ÑÓŒ¯0-9 ]*")) {
	            super.replaceText(start, end, text);
	        }
	        if (getText().length() > 100)
	            setText(old);
	        positionCaret(getText().length());
	    }

	    public void replaceSelection(String text) {
	        String old = getText();
	        if (text.matches("[a-zA-Z¹æê³ñóœŸ¿¥Ê£ÑÓŒ¯0-9]*")) {
	            super.replaceSelection(text);
	        }
	        if (getText().length() > 100)
	            setText(old);
	        positionCaret(getText().length());
	    }
	}