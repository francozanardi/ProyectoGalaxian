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
		//ac� est� el error del powerup en la esquina superior izquierda. 
		//se le env�a el mensaje al thread de no avance m�s, pero se termina esa �ltima 'vuelta' que est� haciendo.
		
		//por este otro hilo se llama al m�todo resetPanel(), donde se borra todo los paneles.
		juego.getPanel().removeAllEntities();
		
		//sin embargo el thread a�n sigue corriendo, y agrega todas las entidades a agregar que ten�a en el panel.
		//finalmente el panel queda con entidades que no deber�a tener.
		startMap( new MapaGenerico( juego, this, jugador, "LEVEL " + nivelID, (1.0 * nivelID) ) );
		
		if (Juego.DEBUG)
			System.out.println( "COMIENZA EL NIVEL " + nivelID );
	}

	
	
	
	public void mapVictory( Jugador player )
	{
		nivel ++;
		establecerNivel( nivel );
		
		if (Juego.DEBUG)
			System.out.println("MAP VICTORY");
	}

	public void mapDefeat( Jugador player )
	{
		stopMap( );
		
		gameEnd();

		if (Juego.DEBUG)
			System.out.println("MAP DEFEAT");
	}

	
	
	public void gameStart()
	{
		nivel = 1;
		establecerNivel( 1 );

		if (Juego.DEBUG)
			System.out.println("GAME START");
	}

	public void gameEnd()
	{
		stopMap(); //provisioria

		juego.endGame( jugador );

		if (Juego.DEBUG)
			System.out.println("GAME END");
	}
}
