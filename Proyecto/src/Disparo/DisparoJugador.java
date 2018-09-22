package Disparo;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;

import Colisiones.Colisionador;
import Colisiones.ColisionadorDisparoJugador;
import Entidad.Personaje;
import Jugador.Jugador;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Size;
import Utils.Vector;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class DisparoJugador extends Disparo
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public DisparoJugador(Mapa mapa, Posicion p, Personaje jugador, Vector vectorDireccion)
	{
		panel = new JPanel();
		pos = p;
		tamano = new Size(5, 5);
		fuerza = 1;
		vecDireccion = vectorDireccion;
		map = mapa;
		
		actualizarPanel( true, Color.cyan );
		
		colisionador = new ColisionadorDisparoJugador(this, jugador);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void serChocado(Colisionador col) {
		col.afectar(this);
	}
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////