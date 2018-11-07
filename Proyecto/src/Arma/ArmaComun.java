package Arma;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import Disparo.Disparo;
import Disparo.DisparoComun;
import Entidad.EntidadConVida;
import Utils.Posicion;
import Utils.Size;
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
			new Posicion(3, 3),
			new Size(10, 20),
			tirador,
			miColisionador,
			anguloDelDisparo,
			DISPAROS_POR_SEGUNDO,
			MULTIPLICADOR_DMG
		);

		actualizarPanel( true, new Color(0, 0, 105) );
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