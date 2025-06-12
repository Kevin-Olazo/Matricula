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

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel cardPanel;
	private JFrame frame;
	private CardLayout cardLayout;
	private PanelListaAlumnos panelListaAlumnos;
	private PanelListaCursos panelListaCursos;

	private JScrollPane scrollPane;	

	private JTable tablaCursos;

	public ListaAlumnos listaAlumnos = new ListaAlumnos();
	public ListaCursos listaCursos = new ListaCursos();

	public Inicio() {
		crearVentana();
		crearCardLayout();
		agregarAlumnos();
		frame.getContentPane().add(cardPanel);
		frame.setVisible(true);

	}

	private void crearVentana() {
		frame = new JFrame("Menu Principal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1086, 746);
		frame.setLocationRelativeTo(null);
	}

	private void crearCardLayout() {
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);				
		
		cardPanel.add(crearMenuPrincipal(), "PanelMenu");
		cardPanel.add(new PanelAlumno(cardLayout, cardPanel, listaAlumnos, this), "PanelAlumno");	
		cardPanel.add(new PanelCurso(cardLayout, cardPanel, listaCursos, this), "PanelCurso");
		cardPanel.add(new PanelMantenimiento(cardLayout, cardPanel,this), "PanelMantenimiento");
		cardPanel.add(new PanelRegistro(cardLayout, cardPanel,this), "PanelRegistro");
		cardPanel.add(new PanelMatricula(cardLayout, cardPanel,listaAlumnos,listaCursos, this), "PanelMatricula");
		cardPanel.add(new PanelRetiro(cardLayout, cardPanel,listaAlumnos,listaCursos, this), "PanelRetiro");
		cardPanel.add(new PanelConsulta(cardLayout, cardPanel, this), "PanelConsulta");
		cardPanel.add(new PanelReporte(cardLayout, cardPanel, this), "PanelReporte");	
						
		panelListaAlumnos = new PanelListaAlumnos(cardLayout, cardPanel, listaAlumnos, this);
		cardPanel.add(panelListaAlumnos, "PanelListaAlumnos");
		panelListaCursos = new PanelListaCursos(cardLayout, cardPanel, listaCursos, this);
		cardPanel.add(panelListaCursos, "PanelListaCursos");		
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
			
	
	public static void main(String[] args) {
		 EventQueue.invokeLater(() -> new Inicio());		
		
	}
	
	private void agregarAlumnos() {
		
			Alumno Alumno1 = new Alumno("Pepa","Pig","8974512", 8, 8487544, 0);
			Alumno Alumno2 = new Alumno("Pablito","Backyardigan","554512", 12, 4524455, 0);			
			Alumno Alumno4 = new Alumno("Jesus","Lujan Carrion","8974512", 30, 98989, 0);
			Alumno Alumno3 = new Alumno("Tyrone","Backyardigan","45645", 24, 942522, 0);
			Alumno Alumno5 = new Alumno("Dina","Boluarte","78965", 18, 6987544, 0);
			Alumno Alumno6 = new Alumno("Christian","Cueva","457885", 15, 28724, 0);
			Alumno Alumno7 = new Alumno("Christian","Dominguez","368345", 22, 567852, 0);
			Alumno Alumno8 = new Alumno("Christian","Meier","36897", 26, 78942, 0);
			Alumno Alumno9 = new Alumno("Jose","Perez","97867689", 15, 945342, 0);
			Alumno Alumno10 = new Alumno("Jesus","Perez","795785", 20, 2456348, 0);
			
			listaAlumnos.agregarRegistro(Alumno10);
			listaAlumnos.agregarRegistro(Alumno7);
			listaAlumnos.agregarRegistro(Alumno1);
			listaAlumnos.agregarRegistro(Alumno3);
			listaAlumnos.agregarRegistro(Alumno8);
			listaAlumnos.agregarRegistro(Alumno9);
			listaAlumnos.agregarRegistro(Alumno2);
			listaAlumnos.agregarRegistro(Alumno4);			
			listaAlumnos.agregarRegistro(Alumno5);
			listaAlumnos.agregarRegistro(Alumno6);
			

			
	        
	    
	}
	public PanelListaAlumnos getPanelListaAlumnos() {
	    return panelListaAlumnos;
	}
	
	public PanelListaCursos getPanelListaCursos() {
	    return panelListaCursos;
	}
}
