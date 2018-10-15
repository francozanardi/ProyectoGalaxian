package Arma;

import java.awt.Color;
import javax.swing.JPanel;

import Colisiones.ColisionadorDisparo;
import Disparo.*;
import Entidad.Personaje;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;
import Utils.Vector;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ArmaTriple extends Arma
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final double	AMPLITUD_DISPARO		= Math.PI / 8,
							VELOCIDAD_DISPARO		= 100.0,
							DISPAROS_POR_SEGUNDO	= 0.33,
							MULTIPLICADOR_DMG 		= 1.0;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public ArmaTriple( Mapa map, Personaje tirador, ColisionadorDisparo miColisionador, double anguloDelDisparo )
	{
		inicializar(
			new Posicion(5, 5),
			new Size(5, 15),
			tirador,
			miColisionador,
			map,
			anguloDelDisparo,
			DISPAROS_POR_SEGUNDO,
			MULTIPLICADOR_DMG
		);
				
		actualizarPanel( true, new Color(255, 255, 255) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected void crearDisparo( Personaje p )
	{
		Vector v;
		Disparo d;
		
		
		// disparo 1
		v = new Vector();
		v.setEnPolares( corregirAngulo( -AMPLITUD_DISPARO ), VELOCIDAD_DISPARO );	
		d = new DisparoPerdigon(
				map,
				colisionador.clone(),
				this,
				getPosicionLanzamiento( p ),
				v
			);		
		map.addEntity( d );
		
		
		// disparo 2
		v = new Vector();
		v.setEnPolares( corregirAngulo( 0.0 ), VELOCIDAD_DISPARO );	
		d = new DisparoPerdigon(
				map,
				colisionador.clone(),
				this,
				getPosicionLanzamiento( p ),
				v
			);
		map.addEntity( d );
		
		
		// disparo 3
		v = new Vector();
		v.setEnPolares( corregirAngulo( AMPLITUD_DISPARO ), VELOCIDAD_DISPARO );	
		d = new DisparoPerdigon(
				map,
				colisionador.clone(),
				this,
				getPosicionLanzamiento( p ),
				v
			);
		map.addEntity( d );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////