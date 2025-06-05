package matricula;

import java.util.ArrayList;

import javax.swing.JTextArea;

public class ListaRegistro {
	private ArrayList<Alumno> registros = new ArrayList<>();

	public void agregarRegistro(Alumno alumno) {
		registros.add(alumno);
	}

	public ArrayList<Alumno> getRegistros() {
		return registros;
	}
	
	public void mostrarRegistros(JTextArea textArea) {
	    textArea.setText(""); // Clear previous content
	    for (int i = 0; i < registros.size(); i++) {
	        textArea.append("Código: " + registros.get(i).getCodAlumno() + "\n");
	        textArea.append("Nombres: " + registros.get(i).getNombres() + "\n");
	        textArea.append("Apellidos: " + registros.get(i).getApellidos() + "\n");
	        textArea.append("DNI: " + registros.get(i).getDni() + "\n");
	        textArea.append("Edad: " + registros.get(i).getEdad() + "\n");
	        textArea.append("Celular: " + registros.get(i).getCelular() + "\n");
	        textArea.append("Estado: " + registros.get(i).getEstado() + "\n");
	        textArea.append("--------------------------\n");
	    }	
	}
	
	public void eliminarRegistro(int index) {
		registros.remove(index);
	}
}
