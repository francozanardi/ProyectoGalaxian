package Arma;

import java.awt.Color;

import Colisiones.ColisionadorDisparo;
import Disparo.*;
import Entidad.Personaje;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Size;
import Utils.Vector;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ArmaComun extends Arma
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final double	VELOCIDAD_MOVIMIENTO = 150.0,
							DISPAROS_POR_SEGUNDO = 5,
							MULTIPLICADOR_DMG = 1.0;

	///////////////////////////////////////////////////////////////////////////////////////////////

	public ArmaComun( Mapa map, Personaje tirador, ColisionadorDisparo miColisionador, double anguloDelDisparo )
	{
		inicializar(
			new Posicion(3, 3),
			new Size(10, 20),
			tirador,
			miColisionador,
			map,
			anguloDelDisparo,
			DISPAROS_POR_SEGUNDO,
			MULTIPLICADOR_DMG
		);

		actualizarPanel( true, new Color(0, 0, 105) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected void crearDisparo(Personaje p)
	{
		Vector v = new Vector();
		v.setEnPolares( corregirAngulo( 0.0 ), VELOCIDAD_MOVIMIENTO );

		map.addEntity(
			new DisparoComun(
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