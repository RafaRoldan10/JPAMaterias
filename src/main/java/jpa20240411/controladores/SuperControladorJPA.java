package jpa20240411.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa20240411.model.Entidad;
import jpa20240411.model.Estudiante;
import jpa20240411.model.Materia;
import jpa20240411.model.Profesor;
import jpa20240411.model.ValoracionMateria;


public class SuperControladorJPA {

	private static EntityManager em = null;
	private String nombreTabla ="";
	private Class tipoEntidad;
	
	public SuperControladorJPA(String nombreTabla, Class tipoEntidad) {
		this.nombreTabla = nombreTabla;
		this.tipoEntidad = tipoEntidad;
	}
	
	protected EntityManager getEntityManager() {
		
		if(em == null) {
			em = Persistence.createEntityManagerFactory("centroeducativo").
					createEntityManager();
		}
		return em;
		
	}
	
	public void update (Entidad m) {
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
		System.out.println("Se ha actualizado");
		
	}
	
	public void insert(Entidad m) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		System.out.println("Se ha insertado");
		
	}
	
	@SuppressWarnings("unchecked")
	public List<? extends Entidad> findAll() {
		return (List<Entidad>) getEntityManager().
				createNativeQuery("SELECT * FROM " + this.nombreTabla, this.tipoEntidad)
				.getResultList();
	}
	
	public ValoracionMateria findByEstudianteAndProfesorAndMateria (Profesor profesor, Materia materia, Estudiante estudiante) {
		ValoracionMateria resultado = null;
		EntityManager em = getEntityManager();
		try {
			Query q = em.createNativeQuery("Select * from valoracionmateria where idProfesor = ? and "
					+ "idMateria = ? and idEstudiante = ?", ValoracionMateria.class);
			q.setParameter(1, profesor.getId());
			q.setParameter(2, materia.getId());
			q.setParameter(3, estudiante.getId());
			resultado = (ValoracionMateria) q.getSingleResult();
		}
		catch (Exception ex) {
		}
		
		return resultado;
	}
	
	
	
	
}
