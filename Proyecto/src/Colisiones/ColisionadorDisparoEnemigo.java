package Colisiones;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Jugador.Jugador;

public class ColisionadorDisparoEnemigo extends Colisionador {
	private Disparo disparo;
	
	public ColisionadorDisparoEnemigo(Disparo disp) {
		disparo = disp;
	}
	
	@Override
	public void afectar(Jugador jugador) {
		jugador.recibirDMG(10);
	}

	@Override
	public void afectar(Enemigo enemigo) {
		
	}
	

}
