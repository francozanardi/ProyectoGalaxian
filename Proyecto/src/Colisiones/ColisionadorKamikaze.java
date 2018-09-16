package Colisiones;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Jugador.Jugador;

public class ColisionadorKamikaze extends Colisionador {

	@Override
	public void afectar(Jugador jugador) {
		jugador.setVida(jugador.getVida()-100);
		if(jugador.getVida() <= 0) {
			jugador.eliminar();
		}
		
	}
	
	public void afectar(Disparo disparo) {
		disparo.eliminar();
	}

}
