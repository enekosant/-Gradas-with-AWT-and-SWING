package clases;

import java.awt.*;
import javax.swing.*;

public class Partido extends JPanel
{
	//atributos
	private static final long serialVersionUID = 1L;
	private Frame frame;
	private AccionBotonesPartido aBoton;
	
	//constructora
	public Partido(Frame frame, DatosPartido datos) 
	{
		aBoton = new AccionBotonesPartido();
		this.frame=frame;
		
		setLayout(new BorderLayout());
		Font fuente = new Font("Verdana",Font.BOLD,55);
		JButton volver = new JButton("Volver");
		volver.setFont(fuente);
		volver.addActionListener(aBoton);
		JPanel central = new JPanel();
		add(volver,BorderLayout.SOUTH);
		add(central,BorderLayout.NORTH);
		central.setLayout(new BorderLayout());
		JButton relleno = new JButton();
		relleno.setPreferredSize(new Dimension(100,(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.185)));
		relleno.setEnabled(false);
		relleno.setBorderPainted(false);
		central.add(relleno, BorderLayout.NORTH);
		central.add(datos.getDatosPartido(), BorderLayout.CENTER);
	}
	
	//otros metodos	
	
	public void seleccionar() 
	{
		AccionBotonesCompeticiones.reset();
		AccionBotonesEquipoLocal.reset();
		AccionBotonesEquipoRival.reset();
		AccionBotonesGradasAutomaticas.reset();
		AccionBotonesMenu.reset();
		AccionBotonesPartido.reset();
		AccionBotonesGradasManuales.reset();
		
		while(!AccionBotonesPartido.pulsado) 
		{
			this.esperar();
		}
		
		this.frame.quitarLamina(this.frame.devolverLamina());
		Menu menu = new Menu(this.frame);
		this.frame.ponerLamina(menu);
		this.frame.setVisible(true);
		menu.seleccionar();
	}
	
	public void esperar() 
	{
		try
		{
		    Thread.sleep(0);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
	}
	

}