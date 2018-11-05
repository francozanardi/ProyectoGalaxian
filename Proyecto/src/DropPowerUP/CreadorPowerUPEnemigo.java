package DropPowerUP;

import Balance.BalanceDropPUEnemigo;
import Mapa.Mapa;

public class CreadorPowerUPEnemigo extends CreadorPowerUP {
	
	public CreadorPowerUPEnemigo(Mapa mapa, double dificultad) {
		this.dificultad = dificultad;
		this.mapa = mapa;
		
		balance = new BalanceDropPUEnemigo(dificultad);
	}

}
