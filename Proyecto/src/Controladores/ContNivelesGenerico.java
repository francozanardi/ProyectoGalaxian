package Controladores;

import Jugador.Jugador;
import Logica.Juego;
import Mapa.Mapa;
import Mapa.MapaGenerico;
import Menu.MediadorMenu;
import Menu.Menu;
import Menu.MenuNextLevel;
import PowerUp.PowerUp;
import Tienda.Item;
import Utils.Posicion;



public class ContNivelesGenerico extends ControladorNiveles
{

	public ContNivelesGenerico( Juego game, Jugador player ) {
		jugador = player;
		juego = game;
	}
	
	
	
	private Mapa establecerNivel( int nivelID )
	{
		juego.requestFocus();
		Mapa mapa = new MapaGenerico( juego, this, jugador, "LEVEL " + nivelID, nivelID, (1.0 * nivelID) );
		startMap(mapa);
		
		if (Juego.DEBUG)
			System.out.println( "COMIENZA EL NIVEL " + nivelID );
		
		return mapa;
	}

	
	public void siguienteNivel(Item compra) {
		nivel ++;
		Mapa mapa = establecerNivel( nivel );
		
		if(compra != null)
			compra.darContenido(mapa);
	}
	
	
	public void mapVictory( Jugador player )
	{
		stopMap();
		juego.getPanel().removeAllEntities();

		MediadorMenu mediador = juego.getMediadorMenu();
		mediador.iniciarNuevoMenu(mediador.menuNextLevel());
		
		if (Juego.DEBUG)
			System.out.println("MAP VICTORY");
	}

	public void mapDefeat( Jugador player )
	{
		gameEnd();

		if (Juego.DEBUG)
			System.out.println("MAP DEFEAT");
	}

	
	
	public void gameStart()
	{
		nivel = 1;
		establecerNivel( nivel );

		if (Juego.DEBUG)
			System.out.println("GAME START");
	}

	public void gameEnd()
	{
		stopMap();
		juego.endGame( jugador );

		if (Juego.DEBUG)
			System.out.println("GAME END");
	}
}
