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
	private Air internalAir;
	private UniversalMotor universalMotor;
	private ElectronicThrottleModule electronicThrottle;
	private Model mafModel = new DummyModel();
	private Model mapModel = new DummyModel();

	/**
	 * Construtor desta classe (Prototipo). Constrói uma instância da classe Ar,
	 * uma instância da classe Motor_universal, uma instância da classe
	 * Modulo_valvula_borboleta e uma instância das classes dos modelos feitos
	 * com as RNA's.
	 */
	public Prototype() {

		// instanciação de objetos.
		internalAir = new Air();
		universalMotor = new UniversalMotor();
		electronicThrottle = new ElectronicThrottleModule();

	}

	/**
	 * Este método retorna o objeto (do tipo Ar) the_air_inside_the_prototype.
	 * 
	 * @return o objeto (do tipo Ar) the_air_inside_the_prototype.
	 */
	public Air getInternalAir() {
		return this.internalAir;
	}

	/**
	 * Este método constrói o objeto (do tipo Model) no conjunto de modelos
	 * feitos para o fluxo de massa do ar admitido.
	 * 
	 * @param i
	 *            número inteiro para especificar o modelo desejado.<br>
	 * 
	 */
	public void buildMafModel(int i) {

		// lógica de construção dos objetos relacionados aos modelos projetados
		// para o fluxo de massa
		// do ar admitido.
		if (i == 0)
			mafModel = new AnnMafModel();
		else if (i == 1)
			mafModel = new SecondMafModel();
		else if (i == 2)
			mafModel = new ThirdMafModel();
		else if (i == 3)
			mafModel = new FourthMafModel();
		else if (i == 4)
			mafModel = new FifthMafModel();
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
			mapModel = new AnnMapModel();
		else if (i == 1)
			mapModel = new SecondMapModel();
		else if (i == 2)
			mapModel = new ThirdMapModel();
		else if (i == 3)
			mapModel = new FourthMapModel();
		else if (i == 4)
			mapModel = new FifthMapModel();
	}

	/**
	 * Este método retorna o objeto (do tipo Model) no conjunto de modelos
	 * feitos para o fluxo de massa do ar admitido.
	 * 
	 * @return o objeto (do tipo Model) no conjunto de modelos feitos para o
	 *         fluxo de massa do ar admitido.
	 */
	public Model getModel_maf() {
		return mafModel;
	}

	/**
	 * Este método retorna o objeto (do tipo Model) no conjunto de modelos
	 * feitos para a pressão do ar admitido.
	 * 
	 * @return o objeto (do tipo Model) no conjunto de modelos feitos para a
	 *         pressão do ar admitido.
	 */
	public Model getModel_map() {
		return mapModel;
	}

	/**
	 * Este método retorna o objeto (do tipo Motor_universal)
	 * the_universal_motor_of_the_prototype.
	 * 
	 * @return o objeto (do tipo Motor_universal)
	 *         the_universal_motor_of_the_prototype.
	 */
	public UniversalMotor getThe_universal_motor_of_the_prototype() {
		return this.universalMotor;
	}

	/**
	 * Este método retorna o objeto (do tipo Modulo_valvula_borboleta)
	 * the_electronic_throttle_module_of_the_prototype.
	 * 
	 * @return o objeto (do tipo Modulo_valvula_borboleta)
	 *         the_electronic_throttle_module_of_the_prototype.
	 */
	public ElectronicThrottleModule getThe_electronic_throttle_module_of_the_prototype() {
		return this.electronicThrottle;
	}
	
	public void setRotationFrequency(double rotationFrequency) {
		this.universalMotor.setRotationFrequency(rotationFrequency);
	}
	
	public double getRotationFrequency() {
		return this.universalMotor.getRotationFrequency();
	}
}