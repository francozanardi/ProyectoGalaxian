package DropPowerUP;

import Balance.BalanceDropPUObstaculo;
import Mapa.Mapa;

public class CreadorPowerUPObstaculo extends CreadorPowerUP {

	public CreadorPowerUPObstaculo(Mapa map, double dificultad) {
		this.mapa = map;
		this.dificultad = dificultad;
		this.balance = new BalanceDropPUObstaculo();
	}
}
