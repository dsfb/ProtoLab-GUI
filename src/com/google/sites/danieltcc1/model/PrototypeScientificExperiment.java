package com.google.sites.danieltcc1.model;

/**
 * Classe que define o experimento sobre o protótipo real. Este experimento é
 * feito com um protótipo e um ar ambiente.
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since versão 1.0b1
 */
public class PrototypeScientificExperiment {

	// declaração de objetos.
	private Prototype myPrototype;
	private Air ambientAir;

	/**
	 * Construtor desta classe.
	 * 
	 * Constrói uma instância da classe Prototipo e uma instância da classe Ar.
	 */
	public PrototypeScientificExperiment() {

		myPrototype = new Prototype();
		ambientAir = new Air();

	}

	/**
	 * Este método retorna o objeto (do tipo Prototipo) meu_prototipo.
	 * 
	 * @return o objeto (do tipo Prototipo) meu_prototipo.
	 */
	public Prototype getMyPrototype() {
		return this.myPrototype;
	}

	/**
	 * Este método retorna o objeto (do tipo Ar) ar_ambiente.
	 * 
	 * @return o objeto (do tipo Ar) ar_ambiente.
	 */
	public Air getAmbientAir() {
		return this.ambientAir;
	}

}