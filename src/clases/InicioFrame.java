package clases;

public class InicioFrame 
{
	//atributos
	Frame frame = new Frame();
	Competiciones competiciones;
	
	//constrcutora
	public InicioFrame() 
	{
	}
	
	//otros metodos
	public void inicio() 
	{	
		this.competiciones=new Competiciones(this.frame);
		this.frame.ponerLamina(competiciones);
		this.frame.setVisible(true);
		this.competiciones.seleccionar();
	}
}
