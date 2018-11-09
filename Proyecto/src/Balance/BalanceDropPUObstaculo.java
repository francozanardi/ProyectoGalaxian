package Balance;

public class BalanceDropPUObstaculo extends BalanceDropPU {

	@Override
	public int chancePUCongelar() {
		return 15;
	}

	@Override
	public int chancePUEscudoExplosion() {
		return 20;
	}

	@Override
	public int chancePUHeal() {
		return 25;
	}

	@Override
	public int chancePUMinigun() {
		return 20;
	}

	@Override
	public int chancePUMultiplicador() {
		return 20;
	}

	@Override
	public int chancePUVelocidad() {
		return 10;
	}

	@Override
	public int chancePUArmaTriple() {
		return 18;
	}

	@Override
	public int chanceNoPowerUP() {
		return 10;
	}

}
