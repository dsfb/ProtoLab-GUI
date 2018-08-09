package com.google.sites.danieltcc1.model;

/**
 * Classe que define o modelo feito com RNA para fornecer a pressão do ar
 * admitido. Esta classe recebe como entrada dois números reais, que são a
 * frequência de rotação do motor universal (0-280Hz) e o fator de abertura do
 * módulo "válvula borboleta" (0-1) e fornece como saída a pressão do ar
 * admitido (kPa).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.1
 * @since versão 1.0b1
 */
class Map_ann extends Model {

	// declaração e instanciação de variáveis.
	private double mainWeights[] = { -0.511706444191813, -0.344353307730753,
			-0.764108793162510, 1.267826852673265, -0.555643548758986,
			-0.154553701447127, 1.669107032600022, 0.320561012488859,
			6.792301573274761, 1.132439483766817, -0.391168064314198,
			-0.357294674169656, -0.482254357586175, -1.108427804033872,
			0.675202299101416, -1.656731829038499, 0.165792719230719,
			3.843829480082361, -1.021784108795377, 0.002860104578673,
			0.856380310039862, 0.138936793306635, -0.295330077049945,
			-1.358032500024169, 0.383334224445037, -0.527855195089648,
			0.417032716622112, -0.129044543586513, -0.649948700572289,
			0.188403522518733, 2.284097565554414, -0.642555015366342,
			-5.425910400159317, 0.200449775582260, -0.260836048459364,
			0.643326293450102, -0.001139325838746, 4.118934216951689,
			0.067252947707043, -0.019080866042566, 2.774583108696536,
			0.629459941591412, 0.724163836389440, 0.705307574842162,
			0.993811328238579, 0.877680507963909, 2.065747754561889,
			-1.646255351514270, -1.310977395990261, -0.027372398858996,
			0.249335872188902, -1.752778500146101, 1.351930556259141,
			0.466199804472675, 1.158617014640232, -0.322907908254381,
			0.931379017492138, -1.019628254318927, 0.466549378374106,
			0.410269504548284, 0.789871428897160, -1.683837986578975,
			-0.794139012762853, 1.250646491563466, -0.617098315467303,
			0.307437738177914, -0.446669262991229, 0.049355243466497,
			1.374748066176206, 0.095063331827818, 0.593934187588542,
			1.483067369670699, -0.938050364579116, -1.815986221759884,
			-0.215289378914087, -0.212032011810586, -1.182770578581595,
			0.177390137831041, -0.800394853335377, 2.500232527325115,
			-2.707527198428466, 1.389397524117964, -0.933423624342362,
			0.105559476830702, 1.980597595636001, -3.731133877111759,
			-0.715589346634318, 2.107976913326898, -1.381646544950880,
			-1.729094646354929, 0.849036530066724, 0.149984526778217,
			1.223623287261778, -1.829557658992579, 0.985174830371674,
			0.363059849222935, -0.419736792796665, 1.188233328777818,
			-0.442217682511213, -0.031458275619050, 0.207919006087982,
			0.380464683542972, 1.159497485356833, 0.112006550531954,
			-0.069668954238967, -0.028147108020281, -0.607691780953120,
			-0.816081297547369, -0.735966581389491, -0.585249624274159,
			0.560209425127299, 0.331520460534084, -1.207885043153171,
			0.962562342380156, 0.963871365942483, 0.028253020104892,
			0.537498101016721, 0.555879669858611, -0.836651245069403,
			-0.285738432801014, -0.709039606568463, 0.859261049536479,
			-0.732421443260700, -0.197016779333875, 0.697836210714957,
			-0.839138326911844, -0.227882258346471, 0.109310451496808,
			0.453103667538821, 1.188014988111730, 0.612301076428731,
			-0.320039244669561, 2.098742355150140, 0.554525568799470,
			0.818283944726630, -1.378862939019555, 0.144601608847830,
			-0.028293167947786, 1.046425432289448, -0.092592598883067,
			2.227707235609934, -0.539497253862768, -2.879091630077081,
			-1.538840324864955, -0.635918283454893, -0.292595162527649,
			-0.727473778411918, -0.997569444408794, -1.214962103237866,
			-0.505250269152619, 1.725956469560833, 0.597920913711359,
			0.253484892768997, -0.779298901103738, -0.079117852311374,
			-0.141679754683664, -2.744988126326935, 0.053422207564130,
			1.291835169112297, 1.988035634808787, -1.611510036398706,
			-0.140401815659510, -0.135589203649391, 1.478405642202507,
			-0.138922363551511, 0.580595936074637, -0.252054106974121,
			-0.335318270995304, 0.295437726904328, 0.413476227458568,
			-0.510638572151043, -0.109875573299424, 0.420027285270223,
			0.645942665243147, -0.192606526723528, 0.364657058468049,
			0.722159445195184, -0.464254057465826, -0.679418591069034,
			0.960409926805308, -0.617612006433689, -1.427994013784664,
			-0.618371933337371, -0.202899146097166, -1.598666656037371,
			-0.585907067029418, -0.811287637522361, -0.375176098817205,
			-0.716219844006575, 0.719143723257637, -0.717310419048891,
			-0.277876345762706, -0.860299187601859, -0.492052757169222,
			-0.198517758719802, -0.933295440148472, -0.305240319600072,
			-0.158816264614485, 0.542583214801548, 0.376947717661787,
			0.029875206969661, 0.842085436767842, 0.876735200933024,
			-1.897606319694278, -0.418651138843941, -0.344494053411072,
			-1.736333777217276, -0.171460592256441, 0.738038495210300,
			-0.879574319109635, 0.605839953863821, -2.154611210377917,
			-0.369828700166955, 0.600279634356512, -0.349363160403351,
			0.113574397858992, -0.094169468317822, 0.357897077147551,
			1.429795422414972, 1.390172984599732, 0.583565535475608,
			0.924799880364218, -0.308244689104522, -0.295594296830410,
			-0.068825471866612, -0.791166571172268, -1.239585345386830,
			0.246747532244439, -0.431332244494611, 0.630361026552314,
			1.102636355602630, -4.455123016512165, 1.339119720989920,
			-0.875174873026101, 0.455118902539114, 0.062559771652410,
			1.299937661348390, -0.580971545284363, -0.181009172385389,
			-2.495728408110466, -0.323720922915010, 1.096877422416151,
			-0.061369636497567, -0.203433389029317, 1.096484985738259,
			-0.279962825906688, 0.538750958050000, 0.146566354322685,
			-1.927753313892649, -0.091550300823003, -0.118845737778960,
			-2.017950960726187, -0.566252082293054, -0.149224701021010,
			-0.666545360627681, 1.029781599937922, 0.302570041632466,
			0.422156827821046, 1.630230107979055, -1.185429520986624,
			-1.537275093881780, -1.014740781677737, -0.220810530723603,
			0.107215377035998, 0.958619219445506, -0.702872962792630,
			-0.441535717105914, -0.888300964268038, -0.070912304039486,
			0.411315754335953, 0.732380224890699, 0.591140320278601,
			-0.122899149993387, 0.033427027852552, 0.994944614756616,
			-0.823948394096079, 0.727956151259131, 0.235613435917905,
			-0.647429332014370, -0.836191385091420, -0.389753673217360,
			-0.590409266982876, 0.620702878617510, -1.163305706980641,
			-0.128001549077435, -0.922203753245003, 1.048726415633665,
			0.257686760917274, 1.123728186236590, -1.072789554982607,
			-1.003873076067791, -0.128553338481620, 0.973741271206833,
			-0.324079540284648, 0.967390125871626, -0.113718628893251,
			0.802080479288223, 1.993170908315268, 0.573536186043207,
			2.446537728407662, 1.356650638090824, 1.226433117844753,
			0.498837787350163, 1.307946180753392, 0.513720958104054,
			-2.648756332238713, 1.716271136365077, -0.546157302197066,
			0.074222506378473, 1.082942620479702, -0.644034774836921,
			-0.441571568785331, -0.663176254443579, 1.666164899630204,
			-0.752917822433612, 0.527043200473806, 0.765887998890228,
			0.159929086310814, 2.497711874217662, 0.224980416279120,
			2.155787161703794, -6.850328794539927, 0.385445419120752,
			-0.101128860722225, -1.137483624159616, 2.275619804342468,
			0.024592735943551, -0.817618255632529, 1.103718312893461,
			-0.505412031300244, 0.178731525492850, -0.117437291357689,
			-0.068206032663805, 1.503483271344356, 0.945865271197626,
			-0.573303041893962, -0.226025869241382, 0.963117184088992,
			-0.494619340138030, -0.001687607424900, 0.383761206526219,
			-0.078601241152418, 0.376236183063560, -0.760710752524973,
			0.845108688804876, 1.032327622253915, -0.672906740339042,
			-0.005407941950508, -1.317931675315283, -1.132404703164774,
			0.520387088596095, -0.495281757667891, -0.718522134569770,
			0.398694907849837, 0.789926043698974, 0.064822847323364,
			-0.440405639124058, -0.809947489480077, -0.174652931980940,
			0.543875781504132, 0.798264094762572, 0.784257979054332,
			-0.461553604646746, 0.230645627701409, -0.549391879697582,
			-0.730315943304579, 0.609110223158244, 0.278090378463438,
			-0.864525352047885, 0.562386950860105, -0.161320073072324,
			0.024254542242752, -0.163350663295589, -0.460203152494668,
			-0.820203577361192, -0.782394639853777, 0.084374350005982,
			0.817436245302620, 0.772614169682839, -0.995072971530781,
			-0.183124120987911, -0.523465999646181, -0.296150937925509,
			0.150520925877316, -0.289568517886230, -0.543746960834053,
			0.022710407191036, 0.531002309938058, -0.753160926870491,
			-0.075631215525822, -0.749266859421199, 0.006376405422881,
			0.392652277190096, -0.095493488658649, 0.625276408651898,
			-0.621389789729689, 0.309434183749495, 0.807985557629410,
			-0.017366301180718, -0.838175074641231, -0.529087914093083,
			-0.918443217668012, -0.149247449065828, 0.785145200319040,
			-0.451826609680408, 0.347013539680632, 0.684299621891527,
			0.796931682931498, -0.872862535713068, 0.514560559212517,
			-0.043707393875865, 0.718738177195636, -1.052968583895554,
			0.084874058163955, -0.173404837111304, -0.573046300593731,
			0.303110534537917, -0.946797143319613, 0.800518322543832,
			-0.058152503938961, 0.984200532666480, -0.452633462491086,
			0.362972529576867, 0.403329844521736, -1.320728048102841,
			-0.789005172916564, -0.598619323106995, -1.044847677767754,
			0.511898917648059, 0.852177242164491, -0.704766608004324,
			-0.527655578938286, 0.999735169748612, 1.101364172737961,
			-0.820031904502290, 0.413725565732218, 0.037787939015719,
			-2.782524019253992, 0.015405418842097, -0.762336558885446,
			-0.078380875732953, -0.148477460289451, -1.536641841046398,
			0.774874050040116, 0.824813157697289, 0.886468790296358,
			-0.467450091061881, 0.738154501611513, 0.726433105120959,
			1.326044809059620, -0.539015384728639, -0.283360013861378,
			0.480002209261994, -1.670225551383048, -0.476848205686782,
			0.083310691215359, -1.241629057985363, -0.323869791838248,
			-0.397711935831262, 0.815681619885754, 0.161977688888011,
			-0.381962583154923, -0.067654219572283, 0.312190217330008,
			-0.005834693448600, -1.504863446328549, -1.815860735602051,
			0.580401894158663, 0.172511267361500, 0.308235230185219,
			-0.125025764151390, 0.367387583202750, 0.526024943398609,
			-0.116903897684488, -0.287049241717496, 0.460415157016629,
			-0.923722957441675, -0.283993393582011, -0.115265179564302,
			-0.090965020531176, 1.097969739448387, 1.326049713010919,
			-1.067442010686681, -0.668889996280881, -0.390288358925908,
			0.114251522739830, -0.817038318200943, 0.683453592649315,
			-0.025976798258034, 1.633186622326154, -0.212931102532312,
			-0.637005686945303, -0.391995069558800, -0.048039240953908,
			0.041285372911821, -0.458186662659489, -0.600439756958948,
			-0.589106680625988, -0.165509590056111, -0.958935271218431,
			0.404147727830148, 0.001606417149299, -0.981356949740138,
			-0.662600016900794, 1.055588528619963, -1.780342332183794,
			-2.477343675724835, 0.293859458840728, 1.103847580829737,
			0.307614006117330, -0.778592567317168, 2.614957669084153,
			0.391844156920546, 0.644043683124794, 1.406601154195050,
			-0.604722812708801, 0.481750522641602, -0.819141547714735,
			0.582869099263542, -1.011903020411674, -0.178954932253986,
			-0.632865982007718, -0.259139901420310, 2.015451487803170,
			-0.592752017265550, -0.034971291890495, -0.103018534130080,
			0.602591984448420, -0.149628245415130, 1.190494180553346,
			-0.363439792918162, -0.757383077531475, -0.180670808762167,
			0.347491062153253, -0.454080781899345, -0.827485308955183,
			0.593016116192830, -0.700752567538997, -0.545094408885460,
			-0.153829194008307, 0.466487348102622, -0.279119187824802,
			-1.402880054105577, -1.242819727452390, -0.088022376762424,
			-0.202763634246747, 0.121617840518311, -0.268628579156251,
			0.241485839550174, 0.770095349988042, 0.255691857052679,
			0.535273237087437, 0.816795321419170, 1.161247587538594,
			1.021958298625623, 0.532171693245992, 0.039257039330825,
			0.076958470950930, 0.566882913410895, -1.630147405112426,
			1.053530084469331, 2.047528134352276, 1.089416725811282,
			-4.106356701292905, -0.644651159596163, -0.521647028221024,
			0.172486822520312, -0.361566785347934, -1.445534511980694,
			0.294444932262318, -1.103517189632157, 0.410415589542993,
			0.316600106781761, 1.918980018502583, 1.430304502783629,
			0.327381577310535, -0.266183235754854, 0.263212682245452,
			-0.889542637350158, 0.842699092641690, 0.745969550652609,
			-0.464468324643577, 0.567561731442629, -2.571074891101530,
			-2.344040950920907, 0.646312031855413, 0.226522738950190,
			0.856175993408158, -0.265760872513790, -0.240810170186674,
			-1.280047327623668, -0.390478714431975, -1.838624319731249,
			1.124252323775106, -0.612335314804825, -0.710796033056908,
			0.353388327155097, 0.539047329591057, -0.708986642113373,
			-0.270480467793290, 0.001145244168623, 0.231642827564659,
			0.528126617289944, 0.049785624983009, 0.475461137679902,
			0.466877600191660, -0.050483092750805, -0.341313345340451,
			-1.028028105584682, -0.175283340352119, 1.414471172628335,
			0.119168984212685, -0.451200146477133, 0.252691899678424,
			0.596027141327853, 0.764493947892668, 0.450779198749572,
			0.871045903676973, -0.001815135312594, 1.014233794014322,
			0.046294579614304, -0.179215913813932, 2.334889906860607,
			-1.137803097786908, -0.530133480252262, -0.112704960467900,
			-1.466949095401463, 0.489143204103102, 0.290738539264872,
			-2.859610818096788, -1.904219585663408, -1.288878488961910,
			0.290107095257995, 0.551880073947633, -2.367155964628723,
			-2.160520693459902, 0.399337374008383, -0.596184438471647,
			0.343498948858576, 0.848703102609868, -0.605848627259555,
			-0.960646523980808, -0.182998466109359, 1.561806344925713,
			-0.668587862523519, -0.443622834263491, 0.141688766683642,
			-1.605254580064335, 1.330634418693720, -0.287872095178929,
			0.238361744004779, -1.852762810081582, -1.008260260206106,
			-0.686354299436272, -0.429367956341219, -0.972574241036252,
			0.520180247289823, 1.352649319726927, 0.145165215357231,
			0.481261341470903, 0.098509279288441, 1.813333463339827,
			-0.203888124361353, 0.136648667698632, -0.513987158514536,
			-0.442873063686841, 0.429065587042445, 0.327744544168198,
			0.856877578914662, 0.334614049899671, -0.913012460481535,
			-1.237401083205328, 0.762300218372108, 0.834624775539312,
			-5.342837836941789, 0.946131329872751, 0.323218790232083,
			2.114743868626859, -0.832712067510625, -0.153357512209641,
			0.834184245251765, -0.372153819105157, 1.013284303637620,
			0.444429323934908, 0.111840843233641, 0.002722236157582,
			-0.456760259471501, 0.669212799548504, 0.396347013852992,
			0.520641119612739, -0.523350827380325, 0.282712367141789,
			-1.169163771819730, 0.896529451968533, -0.586724119024176,
			0.345461372452598, 1.325077219060498, 0.061161783540761,
			-0.358067311200368, 0.466780994843558, 1.309421202844189,
			1.063284425593185, 0.240263031328503, 0.945733132379417,
			-1.145536719584967, -1.824886518651465, 0.506507438861925,
			-0.534569787748030, 1.081645108887743, -0.022410501261664,
			-0.524547164782997, 1.677722515635488, -0.209451094038234,
			0.868202681561874, -0.538506508247907, -1.353553502613019,
			1.429418386586124, -0.842969845452379, 0.631959513365174,
			1.550851694111208, 0.331985332730413, -1.066393472641360,
			0.417647604300487, -0.000128088945781, -0.463309818785609,
			-0.764503924516128, 0.421432642561300, 0.198531283971332,
			-1.342481339907029, 0.555806270590370, 0.423405520649501,
			0.362214520428441, 5.927274983867696, -0.562779406827459,
			-0.921314817030750, -0.190654286612003, -0.995163320699279,
			-1.510229776013100, 0.214696117485412, -1.179307319478796,
			-0.842948616177478, -1.892596406612586, 1.521077293883439,
			-0.714423226242005, 0.426567731499709, -0.835135696624617,
			-0.046314360862167, 0.743902071799437, -0.857951846407398,
			0.117991519769076, -1.166080768579573, 0.126321665441284,
			-0.450169700169357, -0.620687197392254, -0.451125825428831,
			-0.046321833845104, -0.732975365259026, -0.045895103561170,
			-0.370476713517798, 0.486958577737944, -0.329695520309285,
			0.624258205705334, 0.488139288181806, -1.109891681348179,
			0.236677028571186, -1.569426810494573, 1.829976597248682,
			0.522224759148015, -0.008714267037274 };

	private double[] hiddenLayer1outputs;
	private double[] hiddenLayer2outputs;
	private double[] hiddenLayer3outputs;
	private int c;

	/**
	 * Construtor de uma instância da classe Rna_propria_map. Aloca memória para
	 * as variáveis hiddenLayer1outputs, hiddenLayer2outputs e
	 * hiddenLayer3outputs.
	 */
	Map_ann() {

		// instanciação de variáveis.
		hiddenLayer1outputs = new double[32];
		hiddenLayer2outputs = new double[16];
		hiddenLayer3outputs = new double[8];
	}

	/**
	 * Este método retorna a variável (do tipo double) mainWeights[i], isto é, o
	 * valor real do peso de um nó da RNA, a partir do número inteiro fornecido,
	 * i.
	 * 
	 * @param i
	 *            número inteiro fornecido para escolha do peso do nó na RNA.
	 * 
	 * @return o valor real do peso de um nó da RNA, a partir do número inteiro
	 *         fornecido, i.
	 */
	public double get_pesos(int i) {
		return this.mainWeights[i];
	}

	/**
	 * Este método fixa a variável (do tipo double) saida, isto é, o valor real
	 * da saída da RNA.
	 * 
	 */
	public void setOutput() {

		// declaração e instanciação de variáveis.
		Double[] inputs = new Double[2];
		double outputs;
		int i = 0;

		// lógica de ajuste e cálculo matemático dos valores definitivos de
		// variáveis.
		// Além da fixação de valor.
		inputs[0] = getInput1();
		inputs[1] = getInput2();

		inputs[0] = -1.0 + (inputs[0] - 0.000000000000000)
				/ 140.000000000000000;
		inputs[1] = -1.0 + (inputs[1] - 0.000000000000000) / 0.500000000000000;
		hiddenLayer1outputs[0] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[0] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[0] = Math.tanh(hiddenLayer1outputs[0]);
		hiddenLayer1outputs[1] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[1] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[1] = Math.tanh(hiddenLayer1outputs[1]);
		hiddenLayer1outputs[2] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[2] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[2] = Math.tanh(hiddenLayer1outputs[2]);
		hiddenLayer1outputs[3] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[3] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[3] = Math.tanh(hiddenLayer1outputs[3]);
		hiddenLayer1outputs[4] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[4] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[4] = Math.tanh(hiddenLayer1outputs[4]);
		hiddenLayer1outputs[5] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[5] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[5] = Math.tanh(hiddenLayer1outputs[5]);
		hiddenLayer1outputs[6] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[6] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[6] = Math.tanh(hiddenLayer1outputs[6]);
		hiddenLayer1outputs[7] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[7] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[7] = Math.tanh(hiddenLayer1outputs[7]);
		hiddenLayer1outputs[8] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[8] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[8] = Math.tanh(hiddenLayer1outputs[8]);
		hiddenLayer1outputs[9] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[9] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[9] = Math.tanh(hiddenLayer1outputs[9]);
		hiddenLayer1outputs[10] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[10] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[10] = Math.tanh(hiddenLayer1outputs[10]);
		hiddenLayer1outputs[11] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[11] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[11] = Math.tanh(hiddenLayer1outputs[11]);
		hiddenLayer1outputs[12] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[12] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[12] = Math.tanh(hiddenLayer1outputs[12]);
		hiddenLayer1outputs[13] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[13] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[13] = Math.tanh(hiddenLayer1outputs[13]);
		hiddenLayer1outputs[14] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[14] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[14] = Math.tanh(hiddenLayer1outputs[14]);
		hiddenLayer1outputs[15] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[15] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[15] = Math.tanh(hiddenLayer1outputs[15]);
		hiddenLayer1outputs[16] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[16] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[16] = Math.tanh(hiddenLayer1outputs[16]);
		hiddenLayer1outputs[17] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[17] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[17] = Math.tanh(hiddenLayer1outputs[17]);
		hiddenLayer1outputs[18] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[18] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[18] = Math.tanh(hiddenLayer1outputs[18]);
		hiddenLayer1outputs[19] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[19] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[19] = Math.tanh(hiddenLayer1outputs[19]);
		hiddenLayer1outputs[20] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[20] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[20] = Math.tanh(hiddenLayer1outputs[20]);
		hiddenLayer1outputs[21] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[21] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[21] = Math.tanh(hiddenLayer1outputs[21]);
		hiddenLayer1outputs[22] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[22] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[22] = Math.tanh(hiddenLayer1outputs[22]);
		hiddenLayer1outputs[23] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[23] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[23] = Math.tanh(hiddenLayer1outputs[23]);
		hiddenLayer1outputs[24] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[24] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[24] = Math.tanh(hiddenLayer1outputs[24]);
		hiddenLayer1outputs[25] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[25] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[25] = Math.tanh(hiddenLayer1outputs[25]);
		hiddenLayer1outputs[26] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[26] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[26] = Math.tanh(hiddenLayer1outputs[26]);
		hiddenLayer1outputs[27] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[27] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[27] = Math.tanh(hiddenLayer1outputs[27]);
		hiddenLayer1outputs[28] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[28] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[28] = Math.tanh(hiddenLayer1outputs[28]);
		hiddenLayer1outputs[29] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[29] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[29] = Math.tanh(hiddenLayer1outputs[29]);
		hiddenLayer1outputs[30] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[30] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[30] = Math.tanh(hiddenLayer1outputs[30]);
		hiddenLayer1outputs[31] = this.get_pesos(i++);
		for (c = 0; c < 2; c++)
			hiddenLayer1outputs[31] += this.get_pesos(i++) * inputs[c];
		hiddenLayer1outputs[31] = Math.tanh(hiddenLayer1outputs[31]);
		hiddenLayer2outputs[0] = this.get_pesos(i++);
		for (c = 0; c < 32; c++)
			hiddenLayer2outputs[0] += this.get_pesos(i++)
					* hiddenLayer1outputs[c];
		hiddenLayer2outputs[0] = Math.tanh(hiddenLayer2outputs[0]);
		hiddenLayer2outputs[1] = this.get_pesos(i++);
		for (c = 0; c < 32; c++)
			hiddenLayer2outputs[1] += this.get_pesos(i++)
					* hiddenLayer1outputs[c];
		hiddenLayer2outputs[1] = Math.tanh(hiddenLayer2outputs[1]);
		hiddenLayer2outputs[2] = this.get_pesos(i++);
		for (c = 0; c < 32; c++)
			hiddenLayer2outputs[2] += this.get_pesos(i++)
					* hiddenLayer1outputs[c];
		hiddenLayer2outputs[2] = Math.tanh(hiddenLayer2outputs[2]);
		hiddenLayer2outputs[3] = this.get_pesos(i++);
		for (c = 0; c < 32; c++)
			hiddenLayer2outputs[3] += this.get_pesos(i++)
					* hiddenLayer1outputs[c];
		hiddenLayer2outputs[3] = Math.tanh(hiddenLayer2outputs[3]);
		hiddenLayer2outputs[4] = this.get_pesos(i++);
		for (c = 0; c < 32; c++)
			hiddenLayer2outputs[4] += this.get_pesos(i++)
					* hiddenLayer1outputs[c];
		hiddenLayer2outputs[4] = Math.tanh(hiddenLayer2outputs[4]);
		hiddenLayer2outputs[5] = this.get_pesos(i++);
		for (c = 0; c < 32; c++)
			hiddenLayer2outputs[5] += this.get_pesos(i++)
					* hiddenLayer1outputs[c];
		hiddenLayer2outputs[5] = Math.tanh(hiddenLayer2outputs[5]);
		hiddenLayer2outputs[6] = this.get_pesos(i++);
		for (c = 0; c < 32; c++)
			hiddenLayer2outputs[6] += this.get_pesos(i++)
					* hiddenLayer1outputs[c];
		hiddenLayer2outputs[6] = Math.tanh(hiddenLayer2outputs[6]);
		hiddenLayer2outputs[7] = this.get_pesos(i++);
		for (c = 0; c < 32; c++)
			hiddenLayer2outputs[7] += this.get_pesos(i++)
					* hiddenLayer1outputs[c];
		hiddenLayer2outputs[7] = Math.tanh(hiddenLayer2outputs[7]);
		hiddenLayer2outputs[8] = this.get_pesos(i++);
		for (c = 0; c < 32; c++)
			hiddenLayer2outputs[8] += this.get_pesos(i++)
					* hiddenLayer1outputs[c];
		hiddenLayer2outputs[8] = Math.tanh(hiddenLayer2outputs[8]);
		hiddenLayer2outputs[9] = this.get_pesos(i++);
		for (c = 0; c < 32; c++)
			hiddenLayer2outputs[9] += this.get_pesos(i++)
					* hiddenLayer1outputs[c];
		hiddenLayer2outputs[9] = Math.tanh(hiddenLayer2outputs[9]);
		hiddenLayer2outputs[10] = this.get_pesos(i++);
		for (c = 0; c < 32; c++)
			hiddenLayer2outputs[10] += this.get_pesos(i++)
					* hiddenLayer1outputs[c];
		hiddenLayer2outputs[10] = Math.tanh(hiddenLayer2outputs[10]);
		hiddenLayer2outputs[11] = this.get_pesos(i++);
		for (c = 0; c < 32; c++)
			hiddenLayer2outputs[11] += this.get_pesos(i++)
					* hiddenLayer1outputs[c];
		hiddenLayer2outputs[11] = Math.tanh(hiddenLayer2outputs[11]);
		hiddenLayer2outputs[12] = this.get_pesos(i++);
		for (c = 0; c < 32; c++)
			hiddenLayer2outputs[12] += this.get_pesos(i++)
					* hiddenLayer1outputs[c];
		hiddenLayer2outputs[12] = Math.tanh(hiddenLayer2outputs[12]);
		hiddenLayer2outputs[13] = this.get_pesos(i++);
		for (c = 0; c < 32; c++)
			hiddenLayer2outputs[13] += this.get_pesos(i++)
					* hiddenLayer1outputs[c];
		hiddenLayer2outputs[13] = Math.tanh(hiddenLayer2outputs[13]);
		hiddenLayer2outputs[14] = this.get_pesos(i++);
		for (c = 0; c < 32; c++)
			hiddenLayer2outputs[14] += this.get_pesos(i++)
					* hiddenLayer1outputs[c];
		hiddenLayer2outputs[14] = Math.tanh(hiddenLayer2outputs[14]);
		hiddenLayer2outputs[15] = this.get_pesos(i++);
		for (c = 0; c < 32; c++)
			hiddenLayer2outputs[15] += this.get_pesos(i++)
					* hiddenLayer1outputs[c];
		hiddenLayer2outputs[15] = Math.tanh(hiddenLayer2outputs[15]);
		hiddenLayer3outputs[0] = this.get_pesos(i++);
		for (c = 0; c < 16; c++)
			hiddenLayer3outputs[0] += this.get_pesos(i++)
					* hiddenLayer2outputs[c];
		hiddenLayer3outputs[0] = Math.tanh(hiddenLayer3outputs[0]);
		hiddenLayer3outputs[1] = this.get_pesos(i++);
		for (c = 0; c < 16; c++)
			hiddenLayer3outputs[1] += this.get_pesos(i++)
					* hiddenLayer2outputs[c];
		hiddenLayer3outputs[1] = Math.tanh(hiddenLayer3outputs[1]);
		hiddenLayer3outputs[2] = this.get_pesos(i++);
		for (c = 0; c < 16; c++)
			hiddenLayer3outputs[2] += this.get_pesos(i++)
					* hiddenLayer2outputs[c];
		hiddenLayer3outputs[2] = Math.tanh(hiddenLayer3outputs[2]);
		hiddenLayer3outputs[3] = this.get_pesos(i++);
		for (c = 0; c < 16; c++)
			hiddenLayer3outputs[3] += this.get_pesos(i++)
					* hiddenLayer2outputs[c];
		hiddenLayer3outputs[3] = Math.tanh(hiddenLayer3outputs[3]);
		hiddenLayer3outputs[4] = this.get_pesos(i++);
		for (c = 0; c < 16; c++)
			hiddenLayer3outputs[4] += this.get_pesos(i++)
					* hiddenLayer2outputs[c];
		hiddenLayer3outputs[4] = Math.tanh(hiddenLayer3outputs[4]);
		hiddenLayer3outputs[5] = this.get_pesos(i++);
		for (c = 0; c < 16; c++)
			hiddenLayer3outputs[5] += this.get_pesos(i++)
					* hiddenLayer2outputs[c];
		hiddenLayer3outputs[5] = Math.tanh(hiddenLayer3outputs[5]);
		hiddenLayer3outputs[6] = this.get_pesos(i++);
		for (c = 0; c < 16; c++)
			hiddenLayer3outputs[6] += this.get_pesos(i++)
					* hiddenLayer2outputs[c];
		hiddenLayer3outputs[6] = Math.tanh(hiddenLayer3outputs[6]);
		hiddenLayer3outputs[7] = this.get_pesos(i++);
		for (c = 0; c < 16; c++)
			hiddenLayer3outputs[7] += this.get_pesos(i++)
					* hiddenLayer2outputs[c];
		hiddenLayer3outputs[7] = Math.tanh(hiddenLayer3outputs[7]);
		outputs = this.get_pesos(i++);
		for (c = 0; c < 8; c++)
			outputs += this.get_pesos(i++) * hiddenLayer3outputs[c];
		outputs = Math.tanh(outputs);
		outputs = 87.579999999999998 + (outputs - -1.000000) * 3.704999999999998;
		setOutput(outputs);
	}

}
