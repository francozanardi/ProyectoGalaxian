package Arma;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

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

	public ArmaMinigun( Mapa mapa, Personaje tirador, ColisionadorDisparo miColisionador, double anguloDelDisparo )
	{
		inicializar(
			mapa,
			new Posicion(3, 3),
			new Size(8, 20),
			tirador,
			miColisionador,
			anguloDelDisparo,
			DISPAROS_POR_SEGUNDO,
			MULTIPLICADOR_DMG
		);
		
		actualizarPanel( true, Color.red );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected List<Disparo> crearDisparo(Personaje p)
	{
		List<Disparo> lista = new LinkedList<Disparo>( );
		
		Vector v = new Vector();
		v.setEnPolares( corregirAngulo( 0.0 ), VELOCIDAD_MOVIMIENTO );

		lista.add(
			new DisparoMinigun(
				map,
				colisionador.clone(),
				this,
				getPosicionLanzamiento( p ),
				v
			)
		);
		
		return lista;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////