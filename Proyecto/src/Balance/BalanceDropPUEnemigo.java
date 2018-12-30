package Balance;

public class BalanceDropPUEnemigo extends BalanceDropPU {

	public BalanceDropPUEnemigo(double d) {
		dificultad = d;
	}
	
	@Override
	public int chancePUCongelar() {
		return 2;
	}

	@Override
	public int chancePUEscudoExplosion() {
		return 3;
	}

	@Override
	public int chancePUHeal() {
		return 4;
	}

	@Override
	public int chancePUMinigun() {
		return 2;
	}

	@Override
	public int chancePUMultiplicador() {
		return 3;
	}

	@Override
	public int chanceNoPowerUP() {
		return 70;
	}

	@Override
	public int chancePUVelocidad() {
		return 4;
	}

	@Override
	public int chancePUArmaTriple() {
		return 2;
	}
	
	public int chancePUVelocidadAtaque() {
		return 3;
	}

}
