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
	
	public ArmaJugador(Mapa map)
	{
		this.rand	= new Randomizador( );
		this.panel	= new JPanel();
		this.tamano	= new Size(10, 20);
		this.pos	= new Posicion(3, 3);
		this.tiempoUltimoDisparo = 0;
		this.velocidad = 5; //o Juego.FPS / 3
		this.map = map;
		
		actualizarPanel( true, new Color(0, 0, 105) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Disparo lanzarDisparo(Personaje p)
	{
		long	tiempoActual = System.nanoTime(),
				tiempoFinal = tiempoUltimoDisparo + TIEMPO_DISPARO/velocidad;
		
		if(tiempoActual >= tiempoFinal) {
			tiempoUltimoDisparo = System.nanoTime();
			Vector v = new Vector();
			v.setEnPolares( Math.PI / 2, 5.0 );

			return	new DisparoJugador(
						map,
						new Posicion(
							p.getPos().getX() + this.pos.getX(),
							p.getPos().getY() - 5
						),
						v
					);
		}
		
		return null;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////