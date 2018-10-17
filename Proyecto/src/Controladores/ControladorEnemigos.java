package Controladores;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import Entidad.Entidad;
import Mapa.Mapa;
import Utils.Randomizador;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public abstract class ControladorEnemigos
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected Collection<Entidad>	enemigosEnJuego			= new HashSet<Entidad>( );
	protected List<Entidad>			enemigosFueraDeJuego	= new LinkedList<Entidad>( );
	protected Mapa					map;
	protected int					maxCantEnem;
	protected Randomizador			rand;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public abstract void crearEnemigos( );

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public abstract void liberarEnemigo( );

	///////////////////////////////////////////////////////////////////////////////////////////////
	
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

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<Entidad> obtenerEnemigosVivos( )
	{
		List<Entidad> lista = new LinkedList<Entidad>( );
		
		for (Entidad e : enemigosEnJuego)
			lista.add( e );
		
		return lista;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////