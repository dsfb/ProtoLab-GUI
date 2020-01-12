package com.google.sites.danieltcc1.model;

/**
 * Classe que define o terceiro modelo, fenomenológico, feito com polinômios do
 * segundo grau. Esta classe recebe como entrada dois números reais, que são a
 * frequência de rotação do motor universal (0-280Hz) e o fator de abertura do
 * módulo "válvula borboleta" (0-1) e fornece na saída a pressão do ar admitido
 * (kPa).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since versão 1.0b1
 */
public class ThirdMapModel extends Model {

	// declaração e instanciação de variáveis.
	private double[] polynomial;

	private double[][] polynomials;

	private double coefficient;

	private final int model_coefficients = 3;

	private final int numberOfPolynomialTerms = 7;

	/**
	 * Construtor de uma instância da classe. Aloca memória para as variáveis
	 * (do tipo double) polinomio e polinomios.
	 */
	ThirdMapModel() {

		// declaração e instanciação de variáveis.
		polynomial = new double[model_coefficients];
		polynomials = new double[model_coefficients][numberOfPolynomialTerms];

		polynomials[2][0] = 0.0022995;
		polynomials[2][1] = -0.22368;
		polynomials[2][2] = 3.0077;
		polynomials[2][3] = -15.727;
		polynomials[2][4] = 38.959;
		polynomials[2][5] = -45.826;
		polynomials[2][6] = 20.606;

		polynomials[1][0] = 0.082976;
		polynomials[1][1] = 4.0984;
		polynomials[1][2] = -57.474;
		polynomials[1][3] = 291.9;
		polynomials[1][4] = -702.65;
		polynomials[1][5] = 806.14;
		polynomials[1][6] = -354.51;

		polynomials[0][0] = 4.6781;
		polynomials[0][1] = 48.648;
		polynomials[0][2] = -1407.5;
		polynomials[0][3] = 8673.4;
		polynomials[0][4] = -22654;
		polynomials[0][5] = 27074;
		polynomials[0][6] = -12207;

	}

	/**
	 * Este método fixa a variável (do tipo double) saida, isto é, o valor real
	 * da saída deste modelo.
	 * 
	 */
	public void setOutput() {

		// declaração e instanciação de variável.
		coefficient = 0;

		// cálculo matemático do valor definitivo de variáveis.
		for (int i = 0; i < model_coefficients; i++)
			polynomial[i] = 0;

		for (int i = 0; i < model_coefficients; i++)
			for (int c = 0; c < numberOfPolynomialTerms; c++)
				polynomial[i] = polynomial[i] + polynomials[i][c]
						* Math.pow(getInput2(), c);

		polynomial[2] = polynomial[2] / 10;

		for (int c = 0; c < model_coefficients; c++) {
			coefficient = coefficient + polynomial[c] * Math.pow(getInput1(), c);
		}

		// fixação de valor.
		setOutput(getPressure_kPa()
				- (coefficient * getR_kPa_L_mol_K() * getTemperature_k() / (1000 * getVolum_L() * getMolar_mass_g_mol())));

		if (getInput2() >= 0.67 || getInput1() == 0) {
			setOutput(getPressure_kPa());
			return;
		}

	}

}
