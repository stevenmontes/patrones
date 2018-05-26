package cr.ac.cenfotec.proyecto.ui;

import java.io.*;

public class Main {

    static PrintStream imprimir = System.out;
    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static String[] usuario;
	
	public static void main(String[] args) throws IOException {
		iniciarSistema();
	}
	
	public static void iniciarSistema() throws IOException {
		boolean inicio = true;
		
		do {
			//iniciarSesion();
			mostrarMenu();
			
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
	
	public static int leerOpcion() throws IOException {
		imprimir.println("Digite la opcion.");
		return Integer.parseInt(leer.readLine());
	}
	
	public static void mostrarMenu() throws IOException {
		int area = 1;//Integer.parseInt(usuario[3]);
		
		switch(area) {
		case 1: 
			mainAdmin();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4: 
			break;
		default:
			break;
		}
		
	}
	
	public static void mainAdmin() throws IOException {
		boolean salir = false;
		int opcion;
		
		do {
			mostrarMenuAdministrador();
			opcion = leerOpcion();
			salir = mainAdminOpciones(opcion);
		} while (!salir);
	}
	
	public static void mostrarMenuAdministrador() {
		imprimir.println("1.REGISTRAR");
		imprimir.println("2.MODIFICAR");
		imprimir.println("3.LISTAR");
		imprimir.println("4.SALIR");
	}
	
	public static boolean mainAdminOpciones(int opcion) throws IOException {
		boolean salir = false;
		
		switch(opcion) {
		case 1:
			mainAdminRegistrar();
			break;
		case 2:
			mainAdminModificar();
			break;
		case 3:
			mainAdminListar();
			break;
		case 4:
			salir = true;
			break;
		default:
			imprimir.println("Comando invalido");
			break;
		}
		
		return salir;
	}
	
	public static void menuAdminRegistrar() {
		imprimir.println("1. Registrar proceso");
		imprimir.println("2. Registrar tarea");
		imprimir.println("3. Registrar pasos");
		imprimir.println("4. Registrar empleados");
		imprimir.println("5. Registrar areas funcionales");
		imprimir.println("6. Salir");
	}
	
	public static void mainAdminRegistrar() throws IOException {
		boolean salir = false;
		int opcion;
		
		while(!salir) {
			menuAdminRegistrar();
			opcion = leerOpcion();
			salir = seleccionarOpcionRegistrar(opcion);
		}
	}
	
	public static boolean seleccionarOpcionRegistrar(int opcion) {
		boolean salir = false;
		
		switch(opcion) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5: 
			break;
		case 6: 
			salir = true;
			break;
		}
		
		return salir;
	}
	
	public static void menuAdminModificar() {
		imprimir.println("1. Modificar proceso");
		imprimir.println("2. Modificar tarea");
		imprimir.println("3. Modificar pasos");
		imprimir.println("4. Modificar empleados");
		imprimir.println("5. Modificar areas funcionales");
		imprimir.println("6. Salir");
	}	
	
	public static void mainAdminModificar() throws IOException {
		boolean salir = false;
		int opcion;
		
		while(!salir) {
			menuAdminModificar();
			opcion = leerOpcion();
			salir = seleccionarOpcionModificar(opcion);
		}
	}
	
	public static boolean seleccionarOpcionModificar(int opcion) {
		boolean salir = false;
		
		switch(opcion) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5: 
			break;
		case 6: 
			salir = true;
			break;
		}
		
		return salir;
	}
	
	public static void menuAdminListar() {
		imprimir.println("1. Listar proceso activos");
		imprimir.println("2. Listar proceso completadas");
		imprimir.println("3. Listar tarea de un proceso");
		imprimir.println("4. Listar pasos de una tarea");
		imprimir.println("5. Listar empleados");
		imprimir.println("6. Listar areas funcionales");
		imprimir.println("7. Salir");
	}	
	
	public static void mainAdminListar() throws IOException {
		boolean salir = false;
		int opcion;
		
		while(!salir) {
			menuAdminListar();
			opcion = leerOpcion();
			salir = seleccionarOpcionListar(opcion);
		}
	}
	
	public static boolean seleccionarOpcionListar(int opcion) {
		boolean salir = false;
		
		switch(opcion) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5: 
			break;
		case 6:
			break;
		case 7: 
			salir = true;
			break;
		}
		
		return salir;
	}

}
