package mx.edu.ulsaoaxaca.lae.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mx.edu.ulsaoaxaca.lae.model.Persona;

public interface PersonaMapper {
	
	@Results({
        @Result(property = "id", column = "id"),
        @Result(property = "nombres", column = "nombres"),
        @Result(property = "apellidos", column = "apellidos"),
        @Result(property = "fechaNacimiento", column = "fecha_nacimiento")
      })
	
	@Select("select id, nombres, apellidos, fecha_nacimiento from persona")
	public List<Persona> listar();
	
	@Insert("insert into persona(nombres, apellidos, fecha_nacimiento) values(#{nombres}, #{apellidos}, #{fechaNacimiento})")
	public void insertPersona(Persona persona);
	
	@Delete("DELETE FROM persona WHERE id =#{id}")
	public void deletePersona(int id);
	
	@Update("UPDATE persona set nombres=#{nombres}, apellidos=#{apellidos}, fecha_nacimiento=#{fechaNacimiento} where id=#{id}")
	public void updatePersona(Persona persona);
	
}
