package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Interfata extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JButton logare;
	 JPanel panel;
	 JLabel label1,label2,label;
	 final JTextField  text1,text2;
	 public Interfata(){
		  label = new JLabel("Formular de logare");
		  label.setForeground(Color.blue);
		  label.setFont(new Font("Serif", Font.BOLD, 20));
		  
		  label1 = new JLabel();
		  label1.setText("Utilizator:");
		  text1 = new JTextField(15);

		  label2 = new JLabel();
		  label2.setText("Parola:");
		  text2 = new JPasswordField(15);
	 
		  logare = new JButton("Logare");
		  
		  label.setBounds(200, 30, 400, 30);
		  label1.setBounds(80, 90, 200, 30);
		  text1.setBounds(300, 90, 200, 30);
		  label2.setBounds(80, 130, 200, 30);
		  text2.setBounds(300, 130, 200, 30);
		  logare.setBounds(200,190,100,30);
		  panel = new JPanel(new GridLayout(3,1));
		  panel.add(label);
		  panel.add(label1);
		  panel.add(text1);
		  panel.add(label2);
		  panel.add(text2);
		  panel.add(logare);
		  add(panel,BorderLayout.CENTER);
		  panel.setLayout(null);
		  logare.addActionListener(this);
		  setTitle("Formular de logare");
	}
	public void actionPerformed(ActionEvent ae){
		String value1 = text1.getText();
		String value2 = text2.getText();
		if (value1.equals("a") && value2.equals("a")) {
				InterfataAdministrator administrator = new InterfataAdministrator();
				administrator.setVisible(true);
				administrator.show();
		}
		else if(value1.equals("c") && value2.equals("c")){
			InterfataCasier casier = new InterfataCasier();
			casier.setVisible(true);
			casier.show1();
		}else{
			System.out.println("Introduceti parola si utilizatorul valide! ");
			JOptionPane.showMessageDialog(this,"Parola incorecta sau utilizator incorect!","Eroare",JOptionPane.ERROR_MESSAGE);
		}
	}
}

