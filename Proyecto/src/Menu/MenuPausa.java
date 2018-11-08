package Menu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Logica.Juego;



public class MenuPausa extends Menu
{
	private JLabel labelPausa;
	
	
	public MenuPausa( JPanel canvas, Juego juego )
	{
		this.canvas	= canvas;
		
		crear( );
	}
	
	
	
	public void crear( )
	{
		crearLabels( );
	}
	
	
	
	public void inicializar( )
	{
	}
	
	
	
	public void show( boolean toggle )
	{		
		labelPausa.setVisible( toggle );
	}
	
	
	
	private void crearLabels( )
	{
		labelPausa = new JLabel( );
		labelPausa.setText( "PAUSA" );
		labelPausa.setOpaque( true );
		labelPausa.setHorizontalAlignment( SwingConstants.CENTER );
		labelPausa.setVerticalAlignment( SwingConstants.CENTER );
		labelPausa.setBounds(0, (Juego.GAME_HEIGHT / 2) - 100, Juego.GAME_WIDTH, 200);
		labelPausa.setFont( new Font("Ubuntu", Font.PLAIN, 54) );
		labelPausa.setForeground( Color.white );
		labelPausa.setBackground( Color.black );
		labelPausa.setVisible( false );
		
		canvas.add( labelPausa );
	}
}
