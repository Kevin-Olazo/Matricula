package matricula;

import java.util.ArrayList;

public class ListaMatriculas {
    private ArrayList<Matricula> matriculas;
    
    public ListaMatriculas() {
    	this.matriculas = new ArrayList<>();
    }

    public void agregarMatricula(Matricula matricula) {
        matriculas.add(matricula);
    }

    public boolean contieneAlumno(int codAlumno) {
        return matriculas.stream().anyMatch(matricula -> matricula.getCodAlumno() == codAlumno);
    }

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }
}
