package Controladores;

import java.util.Random;

import Jugador.Jugador;
import Logica.Juego;
import Mapa.Mapa;
import Mapa.MapaGenerico;
import Menu.MediadorMenu;
import Tienda.Item;



public class ContNivelesGenerico extends ControladorNiveles
{

	private final int PORCENTAJE_BASE_BOSS = 8;
	private int nivelesSinJefe;
	
	public ContNivelesGenerico( Juego game, Jugador player ) {
		jugador = player;
		juego = game;
		nivelesSinJefe = 0;
	}
	
	private int funcionPorcentajeBoss(int n) {
		return PORCENTAJE_BASE_BOSS + (int) Math.pow(n, 2);
	}
	
	private boolean nivelBoss() {
		int porcentajeActual = funcionPorcentajeBoss(nivelesSinJefe);
		Random random = new Random();
		int numeroAleatorio = random.nextInt(100);
		
		if(numeroAleatorio <= porcentajeActual) {
			nivelesSinJefe = 0;
			return true;
		}
		
		nivelesSinJefe++;
		return false;
	}
	
	
	private Mapa establecerNivel( int nivelID )
	{
		juego.requestFocus();
		Mapa mapa = new MapaGenerico( juego, this, jugador, "LEVEL " + nivelID, nivelID, nivelBoss());
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
