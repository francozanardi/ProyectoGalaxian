package Controladores;

import Balance.BalanceEnemigo;
import Balance.BalanceEnemigoDefault;
import Enemigo.Borracho;
import Enemigo.Camuflado;
import Enemigo.Comun;
import Enemigo.Enemigo;
import Enemigo.Guiado;
import Enemigo.Sniper;
import Enemigo.Fragil;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;



public class ContEnemMapaGenerico extends ControladorEnemigos
{
	
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
	
	
	
	private Enemigo crearEnemigo() {
		Randomizador rand = Randomizador.create();
		BalanceEnemigo balance = new BalanceEnemigoDefault(dificultad);

		int valorAleatorio = rand.nextInt(balance.getChanceTotal());
		
		if(valorAleatorio < balance.chanceGuiado())
			return new Guiado(map, dificultad);
		valorAleatorio -= balance.chanceGuiado();
		
		if(valorAleatorio < balance.chanceBorracho())
			return new Borracho(map, dificultad);
		valorAleatorio -= balance.chanceBorracho();
		
		if(valorAleatorio < balance.chanceFragil())
			return new Fragil(map, dificultad);
		valorAleatorio -= balance.chanceFragil();
		
		if(valorAleatorio < balance.chanceSniper())
			return new Sniper(map, dificultad);
		valorAleatorio -= balance.chanceSniper();
		
		if(valorAleatorio < balance.chanceCamuflado())
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