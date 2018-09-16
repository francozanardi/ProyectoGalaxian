package Colisiones;

import Enemigo.Enemigo;
import Jugador.Jugador;

public class ColisionadorDisparoEnemigo extends Colisionador {

	@Override
	public void afectar(Jugador jugador) {
		jugador.setVida(jugador.getVida()-10);
		if(jugador.getVida() <= 0) {
			jugador.eliminar();
		}
	}

	@Override
	public void afectar(Enemigo enemigo) {
		
	}
	

}
