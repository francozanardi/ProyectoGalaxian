package Colisiones;

import Disparo.DisparoEnemigo;
import Disparo.DisparoJugador;

public class ColisionadorEntidad extends Colisionador {
	public void afectar(DisparoEnemigo disparo) {
		disparo.eliminar();
	}
	
	public void afectar(DisparoJugador disparo) {
		disparo.eliminar();
	}
}
