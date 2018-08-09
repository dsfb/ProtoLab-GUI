package com.google.sites.danieltcc1.main;

import com.google.sites.danieltcc1.control.*;
import com.google.sites.danieltcc1.vision.*;

public class Main {
	public static void main(String[] args) {
		Vision vision = new Vision(args);
		Control control = new Control(vision);

		control.start();
	}
}