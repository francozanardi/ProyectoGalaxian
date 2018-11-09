package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Logica.Juego;



public class MenuGameOver extends Menu
{
	private MenuButton	botonMenuPrincipal;
	private JLabel		label;
	private int			score;
	
	
	
	public MenuGameOver( JPanel canvas )
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

			
		botonMenuPrincipal = crearBoton( "Men� Principal", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, new OyenteBotonMenuPrincipal() );
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
			nextMenu( mediador.menuPrincipal() );
		}
	}
}