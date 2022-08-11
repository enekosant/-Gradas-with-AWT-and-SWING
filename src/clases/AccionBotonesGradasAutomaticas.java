package clases;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class AccionBotonesGradasAutomaticas extends AbstractAction
{
	private static final long serialVersionUID = 1L;
	static boolean pulsado=false;
	
	public AccionBotonesGradasAutomaticas() 
	{
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		AccionBotonesGradasAutomaticas.pulsado=true;
	}
	
	public static void reset()
	{
		AccionBotonesGradasAutomaticas.pulsado=false;
	}
}