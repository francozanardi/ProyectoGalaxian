package Inteligencia;

import java.util.Timer;

import Arma.ArmaCongelada;



public class IACongelado extends Inteligencia
{

	protected Inteligencia iaAntigua; //Inteligencia debería ser.
	protected Timer timerCongelado;
	protected ArmaCongelada armaCongelada;
	
	public IACongelado(Inteligencia iaAntigua, ArmaCongelada arma) {
		this.iaAntigua = iaAntigua;
		this.timerCongelado = null;
		this.armaCongelada = arma;
	}
	
	public void mover( double msDesdeUltActualizacion )
	{
	}
	
	public Inteligencia getInteligenciaAntigua() {
		return iaAntigua;
	}
	
	public ArmaCongelada getArmaNueva() {
		return armaCongelada;
	}
	
	public Timer getTimer() {
		return timerCongelado;
	}
	
	public void setTimer(Timer t) {
		timerCongelado = t;
	}

}
