package ejecutables;

import javax.swing.JOptionPane;

import modelo.dao.AccesoBBDD;

public class DeleteInscripcion {
	
		
		public static void main (String[]arg) {
			
			final int OPCION_UNO = 1;
			final int SALIR = 0;
			int opcion_menu;
			do {
				opcion_menu = Integer.parseInt(JOptionPane.showInputDialog(null,
						"------MENU POLIDEPORTIVO-------\n" + OPCION_UNO + ". Insertam nombre actividad\n" + SALIR + ". Salir\n\n" + "¿Que opcion desea ejecutar?"));
				//fin menú
				switch (opcion_menu) {
				case OPCION_UNO:
				
			AccesoBBDD.eliminarUsuarios();
					
					break;
				case SALIR:
					break;
				default:
					
					JOptionPane.showMessageDialog(null, "Opcion incorrecta");
				}
			} while (opcion_menu != SALIR);
			
			
			
		}
		
		
		
		
		
	
}
