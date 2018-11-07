package Enemigo.Estados;

import java.awt.Color;

import Arma.ArmaSniper;
import Enemigo.Transformable;
import Inteligencia.IAKamikaze;
import visitor.ColDispEnemigo;
import visitor.ColKamikaze;



public class EstadoGuiado extends EstadoKamikazeFragil
{
	protected static final double PORCENTAJE_TRANSFORMACION = 20;
	
	
	
	public EstadoGuiado(Transformable e)
	{
		contenedor = e;
		vidaMaxima = contenedor.getVida();
		
		contenedor.setIA( new IAKamikaze(contenedor) );
		contenedor.setExplosionDmg(100*contenedor.getDificultad());
		contenedor.setColisionador(new ColKamikaze(contenedor.getExplosionDmg()));
		contenedor.getPanel().setBackground(new Color(100, 0, 0));
		contenedor.setArma(new ArmaSniper( contenedor, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI));
		contenedor.getSize().setHeight(15);
		contenedor.getSize().setWidth(30);

	}


	
	public void controlarTransformacion()
	{
		if(contenedor.getVida() <= vidaMaxima*PORCENTAJE_TRANSFORMACION/100 ) {
			contenedor.transformar();
		}
	}

	public void explotar()
	{
		contenedor.setVida(0);
	}

	public Estado transformar()
	{
		return new EstadoBorracho(contenedor);
	}
}