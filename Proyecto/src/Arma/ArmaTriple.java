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

public class ArmaTriple extends Arma
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final double	AMPLITUD_DISPARO		= Math.PI / 8,
							VELOCIDAD_DISPARO		= 100.0,
							DISPAROS_POR_SEGUNDO	= 0.33,
							MULTIPLICADOR_DMG 		= 1.0;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ArmaTriple(Mapa map)
	{
		this.map					= map;
		this.rand					= new Randomizador( );
		this.panel					= new JPanel();
		this.tamano					= new Size(5, 15);
		this.pos					= new Posicion(5, 5);
		this.cadenciaDisparo		= (int) (1000.0 / DISPAROS_POR_SEGUNDO);
		this.multiplicadorDmg		= MULTIPLICADOR_DMG;
		
		inicializar( );
		
		actualizarPanel( true, new Color(255, 255, 255) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected void crearDisparo( Personaje p )
	{
		Vector v;
		Disparo d;
		double ang	= (3 * Math.PI / 2);
		
		
		// disparo 1
		v = new Vector();
		v.setEnPolares( ang - AMPLITUD_DISPARO, VELOCIDAD_DISPARO );	
		d = new DisparoEnemigo(
				map,
				this,
				new Posicion(
					p.getPos().getX() + this.pos.getX(),
					p.getPos().getY() + p.getSize().getHeight() + 5
				),
				v
			);		
		map.agregarEntidad( d );
		d.getPanel().setBackground( Color.pink );
		
		
		// disparo 2
		v = new Vector();
		v.setEnPolares( ang, VELOCIDAD_DISPARO );	
		d = new DisparoEnemigo(
				map,
				this,
				new Posicion(
					p.getPos().getX() + this.pos.getX(),
					p.getPos().getY() + p.getSize().getHeight() + 5
				),
				v
			);
		map.agregarEntidad( d );
		d.getPanel().setBackground( Color.pink );
		
		
		// disparo 3
		v = new Vector();
		v.setEnPolares( ang + AMPLITUD_DISPARO, VELOCIDAD_DISPARO );	
		d = new DisparoEnemigo(
				map,
				this,
				new Posicion(
					p.getPos().getX() + this.pos.getX(),
					p.getPos().getY() + p.getSize().getHeight() + 5
				),
				v
			);
		map.agregarEntidad( d );
		d.getPanel().setBackground( Color.pink );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////