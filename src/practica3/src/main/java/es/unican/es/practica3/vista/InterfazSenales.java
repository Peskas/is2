package es.unican.es.practica3.vista;

import java.awt.GraphicsConfiguration;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import es.unican.es.practica3.controlador.AlarmaHogar;

public class InterfazSenales extends JFrame{
	private static final long serialVersionUID = 1L;
    
    private AlarmaHogar alarma;
    
	public InterfazSenales(AlarmaHogar a) {
        alarma = a;
        init();
        mostrar();
	}
	
	private void init() {
		JPanel panel = new JPanel();
        this.setTitle("Senhales");                   			// colocamos titulo a la ventana
        this.setSize(180, 180);                                 // colocamos tamanio a la ventana (ancho, alto)
        setLocationToTopRight(this);
        //this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setAlwaysOnTop(true);
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
  
		// creamos los componentes
		panel.setLayout(null);
		
		JButton jbInt = new JButton("Intruso");
		jbInt.setBounds(15,10,150,50);
		jbInt.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	alarma.intruso();
		    }
		});
		panel.add(jbInt);
				
		JButton jbOff = new JButton("OFF");
		jbOff.setBounds(15,70,150,50);
		jbOff.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	alarma.off();
		    }
		});
		panel.add(jbOff);
		this.getContentPane().add(panel);
    }
	
	public void mostrar() {
		this.setVisible(true);
	}
	
	static void setLocationToTopRight(JFrame frame) {
	    GraphicsConfiguration config = frame.getGraphicsConfiguration();
	    Rectangle bounds = config.getBounds();
	    Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(config);

	    int x = bounds.x + bounds.width - insets.right - frame.getWidth()*2 + 50;
	    int y = bounds.y + insets.top + frame.getHeight() + 20;
	    frame.setLocation(x, y);
	}
}
