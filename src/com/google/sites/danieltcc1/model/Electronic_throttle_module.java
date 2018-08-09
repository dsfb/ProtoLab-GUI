package com.google.sites.danieltcc1.model;

/**
 * Classe que define o módulo "válvula borboleta". Assim, define também as
 * propriedades do disco do sensor tipo TPS (Throttle Position Sensor).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since versão 1.0b1
 */
public class Electronic_throttle_module {

	// declaração e instanciação de variáveis.
	private double current_opening_angle_in_radians;
	private final double maximum_opening_angle_in_radians = 1.5707963267948966192313216916398;
	private final double minimum_opening_angle_in_radians = 0.0;

	private double current_opening_angle_in_degrees;
	private final double maximum_opening_angle_in_degrees = 90.0;
	private final double minimum_opening_angle_in_degrees = 0.0;

	private double current_difference_of_electrical_potential;
	private final double maximum_difference_of_electrical_potential = 4.55;
	private final double minimum_difference_of_electrical_potential = 0.95;

	private double current_opening_factor;
	private final double maximum_opening_factor = 1.0;
	private final double minimum_opening_factor = 0.0;

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
		this.current_difference_of_electrical_potential = current_difference_of_electrical_potential;
		this.current_opening_factor = (this.current_difference_of_electrical_potential - minimum_difference_of_electrical_potential)
				/ (maximum_difference_of_electrical_potential - minimum_difference_of_electrical_potential);
		this.current_opening_angle_in_degrees = this.current_opening_factor * 90;
		this.current_opening_angle_in_radians = this.current_opening_factor
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
		return this.current_difference_of_electrical_potential;
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
		this.current_opening_angle_in_radians = current_opening_angle_in_radians;
		if (this.current_opening_angle_in_radians > this.maximum_opening_angle_in_radians)
			this.current_opening_angle_in_radians = this.maximum_opening_angle_in_radians;
		if (this.current_opening_angle_in_radians < this.minimum_opening_angle_in_radians)
			this.current_opening_angle_in_radians = this.minimum_opening_angle_in_radians;
		this.current_opening_factor = this.current_opening_angle_in_radians * 2
				/ Math.PI;
		this.current_opening_angle_in_degrees = this.current_opening_factor * 90;
		this.current_difference_of_electrical_potential = this.current_opening_factor
				* (maximum_difference_of_electrical_potential - minimum_difference_of_electrical_potential)
				+ minimum_difference_of_electrical_potential;
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
		return this.current_opening_angle_in_radians;
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
		this.current_opening_angle_in_degrees = current_opening_angle_in_degrees;
		if (this.current_opening_angle_in_degrees > this.maximum_opening_angle_in_degrees)
			this.current_opening_angle_in_degrees = this.maximum_opening_angle_in_degrees;
		if (this.current_opening_angle_in_degrees < this.minimum_opening_angle_in_degrees)
			this.current_opening_angle_in_degrees = this.minimum_opening_angle_in_degrees;
		this.current_opening_factor = this.current_opening_angle_in_radians / 90;
		this.current_opening_angle_in_radians = this.current_opening_factor
				* Math.PI / 2;
		this.current_difference_of_electrical_potential = this.current_opening_factor
				* (maximum_difference_of_electrical_potential - minimum_difference_of_electrical_potential)
				+ minimum_difference_of_electrical_potential;
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
		return this.current_opening_angle_in_degrees;
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
		this.current_opening_factor = current_opening_factor;
		if (this.current_opening_factor > maximum_opening_factor)
			this.current_opening_factor = maximum_opening_factor;
		if (this.current_opening_factor < minimum_opening_factor)
			this.current_opening_factor = minimum_opening_factor;
		this.current_opening_angle_in_radians = this.current_opening_factor
				* Math.PI / 2;
		this.current_opening_angle_in_degrees = this.current_opening_factor * 90;
		this.current_difference_of_electrical_potential = this.current_opening_factor
				* (maximum_difference_of_electrical_potential - minimum_difference_of_electrical_potential)
				+ minimum_difference_of_electrical_potential;
	}

	/**
	 * Este método retorna o fator de abertura, do disco deste módulo, isto é, o
	 * valor da variável (do tipo double) current_opening_factor.
	 * 
	 * @return o valor da variável (do tipo double) current_opening_factor.
	 */
	public double getCurrent_opening_factor() {
		return this.current_opening_factor;
	}
}