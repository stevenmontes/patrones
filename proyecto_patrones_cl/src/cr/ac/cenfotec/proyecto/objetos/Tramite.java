package cr.ac.cenfotec.proyecto.objetos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Tramite {
	private String nombre;
	private String fecha_inicio;
	private String fecha_fin;
	private String descripcion;
	private String estado;
	private ArrayList<Tarea> listaTareas;
		
	public Tramite () {
		listaTareas = new ArrayList<>();
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void iniciarFecha() {
		Date hoy = new Date();
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		this.fecha_inicio = formatoFecha.format(hoy);
	}
	
	public String getFechaInicio() {
		return this.fecha_inicio;
	}
	
	public void finalizarFecha() {
		Date fin = new Date();
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		this.fecha_fin = formatoFecha.format(fin);
	}
	
	public String getFechaFin() {
		return this.fecha_fin;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void activar () {
		this.estado = "En proceso";
	}
	
	public void desactivar() {
		this.estado = "Inactivo";
	}
	
	public void completar() {
		this.estado = "Completado";
	}
	
	public String getEstado() {
		return estado;
	}
	public ArrayList<Tarea> getTareas() {
		return listaTareas;
	}

	public void setTareas(ArrayList<Tarea> tareas) {
		this.listaTareas = tareas;
	}
	
	public void agregarTarea(Tarea nueva) {
		listaTareas.add(nueva);
	}
	
}
