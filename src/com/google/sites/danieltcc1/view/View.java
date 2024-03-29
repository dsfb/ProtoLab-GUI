package com.google.sites.danieltcc1.view;

import javax.swing.*;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import org.jfree.ui.RefineryUtilities;

import com.google.sites.danieltcc1.view.defined.Button;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;

	// declara��o de objetos e vari�veis.
	private JPanel windowContent;

	private GridLayout gl;

	private JLabel label1;
	private JLabel responseLabel1;
	private JLabel label2;
	private JLabel responseLabel2;
	private JLabel label3;
	private JLabel responseLabel3;
	private JLabel label4;
	private JLabel responseLabel4;
	private JLabel label5;
	private JLabel responseLabel5;
	private JLabel label6;
	private JLabel responseLabel6;
	private JLabel label7;
	private JLabel responseLabel7;
	private JLabel label8;
	private JLabel responseLabel8;
	private JLabel label9;
	private JLabel responseLabel9;
	private JLabel label10;
	private JLabel responseLabel10;

	private JButton mu_freq;
	private JButton etm_factor;
	private JButton air_pressure;
	private JButton air_volum;
	private JButton air_molar_mass;
	private JButton air_temperature;
	private JButton stop_sim;
	private Button restart_sim;
	private JButton dyn_press;
	private JButton dyn_amf;

	private String info;

	private JMenuBar menuBar;

	private JMenu fileMenu;
	private JMenuItem exitCommand;

	private JMenu modelsMenu;
	private JMenuItem models[];

	private JMenu optionMenu;
    private JMenu languageSetting;
    private JMenuItem enUsLang;
    private JMenuItem ptBrLang;

	private JMenu helpMenu;
	private JMenuItem aboutCommand;

	private JLabel chosenModel;

	private String language;

	private String country;

	private Locale currentLocale;
	private ResourceBundle messages;

	/**
	 * This is the default constructor
	 */
	public View(String[] args) {
		super();
		windowContent = new JPanel();

		gl = new GridLayout(12, 1);

		if (args.length != 2) {
			language = new String("en");
			country = new String("US");
		} else {
			language = new String(args[0]);
			country = new String(args[1]);
		}
		currentLocale = new Locale(language, country);
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		info = messages.getString("info");

		label1 = new JLabel();
		responseLabel1 = new JLabel();
		label2 = new JLabel(messages.getString("air_temperature_k_gui"));
		responseLabel2 = new JLabel();
		label3 = new JLabel(messages.getString("intake_air_pressure_kpa_gui"));
		responseLabel3 = new JLabel();
		label4 = new JLabel(messages.getString("intake_air_mass_flow_kgh_gui"));
		responseLabel4 = new JLabel();
		label5 = new JLabel(
				messages.getString("rotation_frequency_of_the_universal_motor_hz_gui"));
		responseLabel5 = new JLabel();
		label6 = new JLabel(
				messages.getString("opening_factor_of_the_electronic_throttle_module_gui"));
		responseLabel6 = new JLabel();
		label7 = new JLabel(messages.getString("intake_air_full_volum_l_gui"));
		responseLabel7 = new JLabel();
		label8 = new JLabel(messages.getString("air_molar_mass_gmol_gui"));
		responseLabel8 = new JLabel();
		label9 = new JLabel(
				messages.getString("previous_intake_air_pressure_kpa_gui"));
		responseLabel9 = new JLabel();
		label10 = new JLabel(
				messages.getString("previous_intake_air_mass_flow_kgh_gui"));
		responseLabel10 = new JLabel();

		chosenModel = new JLabel(
				messages.getString("first_message_chosen_model"));

		menuBar = new JMenuBar();

		fileMenu = new JMenu(messages.getString("file"));
		exitCommand = new JMenuItem(messages.getString("quit"));
		exitCommand.setActionCommand("ExitCommand");
		fileMenu.add(exitCommand);

		modelsMenu = new JMenu();
		models = new JMenuItem[5];
		for (int i = 1; i < 6; i++) {
			models[i - 1] = new JMenuItem();
			modelsMenu.add(models[i - 1]);
			models[i - 1].setActionCommand("Models" + i);
			models[i - 1].setFont(new Font("Arial", Font.PLAIN, 12));
		}

		helpMenu = new JMenu();
		aboutCommand = new JMenuItem(messages.getString("about"));
		aboutCommand.setActionCommand("AboutCommand");
		helpMenu.add(aboutCommand);

		optionMenu = new JMenu("Options");
        languageSetting = new JMenu("Language");
        optionMenu.add(languageSetting);
        enUsLang = new JMenuItem("English");
        ptBrLang = new JMenuItem("Portugu�s do Brasil");
        languageSetting.add(enUsLang);
        languageSetting.add(ptBrLang);
        enUsLang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// https://stackoverflow.com/questions/615973/changing-locale-at-runtime-in-swing
				ResourceBundle.clearCache();
				View.this.currentLocale = new Locale("en", "US");
				View.this.messages = ResourceBundle.getBundle("MessagesBundle", View.this.currentLocale);
				View.this.internationalize();
			}
        	
        });

        ptBrLang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						// https://stackoverflow.com/questions/615973/changing-locale-at-runtime-in-swing
						ResourceBundle.clearCache();
						View.this.currentLocale = new Locale("pt", "BR");
						View.this.messages = ResourceBundle.getBundle("MessagesBundle", View.this.currentLocale);
						View.this.internationalize();
					}
					
				});
				
			}
        	
        });

		responseLabel1.setHorizontalAlignment(JTextField.RIGHT);
		responseLabel2.setHorizontalAlignment(JTextField.RIGHT);
		responseLabel3.setHorizontalAlignment(JTextField.RIGHT);
		responseLabel4.setHorizontalAlignment(JTextField.RIGHT);
		responseLabel5.setHorizontalAlignment(JTextField.RIGHT);
		responseLabel6.setHorizontalAlignment(JTextField.RIGHT);
		responseLabel7.setHorizontalAlignment(JTextField.RIGHT);
		responseLabel8.setHorizontalAlignment(JTextField.RIGHT);
		responseLabel9.setHorizontalAlignment(JTextField.RIGHT);
		responseLabel10.setHorizontalAlignment(JTextField.RIGHT);

		mu_freq = new JButton(
				messages.getString("change_the_rotation_frequency_of_the_universal_motor"));
		etm_factor = new JButton(
				messages.getString("change_the_opening_factor_of_the_electronic_throttle_module"));
		air_pressure = new JButton(
				messages.getString("change_the_ambient_air_pressure"));
		air_volum = new JButton(
				messages.getString("change_the_intake_air_full_volum"));
		air_molar_mass = new JButton(
				messages.getString("change_the_ambient_air_molar_mass"));
		air_temperature = new JButton(
				messages.getString("change_the_ambient_air_temperature"));
		stop_sim = new Button(
				messages.getString("stop_the_simulation_and_quit_this_app"));
		stop_sim.setFont(new Font("Arial", Font.BOLD, 12));
		restart_sim = new Button(messages.getString("restart_the_simulation"));
		dyn_press = new JButton(
				messages.getString("plot_the_transient_response_of_the_intake_air_pressure"));
		dyn_amf = new JButton(
				messages.getString("plot_the_transient_response_of_the_air_mass_flow"));

		info = messages.getString("info");

		windowContent.setLayout(gl);

		windowContent.add(label1);
		windowContent.add(responseLabel1);
		windowContent.add(label2);
		windowContent.add(responseLabel2);
		windowContent.add(label3);
		windowContent.add(responseLabel3);
		windowContent.add(label4);
		windowContent.add(responseLabel4);
		windowContent.add(label5);
		windowContent.add(responseLabel5);
		windowContent.add(label6);
		windowContent.add(responseLabel6);
		windowContent.add(label9);
		windowContent.add(responseLabel9);
		windowContent.add(label10);
		windowContent.add(responseLabel10);

		windowContent.add(mu_freq);
		windowContent.add(etm_factor);
		windowContent.add(dyn_press);
		windowContent.add(dyn_amf);
		windowContent.add(stop_sim);
		windowContent.add(restart_sim);
		windowContent.add(chosenModel);

		menuBar.add(fileMenu);
		menuBar.add(modelsMenu);
		menuBar.add(optionMenu);
		menuBar.add(helpMenu);

		Component[] elements = {label1, responseLabel1, label2,
				responseLabel2, label3, responseLabel3, label4,
				responseLabel4, label5, responseLabel5, label6,
				responseLabel6, label7, responseLabel7, label8,
				responseLabel8, label9, responseLabel9, label10,
				responseLabel10, mu_freq, etm_factor, dyn_press,
				dyn_amf, stop_sim, restart_sim, chosenModel,
				fileMenu, modelsMenu, optionMenu, helpMenu,
				air_pressure, air_volum, air_molar_mass,
				air_temperature, dyn_press, exitCommand,
				aboutCommand, languageSetting, enUsLang,
				ptBrLang};

		for (Component element : elements) {
			element.setFont(new Font("Arial", Font.PLAIN, 12));
		}

		mu_freq.setActionCommand("mu_freq");
		etm_factor.setActionCommand("etm_factor");
		stop_sim.setActionCommand("stop_sim");
		restart_sim.setActionCommand("restart_sim");
		air_pressure.setActionCommand("air_pressure");
		air_volum.setActionCommand("air_volum");
		air_molar_mass.setActionCommand("air_molar_mass");
		air_temperature.setActionCommand("air_temperature");
		dyn_press.setActionCommand("dyn_press");
		dyn_amf.setActionCommand("dyn_amf");

		initialize();
	}

	private void internationalize() {
		this.setTitle(info + " "
				+ messages.getString("the_simulation_was_started"));
		info = messages.getString("info");
		label1.setText(messages.getString("ambient_air_pressure_kpa_gui"));
		modelsMenu.setText(messages.getString("choose_a_model"));
		
		for (int i = 1; i < 6; i++) {
			String label = " " +
					messages.getString("model") + " " + 
					messages.getString("of_type") + " " +
					messages.getString("phenomenological");
			switch (i) {
			case 1:
				label = messages.getString("first") + " " +
						messages.getString("model") + " " +
						messages.getString("with") + " " +
						messages.getString("ann");
				break;
			case 2:
				label = messages.getString("second") + label;
				break;
			case 3:
				label = messages.getString("third") + label;
				break;
			case 4:
				label = messages.getString("fourth") + label;
				break;
			case 5:
				label = messages.getString("fifth") + label;
				break;
			default:
				label = "Unknown option!";
				break;
			}
			models[i - 1].setText(label);
		}
		helpMenu.setText(messages.getString("help"));
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setContentPane(windowContent);
		this.setJMenuBar(menuBar);
		this.internationalize();
		this.pack();
	}

	public void restart(String field1, String field2, String field3,
			String field4, String responselabel5, String responselabel6, String responselabel7,
			String responselabel8, String responselabel9, String responselabel10) {
		// reajuste da janela na Interface Gr�fica do Usu�rio.
		this.responseLabel1.setText(field1);
		this.responseLabel2.setText(field2);
		this.responseLabel3.setText(field3);
		this.responseLabel4.setText(field4);
		this.responseLabel5.setText(responselabel5);
		if (responselabel6 != null) {
			this.responseLabel6.setText(responselabel6);
		}
		if (responselabel7 != null) {
			this.responseLabel7.setText(responselabel7);
		}
		if (responselabel8 != null) {
			this.responseLabel8.setText(responselabel8);
		}
		if (responselabel9 != null) {
			this.responseLabel9.setText(responselabel9);
		}
		if (responselabel10 != null) {
			this.responseLabel10.setText(responselabel10);
		}
		windowContent.revalidate();
		windowContent.repaint();

		this.setTitle(info + " - "
				+ messages.getString("the_simulation_was_started_pass") + 0);
	}

	public void configureListener(ActionListener listener) {
		mu_freq.addActionListener(listener);
		etm_factor.addActionListener(listener);
		stop_sim.addActionListener(listener);
		restart_sim.addActionListener(listener);
		air_pressure.addActionListener(listener);
		air_volum.addActionListener(listener);
		air_molar_mass.addActionListener(listener);
		air_temperature.addActionListener(listener);
		dyn_press.addActionListener(listener);
		dyn_amf.addActionListener(listener);

		exitCommand.addActionListener(listener);
		for (int i = 1; i < 6; i++) {
			models[i - 1].addActionListener(listener);
		}
		aboutCommand.addActionListener(listener);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public String showInput(String message) {
		return JOptionPane.showInputDialog(null, message);
	}

	public String getMessage(String message) {
		return messages.getString(message);
	}

	public void plotGraphIAP(int execution) {

		PlotGraph graph;
		graph = new PlotGraph(
				messages.getString("transient_response_graph_of_the_intake_air_pressure_model"),
				messages.getString("transient_response_of_the_system_iapm"),
				messages.getString("time") + " (s)", messages
						.getString("amplitude_of_this_transient_response"),
				Double.parseDouble(responseLabel9.getText()), Double.parseDouble(responseLabel3
						.getText()));

		graph.pack();
		RefineryUtilities.centerFrameOnScreen(graph);
		graph.setVisible(true);
		graph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void plotGraphIAMF(int execution) {

		PlotGraph graph;
		graph = new PlotGraph(
				messages.getString("transient_response_graph_of_the_air_mass_flow_model"),
				messages.getString("transient_response_of_the_system_amfm"),
				messages.getString("time") + " (s)", messages
						.getString("amplitude_of_this_transient_response"),
				Double.parseDouble(responseLabel10.getText()), Double
						.parseDouble(responseLabel4.getText()));

		graph.pack();
		RefineryUtilities.centerFrameOnScreen(graph);
		graph.setVisible(true);
		graph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Este m�todo change a vari�vel referente � frequ�ncia de rota��o do motor
	 * universal, na inst�ncia da classe Experimento_prototipo.
	 */
	public void change_rot_freq(double rot_freq, double field_3,
			double field_4, int execution) {

		// ajuste dos objetos para changer a frequ�ncia de rota��o do motor
		// universal.
		responseLabel5.setText(rot_freq + "");

		responseLabel9.setText(responseLabel3.getText());
		responseLabel3.setText(field_3 + "");

		responseLabel10.setText(responseLabel4.getText());
		responseLabel4.setText(field_4 + "");

		this.setTitle(info + " - "
				+ messages.getString("the_simulation_is_in_progress_step")
				+ execution);
	}

	/**
	 * Este m�todo change a vari�vel referente ao fator de abertura do m�dulo
	 * "v�lvula borboleta", na inst�ncia da classe Experimento_prototipo.
	 */
	public void change_open_factor(double open_factor, double field3,
			double field4, int execution) {

		// ajuste dos objetos para changer o fator de abertura do m�dulo v�lvula
		// borboleta.
		responseLabel6.setText(open_factor + "");

		responseLabel9.setText(this.responseLabel3.getText());
		this.responseLabel3.setText(field3 + "");

		responseLabel10.setText(this.responseLabel4.getText());
		this.responseLabel4.setText(field4 + "");

		execution = execution + 1;

		this.setTitle(info + " - "
				+ messages.getString("the_simulation_is_in_progress_step")
				+ execution);
	}

	/**
	 * Este m�todo change a vari�vel referente � press�o do ar admitido e do ar
	 * ambiente, na inst�ncia da classe Experimento_prototipo.
	 */
	public void change_air_pressure(double air_pressure, double field3,
			int execution) {

		// ajuste dos objetos para changer a press�o do ar ambiente.
		responseLabel1.setText(air_pressure + "");

		responseLabel9.setText(this.responseLabel3.getText());
		this.responseLabel3.setText(field3 + "");

		this.setTitle(info + " - "
				+ messages.getString("the_simulation_is_in_progress_step")
				+ execution);
	}

	/**
	 * Este m�todo change a vari�vel referente ao volume do ar admitido, na
	 * inst�ncia da classe Experimento_prototipo.
	 */
	public void change_air_volum(double air_volum, double field3, int execution) {

		// ajuste dos objetos para changer o volume do ar admitido.
		responseLabel9.setText(this.responseLabel3.getText());
		this.responseLabel3.setText(field3 + "");

		responseLabel7.setText(air_volum + "");

		this.setTitle(info + " - "
				+ messages.getString("the_simulation_is_in_progress_step")
				+ execution);
	}

	/**
	 * Este m�todo change a vari�vel referente � massa molar do ar admitido e do
	 * ar ambiente, na inst�ncia da classe Experimento_prototipo.
	 */
	public void change_air_molar_mass(double air_molar_mass, double field3,
			int execution) {

		// ajuste dos objetos para changer a massa molar do ar ambiente.
		responseLabel9.setText(this.responseLabel3.getText());
		this.responseLabel3.setText(field3 + "");

		responseLabel8.setText(air_molar_mass + "");

		this.setTitle(info + " - "
				+ messages.getString("the_simulation_is_in_progress_step")
				+ execution);
	}

	/**
	 * Este m�todo change a vari�vel referente � temperatura do ar ambiente e do
	 * ar admitido, na inst�ncia da classe Experimento_prototipo.
	 */
	public void change_air_temperature(double air_temperature, double field3,
			int execution) {

		// ajuste dos objetos para changer a temperatura do ar ambiente.
		responseLabel9.setText(this.responseLabel3.getText());
		this.responseLabel3.setText(field3 + "");

		responseLabel2.setText(air_temperature + "");

		execution = execution + 1;

		this.setTitle(info + " - "
				+ messages.getString("the_simulation_is_in_progress_step")
				+ execution);
	}

	/**
	 * Este m�todo retira os componentes da Interface Gr�fica do Usu�rio que s�o
	 * desnecess�rios durante alguma situa��o de simula��o.
	 */
	public void retiracomponentes() {

		// ajuste dos objetos na janela da Interface Gr�fica do Usu�rio.
		gl = new GridLayout(12, 1);

		windowContent.setLayout(gl);

		windowContent.remove(label7);
		windowContent.remove(responseLabel7);
		windowContent.remove(label8);
		windowContent.remove(responseLabel8);

		windowContent.remove(air_pressure);
		windowContent.remove(air_volum);
		windowContent.remove(air_molar_mass);
		windowContent.remove(air_temperature);

		windowContent.revalidate();
		windowContent.repaint();

		this.pack();

	}

	/**
	 * Este m�todo adiciona os componentes da Interface Gr�fica do Usu�rio que
	 * s�o necess�rios durante alguma situa��o de simula��o.
	 */
	public void adicionacomponentes() {

		// ajuste dos objetos na janela da Interface Gr�fica do Usu�rio.
		gl = new GridLayout(16, 1);

		windowContent.setLayout(gl);

		windowContent.remove(mu_freq);
		windowContent.remove(etm_factor);
		windowContent.remove(dyn_press);
		windowContent.remove(dyn_amf);
		windowContent.remove(stop_sim);
		windowContent.remove(restart_sim);
		windowContent.remove(chosenModel);

		windowContent.add(label7);
		windowContent.add(responseLabel7);
		windowContent.add(label8);
		windowContent.add(responseLabel8);

		windowContent.add(mu_freq);
		windowContent.add(etm_factor);

		windowContent.add(air_pressure);
		windowContent.add(air_volum);
		windowContent.add(air_molar_mass);
		windowContent.add(air_temperature);

		windowContent.add(dyn_press);
		windowContent.add(dyn_amf);
		windowContent.add(stop_sim);
		windowContent.add(restart_sim);
		windowContent.add(chosenModel);

		windowContent.revalidate();
		windowContent.repaint();

		this.pack();
	}

	public void eventModel0() {
		info = messages.getString("info") + " - " + messages.getString("first") + " "
				+ messages.getString("model") + " with " + messages.getString("ann");
		chosenModel.setText(messages.getString("the_model") + " " + messages.getString("first")
				+ messages.getString("model") + " with " + messages.getString("ann") 
				+ " " + messages.getString("was_chosen"));
	}

	private void eventModelPhenomenologicalX(int x) {
		String label = "";
		switch(x) {
		case 2:
			label = messages.getString("second");
			break;
		case 3:
			label = messages.getString("third");
			break;
		case 4:
			label = messages.getString("fourth");
			break;
		case 5:
			label = messages.getString("fifth");
			break;
		default:
			label = "unknown";
			break;
		}
		info = messages.getString("info") + " - " + label + " "
				+ messages.getString("model") + " " + 
				messages.getString("of_type") + " " + 
				messages.getString("phenomenological");
		chosenModel.setText(messages.getString("the") + " " + label + " " +
				messages.getString("model") + " " + messages.getString("of_type")
				+ " " + messages.getString("phenomenological") + " " + 
				messages.getString("was_chosen"));
			
	}
	
	public void eventModel1() {
		this.eventModelPhenomenologicalX(2);
	}

	public void eventModel2() {
		this.eventModelPhenomenologicalX(3);
	}

	public void eventModel3() {
		this.eventModelPhenomenologicalX(4);
	}

	public void eventModel4() {
		this.eventModelPhenomenologicalX(5);
	}
}