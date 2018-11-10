package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Jugador.Jugador;
import Logica.Juego;



public class MenuGameOver extends Menu
{
	private MenuButton	botonMenuPrincipal;
	private JLabel		label;
	private int			score;
	private Jugador 	jugador;
	
	
	
	public MenuGameOver( Juego juego, MediadorMenu m, Jugador jugador )
	{
		this.canvas	= juego.getPanel();
		this.mediador = m;
		this.jugador = jugador;
		
		crearBotones( );
		crearLabels( );
	}
	
	protected void eliminar() {
		show(false);
		canvas.remove(botonMenuPrincipal);
		canvas.remove(label);
		canvas.repaint();
	}
	
	public void show( boolean toggle )
	{
		if (toggle)
			canvas.setBackground( Color.black );
		
		
		botonMenuPrincipal.setVisible( toggle );
		label.setVisible( toggle );
	}
	
	
	
	public void update( int score )
	{
		this.score = score;

		label.setText( "<html>GAME OVER<br/>SCORE: " + score + "</html>" );
	}


		
	private void crearBotones( )
	{		
		int yBoton = Juego.GAME_HEIGHT - (DIST_BOTONES + BOTON_HEIGHT) - 80,
			xCentrado = (Juego.GAME_WIDTH / 2) - (BOTON_WIDTH / 2);

			
		botonMenuPrincipal = crearBoton( "Menú Principal", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, new OyenteBotonMenuPrincipal() );
	}
	
	
	
	private void crearLabels( )
	{
		label = new JLabel( );
		label.setText( "GAME OVER" );
		label.setOpaque( false );
		label.setHorizontalAlignment( SwingConstants.CENTER );
		label.setVerticalAlignment( SwingConstants.CENTER );
		label.setBounds(0, (Juego.GAME_HEIGHT / 2) - 100, Juego.GAME_WIDTH, 200);
		label.setFont( new Font("Ubuntu", Font.PLAIN, 54) );
		label.setForeground( Color.white );
		label.setBackground( Color.black );
		label.setVisible( false );
		
		canvas.add( label );
	}
	
	
	
	private class OyenteBotonMenuPrincipal implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			mediador.iniciarNuevoMenu( mediador.menuPrincipal() );
			jugador.restaurarValores();
		}
	}
}
