package Colisiones;

import Enemigo.Enemigo;
import Enemigo.Kamikaze;
import Jugador.Jugador;

public class ColisionadorDisparoJugador extends Colisionador {

	@Override
	public void afectarJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectarEnemigo(Enemigo enemigo) {
		enemigo.setVida(enemigo.getVida()-10);
		
	}
	
	public void afectarKamikaze(Kamikaze kamikaze) {
		kamikaze.setVida(kamikaze.getVida()-10);
	}

}
