package Arma;

import java.util.LinkedList;
import java.util.List;

import Disparo.Disparo;
import Disparo.DisparoDefaultEnemigo;
import Entidad.EntidadConVida;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Vector;
import visitor.ColDisparo;



public class ArmaDefaultEnemigo extends Arma
{
	private final double	AMPLITUD_DISPARO		= Math.PI / 12,
							VELOCIDAD_MOVIMIENTO	= 100.0,
							DISPAROS_POR_SEGUNDO	= 3,
							MULTIPLICADOR_DMG		= 1.0;



	public ArmaDefaultEnemigo( EntidadConVida tirador, ColDisparo miColisionador, double anguloDelDisparo )
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
		
		Vector v = new Vector();
		v.setPolares( corregirAngulo( rand.nextDouble( -AMPLITUD_DISPARO, AMPLITUD_DISPARO ) ), VELOCIDAD_MOVIMIENTO );	

		lista.add(
			new DisparoDefaultEnemigo(
				colisionador.clone(),
				this,
				getPosicionLanzamiento( ),
				v
			)
		);
		
		return lista;
	}
}