package matricula;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Prueba extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelPrincipal;
	private JPanel panelConsulta;
	private JButton btnConsulta;
	private CardLayout cardLayout;
	private JButton btnAtras;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba frame = new Prueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		cardLayout = new CardLayout();				

		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);
		
		panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, "panelPrincipal");
		panelPrincipal.setLayout(null);
		
		btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(this);
		btnConsulta.setBounds(86, 272, 89, 23);
		panelPrincipal.add(btnConsulta);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(271, 109, 597, 388);
		panelPrincipal.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		panelConsulta = new JPanel();
		contentPane.add(panelConsulta, "panelConsulta");
		panelConsulta.setLayout(null);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(this);
		btnAtras.setBounds(34, 517, 129, 38);
		panelConsulta.add(btnAtras);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAtras) {
			actionPerformedBtnAtras(e);
		}
		if (e.getSource() == btnConsulta) {
			actionPerformedBtnConsulta(e);
		}
	}
	protected void actionPerformedBtnConsulta(ActionEvent e) {
		cardLayout.show(contentPane, "panelConsulta");
	}
	protected void actionPerformedBtnAtras(ActionEvent e) {
		cardLayout.show(contentPane,"panelPrincipal");
	}
}
