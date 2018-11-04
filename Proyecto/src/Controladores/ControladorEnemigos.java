package Controladores;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import Enemigo.Enemigo;
import Entidad.Entidad;
import Mapa.Mapa;



public abstract class ControladorEnemigos
{	
	protected Collection<Enemigo>	enemigosEnJuego			= new HashSet<Enemigo>( );
	protected List<Enemigo>			enemigosFueraDeJuego	= new LinkedList<Enemigo>( );
	protected Mapa					map;
	protected int					maxCantEnem;


	
	public abstract void crearEnemigos( );
	
	public abstract void liberarEnemigo( );


	
	public void notificarMuerteEntidad( Entidad e )
	{
		if (enemigosEnJuego.contains(e))
		{
			enemigosEnJuego.remove( e );
			
			System.out.printf("ingame: %d, waiting: %d\n", enemigosEnJuego.size(), enemigosFueraDeJuego.size() );
			
			if (enemigosEnJuego.size() > 0)
			{
				if (enemigosFueraDeJuego.size() > 0)
					liberarEnemigo( );
			}
			else
			{
				if (enemigosFueraDeJuego.size() == 0)
					map.ganar();
			}
		}
	}


	
	public List<Enemigo> obtenerEnemigosVivos( )
	{
		List<Enemigo> lista = new LinkedList<Enemigo>( );
		
		for (Enemigo e : enemigosEnJuego)
			lista.add( e );
		
		return lista;
	}
}