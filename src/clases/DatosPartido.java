package clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalButtonUI;

public class DatosPartido extends JPanel
{
	//constructora
	private static final long serialVersionUID = 1L;
	private String codigoPartido;
	private double precio;
	private String local;
	private String estadio;
	private String codigoL;
	private String rival;
	private String codigoR;
	private String competicion;
	private String condicionMeteo;
	private LocalDate fecha;
	private String ciudad;
	private JPanel datosPartido;
	static int asistencia;
	private JButton asistenciaB;
	
	public DatosPartido() 
	{
		this.meterDatos();
		Font fuente = new Font("Verdana",Font.BOLD,55);
		this.datosPartido = new JPanel();
		
		JPanel displayInterior = new JPanel();
		displayInterior.setLayout(new BorderLayout());
		this.datosPartido.add(displayInterior);
		
		JButton eLocal = new JButton(this.local);
		JButton eRival = new JButton(this.rival);
		
		eLocal.setUI(new MetalButtonUI() {protected Color getDisabledTextColor() {return new Color(255,255,255);}});		
		eRival.setUI(new MetalButtonUI() {protected Color getDisabledTextColor() {return new Color(255,255,255);}});
		
		eLocal.setBackground(new Color(0,179,60));
		eRival.setBackground(new Color(0,230,77));
		
		Dimension dimBoton = new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2),500);
		eLocal.setPreferredSize(dimBoton);
		eLocal.setBorderPainted(false);
		eRival.setPreferredSize(dimBoton);
		eRival.setBorderPainted(false);
		eLocal.setFont(fuente);
		eRival.setFont(fuente);
		eLocal.setEnabled(false);
		eRival.setEnabled(false);
		
		displayInterior.add(eLocal,BorderLayout.WEST);
		displayInterior.add(eRival,BorderLayout.EAST);
		
		JPanel datos = new JPanel();
		datos.setLayout(new GridLayout(4,2));
		displayInterior.add(datos,BorderLayout.SOUTH);
		
		Font fuenteBoton = new Font("Verdana",Font.PLAIN,20);
		
		JButton a1 = new JButton(this.codigoPartido);
		JButton a2 = new JButton("Precio de Entrada: " + this.precio);
		JButton a3 = new JButton("Estadio " + this.estadio);
		JButton a4 = new JButton(this.competicion);
		JButton a5 = new JButton("Tiempo: "+this.condicionMeteo);
		JButton a6 = new JButton(String.valueOf(this.fecha));
		JButton a7 = new JButton("Ciudad: "+this.ciudad);
		asistenciaB = new JButton(String.valueOf("Asistencia: " + DatosPartido.asistencia));
		
		a1.setFont(fuenteBoton);
		a2.setFont(fuenteBoton);
		a3.setFont(fuenteBoton);
		a4.setFont(fuenteBoton);
		a5.setFont(fuenteBoton);
		a6.setFont(fuenteBoton);
		a7.setFont(fuenteBoton);
		asistenciaB.setFont(fuenteBoton);
		
		Color color = this.elegirColor();
		
		a1.setUI(new MetalButtonUI() {protected Color getDisabledTextColor() {return new Color(255,255,255);}});	
		a2.setUI(new MetalButtonUI() {protected Color getDisabledTextColor() {return new Color(255,255,255);}});	
		a3.setUI(new MetalButtonUI() {protected Color getDisabledTextColor() {return new Color(255,255,255);}});		
		a4.setUI(new MetalButtonUI() {protected Color getDisabledTextColor() {return new Color(255,255,255);}});	
		a5.setUI(new MetalButtonUI() {protected Color getDisabledTextColor() {return new Color(255,255,255);}});	
		a6.setUI(new MetalButtonUI() {protected Color getDisabledTextColor() {return new Color(255,255,255);}});	
		a7.setUI(new MetalButtonUI() {protected Color getDisabledTextColor() {return new Color(255,255,255);}});	
		asistenciaB.setUI(new MetalButtonUI() {protected Color getDisabledTextColor() {return new Color(255,255,255);}});
		
		a1.setBackground(color);
		a2.setBackground(color);
		a3.setBackground(color);
		a4.setBackground(color);
		a5.setBackground(color);
		a6.setBackground(color);
		a7.setBackground(color);
		asistenciaB.setBackground(color);
		
		a1.setEnabled(false);
		a2.setEnabled(false);
		a3.setEnabled(false);
		a4.setEnabled(false);
		a5.setEnabled(false);
		a6.setEnabled(false);
		a7.setEnabled(false);
		asistenciaB.setEnabled(false);
		
		a1.setBorderPainted(false);
		a2.setBorderPainted(false);
		a3.setBorderPainted(false);
		a4.setBorderPainted(false);
		a5.setBorderPainted(false);
		a6.setBorderPainted(false);
		a7.setBorderPainted(false);
		asistenciaB.setBorderPainted(false);

		
		datos.add(a1);
		datos.add(a2);
		datos.add(a3);
		datos.add(a4);
		datos.add(a5);
		datos.add(a6);
		datos.add(a7);
		datos.add(asistenciaB);
	}
	
	public JPanel getDatosPartido() 
	{
		return this.datosPartido;
	}
	
	public void meterDatos() 
	{
		//falta por meter asistencia, ciudad
		this.competicion=AccionBotonesCompeticiones.competicion;
		this.local=AccionBotonesEquipoLocal.equipo;
		this.rival=AccionBotonesEquipoRival.equipo;
		
		try 
		{
			this.buscarPrecio();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		this.fecha=LocalDate.now();
		this.generarCodigoPartido();
		this.condicionMeteo = AccionBotonesEquipoRival.tiempo;
	}
	
	public void buscarPrecio() throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("./src/datos/competiciones.txt"));
		sc.nextLine();
		int numero = Integer.valueOf(sc.nextLine());
		for(int i =0;i<numero;i++) 
		{
			if(sc.nextLine().equals(this.competicion)) 
			{
				this.precio = Double.valueOf(sc.nextLine());
			}
			else 
			{
				sc.nextLine();
			}
		}
	}
	
	public void cambiarAsistencia() 
	{
		asistenciaB.setText(String.valueOf("Asistencia: " + DatosPartido.asistencia));
	}


	public Color elegirColor() 
	{
		Color color = new Color(0,0,0);
		
		switch(this.competicion) 
		{
			case("Liga Santander"):
			{
				color = new Color(0,153,170);
				break;
			}
			
			case("Liga SmartBank"):
			{
				color = new Color(255,0,0);
				break;
			}
			
			case("Copa del Rey"):
			{
				color = Color.BLACK;
				break;
			}
			
			case("UEFA Champions League"):
			{
				color = new Color(0,0,204);
				break;
			}
			
			case("UEFA Europa League"):
			{
				color = new Color(255,153,0);
				break;
			}
		}
		return color;
	}

	public void generarCodigoPartido() 
	{
		Scanner sc = null;
		try 
		{
			sc = new Scanner(new File(AccionBotonesCompeticiones.fichero));
		} 
		catch (FileNotFoundException e) 
		{

		}
		
		sc.nextLine();
		int numero = Integer.valueOf(sc.nextLine());
		for(int i =0;i<numero;i++) 
		{
			String equipo = sc.nextLine();
			
			if(this.local.equals(equipo)) 
			{
				this.ciudad=sc.nextLine();
				this.estadio=sc.nextLine();
				this.codigoL=sc.nextLine();
			}
			else 
			{
				sc.nextLine();
				sc.nextLine();
				sc.nextLine();
			}
		}
		
		try 
		{
			sc = new Scanner(new File(AccionBotonesCompeticiones.fichero));
		} 
		catch (FileNotFoundException e) 
		{

		}
		sc.nextLine();
		numero = Integer.valueOf(sc.nextLine());
		
		for(int i =0;i<numero;i++) 
		{
			String equipo = sc.nextLine();
			if(this.rival.equals(equipo)) 
			{
				sc.nextLine();
				sc.nextLine();
				this.codigoR=sc.nextLine();
			}
			else 
			{
				sc.nextLine();
				sc.nextLine();
				sc.nextLine();
			}
		}
		
		this.codigoPartido = this.codigoL+" "+this.codigoR+" "+String.valueOf(fecha)+" "+this.competicion;
	}
}