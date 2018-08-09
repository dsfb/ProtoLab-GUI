package com.google.sites.danieltcc1.model;

/**
 * Classe que define o segundo modelo, fenomenológico, feito com polinômios do
 * primeiro grau. Esta classe recebe como entrada dois números reais, que são a
 * frequência de rotação do motor universal (0-280Hz) e o fator de abertura do
 * módulo "válvula borboleta" (0-1) e fornece na saída o fluxo da massa do ar
 * admitido (kg/h).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since versão 1.0b1
 */
public class Model2_maf extends Model {

	// declaração e instanciação de variáveis.
	private double polinomio[] = { 0.059881, 1.01, 2.3754, -14.459, 26.312,
			-21.564, 6.7468 };
	private double coef;

	/**
	 * Este método fixa a variável (do tipo double) saida, isto é, o valor real
	 * da saída deste modelo.
	 * 
	 */
	public void setOutput() {

		// declaração e instanciação de variável.
		coef = 0;

		// cálculo matemático do valor definitivo da variável.
		for (int c = 0; c < 7; c++) {
			coef = coef + polinomio[c] * Math.pow(getInput2(), c);
		}

		// fixação de valor.
		setOutput(coef * getInput1());

	}

}
