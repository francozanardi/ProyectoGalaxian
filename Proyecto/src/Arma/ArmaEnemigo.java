package Arma;

import java.awt.Color;
import javax.swing.JPanel;
import Disparo.*;
import Entidad.Personaje;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;
import Utils.Vector;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ArmaEnemigo extends Arma
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final double AMPLITUD_DISPARO = Math.PI / 12;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ArmaEnemigo(Mapa map)
	{
		this.map					= map;
		this.rand					= new Randomizador( );
		this.panel					= new JPanel();
		this.tamano					= new Size(5, 15);
		this.pos					= new Posicion(5, 5);
		this.cadenciaDisparo		= (int) (1000.0 / 0.5); // 0.5 disparos por segundo = 1 disparo cada 2 segundos
		
		inicializar( );
		
		actualizarPanel( true, new Color(255, 255, 255) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected Disparo crearDisparo( Personaje p )
	{
		Vector v = new Vector();
		double ang = (3 * Math.PI / 2) + rand.nextDouble( -AMPLITUD_DISPARO, AMPLITUD_DISPARO );
		v.setEnPolares( ang, 5.0);	

		return	new DisparoEnemigo(
					map,
					new Posicion(
						p.getPos().getX() + this.pos.getX(),
						p.getPos().getY() + p.getSize().getHeight() + 5
					),
					v
				);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////