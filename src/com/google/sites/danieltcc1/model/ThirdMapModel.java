package com.google.sites.danieltcc1.model;

/**
 * Classe que define o terceiro modelo, fenomenol�gico, feito com polin�mios do
 * segundo grau. Esta classe recebe como entrada dois n�meros reais, que s�o a
 * frequ�ncia de rota��o do motor universal (0-280Hz) e o fator de abertura do
 * m�dulo "v�lvula borboleta" (0-1) e fornece na sa�da a press�o do ar admitido
 * (kPa).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since vers�o 1.0b1
 */
public class ThirdMapModel extends Model {

	// declara��o e instancia��o de vari�veis.
	private double[] polynomial;

	private double[][] polynomials;

	private double coefficient;

	private final int model_coefficients = 3;

	private final int numberOfPolynomialTerms = 7;

	/**
	 * Construtor de uma inst�ncia da classe. Aloca mem�ria para as vari�veis
	 * (do tipo double) polinomio e polinomios.
	 */
	ThirdMapModel() {

		// declara��o e instancia��o de vari�veis.
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
	 * Este m�todo fixa a vari�vel (do tipo double) saida, isto �, o valor real
	 * da sa�da deste modelo.
	 * 
	 */
	public void setOutput() {

		// declara��o e instancia��o de vari�vel.
		coefficient = 0;

		// c�lculo matem�tico do valor definitivo de vari�veis.
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

		// fixa��o de valor.
		setOutput(getPressure_kPa()
				- (coefficient * getR_kPa_L_mol_K() * getTemperature_k() / (1000 * getVolum_L() * getMolar_mass_g_mol())));

		if (getInput2() >= 0.67 || getInput1() == 0) {
			setOutput(getPressure_kPa());
			return;
		}

	}

}
