package Validate;

import javafx.scene.control.TextField;

public class Name extends TextField{
	 public void replaceText(int start, int end, String text) {
	        String old = getText();
	        if (text.matches("[a-zA-Z¹æê³ñóœŸ¿¥Ê£ÑÓŒ¯ ]*")) {
	            super.replaceText(start, end, text);
	        }
	        if (getText().length() > 30)
	            setText(old);
	        positionCaret(getText().length());
	    }

	    public void replaceSelection(String text) {
	        String old = getText();
	        if (text.matches("[a-zA-Z¹æê³ñóœŸ¿¥Ê£ÑÓŒ¯]*")) {
	            super.replaceSelection(text);
	        }
	        if (getText().length() > 30)
	            setText(old);
	        positionCaret(getText().length());
	    }
	}