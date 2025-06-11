package matricula;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelReporte extends JPanel {
	private CardLayout layout;
	private JPanel cardPanel;
	private Inicio parentFrame;
	private JButton btnAtras;
	

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public PanelReporte(CardLayout layout, JPanel cardPanel, Inicio parentFrame) {
		this.layout = layout;
		this.cardPanel = cardPanel;
		this.parentFrame = parentFrame;
		
		setLayout(null);
		crearInterfaz();
	}
	
	private void crearInterfaz() {
		btnAtras = new JButton("Atras");
		btnAtras.setLocation(10, 632);
		btnAtras.setSize(110, 45);
		this.add(btnAtras);
		
		lblNewLabel = new JLabel("REPORTE");
		lblNewLabel.setBounds(132, 26, 172, 38);
		add(lblNewLabel);
		
		btnAtras.addActionListener( e-> layout.show(cardPanel, "PanelMenu"));
		
	}

}
