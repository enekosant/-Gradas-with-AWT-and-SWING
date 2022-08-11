package clases;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class AccionBotonesEquipoLocal extends AbstractAction
{
	//atributos
	private static final long serialVersionUID = 1L;
	static String equipo;
	static boolean volver=false;
	static boolean pulsado=false;

	//constructora
	public AccionBotonesEquipoLocal() 
	{

	}
	
	//otros metodos
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
				AccionBotonesEquipoLocal.volver=true;
				break;
			}
			default:
			{
				AccionBotonesEquipoLocal.equipo=nombre;
			}
			AccionBotonesEquipoLocal.pulsado=true;
		}
		AccionBotonesEquipoLocal.pulsado=true;
	}
	
	public static void reset() 
	{
		AccionBotonesEquipoLocal.volver=false;
		AccionBotonesEquipoLocal.pulsado=false;
	}
}