package DropPowerUP;

import Balance.BalanceDropPU;
import Mapa.Mapa;
import PowerUp.PUArmaTriple;
import PowerUp.PUCongelar;
import PowerUp.PUEscudoExplosion;
import PowerUp.PUHeal;
import PowerUp.PUMinigun;
import PowerUp.PUMultiplicador;
import PowerUp.PUVelocidadMovimiento;
import PowerUp.PowerUp;
import Utils.Randomizador;

public abstract class CreadorPowerUP {
	
	protected double dificultad;
	protected Mapa mapa;
	protected BalanceDropPU balance;

	public PowerUp crearPowerUP() {
		Randomizador rand = Randomizador.create();
		
		int valorAleatorio = rand.nextInt(balance.getChanceTotal());
		
		if(valorAleatorio < balance.chancePUCongelar())
			return new PUCongelar(mapa);
		valorAleatorio -= balance.chancePUCongelar();
		
		if(valorAleatorio < balance.chancePUEscudoExplosion())
			return new PUEscudoExplosion(mapa);
		valorAleatorio -= balance.chancePUEscudoExplosion();
		
		if(valorAleatorio < balance.chancePUHeal())
			return new PUHeal(mapa);
		valorAleatorio -= balance.chancePUHeal();
		
		if(valorAleatorio < balance.chancePUMinigun())
			return new PUMinigun(mapa);
		valorAleatorio -= balance.chancePUMinigun();
		
		if(valorAleatorio < balance.chancePUMultiplicador())
			return new PUMultiplicador(mapa);
		valorAleatorio -= balance.chancePUMultiplicador();
		
		if(valorAleatorio < balance.chancePUVelocidad())
			return new PUVelocidadMovimiento(mapa);
		valorAleatorio -= balance.chancePUVelocidad();
		
		if(valorAleatorio < balance.chancePUArmaTriple())
			return new PUArmaTriple(mapa);
		
		return null;
	}
}
