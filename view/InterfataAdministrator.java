package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.*;

import bll.AdministrareBilete;
import bll.AdministrareCasier;
import dgateway.AdministratorGatewayB;
import dgateway.AdministratorGatewayC;
import dgateway.AdministratorGatewayCon;
import model.Bilet;
import model.Casier;
import model.Conferinta;

public class InterfataAdministrator extends JPanel{
	private static final long serialVersionUID = 1L;
	private static JFrame f = new JFrame("Sectiune administrator");
	
	private static Bilet bilet1 = new Bilet();
	private static Bilet bilet2 = new Bilet();
	private static Casier casier = new Casier();
	private static Conferinta conferinta = new Conferinta();
	
	private static JButton insertB = new JButton("Introducere bilete");
	private static JButton insertC = new JButton("Introducere casier");
	private static JButton selectC = new JButton("Vizualizare casieri");
	private static JButton selectB = new JButton("Vizualizare bilete");
	private static JButton selectCon = new JButton("Vizualizare conferinta");
	private static JButton updateP = new JButton("Actualizare pret");
	private static JButton updateD = new JButton("Actualizare bilete disponibile");
	private static JButton updateC = new JButton("Actualizare capacitate");
	private static JButton stergereC = new JButton("Stergere casier");
	private static JButton raportC = new JButton("Raport bilete vandute de un casier");
	private static JButton raportZi = new JButton("Raport incasari pe o zi");
	private static JButton raportTotale = new JButton("Raport incasari totale");
	private static JButton inchide = new JButton("Inchide fereastra!");
	
	InterfataAdministrator(){
	    setLayout(null);
	    insertB.setBackground(Color.GREEN);
		insertB.setBounds(20, 30, 160, 80);
		add(insertB);
		
		insertC.setBackground(Color.GREEN);
		insertC.setBounds(200,30,150,80);
		add(insertC);
		
		selectC.setBackground(Color.GREEN);
		selectC.setBounds(370, 30, 170, 80);
		add(selectC);
		
		selectB.setBackground(Color.RED);
		selectB.setBounds(20,350,140,20);
		add(selectB);
		
		selectCon.setBackground(Color.RED);
		selectCon.setBounds(320,350,180,20);
		add(selectCon);
		
		updateP.setBackground(Color.GREEN);
		updateP.setBounds(560, 30, 250, 80);
		add(updateP);
		
		updateD.setBackground(Color.PINK);
		updateD.setBounds(60, 140, 200, 80);
		add(updateD);
		
		updateC.setBackground(Color.PINK);
		updateC.setBounds(320, 140, 200, 80);
		add(updateC);
		
		stergereC.setBackground(Color.PINK);
		stergereC.setBounds(555, 140, 250, 80);
		add(stergereC);
		
		raportC.setBackground(Color.MAGENTA);
		raportC.setBounds(20, 250, 250, 80);
		add(raportC);
		
		raportZi.setBackground(Color.MAGENTA);
		raportZi.setBounds(350, 250, 160, 80);
		add(raportZi);
		
		raportTotale.setBackground(Color.MAGENTA);
		raportTotale.setBounds(560, 250, 250, 80);
		add(raportTotale);
		
		inchide.setBackground(Color.RED);
		inchide.setBounds(670,350,140,20);
		add(inchide);
	}
	
	public void show(){
		f.getContentPane().add(new InterfataAdministrator());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(850, 450);
		f.setBackground(Color.darkGray);
		f.setForeground(Color.BLUE);
		f.setVisible(true);
		f.setLocationRelativeTo(null); 
		
		class InsertBilet implements ActionListener{
			JPanel panel = new JPanel();
			private GridBagConstraints c = new GridBagConstraints();
			
			JLabel tip_bilet1 = new JLabel("TIP BILET:");
			JLabel pret1 = new JLabel("PRET BILET:");
			JLabel disponibile1 = new JLabel("BILETE DISPONIBILE:");
			JTextField t_tip_bilet1 = new JTextField(15);
			JTextField t_pret1 = new JTextField(15);
			JTextField t_disponibile1 = new JTextField(15);
			
			JLabel tip_bilet2 = new JLabel("TIP BILET:");
			JLabel pret2 = new JLabel("PRET BILET:");
			JLabel disponibile2 = new JLabel("BILETE DISPONIBILE:");
			JTextField t_tip_bilet2 = new JTextField(15);
			JTextField t_pret2 = new JTextField(15);
			JTextField t_disponibile2 = new JTextField(15);
			
			JButton btn_bilete = new JButton("Inserare bilete");
			JFrame frame = new JFrame("Introduceti datele biletelor: ");
			
			class IButtonListener implements ActionListener{
				public void actionPerformed(ActionEvent event) {
					bilet1.setTip_bilet(t_tip_bilet1.getText());
					bilet1.setPret(Integer.valueOf(t_pret1.getText()));
					bilet1.setNr_disponibile(Integer.valueOf(t_disponibile1.getText()));
					
					bilet2.setTip_bilet(t_tip_bilet2.getText());
					bilet2.setPret(Integer.valueOf(t_pret2.getText()));
					bilet2.setNr_disponibile(Integer.valueOf(t_disponibile2.getText()));
					boolean verificare = false;
					try{
						verificare = AdministrareBilete.locuri(bilet1, bilet2, conferinta);
						if(verificare == true)
							JOptionPane.showMessageDialog(new JFrame(), "Inserare efectuata!");
						else
							JOptionPane.showMessageDialog(new JFrame(), "Capacitate depasita, modificati numarul biletelor!");
					}catch(AssertionError e){
						JOptionPane.showMessageDialog(null,e);
					}
					frame.dispose();
				}
			}
			@Override
			public void actionPerformed(ActionEvent event) {
				btn_bilete.setBackground(Color.GREEN);
				btn_bilete.setSize(40, 40);
				ActionListener listener = new IButtonListener();
				btn_bilete.addActionListener(listener);
				frame.setSize(400, 300);
				frame.setLocationRelativeTo(null);
				panel = new JPanel(new GridBagLayout());
				
				c.gridx = 0;
			    c.gridy = 1;
		        panel.add(tip_bilet1, c);
		        c.gridx = 0;
		        c.gridy = 2;
			    panel.add(pret1, c);
		        c.gridx = 0;
		        c.gridy = 3;
		        panel.add(disponibile1, c);
		        c.gridx = 0;
		        c.gridy = 6;
		        panel.add(tip_bilet2, c);
		        c.gridx = 0;
		        c.gridy = 7;
			    panel.add(pret2, c);
		        c.gridx = 0;
		        c.gridy = 8;
		        panel.add(disponibile2, c);
		        c.gridx = 1;
		        c.gridy = 1;
		        panel.add(t_tip_bilet1, c);
		        c.gridx = 1;
		        c.gridy = 2;
		        panel.add(t_pret1, c);
		        c.gridx = 1;
		        c.gridy = 3;
		        panel.add(t_disponibile1, c);
		        c.gridx = 1;
		        c.gridy = 6;
		        panel.add(t_tip_bilet2, c);
		        c.gridx = 1;
		        c.gridy = 7;
		        panel.add(t_pret2, c);
		        c.gridx = 1;
		        c.gridy = 8;
		        panel.add(t_disponibile2, c);
		        
		        c.gridx = 1;
		        c.gridy = 12;
		        panel.add(btn_bilete,c);
		        frame.setContentPane(panel);
				frame.setVisible(true);
				
			}
		}
		ActionListener listener1 = new InsertBilet();
		insertB.addActionListener(listener1);
		
		class InsertCasier implements ActionListener{
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
			
			JButton btn_casier = new JButton("Inserare casier");
			JFrame frame = new JFrame("Introduceti datele casierului: ");
			
			class IButtonListener implements ActionListener{
				public void actionPerformed(ActionEvent event) {
					casier.setId_casier(Integer.valueOf(t_id_casier.getText()));
					casier.setTip_bilet(t_tip_bilet.getText());
					casier.setTimp(Time.valueOf(t_timp.getText()));
					casier.setData(Date.valueOf(t_data.getText()));
					try{
						AdministrareCasier.inserare_casier(casier);
						JOptionPane.showMessageDialog(new JFrame(), "Inserare efectuata!");
						
					}catch(AssertionError e){
						JOptionPane.showMessageDialog(null,e);
					}
					frame.dispose();
				}
			}
			@Override
			public void actionPerformed(ActionEvent event) {
				btn_casier.setBackground(Color.GREEN);
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
		        
		        c.gridx = 1;
		        c.gridy = 12;
		        panel.add(btn_casier,c);
		        frame.setContentPane(panel);
				frame.setVisible(true);
				
			}
		}
		ActionListener listener2 = new InsertCasier();
		insertC.addActionListener(listener2);

		class IButtonListener implements ActionListener{
		    	JFrame frame1 = new JFrame("Casieri");
		    	private String[] columnNames = {"id_casier","tip_bilet","timp","data"};
			    private JTable table;
				@Override
				public void actionPerformed(ActionEvent e) {
					try{
					Casier cas = new Casier();
					ArrayList<Casier> lista = (ArrayList<Casier>)AdministrareCasier.lista_cas();
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
			
		ActionListener listener3 = new IButtonListener();
		selectC.addActionListener(listener3);
		
		class IButtonListener11 implements ActionListener{
	    	JFrame frame1 = new JFrame("Bilete");
	    	private String[] columnNames = {"tip_bilete","pret","nr_disponibile","bilete_vandute"};
		    private JTable table;
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
				Bilet b = new Bilet();
				ArrayList<Bilet> lista = (ArrayList<Bilet>)AdministrareBilete.lista_bil();
				Object[][] data = new Object[lista.size()][4];
                for(int i = 0; i < lista.size(); i++) {
                    b = lista.get(i);
                    data[i][0] = new Object();
                    data[i][1] = new Object();
                    data[i][2] = new Object();
                    data[i][3] = new Object();
                    data[i][0] = b.getTip_bilet();
                    data[i][1] = b.getPret();
                    data[i][2] = b.getNr_disponibile();
                    data[i][3] = b.getBilete_vandute();
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
		
	ActionListener listener12 = new IButtonListener11();
	selectB.addActionListener(listener12);
	
	class IButtonListener111 implements ActionListener{
    	JFrame frame1 = new JFrame("Conferinta");
    	private String[] columnNames = {"nr_sali","ziua","capacitate_maxima"};
	    private JTable table;
		@Override
		public void actionPerformed(ActionEvent e) {
			try{
			Conferinta c = new Conferinta();
			ArrayList<Conferinta> lista = (ArrayList<Conferinta>)AdministrareCasier.lista_conf();
			Object[][] data = new Object[lista.size()][4];
            for(int i = 0; i < lista.size(); i++) {
                c = lista.get(i);
                data[i][0] = new Object();
                data[i][1] = new Object();
                data[i][2] = new Object();
                data[i][0] = c.getNr_sali();
                data[i][1] = c.getZiua();
                data[i][2] = c.getCapacitate_maxima();
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
	
	ActionListener listener123 = new IButtonListener111();
	selectCon.addActionListener(listener123);
		
		class UpdatePret implements ActionListener{
			JPanel panel = new JPanel();
			private GridBagConstraints c = new GridBagConstraints();
			JLabel tip_bilet1 = new JLabel("INTRODUCETI TIP BILET:");
			JLabel pret1 = new JLabel("INTRODUCETI PRET NOU BILET:");
			JLabel disponibile1 = new JLabel("AFISARE BILETE DISPONIBILE:");
			JLabel vandute1 = new JLabel("AFISARE BILETE VANDUTE:");
			
			JTextField t_tip_bilet1 = new JTextField(15);
			JTextField t_pret1 = new JTextField(15);
			JTextField t_disponibile1 = new JTextField(15);
			JTextField t_vandute1 = new JTextField(15);
			JButton buton = new JButton("Actualizeaza pret");
		    JButton buton1 = new JButton("Afisare bilet dupa pret");
			JFrame frame = new JFrame("Introduceti tipul biletului:");
			
			class I1ButtonListener implements ActionListener{
		    	public void actionPerformed(ActionEvent event) {
						try{
							bilet1.setTip_bilet(t_tip_bilet1.getText());
							bilet1.setPret(Integer.valueOf(t_pret1.getText()));
							AdministrareCasier.modificare(bilet1.getPret(), bilet1.getTip_bilet());
							JOptionPane.showMessageDialog(new JFrame(), "Actualizare efectuata!");
						}catch(AssertionError e){
							JOptionPane.showMessageDialog(null,e);
						}
					frame.dispose();
				}
		    	
		    }
		    
		    class IButton1Listener implements ActionListener{
		    	public void actionPerformed(ActionEvent event) {
						try{
							Bilet b  = AdministrareCasier.cauta_pret(t_tip_bilet1.getText());
				        	t_tip_bilet1.setText(b.getTip_bilet());
				        	t_pret1.setText(String.valueOf(b.getPret()));
				        	t_disponibile1.setText(String.valueOf(b.getNr_disponibile()));
				        	t_vandute1.setText(String.valueOf(b.getBilete_vandute()));
						}catch(AssertionError e){
							JOptionPane.showMessageDialog(null,e);
						}
				}
		    }
			
		   public void actionPerformed(ActionEvent event) {
				buton.setBackground(Color.MAGENTA);
				buton.setSize(40, 40);
				buton1.setBackground(Color.MAGENTA);
				buton1.setSize(40, 40);
				ActionListener listener_but = new I1ButtonListener();
				buton.addActionListener(listener_but);
				ActionListener listener_but1 = new IButton1Listener();
				buton1.addActionListener(listener_but1);
				frame.setSize(400, 300);
				frame.setLocationRelativeTo(null);
				panel = new JPanel(new GridBagLayout());
				
				c.gridx = 0;
			    c.gridy = 1;
		        panel.add(tip_bilet1, c);
		        c.gridx = 0;
		        c.gridy = 2;
			    panel.add(pret1, c);
		        c.gridx = 0;
		        c.gridy = 3;
		        panel.add(disponibile1, c);
		        c.gridx = 0;
		        c.gridy = 6;
		        panel.add(vandute1, c);
		        c.gridx = 1;
		        c.gridy = 1;
		        panel.add(t_tip_bilet1, c);
		        c.gridx = 1;
		        c.gridy = 2;
		        panel.add(t_pret1, c);
		        c.gridx = 1;
		        c.gridy = 3;
		        panel.add(t_disponibile1, c);
		        c.gridx = 1;
		        c.gridy = 6;
		        panel.add(t_vandute1, c);
			      
			     c.gridx = 0;
			     c.gridy = 9;
			     panel.add(buton,c);
			     c.gridx = 1;
			     c.gridy = 9;
			    panel.add(buton1,c);
		        frame.setContentPane(panel);
				frame.setVisible(true);
			}
		}
		ActionListener listener4 = new UpdatePret();
		updateP.addActionListener(listener4);
		
		class UpdateDisponibile implements ActionListener{
			JPanel panel = new JPanel();
			private GridBagConstraints c = new GridBagConstraints();
			JLabel tip_bilet1 = new JLabel("INTRODUCETI TIP BILET:");
			JLabel pret1 = new JLabel("AFISARE PRET BILET:");
			JLabel disponibile1 = new JLabel("INTRODUCETI BILETE DISPONIBILE:");
			JLabel vandute1 = new JLabel("AFISARE BILETE VANDUTE:");
			
			JTextField t_tip_bilet1 = new JTextField(15);
			JTextField t_pret1 = new JTextField(15);
			JTextField t_disponibile1 = new JTextField(15);
			JTextField t_vandute1 = new JTextField(15);
			JButton buton = new JButton("Actualizeaza disponibile");
		    JButton buton1 = new JButton("Afisare bilet");
			JFrame frame = new JFrame("Introduceti tipul biletului:");
			
			class I1ButtonListener implements ActionListener{
		    	public void actionPerformed(ActionEvent event) {
						try{
							bilet1.setTip_bilet(t_tip_bilet1.getText());
							bilet1.setNr_disponibile(Integer.valueOf(t_disponibile1.getText()));
							AdministrareCasier.modificare_disp(bilet1.getNr_disponibile(), bilet1.getTip_bilet());
							JOptionPane.showMessageDialog(new JFrame(), "Actualizare efectuata!");
						}catch(AssertionError e){
							JOptionPane.showMessageDialog(null,e);
						}
					frame.dispose();
				}
		    	
		    }
		    
		    class IButton1Listener implements ActionListener{
		    	public void actionPerformed(ActionEvent event) {
						try{
							Bilet b  = AdministrareCasier.cauta_pret(t_tip_bilet1.getText());
				        	t_tip_bilet1.setText(b.getTip_bilet());
				        	t_pret1.setText(String.valueOf(b.getPret()));
				        	t_disponibile1.setText(String.valueOf(b.getNr_disponibile()));
				        	t_vandute1.setText(String.valueOf(b.getBilete_vandute()));
						}catch(AssertionError e){
							JOptionPane.showMessageDialog(null,e);
						}
				}
		    }
			
		   public void actionPerformed(ActionEvent event) {
				buton.setBackground(Color.MAGENTA);
				buton.setSize(40, 40);
				buton1.setBackground(Color.MAGENTA);
				buton1.setSize(40, 40);
				ActionListener listener_but = new I1ButtonListener();
				buton.addActionListener(listener_but);
				ActionListener listener_but1 = new IButton1Listener();
				buton1.addActionListener(listener_but1);
				frame.setSize(400, 300);
				frame.setLocationRelativeTo(null);
				panel = new JPanel(new GridBagLayout());
				
				c.gridx = 0;
			    c.gridy = 1;
		        panel.add(tip_bilet1, c);
		        c.gridx = 0;
		        c.gridy = 2;
			    panel.add(pret1, c);
		        c.gridx = 0;
		        c.gridy = 3;
		        panel.add(disponibile1, c);
		        c.gridx = 0;
		        c.gridy = 6;
		        panel.add(vandute1, c);
		        c.gridx = 1;
		        c.gridy = 1;
		        panel.add(t_tip_bilet1, c);
		        c.gridx = 1;
		        c.gridy = 2;
		        panel.add(t_pret1, c);
		        c.gridx = 1;
		        c.gridy = 3;
		        panel.add(t_disponibile1, c);
		        c.gridx = 1;
		        c.gridy = 6;
		        panel.add(t_vandute1, c);
			      
			     c.gridx = 0;
			     c.gridy = 9;
			     panel.add(buton,c);
			     c.gridx = 1;
			     c.gridy = 9;
			    panel.add(buton1,c);
		        frame.setContentPane(panel);
				frame.setVisible(true);
			}
		}
		ActionListener listener5 = new UpdateDisponibile();
		updateD.addActionListener(listener5);
		
		class UpdateCapacitate implements ActionListener{
			JPanel panel = new JPanel();
			private GridBagConstraints c = new GridBagConstraints();
			JLabel nr_sali = new JLabel("AFISARE NR SALI:");
			JLabel ziua = new JLabel("INTRODUCETI ZIUA:");
			JLabel capacitate = new JLabel("INTRODUCETI CAPACITATE MAX:");
			
			JTextField t_sali = new JTextField(15);
			JTextField t_ziua = new JTextField(15);
			JTextField t_capacitate = new JTextField(15);
			JButton buton = new JButton("Actualizeaza capacitate");
		    JButton buton1 = new JButton("Afisare");
			JFrame frame = new JFrame("Introduceti ziua:");
			
			class I1ButtonListener implements ActionListener{
		    	public void actionPerformed(ActionEvent event) {
						try{
							conferinta.setZiua(t_ziua.getText());
							conferinta.setCapacitate_maxima(Integer.valueOf(t_capacitate.getText()));
							AdministrareCasier.modificare_cap(conferinta.getZiua(), conferinta.getCapacitate_maxima());
							JOptionPane.showMessageDialog(new JFrame(), "Actualizare efectuata!");
						}catch(AssertionError e){
							JOptionPane.showMessageDialog(null,e);
						}
					frame.dispose();
				}
		    	
		    }
		    
		    class IButton1Listener implements ActionListener{
		    	public void actionPerformed(ActionEvent event) {
						try{
							Conferinta con  = AdministrareCasier.afis_con(t_ziua.getText());
				        	t_sali.setText(String.valueOf(con.getNr_sali()));
				        	
						}catch(AssertionError e){
							JOptionPane.showMessageDialog(null,e);
						}
				}
		    }
			
		   public void actionPerformed(ActionEvent event) {
				buton.setBackground(Color.MAGENTA);
				buton.setSize(40, 40);
				buton1.setBackground(Color.MAGENTA);
				buton1.setSize(40, 40);
				ActionListener listener_but = new I1ButtonListener();
				buton.addActionListener(listener_but);
				ActionListener listener_but1 = new IButton1Listener();
				buton1.addActionListener(listener_but1);
				frame.setSize(400, 300);
				frame.setLocationRelativeTo(null);
				panel = new JPanel(new GridBagLayout());
				
				c.gridx = 0;
			    c.gridy = 1;
		        panel.add(nr_sali, c);
		        c.gridx = 0;
		        c.gridy = 2;
			    panel.add(ziua, c);
		        c.gridx = 0;
		        c.gridy = 3;
		        panel.add(capacitate, c);
		        c.gridx = 1;
		        c.gridy = 1;
		        panel.add(t_sali, c);
		        c.gridx = 1;
		        c.gridy = 2;
		        panel.add(t_ziua, c);
		        c.gridx = 1;
		        c.gridy = 3;
		        panel.add(t_capacitate, c);
			      
			     c.gridx = 0;
			     c.gridy = 9;
			     panel.add(buton,c);
			     c.gridx = 1;
			     c.gridy = 9;
			    panel.add(buton1,c);
		        frame.setContentPane(panel);
				frame.setVisible(true);
			}
		}
		ActionListener listener6 = new UpdateCapacitate();
		updateC.addActionListener(listener6);
		
		class StergereCasier implements ActionListener{
			JPanel panel = new JPanel();
			private GridBagConstraints c = new GridBagConstraints();
			
			JLabel id_casier = new JLabel("ID CASIER:");
			JLabel tip_bilet = new JLabel("TIP BILET:");
			JTextField t_id_casier = new JTextField(15);
			JTextField t_tip_bilet = new JTextField(15);
		    JButton buton = new JButton("Stergere client");
			JFrame frame = new JFrame("Introduceti id-ul clientului: ");
			
		    class IButtonListener implements ActionListener{
		    	public void actionPerformed(ActionEvent event) {
						try{
							AdministrareCasier.stergere_cas(Integer.valueOf(t_id_casier.getText()), t_tip_bilet.getText());
							JOptionPane.showMessageDialog(new JFrame(), "Stergere efectuata!");
						}catch(AssertionError e){
							JOptionPane.showMessageDialog(null,e);
						}
					frame.dispose();
				}
		    	
		    }
			
		   public void actionPerformed(ActionEvent event) {
				buton.setBackground(Color.ORANGE);
				buton.setSize(40, 40);
				ActionListener listener = new IButtonListener();
				buton.addActionListener(listener);
				frame.setSize(400, 300);
				frame.setLocationRelativeTo(null);
				panel = new JPanel(new GridBagLayout());
				
				c.gridx = 0;
			    c.gridy = 0;
		        panel.add(id_casier, c);
		        c.gridx = 0;
			    c.gridy = 2;
		        panel.add(tip_bilet, c);
		        c.gridx = 1;
		        c.gridy = 0;
		        panel.add(t_id_casier, c);
		        c.gridx = 1;
		        c.gridy = 2;
		        panel.add(t_tip_bilet, c);
		        
		        c.gridx = 1;
		        c.gridy = 4;
		        panel.add(buton,c);
		        frame.setContentPane(panel);
				frame.setVisible(true);
			}
		}
		ActionListener listener7 = new StergereCasier();
		stergereC.addActionListener(listener7);
		
		
		class IButtonListener1 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					int nr = AdministrareBilete.raport_incasari();
					JOptionPane.showMessageDialog(new JFrame(), nr);
     
			}catch(AssertionError e1){
				JOptionPane.showMessageDialog(null,e1);
			}
		}
	    	
	   }
		
	ActionListener listener8 = new IButtonListener1();
	raportTotale.addActionListener(listener8);
	
	class RaportCasier implements ActionListener{
		JPanel panel = new JPanel();
		private GridBagConstraints c = new GridBagConstraints();
		
		JLabel id_casier = new JLabel("ID CASIER:");
		JLabel tip_bilet = new JLabel("TIP BILET:");
		JTextField t_id_casier = new JTextField(15);
		JTextField t_tip_bilet = new JTextField(15);
	    JButton buton = new JButton("Raport casier");
		JFrame frame = new JFrame("Introduceti id-ul casierului si ziua dorita: ");
		
	    class IButtonListener implements ActionListener{
	    	public void actionPerformed(ActionEvent event) {
					try{
						int nr = AdministrareCasier.raport_casier(Integer.valueOf(t_id_casier.getText()), t_tip_bilet.getText());
						JOptionPane.showMessageDialog(new JFrame(), nr);
					}catch(AssertionError e){
						JOptionPane.showMessageDialog(null,e);
					}
				frame.dispose();
			}
	    	
	    }
		
	   public void actionPerformed(ActionEvent event) {
			buton.setBackground(Color.ORANGE);
			buton.setSize(40, 40);
			ActionListener listener = new IButtonListener();
			buton.addActionListener(listener);
			frame.setSize(400, 300);
			frame.setLocationRelativeTo(null);
			panel = new JPanel(new GridBagLayout());
			
			c.gridx = 0;
		    c.gridy = 0;
	        panel.add(id_casier, c);
	        c.gridx = 0;
		    c.gridy = 2;
	        panel.add(tip_bilet, c);
	        c.gridx = 1;
	        c.gridy = 0;
	        panel.add(t_id_casier, c);
	        c.gridx = 1;
	        c.gridy = 2;
	        panel.add(t_tip_bilet, c);
	        
	        c.gridx = 1;
	        c.gridy = 4;
	        panel.add(buton,c);
	        frame.setContentPane(panel);
			frame.setVisible(true);
		}
	}
	ActionListener listener9 = new RaportCasier();
	raportC.addActionListener(listener9);
	
	
	class RaportZi implements ActionListener{
		JPanel panel = new JPanel();
		private GridBagConstraints c = new GridBagConstraints();
		
		JLabel tip_bilet = new JLabel("TIP BILET:");
		JTextField t_tip_bilet = new JTextField(15);
	    JButton buton = new JButton("Raport incasari pe o zi");
		JFrame frame = new JFrame("Introduceti ziua dorita: ");
		
	    class IButtonListener implements ActionListener{
	    	public void actionPerformed(ActionEvent event) {
					try{
						int nr = AdministrareBilete.raport_zi(t_tip_bilet.getText());
						JOptionPane.showMessageDialog(new JFrame(), nr);
					}catch(AssertionError e){
						JOptionPane.showMessageDialog(null,e);
					}
				frame.dispose();
			}
	    	
	    }
		
	   public void actionPerformed(ActionEvent event) {
			buton.setBackground(Color.ORANGE);
			buton.setSize(40, 40);
			ActionListener listener = new IButtonListener();
			buton.addActionListener(listener);
			frame.setSize(400, 300);
			frame.setLocationRelativeTo(null);
			panel = new JPanel(new GridBagLayout());
			
	        c.gridx = 0;
		    c.gridy = 2;
	        panel.add(tip_bilet, c);
	        c.gridx = 1;
	        c.gridy = 2;
	        panel.add(t_tip_bilet, c);
	        
	        c.gridx = 1;
	        c.gridy = 4;
	        panel.add(buton,c);
	        frame.setContentPane(panel);
			frame.setVisible(true);
		}
	}
	ActionListener listener10 = new RaportZi();
	raportZi.addActionListener(listener10);
	
	class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			f.dispose();
		}
	}     
	ActionListener listener11 = new ExitListener();
	inchide.addActionListener(listener11);
	}
	
}
