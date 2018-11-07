package Arma;

import java.util.LinkedList;
import java.util.List;

import Disparo.Disparo;


public class ArmaCongelada extends Arma {
	protected Arma armaAntigua;
	public ArmaCongelada(Arma arma) {
		//recibe el arma a copiar	
		armaAntigua = arma;
		inicializar(arma.getPos(), arma.getSize(), arma.getOwner(), arma.getColisionadorDisparo(), arma.getAnguloDisparo(), arma.getCadencia(), arma.getMultDmg());
	}

	@Override
	protected List<Disparo> crearDisparo() {
		return new LinkedList<Disparo>();
	}

	public Arma getArmaAntigua() {
		return armaAntigua;
	}
}
