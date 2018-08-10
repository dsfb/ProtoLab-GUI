package com.google.sites.danieltcc1.model;

/**
 * Classe que define o prot�tipo f�sico. Assim, tamb�m define o ar dentro do
 * prot�tipo, o motor universal, o m�dulo "v�lvula borboleta" e os modelos
 * feitos com as RNA's do prot�tipo.
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.1
 * @since vers�o 1.0b1
 */
public class Prototype {

	// declara��o de objetos.
	private Air the_air_inside_the_prototype;
	private UniversalMotor the_universal_motor_of_the_prototype;
	private ElectronicThrottleModule the_electronic_throttle_module_of_the_prototype;
	private Model model_maf;
	private Model model_map;

	/**
	 * Construtor desta classe (Prototipo). Constr�i uma inst�ncia da classe Ar,
	 * uma inst�ncia da classe Motor_universal, uma inst�ncia da classe
	 * Modulo_valvula_borboleta e uma inst�ncia das classes dos modelos feitos
	 * com as RNA's.
	 */
	public Prototype() {

		// instancia��o de objetos.
		the_air_inside_the_prototype = new Air();
		the_universal_motor_of_the_prototype = new UniversalMotor();
		the_electronic_throttle_module_of_the_prototype = new ElectronicThrottleModule();

	}

	/**
	 * Este m�todo retorna o objeto (do tipo Ar) the_air_inside_the_prototype.
	 * 
	 * @return o objeto (do tipo Ar) the_air_inside_the_prototype.
	 */
	public Air getThe_air_inside_the_prototype() {
		return this.the_air_inside_the_prototype;
	}

	/**
	 * Este m�todo constr�i o objeto (do tipo Model) no conjunto de modelos
	 * feitos para o fluxo de massa do ar admitido.
	 * 
	 * @param i
	 *            n�mero inteiro para especificar o modelo desejado.<br>
	 * 
	 */
	public void build_model_maf(int i) {

		// l�gica de constru��o dos objetos relacionados aos modelos projetados
		// para o fluxo de massa
		// do ar admitido.
		if (i == 0)
			model_maf = new AnnMafModel();
		else if (i == 1)
			model_maf = new SecondMafModel();
		else if (i == 2)
			model_maf = new ThirdMafModel();
		else if (i == 3)
			model_maf = new FourthMafModel();
		else if (i == 4)
			model_maf = new FifthMafModel();
	}

	/**
	 * Este m�todo constr�i o objeto (do tipo Model) no conjunto de modelos
	 * feitos para a press�o do ar admitido.
	 * 
	 * @param i
	 *            n�mero inteiro para especificar o modelo desejado.<br>
	 * 
	 */
	public void build_model_map(int i) {

		// l�gica de constru��o dos objetos relacionados aos modelos projetados
		// para a press�o do ar
		// admitido.
		if (i == 0)
			model_map = new AnnMapModel();
		else if (i == 1)
			model_map = new SecondMapModel();
		else if (i == 2)
			model_map = new ThirdMapModel();
		else if (i == 3)
			model_map = new FourthMapModel();
		else if (i == 4)
			model_map = new FifthMapModel();
	}

	/**
	 * Este m�todo retorna o objeto (do tipo Model) no conjunto de modelos
	 * feitos para o fluxo de massa do ar admitido.
	 * 
	 * @return o objeto (do tipo Model) no conjunto de modelos feitos para o
	 *         fluxo de massa do ar admitido.
	 */
	public Model getModel_maf() {
		return model_maf;
	}

	/**
	 * Este m�todo retorna o objeto (do tipo Model) no conjunto de modelos
	 * feitos para a press�o do ar admitido.
	 * 
	 * @return o objeto (do tipo Model) no conjunto de modelos feitos para a
	 *         press�o do ar admitido.
	 */
	public Model getModel_map() {
		return model_map;
	}

	/**
	 * Este m�todo retorna o objeto (do tipo Motor_universal)
	 * the_universal_motor_of_the_prototype.
	 * 
	 * @return o objeto (do tipo Motor_universal)
	 *         the_universal_motor_of_the_prototype.
	 */
	public UniversalMotor getThe_universal_motor_of_the_prototype() {
		return this.the_universal_motor_of_the_prototype;
	}

	/**
	 * Este m�todo retorna o objeto (do tipo Modulo_valvula_borboleta)
	 * the_electronic_throttle_module_of_the_prototype.
	 * 
	 * @return o objeto (do tipo Modulo_valvula_borboleta)
	 *         the_electronic_throttle_module_of_the_prototype.
	 */
	public ElectronicThrottleModule getThe_electronic_throttle_module_of_the_prototype() {
		return this.the_electronic_throttle_module_of_the_prototype;
	}

}