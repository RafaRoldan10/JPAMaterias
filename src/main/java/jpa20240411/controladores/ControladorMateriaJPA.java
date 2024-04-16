package jpa20240411.controladores;



import jpa20240411.model.Materia;




public class ControladorMateriaJPA extends SuperControladorJPA{
	
	private static ControladorMateriaJPA instance = null;
	
	public ControladorMateriaJPA() {
		super("materia",Materia.class);
	}
	
	
	/**
	 * 
	 */
	
	public static ControladorMateriaJPA getInstance() {
		if(instance == null) {
			instance = new ControladorMateriaJPA();
		}
		return instance;
	}

}
