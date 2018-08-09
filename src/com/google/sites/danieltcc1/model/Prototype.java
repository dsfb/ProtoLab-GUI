package com.google.sites.danieltcc1.model;

/**
 * Classe que define o protótipo físico. Assim, também define o ar dentro do
 * protótipo, o motor universal, o módulo "válvula borboleta" e os modelos
 * feitos com as RNA's do protótipo.
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.1
 * @since versão 1.0b1
 */
public class Prototype {

	// declaração de objetos.
	private Air the_air_inside_the_prototype;
	private Universal_motor the_universal_motor_of_the_prototype;
	private Electronic_throttle_module the_electronic_throttle_module_of_the_prototype;
	private Model model_maf;
	private Model model_map;

	/**
	 * Construtor desta classe (Prototipo). Constrói uma instância da classe Ar,
	 * uma instância da classe Motor_universal, uma instância da classe
	 * Modulo_valvula_borboleta e uma instância das classes dos modelos feitos
	 * com as RNA's.
	 */
	public Prototype() {

		// instanciação de objetos.
		the_air_inside_the_prototype = new Air();
		the_universal_motor_of_the_prototype = new Universal_motor();
		the_electronic_throttle_module_of_the_prototype = new Electronic_throttle_module();

	}

	/**
	 * Este método retorna o objeto (do tipo Ar) the_air_inside_the_prototype.
	 * 
	 * @return o objeto (do tipo Ar) the_air_inside_the_prototype.
	 */
	public Air getThe_air_inside_the_prototype() {
		return this.the_air_inside_the_prototype;
	}

	/**
	 * Este método constrói o objeto (do tipo Model) no conjunto de modelos
	 * feitos para o fluxo de massa do ar admitido.
	 * 
	 * @param i
	 *            número inteiro para especificar o modelo desejado.<br>
	 * 
	 */
	public void build_model_maf(int i) {

		// lógica de construção dos objetos relacionados aos modelos projetados
		// para o fluxo de massa
		// do ar admitido.
		if (i == 0)
			model_maf = new Maf_ann();
		else if (i == 1)
			model_maf = new Model2_maf();
		else if (i == 2)
			model_maf = new Model3_maf();
		else if (i == 3)
			model_maf = new Model4_maf();
		else if (i == 4)
			model_maf = new Model5_maf();
	}

	/**
	 * Este método constrói o objeto (do tipo Model) no conjunto de modelos
	 * feitos para a pressão do ar admitido.
	 * 
	 * @param i
	 *            número inteiro para especificar o modelo desejado.<br>
	 * 
	 */
	public void build_model_map(int i) {

		// lógica de construção dos objetos relacionados aos modelos projetados
		// para a pressão do ar
		// admitido.
		if (i == 0)
			model_map = new Map_ann();
		else if (i == 1)
			model_map = new Model2_map();
		else if (i == 2)
			model_map = new Model3_map();
		else if (i == 3)
			model_map = new Model4_map();
		else if (i == 4)
			model_map = new Model5_map();
	}

	/**
	 * Este método retorna o objeto (do tipo Model) no conjunto de modelos
	 * feitos para o fluxo de massa do ar admitido.
	 * 
	 * @return o objeto (do tipo Model) no conjunto de modelos feitos para o
	 *         fluxo de massa do ar admitido.
	 */
	public Model getModel_maf() {
		return model_maf;
	}

	/**
	 * Este método retorna o objeto (do tipo Model) no conjunto de modelos
	 * feitos para a pressão do ar admitido.
	 * 
	 * @return o objeto (do tipo Model) no conjunto de modelos feitos para a
	 *         pressão do ar admitido.
	 */
	public Model getModel_map() {
		return model_map;
	}

	/**
	 * Este método retorna o objeto (do tipo Motor_universal)
	 * the_universal_motor_of_the_prototype.
	 * 
	 * @return o objeto (do tipo Motor_universal)
	 *         the_universal_motor_of_the_prototype.
	 */
	public Universal_motor getThe_universal_motor_of_the_prototype() {
		return this.the_universal_motor_of_the_prototype;
	}

	/**
	 * Este método retorna o objeto (do tipo Modulo_valvula_borboleta)
	 * the_electronic_throttle_module_of_the_prototype.
	 * 
	 * @return o objeto (do tipo Modulo_valvula_borboleta)
	 *         the_electronic_throttle_module_of_the_prototype.
	 */
	public Electronic_throttle_module getThe_electronic_throttle_module_of_the_prototype() {
		return this.the_electronic_throttle_module_of_the_prototype;
	}

}