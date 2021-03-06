package Enemigo.Estados;

import Arma.ArmaTriple;
import Enemigo.Transformable;
import Inteligencia.IABorracho;
import visitor.ColDispEnemigo;
import visitor.ColKamikaze;
import Sprite.Sprite;



public class EstadoBorracho extends EstadoKamikazeFragil
{
	public EstadoBorracho(Transformable e)
	{
		contenedor = e;
		vidaMaxima = contenedor.getVida();

		contenedor.setSprite( new Sprite( "/GameSprites/Kamikaze.PNG" ) );
		contenedor.setIA( new IABorracho( contenedor ) );
		contenedor.setExplosionDmg(100*contenedor.getDificultad());
		contenedor.setColisionador(new ColKamikaze(contenedor.getExplosionDmg()));
		contenedor.setArma(new ArmaTriple(contenedor, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI));
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
		return null; //no tiene siguiente estado, deberķamos crear una excepcion
	}
}