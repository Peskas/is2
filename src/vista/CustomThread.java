package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import controlador.AlarmaHogar;

import javax.swing.JLabel;

class CustomThread extends Thread 
{
	private Timer timer;
    private JLabel jLabel;
    private JLabel jLabel2;
    private boolean flag = true;
    AlarmaHogar alarma;

    public CustomThread(JLabel jl, JLabel jl2, AlarmaHogar a)
    {
        jLabel = jl;
        jLabel2 = jl2;
        alarma = a;
        
        int t = 3000; 
        this.timer = new Timer (t, new ActionListener ()
        {
            public void actionPerformed(ActionEvent e)
            {
         	   alarma.setMsg(" ");
             }
        });
        
    }   

    public void setFlagValue(boolean flag)
    {
        this.flag = flag;
    }

    @Override
    public void run()
    {
        while (flag)
        {
            EventQueue.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                   jLabel.setText(alarma.getEstado().getClass().getSimpleName());
        
                   jLabel2.setText(alarma.getMsg());
                   
                   timer.start();
                   
				         
                   
                }
            });

            try
            {
                Thread.sleep(10);
            }
            catch(InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
        System.out.println("I am OUT of WHILE");
    }    
}