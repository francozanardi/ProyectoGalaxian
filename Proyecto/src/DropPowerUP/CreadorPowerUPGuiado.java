package DropPowerUP;

import Balance.BalanceDropPUGuiado;
import Mapa.Mapa;

public class CreadorPowerUPGuiado extends CreadorPowerUP {
	public CreadorPowerUPGuiado(Mapa mapa, double dif) {
		this.mapa = mapa;
		this.dificultad = dif;
		
		balance = new BalanceDropPUGuiado(dificultad);
	}
}
