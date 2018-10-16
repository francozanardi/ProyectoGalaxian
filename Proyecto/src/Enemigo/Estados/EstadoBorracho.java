package Enemigo.Estados;

import java.awt.Color;

import Arma.ArmaSniper;
import Arma.ArmaTriple;
import Colisiones.ColDispEnemigo;
import Colisiones.ColisionadorKamikaze;
import Enemigo.Transformable;
import Inteligencia.IABorracho;

public class EstadoBorracho extends EstadoKamikazeFragil {

	public EstadoBorracho(Transformable e) {
		contenedor = e;
		vidaMaxima = contenedor.getVida();
		
		contenedor.setInteligencia(new IABorracho(contenedor.getMapa()));
		contenedor.setExplosionDmg(100*contenedor.getDificultad());
		contenedor.setColisionador(new ColisionadorKamikaze(contenedor.getExplosionDmg()));
		//contenedor.getPanel().setBackground(new Color(0, 100, 0));
		contenedor.setArma(new ArmaTriple(contenedor.getMapa(), contenedor, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI));
		contenedor.getSize().setHeight(15);
		contenedor.getSize().setWidth(30);
	}

	@Override
	protected void transformar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controlarTransformacion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void choque() {
		contenedor.setVida(0);
	}
	
}
