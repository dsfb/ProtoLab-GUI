package com.google.sites.danieltcc1.model;

/**
 * Classe que define o terceiro modelo, fenomenológico, feito com polinômios do
 * segundo grau. Esta classe recebe como entrada dois números reais, que são a
 * frequência de rotação do motor universal (0-280Hz) e o fator de abertura do
 * módulo "válvula borboleta" (0-1) e fornece na saída o fluxo da massa do ar
 * admitido (kg/h).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since versão 1.0b1
 */
public class Model3_maf extends Model {

	// declaração e instanciação de variáveis.
	private double[] polinomio;

	private double[][] polinomios;

	private double coef;

	private final int coeficientes_modelo = 2;

	private final int numero_termos_polinomio = 7;

	/**
	 * Construtor de uma instância da classe. Aloca memória para as variáveis
	 * (do tipo double) polinomio e polinomios.
	 */
	Model3_maf() {

		// declaração e instanciação de variáveis.
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

		polinomio[1] = polinomio[1] / 10;

		for (int c = 0; c < coeficientes_modelo; c++) {
			coef = coef + polinomio[c] * Math.pow(getInput1(), c + 1);
		}

		// fixação de valor.
		setOutput(coef);

	}

}
