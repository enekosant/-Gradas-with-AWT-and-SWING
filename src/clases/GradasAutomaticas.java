package clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GradasAutomaticas extends JPanel 
{
	//atributos
	private static final long serialVersionUID = 1L;
	private int fila;
	private int columna;
	static int asistencia;
	private Frame frame;
	private AccionBotonesGradasAutomaticas aBoton;
	
	//constructora
	public GradasAutomaticas(Frame frame, DatosPartido datos) 
	{
		this.frame=frame;
		this.fila=15;
		this.columna=100;
		this.aBoton=new AccionBotonesGradasAutomaticas();	
		GradasAutomaticas.asistencia=0;
		setLayout(new BorderLayout(5,5));
		JButton volver = new JButton("Volver");
		Font fuente = new Font("Verdana",Font.BOLD,60);
		volver.setFont(fuente);
		volver.addActionListener(aBoton);
		add(volver,BorderLayout.SOUTH);
		
		JPanel display = new JPanel();
		display.setLayout(new BorderLayout(0,5));
		add(display,BorderLayout.CENTER);
		
		display.add(datos.getDatosPartido(),BorderLayout.CENTER);
		JPanel gradaSup = new JPanel();
		gradaSup.setLayout(new GridLayout(this.fila,this.columna,2,2));
		JPanel gradaInf = new JPanel();
		gradaInf.setLayout(new GridLayout(this.fila,this.columna,2,2));
	
		
		display.add(gradaSup,BorderLayout.NORTH);
		this.anadirBotonesHorizontales(gradaSup);
		display.add(gradaInf,BorderLayout.SOUTH);
		this.anadirBotonesHorizontales(gradaInf);
		
		DatosPartido.asistencia = asistencia;
		datos.cambiarAsistencia();
		datos.repaint();
		frame.repaint();
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
		
		while(!AccionBotonesGradasAutomaticas.pulsado) 
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
	
	public void anadirBotonesHorizontales(JPanel lamina) 
	{
		int numero = this.fila*this.columna;
		
		for(int i = 0;i<numero;i++) 
		{
			int aleatorio = new Random().nextInt(10);
			JButton asiento = new JButton();
			Dimension dBotones = new Dimension(9,9);
			asiento.setPreferredSize(dBotones);
			asiento.setEnabled(false);
			if(aleatorio==1||aleatorio==5||aleatorio==8) 
			{
				asiento.setBackground(Color.GREEN);
			}
			else
			{
				asiento.setBackground(Color.RED);
				GradasAutomaticas.asistencia++;
			}
			lamina.add(asiento);
		}
	}
}