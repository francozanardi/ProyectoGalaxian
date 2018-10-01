package Arma;

import java.awt.Color;

import javax.swing.JPanel;
import Disparo.*;
import Entidad.Personaje;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;
import Utils.Vector;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ArmaMinigun extends Arma
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final double	VELOCIDAD_MOVIMIENTO = 250.0,
							DISPAROS_POR_SEGUNDO = 10.0,
							MULTIPLICADOR_DMG = 1.0;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ArmaMinigun(Mapa map)
	{
		this.map				= map;
		this.rand				= new Randomizador( );
		this.panel				= new JPanel();
		this.tamano				= new Size(8, 300);
		this.pos				= new Posicion(3, 3);
		this.cadenciaDisparo	= (int) (1000.0 / DISPAROS_POR_SEGUNDO);
		this.multiplicadorDmg	= MULTIPLICADOR_DMG;

		inicializar( );
		
		actualizarPanel( true, Color.red );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected void crearDisparo(Personaje p)
	{
		Vector v = new Vector();
		v.setEnPolares( Math.PI / 2, VELOCIDAD_MOVIMIENTO );

		map.agregarEntidad(
			new DisparoMinigun(
				map,
				this,
				new Posicion(
					p.getPos().getX() + this.pos.getX(),
					p.getPos().getY() - 5
				),
				p,
				v
			)
		);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////