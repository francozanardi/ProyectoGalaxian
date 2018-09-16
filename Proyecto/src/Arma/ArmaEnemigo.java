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

public class ArmaEnemigo extends Arma
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ArmaEnemigo(Mapa map)
	{
		this.rand	= new Randomizador( );
		this.panel	= new JPanel();
		this.tamano	= new Size(5, 15);
		this.pos	= new Posicion(4, 4); // pos
		this.map	= map;
		
		actualizarPanel( true, new Color(255, 255, 255) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	//el arma enemigo no tiene el control de velocidad hecho para lanzar disparos, a diferencia del arma jugador que si lo tiene hecho.
	public Disparo lanzarDisparo(Personaje p)
	{
		final double AMPLITUD_DISPARO = Math.PI / 12;
		
		Vector v = new Vector( );
		
		double ang = (3 * Math.PI / 2) + rand.nextDouble( -AMPLITUD_DISPARO, AMPLITUD_DISPARO );
		
		v.setEnPolares( ang, 5.0);		 
		
		return	new DisparoEnemigo(
					map,
					new Posicion(
						p.getPos().getX() + this.pos.getX(),
						p.getPos().getY() + p.getSize().getHeight() + 5
					),
					v
				);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////