package Enemigo.Estados;

import Arma.ArmaTriple;
import Colisiones.ColDispEnemigo;
import Colisiones.ColKamikaze;
import Enemigo.Transformable;
import Inteligencia.IABorracho;



public class EstadoBorracho extends EstadoKamikazeFragil
{
	public EstadoBorracho(Transformable e)
	{
		contenedor = e;
		vidaMaxima = contenedor.getVida();
		
		contenedor.setIA( new IABorracho( contenedor ) );
		contenedor.setExplosionDmg(100*contenedor.getDificultad());
		contenedor.setColisionador(new ColKamikaze(contenedor.getExplosionDmg()));
		//contenedor.getPanel().setBackground(new Color(0, 100, 0));
		contenedor.setArma(new ArmaTriple(contenedor, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI));
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
		return null; //no tiene siguiente estado, deberíamos crear una excepcion
	}
}