package Balance;

public class BalanceDropPUEnemigo extends BalanceDropPU {

	public BalanceDropPUEnemigo(double d) {
		dificultad = d;
	}
	
	@Override
	public int porcentajePUCongelar() {
		return 100;
	}

	@Override
	public int porcentajePUEscudoExplosion() {
		return 5;
	}

	@Override
	public int porcentajePUHeal() {
		return 7;
	}

	@Override
	public int porcentajePUMinigun() {
		return 6;
	}

	@Override
	public int porcentajePUMultiplicador() {
		return 2;
	}

	@Override
	public int porcentajeNoPowerUP() {
		return 100-porcentajePUCongelar()-porcentajePUEscudoExplosion()-porcentajePUHeal()-porcentajePUMinigun()-porcentajePUMultiplicador();
	}

}
