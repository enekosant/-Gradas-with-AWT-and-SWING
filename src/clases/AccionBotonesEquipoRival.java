package clases;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.AbstractAction;

public class AccionBotonesEquipoRival extends AbstractAction
{
	//atributos
	private static final long serialVersionUID = 1L;
	static String equipo;
	static boolean volver=false;
	static boolean pulsado=false;
	static String tiempo;

	//constructora
	public void actionPerformed(ActionEvent e) 
	{
		String nombre = e.getActionCommand();
		switch(nombre) 
		{
			case("Salir"):
			{
				System.exit(0);
				break;
			}
			case("Volver atras"):
			{
				AccionBotonesEquipoRival.volver=true;
				break;
			}
			default:
			{
				AccionBotonesEquipoRival.equipo=nombre;
			}
			AccionBotonesEquipoRival.pulsado=true;
		}
		AccionBotonesEquipoRival.pulsado=true;
		
		Scanner sc = null;
		try 
		{
			sc = new Scanner(new File("./src/datos/CondicionesMeteorologicas.txt"));
		} 
		catch (FileNotFoundException ex) 
		{
			ex.printStackTrace();
		}

		int numero = Integer.valueOf(sc.nextLine());
		int cond = new Random().nextInt(numero);
		for(int i=0;i<numero;i++) 
		{
			if(i==cond) 
			{
				tiempo = sc.nextLine();
			}
			else
			{
				sc.nextLine();
			}
		}
	}
	
	public static void reset() 
	{
		AccionBotonesEquipoRival.volver=false;
		AccionBotonesEquipoRival.pulsado=false;
	}
}