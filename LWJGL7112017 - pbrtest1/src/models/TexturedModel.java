package models;

import textures.ModelTexture;

public class TexturedModel {
	
	private RawModel rawModel;
	private ModelTexture one;
	private ModelTexture two;
	private ModelTexture three;
	
	public TexturedModel(RawModel model, ModelTexture one){
		this.rawModel = model;
		this.one = one;

	}

	public RawModel getRawModel() {
		return rawModel;
	}

	public ModelTexture getTexture() {
		return one;
	}




}
