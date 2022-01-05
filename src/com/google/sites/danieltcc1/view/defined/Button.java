package com.google.sites.danieltcc1.view.defined;

import java.awt.Insets;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.Border;

public class Button extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int INSET_VALUE = 4;
	private static final int BORDER_VALUE = 6;
	private static final int ins = INSET_VALUE;
	private static final int bor = BORDER_VALUE;


	private void customize() {
		this.setFont(Defaults.getFont());
		this.setMargin(new Insets(ins, ins, ins, ins));
		Border border = BorderFactory.createEmptyBorder(bor, bor, bor, bor);
		this.setBorder(border);
	}

	public Button() {
		super();
		this.customize();
	}

	public Button(Action a) {
		super(a);
		this.customize();
	}

	public Button(Icon icon) {
		super(icon);
		this.customize();
	}

	public Button(String text, Icon icon) {
		super(text, icon);
		this.customize();
	}

	public Button(String text) {
		super(text);
		this.customize();
	}
}
