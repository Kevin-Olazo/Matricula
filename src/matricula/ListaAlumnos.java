package matricula;

import java.util.ArrayList;

public class ListaAlumnos {
	private ArrayList<Alumno> registros;;
	
	public ListaAlumnos() {
		this.registros = new ArrayList<>();
	}

	public void agregarRegistro(Alumno alumno) {
		registros.add(alumno);
	}

	public ArrayList<Alumno> getRegistros() {
		return registros;
	}	
	
	public void eliminarRegistro(int index) {
		registros.remove(index);
	}
	
	public Alumno buscarCodigo(int codigo) {
		for (Alumno a : registros) {
			if (a.getCodAlumno() == codigo){
				return a;
			}
		}
		
		return null;
	}
}
