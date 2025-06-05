package matricula;

import java.util.ArrayList;

public class ListaCursos {
	private ArrayList<Curso> cursos = new ArrayList<>();

	
	public void agregarCurso(Curso curso) {
		cursos.add(curso);
	}
	
	public ArrayList<Curso> getCursos(){
		return cursos;		
	}
	
	public void eliminarCurso(int index) {
		cursos.remove(index);
	}
}
