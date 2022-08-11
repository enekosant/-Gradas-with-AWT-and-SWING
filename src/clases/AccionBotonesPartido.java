package clases;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class AccionBotonesPartido extends AbstractAction
{
	private static final long serialVersionUID = 1L;
	static boolean pulsado=false;
	
	public AccionBotonesPartido() 
	{
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		AccionBotonesPartido.pulsado=true;
	}
	
	public static void reset() 
	{
		AccionBotonesPartido.pulsado=false;
	}
}