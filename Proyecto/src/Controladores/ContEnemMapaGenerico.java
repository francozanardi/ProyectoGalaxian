package Controladores;

import Enemigo.Borracho;
import Enemigo.Camuflado;
import Enemigo.Comun;
import Enemigo.Enemigo;
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
	
	protected int CHANCE_CREAR_COMUN = 1;
	protected int CHANCE_CREAR_GUIADO = 1;
	protected int CHANCE_CREAR_BORRACHO = 500;
	protected int CHANCE_CREAR_FRAGIL = 1;
	protected int CHANCE_CREAR_CAMUFLADO = 1;
	protected int CHANCE_TOTAL = CHANCE_CREAR_COMUN + CHANCE_CREAR_GUIADO + CHANCE_CREAR_BORRACHO + CHANCE_CREAR_FRAGIL + CHANCE_CREAR_CAMUFLADO;

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
	
	private Enemigo crearEnemigo() {
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
	
	public void crearEnemigos() {
		int cantTotal = (int) (30 + (dificultad * 1));
		
		for(int i = 0; i < cantTotal; i++) {
			enemigosFueraDeJuego.add(crearEnemigo());
		}
		
		agregarEnemigosIniciales();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	/*
	public void crearEnemigos()
	{
		int cantComun		= Math.min( (int) (cantTotal * 60 / 100), cantTotal - 4 ),
			cantGuiado		= Math.max( (int) (cantTotal * 10 / 100), 1 ),
			cantCamuflado	= Math.max( (int) (cantTotal * 10 / 100), 1 ), //para que salga un comun cantTotal deber ser al menos 10. Por lo que se debe estar en nivel 5.
			cantFragil		= Math.max( (int) (cantTotal * 10 / 100), 1 ),
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
	*/
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