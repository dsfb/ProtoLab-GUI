package com.google.sites.danieltcc1.model;

/**
 * Classe que define o modelo abstrato. Esta classe recebe como entrada dois
 * n�meros reais, que s�o a frequ�ncia de rota��o do motor universal (0-280Hz) e
 * o fator de abertura do m�dulo "v�lvula borboleta" (0-1) e fornece na sa�da o
 * fluxo da massa do ar admitido (kg/h) ou a press�o do ar admitido (kPa).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since vers�o 1.0b1
 */
public class Model {

	// declara��o de vari�veis e constantes.
	private double input1;
	private double input2;

	private double output;

	private double pressure_kPa;
	private double volum_L;
	private double molar_mass_g_mol;
	private final double r_kPa_L_mol_K = 8.314472;
	private double temperature_k;

	/**
	 * Construtor de uma inst�ncia da classe. Aloca mem�ria para as vari�veis.
	 */
	Model() {

	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) entrada1, isto �, o valor
	 * real de uma das entradas deste modelo.
	 * 
	 * @param entrada1
	 *            uma constante (do tipo double) fornecida para fixar a vari�vel
	 *            entrada1.
	 */
	public void setInput1(double input1) {
		this.input1 = input1;
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) entrada1, isto �, o valor
	 * real de uma das entradas deste modelo.
	 * 
	 * @return o valor real de uma das entradas deste modelo.
	 */
	public double getInput1() {
		return this.input1;
	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) entrada2, isto �, o valor
	 * real de uma das entradas deste modelo.
	 * 
	 * @param entrada2
	 *            uma constante (do tipo double) fornecida para fixar a vari�vel
	 *            entrada2.
	 */
	public void setInput2(double input2) {
		this.input2 = input2;
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) entrada2, isto �, o valor
	 * real de uma das entradas deste modelo.
	 * 
	 * @return o valor real de uma das entradas deste modelo.
	 */
	public double getInput2() {
		return this.input2;
	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) saida, isto �, o valor real
	 * da sa�da deste modelo.
	 * 
	 */
	public void setOutput() {

	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) saida, isto �, o valor real
	 * da sa�da deste modelo.
	 * 
	 * @param saida
	 *            uma constante (do tipo double) fornecida para fixar a vari�vel
	 *            saida.
	 */
	public void setOutput(double output) {
		this.output = output;
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) saida, isto �, o valor
	 * real da sa�da deste modelo.
	 * 
	 * @return o valor real da sa�da deste modelo.
	 */
	public double getOutput() {
		return this.output;
	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) pressao_kPa, com uma
	 * constante dada, isto �, o valor da press�o do ar em kPa.
	 * 
	 * @param pressao_kPa
	 *            uma constante (do tipo double) fornecida para fixar a vari�vel
	 *            pressao_kPa.
	 */
	public void setPressure_kPa(double pressure_kPa) {
		this.pressure_kPa = pressure_kPa;
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
	 * constante dada, isto �, o valor do volume do ar em litros.
	 * 
	 * @param volume_L
	 *            uma constante (do tipo double) fornecida para fixar a vari�vel
	 *            volume_L.
	 */
	public void setVolum_L(double volum_L) {
		this.volum_L = volum_L;
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) volume_L, isto �, o valor
	 * do volume do ar em litros.
	 * 
	 * @return o valor do volume do ar em litros.
	 */
	public double getVolum_L() {
		return this.volum_L;
	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) massa_molar_g_mol, com uma
	 * constante dada, isto �, o valor da massa molar do ar em g/mol.
	 * 
	 * @param massa_molar_g_mol
	 *            uma constante (do tipo double) fornecida para fixar a vari�vel
	 *            massa_molar_g_mol.
	 */
	public void setMolar_mass_g_mol(double molar_mass_g_mol) {
		this.molar_mass_g_mol = molar_mass_g_mol;
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) massa_molar_g_mol, isto
	 * �, o valor da massa molar do ar em g/mol.
	 * 
	 * @return o valor da massa molar do ar em g/mol.
	 */
	public double getMolar_mass_g_mol() {
		return this.molar_mass_g_mol;
	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) temperatura_k, com uma
	 * constante dada, isto �, o valor da temperatura do ar em K.
	 * 
	 * @param temperatura_k
	 *            uma constante (do tipo double) fornecida para fixar a vari�vel
	 *            temperatura_k.
	 */
	public void setTemperature_k(double temperature_k) {
		this.temperature_k = temperature_k;
	}

	/**
	 * Este m�todo retorna a vari�vel (do tipo double) temperatura_k, isto �, o
	 * valor da temperatura do ar em K.
	 * 
	 * @return o valor da temperatura do ar em K.
	 */
	public double getTemperature_k() {
		return this.temperature_k;
	}

	/**
	 * Este m�todo retorna a constante (do tipo double) r_kPa_L_mol_K, isto �, o
	 * valor da constante universal dos gases.
	 * 
	 * @return o valor da constante universal dos gases.
	 */
	public double getR_kPa_L_mol_K() {
		return this.r_kPa_L_mol_K;
	}

}
