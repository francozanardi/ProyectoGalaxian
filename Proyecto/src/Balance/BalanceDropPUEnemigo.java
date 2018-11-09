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
		return 6;
	}

	@Override
	public int chancePUMinigun() {
		return 6;
	}

	@Override
	public int chancePUMultiplicador() {
		return 2;
	}

	@Override
	public int chanceNoPowerUP() {
		return 70;
	}

	@Override
	public int chancePUVelocidad() {
		return 3;
	}

	@Override
	public int chancePUArmaTriple() {
		return 3;
	}

}
