import javax.swing.JPanel;

public class Mapa
{
	private Juego juego;
	private Entidad[] e;
	
	public Mapa( Juego juego )
	{
		this.juego = juego;
		
		crearEnemigos( );
	}
	
	public void crearEnemigos( )
	{
		e = new Entidad[10];
		JPanel panelJuego = juego.obtenerPanel();
		
		for (int i = 0; i < e.length; i ++)
		{
			e[i] = new Enemigo( this );
			
			panelJuego.add( e[i].obtenerPanel() );
		}
		
	}
	
	public void actualizar( )
	{
		for (int i = 0; i < e.length; i ++)
		{
			e[i].mover();
		}
		
		juego.obtenerPanel().repaint();
	}
	
}
