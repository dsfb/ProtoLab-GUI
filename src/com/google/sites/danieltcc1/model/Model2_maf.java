package com.google.sites.danieltcc1.model;

/**
 * Classe que define o segundo modelo, fenomenol�gico, feito com polin�mios do
 * primeiro grau. Esta classe recebe como entrada dois n�meros reais, que s�o a
 * frequ�ncia de rota��o do motor universal (0-280Hz) e o fator de abertura do
 * m�dulo "v�lvula borboleta" (0-1) e fornece na sa�da o fluxo da massa do ar
 * admitido (kg/h).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since vers�o 1.0b1
 */
public class Model2_maf extends Model {

	// declara��o e instancia��o de vari�veis.
	private double polinomio[] = { 0.059881, 1.01, 2.3754, -14.459, 26.312,
			-21.564, 6.7468 };
	private double coef;

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) saida, isto �, o valor real
	 * da sa�da deste modelo.
	 * 
	 */
	public void setOutput() {

		// declara��o e instancia��o de vari�vel.
		coef = 0;

		// c�lculo matem�tico do valor definitivo da vari�vel.
		for (int c = 0; c < 7; c++) {
			coef = coef + polinomio[c] * Math.pow(getInput2(), c);
		}

		// fixa��o de valor.
		setOutput(coef * getInput1());

	}

}
