package Arma;

import java.util.LinkedList;
import java.util.List;

import Disparo.Disparo;
import Disparo.DisparoPerdigon;
import Entidad.EntidadConVida;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Vector;
import visitor.ColDisparo;



public class ArmaBoss extends Arma
{	
	private final double	AMPLITUD_DISPARO		= Math.PI / 8,
							VELOCIDAD_DISPARO		= 100.0,
							DISPAROS_POR_SEGUNDO	= 3,
							MULTIPLICADOR_DMG 		= 1.0;



	public ArmaBoss( EntidadConVida tirador, ColDisparo miColisionador, double anguloDelDisparo )
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


	
	private void crearDisparo( List<Disparo> lista, double ang )
	{
		Vector v = new Vector();
		v.setPolares( corregirAngulo( ang ), VELOCIDAD_DISPARO );
		lista.add(
			new DisparoPerdigon(
				colisionador.clone(),
				this,
				getPosicionLanzamiento( ),
				v
			)
		);
	}
	
	protected List<Disparo> crearDisparo( )
	{
		List<Disparo> lista = new LinkedList<Disparo>( );
		
		
		crearDisparo( lista, -AMPLITUD_DISPARO );
		crearDisparo( lista, -(AMPLITUD_DISPARO / 2) );
		crearDisparo( lista, 0.0 );
		crearDisparo( lista, (AMPLITUD_DISPARO / 2) );
		crearDisparo( lista, AMPLITUD_DISPARO );
		
		
		return lista;
	}
}