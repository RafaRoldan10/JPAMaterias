package jpa20240411.controladores;

import jpa20240411.model.Profesor;

public class ControladorProfesorJPA extends SuperControladorJPA{
	
	private static ControladorProfesorJPA instance = null;
	
	public ControladorProfesorJPA() {
		super("profesor",Profesor.class);
	}
	
	public static ControladorProfesorJPA getInstance() {
		if(instance == null) {
			instance = new ControladorProfesorJPA();
		}
		return instance;
	}

}
