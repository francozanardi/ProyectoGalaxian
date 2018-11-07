package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Logica.Juego;



public class MenuAbout extends Menu
{
	private MenuButton	botonSalirAbout;
	private JLabel		labelCreditos;
	
	
	
	public MenuAbout( JPanel canvas )
	{
		this.canvas	= canvas;
		
		crear( );
	}
	
	
	
	public void crear( )
	{
		crearBotones( );
		crearLabels( );
	}
	
	
	
	public void inicializar( )
	{
	}
	
	
	
	public void show( boolean toggle )
	{
		if (toggle)
			canvas.setBackground( Color.black );
		
		
		botonSalirAbout.setVisible( toggle );
		labelCreditos.setVisible( toggle );
	}


		
	private void crearBotones( )
	{		
		int yBoton = Juego.GAME_HEIGHT - (DIST_BOTONES + BOTON_HEIGHT) - 80,
			xCentrado = (Juego.GAME_WIDTH / 2) - (BOTON_WIDTH / 2);

			
		botonSalirAbout = crearBoton( "Menú Principal", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, new OyenteBotonSalirAbout() );
	}
	
	
	
	private void crearLabels( )
	{
		labelCreditos = new JLabel( );
		labelCreditos.setText(
			String.format(
				"<html><b><h2>%s</h2></b>" + "<br/><br/>" +
				"Este juego es el resultado de un proyecto de programación para la materia \"Tecnologías de Programación\"" + 
				"del Departamento de Ciencias e Ingeniería de la Computación, Universidad Nacional del Sur." + "<br/><br/>" +
				"Fue desarrollado durante el segundo cuatrimestre del año 2018." + "<br/><br/>" +
				"<b><u>Autores:</u></b>" + "<br/>" +
				"Giordano, Nicolás" + "<br/>" +
				"Vega, Maximiliano Nicolás" + "<br/>" +
				"Zanardi, Franco Iván" + "<br/>" +
				"</html>",
				Juego.GAME_TITLE
			)
		);
		labelCreditos.setOpaque( false );
		labelCreditos.setVerticalAlignment( SwingConstants.TOP );
		labelCreditos.setBounds(20, 20, Juego.GAME_WIDTH - 40, Juego.GAME_HEIGHT);
		labelCreditos.setFont( new Font("Ubuntu", Font.PLAIN, 12) );
		labelCreditos.setForeground( Color.white );
		labelCreditos.setVisible( false );
		
		canvas.add( labelCreditos );
	}
	
	
	
	private class OyenteBotonSalirAbout implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			nextMenu( mediador.menuPrincipal() );
		}
	}
}
