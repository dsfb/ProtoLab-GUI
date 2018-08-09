package com.google.sites.danieltcc1.model;

/**
 * Classe que define o terceiro modelo, fenomenol�gico, feito com polin�mios do
 * segundo grau. Esta classe recebe como entrada dois n�meros reais, que s�o a
 * frequ�ncia de rota��o do motor universal (0-280Hz) e o fator de abertura do
 * m�dulo "v�lvula borboleta" (0-1) e fornece na sa�da o fluxo da massa do ar
 * admitido (kg/h).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since vers�o 1.0b1
 */
public class Model3_maf extends Model {

	// declara��o e instancia��o de vari�veis.
	private double[] polinomio;

	private double[][] polinomios;

	private double coef;

	private final int coeficientes_modelo = 2;

	private final int numero_termos_polinomio = 7;

	/**
	 * Construtor de uma inst�ncia da classe. Aloca mem�ria para as vari�veis
	 * (do tipo double) polinomio e polinomios.
	 */
	Model3_maf() {

		// declara��o e instancia��o de vari�veis.
		polinomio = new double[coeficientes_modelo];
		polinomios = new double[coeficientes_modelo][numero_termos_polinomio];

		polinomios[0][0] = 0.093263;
		polinomios[0][1] = 1.3979;
		polinomios[0][2] = -0.34323;
		polinomios[0][3] = -2.09;
		polinomios[0][4] = 1.7086;
		polinomios[0][5] = 0.2118;
		polinomios[0][6] = -0.35086;

		polinomios[1][0] = -0.0015366;
		polinomios[1][1] = -0.017853;
		polinomios[1][2] = 0.12513;
		polinomios[1][3] = -0.56938;
		polinomios[1][4] = 1.1326;
		polinomios[1][5] = -1.0026;
		polinomios[1][6] = 0.32679;

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

		polinomio[1] = polinomio[1] / 10;

		for (int c = 0; c < coeficientes_modelo; c++) {
			coef = coef + polinomio[c] * Math.pow(getInput1(), c + 1);
		}

		// fixa��o de valor.
		setOutput(coef);

	}

}
