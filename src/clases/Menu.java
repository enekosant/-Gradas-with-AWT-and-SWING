package clases;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel
{
	//atributos
	private static final long serialVersionUID = 1L;
	private Frame frame;
	private AccionBotonesMenu aBoton;
	private DatosPartido dt;
	
	//contructora
	public Menu(Frame frame)
	{
		this.frame=frame;
	
		//this.dt = DatosPartido.getMiDatosPartido().getDatosPartido();
		this.dt = new DatosPartido();
		this.aBoton= new AccionBotonesMenu();
		
		setLayout(new BorderLayout(10,10));
		JButton titulo = new JButton("Menu principal");
		titulo.setEnabled(false);
		Font fuente = new Font("Verdana",Font.BOLD,60);
		Font fuenteBoton = new Font("Verdana",Font.PLAIN,20);
		titulo.setFont(fuente);
		titulo.setBorderPainted(false);
		add(titulo,BorderLayout.NORTH);
		JPanel display = new JPanel();
		add(display,BorderLayout.CENTER);
		display.setLayout(new GridLayout(4,1,10,10));	
		JButton inserDatosPartido = new JButton("Volver a introducir datos");
		inserDatosPartido.setFont(fuenteBoton);
		inserDatosPartido.addActionListener(aBoton);
		JButton mostrarPartido = new JButton("Mostrar datos del partido");
		mostrarPartido.setFont(fuenteBoton);
		mostrarPartido.addActionListener(aBoton);
		JButton simGrada = new JButton("Simular llenado de gradas automatico");
		simGrada.setFont(fuenteBoton);
		simGrada.addActionListener(aBoton);
		JButton introManualGrada = new JButton("Introducir espectadores manualmente");
		introManualGrada.setFont(fuenteBoton);
		introManualGrada.addActionListener(aBoton);
		JButton salir = new JButton("Salir");
		salir.setFont(fuente);
		salir.addActionListener(aBoton);
		
		display.add(inserDatosPartido);
		display.add(mostrarPartido);
		display.add(simGrada);
		display.add(introManualGrada);
		
		add(salir,BorderLayout.SOUTH);
	}
	
	//otros metodos
	public void seleccionar()
	{
		AccionBotonesCompeticiones.reset();
		AccionBotonesEquipoLocal.reset();
		AccionBotonesEquipoRival.reset();
		AccionBotonesGradasAutomaticas.reset();
		AccionBotonesMenu.reset();
		AccionBotonesPartido.reset();
		
		while(!AccionBotonesMenu.pulsado) 
		{
			this.esperar();
		}

		switch(AccionBotonesMenu.opcion) 
		{
			case(1):
			{
				Competiciones comp = new Competiciones(this.frame);
				this.frame.quitarLamina(this.frame.devolverLamina());
				this.frame.ponerLamina(comp);
				this.frame.setVisible(true);
				comp.seleccionar();
				break;
			}
			case(2):
			{
				
				this.frame.quitarLamina(this.frame.devolverLamina());
				Partido partido = new Partido(frame, dt);
				this.frame.ponerLamina(partido);
				this.frame.setVisible(true);
				partido.seleccionar();
				break;
			}
			case(3):
			{
				DatosPartido.asistencia = 0;
				dt.cambiarAsistencia();
				this.frame.quitarLamina(this.frame.devolverLamina());
				GradasAutomaticas gradasA = new GradasAutomaticas(frame, dt);
				this.frame.ponerLamina(gradasA);
				this.frame.setVisible(true);
				gradasA.seleccionar();
				break;
			}
			case(4):
			{
				DatosPartido.asistencia = 0;
				dt.cambiarAsistencia();
				this.frame.quitarLamina(this.frame.devolverLamina());
				GradasManuales gradasM = new GradasManuales(frame, dt);
				this.frame.ponerLamina(gradasM);
				this.frame.setVisible(true);
				gradasM.seleccionar();
				break;
			}
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
