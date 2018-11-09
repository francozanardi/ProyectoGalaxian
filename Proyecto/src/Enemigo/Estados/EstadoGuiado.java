package Enemigo.Estados;

import Arma.ArmaNula;
import Enemigo.Transformable;
import Inteligencia.IAGuiado;
import visitor.ColKamikaze;
import Sprite.Sprite;

public class EstadoGuiado extends EstadoKamikazeFragil
{
	protected static final double PORCENTAJE_TRANSFORMACION = 20;
	
	
	
	public EstadoGuiado(Transformable e)
	{
		contenedor = e;
		vidaMaxima = contenedor.getVida();

		contenedor.setSprite( new Sprite( "/GameSprites/Guiado.PNG" ) );
		contenedor.setIA( new IAGuiado(contenedor) );
		contenedor.setExplosionDmg(100*contenedor.getDificultad());
		contenedor.setColisionador(new ColKamikaze(contenedor.getExplosionDmg()));
		contenedor.setArma(new ArmaNula());
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