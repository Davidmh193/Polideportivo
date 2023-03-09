package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Conector;
import modelo.bean.Usuario;

public class AccesoBBDD extends Conector{

	static Conector con = new Conector();
	static PreparedStatement ps;
	
/**********************************************************************************************************************************************/
	
	//Inserta Los usuarios
	
	public static void registrarUsuarios(Usuario usuario){
		
		try {
			con.conectar();
			ps = con.getCon().prepareStatement("INSERT INTO usuarios (id, nombre_apellido, dni, codigo) VALUES (?, ? , ?, ?)");
			ps.setInt(1, usuario.getId());
			ps.setString(2, usuario.getNombre_apellido());
			ps.setString(3, usuario.getDni());
			ps.setString(4, usuario.getCodigo());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
/*****************************************************************************************************************************************/
	
	public static void modificarCliente(int id, String modificar, String nuevoValor) throws ClassNotFoundException, SQLException {
		con.conectar();
		ps = con.getCon().prepareStatement("UPDATE usuarios SET "+modificar+" = ? WHERE `usuarios`.`id` = ?");
		ps.setString(1, nuevoValor);
		ps.setInt(2, id);
		ps.execute();
	}
	
	public static void modificarClienteJframe(int id, Usuario usuario) throws ClassNotFoundException {

        try {
            con.conectar();
           ps = con.getCon().prepareStatement("UPDATE usuarios SET nombre_apellido= ?, dni= ?, codigo= ? WHERE id = ?");
            ps.setString(1, usuario.getNombre_apellido());
            ps.setString(2, usuario.getDni());
            ps.setString(3, usuario.getCodigo());
            ps.setInt(4, id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	

/*****************************************************************************************************************************************/

	
	public void bajaUsuario(int id) throws ClassNotFoundException{
		try {
			con.conectar();
			ps = con.getCon().prepareStatement("DELETE FROM usuarios WHERE `usuarios`.`id` = ?");
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}