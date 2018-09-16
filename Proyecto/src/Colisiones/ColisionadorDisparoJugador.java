package Colisiones;

import Enemigo.Enemigo;
import Enemigo.Kamikaze;
import Jugador.Jugador;

public class ColisionadorDisparoJugador extends Colisionador {

	@Override
	public void afectar(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Enemigo enemigo) {
		enemigo.setVida(enemigo.getVida()-10);
		if(enemigo.getVida() <= 0) {
			enemigo.eliminar();
			
			//para dar puntaje al jugador lo necesitamos conocer,
			//solucion posible crear atributo de tipo jugador y que lo reciba en el contructor
		}
		
	}
	
	public void afectar(Kamikaze kamikaze) {
		kamikaze.setVida(kamikaze.getVida()-10);
		if(kamikaze.getVida() <= 0) {
			kamikaze.eliminar();
		}
	}

}
