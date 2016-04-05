package grafiko;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Errorea extends JDialog {

	public Errorea(String mezua){
		super(new Frame(),"Error", true);
		this.setBounds(300, 150, 400, 180);
		this.getContentPane().setLayout(null);
		JLabel label = new JLabel(mezua);
		label.setBounds(65, 35, 110, 15);
		this.getContentPane().add(label, null);
		JButton botoia = new JButton("OK");
		botoia.setBounds(165, 80, 105, 30);
		botoia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		this.getContentPane().add(botoia);
		getRootPane().setDefaultButton(botoia);
		this.setVisible(true);
	}
}
