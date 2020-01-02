package Validate;

import javax.swing.JOptionPane;

import javafx.scene.control.TextField;

public class DanePoszk extends TextField{
	 public void replaceText(int start, int end, String text) {
		
	        String old = getText();
	        if (text.matches("[a-zA-Z¹æê³ñóœŸ¿¥Ê£ÑÓŒ¯ ]*")) {
	            super.replaceText(start, end, text);
	        }
	        
	        if (getText().length() > 30)
	            setText(old);
	        positionCaret(getText().length());
	        
	        if(getText().trim().isEmpty())
	        	
	        	JOptionPane.showMessageDialog(null, "Z³e Has³o albo Login");
	        }

	    public void replaceSelection(String text) {
	        String old = getText();
	        if (text.matches("[a-zA-Z¹æê³ñóœŸ¿¥Ê£ÑÓŒ¯]*")) {
	            super.replaceSelection(text);
	        }
	        if (getText().length() > 30)
	            setText(old);
	        positionCaret(getText().length());
	        
            if(getText().length()<10)
	        	
	        	JOptionPane.showMessageDialog(null, "Z³e Has³o albo Login");
	    }
	}