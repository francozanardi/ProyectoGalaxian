package Controladores;

import Enemigo.Borracho;
import Enemigo.Camuflado;
import Enemigo.Comun;
import Enemigo.Enemigo;
import Enemigo.Guiado;
import Enemigo.Fragil;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;



public class ContEnemMapaGenerico extends ControladorEnemigos
{
	protected final int CHANCE_CREAR_COMUN		= 20,
						CHANCE_CREAR_GUIADO		= 20,
						CHANCE_CREAR_BORRACHO	= 20,
						CHANCE_CREAR_FRAGIL		= 20,
						CHANCE_CREAR_CAMUFLADO	= 20,
						CHANCE_TOTAL			= CHANCE_CREAR_COMUN + CHANCE_CREAR_GUIADO + CHANCE_CREAR_BORRACHO + CHANCE_CREAR_FRAGIL + CHANCE_CREAR_CAMUFLADO;

	
	
	protected double dificultad;

	
	
	public ContEnemMapaGenerico( Mapa mapa, int cantMaximaEnemigosEnPantalla, double dificultad )
	{
		this.map			= mapa;
		this.dificultad		= dificultad;
		this.maxCantEnem	= cantMaximaEnemigosEnPantalla;
	}


	
	private Enemigo obtenerEnemigoAlAzar( )
	{
		Randomizador rand = Randomizador.create();
		
		int id = rand.nextInt( enemigosFueraDeJuego.size() );
		Enemigo enemigo = enemigosFueraDeJuego.get( id );
		enemigosFueraDeJuego.remove( id );
		
		return enemigo;
	}


	
	private void agregarEnemigosIniciales( )
	{		
		int tope = Math.min( maxCantEnem, enemigosFueraDeJuego.size() ),
			i;
		Enemigo enemigo;
		
		for (i = 0; i < tope; i ++)
		{
			enemigo = obtenerEnemigoAlAzar( );

			enemigosEnJuego.add( enemigo );
			map.addEntity( enemigo );
		}
	}
	
	
	
	private Enemigo crearEnemigo()
	{
		Randomizador rand = Randomizador.create();
		
		int valorAleatorio = rand.nextInt(CHANCE_TOTAL);
		
		if(valorAleatorio < CHANCE_CREAR_GUIADO)
			return new Guiado(map, dificultad);
		valorAleatorio -= CHANCE_CREAR_GUIADO;
		
		if(valorAleatorio < CHANCE_CREAR_BORRACHO)
			return new Borracho(map, dificultad);
		valorAleatorio -= CHANCE_CREAR_BORRACHO;
		
		if(valorAleatorio < CHANCE_CREAR_FRAGIL)
			return new Fragil(map, dificultad);
		valorAleatorio -= CHANCE_CREAR_FRAGIL;
		
		if(valorAleatorio < CHANCE_CREAR_CAMUFLADO)
			return new Camuflado(map, dificultad);
		
		return new Comun(map, dificultad);
	}
	
	
	
	public void crearEnemigos()
	{
		int cantTotal = (int) (8 + (dificultad * 2));
		
		for(int i = 0; i < cantTotal; i++)
		{
			enemigosFueraDeJuego.add(crearEnemigo());
		}
		
		agregarEnemigosIniciales();
	}


	
	public void liberarEnemigo()
	{
		Enemigo enemigo = obtenerEnemigoAlAzar( );
		
		// Asegurarnos que aparezca desde arriba de todo y no al azar en el medio de la pantalla.
		enemigo.setPos( new Posicion( enemigo.getPos().getX(), -25.0 ) );

		enemigosEnJuego.add( enemigo );
		map.addEntity( enemigo );
	}
}