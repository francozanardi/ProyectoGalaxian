package Balance;

public class BalanceEnemigoDefault extends BalanceEnemigo {

	public BalanceEnemigoDefault(double d) {
		dificultad = d;
	}

	@Override
	public int chanceComun() {
		return 80;
	}

	@Override
	public int chanceGuiado() {
		return (int)Math.floor(Math.sqrt(Math.PI*2*(dificultad+10)));
	}

	@Override
	public int chanceBorracho() {
		return (int)Math.floor(2*Math.sqrt(2*(dificultad+10)));
	}

	@Override
	public int chanceFragil() {
		return (int)Math.floor(2.25*Math.sqrt(dificultad)) + 10;
	}

	@Override
	public int chanceCamuflado() {
		return (int)Math.floor(3.25*Math.sqrt(dificultad));
	}

	@Override
	public int chanceSniper() {
		return (int)Math.floor(2*Math.sqrt(2*(dificultad+10)));
	}
	
}
