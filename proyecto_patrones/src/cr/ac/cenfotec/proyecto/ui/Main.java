package cr.ac.cenfotec.proyecto.ui;

import java.io.*;
import cr.ac.cenfotec.proyecto.controlador.Controlador;

public class Main {

    static PrintStream imprimir = System.out;
    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static String[] usuario;
    static Controlador controlador = new Controlador();
	
	public static void main(String[] args) throws IOException {
		iniciarSesion();
		mostrarMenuPrincipal();
	}
	
	public static void iniciarSesion() throws IOException {
		boolean iniciar = false;
		
		while (!iniciar) {
			iniciar = obtenerInicioSesion();
		}
	}
	
	public static boolean obtenerInicioSesion() throws IOException {
		boolean a;
		String nombre, clave;
		
		imprimir.println("Digite su usuario.");
		nombre = leer.readLine();
		imprimir.println("Digite su contraseña");
		clave = leer.readLine();
		
		a = verificarInicioSesion(nombre, clave);
		
		return a;
	}
	
	public static boolean verificarInicioSesion(String nombre, String clave) {
		boolean e;
		try {
			usuario = controlador.iniciarSesion(nombre, clave);
			imprimir.println("Se inició sesión exitosamente");
			e = true;
		} catch (Exception ex) {
			imprimir.println("El nombre del usuario y la clave no coinciden, Vuelve a intentarlo.");
			e = false;
		}
		
		return e;
	}
	
	public static int leerOpcion() throws IOException {
		imprimir.println("Digite la opcion.");
		return Integer.parseInt(leer.readLine());
	}
	
	public static boolean mostrarMenuPrincipal() throws IOException {
		int area = Integer.parseInt(usuario[3]);
		boolean a = false;
		
		switch(area) {
		case 1: 
			a = mainAdmin();
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
		
		return a;
	}
	
	public static boolean mainAdmin() throws IOException {
		boolean salir = false;
		int opcion;
		
		do {
			mostrarMenuAdministrador();
			opcion = leerOpcion();
			salir = mainAdminOpciones(opcion);
		} while (!salir);
		
		return salir;
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
	
	public static boolean seleccionarOpcionRegistrar(int opcion) throws IOException {
		boolean salir = false;
		
		switch(opcion) {
		case 1:
			obtenerInfoTramite();
			break;
		case 2:
			obtenerInfoTarea();
			break;
		case 3:
			obtenerInfoPaso();
			break;
		case 4:
			obtenerInfoEmpleado();
			break;
		case 5: 
			obtenerInfoArea();
			break;
		case 6: 
			salir = true;
			break;
		}
		
		return salir;
	}
	
	public static void obtenerInfoTramite() throws IOException {
		String codigo, nombre, descripcion, resultado;
		boolean EE;
		imprimir.println("Digite el código del proceso");
		codigo = leer.readLine();
		imprimir.println("Digite el nombre del proceso");
		nombre = leer.readLine();
		imprimir.println("Digite la descripción del proceso");
		descripcion = leer.readLine();
		
		
		//resultado = controlador.registrarTramite(codigo, nombre, descripcion);
	}
	
	public static void obtenerInfoTarea () throws IOException {
		String codigoTarea, nombre, descripcion, resultado, codigoDep, codigoPro;
		imprimir.println("Digite el código de la tarea");
		codigoTarea = leer.readLine();
		imprimir.println("Digite el nombre de la tarea");
		nombre = leer.readLine();
		imprimir.println("Digite la descripción de la tarea");
		descripcion = leer.readLine();
		imprimir.println("Digite el codigo del departamento encargado");
		codigoDep = leer.readLine();
		imprimir.println("Digite el codigo del proceso que pertenece esta tarea");
		codigoPro = leer.readLine();
		
		/*
		 * boolean e = controlador.validarCodigoDep(codigoDep);
		 * 
		 * if(!e){
		 * 	resultado = controlador.registrarTarea(codigoTarea, nombre, descripcion, codigoDep);
		 *  imprimir.println(resultado);
		 * }
		 */
	}
	
	public static void obtenerInfoPaso() throws IOException {
		String descripcion, codigoTarea;
		imprimir.println("Digite el codigo de la tarea que pertenece este paso");
		codigoTarea = leer.readLine();
		imprimir.println("Digite la descripcion de este paso.");
		
	}
	
	public static void obtenerInfoEmpleado() throws IOException {
		String cedula, nom1, nom2, ape1, ape2, correo, nomU, clave, rol, codArea;
		boolean e;
		
		imprimir.println("Digite la cedula del empleado");
		cedula = leer.readLine();
		imprimir.println("Digite el primer nombre del empleado");
		nom1 = leer.readLine();
		imprimir.println("Digite el segundo nombre del empleado (Opcional)");
		nom2 = leer.readLine();
		imprimir.println("Digite el primer apellido del empleado");
		ape1 = leer.readLine();
		imprimir.println("Digite el segundo apelldio del empleado (Opcional)");
		ape2 = leer.readLine();
		imprimir.println("Digite el correo del empleado");
		correo = leer.readLine();
		imprimir.println("Digite el nombre del usuario que va tener el empleado");
		nomU = leer.readLine();
		imprimir.println("Digite la clave que va utilizar el empleado");
		clave = leer.readLine();
		imprimir.println("Digite el rol del empleado");
		rol = leer.readLine();
		imprimir.println("Digite el codigo de la area funcional la cual pertenece el empleado");
		codArea = leer.readLine();
		
		/*
		 * e = controlador.validarCodigoDep(codArea);
		 * 
		 * if(e){
		 * 	controlador.registrarEmpleado();
		 * }
		 * 
		 */
	}
	
	public static void obtenerInfoArea() throws IOException {
		String codigo, nombre, descripcion, resultado;
		imprimir.println("Digite el código de la area funcional");
		codigo = leer.readLine();
		imprimir.println("Digite el nombre de la area funcional");
		nombre = leer.readLine();
		imprimir.println("Digite la descripción de la area funcional");
		descripcion = leer.readLine();
		//controlador.registrarArea(codigo, nombre, descripcion);
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
