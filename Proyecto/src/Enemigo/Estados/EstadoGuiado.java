package Enemigo.Estados;

import Arma.ArmaSniper;
import Colisiones.ColDispEnemigo;
import Colisiones.ColKamikaze;
import Enemigo.Transformable;
import Inteligencia.IAKamikaze;
import Sprite.Sprite;



public class EstadoGuiado extends EstadoKamikazeFragil
{
	protected static final double PORCENTAJE_TRANSFORMACION = 20;
	
	
	
	public EstadoGuiado(Transformable e)
	{
		contenedor = e;
		vidaMaxima = contenedor.getVida();

		contenedor.setSprite( new Sprite( "/GameSprites/Guiado.PNG" ) );
		contenedor.setIA( new IAKamikaze(contenedor) );
		contenedor.setExplosionDmg(100*contenedor.getDificultad());
		contenedor.setColisionador(new ColKamikaze(contenedor.getExplosionDmg()));
		contenedor.setArma(new ArmaSniper( contenedor, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI));
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
		System.out.println("TRANSFORMACION: GUIADO -> BORRACHO");
		return new EstadoBorracho(contenedor);
	}
}