package com.google.sites.danieltcc1.model;

/**
 * Classe que define o ar como uma grandeza física, do ponto de vista da teoria
 * química. Assim, o ar é definido pela temperatura, pela pressão, pelo volume,
 * pelo número de mols, pela massa molar, pela massa e pelo fluxo de massa dele.
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since versão 1.0b1
 */
public class Air {

	// declaração de variáveis e constantes.
	private double temperatureKelvin;
	private double temperatureCelsius;

	private double pressureAtm;
	private double pressureBar;
	private double pressureInkPa;

	private double volumLiters;
	private double volumInm3;

	private double massFlowInkgPerh;
	
	// They are the definition of "Gas constant", as defined on:
	// https://en.wikipedia.org/wiki/Gas_constant, and defined
	// in Brazilian Language as: "Constante universal dos gases perfeitos".
	// Available on: https://pt.wikipedia.org/wiki/Constante_universal_dos_gases_perfeitos
	// Observation: In May 2019, these constant values are redefined for being more precise...!
	private final double r_L_atm_mol_K = 0.082057366080960;
	private final double r_kPa_L_mol_K = 8.31446261815324;
	private final double r_mbar_L_mol_K = 8.31446261815324; // Not used now...!

	private double air_molar_mass_g_mol = 28.96;

	private double mass_g;

	private double number_of_mole;

	/**
	 * Construtor de uma instância da classe. Aloca memória para as variáveis.
	 */
	Air() {

	}

	/**
	 * Este método fixa a variável (do tipo double) massa_molar_ar_g_mol, com
	 * uma constante dada, isto é, o valor da massa molar do ar em g/mol.
	 * 
	 * @param massa_molar_ar_g_mol
	 *            uma constante (do tipo double) fornecida para fixar a variável
	 *            massa_molar_ar_g_mol.
	 */
	public void setAir_molar_mass_g_mol(double air_molar_mass_g_mol) {
		this.air_molar_mass_g_mol = air_molar_mass_g_mol;
	}

	/**
	 * Este método retorna a variável (do tipo double) massa_molar_ar_g_mol,
	 * isto é, o valor da massa molar do ar em g/mol.
	 * 
	 * @return o valor da massa molar do ar em g/mol.
	 */
	public double getAir_molar_mass_g_mol() {
		return this.air_molar_mass_g_mol;
	}

	/**
	 * Este método fixa a variável (do tipo double) temperatura_kelvin, com uma
	 * constante dada, isto é, o valor da temperatura do ar em K. Assim, ele
	 * também fixa a variável temperatura_celsius com o auxílio da relação
	 * matemática entre as temperaturas dadas em K e °C para uma mesma medida.
	 * 
	 * @param temperatura_kelvin
	 *            uma constante (do tipo double) fornecida para fixar a variável
	 *            temperatura_kelvin.
	 */
	public void setTemperatureKelvin(double temperatureKelvin) {
		this.temperatureKelvin = temperatureKelvin;
		this.temperatureCelsius = temperatureKelvin - 273.0;
	}

	/**
	 * Este método retorna a variável (do tipo double) temperatura_kelvin, isto
	 * é, o valor da temperatura do ar em K.
	 * 
	 * @return o valor da temperatura do ar em K.
	 */
	public double getTemperatureKelvin() {
		return this.temperatureKelvin;
	}

	/**
	 * Este método fixa a variável (do tipo double) temperatura_celsius, com uma
	 * constante dada, isto é, o valor da temperatura do ar em °C. Assim, ele
	 * também fixa a variável temperatura_kelvin com o auxílio da relação
	 * matemática entre as temperaturas dadas em K e °C para uma mesma medida.
	 * 
	 * @param temperatura_celsius
	 *            uma constante (do tipo double) fornecida para fixar a variável
	 *            temperatura_celsius.
	 */
	public void setTemperatureCelsius(double temperatureCelsius) {
		this.temperatureCelsius = temperatureCelsius;
		this.temperatureKelvin = temperatureCelsius + 273.0;
	}

	/**
	 * Este método retorna a variável (do tipo double) temperatura_celsius, isto
	 * é, o valor da temperatura do ar em °C.
	 * 
	 * @return o valor da temperatura do ar em °C.
	 */
	public double getTemperatureCelsius() {
		return this.temperatureCelsius;
	}

	/**
	 * Este método fixa a variável (do tipo double) pressao_atm, com uma
	 * constante dada, isto é, o valor da pressão do ar em atm. Assim, ele
	 * também fixa as variáveis pressao_bar e pressao_kPa com o auxílio da
	 * relação matemática entre as pressões dadas em kPa, bar e atm para uma
	 * mesma medida.
	 * 
	 * @param pressao_atm
	 *            uma constante (do tipo double) fornecida para fixar a variável
	 *            pressao_atm.
	 */
	public void setPressureAtm(double pressureAtm) {
		this.pressureAtm = pressureAtm;
		this.pressureBar = pressureAtm / 1.01325;
		this.pressureInkPa = 1.01325 * pressureAtm * 100.0;
	}

	/**
	 * Este método retorna a variável (do tipo double) pressao_atm, isto é, o
	 * valor da pressão do ar em atm.
	 * 
	 * @return o valor da pressão do ar em atm.
	 */
	public double getPressureAtm() {
		return this.pressureAtm;
	}

	/**
	 * Este método fixa a variável (do tipo double) pressao_bar, com uma
	 * constante dada, isto é, o valor da pressão do ar em bar. Assim, ele
	 * também fixa as variáveis pressao_atm e pressao_kPa com o auxílio da
	 * relação matemática entre as pressões dadas em kPa, bar e atm para uma
	 * mesma medida.
	 * 
	 * @param pressao_bar
	 *            uma constante (do tipo double) fornecida para fixar a variável
	 *            pressao_bar.
	 */
	public void setPressureBar(double pressureBar) {
		this.pressureBar = pressureBar;
		this.pressureAtm = pressureBar * 1.01325;
		this.pressureInkPa = pressureBar * 100.0;
	}

	/**
	 * Este método retorna a variável (do tipo double) pressao_bar, isto é, o
	 * valor da pressão do ar em bar.
	 * 
	 * @return o valor da pressão do ar em bar.
	 */
	public double getPressure_bar() {
		return this.pressureBar;
	}

	/**
	 * Este método fixa a variável (do tipo double) pressao_kPa, com uma
	 * constante dada, isto é, o valor da pressão do ar em kPa. Assim, ele
	 * também fixa as variáveis pressao_atm e pressao_bar com o auxílio da
	 * relação matemática entre as pressões dadas em kPa, bar e atm para uma
	 * mesma medida.
	 * 
	 * @param pressao_kPa
	 *            uma constante (do tipo double) fornecida para fixar a variável
	 *            pressao_kPa.
	 */
	public void setPressure_kPa(double pressure_kPa) {
		this.pressureInkPa = pressure_kPa;
		this.pressureAtm = pressure_kPa / (1.01325 * 100);
		this.pressureBar = pressure_kPa / 100.0;
	}

	/**
	 * Este método retorna a variável (do tipo double) pressao_kPa, isto é, o
	 * valor da pressão do ar em kPa.
	 * 
	 * @return o valor da pressão do ar em kPa.
	 */
	public double getPressure_kPa() {
		return this.pressureInkPa;
	}

	/**
	 * Este método fixa a variável (do tipo double) volume_litros, com uma
	 * constante dada, isto é, o valor do volume do ar em litros. Assim, ele
	 * também fixa a variável volume_m3 com o auxílio da relação matemática
	 * entre os volumes dados em litros e metros cúbicos para uma mesma medida.
	 * 
	 * @param volume_litros
	 *            uma constante (do tipo double) fornecida para fixar a variável
	 *            volume_litros.
	 */
	public void setVolum_liters(double volum_liters) {
		this.volumLiters = volum_liters;
		this.volumInm3 = volum_liters / 1000.0;
	}

	/**
	 * Este método retorna a variável (do tipo double) volume_litros, isto é, o
	 * valor do volume do ar em litros.
	 * 
	 * @return o valor do volume do ar em litros.
	 */
	public double getVolum_liters() {
		return volumLiters;
	}

	/**
	 * Este método fixa a variável (do tipo double) volume_m3, com uma constante
	 * dada, isto é, o valor do volume do ar em metros cúbicos. Assim, ele
	 * também fixa a variável volume_litros com o auxílio da relação matemática
	 * entre os volumes dados em litros e metros cúbicos para uma mesma medida.
	 * 
	 * @param volume_m3
	 *            uma constante (do tipo double) fornecida para fixar a variável
	 *            volume_m3.
	 */
	public void setVolum_m3(double volum_m3) {
		this.volumInm3 = volum_m3;
		this.volumLiters = volum_m3 * 1000.0;
	}

	/**
	 * Este método retorna a variável (do tipo double) volume_m3, isto é, o
	 * valor do volume do ar em metros cúbicos.
	 * 
	 * @return o valor do volume do ar em metros cúbicos.
	 */
	public double getVolum_m3() {
		return volumInm3;
	}

	/**
	 * Este método fixa a variável (do tipo double) numero_mols, isto é, o valor
	 * do número de mols do ar. Esta fixação ocorre com o auxílio da equação de
	 * estado dos gases ideais.
	 */
	public void setNumber_of_mole_r_L_atm_mol_K() {
		this.number_of_mole = this.pressureAtm * this.volumLiters
				/ (this.r_L_atm_mol_K * this.temperatureKelvin);
	}

	public void setNumber_of_mole_r_kPa_L_mol_K() {
		this.number_of_mole = this.pressureInkPa * this.volumLiters
				/ (this.r_kPa_L_mol_K * this.temperatureKelvin);
	}

	public void setNumber_of_mole_r_mbar_L_mol_K() {
		this.number_of_mole = this.pressureBar * 1000 * this.volumLiters
				/ (this.r_mbar_L_mol_K * this.temperatureKelvin);
	}

	/**
	 * Este método retorna a variável (do tipo double) numero_mols, isto é, o
	 * valor do número de mols do ar.
	 * 
	 * @return o valor do número de mols do ar.
	 */
	public double getNumber_of_mole() {
		return this.number_of_mole;
	}

	/**
	 * Este método fixa a variável (do tipo double) massa_g, isto é, o valor da
	 * massa do ar em gramas. Esta fixação ocorre com o auxílio da relação entre
	 * o número de mols, a massa e a massa molar.
	 */
	public void setMass_g() {
		this.mass_g = this.number_of_mole * this.air_molar_mass_g_mol;
	}

	/**
	 * Este método retorna a variável (do tipo double) massa_g, isto é, o valor
	 * da massa do ar em gramas.
	 * 
	 * @return o valor da massa do ar em gramas.
	 */
	public double getMass_g() {
		return this.mass_g;
	}

	/**
	 * Este método fixa a variável (do tipo double) fluxo_massa_kg_h, com uma
	 * constante dada, isto é, o valor do fluxo da massa do ar em kg/h.
	 * 
	 * @param fluxo_massa_kg_h
	 *            uma constante (do tipo double) fornecida para fixar a variável
	 *            fluxo_massa_kg_h.
	 */
	public void setMass_flow_kg_h(double mass_flow_kg_h) {
		this.massFlowInkgPerh = mass_flow_kg_h;
	}

	/**
	 * Este método retorna a variável (do tipo double) fluxo_massa_kg_h, isto é,
	 * o valor do fluxo da massa do ar em kg/h.
	 * 
	 * @return o valor do fluxo da massa do ar em kg/h.
	 */
	public double getMass_flow_kg_h() {
		return this.massFlowInkgPerh;
	}
}