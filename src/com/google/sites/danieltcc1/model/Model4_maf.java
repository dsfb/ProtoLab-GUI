package com.google.sites.danieltcc1.model;

/**
 * Classe que define o quarto modelo, fenomenol�gico, feito com polin�mios do
 * terceiro grau. Esta classe recebe como entrada dois n�meros reais, que s�o a
 * frequ�ncia de rota��o do motor universal (0-280Hz) e o fator de abertura do
 * m�dulo "v�lvula borboleta" (0-1) e fornece na sa�da o fluxo da massa do ar
 * admitido (kg/h).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since vers�o 1.0b1
 */
public class Model4_maf extends Model {

	// declara��o e instancia��o de vari�veis.
	private double[] polinomio;

	private double[][] polinomios;

	private double coef;

	private final int coeficientes_modelo = 3;

	private final int numero_termos_polinomio = 7;

	/**
	 * Construtor de uma inst�ncia da classe. Aloca mem�ria para as vari�veis
	 * (do tipo double) polinomio e polinomios.
	 */
	Model4_maf() {

		// declara��o e instancia��o de vari�veis.
		polinomio = new double[coeficientes_modelo];
		polinomios = new double[coeficientes_modelo][numero_termos_polinomio];

		polinomios[0][0] = 0.095604;
		polinomios[0][1] = 2.1176;
		polinomios[0][2] = -12.096;
		polinomios[0][3] = 49.117;
		polinomios[0][4] = -93.314;
		polinomios[0][5] = 79.241;
		polinomios[0][6] = -24.576;

		polinomios[1][0] = -0.0018066;
		polinomios[1][1] = -0.10087;
		polinomios[1][2] = 1.4808;
		polinomios[1][3] = -6.4761;
		polinomios[1][4] = 12.093;
		polinomios[1][5] = -10.118;
		polinomios[1][6] = 3.1211;

		polinomios[2][0] = 0.00070061;
		polinomios[2][1] = 0.21538;
		polinomios[2][2] = -3.5172;
		polinomios[2][3] = 15.325;
		polinomios[2][4] = -28.437;
		polinomios[2][5] = 23.65;
		polinomios[2][6] = -7.2496;

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

		for (int c = 0; c < coeficientes_modelo; c++) {
			coef = coef + polinomio[c] * Math.pow(getInput1(), c + 1);
		}

		// fixa��o de valor.
		setOutput(coef);

	}

}
