package clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GradasManuales extends JPanel
{
	//atributos
	private static final long serialVersionUID = 1L;
	private Frame frame; 
	private int fila;
	private int columna;
	private AccionBotonesGradasManuales aBoton;
	static int asistencia;
	
	//constructora
	public GradasManuales(Frame frame, DatosPartido datos) 
	{
		this.frame=frame;
		this.aBoton=new AccionBotonesGradasManuales(datos, frame);
		this.fila=15;
		this.columna=100;
		asistencia = 0;
		setLayout(new BorderLayout());
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
		this.anadirBotonesHorizontales(gradaSup,this.aBoton);
		display.add(gradaInf,BorderLayout.SOUTH);
		this.anadirBotonesHorizontales(gradaInf,this.aBoton);
	}
	
	public void anadirBotonesHorizontales(JPanel lamina,AccionBotonesGradasManuales aBoton) 
	{
		int numero = this.fila*this.columna;
		
		for(int i=0;i<numero;i++) 
		{
			JButton asiento = new JButton();
			Dimension dBotones =new Dimension(9,9);
			asiento.setPreferredSize(dBotones);
			asiento.setBackground(Color.GREEN);
			asiento.addActionListener(aBoton);
			lamina.add(asiento);
		}
	}
	
	public void seleccionar() 
	{
		JOptionPane.showMessageDialog(frame, "Haz click en los asientos que quieras obtener", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		
		AccionBotonesCompeticiones.reset();
		AccionBotonesEquipoLocal.reset();
		AccionBotonesEquipoRival.reset();
		AccionBotonesGradasAutomaticas.reset();
		AccionBotonesMenu.reset();
		AccionBotonesPartido.reset();
		AccionBotonesGradasManuales.reset();
		
		while(!AccionBotonesGradasManuales.pulsado) 
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