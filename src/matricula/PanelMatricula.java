package matricula;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.Color;

public class PanelMatricula extends JPanel {
	private ListaAlumnos listaRegistro;
	private ListaCursos listaCursos;
	private ListaMatriculas listaMatriculas;
	private CardLayout layout;
	private JPanel cardPanel;
	private Inicio parentFrame;
	private Alumno alumnoSeleccionado;

	private int nroMatricula = Matricula.numMATRICULA;

	private JComboBox<String> cboCurso;
	private JButton btnAtras, btnBuscar, btnAgregar, btnSeleccionar, btnCancelar, btnBuscarPor, btnResetear;
	private JTextField txtAlumno, txtCodMatricula;

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable tablaMatriculados;

	/**
	 * Create the panel.
	 */
	public PanelMatricula(CardLayout layout, JPanel cardPanel, ListaAlumnos listaRegistro, ListaCursos listaCursos,
			ListaMatriculas listaMatriculas, Inicio parentFrame) {
		this.layout = layout;
		this.cardPanel = cardPanel;
		this.parentFrame = parentFrame;
		this.listaRegistro = listaRegistro;
		this.listaCursos = listaCursos;
		this.listaMatriculas = listaMatriculas;

		this.setLayout(null);

		crearInferaz(nroMatricula);
	}

	private void crearInferaz(int nroMatricula) {
		this.setLayout(null);
		
		btnAtras = new JButton("ATRAS");
		btnAtras.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAtras.setLocation(10, 632);
		btnAtras.setSize(120, 52);
		this.add(btnAtras);
		btnAtras.addActionListener( e-> layout.show(cardPanel, "PanelRegistro"));
		
		JLabel lblNewLabel = new JLabel("MATRICULA");
		lblNewLabel.setBounds(150, 32, 346, 83);
		add(lblNewLabel);
		
		JLabel lblAlumno = new JLabel("Alumno");
		lblAlumno.setForeground(new Color(0, 128, 255));
		lblAlumno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlumno.setBounds(54, 122, 222, 24);
		add(lblAlumno);
		
		txtAlumno = new JTextField();
		txtAlumno.setBounds(54, 157, 222, 24);
		txtAlumno.setBackground(new Color(230, 255, 230));
		txtAlumno.setEditable(false);
		add(txtAlumno);
		txtAlumno.setColumns(10);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(54, 206, 222, 24);
		add(lblCurso);
		
		cboCurso = new JComboBox<String>();
		cboCurso.setBounds(54, 241, 222, 24);
		for (Curso curso : listaCursos.getCursos()) {
		    cboCurso.addItem(curso.getAsignatura());
		}
		add(cboCurso);
		
		JLabel lblNMatricula = new JLabel("Nro. de Matricula");
		lblNMatricula.setBounds(423, 126, 178, 19);
		add(lblNMatricula);
		
		txtCodMatricula = new JTextField();
		txtCodMatricula.setBounds(423, 157, 148, 24);
		txtCodMatricula.setText(String.valueOf(Matricula.numMATRICULA));
		add(txtCodMatricula);
		txtCodMatricula.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.YELLOW);
		btnBuscar.setBounds(286, 157, 87, 24);
		add(btnBuscar);
		btnBuscar.addActionListener(e-> crearPanelBuscar());
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(286, 200, 87, 24);
		btnAgregar.setBackground(Color.green);
		add(btnAgregar);
				
		scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 320, 556, 267);
		add(scrollPane);
		
		tablaMatriculados = new JTable();
		tablaMatriculados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				    "Código", "Nombres", "Apellidos", "Curso", "Ciclo"
				}
		));		
		
		DefaultTableModel model = (DefaultTableModel) tablaMatriculados.getModel();
		model.setRowCount(0);
		
		for (Matricula matricula : listaMatriculas.getMatriculas()) {
		    Alumno alumno = null;
		    for (Alumno a : listaRegistro.getRegistros()) {
		        if (a.getCodAlumno() == matricula.getCodAlumno()) {
		            alumno = a;
		            break;
		        }
		    }

		    Curso curso = null;
		    for (Curso c : listaCursos.getCursos()) {
		        if (c.getCodCurso() == matricula.getCodCurso()) {
		            curso = c;
		            break;
		        }
		    }

		    if (alumno != null && curso != null) {
		        model.addRow(new Object[] {
		            matricula.getCodMatricula(),
		            alumno.getNombres(),
		            alumno.getApellidos(),
		            curso.getAsignatura(),
		            curso.getCiclo()
		        });
		    }
		}
		scrollPane.setViewportView(tablaMatriculados);
		

		btnAgregar.addActionListener(e -> {
			
			if (alumnoSeleccionado != null && alumnoSeleccionado.getEstado() == 0) {
				
				// Verificar si alumno ya esta matriculado 
				boolean matriculado = false;
				for(Matricula m : listaMatriculas.getMatriculas()) {
					if (m.getCodAlumno() == alumnoSeleccionado.getCodAlumno()) {
						matriculado = true;
						break;
					}
				}
				
				// Buscar curso
				if (!matriculado) {
					Curso cursoSeleccionado = null;
					String nombreCurso = cboCurso.getSelectedItem().toString();
					for (Curso c : listaCursos.getCursos()) {
						if (c.getAsignatura().equals(nombreCurso)) {
							cursoSeleccionado = c;
							break;
						}
					}

					LocalDate fechaActual = LocalDate.now();
					LocalTime horaActual = LocalTime.now();
					
					//Matricular
					if (cursoSeleccionado != null) {
						Matricula nueva = new Matricula(
								alumnoSeleccionado.getCodAlumno(),
								cursoSeleccionado.getCodCurso(),
								fechaActual.toString(),
								horaActual.toString()
								);
						
						listaMatriculas.agregarMatricula(nueva);
						alumnoSeleccionado.setEstado(1);
						cargarMatriculadosEnTabla();
						txtCodMatricula.setText(String.valueOf(Matricula.numMATRICULA));
						System.out.println(nueva.getFecha() + " " + nueva.getHora());
					}
				}
				else {
		            System.out.println("Este alumno ya tiene matrícula.");
		        }

		    } else {
		        System.out.println("Selecciona un alumno válido.");
		    }
		});
		
		cargarMatriculadosEnTabla();
	}

	private JFrame crearPanelBuscar() {
		JFrame panelBuscar = new JFrame("Lista de Alumnos");
		panelBuscar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panelBuscar.setSize(653, 255);
		panelBuscar.setBounds(100, 100, 684, 348);
		panelBuscar.setLocationRelativeTo(parentFrame);
		panelBuscar.setVisible(true);
		panelBuscar.getContentPane().setLayout(null);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(520, 51, 116, 33);
		panelBuscar.getContentPane().add(btnSeleccionar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(520, 113, 116, 33);
		btnCancelar.addActionListener(e -> panelBuscar.dispose());
		panelBuscar.getContentPane().add(btnCancelar);

		btnBuscarPor = new JButton("Buscar");
		btnBuscarPor.setBounds(284, 10, 89, 23);
		panelBuscar.getContentPane().add(btnBuscarPor);

		btnResetear = new JButton("Resetear");
		btnResetear.setBounds(284, 43, 89, 23);
		panelBuscar.getContentPane().add(btnResetear);

		JLabel lblBuscar = new JLabel("Buscar por:");
		lblBuscar.setBounds(31, 11, 103, 21);
		panelBuscar.getContentPane().add(lblBuscar);

		JComboBox<String> cboBuscarPor = new JComboBox<>(new String[] { "Codigo", "Nombres", "Apellidos", "DNI" });
		cboBuscarPor.setBounds(144, 10, 116, 21);
		panelBuscar.getContentPane().add(cboBuscarPor);

		JTextField txtBuscar = new JTextField();
		txtBuscar.setBounds(31, 44, 229, 21);
		panelBuscar.getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);

		JPanel panelTabla = new JPanel();
		panelTabla.setBorder(
				new TitledBorder(null, "Alumnos Registrados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTabla.setBounds(31, 99, 471, 179);
		panelBuscar.getContentPane().add(panelTabla);
		panelTabla.setLayout(null);

		JTable tablaRegistrados = new JTable();

		tablaRegistrados.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Codigo", "Nombres", "Apellidos", "DNI" }));

		DefaultTableModel model = (DefaultTableModel) tablaRegistrados.getModel();
		for (Alumno alumno : listaRegistro.getRegistros()) {
			model.addRow(new Object[] { alumno.getCodAlumno(), alumno.getNombres(), alumno.getApellidos(),
					alumno.getDni() });
		}

		tablaRegistrados.getColumnModel().getColumn(1).setPreferredWidth(170);
		tablaRegistrados.getColumnModel().getColumn(2).setPreferredWidth(170);
		tablaRegistrados.getColumnModel().getColumn(3).setPreferredWidth(120);
		JScrollPane scrollPane = new JScrollPane(tablaRegistrados);
		scrollPane.setBounds(6, 16, 455, 152);
		panelTabla.add(scrollPane);
		panelTabla.setLayout(new BorderLayout());
		panelTabla.add(scrollPane, BorderLayout.CENTER);

		btnSeleccionar.addActionListener(e -> {
			int filaSeleccionada = tablaRegistrados.getSelectedRow();
			if (filaSeleccionada >= 0) {
				int codigo = (int) tablaRegistrados.getValueAt(filaSeleccionada, 0);
				System.out.println("Código seleccionado: " + codigo);
				elegirAlumno(codigo);
			}

		});

		btnBuscarPor.addActionListener(e -> {
			String criterio = cboBuscarPor.getSelectedItem().toString();
			String valor = txtBuscar.getText().trim();
			filtrarTabla((DefaultTableModel) tablaRegistrados.getModel(), criterio, valor);
		});

		btnResetear.addActionListener(e -> {
			txtBuscar.setText("");
			filtrarTabla((DefaultTableModel) tablaRegistrados.getModel(), "", "");
		});

		return panelBuscar;

	}

	private void elegirAlumno(int codigoSeleccionado) {
		for (Alumno alumno : listaRegistro.getRegistros()) {
			if (alumno.getCodAlumno() == codigoSeleccionado) {
				alumnoSeleccionado = alumno; // Store it!
				txtAlumno.setText(alumno.getNombres() + " " + alumno.getApellidos());
				break;
			}
		}
	}

	private void filtrarTabla(DefaultTableModel model, String criterio, String valor) {
		model.setRowCount(0);

		for (Alumno alumno : listaRegistro.getRegistros()) {
			String input = switch (criterio) {
			case "Codigo" -> String.valueOf(alumno.getCodAlumno());
			case "Nombres" -> alumno.getNombres();
			case "Apellidos" -> alumno.getApellidos();
			case "DNI" -> alumno.getDni();
			default -> "";
			};

			if (input.toLowerCase().contains(valor.toLowerCase())) {
				model.addRow(new Object[] { alumno.getCodAlumno(), alumno.getNombres(), alumno.getApellidos(),
						alumno.getDni() });
			}
		}
	}

	private void cargarMatriculadosEnTabla() {
		DefaultTableModel model = (DefaultTableModel) tablaMatriculados.getModel();
		model.setRowCount(0);

		for (Matricula matricula : listaMatriculas.getMatriculas()) {
			Alumno alumno = null;
			for(Alumno a : listaRegistro.getRegistros()) {
				if (a.getCodAlumno() == matricula.getCodAlumno()) {
					alumno = a;
					break;
				}
			}
			
			Curso curso = null;
			for(Curso c : listaCursos.getCursos()) {
				if(c.getCodCurso() == matricula.getCodCurso()) {
					curso = c;
					break;
				}
			}
			
			if (alumno != null && curso != null) {
				model.addRow(new Object[] {
						alumno.getCodAlumno(),
						alumno.getNombres(),
						alumno.getApellidos(),
						curso.getAsignatura(),
						curso.getCiclo()
				});
			}
			
		}
	}
}
