package matricula;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCurso extends JPanel {
	private ListaCursos listaCursos;
	private CardLayout layout;
	private JPanel cardPanel;
	private Inicio parentFrame;
	private JTextField txtCodigo, txtAsignatura, txtCreditos, txtHoras;
	private JButton btnAgregar, btnAtras;
	private JComboBox cboCiclo;

	public PanelCurso(CardLayout layout, JPanel cardPanel, ListaCursos listaCursos, Inicio parentFrame) {
		this.layout = layout;
		this.cardPanel = cardPanel;
		this.listaCursos = listaCursos;
		this.parentFrame = parentFrame;

		setLayout(null);
		crearInterfaz();

	}

	private void crearInterfaz() {
		this.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(30, 46, 46, 14);
		this.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(30, 83, 86, 20);
		txtCodigo.setColumns(10);
		this.add(txtCodigo);

		JLabel lblAsignatura = new JLabel("Asignatura: ");
		lblAsignatura.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAsignatura.setBounds(30, 136, 107, 33);
		this.add(lblAsignatura);

		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(30, 180, 86, 20);
		this.add(txtAsignatura);
		txtAsignatura.setColumns(10);
		
		JLabel lblCiclo = new JLabel("Ciclo:");
		lblCiclo.setLocation(175, 38);
		lblCiclo.setSize(50, 30);
		lblCiclo.setFont(new Font("Arial", Font.PLAIN, 12));
		
		this.add(lblCiclo);
		
		cboCiclo = new JComboBox();
		cboCiclo.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		cboCiclo.setLocation(175, 83);
		cboCiclo.setSize(76, 20);
		this.add(cboCiclo);
		
		JLabel lblCreditos = new JLabel("Creditos");
		lblCreditos.setLocation(185, 137);
		lblCreditos.setSize(63, 30);
		lblCreditos.setFont(new Font("Arial", Font.PLAIN, 12));
		this.add(lblCreditos);
		
		txtCreditos = new JTextField();
		txtCreditos.setBounds(175,180,86,20);
		this.add(txtCreditos);
		
		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setLocation(290, 38);
		lblHoras.setSize(50, 30);
		lblHoras.setFont(new Font("Arial", Font.PLAIN, 12));
		this.add(lblHoras);
		
		txtHoras = new JTextField();
		txtHoras.setBounds(290,83,99,20);
		this.add(txtHoras);
		
		btnAgregar = new JButton();
		btnAgregar.setText("Agregar");
		btnAgregar.setLocation(430, 80);
		btnAgregar.setSize(82, 26);
		this.add(btnAgregar);
		btnAgregar.addActionListener(e-> registrarCurso());
		
		btnAtras = new JButton();
		btnAtras.setText("Atras");
		btnAtras.setLocation(20, 373);
		btnAtras.setSize(69, 33);
		this.add(btnAtras);		
		btnAtras.addActionListener(e -> layout.show(cardPanel, "PanelMantenimiento"));
	}
	
	public void registrarCurso() {
		if (txtAsignatura.getText().isEmpty() || txtCreditos.getText().isEmpty() || txtHoras.getText().isEmpty()) {
			JOptionPane.showMessageDialog(parentFrame, "Por favor, complete todos los campos", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Variables
		String asignatura = txtAsignatura.getText();
		int codigo = Integer.valueOf(txtCodigo.getText());
		int ciclo = Integer.valueOf(cboCiclo.getSelectedIndex());
		int creditos = Integer.valueOf(txtCreditos.getText());
		int horas = Integer.valueOf(txtHoras.getText());

		Curso nuevoCurso = new Curso(asignatura, codigo, ciclo, creditos, horas);
		listaCursos.agregarCurso(nuevoCurso);

		JOptionPane.showMessageDialog(parentFrame, "Nuevo curso agregado: \n" + asignatura, "Completo",
				JOptionPane.DEFAULT_OPTION);
		
		parentFrame.getPanelListaCursos().actualizarTabla();
	}
	
	

}
