package Arma;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import Colisiones.ColDisparo;
import Disparo.Disparo;
import Disparo.DisparoPerdigon;
import Entidad.EntidadConVida;
import Utils.Posicion;
import Utils.Size;
import Utils.Vector;



public class ArmaTriple extends Arma
{	
	private final double	AMPLITUD_DISPARO		= Math.PI / 8,
							VELOCIDAD_DISPARO		= 100.0,
							DISPAROS_POR_SEGUNDO	= 0.33,
							MULTIPLICADOR_DMG 		= 1.0;



	public ArmaTriple( EntidadConVida tirador, ColDisparo miColisionador, double anguloDelDisparo )
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
		Vector v;
		
		
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
		
		
		return lista;
	}
}