package matricula;

import java.util.ArrayList;

import javax.swing.JTextArea;

public class ListaRegistro {
	private ArrayList<Alumno> registros;;
	
	public ListaRegistro() {
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
}
