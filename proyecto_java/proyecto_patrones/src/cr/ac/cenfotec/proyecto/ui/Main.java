package cr.ac.cenfotec.proyecto.ui;

import java.io.*;

public class Main {

    static PrintStream imprimir = System.out;
    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		iniciarSistema();
	}
	
	public static void iniciarSistema() throws IOException {
		boolean inicio = true;
		
		do {
			iniciarSesion();
			
		} while (inicio);
	}
	
	public static void iniciarSesion() throws IOException {
		String usuario, clave, resultado;
		imprimir.println("Digite su usuario.");
		usuario = leer.readLine();
		imprimir.println("Digite su contraseña");
		clave = leer.readLine();
		//resultado = controlador.iniciarSesion(usuario, clave);
		//imprimir.println(resultado);
	}

}
