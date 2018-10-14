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

public class ArmaMinigun extends Arma
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final double	VELOCIDAD_MOVIMIENTO = 250.0,
							DISPAROS_POR_SEGUNDO = 10.0,
							MULTIPLICADOR_DMG = 1.0;

	///////////////////////////////////////////////////////////////////////////////////////////////

	public ArmaMinigun( Mapa map, Personaje tirador, ColisionadorDisparo miColisionador, double anguloDelDisparo )
	{
		inicializar(
			new Posicion(3, 3),
			new Size(8, 20),
			tirador,
			miColisionador,
			map,
			anguloDelDisparo,
			DISPAROS_POR_SEGUNDO,
			MULTIPLICADOR_DMG
		);
		
		actualizarPanel( true, Color.red );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected void crearDisparo(Personaje p)
	{
		Vector v = new Vector();
		v.setEnPolares( corregirAngulo( 0.0 ), VELOCIDAD_MOVIMIENTO );

		map.agregarEntidad(
			new DisparoMinigun(
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