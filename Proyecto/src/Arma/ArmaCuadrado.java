package Arma;

import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;
import Disparo.*;
import Entidad.Personaje;
import Grafica.Posicion;
import Grafica.Size;
import Grafica.Vector;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ArmaCuadrado extends Arma
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ArmaCuadrado()
	{
		panel = new JPanel();
		tamano = new Size(5, 15);
		this.pos = new Posicion(4, 4); // pos
		
		actualizarPanel( true, new Color(255, 255, 255) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Disparo lanzarDisparo(Personaje p)
	{
		final double AMPLITUD_DISPARO = Math.PI / 12;
		
		Vector v = new Vector( );
		
		Random r = new Random();
		double ang = (3 * Math.PI / 2) + (AMPLITUD_DISPARO * ((r.nextDouble() * 2.0) - 1.0));
		
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