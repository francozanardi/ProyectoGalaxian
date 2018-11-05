package Logica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class MenuPrincipal
{
	private Juego	juego;
	private JPanel	canvas;
	private JLabel	labelCreditos;
	private JButton botonNewGame,
					botonMaxScore,
					botonAbout,
					botonExit,
					botonSalirAbout;
	
	
	
	public MenuPrincipal( Juego juego )
	{
		this.juego	= juego;
		this.canvas	= juego.getPanel();
		
		prepararFondo( );
		crearLabels( );
		crearBotones( );

		showMenuPrincipal( true );
	}
	
	
	
	public void gameFinished( )
	{
		agregarEntidades( );
		showMenuPrincipal( true );
	}
	
	private void agregarEntidades( )
	{
		canvas.add( labelCreditos );
		canvas.add( botonNewGame );
		canvas.add( botonMaxScore );
		canvas.add( botonAbout );
		canvas.add( botonExit );
		canvas.add( botonSalirAbout );
	}
	
	
	
	private void prepararFondo( )
	{
		canvas.setBackground( Color.black );
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
	
	private void crearBotones( )
	{
		final int	BOTON_WIDTH		= 200,
					BOTON_HEIGHT	= 40,
					DIST_BOTONES	= 10;
		final Font	BOTON_FONT		= new Font("Ubuntu", Font.BOLD, 16);
		final Color COLOR_BG		= new Color(50, 50, 50),
					COLOR_FONT		= Color.white;
		
		
		// BOTONES MENU PRINCIPAL ===============
		int yBoton = Juego.GAME_HEIGHT - (DIST_BOTONES + BOTON_HEIGHT) - 80,
			xCentrado = (Juego.GAME_WIDTH / 2) - (BOTON_WIDTH / 2);

		botonExit = createButton( "Salir", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, BOTON_FONT, COLOR_BG, COLOR_FONT );
		botonExit.addActionListener( new OyenteBotonExit() );
		
		yBoton -= (DIST_BOTONES + BOTON_HEIGHT);
		botonAbout = createButton( "Acerca de", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, BOTON_FONT, COLOR_BG, COLOR_FONT );
		botonAbout.addActionListener( new OyenteBotonAbout() );
		
		yBoton -= (DIST_BOTONES + BOTON_HEIGHT);
		botonMaxScore = createButton( "Mejores Puntajes", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, BOTON_FONT, COLOR_BG, COLOR_FONT );
		
		yBoton -= (DIST_BOTONES + BOTON_HEIGHT);
		botonNewGame = createButton( "Nueva Partida", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, BOTON_FONT, COLOR_BG, COLOR_FONT );
		botonNewGame.addActionListener( new OyenteBotonStartGame() );
		
		
		
		// BOTONES MENU CREDITOS ================
		yBoton = Juego.GAME_HEIGHT - (DIST_BOTONES + BOTON_HEIGHT) - 80;
			
		botonSalirAbout = createButton( "Menú Principal", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, BOTON_FONT, COLOR_BG, COLOR_FONT );
		botonSalirAbout.addActionListener( new OyenteBotonSalirAbout() );
	}
	
	private JButton createButton( String texto, int x, int y, int w, int h, Font f, Color bg, Color fg )
	{
		JButton b = new JButton();
		
		b.setBounds( x, y, w, h );
		b.setText( texto );
		b.setFont( f );
		b.setBackground( bg );
		b.setForeground( fg );
		b.setVisible( false );
		canvas.add( b );
		
		return b;
	}



	private void showMenuPrincipal( boolean show )
	{
		botonNewGame.setVisible( show );
		botonMaxScore.setVisible( show );
		botonAbout.setVisible( show );
		botonExit.setVisible( show );
	}
	
	
	
	private void showMenuCreditos( boolean show )
	{
		labelCreditos.setVisible( show );
		botonSalirAbout.setVisible( show );
	}
	
	
	
	private class OyenteBotonStartGame implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			showMenuPrincipal( false );
			juego.startGame();
		}
	}
	
	private class OyenteBotonExit implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			juego.dispose();
		}
	}
	
	private class OyenteBotonAbout implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			showMenuPrincipal( false );
			showMenuCreditos( true );
		}
	}
	
	private class OyenteBotonSalirAbout implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			showMenuCreditos( false );
			showMenuPrincipal( true );
		}
	}
}
