package mx.edu.ulsaoaxaca.lae;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mx.edu.ulsaoaxaca.lae.mapper.PersonaMapper;
import mx.edu.ulsaoaxaca.lae.model.Persona;

public class MainMyBatis {


	
	public static void main(String[] Args) {
		
		SqlSessionFactory sqlSessionFactory = null;
		
		try {
			String resource = "mx/edu/ulsaoaxaca/lae/db-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		SqlSession session = sqlSessionFactory.openSession();
		
		PersonaMapper personaMapper = session.getMapper(PersonaMapper.class);
		List<Persona> personas = personaMapper.listar();
		
		for(Persona persona: personas) {
			System.out.println(persona.getNombres());
		}
		
		session.close();
	}
}
