package Balance;

public abstract class BalanceDropPU {
	protected double dificultad;
	
	public abstract int chancePUCongelar();
	public abstract int chancePUEscudoExplosion();
	public abstract int chancePUHeal();
	public abstract int chancePUMinigun();
	public abstract int chancePUMultiplicador();
	public abstract int chanceNoPowerUP();
	public int getChanceTotal() {
		return chancePUCongelar()+chancePUEscudoExplosion()+chancePUHeal()+chancePUMinigun()+chancePUMultiplicador()+chanceNoPowerUP();
	}

}
