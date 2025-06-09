package matricula;

public class Curso {
	private int codCurso, creditos, horas, ciclo;
	private String asignatura;
	
	
	public Curso(String asignatura, int codCurso, int ciclo, int creditos, int horas) {
		this.asignatura = asignatura;
		this.codCurso = codCurso;
		this.ciclo = ciclo;
		this.creditos = creditos;
		this.horas = horas;
	}


	public int getCodCurso() {
		return codCurso;
	}


	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}


	public int getCreditos() {
		return creditos;
	}


	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}


	public int getHoras() {
		return horas;
	}


	public void setHoras(int horas) {
		this.horas = horas;
	}


	public int getCiclo() {
		return ciclo;
	}


	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}


	public String getAsignatura() {
		return asignatura;
	}


	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
}
