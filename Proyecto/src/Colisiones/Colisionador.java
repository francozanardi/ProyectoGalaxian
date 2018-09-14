package Colisiones;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Entidad.EntidadConVida;
import Jugador.Jugador;

public class Colisionador extends Colisiones {
	public void huboColision(Enemigo emisor, Jugador receptor, Disparo disparo) {
		receptor.setVida(receptor.getVida()-(10*disparo.getFuerza()));
	}
	
	public void huboColision(Enemigo emisor, Enemigo receptor, Disparo disparo) {
		//nada ya que ambos son enemigos.
	}
	
	//si el receptor es una entidad con vida que no es un jugador o un enemigo.
	public void huboColision(Enemigo emisor, EntidadConVida receptor, Disparo disparo) { 
		receptor.setVida(receptor.getVida()-(5*disparo.getFuerza()));
	}
	
	public void huboColision(Jugador emisor, Enemigo receptor, Disparo disparo) {
		receptor.setVida(receptor.getVida()-(10*disparo.getFuerza()));
	}
	
	//si el receptor es una entidad con vida distinta a un enemigo
	public void huboColision(Jugador emisor, EntidadConVida receptor, Disparo disparo) {
		receptor.setVida(receptor.getVida()-(5*disparo.getFuerza()));
	}
	
}
