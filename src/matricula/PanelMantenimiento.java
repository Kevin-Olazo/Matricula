package matricula;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMantenimiento extends JPanel {
	private CardLayout layout;
	private JPanel cardPanel;
	private Inicio parentFrame;

	public PanelMantenimiento(CardLayout layout, JPanel cardPanel, Inicio parentFrame) {
		this.layout = layout;
		this.cardPanel = cardPanel;
		this.parentFrame = parentFrame;
		
		setLayout(null);
		crearInterfaz();
	}
	
	private void crearInterfaz() {
		this.setLayout(null);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setBounds(32, 632, 113, 40);
		this.add(btnAtras);
		btnAtras.addActionListener(e -> layout.show(cardPanel, "PanelMenu"));

		JButton btnRegistrarAlumno = new JButton("Agregar alumno");
		btnRegistrarAlumno.setLocation(121, 113);
		btnRegistrarAlumno.setSize(162, 56);
		this.add(btnRegistrarAlumno);
		btnRegistrarAlumno.addActionListener(e -> layout.show(cardPanel, "PanelAlumno"));

		JButton btnConsultarAlumnos = new JButton("Consultar Alumnos");
		btnConsultarAlumnos.setBounds(121, 218, 162, 56);
		this.add(btnConsultarAlumnos);
		btnConsultarAlumnos.addActionListener(e -> layout.show(cardPanel, "PanelListaAlumnos"));

		JButton btnModificar = new JButton("Modificar Alumnos");
		btnModificar.setBounds(121, 320, 162, 49);
		this.add(btnModificar);

		JLabel lblAlumno = new JLabel("Alumno");
		lblAlumno.setBounds(121, 49, 133, 14);
		this.add(lblAlumno);

		JButton btnAgregarCurso = new JButton("Agregar Curso");
		btnAgregarCurso.setBounds(526, 113, 152, 56);
		this.add(btnAgregarCurso);
		btnAgregarCurso.addActionListener(e -> layout.show(cardPanel, "PanelCurso"));

		JButton btnConsultarCursos = new JButton("Consultar Cursos");
		btnConsultarCursos.setBounds(526, 218, 152, 56);
		this.add(btnConsultarCursos);
		btnConsultarCursos.addActionListener(e -> layout.show(cardPanel, "PanelListaCursos"));
		
	}
}
