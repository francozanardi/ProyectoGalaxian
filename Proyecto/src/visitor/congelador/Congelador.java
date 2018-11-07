package visitor.congelador;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Enemigo.Kamikaze;
import Jugador.Jugador;
import Obstaculo.Barricada;
import Obstaculo.Destructible;
import PowerUp.PUCongelarLogica;
import PowerUp.PowerUp;
import visitor.Visitor;

public class Congelador extends Visitor {

	protected PUCongelarLogica logicaCongelar;
	
	public Congelador(PUCongelarLogica logica) {
		logicaCongelar = logica;
	}
	
	@Override
	public void visit(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Enemigo enemigo) {
		logicaCongelar.congelarEntidad(enemigo);
	}

	@Override
	public void visit(Kamikaze kamikaze) {
		logicaCongelar.congelarEntidad(kamikaze);
	}

	@Override
	public void visit(Disparo disparo) {
	
	}

	@Override
	public void visit(PowerUp powerup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Destructible obstaculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Barricada barricada) {
		// TODO Auto-generated method stub
		
	}
	

}
