package mx.edu.ulsaoaxaca.lae.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mx.edu.ulsaoaxaca.lae.mapper.PersonaMapper;
import mx.edu.ulsaoaxaca.lae.model.Persona;

public class PersonaDAOBatis {

	public void create(Persona persona) {

		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		PersonaMapper mapper = session.getMapper(PersonaMapper.class);
		mapper.insertPersona(persona);
		session.commit();
		session.close();
	}

	public void delete(Integer id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		PersonaMapper mapper = session.getMapper(PersonaMapper.class);
		mapper.deletePersona(id);
		session.commit();
		session.close();
	}

	public List<Persona> getListaPersonas() {

		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		PersonaMapper mapper = session.getMapper(PersonaMapper.class);

		List<Persona> personas = mapper.listar();

		session.close();
		return personas;
	}

	public static void main(String[] Args) {
		PersonaDAOBatis personaDAO = new PersonaDAOBatis();

		Persona persona = new Persona();

		persona.setNombres("Karen Itzel " + new java.util.Date().getMinutes() + new java.util.Date().getSeconds());
		persona.setApellidos("Velasco Chincoya");
		persona.setFechaNacimiento(new java.util.Date());
		
		personaDAO.create(persona);
		
		personaDAO.delete(4);
		
		List<Persona> lista = personaDAO.getListaPersonas();
		System.out.println("Lista de personas");
		for(Persona p: lista) {
			System.out.println("\t"+p.getNombres()+" "+p.getApellidos());
		}
	}
}
