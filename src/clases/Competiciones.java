package clases;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class Competiciones extends JPanel
{
	//atributos
	private static final long serialVersionUID = 1L;
	private String fichero = "./src/datos/competiciones.txt";
	private AccionBotonesCompeticiones aBoton;
	private Frame frame;
	private EquipoLocal equipos;
	
	
	//constructora
	public Competiciones(Frame frame) 
	{
		this.frame=frame;
		aBoton = new AccionBotonesCompeticiones();
		setLayout(new BorderLayout(10,10));
		JButton titulo = new JButton("Selecciona una competicion");
		titulo.setEnabled(false);
		titulo.setBorderPainted(false);
		Font fuente = new Font("Verdana",Font.BOLD,60);
		titulo.setFont(fuente);
		add(titulo,BorderLayout.NORTH);
		JPanel display = new JPanel();
		add(display,BorderLayout.CENTER);

		Font fuenteBoton = new Font("Verdana",Font.PLAIN,20);
		display.setLayout(new GridLayout(2,3,10,10));
		try 
		{
			anadirBotones(display,aBoton,fuenteBoton);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("No encontrado");
		}
		JButton salir = new JButton("Salir");
		salir.setFont(fuente);
		salir.addActionListener(aBoton);
		add(salir,BorderLayout.SOUTH);
	}
	
	//otros metodos
	public void anadirBotones(JPanel display, ActionListener e,Font f) throws FileNotFoundException 
	{
		int numero =0;
		Scanner sc = new Scanner(new File(this.fichero));
		sc.nextLine();
		numero = Integer.valueOf(sc.nextLine());
		for (int i = 0;i<numero;i++) 
		{
			String nombre = sc.nextLine();
			sc.nextLine();
			JButton boton =new JButton (nombre);
			boton.setFont(f);
			boton.addActionListener(e);
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
		while(!AccionBotonesCompeticiones.pulsado) 
		{
			this.esperar();
		}
		this.equipos = new EquipoLocal(AccionBotonesCompeticiones.fichero,this.frame);
		this.cambiarLamina();
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
	
	public void cambiarLamina() 
	{
		this.frame.quitarLamina(this.frame.devolverLamina());
		this.frame.ponerLamina(this.equipos);
		this.frame.setVisible(true);
		this.equipos.seleccionar();
	}
}