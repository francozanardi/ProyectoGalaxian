package Balance;

public class BalanceDropPUGuiado extends BalanceDropPU {

	public BalanceDropPUGuiado(double d) {
		dificultad = d;
	}
	
	@Override
	public int chancePUCongelar() {
		return 6;
	}

	@Override
	public int chancePUEscudoExplosion() {
		return 15;
	}

	@Override
	public int chancePUHeal() {
		return 20;
	}

	@Override
	public int chancePUMinigun() {
		return 6;
	}

	@Override
	public int chancePUMultiplicador() {
		return 6;
	}

	@Override
	public int chanceNoPowerUP() {
		return 60;
	}

	@Override
	public int chancePUVelocidad() {
		return 5;
	}

	@Override
	public int chancePUArmaTriple() {
		return 7;
	}

}
