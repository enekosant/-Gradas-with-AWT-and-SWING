package clases;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class AccionBotonesGradasManuales extends AbstractAction
{
	private static final long serialVersionUID = 1L;
	static boolean pulsado=true;
	private DatosPartido datos;
	private Frame frame;
	
	public AccionBotonesGradasManuales(DatosPartido datos, Frame frame) 
	{
		this.datos = datos;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Volver")) 
		{
			AccionBotonesGradasManuales.pulsado=true;
		}
		else 
		{
			JButton boton = (JButton) e.getSource();
			boton.setBackground(Color.RED);
			GradasManuales.asistencia++;
			boton.setEnabled(false);
			DatosPartido.asistencia = GradasManuales.asistencia;	
			datos.cambiarAsistencia();
			System.out.println(DatosPartido.asistencia);
			datos.repaint();
			frame.repaint();
			JOptionPane.showMessageDialog(frame, "Asiento obtenido con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void reset() 
	{
		AccionBotonesGradasManuales.pulsado=false;
	}
}