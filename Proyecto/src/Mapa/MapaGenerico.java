package Mapa;

import java.awt.Component;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import Controladores.ContEnemMapaGenerico;
import Controladores.ControladorNiveles;
import Enemigo.Borracho;
import Enemigo.Camuflado;
import Enemigo.Comun;
import Enemigo.Guiado;
import Enemigo.Fragil;
import Entidad.Entidad;
import Escudo.EscudoAbsoluto;
import Grafica.FondoGenerico;
import Jugador.Jugador;
import Logica.Juego;
import Logica.Teclado;
import Obstaculo.BarricadaComun;
import Obstaculo.ObstaculoComun;
import Utils.Posicion;
import Utils.Randomizador;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class MapaGenerico extends Mapa
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final int CANT_MAX_ENEM_PANTALLA = 15;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public MapaGenerico( Juego juego, ControladorNiveles control, Jugador player, String nombre, double dificultad )
	{
		// Seleccionar un tipo de fondo especifico
		this.fondo = new FondoGenerico( juego.getPanel() );
		
		// Inicializar objetos
		this.juego					= juego;
		this.player					= player;
		this.controlJuego			= control;
		this.rand					= new Randomizador( );
		this.controlEnemigos		= new ContEnemMapaGenerico( this, CANT_MAX_ENEM_PANTALLA, dificultad );
		this.entidades				= new LinkedList<Entidad>();
		this.entidadesParaEliminar	= new LinkedList<Entidad>();
		this.entidadesParaAgregar	= new LinkedList<Entidad>();
		this.entidades.add(player);
		
		this.nombre		= nombre;
		this.dificultad	= dificultad;
		
		juego.setTitle( Juego.GAME_TITLE + " - " + this.nombre );
		
		establecerJugador( );
		crearEnemigos( );
		crearObjetos( );
		
		agregarEntidades();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public void establecerJugador( )
	{
		// Vincular al jugador con el mapa
		player.setMapa( this );
		player.getArma().setMapa( this );
		
		// Centrar al jugador
		player.setPos( (Juego.GAME_WIDTH / 2) - (player.getSize().getWidth() / 2) );
				
		// Agregarlo al panel principal
		juego.getPanel().add( player.getPanel() );
		
		player.addEscudo( new EscudoAbsoluto(player, 5) );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	public void crearObjetos( )
	{
		addEntity( new BarricadaComun( this, new Posicion( 20, Juego.GAME_HEIGHT / 2 ) ) );
		
		addEntity( new ObstaculoComun( this, new Posicion( Juego.GAME_WIDTH / 2, Juego.GAME_HEIGHT / 2 ) ) );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actualizar( double msDesdeUltActualizacion )
	{
		actualizarJugador( msDesdeUltActualizacion );
		
		fondo.actualizar( msDesdeUltActualizacion );
		
		actualizarLabelInformacion( msDesdeUltActualizacion );

		actualizarEntidades( msDesdeUltActualizacion );//si esto estuviera abajo de controlarColisiones lo que podría suceder es que
		//colisionaría el jugador con un kamikaze, se le quitaría la vida al jugador, y si este muere, queda null.
		//entonces luego en actualizar entidades, al momento de mover los kamikazes restantes, tendrían que obtener
		//la pos del jugador, la cual es nula, entonces provocaría error en tiempo de ejecución.		
		
		controlarColisiones();
		borrarEntidades();
		agregarEntidades();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////