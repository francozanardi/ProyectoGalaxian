package Balance;

public class BalanceDropPUGuiado extends BalanceDropPU {

	public BalanceDropPUGuiado(double d) {
		dificultad = d;
	}
	
	@Override
	public int porcentajePUCongelar() {
		return 6;
	}

	@Override
	public int porcentajePUEscudoExplosion() {
		return 15;
	}

	@Override
	public int porcentajePUHeal() {
		return 20;
	}

	@Override
	public int porcentajePUMinigun() {
		return 6;
	}

	@Override
	public int porcentajePUMultiplicador() {
		return 6;
	}

	@Override
	public int porcentajeNoPowerUP() {
		return 100-porcentajePUCongelar()-porcentajePUEscudoExplosion()-porcentajePUHeal()-porcentajePUMinigun()-porcentajePUMultiplicador();
	}

}
