package com.google.sites.danieltcc1.model;

/**
 * Classe que define o quarto modelo, fenomenol�gico, feito com polin�mios do
 * terceiro grau. Esta classe recebe como entrada dois n�meros reais, que s�o a
 * frequ�ncia de rota��o do motor universal (0-280Hz) e o fator de abertura do
 * m�dulo "v�lvula borboleta" (0-1) e fornece na sa�da a press�o do ar admitido
 * (kPa).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since vers�o 1.0b1
 */
public class Model4_map extends Model {

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
	Model4_map() {

		// declara��o e instancia��o de vari�veis.
		polinomio = new double[coeficientes_modelo];
		polinomios = new double[coeficientes_modelo][numero_termos_polinomio];

		polinomios[3][0] = 0.020107;
		polinomios[3][1] = 0.77786;
		polinomios[3][2] = -15.386;
		polinomios[3][3] = 92.714;
		polinomios[3][4] = -251.26;
		polinomios[3][5] = 317.84;
		polinomios[3][6] = -152.55;

		polinomios[2][0] = -0.0061455;
		polinomios[2][1] = -0.55036;
		polinomios[2][2] = 9.4695;
		polinomios[2][3] = -54.665;
		polinomios[2][4] = 144.49;
		polinomios[2][5] = -179.32;
		polinomios[2][6] = 84.676;

		polinomios[1][0] = 0.17434;
		polinomios[1][1] = 7.6327;
		polinomios[1][2] = -127.38;
		polinomios[1][3] = 713.17;
		polinomios[1][4] = -1844.4;
		polinomios[1][5] = 2250.4;
		polinomios[1][6] = -1047.7;

		polinomios[0][0] = 2.9216;
		polinomios[0][1] = -19.303;
		polinomios[0][2] = -63.452;
		polinomios[0][3] = 574.08;
		polinomios[0][4] = -703.98;
		polinomios[0][5] = -692.95;
		polinomios[0][6] = 1119.5;

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

		polinomio[2] /= 10;
		polinomio[3] /= 10000;

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
