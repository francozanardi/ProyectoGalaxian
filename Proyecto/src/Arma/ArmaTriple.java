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



public class ArmaTriple extends Arma
{	
	private final double	AMPLITUD_DISPARO		= Math.PI / 8,
							VELOCIDAD_DISPARO		= 100.0,
							DISPAROS_POR_SEGUNDO	= 0.33,
							MULTIPLICADOR_DMG 		= 1.0;

	protected int cantidadDeMuniciones;

	public ArmaTriple( EntidadConVida tirador, ColDisparo miColisionador, double anguloDelDisparo )
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
		
		cantidadDeMuniciones = 500;
	}


	
	protected List<Disparo> crearDisparo( )
	{
		List<Disparo> lista = new LinkedList<Disparo>( );
		Vector v;
		
		if(cantidadDeMuniciones > 0) {	
			// disparo 1
			v = new Vector();
			v.setPolares( corregirAngulo( -AMPLITUD_DISPARO ), VELOCIDAD_DISPARO );
			lista.add(
				new DisparoPerdigon(
					colisionador.clone(),
					this,
					getPosicionLanzamiento( ),
					v
				)
			);
			
			
			// disparo 2
			v = new Vector();
			v.setPolares( corregirAngulo( 0.0 ), VELOCIDAD_DISPARO );	
			lista.add(
				new DisparoPerdigon(
					colisionador.clone(),
					this,
					getPosicionLanzamiento( ),
					v
				)
			);
			
			
			// disparo 3
			v = new Vector();
			v.setPolares( corregirAngulo( AMPLITUD_DISPARO ), VELOCIDAD_DISPARO );	
			lista.add(
				new DisparoPerdigon(
					colisionador.clone(),
					this,
					getPosicionLanzamiento( ),
					v
				)
			);
			
			cantidadDeMuniciones--;
			
		} else {
			owner.changeArma(new ArmaComun(owner, colisionador, anguloDisparo));
		}
			
		
		return lista;
	}
}