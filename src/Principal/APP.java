package Principal;

import Controladores.ControladorPrincipal;
import Vista.Principal;

public class APP {
	
	public static void main(String[] args) {
		Principal frmPrincipal = new Principal();
		
		ControladorPrincipal principalC = new ControladorPrincipal();
		principalC.inicializar();
		frmPrincipal.setVisible(true);
		
	}

}
