package clases;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EquipoRival extends JPanel
{
	//atributos
	private static final long serialVersionUID = 1L;
	private String fichero;
	private Frame frame;
	private AccionBotonesEquipoRival aBoton;
	
	//constructora
	public EquipoRival(String fichero,Frame frame) 
	{
		this.fichero=fichero;
		this.frame=frame;
		aBoton = new AccionBotonesEquipoRival();
		setLayout(new BorderLayout(10,10));
		JButton titulo = new JButton("Selecciona el equipo rival");
		titulo.setEnabled(false);
		titulo.setBorderPainted(false);
		Font fuente = new Font("Verdana",Font.BOLD,60);
		titulo.setFont(fuente);
		add(titulo,BorderLayout.NORTH);
		JPanel display = new JPanel();
		add(display,BorderLayout.CENTER);
		display.setLayout(new GridLayout(7,6,10,10));
		Font fuenteBoton = new Font("Verdana",Font.PLAIN,20);
		try
		{
			this.anadirBotones(display, aBoton, fuenteBoton);
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
	
	public void anadirBotones(JPanel display, AccionBotonesEquipoRival aBoton,Font f)throws FileNotFoundException
	{
		int numero=0;
		Scanner sc = new Scanner (new File(this.fichero));
		sc.nextLine();
		numero = Integer.valueOf(sc.nextLine());
		for (int i = 0; i<numero; i++) 
		{
			String nombre = sc.nextLine();
			String eLocal=AccionBotonesEquipoLocal.equipo;
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			if(!nombre.equals(eLocal)) 
			{
				JButton boton = new JButton(nombre);
				boton.addActionListener(aBoton);
				boton.setFont(f);
				display.add(boton);
			}
		}
	}
	
	public void seleccionar() 
	{
		AccionBotonesMenu.reset();
		AccionBotonesCompeticiones.reset();
		AccionBotonesEquipoLocal.reset();
		AccionBotonesEquipoRival.reset();
		AccionBotonesPartido.reset();
		while(!AccionBotonesEquipoRival.pulsado) 
		{
			this.esperar();
		}
		if(AccionBotonesEquipoRival.volver) 
		{
			EquipoLocal eLocal = new EquipoLocal(this.fichero,this.frame);
			this.frame.quitarLamina(this.frame.devolverLamina());
			this.frame.ponerLamina(eLocal);
			this.frame.setVisible(true);
			eLocal.seleccionar();
		}
		else
		{
			Menu menu = new Menu(this.frame);
			this.frame.quitarLamina(this.frame.devolverLamina());
			this.frame.ponerLamina(menu);
			this.frame.setVisible(true);
			menu.seleccionar();
			
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