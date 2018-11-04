package Enemigo.Estados;

import java.awt.Color;

import Arma.ArmaSniper;
import Colisiones.ColDispEnemigo;
import Colisiones.ColKamikaze;
import Enemigo.Transformable;
import Inteligencia.IAKamikaze;

public class EstadoKamikaze extends EstadoCamuflado
{
	public EstadoKamikaze(Transformable e)
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
	}
	
	public void explotar()
	{
		contenedor.setVida(0);
		
	}

	public Estado transformar()
	{
		return null; //no tiene siguiente estado, deberíamos crear una excepcions
	}
}