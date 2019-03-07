package mx.edu.ulsaoaxaca.lae.model;

import java.util.Date;

public class Persona {
	
	private Integer id;
	private String nombres;
	private String apellidos;
	private Date fechaNacimiento;
	
	public Persona() {
		
	}
	
	public Persona(Integer id, String nombres, String apellidos, Date fechaNacimiento) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	public Persona(String nombres, String apellidos, Date fechaNacimiento) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}
