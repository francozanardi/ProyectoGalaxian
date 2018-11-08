package Balance;

public abstract class BalanceEnemigo {
	protected double dificultad;
	
	public abstract int chanceComun();
	public abstract int chanceGuiado();
	public abstract int chanceBorracho();
	public abstract int chanceFragil();
	public abstract int chanceCamuflado();
	public int getChanceTotal() {
		return chanceComun()+chanceGuiado()+chanceBorracho()+chanceFragil()+chanceCamuflado();
	}
}
