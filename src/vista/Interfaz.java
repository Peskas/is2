package vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;

import diseno.*;
import estados.*;

public class Interfaz extends JFrame implements PropertyChangeListener{
	private static final long serialVersionUID = 1L;
	private AlarmaHogar alarma;
	Canvas piloto = new Canvas();

	public Interfaz ( AlarmaHogar al ) {
		alarma = al;
		alarma.addPropertyChangeListener(this);
		init();
	}
	
	public void init() {
		// Creacion this y panel
		//JFrame this = new JFrame("Alarma del hogar");
		JPanel panel = new JPanel();
        
        // Centrado y dimensiones
		this.setTitle("Contrasenha: 1234");
		this.setSize(600, 360);
        this.setLocationRelativeTo(null);
		panel.setLayout(null);
		
		// Pantalla contrasena
		JTextField jt1=new JTextField();
		//Font font = new Font("LCD", Font.BOLD,12);
		//jt1.setFont(font);
        jt1.setBounds(50,40,170,40);
        jt1.setEditable(false);
        jt1.setHorizontalAlignment(JTextField.CENTER);
        panel.add(jt1);
		
        // Estado actual
        JLabel jl1=new JLabel();
		jl1.setBounds(280,20,200,40);
        jl1.setHorizontalAlignment(JLabel.CENTER);
        panel.add(jl1);
        
        // Indicador contrasena
        JLabel jl2=new JLabel();
        jl2.setBounds(260,280,250,40);
        jl2.setHorizontalAlignment(JLabel.CENTER);
        panel.add(jl2);
        
        
        // Listener de estado
        CustomThread cThread = new CustomThread(jl1,jl2,alarma);
        cThread.setFlagValue(true);
        cThread.start();
        
        //  Piloto
        piloto.setBounds(330,100,100,50);
        panel.add(piloto);
		if (alarma.getEstado() instanceof Apagada) {
			piloto.setBackground(Color.red);
		}
        
		// Botones
		JButton jb1 = new JButton("1");
		jb1.setBounds(50,90,50,50);
		jb1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	concJText(jt1,"1");
		    }
		});
		panel.add(jb1);
		
		JButton jb2 = new JButton("2");
		jb2.setBounds(110,90,50,50);
		jb2.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	concJText(jt1,"2");
		    }
		});
		panel.add(jb2);
		
		JButton jb3 = new JButton("3");
		jb3.setBounds(170,90,50,50);
		jb3.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	concJText(jt1,"3");
		    }
		});
		panel.add(jb3);
		
		JButton jb4 = new JButton("4");
		jb4.setBounds(50,150,50,50);
		jb4.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	concJText(jt1,"4");
		    }
		});
		panel.add(jb4);
		
		JButton jb5 = new JButton("5");
		jb5.setBounds(110,150,50,50);
		jb5.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	concJText(jt1,"5");
		    }
		});
		panel.add(jb5);
		
		JButton jb6 = new JButton("6");
		jb6.setBounds(170,150,50,50);
		jb6.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	concJText(jt1,"6");
		    }
		});
		panel.add(jb6);
		
		JButton jb7 = new JButton("7");
		jb7.setBounds(50,210,50,50);
		jb7.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	concJText(jt1,"7");
		    }
		});
		panel.add(jb7);
		
		JButton jb8 = new JButton("8");
		jb8.setBounds(110,210,50,50);
		jb8.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	concJText(jt1,"8");
		    }
		});
		panel.add(jb8);
		
		JButton jb9 = new JButton("9");
		jb9.setBounds(170,210,50,50);
		jb9.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	concJText(jt1,"9");
		    }
		});
		panel.add(jb9);
		
		JButton jbDel = new JButton("Delete");
		jbDel.setBounds(85,270,100,30);
		jbDel.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	blankJText(jt1);
		    }
		});
		panel.add(jbDel);
		
		JButton jbAlarmaOn = new JButton("Alarma On");
		jbAlarmaOn.setBounds(280,180,200,30);
		jbAlarmaOn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	alarma.alarmaOn();
		    }
		});
		panel.add(jbAlarmaOn);
		
		JButton jbAlarmaOff = new JButton("Alarma Off");
		jbAlarmaOff.setBounds(280,220,200,30);
		jbAlarmaOff.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	alarma.setCodigoIntroducido(getJText(jt1));
		    	blankJText(jt1);
				alarma.alarmaOff();
		    }
		});
		panel.add(jbAlarmaOff);
		
		
        this.getContentPane().add(panel);
		this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void concJText(JTextField jt, String t) {
		String text = jt.getText()+t;
		if(text.length()<=4) {
			jt.setText(text);
		} else {
			jt.setText(t);
		}
	}
	
	public static String getJText(JTextField jt) {
		return jt.getText();
	}
	
	public void blankJText(JTextField jt) {
		jt.setText("");
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("estado")) {
			if (alarma.getEstado() instanceof Apagada) {
				piloto.setBackground(Color.red);
			} else if (alarma.getEstado() instanceof Activada) {
				piloto.setBackground(Color.green);
			} else if (alarma.getEstado() instanceof EsperandoSalida) {
				piloto.setBackground(Color.orange);
				
			}
		}
	}
}