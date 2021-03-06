package cr.ac.cenfotec.proyecto.objetos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Paso {
	private int id;
	private String codigo;
	private String nombre;
	private String descripcion;
	private boolean respuesta;
	private String estado;
	private Empleado encargado;
	private String fechaInicio;
	private String fechaFin;
	
	public Paso () {
		
	}
	
	public Paso(String codigo, String nombre, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isRespuesta() {
		return respuesta;
	}

	public void aceptar() {
		this.respuesta = true;
	}
	
	public void rechazar() {
		this.respuesta = false;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
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

	public Empleado getEncargado() {
		return encargado;
	}

	public void setEncargado(Empleado encargado) {
		this.encargado = encargado;
	}
	
	public void iniciarFecha() {
		Date hoy = new Date();
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		this.fechaInicio = formatoFecha.format(hoy);
	}
	
	public void finalizarFecha () {
		Date fin = new Date();
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		this.fechaFin = formatoFecha.format(fin);
	}
	
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}
	
	public String getFechaFin() {
		return fechaFin;
	}
	
}
