package Arma;

import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;
import Disparo.*;
import Entidad.Personaje;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;
import Utils.Vector;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ArmaCuadrado extends Arma
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ArmaCuadrado( )
	{
		this.rand	= new Randomizador( );
		this.panel	= new JPanel();
		this.tamano	= new Size(5, 15);
		this.pos	= new Posicion(4, 4); // pos
		
		actualizarPanel( true, new Color(255, 255, 255) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Disparo lanzarDisparo(Personaje p)
	{
		final double AMPLITUD_DISPARO = Math.PI / 24;
		
		Vector v = new Vector( );
		
		Random r = new Random();
		double ang = (3 * Math.PI / 2) + rand.nextDouble( -AMPLITUD_DISPARO, AMPLITUD_DISPARO );
		
		v.setEnPolares( ang, 5.0);		 
		
		return	new DisparoEnemigo(
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