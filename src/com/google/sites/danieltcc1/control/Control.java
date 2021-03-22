package com.google.sites.danieltcc1.control;

import com.google.sites.danieltcc1.model.*;
import com.google.sites.danieltcc1.view.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Control implements ActionListener {
	private View view;
    private ModelManager modelManager;
    private Air air; // environmental air
    private Air internalAir;

	private int execution;
	
	private double openingFactorElectronicThrottle;
	private static final double MAXOPENINGFACTOR = 1.0;
	private static final double MINOPENINGFACTOR = 0.0;

	private double universalMotorRotationFrequencyHz;
	private static final double MAXROTATIONHZ = 585.0;
	private static final double MINROTATIONHZ = 0.0;

	public Control(View view) {
		this.view = view;
		view.configureListener(this);
		air = new Air();
		internalAir = new Air();

		this.setOpeningFactor(MINOPENINGFACTOR);
		this.setRotationFrequency(MINROTATIONHZ);

		modelManager = new ModelManager();

		// chamada do metodo reinicia().
		restart();
	}

	public String formatAsStr(double r) {
		return Double.toString(this.format(r));
	}

	public double format(double r) {

		int decimalPlaces = 2;
		BigDecimal bd = new BigDecimal(r);

		// setScale is immutable
		bd = bd.setScale(decimalPlaces, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public void start() {
		this.view.setVisible(true);
	}

	public void restart() {
		String field1 = null, field2 = null, field3 = null, field4 = null, field5 = null, field6 = null, field7 = null,
				field8 = null, field9 = null, field10 = null;
		// logica de inicializacao

		// ajuste dos objetos durante a reinicializacao.
		this.setRotationFrequency(0);
		this.setOpeningFactor(0);

		this.modelManager.getModel_map().setInput1(0);
		this.modelManager.getModel_map().setInput2(0);
		this.modelManager.getModel_map().setPressure_kPa(94.99);
		this.modelManager.getModel_map().setVolum_L(0.53751);
		this.modelManager.getModel_map().setMolar_mass_g_mol(28.96);
		this.modelManager.getModel_map().setTemperature_k(300);
		this.modelManager.getModel_map().setOutput();

		air.setPressure_kPa(this.modelManager.getModel_map().getPressure_kPa());
		air.setTemperatureKelvin(300);
		air.setVolum_liters(this.modelManager.getModel_map().getVolum_L());
		air.setAir_molar_mass_g_mol(
				this.modelManager.getModel_map().getMolar_mass_g_mol());

		internalAir
				.setTemperatureKelvin(air.getTemperatureKelvin());
		internalAir
				.setPressure_kPa(air.getPressure_kPa());
		internalAir
				.setVolum_liters(this.modelManager.getModel_map().getVolum_L());
		internalAir.setAir_molar_mass_g_mol(
				this.modelManager.getModel_map().getMolar_mass_g_mol());

		this.modelManager.getModel_maf().setInput1(0);
		this.modelManager.getModel_maf().setInput2(0);
		this.modelManager.getModel_maf().setOutput();
		air.setMass_flow_kg_h(this.modelManager.getModel_maf().getOutput());
		internalAir
				.setMass_flow_kg_h(air.getMass_flow_kg_h());

		field1 = formatAsStr(air.getPressure_kPa());
		field2 = formatAsStr(air.getTemperatureKelvin());
		field3 = formatAsStr(
				internalAir.getPressure_kPa());
		field4 = formatAsStr(
				internalAir.getMass_flow_kg_h());
		field5 = formatAsStr(universalMotorRotationFrequencyHz);
		field6 = formatAsStr(this.getOpeningFactor());
		field7 = formatAsStr(
				internalAir.getVolum_liters());
		field8 = formatAsStr(internalAir
				.getAir_molar_mass_g_mol());

		field9 = field3;
		field10 = field4;
		
		// fixa��o de valores;
		execution = 0;

		view.restart(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10);
	}

	public void setOpeningFactor(double current_opening_factor) {
		this.openingFactorElectronicThrottle = current_opening_factor;
		if (this.openingFactorElectronicThrottle > MAXOPENINGFACTOR)
			this.openingFactorElectronicThrottle = MAXOPENINGFACTOR;
		if (this.openingFactorElectronicThrottle < MINOPENINGFACTOR)
			this.openingFactorElectronicThrottle = MINOPENINGFACTOR;
	}

	public double getOpeningFactor() {
		return this.openingFactorElectronicThrottle;
	}
	
	/**
	 * Este m�todo change a vari�vel referente � frequ�ncia de rota��o do motor
	 * universal, na inst�ncia da classe Experimento_prototipo.
	 */
	public void change_rot_freq(double rot_freq) {

		double field3, field4;

		if (this.modelManager.getModelChoice() == -1)
			this.view.showMessage(this.view.getMessage("please_choose_a_model_before_changing_any_parameters"));

		// ajuste dos objetos para changer a frequ�ncia de rota��o do motor
		// universal.
		this.setRotationFrequency(rot_freq);

		this.modelManager.getModel_map().setInput1(rot_freq);

		this.modelManager.getModel_map().setOutput();

		internalAir
				.setPressure_kPa(this.modelManager.getModel_map().getOutput());

		this.modelManager.getModel_maf().setInput1(rot_freq);
		this.modelManager.getModel_maf().setOutput();
		internalAir
				.setMass_flow_kg_h(this.modelManager.getModel_maf().getOutput());

		execution = execution + 1;

		field3 = format(
				internalAir.getPressure_kPa());
		field4 = format(
				internalAir.getMass_flow_kg_h());
		this.view.change_rot_freq(format(rot_freq), field3, field4, execution);
	}

	/**
	 * Este m�todo change a vari�vel referente ao fator de abertura do m�dulo
	 * "v�lvula borboleta", na inst�ncia da classe Experimento_prototipo.
	 */
	public void change_open_factor(double open_factor) {

		double field3, field4;

		if (this.modelManager.getModelChoice() == -1)
			this.view.showMessage(this.view.getMessage("please_choose_a_model_before_changing_any_parameters"));

		// ajuste dos objetos para changer o fator de abertura do m�dulo v�lvula
		// borboleta.
		this.setOpeningFactor(open_factor);

		this.modelManager.getModel_map().setInput2(open_factor);
		this.modelManager.getModel_map().setOutput();
		internalAir
				.setPressure_kPa(this.modelManager.getModel_map().getOutput());

		this.modelManager.getModel_maf().setInput2(open_factor);
		this.modelManager.getModel_maf().setOutput();
		internalAir
				.setMass_flow_kg_h(this.modelManager.getModel_maf().getOutput());

		execution = execution + 1;

		field3 = format(
				internalAir.getPressure_kPa());

		field4 = format(
				internalAir.getMass_flow_kg_h());

		this.view.change_open_factor(format(open_factor), field3, field4, execution);

	}

	/**
	 * Este m�todo change a vari�vel referente � press�o do ar admitido e do ar
	 * ambiente, na inst�ncia da classe Experimento_prototipo.
	 */
	public void change_air_pressure(double air_pressure) {

		double field3;

		// ajuste dos objetos para changer a press�o do ar ambiente.
		this.modelManager.getModel_map().setPressure_kPa(air_pressure);
		this.modelManager.getModel_map().setOutput();
		air.setPressure_kPa(air_pressure);

		internalAir
				.setPressure_kPa(this.modelManager.getModel_map().getOutput());

		execution = execution + 1;

		field3 = format(
				internalAir.getPressure_kPa());

		this.view.change_air_pressure(format(air_pressure), field3, execution);
	}

	/**
	 * Este m�todo change a vari�vel referente ao volume do ar admitido, na
	 * inst�ncia da classe Experimento_prototipo.
	 */
	public void change_air_volum(double air_volum) {

		double field3;

		// ajuste dos objetos para changer o volume do ar admitido.
		this.modelManager.getModel_map().setVolum_L(air_volum);
		this.modelManager.getModel_map().setOutput();

		internalAir
				.setPressure_kPa(this.modelManager.getModel_map().getOutput());

		field3 = format(
				internalAir.getPressure_kPa());

		internalAir.setVolum_liters(air_volum);

		execution = execution + 1;

		this.view.change_air_volum(format(air_volum), field3, execution);
	}

	public void setRotationFrequency(double rotationFrequency) {
		this.universalMotorRotationFrequencyHz = rotationFrequency;
		if (this.universalMotorRotationFrequencyHz > MAXROTATIONHZ)
			this.universalMotorRotationFrequencyHz = MAXROTATIONHZ;
		if (this.universalMotorRotationFrequencyHz < MINROTATIONHZ)
			this.universalMotorRotationFrequencyHz = MINROTATIONHZ;
	}

	public double getRotationFrequency() {
		return this.universalMotorRotationFrequencyHz;
	}

	/**
	 * Este m�todo change a vari�vel referente � massa molar do ar admitido e do ar
	 * ambiente, na inst�ncia da classe Experimento_prototipo.
	 */
	public void change_air_molar_mass(double air_molar_mass) {

		double field3;

		// ajuste dos objetos para changer a massa molar do ar ambiente.
		this.modelManager.getModel_map().setMolar_mass_g_mol(air_molar_mass);
		this.modelManager.getModel_map().setOutput();
		air.setAir_molar_mass_g_mol(air_molar_mass);

		internalAir
				.setPressure_kPa(this.modelManager.getModel_map().getOutput());

		internalAir
				.setAir_molar_mass_g_mol(air_molar_mass);

		field3 = format(
				internalAir.getPressure_kPa());

		execution = execution + 1;

		this.view.change_air_molar_mass(format(air_molar_mass), field3, execution);
	}

	/**
	 * Este m�todo change a vari�vel referente � temperatura do ar ambiente e do ar
	 * admitido, na inst�ncia da classe Experimento_prototipo.
	 */
	public void change_air_temperature(double air_temperature) {

		double field3;

		// ajuste dos objetos para changer a temperatura do ar ambiente.
		this.modelManager.getModel_map().setTemperature_k(air_temperature);
		this.modelManager.getModel_map().setOutput();
		air.setTemperatureKelvin(air_temperature);

		internalAir
				.setPressure_kPa(this.modelManager.getModel_map().getOutput());

		field3 = format(
				internalAir.getPressure_kPa());

		internalAir
				.setTemperatureKelvin(air_temperature);

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
		// evento de changen�a do fator de abertura do m�dulo v�lvula borboleta.
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
		// evento de changen�a do volume total do ar admitido.
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
		// evento de changen�a da massa molar do ar ambiente.
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
		// evento de changen�a da temperatura do ar ambiente.
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
		// evento de interrup��o e t�rmino da simula��o atual.
		else if (e.getActionCommand().equals("stop_sim")) {
			System.exit(0);
		}
		// evento de rein�cio da simula��o atual.
		else if (e.getActionCommand().equals("restart_sim")) {
			restart();
		}
		// evento de t�rmino da execu��o atual deste software.
		else if (e.getActionCommand().equals("ExitCommand")) {
			System.exit(0);
		}
		// eventos de escolha de modelos.
		else if (e.getActionCommand().equals("Models1")) {

			if (this.modelManager.getModelChoice() > 0)
				this.view.retiracomponentes();
			this.modelManager.setModelChoice(0);

			this.view.eventModel0();

			this.modelManager.build_model_map(this.modelManager.getModelChoice());
			this.modelManager.buildMafModel(this.modelManager.getModelChoice());
			restart();
		} else if (e.getActionCommand().equals("Models2")) {

			if (this.modelManager.getModelChoice() <= 0)
				this.view.adicionacomponentes();
			this.modelManager.setModelChoice(1);

			this.view.eventModel1();

			this.modelManager.build_model_map(this.modelManager.getModelChoice());
			this.modelManager.buildMafModel(this.modelManager.getModelChoice());
			restart();
		} else if (e.getActionCommand().equals("Models3")) {

			if (this.modelManager.getModelChoice() <= 0)
				this.view.adicionacomponentes();
			this.modelManager.setModelChoice(2);

			this.view.eventModel2();

			this.modelManager.build_model_map(this.modelManager.getModelChoice());
			this.modelManager.buildMafModel(this.modelManager.getModelChoice());
			restart();
		} else if (e.getActionCommand().equals("Models4")) {

			if (this.modelManager.getModelChoice() <= 0)
				this.view.adicionacomponentes();
			this.modelManager.setModelChoice(3);

			this.view.eventModel3();

			this.modelManager.build_model_map(this.modelManager.getModelChoice());
			this.modelManager.buildMafModel(this.modelManager.getModelChoice());
			restart();
		} else if (e.getActionCommand().equals("Models5")) {

			if (this.modelManager.getModelChoice() <= 0)
				this.view.adicionacomponentes();
			this.modelManager.setModelChoice(4);

			this.view.eventModel4();

			this.modelManager.build_model_map(this.modelManager.getModelChoice());
			this.modelManager.buildMafModel(this.modelManager.getModelChoice());
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
		// evento de plotagem da resposta transit�ria da press�o do ar admitido.
		else if (e.getActionCommand().equals("dyn_press")) {
			this.view.plotGraphIAP(execution);
		}
		// evento de plotagem da resposta transit�ria do fluxo de massa do ar
		// admitido.
		else if (e.getActionCommand().equals("dyn_amf")) {
			this.view.plotGraphIAMF(execution);
		}
		// outros eventos.
		else {
		}
	}
}