package mx.edu.ulsaoaxaca.lae.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.edu.ulsaoaxaca.lae.model.Persona;

public class PersonaDAO extends DAO{
	
	public void insertar(Persona p){
		Connection conn = getConnection();
		
		try {
			PreparedStatement pst = conn.prepareStatement("insert into persona(nombres, apellidos,fecha_nacimiento) values(?,?,?)");
			pst.setString(1, p.getNombres());
			pst.setString(2,  p.getApellidos());
			pst.setDate(3, new java.sql.Date(p.getFechaNacimiento().getTime()));
			pst.executeUpdate();
			
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		closeConnection();
	}
	
	public List<Persona> listar(){
		List<Persona> lista = new ArrayList<Persona>();
		Connection conn= getConnection();
		
		try {
			PreparedStatement pst = conn.prepareStatement("select id, nombres, apellidos, fecha_nacimiento from persona");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombres = rs.getString(2);
				String apellidos = rs.getString(3);
				Date fechaNacimiento = rs.getDate(4);
				Persona persona = new Persona(id, nombres, apellidos, fechaNacimiento);
				lista.add(persona);
			}
			rs.close();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		closeConnection();
		return lista;
	}
	
	public Integer obtenerUltimoInsertado() {
		Integer id = -1;
		
		Connection conn= getConnection();
		
		try {
			PreparedStatement pst = conn.prepareStatement("select max(id) from persona");
			ResultSet rs = pst.executeQuery();
			rs.next();
			id = rs.getInt(1);
			
			rs.close();
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		closeConnection();
		return id;
	}

}
