package mx.edu.ulsaoaxaca.lae.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import mx.edu.ulsaoaxaca.lae.model.Persona;

public interface PersonaMapper {
	
	@Select("select id, nombres, apellidos, fecha_nacimiento from persona")
	public List<Persona> listar();
	
	@Insert("")
	public void create(Persona persona);
}
