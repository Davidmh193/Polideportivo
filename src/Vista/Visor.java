package Vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Conector;
import modelo.bean.Inscripcion;
import modelo.bean.Usuario;

public class Visor extends Conector{
	
	private static final String HOST = "localhost";
	private static final String BBDD = "polideportivo";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	static Conector con = new Conector();
	PreparedStatement ps;
	
public static void pedirNombreActividad(String Inscripcion) {
		
	Inscripcion inscripcion=  new Inscripcion();
		inscripcion.setId_actividad(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la Activadad a mostrar")));
		 
					
			if (buscadorActividadEnLaBBDDD(inscripcion)) {
				JOptionPane.showMessageDialog(null, "Actividad encontrada");
				
			} else {
				System.out.println("Error en la eliminacion");
			}
		}
	
	private static boolean buscadorActividadEnLaBBDDD(Inscripcion inscripcion) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BBDD, USERNAME, PASSWORD);

			String sql = "SELECT * FROM inscripciones WHERE id = ?";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, inscripcion.getId_usuario());
			pst.execute();
			return true;
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no cargado, falta el jar");
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.out.println("Fallo en la conexion");
			e.printStackTrace();
			return false;
		}

	}
		
	
	public static void mostrarUsuariosActi(ArrayList<Usuario> usuarios) {
	for (Usuario usuario: usuarios) {
		System.out.println("id = "+ usuario.getId()+"  Nombre_apellido = "+usuario.getNombre_apellido()+" El dni es = "+usuario.getDni()+ "El codigo es = " +usuario.getCodigo());
	}
}

public static ArrayList<Usuario> getUsuarios(int id_actividad,int id_usuarios) {
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	
	try {
		con.conectar();
		PreparedStatement ps = con.getCon().prepareStatement("SELECT * from usuarios WHERE id_actividad = ? and id_usuarios= ?");
		ps.setInt(1, id_actividad);
		ps.setInt(2, id_usuarios);
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(res.getInt("id"));
			usuario.setNombre_apellido(res.getString("nombre_apellido"));
			usuario.setDni(res.getString("dni"));
			usuario.setCodigo(res.getString("codigo"));
			usuarios.add(usuario);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		con.cerrar();
	}
	return usuarios;
}


}
