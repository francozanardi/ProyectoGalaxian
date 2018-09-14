package Colisiones;

import Enemigo.Enemigo;
import Jugador.Jugador;

public class ColisionadorDisparoEnemigo extends Colisionador {

	@Override
	public void afectarJugador(Jugador jugador) {
		jugador.setVida(jugador.getVida()-10);
	}

	@Override
	public void afectarEnemigo(Enemigo enemigo) {
		
	}
	

}
