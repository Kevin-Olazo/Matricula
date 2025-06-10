package matricula;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel cardPanel;
	private JFrame frame;
	private CardLayout cardLayout;
	private PanelListaAlumnos panelListaAlumnos;

	private JScrollPane scrollPane;
	
	private JTable tablaAlumnos;
	private JTable tablaCursos;

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
		cardPanel.add(new PanelAlumno(cardLayout, cardPanel, listaRegistro, this), "PanelAlumno");	
		cardPanel.add(new PanelMantenimiento(cardLayout, cardPanel,this), "PanelMantenimiento");
		cardPanel.add(crearPanelConsulta(), "PanelConsulta");
		cardPanel.add(crearPanelRegistro(), "PanelRegistro");
		cardPanel.add(crearPanelReporte(), "PanelReporte");
		panelListaAlumnos = new PanelListaAlumnos(cardLayout, cardPanel, listaRegistro, this);
		cardPanel.add(panelListaAlumnos, "PanelListaAlumnos");
		cardPanel.add(crearPanelCurso(), "PanelCurso");
		cardPanel.add(crearPanelListaCursos(), "PanelListaCursos");
	}
	
	public PanelListaAlumnos getPanelListaAlumnos() {
	    return panelListaAlumnos;
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
		
	
	private JPanel crearPanelListaCursos() {
		JPanel panelListaCursos = new JPanel();
		panelListaCursos.setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(48, 643, 107, 31);
		panelListaCursos.add(btnAtras);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(846, 48, 137, 44);
		panelListaCursos.add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(846, 119, 137, 44);
		btnEliminar.setEnabled(false);
		panelListaCursos.add(btnEliminar);	

		tablaCursos = new JTable();
		tablaCursos.setFont(new Font("Arial", Font.PLAIN, 12));
		tablaCursos.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Codigo", "Asignatura", "Nombres", "Edad", "DNI", "Celular", "Estado" }));
		tablaCursos.getColumnModel().getColumn(0).setPreferredWidth(65);
		tablaCursos.getColumnModel().getColumn(0).setMinWidth(50);
		tablaCursos.getColumnModel().getColumn(0).setMaxWidth(70);
		tablaCursos.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaCursos.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablaCursos.getColumnModel().getColumn(3).setPreferredWidth(55);
		tablaCursos.getColumnModel().getColumn(3).setMinWidth(50);
		tablaCursos.getColumnModel().getColumn(3).setMaxWidth(60);

		tablaCursos.setDefaultEditor(Object.class, null);

		tablaCursos.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				btnEliminar.setEnabled(tablaCursos.getSelectedRow() >= 0);
			}
		});

		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(35, 45, 755, 520);
		scrollPane.setViewportView(tablaCursos);
		panelListaCursos.add(scrollPane);
		
		btnAtras.addActionListener(e -> cardLayout.show(cardPanel, "PanelMantenimiento"));
		
		return panelListaCursos;
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

		JComboBox txtCiclo = new JComboBox();
		txtCiclo.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		txtCiclo.setBounds(316, 77, 86, 20);
		panelCurso.add(txtCiclo);


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
		btnAgregar.addActionListener(e -> registrarCurso(txtAsignatura, txtCiclo,txtCodigo, txtCreditos, txtHoras));

		return panelCurso;
	}

	
	private void registrarCurso(JTextField txtAsignatura, JComboBox txtCodigo, JTextField txtCiclo,
			JTextField txtCreditos, JTextField txtHoras) {
		// Validacion de entrada de datos
		if (txtAsignatura.getText().isEmpty() || txtCiclo.getText().isEmpty()
				|| txtCreditos.getText().isEmpty() || txtHoras.getText().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Variables
		String asignatura = txtAsignatura.getText();
		int codigo = txtCodigo.getSelectedIndex();
		int ciclo = Integer.valueOf(txtCiclo.getText());
		int creditos = Integer.valueOf(txtCreditos.getText());
		int horas = Integer.valueOf(txtHoras.getText());

		Curso nuevoCurso = new Curso(asignatura, codigo, ciclo, creditos, horas);
		listaCursos.agregarCurso(nuevoCurso);

		JOptionPane.showMessageDialog(frame, "Nuevo curso agregado: \n" + asignatura, "Completo",
				JOptionPane.DEFAULT_OPTION);

	}

	public void actualizarTablaAlumnos() {
		DefaultTableModel model = (DefaultTableModel) tablaAlumnos.getModel();
		model.setRowCount(0); // Limpia la tabla antes de actualizarla

		for (Alumno alumno : listaRegistro.getRegistros()) {
			model.addRow(new Object[] { alumno.getCodAlumno(), alumno.getApellidos(), alumno.getNombres(),
					alumno.getEdad(), alumno.getDni(), alumno.getCelular(), alumno.getEstado() });
		}
	}
	
	public void actualizarTablaCursos() {
		DefaultTableModel model = (DefaultTableModel) tablaCursos.getModel();
		model.setRowCount(0);
		
		for (Curso curso : listaCursos.getCursos()) {
			model.addRow(new Object[] {curso.getAsignatura(), curso.getCodCurso(), curso.getCiclo(), curso.getCreditos(), curso.getHoras()});
		}
	}

	public static void main(String[] args) {
		 EventQueue.invokeLater(() -> new Inicio());		
		
	}
}
