package com.google.sites.danieltcc1.model;

/**
 * Classe que define o motor universal. Assim, tamb�m define a frequ�ncia de
 * rota��o dele.
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.1
 * @since vers�o 1.0b1
 */
public class Universal_motor {

	// declara��o e instancia��o de vari�veis.
	private double rotation_frequency_Hz;
	private final double maximum_rotation_frequency_Hz = 585.0;
	private final double minimum_rotation_frequency_Hz = 0.0;

	/**
	 * Este m�todo fixa a frequ�ncia de rota��o deste motor, isto �, o valor da
	 * vari�vel (do tipo double) rotation_frequency_Hz.
	 * 
	 * @param rotation_frequency_Hz
	 *            - uma constante (do tipo double) fornecida para fixar a
	 *            vari�vel rotation_frequency_Hz.
	 */
	public void setRotation_frequency_Hz(double rotation_frequency_Hz) {
		this.rotation_frequency_Hz = rotation_frequency_Hz;
		if (this.rotation_frequency_Hz > maximum_rotation_frequency_Hz)
			this.rotation_frequency_Hz = maximum_rotation_frequency_Hz;
		if (this.rotation_frequency_Hz < minimum_rotation_frequency_Hz)
			this.rotation_frequency_Hz = minimum_rotation_frequency_Hz;
	}

	/**
	 * Este m�todo retorna a frequ�ncia de rota��o deste motor, isto �, o valor
	 * da vari�vel (do tipo double) rotation_frequency_Hz.
	 * 
	 * @return o valor da vari�vel (do tipo double) rotation_frequency_Hz.
	 */
	public double getRotation_frequency_Hz() {
		return this.rotation_frequency_Hz;
	}
}