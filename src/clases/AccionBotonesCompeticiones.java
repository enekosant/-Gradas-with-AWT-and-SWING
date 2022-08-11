package clases;

import java.awt.event.*;
import javax.swing.AbstractAction;

public class AccionBotonesCompeticiones extends AbstractAction
{	

	private static final long serialVersionUID = 1L;
	static String fichero;
	static String competicion;
	static boolean pulsado=false;
	
	
	public AccionBotonesCompeticiones() 
	{
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		String nombre = e.getActionCommand();
		
		switch(nombre) 
		{
			case("Liga Santander"):
			{
				AccionBotonesCompeticiones.competicion=nombre;
				AccionBotonesCompeticiones.fichero="./src/datos/equiposLS.txt";
				break;
			}
			case("Liga SmartBank"):
			{
				AccionBotonesCompeticiones.competicion=nombre;
				AccionBotonesCompeticiones.fichero="./src/datos/equiposSB.txt";
				break;
			}
			case("Copa del Rey"):
			{
				AccionBotonesCompeticiones.competicion=nombre;
				AccionBotonesCompeticiones.fichero="./src/datos/equiposCopa.txt";
				break;
			}
			case("UEFA Champions League"):
			{
				AccionBotonesCompeticiones.competicion=nombre;
				AccionBotonesCompeticiones.fichero="./src/datos/equiposUCL.txt";
				break;
			}
			case("UEFA Europa League"):
			{
				AccionBotonesCompeticiones.competicion=nombre;
				AccionBotonesCompeticiones.fichero="./src/datos/equiposUEL.txt";
				break;
			}
			case("Salir"):
			{
				System.exit(0);
				break;
			}
		}
		AccionBotonesCompeticiones.pulsado=true;
	}
	
	public static void reset() 
	{
		AccionBotonesCompeticiones.pulsado=false;
	}
}