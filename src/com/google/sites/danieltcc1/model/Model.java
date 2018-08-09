package com.google.sites.danieltcc1.model;

/**
 * Classe que define o modelo abstrato. Esta classe recebe como entrada dois
 * números reais, que são a frequência de rotação do motor universal (0-280Hz) e
 * o fator de abertura do módulo "válvula borboleta" (0-1) e fornece na saída o
 * fluxo da massa do ar admitido (kg/h) ou a pressão do ar admitido (kPa).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since versão 1.0b1
 */
public class Model {

	// declaração de variáveis e constantes.
	private double input1;
	private double input2;

	private double output;

	private double pressure_kPa;
	private double volum_L;
	private double molar_mass_g_mol;
	private final double r_kPa_L_mol_K = 8.314472;
	private double temperature_k;

	/**
	 * Construtor de uma instância da classe. Aloca memória para as variáveis.
	 */
	Model() {

	}

	/**
	 * Este método fixa a variável (do tipo double) entrada1, isto é, o valor
	 * real de uma das entradas deste modelo.
	 * 
	 * @param entrada1
	 *            uma constante (do tipo double) fornecida para fixar a variável
	 *            entrada1.
	 */
	public void setInput1(double input1) {
		this.input1 = input1;
	}

	/**
	 * Este método retorna a variável (do tipo double) entrada1, isto é, o valor
	 * real de uma das entradas deste modelo.
	 * 
	 * @return o valor real de uma das entradas deste modelo.
	 */
	public double getInput1() {
		return this.input1;
	}

	/**
	 * Este método fixa a variável (do tipo double) entrada2, isto é, o valor
	 * real de uma das entradas deste modelo.
	 * 
	 * @param entrada2
	 *            uma constante (do tipo double) fornecida para fixar a variável
	 *            entrada2.
	 */
	public void setInput2(double input2) {
		this.input2 = input2;
	}

	/**
	 * Este método retorna a variável (do tipo double) entrada2, isto é, o valor
	 * real de uma das entradas deste modelo.
	 * 
	 * @return o valor real de uma das entradas deste modelo.
	 */
	public double getInput2() {
		return this.input2;
	}

	/**
	 * Este método fixa a variável (do tipo double) saida, isto é, o valor real
	 * da saída deste modelo.
	 * 
	 */
	public void setOutput() {

	}

	/**
	 * Este método fixa a variável (do tipo double) saida, isto é, o valor real
	 * da saída deste modelo.
	 * 
	 * @param saida
	 *            uma constante (do tipo double) fornecida para fixar a variável
	 *            saida.
	 */
	public void setOutput(double output) {
		this.output = output;
	}

	/**
	 * Este método retorna a variável (do tipo double) saida, isto é, o valor
	 * real da saída deste modelo.
	 * 
	 * @return o valor real da saída deste modelo.
	 */
	public double getOutput() {
		return this.output;
	}

	/**
	 * Este método fixa a variável (do tipo double) pressao_kPa, com uma
	 * constante dada, isto é, o valor da pressão do ar em kPa.
	 * 
	 * @param pressao_kPa
	 *            uma constante (do tipo double) fornecida para fixar a variável
	 *            pressao_kPa.
	 */
	public void setPressure_kPa(double pressure_kPa) {
		this.pressure_kPa = pressure_kPa;
	}

	/**
	 * Este método retorna a variável (do tipo double) pressao_kPa, isto é, o
	 * valor da pressão do ar em kPa.
	 * 
	 * @return o valor da pressão do ar em kPa.
	 */
	public double getPressure_kPa() {
		return this.pressure_kPa;
	}

	/**
	 * Este método fixa a variável (do tipo double) volume_litros, com uma
	 * constante dada, isto é, o valor do volume do ar em litros.
	 * 
	 * @param volume_L
	 *            uma constante (do tipo double) fornecida para fixar a variável
	 *            volume_L.
	 */
	public void setVolum_L(double volum_L) {
		this.volum_L = volum_L;
	}

	/**
	 * Este método retorna a variável (do tipo double) volume_L, isto é, o valor
	 * do volume do ar em litros.
	 * 
	 * @return o valor do volume do ar em litros.
	 */
	public double getVolum_L() {
		return this.volum_L;
	}

	/**
	 * Este método fixa a variável (do tipo double) massa_molar_g_mol, com uma
	 * constante dada, isto é, o valor da massa molar do ar em g/mol.
	 * 
	 * @param massa_molar_g_mol
	 *            uma constante (do tipo double) fornecida para fixar a variável
	 *            massa_molar_g_mol.
	 */
	public void setMolar_mass_g_mol(double molar_mass_g_mol) {
		this.molar_mass_g_mol = molar_mass_g_mol;
	}

	/**
	 * Este método retorna a variável (do tipo double) massa_molar_g_mol, isto
	 * é, o valor da massa molar do ar em g/mol.
	 * 
	 * @return o valor da massa molar do ar em g/mol.
	 */
	public double getMolar_mass_g_mol() {
		return this.molar_mass_g_mol;
	}

	/**
	 * Este método fixa a variável (do tipo double) temperatura_k, com uma
	 * constante dada, isto é, o valor da temperatura do ar em K.
	 * 
	 * @param temperatura_k
	 *            uma constante (do tipo double) fornecida para fixar a variável
	 *            temperatura_k.
	 */
	public void setTemperature_k(double temperature_k) {
		this.temperature_k = temperature_k;
	}

	/**
	 * Este método retorna a variável (do tipo double) temperatura_k, isto é, o
	 * valor da temperatura do ar em K.
	 * 
	 * @return o valor da temperatura do ar em K.
	 */
	public double getTemperature_k() {
		return this.temperature_k;
	}

	/**
	 * Este método retorna a constante (do tipo double) r_kPa_L_mol_K, isto é, o
	 * valor da constante universal dos gases.
	 * 
	 * @return o valor da constante universal dos gases.
	 */
	public double getR_kPa_L_mol_K() {
		return this.r_kPa_L_mol_K;
	}

}
