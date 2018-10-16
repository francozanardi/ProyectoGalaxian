package Enemigo.Estados;

import java.awt.Color;

import Arma.ArmaSniper;
import Colisiones.ColDispEnemigo;
import Colisiones.ColisionadorKamikaze;
import Enemigo.Enemigo;
import Enemigo.Transformable;
import Inteligencia.IABorracho;
import Inteligencia.IAKamikaze;

public class EstadoGuiado extends EstadoKamikazeFragil {
	
	protected static final double PORCENTAJE_TRANSFORMACION = 20;
	
	public EstadoGuiado(Transformable e) {
		contenedor = e;
		vidaMaxima = contenedor.getVida();
		
		contenedor.setInteligencia(new IAKamikaze(contenedor.getMapa()));
		contenedor.setExplosionDmg(100*contenedor.getDificultad());
		contenedor.setColisionador(new ColisionadorKamikaze(contenedor.getExplosionDmg()));
		contenedor.getPanel().setBackground(new Color(100, 0, 0));
		contenedor.setArma(new ArmaSniper(contenedor.getMapa(), contenedor, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI));
		contenedor.getSize().setHeight(15);
		contenedor.getSize().setWidth(30);

	}
	
	@Override
	protected void transformar() {
		contenedor.setInteligencia(new IABorracho(contenedor.getMapa()));
		contenedor.setEstado(new EstadoBorracho(contenedor));
	}

	@Override
	public void controlarTransformacion() {
		if(contenedor.getVida() <= vidaMaxima*PORCENTAJE_TRANSFORMACION/100 ) {
			transformar();
		}
	}

	@Override
	public void choque() {
		contenedor.setVida(0);
	}

}
