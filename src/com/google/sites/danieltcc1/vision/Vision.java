package com.google.sites.danieltcc1.vision;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.*;
import org.jfree.ui.RefineryUtilities;

public class Vision extends JFrame {

	/**
  * 
  */
	private static final long serialVersionUID = 1L;

	// declaração de objetos e variáveis.
	private JPanel windowContent;

	private GridLayout gl;

	private JLabel label1;
	private JLabel responselabel1;
	private JLabel label2;
	private JLabel responselabel2;
	private JLabel label3;
	private JLabel responselabel3;
	private JLabel label4;
	private JLabel responselabel4;
	private JLabel label5;
	private JLabel responselabel5;
	private JLabel label6;
	private JLabel responselabel6;
	private JLabel label7;
	private JLabel responselabel7;
	private JLabel label8;
	private JLabel responselabel8;
	private JLabel label9;
	private JLabel responselabel9;
	private JLabel label10;
	private JLabel responselabel10;

	private JButton mu_freq;
	private JButton etm_factor;
	private JButton air_pressure;
	private JButton air_volum;
	private JButton air_molar_mass;
	private JButton air_temperature;
	private JButton stop_sim;
	private JButton restart_sim;
	private JButton dyn_press;
	private JButton dyn_amf;

	private String info;

	private JMenuBar menuBar;

	private JMenu FileMenu;
	private JMenuItem ExitCommand;

	private JMenu ModelsMenu;
	private JMenuItem Models[];

	private JMenu HelpMenu;
	private JMenuItem AboutCommand;

	private JLabel modelo_escolhido;

	private String language;

	private String country;

	private Locale currentLocale;
	private ResourceBundle messages;

	/**
	 * This is the default constructor
	 */
	public Vision(String[] args) {
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

		label1 = new JLabel(messages.getString("ambient_air_pressure_kpa_gui"));
		responselabel1 = new JLabel();
		label2 = new JLabel(messages.getString("air_temperature_k_gui"));
		responselabel2 = new JLabel();
		label3 = new JLabel(messages.getString("intake_air_pressure_kpa_gui"));
		responselabel3 = new JLabel();
		label4 = new JLabel(messages.getString("intake_air_mass_flow_kgh_gui"));
		responselabel4 = new JLabel();
		label5 = new JLabel(
				messages.getString("rotation_frequency_of_the_universal_motor_hz_gui"));
		responselabel5 = new JLabel();
		label6 = new JLabel(
				messages.getString("opening_factor_of_the_electronic_throttle_module_gui"));
		responselabel6 = new JLabel();
		label7 = new JLabel(messages.getString("intake_air_full_volum_l_gui"));
		responselabel7 = new JLabel();
		label8 = new JLabel(messages.getString("air_molar_mass_gmol_gui"));
		responselabel8 = new JLabel();
		label9 = new JLabel(
				messages.getString("previous_intake_air_pressure_kpa_gui"));
		responselabel9 = new JLabel();
		label10 = new JLabel(
				messages.getString("previous_intake_air_mass_flow_kgh_gui"));
		responselabel10 = new JLabel();

		modelo_escolhido = new JLabel(
				messages.getString("first_message_chosen_model"));

		menuBar = new JMenuBar();

		FileMenu = new JMenu(messages.getString("file"));
		ExitCommand = new JMenuItem(messages.getString("quit"));
		ExitCommand.setActionCommand("ExitCommand");
		FileMenu.add(ExitCommand);

		ModelsMenu = new JMenu(messages.getString("choose_a_model"));
		Models = new JMenuItem[5];
		for (int i = 1; i < 6; i++) {
			Models[i - 1] = new JMenuItem(messages.getString("model") + i);
			ModelsMenu.add(Models[i - 1]);
			Models[i - 1].setActionCommand("Models" + i);
		}
		HelpMenu = new JMenu(messages.getString("help"));
		AboutCommand = new JMenuItem(messages.getString("about"));
		AboutCommand.setActionCommand("AboutCommand");
		HelpMenu.add(AboutCommand);

		responselabel1.setHorizontalAlignment(JTextField.RIGHT);
		responselabel2.setHorizontalAlignment(JTextField.RIGHT);
		responselabel3.setHorizontalAlignment(JTextField.RIGHT);
		responselabel4.setHorizontalAlignment(JTextField.RIGHT);
		responselabel5.setHorizontalAlignment(JTextField.RIGHT);
		responselabel6.setHorizontalAlignment(JTextField.RIGHT);
		responselabel7.setHorizontalAlignment(JTextField.RIGHT);
		responselabel8.setHorizontalAlignment(JTextField.RIGHT);
		responselabel9.setHorizontalAlignment(JTextField.RIGHT);
		responselabel10.setHorizontalAlignment(JTextField.RIGHT);

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
		stop_sim = new JButton(
				messages.getString("stop_the_simulation_and_quit_this_app"));
		restart_sim = new JButton(messages.getString("restart_the_simulation"));
		dyn_press = new JButton(
				messages.getString("plot_the_transient_response_of_the_intake_air_pressure"));
		dyn_amf = new JButton(
				messages.getString("plot_the_transient_response_of_the_air_mass_flow"));

		info = messages.getString("info");

		windowContent.setLayout(gl);

		windowContent.add(label1);
		windowContent.add(responselabel1);
		windowContent.add(label2);
		windowContent.add(responselabel2);
		windowContent.add(label3);
		windowContent.add(responselabel3);
		windowContent.add(label4);
		windowContent.add(responselabel4);
		windowContent.add(label5);
		windowContent.add(responselabel5);
		windowContent.add(label6);
		windowContent.add(responselabel6);
		windowContent.add(label9);
		windowContent.add(responselabel9);
		windowContent.add(label10);
		windowContent.add(responselabel10);

		windowContent.add(mu_freq);
		windowContent.add(etm_factor);
		windowContent.add(dyn_press);
		windowContent.add(dyn_amf);
		windowContent.add(stop_sim);
		windowContent.add(restart_sim);
		windowContent.add(modelo_escolhido);

		menuBar.add(FileMenu);
		menuBar.add(ModelsMenu);
		menuBar.add(HelpMenu);

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

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setContentPane(windowContent);
		this.setJMenuBar(menuBar);
		this.setTitle(info + " "
				+ messages.getString("the_simulation_was_started"));
		this.pack();
	}

	public void restart(String field1, String field2, String field3,
			String field4, String responselabel5, String responselabel6, String responselabel7,
			String responselabel8, String responselabel9, String responselabel10) {
		// reajuste da janela na Interface Gráfica do Usuário.
		if (field1 != null) {
			this.responselabel1.setText(field1);
		}
		if (field2 != null) {
			this.responselabel2.setText(field2);
		}
		if (field3 != null) {
			this.responselabel3.setText(field3);
		}
		if (field4 != null) {
			this.responselabel4.setText(field4);
		}
		if (responselabel5 != null) {
			this.responselabel5.setText(responselabel5);
		}
		if (responselabel6 != null) {
			this.responselabel6.setText(responselabel6);
		}
		if (responselabel7 != null) {
			this.responselabel7.setText(responselabel7);
		}
		if (responselabel8 != null) {
			this.responselabel8.setText(responselabel8);
		}
		if (responselabel9 != null) {
			this.responselabel9.setText(responselabel9);
		}
		if (responselabel10 != null) {
			this.responselabel10.setText(responselabel10);
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

		ExitCommand.addActionListener(listener);
		for (int i = 1; i < 6; i++) {
			Models[i - 1].addActionListener(listener);
		}
		AboutCommand.addActionListener(listener);
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
				Double.parseDouble(responselabel9.getText()), Double.parseDouble(responselabel3
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
				Double.parseDouble(responselabel10.getText()), Double
						.parseDouble(responselabel4.getText()));

		graph.pack();
		RefineryUtilities.centerFrameOnScreen(graph);
		graph.setVisible(true);
		graph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Este método change a variável referente à frequência de rotação do motor
	 * universal, na instância da classe Experimento_prototipo.
	 */
	public void change_rot_freq(double rot_freq, double field_3,
			double field_4, int execution) {

		// ajuste dos objetos para changer a frequência de rotação do motor
		// universal.
		responselabel5.setText(rot_freq + "");

		responselabel9.setText(responselabel3.getText());
		responselabel3.setText(field_3 + "");

		responselabel10.setText(responselabel4.getText());
		responselabel4.setText(field_4 + "");

		this.setTitle(info + " - "
				+ messages.getString("the_simulation_is_in_progress_step")
				+ execution);
	}

	/**
	 * Este método change a variável referente ao fator de abertura do módulo
	 * "válvula borboleta", na instância da classe Experimento_prototipo.
	 */
	public void change_open_factor(double open_factor, double field3,
			double field4, int execution) {

		// ajuste dos objetos para changer o fator de abertura do módulo válvula
		// borboleta.
		responselabel6.setText(open_factor + "");

		responselabel9.setText(this.responselabel3.getText());
		this.responselabel3.setText(field3 + "");

		responselabel10.setText(this.responselabel4.getText());
		this.responselabel4.setText(field4 + "");

		execution = execution + 1;

		this.setTitle(info + " - "
				+ messages.getString("the_simulation_is_in_progress_step")
				+ execution);
	}

	/**
	 * Este método change a variável referente à pressão do ar admitido e do ar
	 * ambiente, na instância da classe Experimento_prototipo.
	 */
	public void change_air_pressure(double air_pressure, double field3,
			int execution) {

		// ajuste dos objetos para changer a pressão do ar ambiente.
		responselabel1.setText(air_pressure + "");

		responselabel9.setText(this.responselabel3.getText());
		this.responselabel3.setText(field3 + "");

		this.setTitle(info + " - "
				+ messages.getString("the_simulation_is_in_progress_step")
				+ execution);
	}

	/**
	 * Este método change a variável referente ao volume do ar admitido, na
	 * instância da classe Experimento_prototipo.
	 */
	public void change_air_volum(double air_volum, double field3, int execution) {

		// ajuste dos objetos para changer o volume do ar admitido.
		responselabel9.setText(this.responselabel3.getText());
		this.responselabel3.setText(field3 + "");

		responselabel7.setText(air_volum + "");

		this.setTitle(info + " - "
				+ messages.getString("the_simulation_is_in_progress_step")
				+ execution);
	}

	/**
	 * Este método change a variável referente à massa molar do ar admitido e do
	 * ar ambiente, na instância da classe Experimento_prototipo.
	 */
	public void change_air_molar_mass(double air_molar_mass, double field3,
			int execution) {

		// ajuste dos objetos para changer a massa molar do ar ambiente.
		responselabel9.setText(this.responselabel3.getText());
		this.responselabel3.setText(field3 + "");

		responselabel8.setText(air_molar_mass + "");

		this.setTitle(info + " - "
				+ messages.getString("the_simulation_is_in_progress_step")
				+ execution);
	}

	/**
	 * Este método change a variável referente à temperatura do ar ambiente e do
	 * ar admitido, na instância da classe Experimento_prototipo.
	 */
	public void change_air_temperature(double air_temperature, double field3,
			int execution) {

		// ajuste dos objetos para changer a temperatura do ar ambiente.
		responselabel9.setText(this.responselabel3.getText());
		this.responselabel3.setText(field3 + "");

		responselabel2.setText(air_temperature + "");

		execution = execution + 1;

		this.setTitle(info + " - "
				+ messages.getString("the_simulation_is_in_progress_step")
				+ execution);
	}

	/**
	 * Este método retira os componentes da Interface Gráfica do Usuário que são
	 * desnecessários durante alguma situação de simulação.
	 */
	public void retiracomponentes() {

		// ajuste dos objetos na janela da Interface Gráfica do Usuário.
		gl = new GridLayout(12, 1);

		windowContent.setLayout(gl);

		windowContent.remove(label7);
		windowContent.remove(responselabel7);
		windowContent.remove(label8);
		windowContent.remove(responselabel8);

		windowContent.remove(air_pressure);
		windowContent.remove(air_volum);
		windowContent.remove(air_molar_mass);
		windowContent.remove(air_temperature);

		windowContent.revalidate();
		windowContent.repaint();

		this.pack();

	}

	/**
	 * Este método adiciona os componentes da Interface Gráfica do Usuário que
	 * são necessários durante alguma situação de simulação.
	 */
	public void adicionacomponentes() {

		// ajuste dos objetos na janela da Interface Gráfica do Usuário.
		gl = new GridLayout(16, 1);

		windowContent.setLayout(gl);

		windowContent.remove(mu_freq);
		windowContent.remove(etm_factor);
		windowContent.remove(dyn_press);
		windowContent.remove(dyn_amf);
		windowContent.remove(stop_sim);
		windowContent.remove(restart_sim);
		windowContent.remove(modelo_escolhido);

		windowContent.add(label7);
		windowContent.add(responselabel7);
		windowContent.add(label8);
		windowContent.add(responselabel8);

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
		windowContent.add(modelo_escolhido);

		windowContent.revalidate();
		windowContent.repaint();

		this.pack();
	}

	public void eventModel0() {
		info = messages.getString("info") + " - 1. "
				+ messages.getString("model");
		modelo_escolhido.setText(messages.getString("the_model") + "1 "
				+ messages.getString("was_chosen"));
	}

	public void eventModel1() {
		info = messages.getString("info") + " - 2. "
				+ messages.getString("model");
		modelo_escolhido.setText(messages.getString("the_model") + "2 "
				+ messages.getString("was_chosen"));
	}

	public void eventModel2() {
		info = messages.getString("info") + " - 3. "
				+ messages.getString("model");
		modelo_escolhido.setText(messages.getString("the_model") + "3 "
				+ messages.getString("was_chosen"));
	}

	public void eventModel3() {
		info = messages.getString("info") + " - 4. "
				+ messages.getString("model");
		modelo_escolhido.setText(messages.getString("the_model") + "4 "
				+ messages.getString("was_chosen"));
	}

	public void eventModel4() {
		info = messages.getString("info") + " - 5. "
				+ messages.getString("model");
		modelo_escolhido.setText(messages.getString("the_model") + "5 "
				+ messages.getString("was_chosen"));
	}
}