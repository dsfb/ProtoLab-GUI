package com.google.sites.danieltcc1.view.defined;

import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.Document;

public class TextField extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int INSET_VALUE = 1;
	private static final int BORDER_VALUE = 3;
	private static final int ins = INSET_VALUE;

	private void customize() {
		this.setFont(Defaults.getFont());
		this.setMargin(new Insets(ins, ins, ins, ins));
		Border border = BorderFactory.createEmptyBorder(BORDER_VALUE, BORDER_VALUE,
														BORDER_VALUE, BORDER_VALUE);
		this.setBorder(border);
	}
	
	public TextField() {
		super();
		this.customize();
	}

	public TextField(Document doc, String text, int columns) {
		super(doc, text, columns);
		this.customize();
	}

	public TextField(int columns) {
		super(columns);
		this.customize();
	}

	public TextField(String text, int columns) {
		super(text, columns);
		this.customize();
	}

	public TextField(String text) {
		super(text);
		this.customize();
	}
}
