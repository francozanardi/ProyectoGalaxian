package Arma;

import java.util.LinkedList;
import java.util.List;

import Disparo.Disparo;
import Utils.Posicion;


public class ArmaCongelada extends Arma {
	protected Arma armaAntigua;
	public ArmaCongelada(Arma arma) {
		//recibe el arma a copiar	
		armaAntigua = arma;
		
		//la posicion que se crea es el offset, debería de obtenerlo del arma, pero el arma no lo tiene como atributo
		//de manera temporal queda así.
		inicializar(arma.getSprite(), new Posicion(0, 0), arma.getOwner(), arma.getColisionadorDisparo(), arma.getAnguloDisparo(), arma.getCadencia(), arma.getMultDmg());
	}

	@Override
	protected List<Disparo> crearDisparo() {
		return new LinkedList<Disparo>();
	}

	public Arma getArmaAntigua() {
		return armaAntigua;
	}
}
