package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.*;

import bll.AdministrareBilete;
import bll.AdministrareCasier;
import dgateway.CasierGatewayB;
import dgateway.CasierGatewayC;
import model.Casier;

public class InterfataCasier extends JPanel{
	private static final long serialVersionUID = 1L;
	private static JFrame f = new JFrame("Sectiune casier");

	private static Casier casier = new Casier();
	private static JButton insertB = new JButton("Vanzare bilet");
	private static JButton selectB = new JButton("Vizualizare bilete vandute");
	private static JButton inchide = new JButton("Inchide fereastra!");
	
	InterfataCasier(){
		setLayout(null);
		
		insertB.setBackground(Color.GREEN);
		insertB.setBounds(70, 30, 200, 80);
		add(insertB);
		
		selectB.setBackground(Color.GREEN);
		selectB.setBounds(70, 180, 200, 80);
		add(selectB);
		
		inchide.setBackground(Color.RED);
		inchide.setBounds(150,350,140,20);
		add(inchide);
	}
	
	public void show1(){
		f.getContentPane().add(new InterfataCasier());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(350, 430);
		f.setBackground(Color.darkGray);
		f.setForeground(Color.BLUE);
		f.setVisible(true);
		f.setLocationRelativeTo(null); 
		
		
		class VanzareCasier implements ActionListener{
			JPanel panel = new JPanel();
			private GridBagConstraints c = new GridBagConstraints();
			
			JLabel id_casier = new JLabel("ID CASIER:");
			JLabel tip_bilet = new JLabel("TIP BILET:");
			JLabel timp = new JLabel("TIMP:");
			JLabel data = new JLabel("DATA:");
			JTextField t_id_casier = new JTextField(15);
			JTextField t_tip_bilet = new JTextField(15);
			JTextField t_timp = new JTextField(15);
			JTextField t_data = new JTextField(15);
			
			JButton btn_casier = new JButton("Vanzare");
			JFrame frame = new JFrame("Introduceti datele biletului: ");
			boolean verificat = false;
			class IButtonListener implements ActionListener{
				public void actionPerformed(ActionEvent event) {
					casier.setId_casier(Integer.valueOf(t_id_casier.getText()));
					casier.setTip_bilet(t_tip_bilet.getText());
					casier.setTimp(Time.valueOf(t_timp.getText()));
					casier.setData(Date.valueOf(t_data.getText()));
					try{
						verificat = AdministrareCasier.vanzare(casier);
						if(verificat == true){
							try {
					            FileWriter writer = new FileWriter("Bilet.txt");
					            writer.write("\r\n");
					            writer.write("ID CASIER : " + casier.getId_casier());
					            writer.write("\r\n");   // write new line
					            writer.write("TIP DE BILET : " + casier.getTip_bilet());
					            writer.write("\r\n");   // write new line
					            writer.write("TIMP CUMPARARE: " + casier.getTimp());
					            writer.write("\r\n");   // write new line
					            writer.write("DATA CUMPARARE: " + casier.getData());
					            writer.write("\r\n");   // write new line
					            writer.write("PRET BILET : " + AdministrareBilete.obtinere_pret(casier.getTip_bilet()));
					            writer.close();
					        } catch (IOException e) {
					            e.printStackTrace();
					        }
							JOptionPane.showMessageDialog(new JFrame(), "Bilet vandut!");
						}
						else{
							JOptionPane.showMessageDialog(new JFrame(), "Biletele s-au epuizat!");
						}
					}catch(AssertionError e){
						JOptionPane.showMessageDialog(null,e);
					}
					frame.dispose();
				}
			}
		
			@Override
			public void actionPerformed(ActionEvent event) {
				btn_casier.setBackground(Color.BLUE);
				btn_casier.setSize(40, 40);
				ActionListener listener = new IButtonListener();
				btn_casier.addActionListener(listener);
				frame.setSize(400, 300);
				frame.setLocationRelativeTo(null);
				panel = new JPanel(new GridBagLayout());
				
				c.gridx = 0;
			    c.gridy = 1;
		        panel.add(id_casier, c);
		        c.gridx = 0;
		        c.gridy = 2;
			    panel.add(tip_bilet, c);
		        c.gridx = 0;
		        c.gridy = 3;
		        panel.add(timp, c);
		        c.gridx = 0;
		        c.gridy = 6;
		        panel.add(data, c);
		        c.gridx = 1;
		        c.gridy = 1;
		        panel.add(t_id_casier, c);
		        c.gridx = 1;
		        c.gridy = 2;
		        panel.add(t_tip_bilet, c);
		        c.gridx = 1;
		        c.gridy = 3;
		        panel.add(t_timp, c);
		        c.gridx = 1;
		        c.gridy = 6;
		        panel.add(t_data, c);
		        
		        c.gridx = 0;
		        c.gridy = 12;
		        panel.add(btn_casier,c);
		        frame.setContentPane(panel);
				frame.setVisible(true);
				
			}
		}
		ActionListener listener1 = new VanzareCasier();
		insertB.addActionListener(listener1);
		
		class IButtonListener implements ActionListener{
	    	JFrame frame1 = new JFrame("Bilete vandute");
	    	private String[] columnNames = {"id_casier","tip_bilet","timp","data"};
		    private JTable table;
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
				Casier cas = new Casier();
				ArrayList<Casier> lista = (ArrayList<Casier>)AdministrareCasier.istoric_vanzari();
				Object[][] data = new Object[lista.size()][4];
                for(int i = 0; i < lista.size(); i++) {
                    cas = lista.get(i);
                    data[i][0] = new Object();
                    data[i][1] = new Object();
                    data[i][2] = new Object();
                    data[i][3] = new Object();
                    data[i][0] = cas.getId_casier();
                    data[i][1] = cas.getTip_bilet();
                    data[i][2] = cas.getTimp();
                    data[i][3] = cas.getData();
                }
                table = new JTable(data, columnNames);
                JScrollPane scroll1 = new JScrollPane(table);
                JPanel panel1 = new JPanel(new BorderLayout());
                panel1.add(scroll1,BorderLayout.CENTER);

                frame1.setSize(400, 300);
                frame1.setContentPane(panel1);
                frame1.setVisible(true);
                
			}catch(AssertionError e1){
				JOptionPane.showMessageDialog(null,e1);
			}
		}
	    	
	   }
		
	ActionListener listener2 = new IButtonListener();
	selectB.addActionListener(listener2);
	
		class ExitListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				f.dispose();
			}
		}     
		ActionListener listener11 = new ExitListener();
		inchide.addActionListener(listener11);
		
		
		}

}

