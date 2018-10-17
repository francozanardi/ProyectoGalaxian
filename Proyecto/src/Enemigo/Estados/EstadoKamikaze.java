package Enemigo.Estados;

import java.awt.Color;

import Arma.ArmaSniper;
import Colisiones.ColDispEnemigo;
import Colisiones.ColisionadorKamikaze;
import Enemigo.Transformable;
import Inteligencia.IAKamikaze;

public class EstadoKamikaze extends EstadoCamuflado{

	public EstadoKamikaze(Transformable e) {
		contenedor = e;
		vidaMaxima = contenedor.getVida();
		
		contenedor.setIA(new IAKamikaze(contenedor.getMapa()));
		contenedor.setExplosionDmg(100*contenedor.getDificultad());
		contenedor.setColisionador(new ColisionadorKamikaze(contenedor.getExplosionDmg()));
		contenedor.getPanel().setBackground(new Color(100, 0, 0));
		contenedor.setArma(new ArmaSniper(contenedor.getMapa(), contenedor, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI));
		contenedor.getSize().setHeight(15);
		contenedor.getSize().setWidth(30);
	}

	@Override
	public void controlarTransformacion() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void explotar() {
		contenedor.setVida(0);
		
	}

	@Override
	public Estado transformar() {
		return null; //no tiene siguiente estado, deberíamos crear una excepcions
	}

}
