package PowerUp;

import java.awt.Color;
import javax.swing.JPanel;

import Entidad.Entidad;
import Jugador.Jugador;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Size;
import visitor.ColPowerUp;
import visitor.congelador.Congelador;



public class PUCongelar extends PowerUp
{
	protected PUCongelarLogica logica;
	protected Congelador congelador;
	
	public PUCongelar( Mapa map )
	{
		this.map			= map;
		this.pos			= new Posicion( 0, 0 );
		this.panel			= new JPanel( );
		this.tamano			= new Size( 25, 25 );
		this.vida			= 1000;
		this.colisionador	= new ColPowerUp( this );
		this.logica			= PUCongelarLogica.create();
		this.congelador		= new Congelador(logica);
		
		this.actualizarPanel(true, Color.blue);
	}

	public void afectar(Jugador player)
	{
		for(Entidad ent: map.getEntidades()) {
			ent.accept(congelador);
		}
		    
	    map.mostrarAnuncio("Enemigos congelados!");
	}

}