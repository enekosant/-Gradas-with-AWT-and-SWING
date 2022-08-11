package clases;

import javax.swing.*;

public class Frame extends JFrame
{
	//atributos
	private static final long serialVersionUID = 1L;
	private JPanel laminaActual;
	
	//constructora
	public Frame() 
	{
		setTitle("Gradas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
	}
	
	public void ponerLamina(JPanel lamina) 
	{
		this.laminaActual=lamina;
		add(lamina);
	}
	
	public void quitarLamina(JPanel lamina) 
	{
		this.laminaActual=null;
		remove(lamina);
	}
	
	public JPanel devolverLamina() 
	{
		return this.laminaActual;
	}
}