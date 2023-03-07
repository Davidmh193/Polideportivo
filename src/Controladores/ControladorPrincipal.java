package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.Principal;

public class ControladorPrincipal implements ActionListener {
	Principal principal;

	public ControladorPrincipal(Principal principal) {
		this.principal = principal;

		//Asignar escuchadores de eventos a elementos (botones...)
		principal.getGestorInsertar().addActionListener(this);
		principal.getGestorEliminar().addActionListener(this);
		principal.getGestorModificar().addActionListener(this);		
		}

	// Inicia o resetea la vista de la ventana

	public void inicializar() {
		principal.setTitle("Desktop");
		principal.setLocationRelativeTo(null);
		principal.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== principal.getGestorInsertar()) {
			System.out.println("Click Usuarios");
		}else if (e.getSource() == principal.getGestorEliminar()) {
			System.out.println("Click Actividades");
		}else if(e.getSource()== principal.getGestorModificar()) {
			System.out.println("Click Inscripciones");
	}
		
	}

}
