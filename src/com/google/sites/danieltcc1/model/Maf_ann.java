package com.google.sites.danieltcc1.model;

/**
 * Classe que define o modelo feito com RNA para fornecer o fluxo da massa do ar
 * admitido. Esta classe recebe como entrada dois números reais, que são a
 * frequência de rotação do motor universal (0-280Hz) e o fator de abertura do
 * módulo "válvula borboleta" (0-1) e fornece como saída o fluxo da massa do ar
 * admitido (kg/h).
 * 
 * @author Daniel S. F. Bruno
 * @version 1.0.1
 * @since versão 1.0b1
 */
class Maf_ann extends Model {

	// declaração e instanciação de variáveis.
	private double[] mainWeights = { 1.059302583928928, -1.031676261948852,
			0.395812784805125, 0.239775596184328, 0.004839211003419,
			1.104715908991202, 0.430108122774923, -0.460419041514937,
			0.602225837586060, -0.396444903605381, 1.801283370089761,
			-2.653809080053221, 0.300219733410253, 3.937435825241951,
			-0.071388663439308, -1.067506691270278, 0.728974314577865,
			-0.475488169016954, -0.200823653403286, -0.971344619248555,
			0.833946855374724, -0.402708291798720, -0.355769321505691,
			-0.910069141848696, -1.019754784283316, -0.153872494912995,
			-0.892348138295594, 0.253824518347331, 0.929644921534435,
			1.111983544295503, -1.051167660815658, 1.049609649705564,
			-0.456265565930271, 0.638618822848503, 0.619140680475482,
			0.599764576930801, -0.695717524623480, 0.636854982186748,
			1.040225990260036, 0.712143101928246, 0.405829125227577,
			-1.451311277209734, 0.143975917586098, 0.773476842665648,
			1.378443751317436, 0.192695329824382, -0.480805226964891,
			0.246138601707689, -0.187410037580921, -0.553432433638888,
			-0.346026445291565, 0.835850615425365, -1.459358979715842,
			-0.590724922466404, 0.113789963980192, 0.602815330885088,
			-0.470096417537632, -1.102521341865546, 0.707813626921805,
			-0.136289313812365, -0.172234332571777, 0.624507138637914,
			1.306970718404805, -1.352881199633006, -1.024229323955100,
			0.683927562993918, -0.050227904896818, -0.346511327814431,
			0.427151590469881, -0.174654611090667, -0.219931446838769,
			0.341443234336440, -1.070360025003049, -0.333230752973024,
			-0.265494447870206, -1.112736518777409, 0.544742972593398,
			0.291099451145138, -0.871181118016540, -0.039741472974040,
			0.007662893189863, 0.959341655954570, -0.254672920559559,
			0.183525960957181, -0.230146206196646, -0.860931014019556,
			-0.916760896475351, -0.627140515337929, -0.864642434454756,
			-0.584072417048668, 0.195546099797564, 0.429840355599996,
			-0.040645391714900, 0.512877313418195, 0.949707864698218,
			-0.055177437623769, 0.253933692205450, -0.107077616273422,
			0.033263802172805, 0.804605144546433, -0.231871095747188,
			0.849020294214221, -0.748176760483167, -0.728344493582431,
			-0.947615379442533, 0.957664929005242, -0.061168328809575,
			0.239291055357548, 0.333569441168919, 0.325131908491516,
			0.944338527554517, -0.320362701949383, -0.317302492927237,
			-0.017526810827815, -0.743675766151851, 0.480639977458909,
			0.633686778721520, -1.070004620871224, 0.031278891978044,
			-0.894892289396268, 0.521976099369378, -0.084913445542224,
			0.952292892160478, 0.460007463846400, -0.581929384311522,
			0.785337968920548, 0.248834744262429, -0.141552575360044,
			0.365055590182733, -0.667158860566867, -0.971156722301379,
			-0.705074521396992, -0.171204190956188, 0.210323956438794,
			0.128228960442601, -0.353858895248691, -0.895815840271847,
			0.397428765011087, -0.477852126671292, -0.825701602793726,
			-0.866238998257607, -0.227128196663486, -0.235270937389844,
			0.432602807816674, -0.896835895996897, 0.914436831102627,
			0.120734810566179, 0.787055321909706, 0.406982034613258,
			0.757857433303854, -1.551793916702398, 0.267912384833685,
			-0.255799767772775, -0.500405885141854, -0.913007331745361,
			-0.727151486084860, 0.328367622556616, 0.812083371629866,
			0.662765910851379, 0.841121814398046, -0.425053845171894,
			0.199338664147930, 0.862019118696310, -0.276248785886377,
			0.182125058501700, 0.698716241078025, 0.153650830835922,
			-0.864725674686823, -0.898177629411238, 0.311871398005092,
			-0.930918119868733, -0.856437853844855, 1.039153563028984,
			-0.962676066969537, 0.270812677676665, 0.656556224503675,
			-0.675872136281898, 0.949307743589580, -0.083908536442062,
			-0.507958112976573, 0.302744481710500, 0.704833208596892,
			-0.491966885197362, -0.358208513293747, -0.741420421754484,
			-0.010968917861535, 0.376298767094964, 0.262745684573922,
			0.043398572344695, -1.024304882660683, -0.857926743658469,
			0.352199814913075, 0.125303202426563, 0.131090941947989,
			-0.361833096213604, -0.725188293215975, -0.367983293732978,
			-0.193434682024937, -0.377875566612813, -0.022873922821361,
			-0.285566788456954, 0.880062200612663, 0.076808756239500,
			1.368485631999271, 0.688413483408529, 0.002454668053144,
			0.897769155588803, -0.507291888510926, -0.638101036341553,
			-0.023911966151721, -0.821771036627305, 0.336867659943178,
			0.207839813586039, -0.741466339055719, -0.331652543579921,
			-0.742685001813783, -0.915188666399123, -0.794341719558912,
			-0.819403657537186, -0.626214067741924, 0.618059223411574,
			-0.285271841704183, 0.038384970548741, -0.074571971423146,
			1.014289459867497, -0.603443945166819, -0.186804842184023,
			-0.313451929029272, -0.588990307001039, 0.089962845469899,
			-0.128153074807194, -0.442275992233457, -0.898618360712374,
			0.530519202499654, 0.779048860344499, 0.492496382315031,
			-0.663728749249930, 0.847855364887736, -0.755171351338891,
			0.611848816350547, -0.174757594117645, -0.220266091277062,
			-0.612870072879666, 0.523002848803500, -0.913731711200636,
			0.780363588557048, -0.534831269895503, -0.914481606141583,
			0.797660438060902, 0.116298526639848, -0.628937145415718,
			-0.152983264585902, -0.192634830556425, 0.800537785031941,
			0.802884177200839, -0.289282549773223, -0.741684505223549,
			-0.329452038737484, 0.794217862808080, 0.441253120960568,
			-0.719123138954718, -0.456611393538888, -0.836621219414065,
			-0.383721068908815, -0.169142818710729, 1.518121110828413,
			0.045626053557855, 1.014169487529050, -0.927909900536569,
			0.968585106581909, 0.822732146263696, 1.033655962411495,
			1.860940402016115, 0.219211111552076, 0.836203592224710,
			0.440683362021117, 0.693991655632190, -0.292948429215749,
			0.096435789410678, -1.920007046774280, 0.477395105161667,
			-0.060617436017226, 1.390847949094104, -0.588063023186418,
			0.595232100612132, -0.691198266888881, 0.295018144473382,
			0.543280842248656, -0.844170345634241, -0.100002997070850,
			-0.386114604735328, -0.323826304403773, 0.001310254753361,
			-0.430184304263624, -0.650069179033241, 0.781716297261611,
			0.263643414564421, -0.798101704260346, -0.500305205895536,
			-0.249712452352554, 0.619720800408185, 0.291154263025643,
			1.218577351900163, 0.161549702011517, -1.716817814824072,
			-0.650302118095395, -1.725870059121601, 1.523708843041305,
			-1.355643200879686, -0.584445202171885, 0.108465744567467,
			0.469732845813156, -0.096078785156666, -0.508674427006337,
			-0.199586552796540, 0.692468471913339, 3.778239266333205,
			0.414949276031360, 0.684361274175539, 0.927415311645337,
			0.303398821575014, 0.341613455059078, 0.570682534145003,
			1.262973874949851, 3.039307094043251, -1.188927471823726,
			-1.708637902934339, 0.949575672058321, -0.150946689475754,
			0.204699885973833, 0.693797716357804, 0.587741482533483,
			0.243739219181458, -0.166211008949650, -0.311993653861984,
			0.221462237706983, 0.470784260714861, 0.762330938184973,
			0.049575944023859, 0.660083614763169, 0.705296090790922,
			0.006021309533927, -0.799134112255795, -0.269319243893839,
			0.279233875243027, 0.218000756479283, -0.579083479165425,
			-0.253593884066822, -1.006790790396971, -0.393635402683675,
			0.774707166335646, -1.139533182524383, -0.008509695099962,
			0.627458051471390, -0.150929721999163, -0.369925896293809,
			-0.323565075928079, -0.714287110680965, 0.060451123177472,
			-0.370973005224222, 0.421512703700503, 0.570426753971045,
			-0.010991662904797, 1.078279141217035, -0.968034234862354,
			0.644989772418839, 0.161900403223731, 0.465759891217257,
			-0.531186149080667, 0.172986541027036, 0.300150780371141,
			0.750076456478872, -0.944471255443000, 0.413967471723466,
			-1.912700808979280, -0.854643045603071, 0.221629075972895,
			0.419341974718059, -0.146945894603550, -0.532315906512447,
			0.836902198707287, -0.618816757110369, 0.619066736926596,
			-0.153032328111871, 0.133112667628189, 0.554799593522585,
			0.921691019991296, -0.487547472367550, 0.762342764643077,
			-0.401942591092305, 0.246489272378448, -0.980796355674097,
			-0.266145855715123, -0.555384627653300, 0.697889474154553,
			-0.065711049912029, -0.067503254458785, 0.114653625728040,
			-1.424563615643675, 0.624588383215120, 0.092582168015786,
			-0.650399716268981, -0.446737262490602, 0.634627551717939,
			0.669467327212692, 0.444701285138137, 1.336743879147834,
			-0.111506548813103, -0.817252080851355, 0.323988425817217,
			0.553116154645999, -0.671993070835157, 0.237748476306299,
			0.558333015143766, 0.552971220427809, 2.718365352377091,
			-0.064605976044780, 0.514789991885231, 0.903560902212567,
			0.273865800494498, -0.389483246358137, -0.676637608492007,
			-0.872587037335333, 1.154362722385780, -0.089518854013822,
			-1.292697052912526, 0.808968069617652, 0.860949946498242,
			-0.454598295531197, -0.028436252693853, -0.426923116028946,
			-0.408536001337562, 0.057434937493126, -0.547746896110522,
			-1.424397314597208, -0.679552259740454, 0.725050076851086,
			-0.443349814764965, 1.071341324086495, 0.264358768048929,
			-0.390824383995783, 0.762023087438940, -0.423140293960348,
			-0.599209598100067, 0.533938321437459, 0.928455863195687,
			-0.486630445141060, 0.576625334975408, 0.784901873779267,
			-0.223174425731988, 0.384067961859516, -0.216370495358011,
			0.216917088253477, -0.835657572885682, 0.277400224753563,
			-0.454758718999377, -0.929820532836133, 0.873393512881863,
			0.001215346124450, -0.268207218095037, -0.498328830377782,
			0.362244513644841, -0.389225082475391, -0.846033107136165,
			-0.190249955138026, -0.006051906925384, -0.433626732126254,
			0.232453095571711, 1.124569942129111, 0.328253903446863,
			0.313840660555877, 0.571562767034550, 0.819175561363769,
			-0.280570280881702, 0.442906430881614, 0.639090468387305,
			0.237508239074997, -0.534117528327341, -0.122811377812626,
			0.492345504603293, 0.909164113782946, 0.077995791837458,
			-0.042581623136529, 0.241750889608197, 1.216618893889171,
			-0.076578039691998, 0.887999105258147, -0.465525828877898,
			-0.493793881020460, -0.428381360262242, 0.587205247489549,
			0.595175320526734, -0.276798728580972, 0.479704734769571,
			0.519691007813632, 0.931048772156057, -0.446858206605966,
			-0.030596904834533, 0.085388674227255, -0.941498771726501,
			-0.459172608714601, -0.880929491470993, -0.797209656822552,
			-0.800228884767939, 0.773694744664662, -0.224091767029873,
			0.430077049217442, 0.659722639874633, 0.298178527878395,
			0.441398816712434, 0.206317380826077, -0.851175442423087,
			0.236228038469099, 0.427241239328088, 0.020375545793223,
			1.009483955709968, 0.475973641862178, -0.680283790015053,
			0.563118306845225, 0.310390575297436, 0.444650325439555,
			-0.693387597965597, -0.386272628118136, 0.947486660278743,
			0.137286746661425, -0.414751907330967, 0.185433691993638,
			0.109800966770518, 0.466962996632777, 0.090931237654796,
			0.652508263782926, 0.821904002439434, -0.841098939231006,
			-0.320881815985722, 0.136735342665194, 0.137520446841846,
			-0.090115721015290, -0.848435849165251, 0.754770421615962,
			-0.670527243414536, 0.231017698857298, -0.791547099391923,
			0.433894048252981, -0.496386300342943, -0.692651713809171,
			-0.536459308127955, -0.239383715189680, -0.634753181910675,
			0.362906396539769, 0.028165105038744, -0.806929874446306,
			-0.112458722803640, 0.262383468080565, -0.662558656815658,
			-0.224015604569419, -0.335974158947284, -0.348249157135759,
			-0.729039792079641, 0.872497856794129, 0.937105835218403,
			0.591082232288635, -0.669549216485353, 0.481279269638327,
			-1.019507976966977, 0.601224265428738, 1.113076677211590,
			0.247865675613858, -0.444846490678795, -0.216425030607995,
			0.505264331083570, 0.184530183543359, -0.148232551776778,
			0.701548162727600, -1.021217109300945, -0.214790469728305,
			-0.718153685320289, 0.287665619079222, 0.366493410985936,
			0.417163939853597, -0.584551154360728, 0.247806868661686,
			0.531339475344193, -0.581922541483875, 0.330932312888687,
			-0.569896385267852, 0.498661077828752, 0.063433886234597,
			-0.123084474966894, -0.521421380946949, 0.937686386323703,
			0.233021962914469, 0.041543237245226, 0.425551783724420,
			0.674129106393306, -0.160165438614816, 0.714015570713304,
			0.467292327600877, -0.889572331348935, -0.987395625739771,
			-0.832802470181772, 0.052205624586044, -0.400392159827513,
			-0.643031570304092, 0.617596315416770, 0.401290624903449,
			0.025430742544610, -0.830968563352200, 0.402007489267999,
			-0.124187714195678, -0.657735252612419, -0.124650651569080,
			0.105618936277772, 0.424240341993641, -0.176222450387022,
			0.838919288909957, -0.122259752873915, -0.390317441749450,
			0.412391928306447, 0.674276561542907, 0.978777540650505,
			-0.052342551652069, -0.890158945341977, 1.238820281193288,
			1.169811738007909, -1.039610137762457, -0.706482060349457,
			0.792523422068412, 0.649436652504352, 0.606977543144089,
			-0.038074383275771, 0.220498327564280, 0.684134589242443,
			0.150211271332325, 0.629775454397984, 1.070046410496132,
			-0.331632061734861, 2.647970835013773, -0.366500700464364,
			1.985011434675662, -1.327512771454576, -0.323084772466105,
			-0.317307470024570, -0.239825439094508, 0.188041019276910,
			0.782255272214676, 0.618454788488125, -0.557462679711448,
			0.131529664945343, 0.850252812210616, 0.014765449702753,
			-2.062233385250985, 0.400969970828790, 0.449898664223620,
			-0.409897353250304, 0.800015856033438, 0.699449894419926,
			-1.206552093728271, -0.618658816028130, 0.374201587844979,
			0.053687516460200, 0.571721361417842, 0.349246798332299,
			0.417197619480856, 0.266735942365003, -0.470498095583752,
			0.645757365213778, 0.502198997274810, -0.332542902674546,
			-0.028942251442853, -0.878381869872790, -0.927785125642940,
			-0.193351777100898, -0.728433794028181, 1.172604407494236,
			-0.758546975440091, 0.610627036446644, -0.656019256240034,
			0.273285593666997, -1.022832917813174, -0.262143828768979,
			-0.931031720138470, 0.093216488357765, 2.312952925505905,
			-0.523581063742735, 0.815821075604922, 0.448775265780564,
			-0.242925616593737, -0.681955567890677, -1.903437443613410,
			0.486221631560367, 0.261584515433583, 0.095300499183790,
			0.287199185806549, 0.860229588982405, 0.896563381722438,
			0.587949238100620, -0.171051649764813, -0.371217174644308,
			-0.245626821639496, -0.861096670188282, -0.724070090740640,
			-0.147013435645375, -0.617394287506251, -0.508794981634481,
			0.088091625859512, -0.860785405775065, 0.916786756555744,
			0.649566952548547, 0.928131879568338, -0.716186532460685,
			0.841009176669280, 0.412791360651578, 1.262406762211857,
			0.520711091284175, 0.085562367984316, 0.979455475128224,
			-0.084088048362608, -0.782997147573353, -0.507713413118258,
			-0.870048224916672, -0.902059952602294, 0.877869554768532,
			-0.835801286330234, 0.606742608825017, 0.707152359320131,
			0.063175411640548, 0.381890439794785, 0.731550922060322,
			0.549513046952991, 0.435672952952932, -0.102062846754279,
			0.635735527558273, 0.603851890174544, 0.882909329440435,
			-0.525260766626898, -0.607982000028158, 0.041089936235069,
			-0.480279705343198, 0.503392297126544, 0.195375534421623,
			0.332292217816549, -1.219338298874708, 0.833921389616750,
			-0.732712206963934, 0.223930825452656, -0.346103458140202,
			0.906268374514850, -0.528548878914210, 0.889785594560691,
			0.364203909955896, -0.792677827970779, 0.446107193495801,
			-0.358580475997669, -0.515929149404666, 0.943128792687602,
			0.208112756647397, -0.858359872018735, 0.433401664369845,
			-0.905907838140528, 0.580751193771014, -0.581687979068000,
			0.370473579710304, 0.080417342058211, -0.252229566535943,
			-0.610000052493058, 0.585493682658560, -0.254031463571994,
			0.470865046505538, 0.596217699932512 };

	private double[] hiddenLayer1outputs;
	private double[] hiddenLayer2outputs;
	private double[] hiddenLayer3outputs;

	/**
	 * Construtor de uma instância da classe Rna_propria_maf. Aloca memória para
	 * as variáveis hiddenLayer1outputs, hiddenLayer2outputs e
	 * hiddenLayer3outputs.
	 */
	Maf_ann() {

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
		double[] inputs = new double[2];
		double outputs;
		int i = 0;
		int c;

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
		outputs = 0.000000000000000 + (outputs - -1.000000) * 59.100000000000001;
		setOutput(outputs);
	}

}
