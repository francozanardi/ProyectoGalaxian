package Colisiones;

import Disparo.Disparo;
import Disparo.DisparoJugador;
import Enemigo.Enemigo;
import Jugador.Jugador;

public class ColisionadorKamikaze extends Colisionador {

	@Override
	public void afectar(Jugador jugador) {
		jugador.recibirDMG(100);
		
	}
	
	public void afectar(DisparoJugador disparo) {
		disparo.eliminar();
	}

}
