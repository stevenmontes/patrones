package cr.ac.cenfotec.proyecto.multis;

import java.sql.ResultSet;
import java.util.ArrayList;

import cr.ac.cenfotec.proyecto.conexion.Conector;
import cr.ac.cenfotec.proyecto.objetos.Tarea;

public class MultiTarea {
	
	public MultiTarea() {
		
	}
	
	public String registrarTarea (Tarea E, String proceso) {
        String consulta = "{Call dbo.pa_registrar_tarea ('" + E.getCodigo() + "','" + E.getNombre() + "', '" + E.getDescripcion() + "', '" + E.getAreaEncargada().getCodigo() +"', '"+ proceso +"')}";
        String resultado;

        try {
                Conector.getConector().ejecutarSQL(consulta);
                resultado = "La tarea se registró correctamente en el sistema.";

        } catch (Exception ex) {
                resultado = "No se pudo registrar la tarea, intentelo de nuevo " + ex.getMessage();

        }

        return resultado;
	}
	
	public ArrayList<String> obtenerCodigos(){
        String consulta = "{Call dbo.pa_obtener_codigos_tareas";
        ArrayList<String> lista = new ArrayList<>();

        try {
                ResultSet rs = Conector.getConector().ejecutarSQL(consulta, true);
                
                while(rs.next()) {
                	lista.add(rs.getString("codigo"));
                }

        } catch (Exception ex) {
        }

        return lista;
	}
}
