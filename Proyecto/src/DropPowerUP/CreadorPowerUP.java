package DropPowerUP;

import Balance.BalanceDropPU;
import Mapa.Mapa;
import PowerUp.PUCongelar;
import PowerUp.PUEscudoExplosion;
import PowerUp.PUHeal;
import PowerUp.PUMinigun;
import PowerUp.PUMultiplicador;
import PowerUp.PowerUp;
import Utils.Randomizador;

public abstract class CreadorPowerUP {
	
	protected double dificultad;
	protected Mapa mapa;
	protected BalanceDropPU balance;

	public PowerUp crearDrop() {
		Randomizador rand = Randomizador.create();
		
		int valorAleatorio = rand.nextInt(1, 100);
		
		if(valorAleatorio < balance.porcentajePUCongelar())
			return new PUCongelar(mapa);
		valorAleatorio -= balance.porcentajePUCongelar();
		
		if(valorAleatorio < balance.porcentajePUEscudoExplosion())
			return new PUEscudoExplosion(mapa);
		valorAleatorio -= balance.porcentajePUEscudoExplosion();
		
		if(valorAleatorio < balance.porcentajePUHeal())
			return new PUHeal(mapa);
		valorAleatorio -= balance.porcentajePUHeal();
		
		if(valorAleatorio < balance.porcentajePUMinigun())
			return new PUMinigun(mapa);
		valorAleatorio -= balance.porcentajePUMinigun();
		
		if(valorAleatorio < balance.porcentajePUMultiplicador())
			return new PUMultiplicador(mapa);
		
		return null;
	}
}
