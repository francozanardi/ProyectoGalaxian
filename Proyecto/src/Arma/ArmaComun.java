package Arma;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

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

	public ArmaComun( Mapa mapa, Personaje tirador, ColisionadorDisparo miColisionador, double anguloDelDisparo )
	{
		inicializar(
			mapa,
			new Posicion(3, 3),
			new Size(10, 20),
			tirador,
			miColisionador,
			anguloDelDisparo,
			DISPAROS_POR_SEGUNDO,
			MULTIPLICADOR_DMG
		);

		actualizarPanel( true, new Color(0, 0, 105) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected List<Disparo> crearDisparo(Personaje p)
	{
		List<Disparo> disparos = new LinkedList<Disparo>( );
		Vector v = new Vector();
		v.setEnPolares( corregirAngulo( 0.0 ), VELOCIDAD_MOVIMIENTO );

		disparos.add(
			new DisparoComun(
				map,
				colisionador.clone(),
				this,
				getPosicionLanzamiento( p ),
				v
			)
		);
		
		return disparos;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////