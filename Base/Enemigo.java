import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;

public class Enemigo extends Entidad
{
	private Random rand;
	
	public Enemigo( Mapa mapa )
	{
		this.mapa = mapa;
		this.panel = new JPanel( );
		this.pos = new int[2];
		this.tamano = new int[2];
		
		rand = new Random();
		
		this.pos[0] = rand.nextInt( Juego.GAME_WIDTH );
		this.pos[1] = rand.nextInt( Juego.GAME_HEIGHT );
		
		this.tamano[0] = 10;
		this.tamano[1] = 10;
		
		panel.setOpaque( true );
		panel.setBackground( new Color(100, 100, 100) );
		panel.setBounds( pos[0], pos[1], tamano[0], tamano[1] );
		panel.setVisible( true );
	}
	
	public void mover( )
	{
		this.pos[0] += -1 + rand.nextInt( 3 );
		this.pos[1] += -1 + rand.nextInt( 3 );
		
		panel.setBounds( pos[0], pos[1], tamano[0], tamano[1] );
	}
}
