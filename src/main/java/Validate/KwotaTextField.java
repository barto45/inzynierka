package Validate;

import javafx.scene.control.TextField;

public class KwotaTextField extends TextField{

	public void replaceText(int start, int end, String text) {
        String old = getText();
        if (text.matches("[0.00-9.00]*")) {
            super.replaceText(start, end, text);
        }
        if (getText().length() > 10)
            setText(old);
        positionCaret(getText().length());
    }

    public void replaceSelection(String text) {
        String old = getText();
        if (text.matches("[0.00-9.00]*")) {
            super.replaceSelection(text);
        }
        if (getText().length() > 10)
            setText(old);
        positionCaret(getText().length());
    }
}
			 
