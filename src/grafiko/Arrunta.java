package grafiko;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Arrunta extends JFrame{

	private JPanel contentPane;
	
	
	public Arrunta(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
	
		JButton btnNewButton = new JButton("Katalogoa ikusi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				katalogoaErakutsi();
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton1 = new JButton("Estrenaldiak ikusi");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estreinaldiakErakutsi();
			}
		});
		panel.add(btnNewButton1);
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
	
	private void katalogoaErakutsi(){
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(30,30));
		
		JButton itzuli = new JButton("<--");
		itzuli.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setContentPane(contentPane);
			}
		});	
		panel.add(itzuli, BorderLayout.SOUTH);
		
		JLabel l = new JLabel("KATALOGOA");
		panel.add(l, BorderLayout.NORTH);
		l.setFont(new Font("Snap ITC", Font.PLAIN, 25));
		l.setHorizontalAlignment(SwingConstants.CENTER);
		ResultSet ema = Konexioa.getKonexioa().select("SELECT kodea,egoera,titulua FROM Pelikula;");
		JScrollPane jsp = erakutsi(ema);
		panel.add(jsp, BorderLayout.CENTER);
		
		setContentPane(panel);
		setVisible(true);
		
	}
	
	private void estreinaldiakErakutsi(){
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(30,30));
		
		JButton itzuli = new JButton("<--");
		itzuli.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setContentPane(contentPane);
			}
		});	
		panel.add(itzuli, BorderLayout.SOUTH);
		
		JLabel l = new JLabel("ESTREINALDIAK");
		panel.add(l, BorderLayout.NORTH);
		l.setFont(new Font("Snap ITC", Font.PLAIN, 25));
		l.setHorizontalAlignment(SwingConstants.CENTER);
		ResultSet ema = Konexioa.getKonexioa().select("SELECT kodea,egoera,titulua FROM Pelikula WHERE data>DATE_SUB(CURRENT_TIMESTAMP(),INTERVAL 2 DAY) ;");
		JScrollPane jsp = erakutsi(ema);
		panel.add(jsp, BorderLayout.CENTER);

		setContentPane(panel);
		setVisible(true);
		
	}
	
	private JScrollPane erakutsi(ResultSet ema){
		try{
			ema.last();
			int k = ema.getRow();
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(k+1,3)); 
			Integer i;
			String s;
		
			Font f = new Font("Arial", Font.BOLD, 15);
			JLabel l = new JLabel("Kodea");
			l.setFont(f);
			p.add(l);
			l = new JLabel("Egoera");
			l.setFont(f);
			p.add(l);
			l = new JLabel("Titulua");
			l.setFont(f);
			p.add(l);
			ema.beforeFirst();
			f = new Font("Arial", Font.PLAIN, 15);
			
			while(ema.next()){
				i = ema.getInt("kodea");
				s = i.toString();
				l = new JLabel(s);
				l.setFont(f);
				p.add(l);
				l = new JLabel(ema.getString("egoera"));
				l.setFont(f);
				p.add(l);
				l = new JLabel(ema.getString("titulua"));
				l.setFont(f);
				p.add(l);
			}
			JScrollPane jsp = new JScrollPane(p);
			return jsp;
			
		}catch(Exception ex){System.out.println(ex);}

		return null;
		
	}
	
	
	
}
