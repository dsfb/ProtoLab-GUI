package com.google.sites.danieltcc1.model;

/**
 * Classe que define o experimento sobre o prot�tipo real. Este experimento �
 * feito com um prot�tipo e um ar ambiente.
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.2
 * @since vers�o 1.0b1
 */
public class A_scientific_experiment_with_the_prototype {

	// declara��o de objetos.
	private Prototype my_prototype;
	private Air ambient_air;

	/**
	 * Construtor desta classe.
	 * 
	 * Constr�i uma inst�ncia da classe Prototipo e uma inst�ncia da classe Ar.
	 */
	public A_scientific_experiment_with_the_prototype() {

		my_prototype = new Prototype();
		ambient_air = new Air();

	}

	/**
	 * Este m�todo retorna o objeto (do tipo Prototipo) meu_prototipo.
	 * 
	 * @return o objeto (do tipo Prototipo) meu_prototipo.
	 */
	public Prototype getMy_prototype() {
		return this.my_prototype;
	}

	/**
	 * Este m�todo retorna o objeto (do tipo Ar) ar_ambiente.
	 * 
	 * @return o objeto (do tipo Ar) ar_ambiente.
	 */
	public Air getAmbient_air() {
		return this.ambient_air;
	}

}