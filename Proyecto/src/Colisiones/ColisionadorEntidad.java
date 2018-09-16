package Colisiones;

import Disparo.Disparo;

public class ColisionadorEntidad extends Colisionador {
	public void afectar(Disparo disparo) {
		disparo.eliminar();
	}
}
