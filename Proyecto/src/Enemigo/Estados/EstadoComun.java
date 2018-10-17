package Enemigo.Estados;

import java.awt.Color;
import java.util.Random;

import Arma.ArmaDefaultEnemigo;
import Arma.ArmaSniper;
import Colisiones.ColDispEnemigo;
import Colisiones.ColisionadorEnemigo;
import Colisiones.ColisionadorKamikaze;
import Enemigo.Transformable;
import Inteligencia.IAComun;
import Inteligencia.IAKamikaze;
import Utils.Randomizador;

public class EstadoComun extends EstadoCamuflado {

	protected static final double PORCENTAJE_TRANSFORMACION = 50;
	
	public EstadoComun(Transformable e) {
		contenedor = e;
		vidaMaxima = contenedor.getVida();
		contenedor.setIA(new IAComun(contenedor.getMapa()));
		contenedor.setColisionador(new ColisionadorEnemigo());
	
		Randomizador rand = new Randomizador();
		contenedor.getPanel().setBackground(new Color( rand.nextInt(128, 255), rand.nextInt(128, 255), rand.nextInt(128, 255) ));
		contenedor.setArma(new ArmaDefaultEnemigo(contenedor.getMapa(), contenedor, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI));
		contenedor.getSize().setHeight(15);
		contenedor.getSize().setWidth(15);
		contenedor.setExplosionDmg(0);
	}

	@Override
	public void controlarTransformacion() {
		if(contenedor.getVida() <= vidaMaxima*PORCENTAJE_TRANSFORMACION/100 ) {
			contenedor.transformar();
		}
	}

	@Override
	public void explotar() {
		
	}

	@Override
	public Estado transformar() {
		return new EstadoKamikaze(contenedor);
	}

}
