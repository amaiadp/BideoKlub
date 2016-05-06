package grafiko;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
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
				bazkideaSortu();
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
				pelikulaSartu();
			}
		});
		panel.add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("Pelikula baja");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pelikulariBajaEman();
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
	
	
	//  BAZKIDEAREN EGOERA ALDATZEKO METODOA ETA INTERFAZEA
	
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
		try{
			Konexioa con = Konexioa.getKonexioa();
			con.post("UPDATE BAZKIDEA SET EGOERA=NOT EGOERA WHERE KODEA="+kodea+";");
			new Mezua(kodea+"   kodea duen bazkidearen egoera aldatu egin da");
			
		}catch(Exception e){
							new Mezua("Bazkidearen kodea txarto adierazita dago.");
							}
	}
	
	
	
	
	// PELIKULAK SARTZEKO INTERFAZEA ETA METODOA
	
	
	
	public void pelikulaSartu(){
		try {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblTitulua = new JLabel("Titulua : ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTitulua, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTitulua, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTitulua, -350, SpringLayout.EAST, contentPane);
		contentPane.add(lblTitulua);
		
		JTextField textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 9, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 18, SpringLayout.EAST, lblTitulua);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, 194, SpringLayout.EAST, lblTitulua);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblKodea = new JLabel("Kodea : ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblKodea, 26, SpringLayout.SOUTH, lblTitulua);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblKodea, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblKodea, -24, SpringLayout.EAST, lblTitulua);
		contentPane.add(lblKodea);
		
		JTextField textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, lblKodea);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, 218, SpringLayout.EAST, lblKodea);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
			try{
				Konexioa k = Konexioa.getKonexioa();
				ResultSet s = k.select("SELECT MAX(KODEA) FROM PELIKULA");
				s.next();
				int kode = s.getInt("Max(kodea)");
				kode++;
				textField_1.setText(Integer.toString(kode));
			}catch(Exception ex){new Mezua("Kode berria begiratzerakoan errore bat gertatu da.");}
		
		JLabel lblPrezioa = new JLabel("Prezioa : ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPrezioa, 27, SpringLayout.SOUTH, lblKodea);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPrezioa, 0, SpringLayout.WEST, lblTitulua);
		contentPane.add(lblPrezioa);
		
		JTextField textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, -3, SpringLayout.NORTH, lblPrezioa);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSortu = new JButton("SORTU");
		btnSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pelikulaBerriaSartu(textField.getText(),textField_1.getText(),textField_2.getText());
				new Administratzailea();
				dispose();
				}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSortu, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSortu, -46, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnSortu);
		
		JButton button = new JButton("<---");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Administratzailea();
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, btnSortu);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 82, SpringLayout.EAST, btnSortu);
		sl_contentPane.putConstraint(SpringLayout.EAST, button, 56, SpringLayout.EAST, textField);
		contentPane.add(button);
		
		setVisible(true);
		} catch (Exception e1) {
			new Mezua("Pantailaratzeko orduan errore bat egon da.");
		}
	}
	public void pelikulaBerriaSartu(String izena,String k, String prezioa){
		
		try {
			float o = Float.parseFloat(prezioa);
			Konexioa kon = Konexioa.getKonexioa();
			int kodea = Integer.parseInt(k);
	
				kon.post("INSERT INTO PELIKULA (TITULUA,KODEA,PREZIOA) VALUES('"+izena+"','"+kodea+"','"+o+"');");
				new Mezua("Pelikula sortu da");
		} catch (Exception e) {
			new Mezua("Prezioa edo Izenburua txarto adierazita daude.");
		}
	}
	
	
	
	// PELIKULAREN EGOERA ALDATZEKO INTERFAZEA ETA METODOA
	
	
	public void pelikulariBajaEman(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		JLabel lblBazkidearenIzena = new JLabel("Pelikularen Kodea:  ");
		panel.add(lblBazkidearenIzena);
		
		JTextField o = new JTextField();
		panel.add(o);
		o.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pelikulariBajaEman(o.getText());
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
	
	public void pelikulariBajaEman(String k){
		try{
			int kodea = Integer.parseInt(k);
			Konexioa con = Konexioa.getKonexioa();
			ResultSet s = con.select("SELECT EGOERA FROM PELIKULA WHERE KODEA="+kodea+";");
			s.next();
			String egoera = s.getString("EGOERA");
			if (egoera.equalsIgnoreCase("alokatuta")){
				con.post("UPDATE PELIKULA SET EGOERA='DESKATALOGATUTA' WHERE KODEA="+kodea+";");
				new Mezua("Pelikula deskatalogatu egin da.");
			}
			
			else if(egoera.equalsIgnoreCase("libre")){
				con.post("DELETE FROM PELIKULA WHERE KODEA="+kodea+";");
				new Mezua("Pelikula ezabatu egin da.");
			}
			
		}catch(Exception e){
							new Mezua("Pelikula ezin izan da bajan eman.");
							}
	}
	
	
	// BAZKIDEA SARTZEKO METODOA
	
	
	public void bazkideaSortu(){
		
		try {
			Konexioa con = Konexioa.getKonexioa();
			ResultSet s = con.select("SELECT MAX(KODEA) FROM BAZKIDEA");
			s.next();
			int kode = s.getInt("Max(kodea)");
			kode++;
			con.post("INSERT INTO BAZKIDEA (KODEA) VALUES("+kode+");");
			new Mezua("Bazkide berria sortu da, bere Kodea ("+kode+") da.");
		} catch (Exception e) {
			new Mezua("Bazkidea sortzerakoan arazoren bat egon da.");
		}
		
	}
	
}
