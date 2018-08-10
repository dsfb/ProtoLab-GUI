package com.google.sites.danieltcc1.main;

import com.google.sites.danieltcc1.control.*;
import com.google.sites.danieltcc1.view.*;

public class Main {
	public static void main(String[] args) {
		View vision = new View(args);
		Control control = new Control(vision);

		control.start();
	}
}