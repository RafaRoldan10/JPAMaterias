package jpa20240411.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor extends Entidad{
	
	@Id
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private String direccion;
	private String telefono;
	private String colorPreferido;
	private byte[] imagen;
	private int idTipologiaSexo;
	
	
	
	
	public Profesor() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getColorPreferido() {
		return colorPreferido;
	}
	public void setColorPreferido(String colorPreferido) {
		this.colorPreferido = colorPreferido;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	public int getIdTipologiaSexo() {
		return idTipologiaSexo;
	}
	public void setIdTipologiaSexo(int idTipologiaSexo) {
		this.idTipologiaSexo = idTipologiaSexo;
	}
	@Override
	public String toString() {
		return nombre + apellido1 + apellido2;
	}
	
	
	

}
