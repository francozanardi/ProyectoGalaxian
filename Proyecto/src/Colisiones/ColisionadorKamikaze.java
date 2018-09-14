package Colisiones;

import Enemigo.Enemigo;
import Jugador.Jugador;

public class ColisionadorKamikaze extends Colisionador {

	@Override
	public void afectarJugador(Jugador jugador) {
		jugador.setVida(jugador.getVida()-100);
		
	}

	@Override
	public void afectarEnemigo(Enemigo enemigo) {
		// TODO Auto-generated method stub
		
	}

}
