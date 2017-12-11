package shaders;

import org.lwjgl.util.vector.Matrix;
import org.lwjgl.util.vector.Matrix4f;

import org.lwjgl.util.vector.Vector3f;
import toolbox.Maths;

import entities.Camera;

public class StaticShader extends ShaderProgram{

	float MAX_LIGHTS = 4;

	private static final String VERTEX_FILE = "src/shaders/pbrtest.vert";
	private static final String FRAGMENT_FILE = "src/shaders/pbrtest.frag";

	//locations ex. private int location_transformationMatrix;

	private int location_transformationMatrix;
	private int location_projectionMatrix;
	private int location_viewMatrix;
	private int location_model;

	private int location_albedo;
	private int location_metallic;
	private int location_roughness;
	private int location_ao;

	private int location_lightPosition[];
	private int location_lightColour[];


	public StaticShader()
	{
		super(VERTEX_FILE, FRAGMENT_FILE);

	}

	@Override
	protected void bindAttributes() {
		//bind attributes ex super.bindAttribute(0, "position");

		//super.bindAttribute(0, "position");
		//super.bindAttribute(1, "textureCoordinates");

		super.bindAttribute(0, "aPos");
		super.bindAttribute(1, "aTexCoords");
		super.bindAttribute(2, "aNormal");

	}

	@Override
	protected void getAllUniformLocations() {
		// uniform locations ex. location_transformationMatrix = super.getUniformLocation("transformationMatrix");

		//location_transformationMatrix = super.getUniformLocation("model");
		location_model = super.getUniformLocation("model");
		location_projectionMatrix = super.getUniformLocation("projection");
		location_viewMatrix = super.getUniformLocation("view");


		location_albedo = super.getUniformLocation("albedo");
		location_metallic = super.getUniformLocation("metallic");
		location_roughness = super.getUniformLocation("roughness");
		location_ao = super.getUniformLocation("ao");
		for(int i=0;i<MAX_LIGHTS;i++) {
			location_lightPosition[i] = super.getUniformLocation("lightPositions[" + i + "]");
			location_lightColour[i] = super.getUniformLocation("lightColors[" + i + "]");
		}
	}

	public void loadPBR() {

		super.loadVector(location_albedo, new Vector3f(1,3,20));
		super.loadFloat(location_metallic, 0.3f);
		super.loadFloat(location_roughness, 0.4f);
		super.loadFloat(location_ao, 0.4f);

	}
	
	public void loadTransformationMatrix(Matrix4f matrix){
		// ex. super.loadMatrix(location_transformationMatrix, matrix);
		super.loadMatrix(location_model, matrix);

	}
	
	public void loadViewMatrix(Camera camera){
		// ex. 		Matrix4f viewMatrix = Maths.createViewMatrix(camera);
		// 			super.loadMatrix(location_viewMatrix, viewMatrix);
		Matrix4f viewMatrix = Maths.createViewMatrix(camera);
		super.loadMatrix(location_viewMatrix, viewMatrix);
	}
	
	public void loadProjectionMatrix(Matrix4f projection){
		// ex. super.loadMatrix(location_projectionMatrix, projection);
		super.loadMatrix(location_projectionMatrix, projection);
	}

}
