package mx.edu.ulsaoaxaca.lae;

import java.util.List;

import mx.edu.ulsaoaxaca.lae.dao.PersonaDAO;
import mx.edu.ulsaoaxaca.lae.model.Persona;

public class Main {
	
	public static void main(String[] args) {
		
		
		PersonaDAO personaDAO = new PersonaDAO();
		
		Persona persona = new Persona();
		
		persona.setNombres("Karen Itzel "+ new java.util.Date().getMinutes() + new java.util.Date().getSeconds());
		persona.setApellidos("Velasco Chincoya");
		persona.setFechaNacimiento(new java.util.Date(119,8,16));
		
		personaDAO.insertar(persona);
		
		System.out.println("----------------------------");
		System.out.println(persona.getNombres());
		System.out.println("----------------------------");
		
		System.out.println(personaDAO.obtenerUltimoInsertado());
		System.out.println("----------------------------");
		
		List<Persona> personas = personaDAO.listar();
		
		for(Persona p: personas) {
			System.out.println(p.getId()+" "+p.getNombres()+" " + p.getApellidos());
		}
		
		
		System.out.println("Terminado");
	}
}
