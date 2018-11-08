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
		return 5;
	}

	@Override
	public int chancePUHeal() {
		return 7;
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
		return 100-chancePUCongelar()-chancePUEscudoExplosion()-chancePUHeal()-chancePUMinigun()-chancePUMultiplicador();
	}

}
