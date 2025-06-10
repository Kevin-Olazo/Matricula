package matricula;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelAlumno extends JPanel {
	private ListaAlumnos listaRegistro;
	private CardLayout layout;
	private JPanel cardPanel;
	private Inicio parentFrame;
	private JTextField txtNombre, txtApellidos, txtDNI, txtEdad, txtCelular, txtCodigo;
	private JButton btnRegistrar, btnAtras;

	public PanelAlumno(CardLayout layout, JPanel cardPanel, ListaAlumnos listaRegistro, Inicio parentFrame) {
		this.listaRegistro = listaRegistro;
		this.layout = layout;
		this.cardPanel = cardPanel;
		this.parentFrame = parentFrame;

		setLayout(null);
		crearInterfaz();

	}

	private void crearInterfaz() {
		this.setLayout(null);

		JLabel lblNombres = new JLabel("Nombres: ");
		lblNombres.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombres.setBounds(10, 60, 107, 33);
		this.add(lblNombres);

		txtNombre = new JTextField(15);
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNombre.setBounds(122, 63, 213, 27);
		this.add(txtNombre);

		JLabel lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellidos.setBounds(10, 11, 110, 33);
		this.add(lblApellidos);

		txtApellidos = new JTextField(15);
		txtApellidos.setFont(new Font("Arial", Font.PLAIN, 12));
		txtApellidos.setBounds(122, 14, 213, 27);
		this.add(txtApellidos);

		JLabel lblDNI = new JLabel("DNI: ");
		lblDNI.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDNI.setBounds(10, 127, 107, 33);
		this.add(lblDNI);

		txtDNI = new JTextField(15);
		txtDNI.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDNI.setBounds(124, 130, 126, 27);
		this.add(txtDNI);

		JLabel lblEdad = new JLabel("Edad: ");
		lblEdad.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEdad.setBounds(414, 81, 57, 24);
		this.add(lblEdad);

		txtEdad = new JTextField(15);
		txtEdad.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEdad.setBounds(494, 75, 57, 27);
		this.add(txtEdad);

		JLabel lblCelular = new JLabel("Celular: ");
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCelular.setBounds(414, 136, 77, 24);
		this.add(lblCelular);

		txtCelular = new JTextField(15);
		txtCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCelular.setBounds(494, 133, 142, 27);
		this.add(txtCelular);

		JLabel lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCodigo.setBounds(414, 12, 70, 24);
		this.add(lblCodigo);

		txtCodigo = new JTextField((String.valueOf(Alumno.getCodigoActual())));
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCodigo.setBounds(494, 14, 77, 20);
		this.add(txtCodigo);

		btnAtras = new JButton("ATRAS");
		btnAtras.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAtras.setLocation(10, 632);
		btnAtras.setSize(120, 52);
		this.add(btnAtras);

		btnAtras.addActionListener(e -> layout.show(cardPanel, "PanelMantenimiento"));

		btnRegistrar = new JButton("Agregar");
		btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRegistrar.setBounds(742, 178, 126, 41);

		this.add(btnRegistrar);
		this.add(btnAtras);

		btnRegistrar.addActionListener(e -> this.registrarAlumno());

	}

	public void registrarAlumno() {
		if (txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtDNI.getText().isEmpty()
				|| txtEdad.getText().isEmpty() || txtCelular.getText().isEmpty()) {

			JOptionPane.showMessageDialog(parentFrame, "Por favor, complete todos los campos", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		Alumno nuevoAlumno = new Alumno(txtNombre.getText(), txtApellidos.getText(), txtDNI.getText(),
				Integer.parseInt(txtEdad.getText()), Integer.parseInt(txtCelular.getText()), 0);

		listaRegistro.agregarRegistro(nuevoAlumno);
		JOptionPane.showMessageDialog(parentFrame,
				"Alumno registrado: \n" + nuevoAlumno.getNombres() + " " + nuevoAlumno.getApellidos());

		txtNombre.setText("");
		txtApellidos.setText("");
		txtDNI.setText("");
		txtEdad.setText("");
		txtCelular.setText("");
		txtCodigo.setText(String.valueOf(Alumno.getCodigoActual()));

		parentFrame.getPanelListaAlumnos().actualizarTabla();
	}

}
