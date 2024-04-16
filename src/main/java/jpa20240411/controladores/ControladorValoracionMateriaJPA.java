package jpa20240411.controladores;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpa20240411.model.ValoracionMateria;

public class ControladorValoracionMateriaJPA extends SuperControladorJPA{
	
	private static ControladorValoracionMateriaJPA instance = null;
	
	public ControladorValoracionMateriaJPA() {
		super("valoracionmateria",ValoracionMateria.class);
	}
	
	public static ControladorValoracionMateriaJPA getInstance() {
		if(instance == null) {
			instance = new ControladorValoracionMateriaJPA();
		}
		return instance;
	}
	
	

}
