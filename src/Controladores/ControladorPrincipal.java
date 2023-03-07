package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.Principal;

public class ControladorPrincipal implements ActionListener {
	Principal principal;

	public ControladorPrincipal(Principal principal) {
		this.principal = principal;

		//asignar escuchadores de eventos a elementos (botones...)
		principal.GestorInsertar.addActionListener(this);
		principal.GestorEliminar.addActionListener(this);
		principal.GestorModificar.addActionListener(this);
		
		}

	// Inicia o resetea la vista de la ventana

	public void inicializar() {
		principal.setTitle("Desktop");
		principal.setLocationRelativeTo(null);
		principal.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("boton clicado");

	}

}
