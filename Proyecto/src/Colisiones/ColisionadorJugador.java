package Colisiones;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Enemigo.Kamikaze;
import Jugador.Jugador;

public class ColisionadorJugador extends Colisionador{
	
	public void afectar(Kamikaze kamikaze) {
		kamikaze.setVida(0);
		//falta lo del puntaje
		kamikaze.eliminar();
	}
	
	public void afectar(Disparo disparo) {
		disparo.eliminar();
	}

}
