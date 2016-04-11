package grafiko;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class Bazkidea extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private int eraKode;
	private char[] pasahitza;
	
	
	/**
	 * Create the frame.
	 */
	
	public Bazkidea(){
		this.loginSortu();		
		
	}
	
	
	private void loginSortu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label1= new JLabel();
		label1.setText("Erabiltzailea");
		panel.add(label1);
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label2= new JLabel();
		label2.setText("Pasahitza");
		panel.add(label2);
		textField_1 = new JPasswordField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton botoia = new JButton("OK");
		botoia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					eraKode =Integer.parseInt( textField.getText());
					//System.out.println(eraKode);
					pasahitza = textField_1.getPassword();
					//System.out.println(textField_1.getPassword());
				}
				catch (Exception ex){
					new Errorea("Erabiltzaile okerra");
				}
			}
		});
		panel.add(botoia);
		getRootPane().setDefaultButton(botoia);
		
		this.setVisible(true);
		
	}
	
	private void menuaErakutsi(){
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		JButton btnNewButton = new JButton("Datuak aldatu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton1 = new JButton("Kreditua gehitu");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewButton1);
		
		JButton btnNewButton2 = new JButton("Pelikula alokatu");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("Pelikula itzuli");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewButton3);
		
	}

}
