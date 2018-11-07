package Arma;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import Disparo.Disparo;
import Disparo.DisparoSniper;
import Entidad.EntidadConVida;
import Utils.Posicion;
import Utils.Size;
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