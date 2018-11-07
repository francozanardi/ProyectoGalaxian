package Enemigo.Estados;

import Arma.ArmaDefaultEnemigo;
import Enemigo.Transformable;
import Inteligencia.IAComun;
import visitor.ColDispEnemigo;
import visitor.ColEnemigo;
import Sprite.Sprite;

public class EstadoComun extends EstadoCamuflado
{
	protected static final double PORCENTAJE_TRANSFORMACION = 50;
	
	
	
	public EstadoComun(Transformable e)
	{
		contenedor = e;
		vidaMaxima = contenedor.getVida();
		contenedor.setIA( new IAComun(contenedor) );
		contenedor.setColisionador(new ColEnemigo());
		
		contenedor.setSprite( new Sprite( "/GameSprites/Comun.PNG" ) );
		contenedor.setArma(new ArmaDefaultEnemigo(contenedor, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI));
		contenedor.setExplosionDmg(0);
	}


	
	public void controlarTransformacion()
	{
		if(contenedor.getVida() <= vidaMaxima*PORCENTAJE_TRANSFORMACION/100 ){
			contenedor.transformar();
		}
	}

	public void explotar()
	{
	}

	public Estado transformar()
	{
		System.out.println("CAMUFLADO: COMUN -> KAMIKAZE");
		return new EstadoKamikaze(contenedor);
	}
}
