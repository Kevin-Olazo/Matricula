package matricula;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
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

	private ListaRegistro listaRegistro = new ListaRegistro();
	private JScrollPane scrollPane;
	private JTable tablaAlumnos;
	private JTextArea txtS;	
	private JButton btnRegistrar;

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
		System.out.println("First commit");
		cardPanel.add(crearMenuPrincipal(), "PanelMenu");
		cardPanel.add(crearPanelMantenimiento(), "PanelMantenimiento");		
		cardPanel.add(crearPanelConsulta(), "PanelConsulta");
		cardPanel.add(crearPanelRegistro(), "PanelRegistro");
		cardPanel.add(crearPanelReporte(), "PanelReporte");
		cardPanel.add(crearPanelListaRegistrados(), "PanelRegistrados");
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
		
		JButton btnListaRegistrados = new JButton("Consultar registrados");
		btnListaRegistrados.setBounds(748, 632, 146, 23);
		panelMantenimiento.add(btnListaRegistrados);


		btnAtras.addActionListener(e -> cardLayout.show(cardPanel, "PanelMenu"));

		btnRegistrar = new JButton("Agregar");
		btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRegistrar.setBounds(742, 178, 126, 41);

		panelDatos.add(btnRegistrar);
		panelMantenimiento.add(panelDatos);
		panelMantenimiento.add(btnAtras);

		btnRegistrar.addActionListener(e -> registrarAlumno(txtNombre, txtApellidos,txtDNI,txtEdad, txtCelular,txtCodigo));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(42, 299, 636, 236);
		panelMantenimiento.add(scrollPane_1);
		
		txtS = new JTextArea();
		scrollPane_1.setViewportView(txtS);
		btnListaRegistrados.addActionListener(e -> cardLayout.show(cardPanel, "PanelRegistrados"));
		

		return panelMantenimiento;
	}
	
	
	private void registrarAlumno(JTextField txtNombre, JTextField txtApellidos, JTextField txtDNI, JTextField txtEdad, JTextField txtCelular, JTextField txtCodigo) {
		//Validacion de entrada de datos
		if (txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() ||txtDNI.getText().isEmpty() || txtEdad.getText().isEmpty() || txtCelular.getText().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
	        return;
		}

		//Variables
		String nombres = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		String dni = txtDNI.getText();
		int edad = Integer.parseInt(txtEdad.getText());
		int celular = Integer.parseInt(txtCelular.getText());		
		
		Alumno nuevoAlumno = new Alumno(nombres, apellidos, dni, edad, celular, 0);
		listaRegistro.agregarRegistro(nuevoAlumno);

		DefaultTableModel model = (DefaultTableModel) tablaAlumnos.getModel();
		model.addRow(new Object[] { nuevoAlumno.getCodAlumno(), apellidos, nombres, edad, dni, celular });		
		
		JOptionPane.showMessageDialog(frame, "Alumno registrado: \n" + nombres + " " + apellidos, "Completo", javax.swing.JOptionPane.DEFAULT_OPTION) ;
		
		//Limpiar campos de texto
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDNI.setText("");
		txtEdad.setText("");
		txtCelular.setText("");

		// Actualizar codigo
		txtCodigo.setText(String.valueOf(Alumno.getCodigoActual()));
		
		listaRegistro.mostrarRegistros(txtS);
		
	}
	
	private JPanel crearPanelListaRegistrados() {
		JPanel panelListaRegistrados = new JPanel();
		panelListaRegistrados.setLayout(null);
		
		tablaAlumnos = new JTable();
		tablaAlumnos.setFont(new Font("Arial", Font.PLAIN, 12));
		tablaAlumnos.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Codigo", "Apellidos", "Nombres", "Edad", "DNI", "Celular" }));
		tablaAlumnos.getColumnModel().getColumn(0).setPreferredWidth(65);
		tablaAlumnos.getColumnModel().getColumn(0).setMinWidth(50);
		tablaAlumnos.getColumnModel().getColumn(0).setMaxWidth(70);
		tablaAlumnos.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaAlumnos.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablaAlumnos.getColumnModel().getColumn(3).setPreferredWidth(55);
		tablaAlumnos.getColumnModel().getColumn(3).setMinWidth(50);
		tablaAlumnos.getColumnModel().getColumn(3).setMaxWidth(60);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 45, 913, 400);
		scrollPane.setViewportView(tablaAlumnos);
		panelListaRegistrados.add(scrollPane);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(48, 643, 107, 31);
		panelListaRegistrados.add(btnAtras);		
		
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
	

	public static void main(String[] args) {
		new Inicio();
	}
}
