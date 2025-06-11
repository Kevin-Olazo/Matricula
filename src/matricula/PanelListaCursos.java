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

public class PanelListaCursos extends JPanel{
	private ListaCursos listaCursos;
	private Inicio parentFrame;
	private CardLayout layout;
	private JPanel cardPanel;
	private JTable tablaCursos;
	private DefaultTableModel modelCursos;
	private JButton btnAtras, btnModificar, btnEliminar;
	
	public PanelListaCursos(CardLayout layout, JPanel cardPanel, ListaCursos listaCursos, Inicio parentFrame) {
		this.layout = layout;
		this.cardPanel = cardPanel;
		this.listaCursos = listaCursos;
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
		btnEliminar.addActionListener(e -> eliminarCurso());		
		
		modelCursos = new DefaultTableModel(
				new Object [][] {},
				new String [] {"Codigo", "Asignatura", "Ciclo", "N* de Creditos", "Horas"});								
				
		tablaCursos = new JTable(modelCursos);
		tablaCursos.setFont(new Font("Arial", Font.PLAIN, 12));
		tablaCursos.setDefaultEditor(Object.class, null);
		tablaCursos.getColumnModel().getColumn(0).setPreferredWidth(65);
		tablaCursos.getColumnModel().getColumn(0).setMinWidth(50);
		tablaCursos.getColumnModel().getColumn(0).setMaxWidth(70);
		tablaCursos.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaCursos.getColumnModel().getColumn(2).setPreferredWidth(70);
		tablaCursos.getColumnModel().getColumn(3).setPreferredWidth(70);
		tablaCursos.getColumnModel().getColumn(3).setMinWidth(110);
		tablaCursos.getColumnModel().getColumn(3).setMaxWidth(125);

		tablaCursos.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				btnEliminar.setEnabled(tablaCursos.getSelectedRow() >= 0);
			}
		});
		
		tablaCursos.getTableHeader().setResizingAllowed(false);
		tablaCursos.getTableHeader().setReorderingAllowed(false);
		

		btnModificar.addActionListener(e -> {

			if (tablaCursos.getRowCount() <= 0) {
				JOptionPane.showMessageDialog(this, "No hay cursos", "Error", JOptionPane.OK_OPTION);
				return;
			}

			int filaSeleccionada = tablaCursos.getSelectedRow();
			int index = filaSeleccionada;
			Curso cursoSeleccionado = listaCursos.getCursos().get(filaSeleccionada);
			crearPanelModificar(cursoSeleccionado, index);

		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(35, 45, 755, 520);
		scrollPane.setViewportView(tablaCursos);
		this.add(scrollPane);

		btnAtras.addActionListener(e -> layout.show(cardPanel, "PanelMantenimiento"));
		actualizarTabla();
	}
	
	public void actualizarTabla() {
		modelCursos.setRowCount(0); 

	    for (Curso x : listaCursos.getCursos()) {
	    	modelCursos.addRow(new Object[] {
	    			x.getCodCurso(),
		            x.getAsignatura(),
		            x.getCiclo(),
		            x.getCreditos(),
		            x.getHoras(),
		            
	        });
	    }
	}
	
	private void eliminarCurso() {
		int filaSeleccionada = tablaCursos.getSelectedRow();
		Curso cursoSeleccionado = listaCursos.getCursos().get(filaSeleccionada);

		int confirmacion = JOptionPane.showConfirmDialog(this,
				"¿Está seguro de eliminar el curso: " + cursoSeleccionado.getAsignatura() + " "
						+ cursoSeleccionado.getCodCurso() + " ?",
				"Confirmar eliminacion", JOptionPane.OK_CANCEL_OPTION);

		if (confirmacion != JOptionPane.OK_OPTION) {
			return;
		}

		listaCursos.eliminarCurso(filaSeleccionada);
		((DefaultTableModel) tablaCursos.getModel()).removeRow(filaSeleccionada);

	}
	
	private JFrame crearPanelModificar(Curso curso, int index) {
		JFrame panelModificar = new JFrame();
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

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 40, 101, 14);
		panelModificar.getContentPane().add(lblCodigo);

		JTextField txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 65, 116, 20);
		txtCodigo.setEditable(false);
		panelModificar.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setBounds(10, 106, 46, 14);
		panelModificar.getContentPane().add(lblAsignatura);

		JTextField txtAsignatura = new JTextField();
		txtAsignatura.setBounds(10, 136, 86, 20);
		panelModificar.getContentPane().add(txtAsignatura);
		txtAsignatura.setColumns(10);

		JLabel lblCiclo = new JLabel("Ciclo");
		lblCiclo.setBounds(159, 40, 60, 14);
		panelModificar.getContentPane().add(lblCiclo);

		JTextField txtCiclo = new JTextField();
		txtCiclo.setBounds(159, 65, 46, 20);
		panelModificar.getContentPane().add(txtCiclo);
		txtCiclo.setColumns(10);
	
		JLabel lblCreditos = new JLabel("Creditos");
		lblCreditos.setBounds(159, 106, 86, 14);
		panelModificar.getContentPane().add(lblCreditos);

		JTextField txtCreditos = new JTextField();
		txtCreditos.setBounds(159, 143, 86, 20);
		panelModificar.getContentPane().add(txtCreditos);
		txtCreditos.setColumns(10);

		JLabel lblHoras = new JLabel("Horas:");
		lblHoras.setBounds(293, 106, 46, 14);
		panelModificar.getContentPane().add(lblHoras);

		JTextField txtHoras = new JTextField();
				txtHoras.setBounds(293, 143, 86, 20);
		panelModificar.getContentPane().add(txtHoras);
		txtHoras.setColumns(10);

		txtAsignatura.setText(curso.getAsignatura());
		txtCiclo.setText(String.valueOf(curso.getCiclo()));
		txtCreditos.setText(String.valueOf(curso.getCreditos()));
		txtHoras.setText(String.valueOf(curso.getHoras()));
		txtCodigo.setText(String.valueOf(curso.getCodCurso()));

		btnAceptar.addActionListener(e -> {
			
			if (txtAsignatura.getText().isEmpty() || txtCiclo.getText().isEmpty() || txtCreditos.getText().isEmpty()
					|| txtHoras.getText().isEmpty()) {
				JOptionPane.showMessageDialog(parentFrame, "Por favor, complete todos los campos", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			int confirmacion = JOptionPane.showConfirmDialog(parentFrame, "Esta seguro de hacer cambios?", "Advertencia",
					JOptionPane.YES_NO_OPTION);
			
			if (confirmacion != JOptionPane.YES_OPTION) {
				return;
			}
						
			
			Curso cursoModificar = listaCursos.getCursos().get(index);
			cursoModificar.setAsignatura(String.valueOf(txtAsignatura));
			cursoModificar.setCiclo(Integer.valueOf(txtCiclo.getText()));
			cursoModificar.setCreditos(Integer.valueOf(txtCreditos.getText()));
			cursoModificar.setHoras(Integer.valueOf(txtHoras.getText()));

			actualizarTabla();

		});

		btnCancelar.addActionListener(e -> panelModificar.dispose());
		return panelModificar;

}
}
