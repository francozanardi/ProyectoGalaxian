package Controladores;

import Enemigo.Comun;
import Enemigo.Enemigo;
import Enemigo.Jefe;
import Mapa.Mapa;
import Utils.Posicion;



public class ContEnemBossGenerico extends ControladorEnemigos
{
	protected double dificultad;
	
	
	
	public ContEnemBossGenerico( Mapa mapa, double dificultad )
	{
		this.map		= mapa;
		this.dificultad	= dificultad;
	}
	
	

	public void crearEnemigos()
	{
		Enemigo e;
		
		for (int i = 0, j = (int) dificultad / 5; i < j; i ++)
		{
			e = new Comun(map, dificultad);
			map.addEntity( e );
			enemigosEnJuego.add( e );
		}
		
		
		e = new Jefe(map, dificultad);
		
		map.addEntity( e );
		
		enemigosEnJuego.add( e );
	}


	
	public void liberarEnemigo()
	{		
	}
}
