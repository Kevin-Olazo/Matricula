package matricula;

public class Alumno {
	private String nombres, apellidos, dni;
	private int codAlumno,edad, estado, celular;
	
	private static int codigoActual = 20201001;

	public Alumno(String nombres, String apellidos, String dni, int edad, int celular, int estado) {
		this.codAlumno = codigoActual;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
		this.dni = dni;		
		this.celular = celular;
		this.estado = estado;		
		codigoActual++;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public static int getCodigoActual() {
		return codigoActual;
	}


	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
