package com.google.sites.danieltcc1.model;

/**
 * Classe que define o quinto modelo, fenomenológico, feito com polinômios do
 * quarto grau. Esta classe recebe como entrada dois números reais, que são a
 * frequência de rotação do motor universal (0-280Hz) e o fator de abertura do
 * módulo "válvula borboleta" (0-1) e fornece na saída a pressão do ar admitido
 * (kPa).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since versão 1.0b1
 */
public class Model5_map extends Model {

	// declaração e instanciação de variáveis.
	private double[] polinomio;

	private double[][] polinomios;

	private double coef;

	private final int coeficientes_modelo = 5;

	private final int numero_termos_polinomio = 7;

	/**
	 * Construtor de uma instância da classe. Aloca memória para as variáveis
	 * (do tipo double) polinomio e polinomios.
	 */
	Model5_map() {

		// declaração e instanciação de variáveis.
		polinomio = new double[coeficientes_modelo];
		polinomios = new double[coeficientes_modelo][numero_termos_polinomio];

		polinomios[4][0] = -0.034758;
		polinomios[4][1] = 1.7105;
		polinomios[4][2] = -23.586;
		polinomios[4][3] = 132.69;
		polinomios[4][4] = -357.68;
		polinomios[4][5] = 457.91;
		polinomios[4][6] = -223.08;

		polinomios[3][0] = 0.021475;
		polinomios[3][1] = -0.88013;
		polinomios[3][2] = 11.67;
		polinomios[3][3] = -65.037;
		polinomios[3][4] = 175.18;
		polinomios[3][5] = -224.65;
		polinomios[3][6] = 109.67;

		polinomios[2][0] = -0.040447;
		polinomios[2][1] = 1.1377;
		polinomios[2][2] = -13.806;
		polinomios[2][3] = 76.282;
		polinomios[2][4] = -208.49;
		polinomios[2][5] = 272.57;
		polinomios[2][6] = -135.48;

		polinomios[1][0] = 0.37177;
		polinomios[1][1] = -2.0833;
		polinomios[1][2] = 6.5855;
		polinomios[1][3] = -40.529;
		polinomios[1][4] = 187.29;
		polinomios[1][5] = -350.57;
		polinomios[1][6] = 219.45;

		polinomios[0][0] = 1.0129;
		polinomios[0][1] = 74.625;
		polinomios[0][2] = -1358.6;
		polinomios[0][3] = 7860.4;
		polinomios[0][4] = -20345;
		polinomios[0][5] = 24452;
		polinomios[0][6] = -11131;

	}

	/**
	 * Este método fixa a variável (do tipo double) saida, isto é, o valor real
	 * da saída deste modelo.
	 * 
	 */
	public void setOutput() {

		// declaração e instanciação de variável.
		coef = 0;

		// cálculo matemático do valor definitivo de variáveis.
		for (int i = 0; i < coeficientes_modelo; i++)
			polinomio[i] = 0;

		for (int i = 0; i < coeficientes_modelo; i++)
			for (int c = 0; c < numero_termos_polinomio; c++)
				polinomio[i] = polinomio[i] + polinomios[i][c]
						* Math.pow(getInput2(), c);

		polinomio[2] /= 10;
		polinomio[3] /= 1000;
		polinomio[4] /= 1000000;

		for (int c = 0; c < coeficientes_modelo; c++) {
			coef = coef + polinomio[c] * Math.pow(getInput1(), c);
		}

		// fixação de valor.
		setOutput(getPressure_kPa()
				- (coef * getR_kPa_L_mol_K() * getTemperature_k() / (1000 * getVolum_L() * getMolar_mass_g_mol())));

		if (getInput2() >= 0.67 || getInput1() == 0) {
			setOutput(getPressure_kPa());
			return;
		}

	}

}
