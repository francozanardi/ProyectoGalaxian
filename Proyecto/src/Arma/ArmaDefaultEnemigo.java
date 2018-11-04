package Arma;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import Colisiones.ColDisparo;
import Disparo.Disparo;
import Disparo.DisparoDefaultEnemigo;
import Entidad.EntidadConVida;
import Utils.Posicion;
import Utils.Size;
import Utils.Vector;



public class ArmaDefaultEnemigo extends Arma
{
	private final double	AMPLITUD_DISPARO		= Math.PI / 12,
							VELOCIDAD_MOVIMIENTO	= 100.0,
							DISPAROS_POR_SEGUNDO	= 0.5,
							MULTIPLICADOR_DMG		= 1.0;



	public ArmaDefaultEnemigo( EntidadConVida tirador, ColDisparo miColisionador, double anguloDelDisparo )
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