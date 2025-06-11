package matricula;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelRegistro extends JPanel {
	private CardLayout layout;
	private JPanel cardPanel;
	private Inicio parentFrame;
	private JButton btnMatricula, btnRetiro, btnAtras;
	
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public PanelRegistro(CardLayout layout, JPanel cardPanel, Inicio parentFrame) {
		this.layout = layout;
		this.cardPanel = cardPanel;
		this.parentFrame = parentFrame;
		
		this.setLayout(null);
		crearInterfaz();
	}
	
	private void crearInterfaz() {		
		
		btnMatricula = new JButton("Matricula");
		btnMatricula.setLocation(59, 104);
		btnMatricula.setSize(110, 45);
		this.add(btnMatricula);
		
		btnMatricula.addActionListener(e -> layout.show(cardPanel, "PanelMatricula") ); 
		
		btnRetiro = new JButton("Retiro");
		btnRetiro.setLocation(208, 104);
		btnRetiro.setSize(100, 45);
		this.add(btnRetiro);
		
		btnRetiro.addActionListener(e -> layout.show(cardPanel, "PanelRetiro") ); 
		
		btnAtras = new JButton("Atras");
		btnAtras.setLocation(10, 632);
		btnAtras.setSize(110, 45);
		this.add(btnAtras);
		
		lblNewLabel = new JLabel("REGISTRO");
		lblNewLabel.setBounds(193, 11, 289, 64);
		add(lblNewLabel);
		
		btnAtras.addActionListener(e -> layout.show(cardPanel, "PanelMenu"));
		
	}

}
