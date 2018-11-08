package Arma;

import java.util.LinkedList;
import java.util.List;

import Disparo.Disparo;
import Disparo.DisparoComun;
import Entidad.EntidadConVida;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Vector;
import visitor.ColDisparo;



public class ArmaComun extends Arma
{
	private final double	VELOCIDAD_MOVIMIENTO = 150.0,
							DISPAROS_POR_SEGUNDO = 5,
							MULTIPLICADOR_DMG = 1.0;



	public ArmaComun( EntidadConVida tirador, ColDisparo miColisionador, double anguloDelDisparo )
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
		List<Disparo> disparos = new LinkedList<Disparo>( );
		Vector v = new Vector();
		v.setPolares( corregirAngulo( 0.0 ), VELOCIDAD_MOVIMIENTO );

		disparos.add(
			new DisparoComun(
				colisionador.clone(),
				this,
				getPosicionLanzamiento( ),
				v
			)
		);
		
		return disparos;
	}
	
}