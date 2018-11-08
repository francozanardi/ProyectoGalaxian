package Enemigo.Estados;

import Arma.ArmaSniper;
import Enemigo.Transformable;
import Inteligencia.IAGuiado;
import visitor.ColDispEnemigo;
import visitor.ColKamikaze;
import Sprite.Sprite;


public class EstadoKamikaze extends EstadoCamuflado
{
	public EstadoKamikaze(Transformable e)
	{
		contenedor = e;
		vidaMaxima = contenedor.getVida();

		contenedor.setSprite( new Sprite( "/GameSprites/Kamikaze.PNG" ) );
		contenedor.setIA( new IAGuiado(contenedor) );
		contenedor.setExplosionDmg(100*contenedor.getDificultad());
		contenedor.setColisionador(new ColKamikaze(contenedor.getExplosionDmg()));
		contenedor.setArma(new ArmaSniper( contenedor, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI));
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