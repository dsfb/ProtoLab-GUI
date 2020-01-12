package com.google.sites.danieltcc1.model;

/**
 * Classe que define o experimento sobre o prototipo real. Este experimento eh
 * feito com um prototipo ao ar livre (ambiente!).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since versao 1.0b1
 */
public class ScientificExperiment {

	// declaracao de objetos.
	private Prototype prototype;
	private Air air;

	/**
	 * Construtor desta classe.
	 * 
	 * Constroi uma instancia da classe Prototipo e uma instancia da classe Ar.
	 */
	public ScientificExperiment() {

		prototype = new Prototype();
		air = new Air();

	}

	/**
	 * Este metodo retorna o objeto do tipo Prototipo.
	 * 
	 * @return o objeto do tipo Prototipo.
	 */
	public Prototype getMyPrototype() {
		return this.prototype;
	}

	/**
	 * Este metodo retorna o objeto do tipo Ar.
	 * 
	 * @return o objeto do tipo Ar.
	 */
	public Air getAir() {
		return this.air;
	}
	
	public void setRotationFrequency(double rotationFrequency) {
		this.prototype.setRotationFrequency(rotationFrequency);
	}
	
	public double getRotationFrequency() {
		return this.prototype.getRotationFrequency();
	}
}