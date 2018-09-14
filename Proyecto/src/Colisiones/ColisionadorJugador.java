package Colisiones;

import Enemigo.Enemigo;
import Enemigo.Kamikaze;
import Jugador.Jugador;

public class ColisionadorJugador extends Colisionador{

	@Override
	public void afectarJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectarEnemigo(Enemigo enemigo) {
		// TODO Auto-generated method stub
		
	}
	
	public void afectarKamikaze(Kamikaze kamikaze) {
		kamikaze.setVida(0);
	}

}
