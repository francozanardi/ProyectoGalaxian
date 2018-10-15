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

public class ArmaDefaultEnemigo extends Arma
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final double	AMPLITUD_DISPARO		= Math.PI / 12,
							VELOCIDAD_MOVIMIENTO	= 100.0,
							DISPAROS_POR_SEGUNDO	= 0.5,
							MULTIPLICADOR_DMG		= 1.0;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public ArmaDefaultEnemigo( Mapa map, Personaje tirador, ColisionadorDisparo miColisionador, double anguloDelDisparo )
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
		Vector v = new Vector();
		v.setEnPolares( corregirAngulo( rand.nextDouble( -AMPLITUD_DISPARO, AMPLITUD_DISPARO ) ), VELOCIDAD_MOVIMIENTO );	

		map.addEntity(
			new DisparoDefaultEnemigo(
				map,
				colisionador.clone(),
				this,
				getPosicionLanzamiento( p ),
				v
			)
		);	
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////