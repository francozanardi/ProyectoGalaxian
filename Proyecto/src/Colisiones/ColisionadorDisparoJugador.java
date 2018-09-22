package Colisiones;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Enemigo.Kamikaze;
import Entidad.Personaje;
import Jugador.Jugador;

public class ColisionadorDisparoJugador extends Colisionador {
	private Disparo disparo;
	private Personaje jugador;
	
	public ColisionadorDisparoJugador(Disparo d, Personaje j) {
		disparo = d;
		jugador = j;
	}
	
	@Override
	public void afectar(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar(Enemigo enemigo) {
		enemigo.setVida(enemigo.getVida()-10);
		if(enemigo.getVida() <= 0) {
			jugador.setPuntaje(jugador.getPuntaje()+enemigo.getPuntaje());
			enemigo.eliminar();
			
			//para dar puntaje al jugador lo necesitamos conocer,
			//solucion posible crear atributo de tipo jugador y que lo reciba en el constructor
		}
		
	}
	
	public void afectar(Kamikaze kamikaze) {
		kamikaze.setVida(kamikaze.getVida()-10);
		if(kamikaze.getVida() <= 0) {
			jugador.setPuntaje(jugador.getPuntaje()+kamikaze.getPuntaje());
			kamikaze.eliminar();
		}
	}

}
