package cr.ac.cenfotec.proyecto.controlador;

import cr.ac.cenfotec.proyecto.multis.MultiEmpleado;

public class Controlador {
	static MultiEmpleado mp = new MultiEmpleado();
	
	
	public Controlador() {
		
	}
	
	public String[] iniciarSesion (String usuario, String clave) throws Exception {
		return mp.iniciarSesion(usuario, clave);
	}
	
	
}
