package com.google.sites.danieltcc1.model;

/**
 * Classe que define o motor universal. Assim, tamb�m define a frequ�ncia de
 * rota��o dele.
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.1
 * @since vers�o 1.0b1
 */
public class UniversalMotor {

	// declara��o e instancia��o de vari�veis.
	private double rotationFrequencyHz;
	private static final double MAXIMUM_ROTATION_FREQUENCY_HZ = 585.0;
	private static final double MINIMUM_ROTATION_FREQUENCY_HZ = 0.0;

	/**
	 * Este m�todo fixa a frequ�ncia de rota��o deste motor, isto �, o valor da
	 * vari�vel (do tipo double) rotation_frequency_Hz.
	 * 
	 * @param rotationFrequency
	 *            - uma constante (do tipo double) fornecida para fixar a
	 *            vari�vel rotation_frequency_Hz.
	 */
	public void setRotationFrequency(double rotationFrequency) {
		this.rotationFrequencyHz = Math.min(Math.max(rotationFrequency, MINIMUM_ROTATION_FREQUENCY_HZ), MAXIMUM_ROTATION_FREQUENCY_HZ);
	}

	/**
	 * Este m�todo retorna a frequ�ncia de rota��o deste motor, isto �, o valor
	 * da vari�vel (do tipo double) rotation_frequency_Hz.
	 * 
	 * @return o valor da vari�vel (do tipo double) rotation_frequency_Hz.
	 */
	public double getRotationFrequency() {
		return this.rotationFrequencyHz;
	}
}