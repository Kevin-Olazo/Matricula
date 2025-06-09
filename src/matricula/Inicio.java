package matricula;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel cardPanel;
	private JFrame frame;
	private CardLayout cardLayout;

	private JScrollPane scrollPane;
	private JTable tablaAlumnos;
	private JTextArea txtS;
	private JButton btnRegistrar;

	public ListaRegistro listaRegistro = new ListaRegistro();
	public ListaCursos listaCursos = new ListaCursos();

	public Inicio() {
		crearVentana();
		crearCardLayout();

		frame.getContentPane().add(cardPanel);
		frame.setVisible(true);

	}

	private void crearVentana() {
		frame = new JFrame("Menu Principal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1086, 746);
	}

	private void crearCardLayout() {
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);

		cardPanel.add(crearMenuPrincipal(), "PanelMenu");
		cardPanel.add(crearPanelAlumno(), "PanelAlumno");
		cardPanel.add(crearPanelMantenimiento(), "PanelMantenimiento");
		cardPanel.add(crearPanelConsulta(), "PanelConsulta");
		cardPanel.add(crearPanelRegistro(), "PanelRegistro");
		cardPanel.add(crearPanelReporte(), "PanelReporte");
		cardPanel.add(crearPanelListaRegistrados(), "PanelRegistrados");
		cardPanel.add(crearPanelCurso(), "PanelCurso");
	}

	private JPanel crearMenuPrincipal() {
		JPanel panelMenu = new JPanel();

		JButton btnRegistro = new JButton("REGISTRO");
		btnRegistro.setBounds(276, 46, 175, 70);
		JButton btnConsulta = new JButton("CONSULTA");
		btnConsulta.setBounds(468, 46, 175, 70);
		JButton btnReporte = new JButton("REPORTE");
		btnReporte.setBounds(684, 46, 175, 70);
		JButton btnMantenimiento = new JButton("MANTENIMIENTO");
		btnMantenimiento.setBounds(62, 46, 175, 70);
		panelMenu.setLayout(null);

		panelMenu.add(btnRegistro);
		panelMenu.add(btnConsulta);
		panelMenu.add(btnReporte);
		panelMenu.add(btnMantenimiento);

		btnMantenimiento.addActionListener(e -> cardLayout.show(cardPanel, "PanelMantenimiento"));
		btnConsulta.addActionListener(e -> cardLayout.show(cardPanel, "PanelConsulta"));
		btnRegistro.addActionListener(e -> cardLayout.show(cardPanel, "PanelRegistro"));
		btnReporte.addActionListener(e -> cardLayout.show(cardPanel, "PanelReporte"));

		return panelMenu;

	}

	private JPanel crearPanelMantenimiento() {
		JPanel panelMantenimiento = new JPanel();
		panelMantenimiento.setLayout(null);

		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setBounds(32, 632, 113, 40);
		panelMantenimiento.add(btnAtras);
		btnAtras.addActionListener(e -> cardLayout.show(cardPanel, "PanelMenu"));

		JButton btnRegistrarAlumno = new JButton("Agregar alumno");
		btnRegistrarAlumno.setLocation(121, 113);
		btnRegistrarAlumno.setSize(162, 56);
		panelMantenimiento.add(btnRegistrarAlumno);
		btnRegistrarAlumno.addActionListener(e -> cardLayout.show(cardPanel, "PanelAlumno"));

		JButton btnConsultarAlumnos = new JButton("Consultar Alumnos");
		btnConsultarAlumnos.setBounds(121, 218, 162, 56);
		panelMantenimiento.add(btnConsultarAlumnos);
		btnConsultarAlumnos.addActionListener(e -> cardLayout.show(cardPanel, "PanelRegistrados"));

		JButton btnNewButton_2 = new JButton("Modificar Alumnos");
		btnNewButton_2.setBounds(121, 320, 162, 49);
		panelMantenimiento.add(btnNewButton_2);

		JLabel lblAlumno = new JLabel("Alumno");
		lblAlumno.setBounds(121, 49, 133, 14);
		panelMantenimiento.add(lblAlumno);

		JButton btnAgregarCurso = new JButton("Agregar Curso");
		btnAgregarCurso.setBounds(526, 113, 152, 56);
		panelMantenimiento.add(btnAgregarCurso);
		btnAgregarCurso.addActionListener(e -> cardLayout.show(cardPanel, "PanelCurso"));

		JButton btnConsultarCursos = new JButton("Consultar Cursos");
		btnConsultarCursos.setBounds(526, 218, 152, 56);
		panelMantenimiento.add(btnConsultarCursos);

		return panelMantenimiento;
	}

	private JPanel crearPanelAlumno() {
		JPanel panelAlumno = new JPanel();
		panelAlumno.setLayout(null);

		JPanel panelDatos = new JPanel();
		panelDatos.setBounds(24, 23, 1025, 230);
		panelDatos.setLayout(null);

		JLabel lblNombres = new JLabel("Nombres: ");
		lblNombres.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombres.setBounds(10, 60, 107, 33);
		panelDatos.add(lblNombres);

		JTextField txtNombre = new JTextField(15);
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNombre.setBounds(122, 63, 213, 27);
		panelDatos.add(txtNombre);

		JLabel lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellidos.setBounds(10, 11, 110, 33);
		panelDatos.add(lblApellidos);

		JTextField txtApellidos = new JTextField(15);
		txtApellidos.setFont(new Font("Arial", Font.PLAIN, 12));
		txtApellidos.setBounds(122, 14, 213, 27);
		panelDatos.add(txtApellidos);

		JLabel lblDNI = new JLabel("DNI: ");
		lblDNI.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDNI.setBounds(10, 127, 107, 33);
		panelDatos.add(lblDNI);

		JTextField txtDNI = new JTextField(15);
		txtDNI.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDNI.setBounds(124, 130, 126, 27);
		panelDatos.add(txtDNI);

		JLabel lblEdad = new JLabel("Edad: ");
		lblEdad.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEdad.setBounds(414, 81, 57, 24);
		panelDatos.add(lblEdad);

		JTextField txtEdad = new JTextField(15);
		txtEdad.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEdad.setBounds(494, 75, 57, 27);
		panelDatos.add(txtEdad);

		JLabel lblCelular = new JLabel("Celular: ");
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCelular.setBounds(414, 136, 77, 24);
		panelDatos.add(lblCelular);

		JTextField txtCelular = new JTextField(15);
		txtCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCelular.setBounds(494, 133, 142, 27);
		panelDatos.add(txtCelular);

		JLabel lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCodigo.setBounds(414, 12, 70, 24);
		panelDatos.add(lblCodigo);

		JTextField txtCodigo = new JTextField((String.valueOf(Alumno.getCodigoActual())));
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCodigo.setBounds(494, 14, 77, 20);
		panelDatos.add(txtCodigo);

		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAtras.setLocation(10, 632);
		btnAtras.setSize(120, 52);

		btnAtras.addActionListener(e -> cardLayout.show(cardPanel, "PanelMantenimiento"));

		btnRegistrar = new JButton("Agregar");
		btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRegistrar.setBounds(742, 178, 126, 41);

		panelDatos.add(btnRegistrar);
		panelAlumno.add(panelDatos);
		panelAlumno.add(btnAtras);

		btnRegistrar.addActionListener(
				e -> registrarAlumno(txtNombre, txtApellidos, txtDNI, txtEdad, txtCelular, txtCodigo));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(42, 299, 636, 236);
		panelAlumno.add(scrollPane_1);

		txtS = new JTextArea();
		scrollPane_1.setViewportView(txtS);

		return panelAlumno;
	}

	private JFrame crearPanelModificar(Alumno alumno, int index) {
		JFrame panelModificar = new JFrame();
		panelModificar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panelModificar.setSize(653, 255);
		panelModificar.setLocationRelativeTo(frame);
		panelModificar.setVisible(true);
		panelModificar.getContentPane().setLayout(null);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(451, 96, 156, 35);
		panelModificar.getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(e -> dispose());

		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBounds(451, 40, 156, 35);
		panelModificar.getContentPane().add(btnAceptar);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 40, 101, 14);
		panelModificar.getContentPane().add(lblApellidos);

		JTextField txtApellidos = new JTextField();
		txtApellidos.setBounds(10, 65, 116, 20);
		panelModificar.getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);

		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 106, 46, 14);
		panelModificar.getContentPane().add(lblNombres);

		JTextField txtNombres = new JTextField();
		txtNombres.setBounds(10, 136, 86, 20);
		panelModificar.getContentPane().add(txtNombres);
		txtNombres.setColumns(10);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(159, 40, 60, 14);
		panelModificar.getContentPane().add(lblEdad);

		JTextField txtEdad = new JTextField();
		txtEdad.setBounds(159, 65, 46, 20);
		panelModificar.getContentPane().add(txtEdad);
		txtEdad.setColumns(10);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(293, 40, 86, 14);
		panelModificar.getContentPane().add(lblCodigo);

		JTextField txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(293, 65, 86, 20);
		panelModificar.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(159, 106, 86, 14);
		panelModificar.getContentPane().add(lblCelular);

		JTextField txtCelular = new JTextField();
		txtCelular.setBounds(159, 143, 86, 20);
		panelModificar.getContentPane().add(txtCelular);
		txtCelular.setColumns(10);

		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(293, 106, 46, 14);
		panelModificar.getContentPane().add(lblDNI);

		JTextField txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setBounds(293, 143, 86, 20);
		panelModificar.getContentPane().add(txtDNI);
		txtDNI.setColumns(10);

		txtNombres.setText(alumno.getNombres());
		txtApellidos.setText(alumno.getApellidos());
		txtEdad.setText(String.valueOf(alumno.getEdad()));
		txtCelular.setText(String.valueOf(alumno.getCelular()));
		txtDNI.setText(alumno.getDni());

		btnAceptar.addActionListener(e -> {
			Alumno AlumnoModificar = listaRegistro.getRegistros().get(index);
			AlumnoModificar.setApellidos(txtApellidos.getText());
			AlumnoModificar.setNombres(txtNombres.getText());
			AlumnoModificar.setEdad(Integer.valueOf(txtEdad.getText()));
			AlumnoModificar.setCelular(Integer.valueOf(txtCelular.getText()));

			actualizarTabla();

		});

		btnCancelar.addActionListener(e -> panelModificar.dispose());

		return panelModificar;
	}

	private JPanel crearPanelListaRegistrados() {
		JPanel panelListaRegistrados = new JPanel();
		panelListaRegistrados.setLayout(null);

		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(48, 643, 107, 31);
		panelListaRegistrados.add(btnAtras);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(846, 48, 137, 44);
		panelListaRegistrados.add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(846, 119, 137, 44);
		btnEliminar.setEnabled(false);
		panelListaRegistrados.add(btnEliminar);
		btnEliminar.addActionListener(e -> eliminarAlumno());

		tablaAlumnos = new JTable();
		tablaAlumnos.setFont(new Font("Arial", Font.PLAIN, 12));
		tablaAlumnos.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Codigo", "Apellidos", "Nombres", "Edad", "DNI", "Celular", "Estado" }));
		tablaAlumnos.getColumnModel().getColumn(0).setPreferredWidth(65);
		tablaAlumnos.getColumnModel().getColumn(0).setMinWidth(50);
		tablaAlumnos.getColumnModel().getColumn(0).setMaxWidth(70);
		tablaAlumnos.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaAlumnos.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablaAlumnos.getColumnModel().getColumn(3).setPreferredWidth(55);
		tablaAlumnos.getColumnModel().getColumn(3).setMinWidth(50);
		tablaAlumnos.getColumnModel().getColumn(3).setMaxWidth(60);

		tablaAlumnos.setDefaultEditor(Object.class, null);

		tablaAlumnos.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				btnEliminar.setEnabled(tablaAlumnos.getSelectedRow() >= 0);
			}
		});

		btnModificar.addActionListener(e -> {

			if (tablaAlumnos.getRowCount() <= 0) {
				JOptionPane.showMessageDialog(frame, "No hay alumnos", "Error", JOptionPane.OK_OPTION);
				return;
			}

			int filaSeleccionada = tablaAlumnos.getSelectedRow();
			int index = filaSeleccionada;
			Alumno alumnoSeleccionado = listaRegistro.getRegistros().get(filaSeleccionada);
			crearPanelModificar(alumnoSeleccionado, index);

		});

		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(35, 45, 755, 520);
		scrollPane.setViewportView(tablaAlumnos);
		panelListaRegistrados.add(scrollPane);

		btnAtras.addActionListener(e -> cardLayout.show(cardPanel, "PanelMantenimiento"));

		return panelListaRegistrados;
	}

	private JPanel crearPanelConsulta() {
		JPanel panelConsulta = new JPanel();
		panelConsulta.setLayout(null);

		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(24, 40, 137, 37);
		panelConsulta.add(btnNewButton);

		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setBounds(28, 469, 118, 43);
		panelConsulta.add(btnAtras);

		btnAtras.addActionListener(e -> cardLayout.show(cardPanel, "PanelMenu"));

		return panelConsulta;

	}

	private JPanel crearPanelRegistro() {
		JPanel panelRegistro = new JPanel();
		panelRegistro.setLayout(null);

		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setBounds(28, 469, 118, 43);
		panelRegistro.add(btnAtras);

		JLabel lblNewLabel = new JLabel("REGISTRO");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(381, 46, 198, 43);
		panelRegistro.add(lblNewLabel);

		btnAtras.addActionListener(e -> cardLayout.show(cardPanel, "PanelMenu"));

		return panelRegistro;
	}

	private JPanel crearPanelReporte() {
		JPanel panelReporte = new JPanel();
		panelReporte.setLayout(null);

		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setBounds(28, 469, 118, 43);
		panelReporte.add(btnAtras);

		JLabel lblNewLabel_1 = new JLabel("REPORTE");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(314, 39, 232, 54);
		panelReporte.add(lblNewLabel_1);

		btnAtras.addActionListener(e -> cardLayout.show(cardPanel, "PanelMenu"));

		return panelReporte;
	}

	private JPanel crearPanelCurso() {
		JPanel panelCurso = new JPanel();
		panelCurso.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Codigo");
		lblNewLabel_2.setBounds(34, 46, 146, 20);
		panelCurso.add(lblNewLabel_2);

		JTextField txtCodigo = new JTextField();
		txtCodigo.setBounds(34, 77, 86, 20);
		panelCurso.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Asignatura");
		lblNewLabel_3.setBounds(34, 127, 86, 20);
		panelCurso.add(lblNewLabel_3);

		JTextField txtAsignatura = new JTextField();
		txtAsignatura.setBounds(34, 171, 86, 20);
		panelCurso.add(txtAsignatura);
		txtAsignatura.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Ciclo");
		lblNewLabel_4.setBounds(329, 49, 127, 20);
		panelCurso.add(lblNewLabel_4);

		JTextField txtCiclo = new JTextField();
		txtCiclo.setBounds(316, 77, 86, 20);
		panelCurso.add(txtCiclo);
		txtCiclo.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Numero de creditos");
		lblNewLabel_5.setBounds(316, 130, 140, 17);
		panelCurso.add(lblNewLabel_5);

		JTextField txtCreditos = new JTextField();
		txtCreditos.setBounds(316, 171, 86, 20);
		panelCurso.add(txtCreditos);
		txtCreditos.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Cantidad de Horas:");
		lblNewLabel_6.setBounds(512, 49, 127, 14);
		panelCurso.add(lblNewLabel_6);

		JTextField txtHoras = new JTextField();
		txtHoras.setBounds(512, 77, 127, 20);
		panelCurso.add(txtHoras);
		txtHoras.setColumns(10);

		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setBounds(31, 363, 113, 31);
		panelCurso.add(btnAtras);
		btnAtras.addActionListener(e -> cardLayout.show(cardPanel, "PanelMantenimiento"));

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setLocation(707, 69);
		btnAgregar.setSize(127, 37);
		panelCurso.add(btnAgregar);
		btnAgregar.addActionListener(e -> registrarCurso(txtAsignatura, txtCodigo, txtCiclo, txtCreditos, txtHoras));

		return panelCurso;
	}

	private void registrarAlumno(JTextField txtNombre, JTextField txtApellidos, JTextField txtDNI, JTextField txtEdad,
			JTextField txtCelular, JTextField txtCodigo) {
		// Validacion de entrada de datos
		if (txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtDNI.getText().isEmpty()
				|| txtEdad.getText().isEmpty() || txtCelular.getText().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Variables
		String nombres = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		String dni = txtDNI.getText();
		int edad = Integer.parseInt(txtEdad.getText());
		int celular = Integer.parseInt(txtCelular.getText());

		Alumno nuevoAlumno = new Alumno(nombres, apellidos, dni, edad, celular, 0);
		listaRegistro.agregarRegistro(nuevoAlumno);
		actualizarTabla();

		JOptionPane.showMessageDialog(frame, "Alumno registrado: \n" + nombres + " " + apellidos, "Completo",
				JOptionPane.DEFAULT_OPTION);

		// Limpiar campos de texto
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDNI.setText("");
		txtEdad.setText("");
		txtCelular.setText("");

		// Actualizar codigo
		txtCodigo.setText(String.valueOf(Alumno.getCodigoActual()));

	}

	private void registrarCurso(JTextField txtAsignatura, JTextField txtCodigo, JTextField txtCiclo,
			JTextField txtCreditos, JTextField txtHoras) {
		// Validacion de entrada de datos
		if (txtCodigo.getText().isEmpty() || txtAsignatura.getText().isEmpty() || txtCiclo.getText().isEmpty()
				|| txtCreditos.getText().isEmpty() || txtHoras.getText().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Variables
		String asignatura = txtAsignatura.getText();
		int codigo = Integer.valueOf(txtCodigo.getText());
		int ciclo = Integer.valueOf(txtCiclo.getText());
		int creditos = Integer.valueOf(txtCreditos.getText());
		int horas = Integer.valueOf(txtHoras.getText());

		Curso nuevoCurso = new Curso(asignatura, codigo, ciclo, creditos, horas);
		listaCursos.agregarCurso(nuevoCurso);

		JOptionPane.showMessageDialog(frame, "Nuevo curso agregado: \n" + asignatura, "Completo",
				JOptionPane.DEFAULT_OPTION);

	}

	private void actualizarTabla() {
		DefaultTableModel model = (DefaultTableModel) tablaAlumnos.getModel();
		model.setRowCount(0); // Limpia la tabla antes de actualizarla

		for (Alumno alumno : listaRegistro.getRegistros()) {
			model.addRow(new Object[] { alumno.getCodAlumno(), alumno.getApellidos(), alumno.getNombres(),
					alumno.getEdad(), alumno.getDni(), alumno.getCelular(), alumno.getEstado() });
		}
	}

	private void eliminarAlumno() {
		int filaSeleccionada = tablaAlumnos.getSelectedRow();
		Alumno alumnoSeleccionado = listaRegistro.getRegistros().get(filaSeleccionada);

		int confirmacion = JOptionPane.showConfirmDialog(frame,
				"¿Está seguro de eliminar al alumno: " + alumnoSeleccionado.getApellidos() + " "
						+ alumnoSeleccionado.getNombres() + " ?",
				"Confirmar eliminacion", JOptionPane.OK_CANCEL_OPTION);

		if (confirmacion != JOptionPane.OK_OPTION) {
			return;
		}

		listaRegistro.eliminarRegistro(filaSeleccionada);
		((DefaultTableModel) tablaAlumnos.getModel()).removeRow(filaSeleccionada);

	}

	public static void main(String[] args) {
		new Inicio();
	}
}
