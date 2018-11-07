package Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Logica.Juego;



public class MenuBestScores extends Menu
{
	private MenuButton	botonSalir;
	private JLabel		labelScores;
	private String[]	score;
	
	
	public MenuBestScores( JPanel canvas )
	{
		this.canvas	= canvas;
		this.score	= new String[ Juego.GAME_BEST_SCORES ];
		
		crear( );
	}
	
	
	
	public void crear( )
	{
		crearBotones( );
		crearLabels( );
	}
	
	
	
	public void inicializar( )
	{
		String	nombre	= "Unknown";
		int		puntaje	= 9999;
		
		for (int i = 0; i < score.length; i ++)
			score[i] = String.format("%d. '%s' - Score: %d", i + 1, nombre, puntaje);
	}
	
	
	
	public void show( boolean toggle )
	{
		if (toggle)
		{
			canvas.setBackground( Color.black );
			inicializar( );
			labelScores.setText( cargarPuntajes( ) );
		}
		
		
		botonSalir.setVisible( toggle );
		labelScores.setVisible( toggle );
	}


		
	private void crearBotones( )
	{		
		int yBoton = Juego.GAME_HEIGHT - (DIST_BOTONES + BOTON_HEIGHT) - 80,
			xCentrado = (Juego.GAME_WIDTH / 2) - (BOTON_WIDTH / 2);

			
		botonSalir = crearBoton( "Menú Principal", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, new OyenteBotonSalirAbout() );
	}
	
	
	
	private void crearLabels( )
	{
		labelScores = new JLabel( );
		labelScores.setText( "" );
		labelScores.setOpaque( false );
		labelScores.setVerticalAlignment( SwingConstants.TOP );
		labelScores.setBounds(20, 20, Juego.GAME_WIDTH - 40, Juego.GAME_HEIGHT);
		labelScores.setFont( new Font("Ubuntu", Font.PLAIN, 12) );
		labelScores.setForeground( Color.white );
		labelScores.setVisible( false );
		
		canvas.add( labelScores );
	}
	
	
	
	private String cargarPuntajes( )
	{
		String texto =
				"<html><b><h1>" + Juego.GAME_TITLE + "</h1></b>" + "<br/>" +
				"<h3>Mejores puntajes:</h3>" + "<br/><br/>";
		
		for (int i = 0; i < score.length; i ++)
			texto += score[i] + "<br/>";
		
		texto += "</html>";
		
		return texto;
	}
	
	
	
	private class OyenteBotonSalirAbout implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			nextMenu( mediador.menuPrincipal() );
		}
	}
}
