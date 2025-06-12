package matricula;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PruebaBuscar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTable table;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JTextField textField;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaBuscar frame = new PruebaBuscar();
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
	public PruebaBuscar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(697, 387);
			setBounds(100, 100, 684, 348);
			getContentPane().setLayout(null);
			
			btnNewButton = new JButton("New button");
			btnNewButton.setBounds(520, 102, 116, 33);
			getContentPane().add(btnNewButton);
			
			btnNewButton_1 = new JButton("New button");
			btnNewButton_1.setBounds(520, 146, 116, 33);
			getContentPane().add(btnNewButton_1);
			
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(31, 99, 471, 179);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			table = new JTable();
			table.setBounds(6, 16, 455, 152);
			panel.add(table);
			
			lblNewLabel = new JLabel("Buscar por:");
			lblNewLabel.setBounds(31, 11, 103, 21);
			getContentPane().add(lblNewLabel);
			
			comboBox = new JComboBox();
			comboBox.setBounds(144, 10, 116, 21);
			getContentPane().add(comboBox);
			
			textField = new JTextField();
			textField.setBounds(31, 44, 229, 21);
			getContentPane().add(textField);
			textField.setColumns(10);
			
			btnNewButton_2 = new JButton("New button");
			btnNewButton_2.setBounds(284, 10, 89, 23);
			getContentPane().add(btnNewButton_2);
			
			btnNewButton_3 = new JButton("New button");
			btnNewButton_3.setBounds(284, 43, 89, 23);
			getContentPane().add(btnNewButton_3);
	}
}
