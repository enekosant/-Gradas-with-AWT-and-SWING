package clases;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class AccionBotonesMenu extends AbstractAction
{
	//atributos
	private static final long serialVersionUID = 1L;
	static int opcion;
	static boolean pulsado=false;
	
	//constructora
	public AccionBotonesMenu() 
	{
		
	}
	
	//otros metodos
	public void actionPerformed(ActionEvent e) 
	{
		String nombre = e.getActionCommand();
		
		switch (nombre) 
		{
			case("Volver a introducir datos"):
			{
				AccionBotonesMenu.opcion = 1;
				break;
			}
			
			case ("Mostrar datos del partido"):
			{
				AccionBotonesMenu.opcion=2;
				break;
			}
			
			case ("Simular llenado de gradas automatico"):
			{
				AccionBotonesMenu.opcion = 3;
				break;
			}
			
			case ("Introducir espectadores manualmente"):
			{
				AccionBotonesMenu.opcion = 4;
				break;
			}
			
			case ("Salir"):
			{
				System.exit(0);
				break;
			}
		}
		AccionBotonesMenu.pulsado=true;
	}
	
	public static void reset() 
	{
		AccionBotonesMenu.pulsado=false;
		AccionBotonesMenu.opcion=0;
	}
}