package com.google.sites.danieltcc1.model;

/**
 * Classe que define o motor universal. Assim, também define a frequência de
 * rotação dele.
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.1
 * @since versão 1.0b1
 */
public class UniversalMotor {

	// declaração e instanciação de variáveis.
	private double rotationFrequencyHz;
	private static final double MAXIMUM_ROTATION_FREQUENCY_HZ = 585.0;
	private static final double MINIMUM_ROTATION_FREQUENCY_HZ = 0.0;

	/**
	 * Este método fixa a frequência de rotação deste motor, isto é, o valor da
	 * variável (do tipo double) rotation_frequency_Hz.
	 * 
	 * @param rotationFrequency
	 *            - uma constante (do tipo double) fornecida para fixar a
	 *            variável rotation_frequency_Hz.
	 */
	public void setRotationFrequency(double rotationFrequency) {
		this.rotationFrequencyHz = Math.min(Math.max(rotationFrequency, MINIMUM_ROTATION_FREQUENCY_HZ), MAXIMUM_ROTATION_FREQUENCY_HZ);
	}

	/**
	 * Este método retorna a frequência de rotação deste motor, isto é, o valor
	 * da variável (do tipo double) rotation_frequency_Hz.
	 * 
	 * @return o valor da variável (do tipo double) rotation_frequency_Hz.
	 */
	public double getRotationFrequency() {
		return this.rotationFrequencyHz;
	}
}