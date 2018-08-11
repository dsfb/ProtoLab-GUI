package com.google.sites.danieltcc1.model;

/**
 * Classe que define o experimento sobre o prot�tipo real. Este experimento �
 * feito com um prot�tipo e um ar ambiente.
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since vers�o 1.0b1
 */
public class PrototypeScientificExperiment {

	// declara��o de objetos.
	private Prototype myPrototype;
	private Air ambientAir;

	/**
	 * Construtor desta classe.
	 * 
	 * Constr�i uma inst�ncia da classe Prototipo e uma inst�ncia da classe Ar.
	 */
	public PrototypeScientificExperiment() {

		myPrototype = new Prototype();
		ambientAir = new Air();

	}

	/**
	 * Este m�todo retorna o objeto (do tipo Prototipo) meu_prototipo.
	 * 
	 * @return o objeto (do tipo Prototipo) meu_prototipo.
	 */
	public Prototype getMyPrototype() {
		return this.myPrototype;
	}

	/**
	 * Este m�todo retorna o objeto (do tipo Ar) ar_ambiente.
	 * 
	 * @return o objeto (do tipo Ar) ar_ambiente.
	 */
	public Air getAmbientAir() {
		return this.ambientAir;
	}

}