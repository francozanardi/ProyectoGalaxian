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

public class ArmaJugador extends Arma
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final double	VELOCIDAD_MOVIMIENTO = 150.0,
							DISPAROS_POR_SEGUNDO = 5,
							MULTIPLICADOR_DMG = 1.0;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ArmaJugador(Mapa map)
	{
		this.map				= map;
		this.rand				= new Randomizador( );
		this.panel				= new JPanel();
		this.tamano				= new Size(10, 20);
		this.pos				= new Posicion(3, 3);
		this.cadenciaDisparo	= (int) (1000.0 / DISPAROS_POR_SEGUNDO);
		this.multiplicadorDmg	= MULTIPLICADOR_DMG;

		inicializar( );
		
		actualizarPanel( true, new Color(0, 0, 105) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected void crearDisparo(Personaje p)
	{
		Vector v = new Vector();
		v.setEnPolares( Math.PI / 2, VELOCIDAD_MOVIMIENTO );

		map.agregarEntidad(
			new DisparoJugador(
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