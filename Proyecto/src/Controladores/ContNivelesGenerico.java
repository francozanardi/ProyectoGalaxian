package Controladores;

import Jugador.Jugador;
import Logica.Juego;
import Mapa.MapaGenerico;



public class ContNivelesGenerico extends ControladorNiveles
{
	public ContNivelesGenerico( Juego game, Jugador player )
	{
		jugador = player;
		juego = game;
	}
	
	
	
	private void establecerNivel( int nivelID )
	{
		stopMap( );
		
		juego.resetPanel();
		   
		startMap( new MapaGenerico( juego, this, jugador, "MAPA GENÉRICO LVL." + nivelID, (1.0 * nivelID) ) );
		
		System.out.println( "COMIENZA EL NIVEL " + nivelID );
	}

	
	
	
	public void mapVictory( Jugador player )
	{
		nivel ++;
		establecerNivel( nivel );
		
		System.out.println("VICTORY!!");
	}

	public void mapDefeat( Jugador player )
	{
		stopMap( );
		
		gameEnd();
		
		System.out.println("DEFEAT!!");
	}

	
	
	public void gameStart()
	{
		nivel = 1;
		establecerNivel( 1 );
		
		System.out.println("GAME START!!");
	}

	public void gameEnd()
	{
		stopMap(); //provisioria

		juego.endGame();
		
		System.out.println("GAME OVER!!");
	}
}
