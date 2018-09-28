package Colisiones;

import Disparo.Disparo;
import Disparo.DisparoEnemigo;
import Enemigo.Enemigo;
import Enemigo.Kamikaze;
import Jugador.Jugador;

public class ColisionadorJugador extends Colisionador{
	
	public void afectar(Kamikaze kamikaze) {
		kamikaze.recibirDMG(kamikaze.getVida());
	}
	
	public void afectar(DisparoEnemigo disparo) {
		disparo.eliminar();
	}

}
