package cr.ac.cenfotec.proyecto.objetos;

public class Tramite {
	private String nombre;
	private String fecha_inicio;
	private String fecha_fin;
	private String descripcion;
	private boolean estado;
	private Tarea[] tareas;
		
	public Tramite () {
		
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setFechaInicio(String fechaInicio) {
		this.fecha_inicio = fechaInicio;
	}
	
	public String getFechaInicio() {
		return this.fecha_inicio;
	}
	
	public void setFechaFin(String fechaFin) {
		this.fecha_fin = fechaFin;
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
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public boolean getEstado() {
		return this.estado;
	}

	public Tarea[] getTareas() {
		return tareas;
	}

	public void setTareas(Tarea[] tareas) {
		this.tareas = tareas;
	}
	
	
}
