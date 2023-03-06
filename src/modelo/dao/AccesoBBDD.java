package modelo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Conector;
import modelo.bean.Actividad;
import modelo.bean.Usuario;

public class AccesoBBDD extends Conector{
	
	
	//No funicona bien el conector, por eso lo tengo asi 
	
	private static final String HOST = "localhost";
	private static final String BBDD = "polideportivo";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	static Conector con = new Conector();
	PreparedStatement ps;
	
/**********************************************************************************************************************************************/
	
	//Inserta Los usuarios
	
	public static void InsertarUsuarios(String Usuario) {
		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la id del usuario")));
		usuario.setNombre_apellido(JOptionPane.showInputDialog(null, "Introduce el nombre y apellido de el usuario"));
		usuario.setDni(JOptionPane.showInputDialog(null, "Introduce el dni de el usuario"));
		usuario.setCodigo(JOptionPane.showInputDialog(null, "Introduce el codigo del usario"));
		
		

		try {
			if (insertarUsuariosEnLaBBDD(usuario)) {
				System.out.println("Usuario insertado");
			} else {
				System.out.println("Codigo duplicado");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	private static boolean insertarUsuariosEnLaBBDD(Usuario usuario) {
		try {
			
			//No funicona bien el conector 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BBDD, USERNAME, PASSWORD);

			
			con.conectar();
			String sql = "INSERT INTO usuarios(id, nombre_apellido, dni, codigo) VALUES (?, ?, ?, ?)";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, usuario.getId());
			pst.setString(2, usuario.getNombre_apellido());
			pst.setString(3, usuario.getDni());
			pst.setString(4, usuario.getCodigo());
			pst.execute();
			return true;

		} catch (ClassNotFoundException e) {
			System.out.println("Codigo duplicado");
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.out.println("Codigo duplicado");
			e.printStackTrace();
			return false;
		}

	}
	
/*****************************************************************************************************************************************/

	
	public static void modificarDatosActividad() {
		Actividad actividad = new Actividad();
		
		actividad.setId(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la id de la actividad")));
		actividad.setNombre(JOptionPane.showInputDialog(null, "Introduce el Nombre de la actividad"));
		actividad.setFecha_inicio(java.sql.Date.valueOf(JOptionPane.showInputDialog(null, "Introduce la fecha de inicio")));
		actividad.setDias_semana(JOptionPane.showInputDialog(null, "Introduce los dias a modificar"));
		actividad.setHoras(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el numero de horas")));
		actividad.setMax_participantes(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce los participantes maximos")));
		actividad.setPrecio(Double.parseDouble(JOptionPane.showInputDialog(null, "Introduce el precio")));
		
		
		if (modificarActividadEnLaBBDD(actividad)) {
			System.out.println("Actividad modificada");
		} else {
			System.out.println("Error al modificar");
		}

	}

	private static boolean modificarActividadEnLaBBDD(Actividad actividad) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BBDD, USERNAME, PASSWORD);

			String sql = "UPDATE actividades SET nombre=?, fecha_inicio=?, dias_semana=?, horas=?, max_participantes=?, precio=? WHERE id=?";
			PreparedStatement pst = conexion.prepareStatement(sql);

			pst.setString(1, actividad.getNombre());
			pst.setDate(2, (Date) actividad.getFecha_inicio());
			pst.setString(3, actividad.getDias_semana());
			pst.setInt(4, actividad.getHoras());
			pst.setInt(5, actividad.getMax_participantes());
			pst.setDouble(6, actividad.getPrecio());
			pst.setInt(7, actividad.getId());
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
	
	

/*****************************************************************************************************************************************/

	
	public static void eliminarUsuarios() {
		String codigo = JOptionPane.showInputDialog(null, "Inserte codigo de usuario");

		Usuario eliminar = new Usuario();
		eliminar.setCodigo(codigo);
		if (eliminarUsuariosDelaBBDD(codigo)) {
			System.out.println("Borrada la inscripcion");
		} else {
			System.out.println("Error en la eliminacion");
		}
	}

	private static boolean eliminarUsuariosDelaBBDD(String codigo) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BBDD, USERNAME, PASSWORD);

			String sql = "DELETE FROM usuarios WHERE codigo = ?";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, codigo);
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


}