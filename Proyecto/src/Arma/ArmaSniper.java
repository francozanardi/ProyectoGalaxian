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

public class ArmaSniper extends Arma
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final double	VELOCIDAD_MOVIMIENTO = 200.0,
							DISPAROS_POR_SEGUNDO = 0.33,
							MULTIPLICADOR_DMG = 1.0;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public ArmaSniper( Mapa mapa, Personaje tirador, ColisionadorDisparo miColisionador, double anguloDelDisparo )
	{
		this.map = mapa;
		
		inicializar(
			mapa,
			new Posicion(5, 5),
			new Size(5, 15),
			tirador,
			miColisionador,
			anguloDelDisparo,
			DISPAROS_POR_SEGUNDO,
			MULTIPLICADOR_DMG
		);
				
		actualizarPanel( true, new Color(255, 255, 255) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected List<Disparo> crearDisparo( Personaje p )
	{
		List<Disparo> lista = new LinkedList<Disparo>( );
		
		Posicion comienzoDisparo =	new Posicion(
										p.getPos().getX() + this.pos.getX(),
										p.getPos().getY() + p.getSize().getHeight() + 5
									);
		Posicion posJugador = map.getPlayerPos();
		
		Vector v = new Vector();
		v.setEnCartesianas( posJugador.getX() - comienzoDisparo.getX(), posJugador.getY() - comienzoDisparo.getY() );
		v.setNorma( VELOCIDAD_MOVIMIENTO );

		lista.add(
			new DisparoSniper(
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