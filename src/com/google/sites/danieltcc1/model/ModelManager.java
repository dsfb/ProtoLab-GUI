package com.google.sites.danieltcc1.model;

public final class ModelManager {
	private Model mafModel = new DummyModel();
	private Model mapModel = new DummyModel();

	private int modelChoice;

	private int execution;

	public ModelManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void buildMafModel(int i) {
		// l�gica de constru��o dos objetos relacionados aos modelos projetados
		// para o fluxo de massa
		// do ar admitido.
		if (i == 0)
			mafModel = new AnnMafModel();
		else if (i == 1)
			mafModel = new SecondMafModel();
		else if (i == 2)
			mafModel = new ThirdMafModel();
		else if (i == 3)
			mafModel = new FourthMafModel();
		else if (i == 4)
			mafModel = new FifthMafModel();
	}

	public void build_model_map(int i) {
		// l�gica de constru��o dos objetos relacionados aos modelos projetados
		// para a press�o do ar
		// admitido.
		if (i == 0)
			mapModel = new AnnMapModel();
		else if (i == 1)
			mapModel = new SecondMapModel();
		else if (i == 2)
			mapModel = new ThirdMapModel();
		else if (i == 3)
			mapModel = new FourthMapModel();
		else if (i == 4)
			mapModel = new FifthMapModel();
	}

	public int getModelChoice() {
		return modelChoice;
	}

	public void setModelChoice(int modelChoice) {
		this.modelChoice = modelChoice;
	}

	public int getExecution() {
		return execution;
	}

	public void setExecution(int execution) {
		this.execution = execution;
	}

	public Model getModel_maf() {
		return mafModel;
	}

	public Model getModel_map() {
		return mapModel;
	}
}
