package ejecutables;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Vista.Visor;
import modelo.Conector;
import modelo.bean.Usuario;

public class ConsultarInscripciones extends Conector{
	public static void main (String[]arg) {
		final int OPCION_UNO = 1;
		final int SALIR = 0;
		int opcion_menu;
		do {
			opcion_menu = Integer.parseInt(JOptionPane.showInputDialog(null,
					"------MENU POLIDEPORTIVO-------\n" + OPCION_UNO + ". Consultar inscripciones\n" + SALIR + ". Salir\n\n" + "¿Que opcion desea ejecutar?"));
			//fin menú
			switch (opcion_menu) {
			case OPCION_UNO:
				Visor.pedirNombreActividad(null);
				ArrayList<Usuario> usuario = new ArrayList<Usuario>();
				usuario= Visor.getUsuarios(opcion_menu, opcion_menu);
				Visor.mostrarUsuariosActi(usuario);
				
				break;
			case SALIR:
				break;
			default:
				
				JOptionPane.showMessageDialog(null, "Opcion incorrecta");
			}
		} while (opcion_menu != SALIR);
	
}
	
}
