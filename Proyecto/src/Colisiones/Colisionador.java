package Colisiones;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Enemigo.Kamikaze;
import Entidad.EntidadConVida;
import Jugador.Jugador;

public abstract class Colisionador {
	public abstract void afectarJugador(Jugador jugador);
	public abstract void afectarEnemigo(Enemigo enemigo);
	public void afectarKamikaze(Kamikaze kamikaze) {

	}
}
