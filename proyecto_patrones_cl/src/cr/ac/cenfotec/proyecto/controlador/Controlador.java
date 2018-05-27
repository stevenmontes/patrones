package cr.ac.cenfotec.proyecto.controlador;

import java.util.ArrayList;

import cr.ac.cenfotec.proyecto.multis.*;
import cr.ac.cenfotec.proyecto.objetos.*;

public class Controlador {
	static MultiEmpleado empleado = new MultiEmpleado();
	static MultiTramite sistema = new MultiTramite();
	static MultiTarea tarea = new MultiTarea();
	static MultiDepartamento area_funcional = new MultiDepartamento();
	
	public Controlador() {
		
	}
	
	public String[] iniciarSesion (String usuario, String clave) {
		return empleado.iniciarSesion(usuario, clave);
	}
	
	public ArrayList<String> codidosEmpleados (){
		return empleado.obtenerCodigos();
	}
	
	public ArrayList<String> codidosTramites (){
		return sistema.obtenerCodigos();
	}
	
	public ArrayList<String> codidosTareas (){
		return tarea.obtenerCodigos();
	}
	
	public ArrayList<String> codidosAreas (){
		return area_funcional.obtenerCodigos();
	}
	
	public boolean validarCodigo(String codigo, ArrayList<String> EE) {
		boolean Ex = false;
		
		for(String var: EE) {
			if(var.equals(codigo)) {
				Ex = true;
				break;
			}
		}
		
		return Ex;
	}		
	
	public String registrarTramite (String codigo, String nombre, String descripcion) {
		Tramite proceso = new Tramite(codigo, nombre, descripcion);
		return sistema.registrarTramite(proceso);
	}
	
	public String registrarTarea (String codigo, String nombre, String descripcion, String dep, String pro) {
		Departamento area = new Departamento(dep);	
		Tarea as = new Tarea(codigo, nombre, descripcion);
		as.setAreaEncargada(area);	
		return tarea.registrarTarea(as, pro);	
	}
	
	public String registrarEmpleado(String ced, String nom1, String nom2, String ape1, String ape2, String correo, String nomU, String clave, String rol, String codArea) {
		Departamento area = new Departamento(codArea);
		Empleado usuario = new Empleado(ced, nom1, nom2, ape1, ape2, correo, nomU, clave, rol);
		usuario.setAreaFuncional(area);
		return empleado.registrarEmpleado(usuario);
	}
	
	public String registrarArea(String codigo, String nombre, String descripcion) {
		Departamento E = new Departamento(codigo, nombre, descripcion);
		return area_funcional.registrarDepartamento(E);
	}
	
}
