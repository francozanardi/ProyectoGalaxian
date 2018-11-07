package Arma;

import java.util.LinkedList;
import java.util.List;

import Disparo.Disparo;
import Disparo.DisparoSniper;
import Entidad.EntidadConVida;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Vector;
import visitor.ColDisparo;



public class ArmaSniper extends Arma
{	
	private final double	VELOCIDAD_MOVIMIENTO = 200.0,
							DISPAROS_POR_SEGUNDO = 0.33,
							MULTIPLICADOR_DMG = 1.0;



	public ArmaSniper( EntidadConVida tirador, ColDisparo miColisionador, double anguloDelDisparo )
	{		
		inicializar(
			new Sprite( "/GameSprites/Arma.PNG" ),
			new Posicion(0, 0),
			tirador,
			miColisionador,
			anguloDelDisparo,
			DISPAROS_POR_SEGUNDO,
			MULTIPLICADOR_DMG
		);
	}


	
	protected List<Disparo> crearDisparo( )
	{
		List<Disparo> lista = new LinkedList<Disparo>( );
		
		Posicion	comienzoDisparo = getPosicionLanzamiento( ),
					posJugador		= map.getPlayerPos();
		
		Vector v = new Vector();
		v.setCartesianas( posJugador.getX() - comienzoDisparo.getX(), posJugador.getY() - comienzoDisparo.getY() );
		v.setNorma( VELOCIDAD_MOVIMIENTO );

		lista.add(
			new DisparoSniper(
				colisionador.clone(),
				this,
				comienzoDisparo,
				v
			)
		);
		
		return lista;
	}
}