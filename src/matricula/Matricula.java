package matricula;

public class Matricula {
	
	private int codAlumno, codCurso;
	private String fecha, hora;
	

	public static int numMATRICULA;
	
	static {
		numMATRICULA = 100001;
	}
	
	public Matricula(int codAlumno, int codCurso, String fecha, String hora) {
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fecha = fecha;
		this.hora = hora;
		numMATRICULA++;
		
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
}
