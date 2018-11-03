package Enemigo.Estados;

import java.awt.Color;

import Arma.ArmaDefaultEnemigo;
import Colisiones.ColDispEnemigo;
import Colisiones.ColEnemigo;
import Enemigo.Transformable;
import Inteligencia.IAComun;
import Utils.Randomizador;



public class EstadoComun extends EstadoCamuflado
{
	protected static final double PORCENTAJE_TRANSFORMACION = 50;
	
	
	
	public EstadoComun(Transformable e)
	{
		contenedor = e;
		vidaMaxima = contenedor.getVida();
		contenedor.setIA( new IAComun(contenedor) );
		contenedor.setColisionador(new ColEnemigo());
	
		Randomizador rand = Randomizador.create( );
		contenedor.getPanel().setBackground(new Color( rand.nextInt(128, 255), rand.nextInt(128, 255), rand.nextInt(128, 255) ));
		contenedor.setArma(new ArmaDefaultEnemigo(contenedor, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI));
		contenedor.getSize().setHeight(15);
		contenedor.getSize().setWidth(15);
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
		return new EstadoKamikaze(contenedor);
	}
}
