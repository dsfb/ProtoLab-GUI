package com.google.sites.danieltcc1.control;

import com.google.sites.danieltcc1.model.*;
import com.google.sites.danieltcc1.view.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.math.BigDecimal;

public class Control implements ActionListener {
	private View view;

	private PrototypeScientificExperiment prototypeScientificExperiment;

	private int modelChoice;

	private int execution;

	public Control(View vision) {
		this.view = vision;
		vision.configureListener(this);
		prototypeScientificExperiment = new PrototypeScientificExperiment();

		// fixação de valor.
		modelChoice = -1;

		// chamada do método reinicia().
		restart();
	}

	public String formatAsStr(double r) {
		return Double.toString(this.format(r));
	}

	public double format(double r) {

		int decimalPlaces = 2;
		BigDecimal bd = new BigDecimal(r);

		// setScale is immutable
		bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
		r = bd.doubleValue();
		return r;
	}

	public void start() {
		this.view.setVisible(true);
	}

	public void restart() {
		String field1 = null, field2 = null, field3 = null, field4 = null, field5 = null, field6 = null, field7 = null,
				field8 = null, field9 = null, field10 = null;
		// lógica de inicialização

		// ajuste dos objetos durante a reinicialização.
		prototypeScientificExperiment.getMyPrototype().getThe_universal_motor_of_the_prototype()
				.setRotationFrequency(0);
		prototypeScientificExperiment.getMyPrototype().getThe_electronic_throttle_module_of_the_prototype()
				.setCurrent_opening_factor(0);

		prototypeScientificExperiment.getMyPrototype().getModel_map().setInput1(0);
		prototypeScientificExperiment.getMyPrototype().getModel_map().setInput2(0);
		prototypeScientificExperiment.getMyPrototype().getModel_map().setPressure_kPa(94.99);
		prototypeScientificExperiment.getMyPrototype().getModel_map().setVolum_L(0.53751);
		prototypeScientificExperiment.getMyPrototype().getModel_map().setMolar_mass_g_mol(28.96);
		prototypeScientificExperiment.getMyPrototype().getModel_map().setTemperature_k(300);
		prototypeScientificExperiment.getMyPrototype().getModel_map().setOutput();

		prototypeScientificExperiment.getAmbientAir()
				.setPressure_kPa(prototypeScientificExperiment.getMyPrototype().getModel_map().getPressure_kPa());
		prototypeScientificExperiment.getAmbientAir().setTemperature_kelvin(300);
		prototypeScientificExperiment.getAmbientAir()
				.setVolum_liters(prototypeScientificExperiment.getMyPrototype().getModel_map().getVolum_L());
		prototypeScientificExperiment.getAmbientAir().setAir_molar_mass_g_mol(
				prototypeScientificExperiment.getMyPrototype().getModel_map().getMolar_mass_g_mol());

		prototypeScientificExperiment.getMyPrototype().getInternalAir()
				.setTemperature_kelvin(prototypeScientificExperiment.getAmbientAir().getTemperature_kelvin());
		prototypeScientificExperiment.getMyPrototype().getInternalAir()
				.setPressure_kPa(prototypeScientificExperiment.getAmbientAir().getPressure_kPa());
		prototypeScientificExperiment.getMyPrototype().getInternalAir()
				.setVolum_liters(prototypeScientificExperiment.getMyPrototype().getModel_map().getVolum_L());
		prototypeScientificExperiment.getMyPrototype().getInternalAir().setAir_molar_mass_g_mol(
				prototypeScientificExperiment.getMyPrototype().getModel_map().getMolar_mass_g_mol());

		prototypeScientificExperiment.getMyPrototype().getModel_maf().setInput1(0);
		prototypeScientificExperiment.getMyPrototype().getModel_maf().setInput2(0);
		prototypeScientificExperiment.getMyPrototype().getModel_maf().setOutput();
		prototypeScientificExperiment.getAmbientAir()
				.setMass_flow_kg_h(prototypeScientificExperiment.getMyPrototype().getModel_maf().getOutput());
		prototypeScientificExperiment.getMyPrototype().getInternalAir()
				.setMass_flow_kg_h(prototypeScientificExperiment.getAmbientAir().getMass_flow_kg_h());

		field1 = formatAsStr(prototypeScientificExperiment.getAmbientAir().getPressure_kPa());
		field2 = formatAsStr(prototypeScientificExperiment.getAmbientAir().getTemperature_kelvin());
		field3 = formatAsStr(
				prototypeScientificExperiment.getMyPrototype().getInternalAir().getPressure_kPa());
		field4 = formatAsStr(
				prototypeScientificExperiment.getMyPrototype().getInternalAir().getMass_flow_kg_h());
		field5 = formatAsStr(prototypeScientificExperiment.getMyPrototype().getThe_universal_motor_of_the_prototype()
				.getRotationFrequency());
		field6 = formatAsStr(prototypeScientificExperiment.getMyPrototype()
				.getThe_electronic_throttle_module_of_the_prototype().getCurrent_opening_factor());
		field7 = formatAsStr(
				prototypeScientificExperiment.getMyPrototype().getInternalAir().getVolum_liters());
		field8 = formatAsStr(prototypeScientificExperiment.getMyPrototype().getInternalAir()
				.getAir_molar_mass_g_mol());

		field9 = field3;
		field10 = field4;
		
		// fixação de valores;
		execution = 0;

		view.restart(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10);
	}

	/**
	 * Este método change a variável referente à frequência de rotação do motor
	 * universal, na instância da classe Experimento_prototipo.
	 */
	public void change_rot_freq(double rot_freq) {

		double field3, field4;

		if (modelChoice == -1)
			this.view.showMessage(this.view.getMessage("please_choose_a_model_before_changing_any_parameters"));

		// ajuste dos objetos para changer a frequência de rotação do motor
		// universal.
		prototypeScientificExperiment.getMyPrototype().getThe_universal_motor_of_the_prototype()
				.setRotationFrequency(rot_freq);

		prototypeScientificExperiment.getMyPrototype().getModel_map().setInput1(rot_freq);

		prototypeScientificExperiment.getMyPrototype().getModel_map().setOutput();

		prototypeScientificExperiment.getMyPrototype().getInternalAir()
				.setPressure_kPa(prototypeScientificExperiment.getMyPrototype().getModel_map().getOutput());

		prototypeScientificExperiment.getMyPrototype().getModel_maf().setInput1(rot_freq);
		prototypeScientificExperiment.getMyPrototype().getModel_maf().setOutput();
		prototypeScientificExperiment.getMyPrototype().getInternalAir()
				.setMass_flow_kg_h(prototypeScientificExperiment.getMyPrototype().getModel_maf().getOutput());

		execution = execution + 1;

		field3 = format(
				prototypeScientificExperiment.getMyPrototype().getInternalAir().getPressure_kPa());
		field4 = format(
				prototypeScientificExperiment.getMyPrototype().getInternalAir().getMass_flow_kg_h());
		this.view.change_rot_freq(format(rot_freq), field3, field4, execution);
	}

	/**
	 * Este método change a variável referente ao fator de abertura do módulo
	 * "válvula borboleta", na instância da classe Experimento_prototipo.
	 */
	public void change_open_factor(double open_factor) {

		double field3, field4;

		if (modelChoice == -1)
			this.view.showMessage(this.view.getMessage("please_choose_a_model_before_changing_any_parameters"));

		// ajuste dos objetos para changer o fator de abertura do módulo válvula
		// borboleta.
		prototypeScientificExperiment.getMyPrototype().getThe_electronic_throttle_module_of_the_prototype()
				.setCurrent_opening_factor(open_factor);

		prototypeScientificExperiment.getMyPrototype().getModel_map().setInput2(open_factor);
		prototypeScientificExperiment.getMyPrototype().getModel_map().setOutput();
		prototypeScientificExperiment.getMyPrototype().getInternalAir()
				.setPressure_kPa(prototypeScientificExperiment.getMyPrototype().getModel_map().getOutput());

		prototypeScientificExperiment.getMyPrototype().getModel_maf().setInput2(open_factor);
		prototypeScientificExperiment.getMyPrototype().getModel_maf().setOutput();
		prototypeScientificExperiment.getMyPrototype().getInternalAir()
				.setMass_flow_kg_h(prototypeScientificExperiment.getMyPrototype().getModel_maf().getOutput());

		execution = execution + 1;

		field3 = format(
				prototypeScientificExperiment.getMyPrototype().getInternalAir().getPressure_kPa());

		field4 = format(
				prototypeScientificExperiment.getMyPrototype().getInternalAir().getMass_flow_kg_h());

		this.view.change_open_factor(format(open_factor), field3, field4, execution);

	}

	/**
	 * Este método change a variável referente à pressão do ar admitido e do ar
	 * ambiente, na instância da classe Experimento_prototipo.
	 */
	public void change_air_pressure(double air_pressure) {

		double field3;

		// ajuste dos objetos para changer a pressão do ar ambiente.
		prototypeScientificExperiment.getMyPrototype().getModel_map().setPressure_kPa(air_pressure);
		prototypeScientificExperiment.getMyPrototype().getModel_map().setOutput();
		prototypeScientificExperiment.getAmbientAir().setPressure_kPa(air_pressure);

		prototypeScientificExperiment.getMyPrototype().getInternalAir()
				.setPressure_kPa(prototypeScientificExperiment.getMyPrototype().getModel_map().getOutput());

		execution = execution + 1;

		field3 = format(
				prototypeScientificExperiment.getMyPrototype().getInternalAir().getPressure_kPa());

		this.view.change_air_pressure(format(air_pressure), field3, execution);
	}

	/**
	 * Este método change a variável referente ao volume do ar admitido, na
	 * instância da classe Experimento_prototipo.
	 */
	public void change_air_volum(double air_volum) {

		double field3;

		// ajuste dos objetos para changer o volume do ar admitido.
		prototypeScientificExperiment.getMyPrototype().getModel_map().setVolum_L(air_volum);
		prototypeScientificExperiment.getMyPrototype().getModel_map().setOutput();

		prototypeScientificExperiment.getMyPrototype().getInternalAir()
				.setPressure_kPa(prototypeScientificExperiment.getMyPrototype().getModel_map().getOutput());

		field3 = format(
				prototypeScientificExperiment.getMyPrototype().getInternalAir().getPressure_kPa());

		prototypeScientificExperiment.getMyPrototype().getInternalAir().setVolum_liters(air_volum);

		execution = execution + 1;

		this.view.change_air_volum(format(air_volum), field3, execution);
	}

	/**
	 * Este método change a variável referente à massa molar do ar admitido e do ar
	 * ambiente, na instância da classe Experimento_prototipo.
	 */
	public void change_air_molar_mass(double air_molar_mass) {

		double field3;

		// ajuste dos objetos para changer a massa molar do ar ambiente.
		prototypeScientificExperiment.getMyPrototype().getModel_map().setMolar_mass_g_mol(air_molar_mass);
		prototypeScientificExperiment.getMyPrototype().getModel_map().setOutput();
		prototypeScientificExperiment.getAmbientAir().setAir_molar_mass_g_mol(air_molar_mass);

		prototypeScientificExperiment.getMyPrototype().getInternalAir()
				.setPressure_kPa(prototypeScientificExperiment.getMyPrototype().getModel_map().getOutput());

		prototypeScientificExperiment.getMyPrototype().getInternalAir()
				.setAir_molar_mass_g_mol(air_molar_mass);

		field3 = format(
				prototypeScientificExperiment.getMyPrototype().getInternalAir().getPressure_kPa());

		execution = execution + 1;

		this.view.change_air_molar_mass(format(air_molar_mass), field3, execution);
	}

	/**
	 * Este método change a variável referente à temperatura do ar ambiente e do ar
	 * admitido, na instância da classe Experimento_prototipo.
	 */
	public void change_air_temperature(double air_temperature) {

		double field3;

		// ajuste dos objetos para changer a temperatura do ar ambiente.
		prototypeScientificExperiment.getMyPrototype().getModel_map().setTemperature_k(air_temperature);
		prototypeScientificExperiment.getMyPrototype().getModel_map().setOutput();
		prototypeScientificExperiment.getAmbientAir().setTemperature_kelvin(air_temperature);

		prototypeScientificExperiment.getMyPrototype().getInternalAir()
				.setPressure_kPa(prototypeScientificExperiment.getMyPrototype().getModel_map().getOutput());

		field3 = format(
				prototypeScientificExperiment.getMyPrototype().getInternalAir().getPressure_kPa());

		prototypeScientificExperiment.getMyPrototype().getInternalAir()
				.setTemperature_kelvin(air_temperature);

		execution = execution + 1;

		this.view.change_air_temperature(format(air_temperature), field3, execution);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("mu_freq")) {
			for (boolean continuefor = true; continuefor;) {
				try {
					for (boolean continuetry = true; continuetry;) {
						try {
							String entrada = this.view.showInput(this.view
									.getMessage("enter_the_new_rotation_frequency_of_the_universal_motor_value_hz"));
							if (Double.parseDouble(entrada) > 280 || Double.parseDouble(entrada) < 0)
								this.view.showMessage(this.view.getMessage("you_must_enter_between_0_and_280"));
							if (Double.parseDouble(entrada) <= 280 && Double.parseDouble(entrada) >= 0) {
								continuetry = false;
								this.change_rot_freq(Double.parseDouble(entrada));
							}
						} catch (NullPointerException npe) {
							continuetry = false;
						}
					}
					continuefor = false;
				} catch (NumberFormatException nfe) {
					this.view.showMessage(this.view.getMessage("you_must_enter_with_only_a_dot"));
				}
			}
		}
		// evento de changença do fator de abertura do módulo válvula borboleta.
		else if (e.getActionCommand().equals("etm_factor")) {
			for (boolean continuefor = true; continuefor;) {
				try {
					for (boolean continuetry = true; continuetry;) {
						try {
							String entrada = this.view.showInput(this.view.getMessage(
									"enter_the_new_opening_factor_of_the_electronic_throttle_module_value"));
							if (Double.parseDouble(entrada) > 1 || Double.parseDouble(entrada) < 0)
								this.view.showMessage(this.view.getMessage("you_must_enter_between_0_and_1"));
							if (Double.parseDouble(entrada) <= 1 && Double.parseDouble(entrada) >= 0) {
								continuetry = false;
								change_open_factor(Double.parseDouble(entrada));
							}
						} catch (NullPointerException npe) {
							continuetry = false;
						}
					}
					continuefor = false;
				} catch (NumberFormatException nfe) {
					this.view.showMessage(this.view.getMessage("you_must_enter_with_only_a_dot"));
				}
			}
		} else if (e.getActionCommand().equals("air_pressure")) {
			for (boolean continuefor = true; continuefor;) {
				try {
					for (boolean continuetry = true; continuetry;) {
						try {
							String entrada = this.view
									.showInput(this.view.getMessage("enter_the_new_ambient_air_pressure_value"));
							if (Double.parseDouble(entrada) < 0)
								this.view.showMessage(this.view.getMessage("you_must_enter_greater_than_equal_0"));
							if (Double.parseDouble(entrada) >= 0) {
								continuetry = false;
								change_air_pressure(Double.parseDouble(entrada));
							}
						} catch (NullPointerException npe) {
							continuetry = false;
						}
					}
					continuefor = false;
				} catch (NumberFormatException nfe) {
					this.view.showMessage(this.view.getMessage("you_must_enter_with_only_a_dot"));
				}
			}
		}
		// evento de changença do volume total do ar admitido.
		else if (e.getActionCommand().equals("air_volum")) {
			for (boolean continuefor = true; continuefor;) {
				try {
					for (boolean continuetry = true; continuetry;) {
						try {
							String entrada = this.view
									.showInput(this.view.getMessage("enter_the_new_intake_air_full_volum_value"));
							if (Double.parseDouble(entrada) <= 0)
								this.view.showMessage(this.view.getMessage("you_must_enter_greater_than_equal_0"));
							if (Double.parseDouble(entrada) > 0) {
								continuetry = false;
								change_air_volum(Double.parseDouble(entrada));
							}
						} catch (NullPointerException npe) {
							continuetry = false;
						}
					}
					continuefor = false;
				} catch (NumberFormatException nfe) {
					this.view.showMessage(this.view.getMessage("you_must_enter_with_only_a_dot"));
				}
			}
		}
		// evento de changença da massa molar do ar ambiente.
		else if (e.getActionCommand().equals("air_molar_mass")) {
			for (boolean continuefor = true; continuefor;) {
				try {
					for (boolean continuetry = true; continuetry;) {
						try {
							String entrada = this.view
									.showInput(this.view.getMessage("enter_the_new_ambient_air_molar_mass_value"));
							if (Double.parseDouble(entrada) <= 0)
								this.view.showMessage(this.view.getMessage("you_must_enter_greater_than_equal_0"));
							if (Double.parseDouble(entrada) > 0) {
								continuetry = false;
								change_air_molar_mass(Double.parseDouble(entrada));
							}
						} catch (NullPointerException npe) {
							continuetry = false;
						}
					}
					continuefor = false;
				} catch (NumberFormatException nfe) {
					this.view.showMessage(this.view.getMessage("you_must_enter_with_only_a_dot"));
				}
			}
		}
		// evento de changença da temperatura do ar ambiente.
		else if (e.getActionCommand().equals("air_temperature")) {
			for (boolean continuefor = true; continuefor;) {
				try {
					for (boolean continuetry = true; continuetry;) {
						try {
							String entrada = this.view
									.showInput(this.view.getMessage("enter_the_new_ambient_air_temperature_value"));
							if (Double.parseDouble(entrada) <= 0)
								this.view.showMessage(this.view.getMessage("you_must_enter_greater_than_equal_0"));
							if (Double.parseDouble(entrada) > 0) {
								continuetry = false;
								change_air_temperature(Double.parseDouble(entrada));
							}
						} catch (NullPointerException npe) {
							continuetry = false;
						}
					}
					continuefor = false;
				} catch (NumberFormatException nfe) {
					this.view.showMessage(this.view.getMessage("you_must_enter_with_only_a_dot"));
				}
			}
		}
		// evento de interrupção e término da simulação atual.
		else if (e.getActionCommand().equals("stop_sim")) {
			System.exit(0);
		}
		// evento de reinício da simulação atual.
		else if (e.getActionCommand().equals("restart_sim")) {
			restart();
		}
		// evento de término da execução atual deste software.
		else if (e.getActionCommand().equals("ExitCommand")) {
			System.exit(0);
		}
		// eventos de escolha de modelos.
		else if (e.getActionCommand().equals("Models1")) {

			if (modelChoice > 0)
				this.view.retiracomponentes();
			modelChoice = 0;

			this.view.eventModel0();

			prototypeScientificExperiment.getMyPrototype().build_model_map(modelChoice);
			prototypeScientificExperiment.getMyPrototype().buildMafModel(modelChoice);
			restart();
		} else if (e.getActionCommand().equals("Models2")) {

			if (modelChoice <= 0)
				this.view.adicionacomponentes();
			modelChoice = 1;

			this.view.eventModel1();

			prototypeScientificExperiment.getMyPrototype().build_model_map(modelChoice);
			prototypeScientificExperiment.getMyPrototype().buildMafModel(modelChoice);
			restart();
		} else if (e.getActionCommand().equals("Models3")) {

			if (modelChoice <= 0)
				this.view.adicionacomponentes();
			modelChoice = 2;

			this.view.eventModel2();

			prototypeScientificExperiment.getMyPrototype().build_model_map(modelChoice);
			prototypeScientificExperiment.getMyPrototype().buildMafModel(modelChoice);
			restart();
		} else if (e.getActionCommand().equals("Models4")) {

			if (modelChoice <= 0)
				this.view.adicionacomponentes();
			modelChoice = 3;

			this.view.eventModel3();

			prototypeScientificExperiment.getMyPrototype().build_model_map(modelChoice);
			prototypeScientificExperiment.getMyPrototype().buildMafModel(modelChoice);
			restart();
		} else if (e.getActionCommand().equals("Models5")) {

			if (modelChoice <= 0)
				this.view.adicionacomponentes();
			modelChoice = 4;

			this.view.eventModel4();

			prototypeScientificExperiment.getMyPrototype().build_model_map(modelChoice);
			prototypeScientificExperiment.getMyPrototype().buildMafModel(modelChoice);
			restart();
		}
		// evento sobre o comando de ajuda.
		else if (e.getActionCommand().equals("AboutCommand")) {
			this.view.showMessage(this.view.getMessage(/*
														*/"info") + ".\n" + /*
																				*/this.view.getMessage("author")
					+ "Daniel S. F. Bruno.\n" + /*
												*/this.view.getMessage("protolab_license")
					+ "GNU LIBRARY GENERAL PUBLIC LICENSE, VERSION 2." + /*
																			*/"\n"
					+ this.view.getMessage("made_with_the_jfreechart_library") + ", "
					+ /*
						*/this.view.getMessage("version") + ": " + "1.0.14" + /*
																				*/"\n" + this.view.getMessage("link")
					+ " " + this.view.getMessage("for_this_library") + /*
																		*/"\n http://www.jfree.org/jfreechart/");
		}
		// evento de plotagem da resposta transitória da pressão do ar admitido.
		else if (e.getActionCommand().equals("dyn_press")) {
			this.view.plotGraphIAP(execution);
		}
		// evento de plotagem da resposta transitória do fluxo de massa do ar
		// admitido.
		else if (e.getActionCommand().equals("dyn_amf")) {
			this.view.plotGraphIAMF(execution);
		}
		// outros eventos.
		else {
		}
	}
}