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
public class Model3_map extends Model {

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
	Model3_map() {

		// declara��o e instancia��o de vari�veis.
		polinomio = new double[coeficientes_modelo];
		polinomios = new double[coeficientes_modelo][numero_termos_polinomio];

		polinomios[2][0] = 0.0022995;
		polinomios[2][1] = -0.22368;
		polinomios[2][2] = 3.0077;
		polinomios[2][3] = -15.727;
		polinomios[2][4] = 38.959;
		polinomios[2][5] = -45.826;
		polinomios[2][6] = 20.606;

		polinomios[1][0] = 0.082976;
		polinomios[1][1] = 4.0984;
		polinomios[1][2] = -57.474;
		polinomios[1][3] = 291.9;
		polinomios[1][4] = -702.65;
		polinomios[1][5] = 806.14;
		polinomios[1][6] = -354.51;

		polinomios[0][0] = 4.6781;
		polinomios[0][1] = 48.648;
		polinomios[0][2] = -1407.5;
		polinomios[0][3] = 8673.4;
		polinomios[0][4] = -22654;
		polinomios[0][5] = 27074;
		polinomios[0][6] = -12207;

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

		polinomio[2] = polinomio[2] / 10;

		for (int c = 0; c < coeficientes_modelo; c++) {
			coef = coef + polinomio[c] * Math.pow(getInput1(), c);
		}

		// fixa��o de valor.
		setOutput(getPressure_kPa()
				- (coef * getR_kPa_L_mol_K() * getTemperature_k() / (1000 * getVolum_L() * getMolar_mass_g_mol())));

		if (getInput2() >= 0.67 || getInput1() == 0) {
			setOutput(getPressure_kPa());
			return;
		}

	}

}
