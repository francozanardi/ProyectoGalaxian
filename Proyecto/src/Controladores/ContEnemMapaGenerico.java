package Controladores;

import Enemigo.Borracho;
import Enemigo.Camuflado;
import Enemigo.Comun;
import Enemigo.Guiado;
import Enemigo.Fragil;
import Entidad.Entidad;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ContEnemMapaGenerico extends ControladorEnemigos
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected double dificultad;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ContEnemMapaGenerico( Mapa mapa, int cantMaximaEnemigosEnPantalla, double dificultad )
	{
		this.map			= mapa;
		this.dificultad		= dificultad;
		this.maxCantEnem	= cantMaximaEnemigosEnPantalla;
		this.rand			= new Randomizador( );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private Entidad obtenerEnemigoAlAzar( )
	{
		int id = rand.nextInt( enemigosFueraDeJuego.size() );
		Entidad enemigo = enemigosFueraDeJuego.get( id );
		enemigosFueraDeJuego.remove( id );
		
		return enemigo;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void agregarEnemigosIniciales( )
	{		
		int tope = Math.min( maxCantEnem, enemigosFueraDeJuego.size() ),
			i;
		Entidad enemigo;
		
		for (i = 0; i < tope; i ++)
		{
			enemigo = obtenerEnemigoAlAzar( );

			enemigosEnJuego.add( enemigo );
			map.addEntity( enemigo );
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void crearEnemigos()
	{
		int cantTotal		= (int) (20 + (dificultad * 4));
		int cantComun		= (int) (cantTotal * 0.60),
			cantGuiado		= (int) (cantTotal * 0.10),
			cantCamuflado	= (int) (cantTotal * 0.10),
			cantFragil		= (int) (cantTotal * 0.10),
			cantBorracho	= cantTotal - cantGuiado - cantComun - cantCamuflado - cantFragil,
			i;

		for (i = 0; i < cantComun; i ++)
			enemigosFueraDeJuego.add( new Comun( map, dificultad ) );
		
		for (i = 0; i < cantGuiado; i ++)
			enemigosFueraDeJuego.add( new Guiado( map, dificultad ) );
		
		for (i = 0; i < cantBorracho; i ++)
			enemigosFueraDeJuego.add( new Borracho( map, dificultad ) );
		
		for (i = 0; i < cantCamuflado; i ++)
			enemigosFueraDeJuego.add( new Camuflado(map, dificultad) );
		
		for (i = 0; i < cantFragil; i ++)
			enemigosFueraDeJuego.add( new Fragil(map, dificultad) );
		
		agregarEnemigosIniciales( );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void liberarEnemigo()
	{
		Entidad enemigo = obtenerEnemigoAlAzar( );
		
		// Asegurarnos que aparezca desde arriba de todo y no al azar en el medio de la pantalla.
		enemigo.setPos( new Posicion( enemigo.getPos().getX(), -25.0 ) );

		enemigosEnJuego.add( enemigo );
		map.addEntity( enemigo );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////