package grafiko;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	private String pasahitza;
	private String izena;
	private String abizena;
	private String helbidea;
	
	
	/**
	 * Create the frame.
	 */
	
	public Bazkidea(){
		this.loginSortu();		
		//this.menuaErakutsi();
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
					pasahitza = ((JTextField)textField_1).getText();
					if (pasahitzaKonprobatu()){
						datuakLortu();
						menuaErakutsi();
					}
				}
				catch (Exception ex){
					new Errorea("Erabiltzaile okerra");
				}
			}


		});
		panel.add(botoia);
		getRootPane().setDefaultButton(botoia);
		
		
		JButton btnNewButton4 = new JButton("<--");
		btnNewButton4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Leihoa.getFrame().setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton4, BorderLayout.SOUTH);
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
				datuakAldatu();
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
	
	private boolean pasahitzaKonprobatu(){
		Konexioa kon = Konexioa.getKonexioa();
		ResultSet ema = kon.select("SELECT pasahitza FROM bazkidea WHERE kodea = "+ this.eraKode + ";");
		if (ema== null){
			new Errorea("Erabiltzaile okerra");
		}
		else{
			try {
				if(ema.next()){
					String pasa= ema.getString("pasahitza");
					if (pasa.equals(pasahitza)){
						ResultSet egoera = kon.select(String.format("SELECT egoera FROM bazkidea WHERE kodea= %d", eraKode));
						egoera.next();
						Boolean ego = egoera.getBoolean("egoera");
						if(ego){
							return true;
						}
						else{
							new Errorea("Bazkidea ez dago altan");
						}
						
					}
					else{
						new Errorea("Pasahitza okerra2");
					}
				}
				else{
					new Errorea("Erabiltzaile okerra3");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	private void datuakAldatu() {
		JPanel panela = new JPanel();
		panela.setBorder(new EmptyBorder(5, 5, 5, 5));
		panela.setLayout(new BorderLayout(0, 0));
		setContentPane(panela);
		
		JPanel panel = new JPanel();
		panela.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 75, 10));
		
		JLabel izL= new JLabel("Izena:");		
		panel.add(izL);
		JTextField izTx = new JTextField(izena);
		panel.add(izTx);
		izTx.setColumns(20);
		
		JLabel abL= new JLabel("Abizena:");		
		panel.add(abL);
		JTextField abTx = new JTextField(abizena);
		panel.add(abTx);
		abTx.setColumns(20);
		
		JLabel helL= new JLabel("Helbidea:");		
		panel.add(helL);
		JTextField helTx = new JTextField(helbidea);
		panel.add(helTx);
		helTx.setColumns(30);
		
		JLabel pasL= new JLabel("Pasahitza:");		
		panel.add(pasL);
		JTextField pasTx = new JTextField(pasahitza);
		panel.add(pasTx);
		pasTx.setColumns(4);
		
		JPanel behekoPanela = new JPanel();
		behekoPanela.setLayout(new BorderLayout(50,80));
		panel.add(behekoPanela, BorderLayout.SOUTH);
		
		JButton aldatu = new JButton("Aldatu");
		behekoPanela.add(aldatu, BorderLayout.CENTER);
		aldatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Konexioa kon = Konexioa.getKonexioa();
				try{
					new String();
					String pAgindu = String.format("UPDATE Bazkidea SET pasahitza='%s' , izena='%s' , abizena='%s' , helbidea='%s' WHERE kodea=%d", pasTx.getText(),izTx.getText(),abTx.getText(),helTx.getText(),eraKode);
					kon.post(pAgindu);
				}
				catch(Exception ex){
					System.out.println("Aldagai luzeegiak");
				}
				
		
			}
		});
		
		getRootPane().setDefaultButton(aldatu);
		
		JButton atzera = new JButton("<--");
		atzera.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setContentPane(contentPane);
			}
		});
		behekoPanela.add(atzera, BorderLayout.EAST);
		
		this.setVisible(true);
	}
	
	private void datuakLortu() {
		Konexioa kon = Konexioa.getKonexioa();
		ResultSet ema = kon.select("SELECT pasahitza,izena,abizena,helbidea FROM bazkidea WHERE kodea="+eraKode+";");
		try{
			if(ema.next()){
				izena = ema.getString("izena");
				abizena = ema.getString("abizena");
				helbidea = ema.getString("helbidea");
			}		
		}
		catch(Exception e){
			
		}
		
	}

}
