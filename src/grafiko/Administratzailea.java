package grafiko;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Administratzailea extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane1;
	
	public  Administratzailea(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel1 = new JPanel();
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5,5,5,5));
		contentPane1.setLayout(new BorderLayout(0, 0));
		contentPane1.add(panel1, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("Bazkide berria sartu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton1 = new JButton("Bazkideen egoera aldatu");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bazkideEgoeraAldatu();
			}
		});
		panel.add(btnNewButton1);
		
		JButton btnNewButton2 = new JButton("Pelikula sartu");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("Pelikula baja");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewButton3);
		
		JButton btnNewButton4 = new JButton("<--");
		btnNewButton4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Leihoa.getFrame().setVisible(true);
				dispose();
			}
		});
		
		panel.add(btnNewButton4);
		setVisible(true);
	}
	
	public void bazkideEgoeraAldatu(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		JLabel lblBazkidearenIzena = new JLabel("Bazkidearen Kodea:  ");
		panel.add(lblBazkidearenIzena);
		
		JTextField o = new JTextField();
		panel.add(o);
		o.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				bazkidearenEgoeraAldatu(o.getText());
			}
		});
		JButton btnNewButton4 = new JButton("<--");
		btnNewButton4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Administratzailea();
				dispose();
			}
		});
		panel.add(btnNewButton4);
		setVisible(true);
	}
	
	public void bazkidearenEgoeraAldatu(String kodea){
		Konexioa kon = Konexioa.getKonexioa();
		ResultSet kontsulta = kon.select("SELECT EGOERA FROM BAZKIDEA WHERE KODEA=" + kodea);
		String egoera = kontsulta.toString();
		if (egoera == "TRUE"){
			try {
				kon.post("UPDATE BAZKIDEA SET EGOERA=FALSE WHERE KODEA="+kodea);
			} catch (Exception e) {	e.printStackTrace();}
			
		}
		else{
			try {
				kon.post("UPDATE BAZKIDEA SET EGOERA=TRUE WHERE KODEA"+kodea);
			} catch (Exception e) {e.printStackTrace();}
		}
	}
	
	
}
