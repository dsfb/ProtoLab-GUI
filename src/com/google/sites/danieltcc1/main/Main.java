package com.google.sites.danieltcc1.main;

import javax.swing.JFrame;

import com.google.sites.danieltcc1.control.*;
import com.google.sites.danieltcc1.view.*;

public class Main {
	public static void main(String[] args) {
		View vision = new View(args);
		vision.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Control control = new Control(vision);
		control.start();
	}
}