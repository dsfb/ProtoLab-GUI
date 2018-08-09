package com.google.sites.danieltcc1.model;

/**
 * Classe que define o segundo modelo, fenomenol�gico, feito com polin�mios do
 * primeiro grau. Esta classe recebe como entrada dois n�meros reais, que s�o a
 * frequ�ncia de rota��o do motor universal (0-280Hz) e o fator de abertura do
 * m�dulo "v�lvula borboleta" (0-1) e fornece na sa�da a press�o do ar admitido
 * (kPa).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since vers�o 1.0b1
 */
public class Model2_map extends Model {

	private double polinomio_x[] = { 0.14736, -2.1649, 26.744, -148.47, 388.24,
			-477.03, 222.47 };
	private double polinomio_constante[] = { 1.888, 320.06, -5057, 27756,
			-69926, 82679, -37210 };
	private double coef_constante, coef_x;

	/**
	 * Este m�todo fixa a vari�vel (do tipo double) saida, isto �, o valor real
	 * da sa�da deste modelo.
	 * 
	 */
	public void setOutput() {

		// declara��o e instancia��o de vari�veis.
		coef_constante = 0;
		coef_x = 0;

		// c�lculo matem�tico do valor definitivo da vari�vel.
		for (int c = 0; c < 7; c++) {
			coef_constante = coef_constante + polinomio_constante[c]
					* Math.pow(getInput2(), c);
			coef_x = coef_x + polinomio_x[c] * Math.pow(getInput2(), c);
		}

		// fixa��o de valor.
		setOutput(getPressure_kPa()
				- ((coef_x * getInput1() + coef_constante) * getR_kPa_L_mol_K()
						* getTemperature_k() / (1000 * getVolum_L() * getMolar_mass_g_mol())));

		if (getInput2() >= 0.67 || getInput1() == 0) {
			setOutput(getPressure_kPa());
			return;
		}

	}

}
