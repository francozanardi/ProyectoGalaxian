package Arma;

import java.util.LinkedList;
import java.util.List;

import Disparo.Disparo;
import Disparo.DisparoMinigun;
import Entidad.EntidadConVida;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Vector;
import visitor.ColDisparo;



public class ArmaMinigun extends Arma
{	
	private final double	VELOCIDAD_MOVIMIENTO = 250.0,
							DISPAROS_POR_SEGUNDO = 10.0,
							MULTIPLICADOR_DMG = 1.0;
	
	protected int cantidadDeMuniciones;

	public ArmaMinigun( EntidadConVida tirador, ColDisparo miColisionador, double anguloDelDisparo )
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
		
		cantidadDeMuniciones = 300;
	}


	
	protected List<Disparo> crearDisparo( )
	{
		List<Disparo> lista = new LinkedList<Disparo>( );
		
		Vector v = new Vector();
		
		if(cantidadDeMuniciones > 0) {
			v.setPolares( corregirAngulo( 0.0 ), VELOCIDAD_MOVIMIENTO );
	
			lista.add(
				new DisparoMinigun(
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