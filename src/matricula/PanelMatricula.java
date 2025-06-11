package matricula;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelMatricula extends JPanel {
	private ListaAlumnos listaRegistro;
	private ListaCursos listaCursos;
	private CardLayout layout;
	private JPanel cardPanel;
	private Inicio parentFrame;
	
	private JButton btnAtras;

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public PanelMatricula(CardLayout layout, JPanel cardPanel, ListaAlumnos listaRegistro, ListaCursos listaCursos, Inicio parentFrame) {
		this.layout = layout;
		this.cardPanel = cardPanel;
		this.parentFrame = parentFrame;
		this.listaRegistro = listaRegistro;
		this.listaCursos = listaCursos;
		
		setLayout(null);
		crearInferaz();
	}
	
	private void crearInferaz() {
		this.setLayout(null);
		
		btnAtras = new JButton("ATRAS");
		btnAtras.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAtras.setLocation(10, 632);
		btnAtras.setSize(120, 52);
		this.add(btnAtras);
		
		lblNewLabel = new JLabel("MATRICULA");
		lblNewLabel.setBounds(150, 32, 346, 83);
		add(lblNewLabel);
		btnAtras.addActionListener( e-> layout.show(cardPanel, "PanelRegistro"));
	}
}
