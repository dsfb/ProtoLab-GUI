package com.google.sites.danieltcc1.control;

import com.google.sites.danieltcc1.model.*;
import com.google.sites.danieltcc1.vision.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.math.BigDecimal;

public class Control implements ActionListener {
	private Vision vision;

	private PrototypeScientificExperiment a_scientific_experiment_with_the_prototype;

	private int choice_model;

	private int execution;

	public Control(Vision vision) {
		this.vision = vision;
		vision.configureListener(this);
		a_scientific_experiment_with_the_prototype = new PrototypeScientificExperiment();

		// fixação de valor.
		choice_model = -1;

		// chamada do método reinicia().
		restart();
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
		this.vision.setVisible(true);
	}

	public void restart() {
		String field1 = null, field2 = null, field3 = null, field4 = null, field5 = null, field6 = null, field7 = null, field8 = null, field9 = null, field10 = null;
		// lógica de inicialização
		if (choice_model == -1) {

			// ajuste dos objetos durante a inicialização.
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getThe_universal_motor_of_the_prototype()
					.setRotation_frequency_Hz(0);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getThe_electronic_throttle_module_of_the_prototype()
					.setCurrent_opening_factor(0);

			a_scientific_experiment_with_the_prototype.getAmbient_air()
					.setPressure_kPa(94.99);
			a_scientific_experiment_with_the_prototype.getAmbient_air()
					.setTemperature_kelvin(300.0);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getThe_air_inside_the_prototype()
					.setTemperature_kelvin(300);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getThe_air_inside_the_prototype().setPressure_kPa(94.99);

			a_scientific_experiment_with_the_prototype.getAmbient_air()
					.setMass_flow_kg_h(0);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getThe_air_inside_the_prototype().setMass_flow_kg_h(0);

			field1 = format(a_scientific_experiment_with_the_prototype
					.getAmbient_air().getPressure_kPa()) + "";
			field2 = format(a_scientific_experiment_with_the_prototype
					.getAmbient_air().getTemperature_kelvin()) + "";
			field3 = format(a_scientific_experiment_with_the_prototype
					.getMy_prototype().getThe_air_inside_the_prototype()
					.getPressure_kPa())
					+ "";
			field9 = format(a_scientific_experiment_with_the_prototype
					.getMy_prototype().getThe_air_inside_the_prototype()
					.getPressure_kPa())
					+ "";
			field4 = format(a_scientific_experiment_with_the_prototype
					.getMy_prototype().getThe_air_inside_the_prototype()
					.getMass_flow_kg_h())
					+ "";
			field10 = format(a_scientific_experiment_with_the_prototype
					.getMy_prototype().getThe_air_inside_the_prototype()
					.getMass_flow_kg_h())
					+ "";
			field5 = format(a_scientific_experiment_with_the_prototype
					.getMy_prototype()
					.getThe_universal_motor_of_the_prototype()
					.getRotation_frequency_Hz())
					+ "";
			field6 = format(a_scientific_experiment_with_the_prototype
					.getMy_prototype()
					.getThe_electronic_throttle_module_of_the_prototype()
					.getCurrent_opening_factor())
					+ "";

			// lógica de reinicialização para os primeiros modelos.
		} else if (choice_model == 0) {

			// ajuste dos objetos durante a reinicialização.
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getThe_universal_motor_of_the_prototype()
					.setRotation_frequency_Hz(0);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getThe_electronic_throttle_module_of_the_prototype()
					.setCurrent_opening_factor(0);

			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getModel_map().setInput1(0);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getModel_map().setInput2(0);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getModel_map().setOutput();
			a_scientific_experiment_with_the_prototype.getAmbient_air()
					.setPressure_kPa(
							a_scientific_experiment_with_the_prototype
									.getMy_prototype().getModel_map()
									.getOutput());
			a_scientific_experiment_with_the_prototype.getAmbient_air()
					.setTemperature_kelvin(300.0);
			a_scientific_experiment_with_the_prototype
					.getMy_prototype()
					.getThe_air_inside_the_prototype()
					.setTemperature_kelvin(
							a_scientific_experiment_with_the_prototype
									.getAmbient_air().getTemperature_kelvin());
			a_scientific_experiment_with_the_prototype
					.getMy_prototype()
					.getThe_air_inside_the_prototype()
					.setPressure_kPa(
							a_scientific_experiment_with_the_prototype
									.getAmbient_air().getPressure_kPa());

			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getModel_maf().setInput1(0);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getModel_maf().setInput2(0);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getModel_maf().setOutput();
			a_scientific_experiment_with_the_prototype.getAmbient_air()
					.setMass_flow_kg_h(
							a_scientific_experiment_with_the_prototype
									.getMy_prototype().getModel_maf()
									.getOutput());
			a_scientific_experiment_with_the_prototype
					.getMy_prototype()
					.getThe_air_inside_the_prototype()
					.setMass_flow_kg_h(
							a_scientific_experiment_with_the_prototype
									.getAmbient_air().getMass_flow_kg_h());

			field1 = format(a_scientific_experiment_with_the_prototype
					.getAmbient_air().getPressure_kPa()) + "";
			field2 = format(a_scientific_experiment_with_the_prototype
					.getAmbient_air().getTemperature_kelvin()) + "";
			field3 = format(a_scientific_experiment_with_the_prototype
					.getMy_prototype().getThe_air_inside_the_prototype()
					.getPressure_kPa())
					+ "";
			field4 = format(a_scientific_experiment_with_the_prototype
					.getMy_prototype().getThe_air_inside_the_prototype()
					.getMass_flow_kg_h())
					+ "";
			field5 = format(a_scientific_experiment_with_the_prototype
					.getMy_prototype()
					.getThe_universal_motor_of_the_prototype()
					.getRotation_frequency_Hz())
					+ "";
			field6 = format(a_scientific_experiment_with_the_prototype
					.getMy_prototype()
					.getThe_electronic_throttle_module_of_the_prototype()
					.getCurrent_opening_factor())
					+ "";

			field9 = field3;
			field10 = field4;

			// lógica de reinicialização para os segundos, terceiros, quartos e
			// quintos modelos.
		} else if (choice_model >= 1 && choice_model <= 4) {

			// ajuste dos objetos durante a reinicialização.
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getThe_universal_motor_of_the_prototype()
					.setRotation_frequency_Hz(0);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getThe_electronic_throttle_module_of_the_prototype()
					.setCurrent_opening_factor(0);

			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getModel_map().setInput1(0);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getModel_map().setInput2(0);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getModel_map().setPressure_kPa(94.99);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getModel_map().setVolum_L(0.53751);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getModel_map().setMolar_mass_g_mol(28.96);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getModel_map().setTemperature_k(300);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getModel_map().setOutput();

			a_scientific_experiment_with_the_prototype.getAmbient_air()
					.setPressure_kPa(
							a_scientific_experiment_with_the_prototype
									.getMy_prototype().getModel_map()
									.getPressure_kPa());
			a_scientific_experiment_with_the_prototype.getAmbient_air()
					.setTemperature_kelvin(300);
			a_scientific_experiment_with_the_prototype.getAmbient_air()
					.setVolum_liters(
							a_scientific_experiment_with_the_prototype
									.getMy_prototype().getModel_map()
									.getVolum_L());
			a_scientific_experiment_with_the_prototype.getAmbient_air()
					.setAir_molar_mass_g_mol(
							a_scientific_experiment_with_the_prototype
									.getMy_prototype().getModel_map()
									.getMolar_mass_g_mol());

			a_scientific_experiment_with_the_prototype
					.getMy_prototype()
					.getThe_air_inside_the_prototype()
					.setTemperature_kelvin(
							a_scientific_experiment_with_the_prototype
									.getAmbient_air().getTemperature_kelvin());
			a_scientific_experiment_with_the_prototype
					.getMy_prototype()
					.getThe_air_inside_the_prototype()
					.setPressure_kPa(
							a_scientific_experiment_with_the_prototype
									.getAmbient_air().getPressure_kPa());
			a_scientific_experiment_with_the_prototype
					.getMy_prototype()
					.getThe_air_inside_the_prototype()
					.setVolum_liters(
							a_scientific_experiment_with_the_prototype
									.getMy_prototype().getModel_map()
									.getVolum_L());
			a_scientific_experiment_with_the_prototype
					.getMy_prototype()
					.getThe_air_inside_the_prototype()
					.setAir_molar_mass_g_mol(
							a_scientific_experiment_with_the_prototype
									.getMy_prototype().getModel_map()
									.getMolar_mass_g_mol());

			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getModel_maf().setInput1(0);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getModel_maf().setInput2(0);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.getModel_maf().setOutput();
			a_scientific_experiment_with_the_prototype.getAmbient_air()
					.setMass_flow_kg_h(
							a_scientific_experiment_with_the_prototype
									.getMy_prototype().getModel_maf()
									.getOutput());
			a_scientific_experiment_with_the_prototype
					.getMy_prototype()
					.getThe_air_inside_the_prototype()
					.setMass_flow_kg_h(
							a_scientific_experiment_with_the_prototype
									.getAmbient_air().getMass_flow_kg_h());

			field1 = format(a_scientific_experiment_with_the_prototype
					.getAmbient_air().getPressure_kPa()) + "";
			field2 = format(a_scientific_experiment_with_the_prototype
					.getAmbient_air().getTemperature_kelvin()) + "";
			field3 = format(a_scientific_experiment_with_the_prototype
					.getMy_prototype().getThe_air_inside_the_prototype()
					.getPressure_kPa())
					+ "";
			field4 = format(a_scientific_experiment_with_the_prototype
					.getMy_prototype().getThe_air_inside_the_prototype()
					.getMass_flow_kg_h())
					+ "";
			field5 = format(a_scientific_experiment_with_the_prototype
					.getMy_prototype()
					.getThe_universal_motor_of_the_prototype()
					.getRotation_frequency_Hz())
					+ "";
			field6 = format(a_scientific_experiment_with_the_prototype
					.getMy_prototype()
					.getThe_electronic_throttle_module_of_the_prototype()
					.getCurrent_opening_factor())
					+ "";
			field7 = format(a_scientific_experiment_with_the_prototype
					.getMy_prototype().getThe_air_inside_the_prototype()
					.getVolum_liters())
					+ "";
			field8 = format(a_scientific_experiment_with_the_prototype
					.getMy_prototype().getThe_air_inside_the_prototype()
					.getAir_molar_mass_g_mol())
					+ "";

			field9 = field3;
			field10 = field4;

			// lógica de reinicialização para outras situações.
		} else {

		}

		// fixação de valores;
		execution = 0;

		vision.restart(field1, field2, field3, field4, field5, field6, field7,
				field8, field9, field10);
	}

	/**
	 * Este método change a variável referente à frequência de rotação do motor
	 * universal, na instância da classe Experimento_prototipo.
	 */
	public void change_rot_freq(double rot_freq) {

		double field3, field4;

		if (choice_model == -1)
			this.vision
					.showMessage(this.vision
							.getMessage("please_choose_a_model_before_changing_any_parameters"));

		// ajuste dos objetos para changer a frequência de rotação do motor
		// universal.
		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getThe_universal_motor_of_the_prototype()
				.setRotation_frequency_Hz(rot_freq);

		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getModel_map().setInput1(rot_freq);

		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getModel_map().setOutput();

		a_scientific_experiment_with_the_prototype
				.getMy_prototype()
				.getThe_air_inside_the_prototype()
				.setPressure_kPa(
						a_scientific_experiment_with_the_prototype
								.getMy_prototype().getModel_map().getOutput());

		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getModel_maf().setInput1(rot_freq);
		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getModel_maf().setOutput();
		a_scientific_experiment_with_the_prototype
				.getMy_prototype()
				.getThe_air_inside_the_prototype()
				.setMass_flow_kg_h(
						a_scientific_experiment_with_the_prototype
								.getMy_prototype().getModel_maf().getOutput());

		execution = execution + 1;

		field3 = format(a_scientific_experiment_with_the_prototype
				.getMy_prototype().getThe_air_inside_the_prototype()
				.getPressure_kPa());
		field4 = format(a_scientific_experiment_with_the_prototype
				.getMy_prototype().getThe_air_inside_the_prototype()
				.getMass_flow_kg_h());
		this.vision
				.change_rot_freq(format(rot_freq), field3, field4, execution);
	}

	/**
	 * Este método change a variável referente ao fator de abertura do módulo
	 * "válvula borboleta", na instância da classe Experimento_prototipo.
	 */
	public void change_open_factor(double open_factor) {

		double field3, field4;

		if (choice_model == -1)
			this.vision
					.showMessage(this.vision
							.getMessage("please_choose_a_model_before_changing_any_parameters"));

		// ajuste dos objetos para changer o fator de abertura do módulo válvula
		// borboleta.
		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getThe_electronic_throttle_module_of_the_prototype()
				.setCurrent_opening_factor(open_factor);

		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getModel_map().setInput2(open_factor);
		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getModel_map().setOutput();
		a_scientific_experiment_with_the_prototype
				.getMy_prototype()
				.getThe_air_inside_the_prototype()
				.setPressure_kPa(
						a_scientific_experiment_with_the_prototype
								.getMy_prototype().getModel_map().getOutput());

		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getModel_maf().setInput2(open_factor);
		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getModel_maf().setOutput();
		a_scientific_experiment_with_the_prototype
				.getMy_prototype()
				.getThe_air_inside_the_prototype()
				.setMass_flow_kg_h(
						a_scientific_experiment_with_the_prototype
								.getMy_prototype().getModel_maf().getOutput());

		execution = execution + 1;

		field3 = format(a_scientific_experiment_with_the_prototype
				.getMy_prototype().getThe_air_inside_the_prototype()
				.getPressure_kPa());

		field4 = format(a_scientific_experiment_with_the_prototype
				.getMy_prototype().getThe_air_inside_the_prototype()
				.getMass_flow_kg_h());

		this.vision.change_open_factor(format(open_factor), field3, field4,
				execution);

	}

	/**
	 * Este método change a variável referente à pressão do ar admitido e do ar
	 * ambiente, na instância da classe Experimento_prototipo.
	 */
	public void change_air_pressure(double air_pressure) {

		double field3;

		// ajuste dos objetos para changer a pressão do ar ambiente.
		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getModel_map().setPressure_kPa(air_pressure);
		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getModel_map().setOutput();
		a_scientific_experiment_with_the_prototype.getAmbient_air()
				.setPressure_kPa(air_pressure);

		a_scientific_experiment_with_the_prototype
				.getMy_prototype()
				.getThe_air_inside_the_prototype()
				.setPressure_kPa(
						a_scientific_experiment_with_the_prototype
								.getMy_prototype().getModel_map().getOutput());

		execution = execution + 1;

		field3 = format(a_scientific_experiment_with_the_prototype
				.getMy_prototype().getThe_air_inside_the_prototype()
				.getPressure_kPa());

		this.vision
				.change_air_pressure(format(air_pressure), field3, execution);
	}

	/**
	 * Este método change a variável referente ao volume do ar admitido, na
	 * instância da classe Experimento_prototipo.
	 */
	public void change_air_volum(double air_volum) {

		double field3;

		// ajuste dos objetos para changer o volume do ar admitido.
		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getModel_map().setVolum_L(air_volum);
		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getModel_map().setOutput();

		a_scientific_experiment_with_the_prototype
				.getMy_prototype()
				.getThe_air_inside_the_prototype()
				.setPressure_kPa(
						a_scientific_experiment_with_the_prototype
								.getMy_prototype().getModel_map().getOutput());

		field3 = format(a_scientific_experiment_with_the_prototype
				.getMy_prototype().getThe_air_inside_the_prototype()
				.getPressure_kPa());

		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getThe_air_inside_the_prototype().setVolum_liters(air_volum);

		execution = execution + 1;

		this.vision.change_air_volum(format(air_volum), field3, execution);
	}

	/**
	 * Este método change a variável referente à massa molar do ar admitido e do
	 * ar ambiente, na instância da classe Experimento_prototipo.
	 */
	public void change_air_molar_mass(double air_molar_mass) {

		double field3;

		// ajuste dos objetos para changer a massa molar do ar ambiente.
		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getModel_map().setMolar_mass_g_mol(air_molar_mass);
		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getModel_map().setOutput();
		a_scientific_experiment_with_the_prototype.getAmbient_air()
				.setAir_molar_mass_g_mol(air_molar_mass);

		a_scientific_experiment_with_the_prototype
				.getMy_prototype()
				.getThe_air_inside_the_prototype()
				.setPressure_kPa(
						a_scientific_experiment_with_the_prototype
								.getMy_prototype().getModel_map().getOutput());

		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getThe_air_inside_the_prototype()
				.setAir_molar_mass_g_mol(air_molar_mass);

		field3 = format(a_scientific_experiment_with_the_prototype
				.getMy_prototype().getThe_air_inside_the_prototype()
				.getPressure_kPa());

		execution = execution + 1;

		this.vision.change_air_molar_mass(format(air_molar_mass), field3,
				execution);
	}

	/**
	 * Este método change a variável referente à temperatura do ar ambiente e do
	 * ar admitido, na instância da classe Experimento_prototipo.
	 */
	public void change_air_temperature(double air_temperature) {

		double field3;

		// ajuste dos objetos para changer a temperatura do ar ambiente.
		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getModel_map().setTemperature_k(air_temperature);
		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getModel_map().setOutput();
		a_scientific_experiment_with_the_prototype.getAmbient_air()
				.setTemperature_kelvin(air_temperature);

		a_scientific_experiment_with_the_prototype
				.getMy_prototype()
				.getThe_air_inside_the_prototype()
				.setPressure_kPa(
						a_scientific_experiment_with_the_prototype
								.getMy_prototype().getModel_map().getOutput());

		field3 = format(a_scientific_experiment_with_the_prototype
				.getMy_prototype().getThe_air_inside_the_prototype()
				.getPressure_kPa());

		a_scientific_experiment_with_the_prototype.getMy_prototype()
				.getThe_air_inside_the_prototype()
				.setTemperature_kelvin(air_temperature);

		execution = execution + 1;

		this.vision.change_air_temperature(format(air_temperature), field3,
				execution);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("mu_freq")) {
			for (boolean continuefor = true; continuefor;) {
				try {
					for (boolean continuetry = true; continuetry;) {
						try {
							String entrada = this.vision
									.showInput(this.vision
											.getMessage("enter_the_new_rotation_frequency_of_the_universal_motor_value_hz"));
							if (Double.parseDouble(entrada) > 280
									|| Double.parseDouble(entrada) < 0)
								this.vision
										.showMessage(this.vision
												.getMessage("you_must_enter_between_0_and_280"));
							if (Double.parseDouble(entrada) <= 280
									&& Double.parseDouble(entrada) >= 0) {
								continuetry = false;
								this.change_rot_freq(Double
										.parseDouble(entrada));
							}
						} catch (NullPointerException npe) {
							continuetry = false;
						}
					}
					continuefor = false;
				} catch (NumberFormatException nfe) {
					this.vision.showMessage(this.vision
							.getMessage("you_must_enter_with_only_a_dot"));
				}
			}
		}
		// evento de changença do fator de abertura do módulo válvula borboleta.
		else if (e.getActionCommand().equals("etm_factor")) {
			for (boolean continuefor = true; continuefor;) {
				try {
					for (boolean continuetry = true; continuetry;) {
						try {
							String entrada = this.vision
									.showInput(this.vision
											.getMessage("enter_the_new_opening_factor_of_the_electronic_throttle_module_value"));
							if (Double.parseDouble(entrada) > 1
									|| Double.parseDouble(entrada) < 0)
								this.vision
										.showMessage(this.vision
												.getMessage("you_must_enter_between_0_and_1"));
							if (Double.parseDouble(entrada) <= 1
									&& Double.parseDouble(entrada) >= 0) {
								continuetry = false;
								change_open_factor(Double.parseDouble(entrada));
							}
						} catch (NullPointerException npe) {
							continuetry = false;
						}
					}
					continuefor = false;
				} catch (NumberFormatException nfe) {
					this.vision.showMessage(this.vision
							.getMessage("you_must_enter_with_only_a_dot"));
				}
			}
		} else if (e.getActionCommand().equals("air_pressure")) {
			for (boolean continuefor = true; continuefor;) {
				try {
					for (boolean continuetry = true; continuetry;) {
						try {
							String entrada = this.vision
									.showInput(this.vision
											.getMessage("enter_the_new_ambient_air_pressure_value"));
							if (Double.parseDouble(entrada) < 0)
								this.vision
										.showMessage(this.vision
												.getMessage("you_must_enter_greater_than_equal_0"));
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
					this.vision.showMessage(this.vision
							.getMessage("you_must_enter_with_only_a_dot"));
				}
			}
		}
		// evento de changença do volume total do ar admitido.
		else if (e.getActionCommand().equals("air_volum")) {
			for (boolean continuefor = true; continuefor;) {
				try {
					for (boolean continuetry = true; continuetry;) {
						try {
							String entrada = this.vision
									.showInput(this.vision
											.getMessage("enter_the_new_intake_air_full_volum_value"));
							if (Double.parseDouble(entrada) <= 0)
								this.vision
										.showMessage(this.vision
												.getMessage("you_must_enter_greater_than_equal_0"));
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
					this.vision.showMessage(this.vision
							.getMessage("you_must_enter_with_only_a_dot"));
				}
			}
		}
		// evento de changença da massa molar do ar ambiente.
		else if (e.getActionCommand().equals("air_molar_mass")) {
			for (boolean continuefor = true; continuefor;) {
				try {
					for (boolean continuetry = true; continuetry;) {
						try {
							String entrada = this.vision
									.showInput(this.vision
											.getMessage("enter_the_new_ambient_air_molar_mass_value"));
							if (Double.parseDouble(entrada) <= 0)
								this.vision
										.showMessage(this.vision
												.getMessage("you_must_enter_greater_than_equal_0"));
							if (Double.parseDouble(entrada) > 0) {
								continuetry = false;
								change_air_molar_mass(Double
										.parseDouble(entrada));
							}
						} catch (NullPointerException npe) {
							continuetry = false;
						}
					}
					continuefor = false;
				} catch (NumberFormatException nfe) {
					this.vision.showMessage(this.vision
							.getMessage("you_must_enter_with_only_a_dot"));
				}
			}
		}
		// evento de changença da temperatura do ar ambiente.
		else if (e.getActionCommand().equals("air_temperature")) {
			for (boolean continuefor = true; continuefor;) {
				try {
					for (boolean continuetry = true; continuetry;) {
						try {
							String entrada = this.vision
									.showInput(this.vision
											.getMessage("enter_the_new_ambient_air_temperature_value"));
							if (Double.parseDouble(entrada) <= 0)
								this.vision
										.showMessage(this.vision
												.getMessage("you_must_enter_greater_than_equal_0"));
							if (Double.parseDouble(entrada) > 0) {
								continuetry = false;
								change_air_temperature(Double
										.parseDouble(entrada));
							}
						} catch (NullPointerException npe) {
							continuetry = false;
						}
					}
					continuefor = false;
				} catch (NumberFormatException nfe) {
					this.vision.showMessage(this.vision
							.getMessage("you_must_enter_with_only_a_dot"));
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

			if (choice_model > 0)
				this.vision.retiracomponentes();
			choice_model = 0;

			this.vision.eventModel0();

			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.build_model_map(choice_model);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.build_model_maf(choice_model);
			restart();
		} else if (e.getActionCommand().equals("Models2")) {

			if (choice_model <= 0)
				this.vision.adicionacomponentes();
			choice_model = 1;

			this.vision.eventModel1();

			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.build_model_map(choice_model);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.build_model_maf(choice_model);
			restart();
		} else if (e.getActionCommand().equals("Models3")) {

			if (choice_model <= 0)
				this.vision.adicionacomponentes();
			choice_model = 2;

			this.vision.eventModel2();

			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.build_model_map(choice_model);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.build_model_maf(choice_model);
			restart();
		} else if (e.getActionCommand().equals("Models4")) {

			if (choice_model <= 0)
				this.vision.adicionacomponentes();
			choice_model = 3;

			this.vision.eventModel3();

			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.build_model_map(choice_model);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.build_model_maf(choice_model);
			restart();
		} else if (e.getActionCommand().equals("Models5")) {

			if (choice_model <= 0)
				this.vision.adicionacomponentes();
			choice_model = 4;

			this.vision.eventModel4();

			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.build_model_map(choice_model);
			a_scientific_experiment_with_the_prototype.getMy_prototype()
					.build_model_maf(choice_model);
			restart();
		}
		// evento sobre o comando de ajuda.
		else if (e.getActionCommand().equals("AboutCommand")) {
			this.vision.showMessage(this.vision.getMessage(/*
       */"info")
					+ ".\n"
					+ /*
    */this.vision.getMessage("author")
					+ "Daniel S. F. Bruno.\n"
					+ /*
    */this.vision.getMessage("protolab_license")
					+ "GNU LIBRARY GENERAL PUBLIC LICENSE, VERSION 2."
					+ /*
    */"\n"
					+ this.vision
							.getMessage("made_with_the_jfreechart_library")
					+ ", " + /*
    */this.vision.getMessage("version") + ": "
					+ "1.0.14" + /*
    */"\n" + this.vision.getMessage("link") + " "
					+ this.vision.getMessage("for_this_library")
					+ /*
    */"\n http://www.jfree.org/jfreechart/");
		}
		// evento de plotagem da resposta transitória da pressão do ar admitido.
		else if (e.getActionCommand().equals("dyn_press")) {
			this.vision.plotGraphIAP(execution);
		}
		// evento de plotagem da resposta transitória do fluxo de massa do ar
		// admitido.
		else if (e.getActionCommand().equals("dyn_amf")) {
			this.vision.plotGraphIAMF(execution);
		}
		// outros eventos.
		else {
		}
	}
}