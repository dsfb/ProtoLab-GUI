package com.google.sites.danieltcc1.model;

/**
 * Classe que define o motor universal. Assim, também define a frequência de
 * rotação dele.
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.1
 * @since versão 1.0b1
 */
public class Universal_motor {

	// declaração e instanciação de variáveis.
	private double rotation_frequency_Hz;
	private final double maximum_rotation_frequency_Hz = 585.0;
	private final double minimum_rotation_frequency_Hz = 0.0;

	/**
	 * Este método fixa a frequência de rotação deste motor, isto é, o valor da
	 * variável (do tipo double) rotation_frequency_Hz.
	 * 
	 * @param rotation_frequency_Hz
	 *            - uma constante (do tipo double) fornecida para fixar a
	 *            variável rotation_frequency_Hz.
	 */
	public void setRotation_frequency_Hz(double rotation_frequency_Hz) {
		this.rotation_frequency_Hz = rotation_frequency_Hz;
		if (this.rotation_frequency_Hz > maximum_rotation_frequency_Hz)
			this.rotation_frequency_Hz = maximum_rotation_frequency_Hz;
		if (this.rotation_frequency_Hz < minimum_rotation_frequency_Hz)
			this.rotation_frequency_Hz = minimum_rotation_frequency_Hz;
	}

	/**
	 * Este método retorna a frequência de rotação deste motor, isto é, o valor
	 * da variável (do tipo double) rotation_frequency_Hz.
	 * 
	 * @return o valor da variável (do tipo double) rotation_frequency_Hz.
	 */
	public double getRotation_frequency_Hz() {
		return this.rotation_frequency_Hz;
	}
}