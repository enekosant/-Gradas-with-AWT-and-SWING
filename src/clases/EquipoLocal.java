package clases;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class EquipoLocal extends JPanel 
{
	//atributos
	private static final long serialVersionUID = 1L;
	private String fichero;
	private AccionBotonesEquipoLocal aBoton;
	private Frame frame;
	
	//constructra
	public EquipoLocal(String fichero,Frame frame) 
	{
		this.frame=frame;
		aBoton = new AccionBotonesEquipoLocal();
		this.fichero=fichero;
		setLayout(new BorderLayout(10,10));
		JButton titulo = new JButton("Selecciona el equipo local");
		titulo.setEnabled(false);
		titulo.setBorderPainted(false);
		Font fuente = new Font("Verdana",Font.BOLD,60);
		Font fuenteBoton = new Font("Verdana",Font.PLAIN,20);
		titulo.setFont(fuente);
		add(titulo,BorderLayout.NORTH);
		JPanel display = new JPanel();
		add(display,BorderLayout.CENTER);
		display.setLayout(new GridLayout(7,6,10,10));
		try 
		{
			anadirBotones(display,aBoton,fuenteBoton);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("No encontrado");
		}
		JButton salir = new JButton("Salir");
		salir.addActionListener(aBoton);
		Font fuenteInferior = new Font("Verdana",Font.PLAIN,30);
		salir.setFont(fuenteInferior);
		JButton atras = new JButton("Volver atras");
		atras.addActionListener(aBoton);
		atras.setFont(fuenteInferior);
		JPanel menuInf = new JPanel();
		menuInf.setLayout(new BorderLayout());
		menuInf.add(atras,BorderLayout.NORTH);
		menuInf.add(salir,BorderLayout.SOUTH);
		add(menuInf,BorderLayout.SOUTH);
	}
	
	//otros metodos
	public void anadirBotones(JPanel display,AccionBotonesEquipoLocal aBoton,Font f) throws FileNotFoundException
	{
		int numero = 0;
		Scanner sc = new Scanner(new File (this.fichero));
		sc.nextLine();
		numero = Integer.valueOf(sc.nextLine());
		for (int i = 0;i<numero;i++) 
		{
			String nombre = sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			JButton boton =new JButton (nombre);
			boton.addActionListener(aBoton);
			boton.setFont(f);
			display.add(boton);
		}
	}
	
	public void seleccionar() 
	{
		AccionBotonesMenu.reset();
		AccionBotonesCompeticiones.reset();
		AccionBotonesEquipoLocal.reset();
		AccionBotonesEquipoRival.reset();
		AccionBotonesPartido.reset();
		
		while(!AccionBotonesEquipoLocal.pulsado) 
		{
			this.esperar();
		}
		if(AccionBotonesEquipoLocal.volver) 
		{
			Competiciones competiciones = new Competiciones(this.frame);
			this.frame.quitarLamina(this.frame.devolverLamina());
			this.frame.ponerLamina(competiciones);
			this.frame.setVisible(true);
			competiciones.seleccionar();
		}
		else
		{
			EquipoRival equipo = new EquipoRival(this.fichero,this.frame);
			this.frame.quitarLamina(this.frame.devolverLamina());
			this.frame.ponerLamina(equipo);
			this.frame.setVisible(true);
			equipo.seleccionar();
		}
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