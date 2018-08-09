package com.google.sites.danieltcc1.model;

/**
 * Classe que define o quinto modelo, fenomenol�gico, feito com polin�mios do
 * quarto grau. Esta classe recebe como entrada dois n�meros reais, que s�o a
 * frequ�ncia de rota��o do motor universal (0-280Hz) e o fator de abertura do
 * m�dulo "v�lvula borboleta" (0-1) e fornece na sa�da o fluxo da massa do ar
 * admitido (kg/h).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since vers�o 1.0b1
 */
public class Model5_maf extends Model {

	// declara��o e instancia��o de vari�veis.
	private double[] polinomio;

	private double[][] polinomios;

	private double coef;

	private final int coeficientes_modelo = 4;

	private final int numero_termos_polinomio = 7;

	/**
	 * Construtor de uma inst�ncia da classe. Aloca mem�ria para as vari�veis
	 * (do tipo double) polinomio e polinomios.
	 */
	Model5_maf() {

		// declara��o e instancia��o de vari�veis.
		polinomio = new double[coeficientes_modelo];
		polinomios = new double[coeficientes_modelo][numero_termos_polinomio];

		polinomios[0][0] = 0.10934;
		polinomios[0][1] = 4.138;
		polinomios[0][2] = -30.122;
		polinomios[0][3] = 123.6;
		polinomios[0][4] = -235.5;
		polinomios[0][5] = 203.81;
		polinomios[0][6] = -65.263;

		polinomios[1][0] = -0.0046654;
		polinomios[1][1] = -0.52166;
		polinomios[1][2] = 5.235;
		polinomios[1][3] = -21.987;
		polinomios[1][4] = 41.704;
		polinomios[1][5] = -36.06;
		polinomios[1][6] = 11.594;

		polinomios[2][0] = 0.018061;
		polinomios[2][1] = 2.7705;
		polinomios[2][2] = -26.313;
		polinomios[2][3] = 109.51;
		polinomios[2][4] = -208.24;
		polinomios[2][5] = 181.17;
		polinomios[2][6] = -58.701;

		polinomios[3][0] = -0.00032115;
		polinomios[3][1] = -0.04727;
		polinomios[3][2] = 0.42173;
		polinomios[3][3] = -1.7424;
		polinomios[3][4] = 3.3263;
		polinomios[3][5] = -2.9141;
		polinomios[3][6] = 0.95185;

	}

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) saida, isto �, o valor real
	 * da sa�da deste modelo.
	 * 
	 */
	public void setOutput() {

		// declara��o e instancia��o de vari�vel.
		coef = 0;

		// c�lculo matem�tico do valor definitivo de vari�veis.
		for (int i = 0; i < coeficientes_modelo; i++)
			polinomio[i] = 0;

		for (int i = 0; i < coeficientes_modelo; i++)
			for (int c = 0; c < numero_termos_polinomio; c++)
				polinomio[i] = polinomio[i] + polinomios[i][c]
						* Math.pow(getInput2(), c);

		polinomio[1] /= 10;
		polinomio[2] /= 10000;
		polinomio[3] /= 100000;

		for (int c = 0; c < coeficientes_modelo; c++) {
			coef = coef + polinomio[c] * Math.pow(getInput1(), c + 1);
		}

		// fixa��o de valor.
		setOutput(coef);

	}

}
