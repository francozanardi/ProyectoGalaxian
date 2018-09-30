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

public class ArmaCannon extends Arma
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final double VELOCIDAD_MOVIMIENTO	= 200.0;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ArmaCannon(Mapa map)
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
	
	protected void crearDisparo( Personaje p )
	{
		Posicion comienzoDisparo =	new Posicion(
										p.getPos().getX() + this.pos.getX(),
										p.getPos().getY() + p.getSize().getHeight() + 5
									);
		Posicion posJugador = map.coordenadasDelJugador();
		
		Vector v = new Vector();
		v.setEnCartesianas( posJugador.getX() - comienzoDisparo.getX(), -(posJugador.getY() - comienzoDisparo.getY()) );
		v.setNorma( VELOCIDAD_MOVIMIENTO );

		map.agregarEntidad( new DisparoCannon(
				map,
				comienzoDisparo,
				v
			)
		);	
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////