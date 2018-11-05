package Balance;

public class BalanceEnemigoDefault extends BalanceEnemigo {

	public BalanceEnemigoDefault(double d) {
		dificultad = d;
	}

	@Override
	public int porcentajeComun() {
		return 100-porcentajeGuiado()-porcentajeBorracho()-porcentajeCamuflado()-porcentajeFragil();
	}

	@Override
	public int porcentajeGuiado() {
		return (int)Math.min(Math.floor(Math.sqrt(Math.PI*2*(dificultad+10))), 15);
	}

	@Override
	public int porcentajeBorracho() {
		return (int)Math.min(Math.floor(2*Math.sqrt(2*(dificultad+10))), 20);
	}

	@Override
	public int porcentajeFragil() {
		return (int)Math.min(Math.floor(2.25*Math.sqrt(dificultad)), 25);
	}

	@Override
	public int porcentajeCamuflado() {
		return (int)Math.min(Math.floor(2.25*Math.sqrt(dificultad)), 25);
	}
	
	//me gustaría en vez de manejarnos por porcentajes, internamente utilizar chances y ahí recién calcular el porcentaje. Ya que 
	//de esta forma, agregar un nuevo enemigo implica balancear todos los demás.

}
