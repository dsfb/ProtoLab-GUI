package com.google.sites.danieltcc1.model;

/**
 * Classe que define o módulo "válvula borboleta". Assim, define também as
 * propriedades do disco do sensor tipo TPS (Throttle Position Sensor).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since versão 1.0b1
 */
public class ElectronicThrottleModule {

	// declaração e instanciação de variáveis.
	private double currentOpeningAngleInRadians;
	private final double maximumOpeningAngleInRadians = 1.5707963267948966192313216916398;
	private final double minimumOpeningAngleInRadians = 0.0;

	private double currentOpeningAngleInDegrees;
	private final double maximumOpeningAngleInDegrees = 90.0;
	private final double minimumOpeningAngleInDegrees = 0.0;

	private double currentDifferenceOfElectricalPotential;
	private final double maximumDifferenceOfElectricalPotential = 4.55;
	private final double minimumDifferenceOfElectricalPotential = 0.95;

	private double currentOpeningFactor;
	private final double maximumOpeningFactor = 1.0;
	private final double minimumOpeningFactor = 0.0;

	/**
	 * Este método fixa a tensão elétrica equivalente à situação de abertura do
	 * disco deste módulo, isto é, o valor da variável (do tipo double)
	 * current_difference_of_electrical_potential. Assim, também fixa as outras
	 * variáveis (do tipo double) equivalentes para esta situação, isto é,
	 * current_opening_factor, current_opening_angle_in_degrees e
	 * current_opening_angle_in_radians.
	 * 
	 * @param current_difference_of_electrical_potential
	 *            - uma constante (do tipo double) fornecida para fixar a
	 *            variável current_difference_of_electrical_potential.
	 */
	public void setCurrent_difference_of_electrical_potential(
			double current_difference_of_electrical_potential) {
		this.currentDifferenceOfElectricalPotential = current_difference_of_electrical_potential;
		this.currentOpeningFactor = (this.currentDifferenceOfElectricalPotential - minimumDifferenceOfElectricalPotential)
				/ (maximumDifferenceOfElectricalPotential - minimumDifferenceOfElectricalPotential);
		this.currentOpeningAngleInDegrees = this.currentOpeningFactor * 90;
		this.currentOpeningAngleInRadians = this.currentOpeningFactor
				* Math.PI / 2;
	}

	/**
	 * Este método retorna a tensão elétrica equivalente à situação de abertura
	 * do disco deste módulo, isto é, o valor da variável (do tipo double)
	 * current_difference_of_electrical_potential.
	 * 
	 * @return o valor da variável (do tipo double)
	 *         current_difference_of_electrical_potential.
	 */
	public double getCurrent_difference_of_electrical_potential() {
		return this.currentDifferenceOfElectricalPotential;
	}

	/**
	 * Este método fixa o ângulo de abertura, em radianos, do disco deste
	 * módulo, isto é, o valor da variável (do tipo double)
	 * current_opening_angle_in_radians. Assim, também fixa as outras variáveis
	 * (do tipo double) equivalentes para esta situação, isto é,
	 * current_opening_factor, current_opening_angle_in_degrees e
	 * current_difference_of_electrical_potential.
	 * 
	 * @param current_opening_angle_in_radians
	 *            - uma constante (do tipo double) fornecida para fixar a
	 *            variável current_opening_angle_in_radians.
	 */
	public void setCurrent_opening_angle_in_radians(
			double current_opening_angle_in_radians) {
		this.currentOpeningAngleInRadians = current_opening_angle_in_radians;
		if (this.currentOpeningAngleInRadians > this.maximumOpeningAngleInRadians)
			this.currentOpeningAngleInRadians = this.maximumOpeningAngleInRadians;
		if (this.currentOpeningAngleInRadians < this.minimumOpeningAngleInRadians)
			this.currentOpeningAngleInRadians = this.minimumOpeningAngleInRadians;
		this.currentOpeningFactor = this.currentOpeningAngleInRadians * 2
				/ Math.PI;
		this.currentOpeningAngleInDegrees = this.currentOpeningFactor * 90;
		this.currentDifferenceOfElectricalPotential = this.currentOpeningFactor
				* (maximumDifferenceOfElectricalPotential - minimumDifferenceOfElectricalPotential)
				+ minimumDifferenceOfElectricalPotential;
	}

	/**
	 * Este método retorna o ângulo de abertura, em radianos, do disco deste
	 * módulo, isto é, o valor da variável (do tipo double)
	 * current_opening_angle_in_radians.
	 * 
	 * @return o valor da variável (do tipo double)
	 *         current_opening_angle_in_radians.
	 */
	public double getCurrent_opening_angle_in_radians() {
		return this.currentOpeningAngleInRadians;
	}

	/**
	 * Este método fixa o ângulo de abertura, em graus, do disco deste módulo,
	 * isto é, o valor da variável (do tipo double)
	 * current_opening_angle_in_degrees. Assim, também fixa as outras variáveis
	 * (do tipo double) equivalentes para esta situação, isto é,
	 * current_opening_factor, current_opening_angle_in_radians e
	 * current_difference_of_electrical_potential.
	 * 
	 * @param current_opening_angle_in_degrees
	 *            - uma constante (do tipo double) fornecida para fixar a
	 *            variável current_opening_angle_in_degrees.
	 */
	public void setCurrent_opening_angle_in_degrees(
			double current_opening_angle_in_degrees) {
		this.currentOpeningAngleInDegrees = current_opening_angle_in_degrees;
		if (this.currentOpeningAngleInDegrees > this.maximumOpeningAngleInDegrees)
			this.currentOpeningAngleInDegrees = this.maximumOpeningAngleInDegrees;
		if (this.currentOpeningAngleInDegrees < this.minimumOpeningAngleInDegrees)
			this.currentOpeningAngleInDegrees = this.minimumOpeningAngleInDegrees;
		this.currentOpeningFactor = this.currentOpeningAngleInRadians / 90;
		this.currentOpeningAngleInRadians = this.currentOpeningFactor
				* Math.PI / 2;
		this.currentDifferenceOfElectricalPotential = this.currentOpeningFactor
				* (maximumDifferenceOfElectricalPotential - minimumDifferenceOfElectricalPotential)
				+ minimumDifferenceOfElectricalPotential;
	}

	/**
	 * Este método retorna o ângulo de abertura, em graus, do disco deste
	 * módulo, isto é, o valor da variável (do tipo double)
	 * current_opening_angle_in_degrees.
	 * 
	 * @return o valor da variável (do tipo double)
	 *         current_opening_angle_in_degrees.
	 */
	public double getCurrent_opening_angle_in_degrees() {
		return this.currentOpeningAngleInDegrees;
	}

	/**
	 * Este método fixa o fator de abertura, do disco deste módulo, isto é, o
	 * valor da variável (do tipo double) current_opening_factor. Assim, também
	 * fixa as outras variáveis (do tipo double) equivalentes para esta
	 * situação, isto é, current_opening_angle_in_degrees,
	 * current_opening_angle_in_radians e
	 * current_difference_of_electrical_potential.
	 * 
	 * @param current_opening_factor
	 *            - uma constante (do tipo double) fornecida para fixar a
	 *            variável current_opening_factor.
	 */
	public void setCurrent_opening_factor(double current_opening_factor) {
		this.currentOpeningFactor = current_opening_factor;
		if (this.currentOpeningFactor > maximumOpeningFactor)
			this.currentOpeningFactor = maximumOpeningFactor;
		if (this.currentOpeningFactor < minimumOpeningFactor)
			this.currentOpeningFactor = minimumOpeningFactor;
		this.currentOpeningAngleInRadians = this.currentOpeningFactor
				* Math.PI / 2;
		this.currentOpeningAngleInDegrees = this.currentOpeningFactor * 90;
		this.currentDifferenceOfElectricalPotential = this.currentOpeningFactor
				* (maximumDifferenceOfElectricalPotential - minimumDifferenceOfElectricalPotential)
				+ minimumDifferenceOfElectricalPotential;
	}

	/**
	 * Este método retorna o fator de abertura, do disco deste módulo, isto é, o
	 * valor da variável (do tipo double) current_opening_factor.
	 * 
	 * @return o valor da variável (do tipo double) current_opening_factor.
	 */
	public double getCurrent_opening_factor() {
		return this.currentOpeningFactor;
	}
}