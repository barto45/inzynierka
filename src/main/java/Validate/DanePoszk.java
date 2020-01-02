package Validate;

import javax.swing.JOptionPane;

import javafx.scene.control.TextField;

public class DanePoszk extends TextField{
	 public void replaceText(int start, int end, String text) {
		
	        String old = getText();
	        if (text.matches("[a-zA-Z����󜟿�ʣ�ӌ�� ]*")) {
	            super.replaceText(start, end, text);
	        }
	        
	        if (getText().length() > 30)
	            setText(old);
	        positionCaret(getText().length());
	        
	        if(getText().trim().isEmpty())
	        	
	        	JOptionPane.showMessageDialog(null, "Z�e Has�o albo Login");
	        }

	    public void replaceSelection(String text) {
	        String old = getText();
	        if (text.matches("[a-zA-Z����󜟿�ʣ�ӌ��]*")) {
	            super.replaceSelection(text);
	        }
	        if (getText().length() > 30)
	            setText(old);
	        positionCaret(getText().length());
	        
            if(getText().length()<10)
	        	
	        	JOptionPane.showMessageDialog(null, "Z�e Has�o albo Login");
	    }
	}