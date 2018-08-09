package com.google.sites.danieltcc1.model;

/**
 * Classe que define o ar como uma grandeza f�sica, do ponto de vista da teoria
 * qu�mica. Assim, o ar � definido pela temperatura, pela press�o, pelo volume,
 * pelo n�mero de mols, pela massa molar, pela massa e pelo fluxo de massa dele.
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since vers�o 1.0b1
 */
public class Air {

	// declara��o de vari�veis e constantes.
	private double temperature_kelvin;
	private double temperature_celsius;

	private double pressure_atm;
	private double pressure_bar;
	private double pressure_kPa;

	private double volum_liters;
	private double volum_m3;

	private double mass_flow_kg_h;

	private final double r_L_atm_mol_K = 0.08205746;
	private final double r_kPa_L_mol_K = 8.314472;
	private final double r_mbar_L_mol_K = 83.14472; // A ser usada numa vers�o
	// futura do software.

	private double air_molar_mass_g_mol = 28.96;

	private double mass_g;

	private double number_of_mole;

	/**
	 * Construtor de uma inst�ncia da classe. Aloca mem�ria para as vari�veis.
	 */
	Air() {

	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) massa_molar_ar_g_mol, com
	 * uma constante dada, isto �, o valor da massa molar do ar em g/mol.
	 * 
	 * @param massa_molar_ar_g_mol
	 *            uma constante (do tipo double) fornecida para fixar a vari�vel
	 *            massa_molar_ar_g_mol.
	 */
	public void setAir_molar_mass_g_mol(double air_molar_mass_g_mol) {
		this.air_molar_mass_g_mol = air_molar_mass_g_mol;
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) massa_molar_ar_g_mol,
	 * isto �, o valor da massa molar do ar em g/mol.
	 * 
	 * @return o valor da massa molar do ar em g/mol.
	 */
	public double getAir_molar_mass_g_mol() {
		return this.air_molar_mass_g_mol;
	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) temperatura_kelvin, com uma
	 * constante dada, isto �, o valor da temperatura do ar em K. Assim, ele
	 * tamb�m fixa a vari�vel temperatura_celsius com o aux�lio da rela��o
	 * matem�tica entre as temperaturas dadas em K e �C para uma mesma medida.
	 * 
	 * @param temperatura_kelvin
	 *            uma constante (do tipo double) fornecida para fixar a vari�vel
	 *            temperatura_kelvin.
	 */
	public void setTemperature_kelvin(double temperature_kelvin) {
		this.temperature_kelvin = temperature_kelvin;
		this.temperature_celsius = temperature_kelvin - 273.0;
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) temperatura_kelvin, isto
	 * �, o valor da temperatura do ar em K.
	 * 
	 * @return o valor da temperatura do ar em K.
	 */
	public double getTemperature_kelvin() {
		return this.temperature_kelvin;
	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) temperatura_celsius, com uma
	 * constante dada, isto �, o valor da temperatura do ar em �C. Assim, ele
	 * tamb�m fixa a vari�vel temperatura_kelvin com o aux�lio da rela��o
	 * matem�tica entre as temperaturas dadas em K e �C para uma mesma medida.
	 * 
	 * @param temperatura_celsius
	 *            uma constante (do tipo double) fornecida para fixar a vari�vel
	 *            temperatura_celsius.
	 */
	public void setTemperature_celsius(double temperature_celsius) {
		this.temperature_celsius = temperature_celsius;
		this.temperature_kelvin = temperature_celsius + 273.0;
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) temperatura_celsius, isto
	 * �, o valor da temperatura do ar em �C.
	 * 
	 * @return o valor da temperatura do ar em �C.
	 */
	public double getTemperature_celsius() {
		return this.temperature_celsius;
	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) pressao_atm, com uma
	 * constante dada, isto �, o valor da press�o do ar em atm. Assim, ele
	 * tamb�m fixa as vari�veis pressao_bar e pressao_kPa com o aux�lio da
	 * rela��o matem�tica entre as press�es dadas em kPa, bar e atm para uma
	 * mesma medida.
	 * 
	 * @param pressao_atm
	 *            uma constante (do tipo double) fornecida para fixar a vari�vel
	 *            pressao_atm.
	 */
	public void setPressure_atm(double pressure_atm) {
		this.pressure_atm = pressure_atm;
		this.pressure_bar = pressure_atm / 1.01325;
		this.pressure_kPa = 1.01325 * pressure_atm * 100.0;
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) pressao_atm, isto �, o
	 * valor da press�o do ar em atm.
	 * 
	 * @return o valor da press�o do ar em atm.
	 */
	public double getPressure_atm() {
		return this.pressure_atm;
	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) pressao_bar, com uma
	 * constante dada, isto �, o valor da press�o do ar em bar. Assim, ele
	 * tamb�m fixa as vari�veis pressao_atm e pressao_kPa com o aux�lio da
	 * rela��o matem�tica entre as press�es dadas em kPa, bar e atm para uma
	 * mesma medida.
	 * 
	 * @param pressao_bar
	 *            uma constante (do tipo double) fornecida para fixar a vari�vel
	 *            pressao_bar.
	 */
	public void setPressure_bar(double pressure_bar) {
		this.pressure_bar = pressure_bar;
		this.pressure_atm = pressure_bar * 1.01325;
		this.pressure_kPa = pressure_bar * 100.0;
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) pressao_bar, isto �, o
	 * valor da press�o do ar em bar.
	 * 
	 * @return o valor da press�o do ar em bar.
	 */
	public double getPressure_bar() {
		return this.pressure_bar;
	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) pressao_kPa, com uma
	 * constante dada, isto �, o valor da press�o do ar em kPa. Assim, ele
	 * tamb�m fixa as vari�veis pressao_atm e pressao_bar com o aux�lio da
	 * rela��o matem�tica entre as press�es dadas em kPa, bar e atm para uma
	 * mesma medida.
	 * 
	 * @param pressao_kPa
	 *            uma constante (do tipo double) fornecida para fixar a vari�vel
	 *            pressao_kPa.
	 */
	public void setPressure_kPa(double pressure_kPa) {
		this.pressure_kPa = pressure_kPa;
		this.pressure_atm = pressure_kPa / (1.01325 * 100);
		this.pressure_bar = pressure_kPa / 100.0;
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) pressao_kPa, isto �, o
	 * valor da press�o do ar em kPa.
	 * 
	 * @return o valor da press�o do ar em kPa.
	 */
	public double getPressure_kPa() {
		return this.pressure_kPa;
	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) volume_litros, com uma
	 * constante dada, isto �, o valor do volume do ar em litros. Assim, ele
	 * tamb�m fixa a vari�vel volume_m3 com o aux�lio da rela��o matem�tica
	 * entre os volumes dados em litros e metros c�bicos para uma mesma medida.
	 * 
	 * @param volume_litros
	 *            uma constante (do tipo double) fornecida para fixar a vari�vel
	 *            volume_litros.
	 */
	public void setVolum_liters(double volum_liters) {
		this.volum_liters = volum_liters;
		this.volum_m3 = volum_liters / 1000.0;
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) volume_litros, isto �, o
	 * valor do volume do ar em litros.
	 * 
	 * @return o valor do volume do ar em litros.
	 */
	public double getVolum_liters() {
		return volum_liters;
	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) volume_m3, com uma constante
	 * dada, isto �, o valor do volume do ar em metros c�bicos. Assim, ele
	 * tamb�m fixa a vari�vel volume_litros com o aux�lio da rela��o matem�tica
	 * entre os volumes dados em litros e metros c�bicos para uma mesma medida.
	 * 
	 * @param volume_m3
	 *            uma constante (do tipo double) fornecida para fixar a vari�vel
	 *            volume_m3.
	 */
	public void setVolum_m3(double volum_m3) {
		this.volum_m3 = volum_m3;
		this.volum_liters = volum_m3 * 1000.0;
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) volume_m3, isto �, o
	 * valor do volume do ar em metros c�bicos.
	 * 
	 * @return o valor do volume do ar em metros c�bicos.
	 */
	public double getVolum_m3() {
		return volum_m3;
	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) numero_mols, isto �, o valor
	 * do n�mero de mols do ar. Esta fixa��o ocorre com o aux�lio da equa��o de
	 * estado dos gases ideais.
	 */
	public void setNumber_of_mole_r_L_atm_mol_K() {
		this.number_of_mole = this.pressure_atm * this.volum_liters
				/ (this.r_L_atm_mol_K * this.temperature_kelvin);
	}

	public void setNumber_of_mole_r_kPa_L_mol_K() {
		this.number_of_mole = this.pressure_kPa * this.volum_liters
				/ (this.r_kPa_L_mol_K * this.temperature_kelvin);
	}

	public void setNumber_of_mole_r_mbar_L_mol_K() {
		this.number_of_mole = this.pressure_bar * 1000 * this.volum_liters
				/ (this.r_mbar_L_mol_K * this.temperature_kelvin);
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) numero_mols, isto �, o
	 * valor do n�mero de mols do ar.
	 * 
	 * @return o valor do n�mero de mols do ar.
	 */
	public double getNumber_of_mole() {
		return this.number_of_mole;
	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) massa_g, isto �, o valor da
	 * massa do ar em gramas. Esta fixa��o ocorre com o aux�lio da rela��o entre
	 * o n�mero de mols, a massa e a massa molar.
	 */
	public void setMass_g() {
		this.mass_g = this.number_of_mole * this.air_molar_mass_g_mol;
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) massa_g, isto �, o valor
	 * da massa do ar em gramas.
	 * 
	 * @return o valor da massa do ar em gramas.
	 */
	public double getMass_g() {
		return this.mass_g;
	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) fluxo_massa_kg_h, com uma
	 * constante dada, isto �, o valor do fluxo da massa do ar em kg/h.
	 * 
	 * @param fluxo_massa_kg_h
	 *            uma constante (do tipo double) fornecida para fixar a vari�vel
	 *            fluxo_massa_kg_h.
	 */
	public void setMass_flow_kg_h(double mass_flow_kg_h) {
		this.mass_flow_kg_h = mass_flow_kg_h;
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) fluxo_massa_kg_h, isto �,
	 * o valor do fluxo da massa do ar em kg/h.
	 * 
	 * @return o valor do fluxo da massa do ar em kg/h.
	 */
	public double getMass_flow_kg_h() {
		return this.mass_flow_kg_h;
	}
}