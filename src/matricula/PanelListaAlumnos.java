package matricula;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PanelListaAlumnos extends JPanel {
	private ListaAlumnos listaAlumnos;
	private Inicio parentFrame;
	private CardLayout layout;
	private JPanel cardPanel;
	private JTable tablaAlumnos;
	private DefaultTableModel modelAlumnos;
	private JButton btnAtras, btnModificar, btnEliminar;

	public PanelListaAlumnos(CardLayout layout, JPanel cardPanel, ListaAlumnos listaRegistro, Inicio parentFrame) {
		this.layout = layout;
		this.cardPanel = cardPanel;
		this.listaAlumnos = listaRegistro;
		this.parentFrame = parentFrame;

		setLayout(null);
		crearInterfaz();

	}

	private void crearInterfaz() {
		this.setLayout(null);
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(48, 643, 107, 31);
		this.add(btnAtras);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(846, 48, 137, 44);
		this.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(846, 119, 137, 44);
		btnEliminar.setEnabled(false);
		this.add(btnEliminar);
		btnEliminar.addActionListener(e -> eliminarAlumno());

		modelAlumnos = new DefaultTableModel(new Object[][] {},
				new String[] { "Codigo", "Apellidos", "Nombres", "Edad", "DNI", "Celular", "Estado" });

		tablaAlumnos = new JTable(modelAlumnos);
		tablaAlumnos.setFont(new Font("Arial", Font.PLAIN, 12));
		tablaAlumnos.setDefaultEditor(Object.class, null);
		tablaAlumnos.getColumnModel().getColumn(0).setPreferredWidth(65);
		tablaAlumnos.getColumnModel().getColumn(0).setMinWidth(50);
		tablaAlumnos.getColumnModel().getColumn(0).setMaxWidth(70);
		tablaAlumnos.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaAlumnos.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablaAlumnos.getColumnModel().getColumn(3).setPreferredWidth(55);
		tablaAlumnos.getColumnModel().getColumn(3).setMinWidth(50);
		tablaAlumnos.getColumnModel().getColumn(3).setMaxWidth(60);

		tablaAlumnos.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				btnEliminar.setEnabled(tablaAlumnos.getSelectedRow() >= 0);
			}
		});

		btnModificar.addActionListener(e -> {

			if (tablaAlumnos.getRowCount() <= 0) {
				JOptionPane.showMessageDialog(this, "No hay alumnos", "Error", JOptionPane.OK_OPTION);
				return;
			}

			int filaSeleccionada = tablaAlumnos.getSelectedRow();
			int index = filaSeleccionada;
			Alumno alumnoSeleccionado = listaAlumnos.getRegistros().get(filaSeleccionada);
			crearPanelModificar(alumnoSeleccionado, index);

		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(35, 45, 755, 520);
		scrollPane.setViewportView(tablaAlumnos);
		this.add(scrollPane);

		btnAtras.addActionListener(e -> layout.show(cardPanel, "PanelMantenimiento"));
		actualizarTabla();
	}

	public void actualizarTabla() {
		modelAlumnos.setRowCount(0);

		for (Alumno x : listaAlumnos.getRegistros()) {
			modelAlumnos.addRow(new Object[] { x.getCodAlumno(), x.getApellidos(), x.getNombres(), x.getEdad(),
					x.getDni(), x.getCelular(), x.getEstado() });
		}
	}

	private void eliminarAlumno() {
		int filaSeleccionada = tablaAlumnos.getSelectedRow();
		Alumno alumnoSeleccionado = listaAlumnos.getRegistros().get(filaSeleccionada);

		int confirmacion = JOptionPane.showConfirmDialog(this,
				"¿Está seguro de eliminar al alumno: " + alumnoSeleccionado.getApellidos() + " "
						+ alumnoSeleccionado.getNombres() + " ?",
				"Confirmar eliminacion", JOptionPane.OK_CANCEL_OPTION);

		if (confirmacion != JOptionPane.OK_OPTION) {
			return;
		}

		listaAlumnos.eliminarRegistro(filaSeleccionada);
		((DefaultTableModel) tablaAlumnos.getModel()).removeRow(filaSeleccionada);

	}

	private JFrame crearPanelModificar(Alumno alumno, int index) {
		JFrame panelModificar = new JFrame("Modificar datos de alumno");
		panelModificar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panelModificar.setSize(653, 255);
		panelModificar.setLocationRelativeTo(parentFrame);
		panelModificar.setVisible(true);
		panelModificar.getContentPane().setLayout(null);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(451, 96, 156, 35);
		panelModificar.getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(e -> panelModificar.dispose());

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
		txtCodigo.setText(String.valueOf(alumno.getCodAlumno()));
		txtDNI.setText(alumno.getDni());

		btnAceptar.addActionListener(e -> {
			if (txtApellidos.getText().isEmpty() || txtNombres.getText().isEmpty() || txtEdad.getText().isEmpty()
					|| txtCelular.getText().isEmpty()) {
				JOptionPane.showMessageDialog(parentFrame, "Por favor, complete todos los campos", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			int confirmacion = JOptionPane.showConfirmDialog(parentFrame, "Esta seguro de hacer cambios?", "Advenrtencia",
					JOptionPane.YES_NO_OPTION);
			
			if (confirmacion != JOptionPane.YES_OPTION) {
				return;
			}

			Alumno AlumnoModificar = listaAlumnos.getRegistros().get(index);
			AlumnoModificar.setApellidos(txtApellidos.getText());
			AlumnoModificar.setNombres(txtNombres.getText());
			AlumnoModificar.setEdad(Integer.valueOf(txtEdad.getText()));
			AlumnoModificar.setCelular(Integer.valueOf(txtCelular.getText()));

			actualizarTabla();

		});

		btnCancelar.addActionListener(e -> panelModificar.dispose());
		return panelModificar;
	}
}