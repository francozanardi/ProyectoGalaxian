package Mapa;

import java.awt.Color;
import java.util.LinkedList;

import Controladores.ContEnemBossGenerico;
import Controladores.ContEnemMapaGenerico;
import Controladores.ContObstaculosGenerico;
import Controladores.ControladorNiveles;
import Entidad.Entidad;
import Escudo.EscudoAbsoluto;
import Grafica.FondoGenerico;
import Jugador.Jugador;
import Logica.Juego;
import Obstaculo.BarricadaComun;
import Obstaculo.ObstaculoComun;
import Utils.Posicion;
import Utils.Randomizador;



public class MapaGenerico extends Mapa
{
	private final int	CANT_MAX_ENEM_PANTALLA = 15;

	
	
	
	public MapaGenerico( Juego juego, ControladorNiveles control, Jugador player, String nombre, double dificultad, boolean boss )
	{
		// Seleccionar un tipo de fondo especifico
		if (boss)
		{
			this.fondo			 = new FondoGenerico( juego.getPanel(), 1000, new Color(0, 0, 0), new Color(128, 0, 0) );
			this.controlEnemigos = new ContEnemBossGenerico( this, dificultad );
		}
		else
		{
			this.fondo			 = new FondoGenerico( juego.getPanel(), 1000, new Color(0, 0, 0), new Color(50, 50, 50) );
			this.controlEnemigos = new ContEnemMapaGenerico( this, CANT_MAX_ENEM_PANTALLA, dificultad );
		}
		
		// Inicializar objetos
		this.juego					= juego;
		this.gui					= juego.getGUI();
		this.player					= player;
		this.controlJuego			= control;
		this.rand					= Randomizador.create( );
		this.controlObstaculos		= new ContObstaculosGenerico( this, dificultad );
		
		this.entidades				= new LinkedList<Entidad>();
		this.entidadesParaEliminar	= new LinkedList<Entidad>();
		this.entidadesParaAgregar	= new LinkedList<Entidad>();
		this.entidades.add(player);
		
		
		this.nombre		= nombre;
		this.dificultad	= dificultad;
		
		juego.setTitle( Juego.GAME_TITLE + " - " + this.nombre );
		
		establecerJugador( );
		crearEnemigos( );
		crearObstaculos( );
		
		agregarEntidades();
		
		gui.show(true);
	}
	
	
	
	public void establecerJugador( )
	{
		// Vincular al jugador con el mapa
		player.setMapa( this );
		player.getArma().setMapa( this );
		
		// Centrar al jugador
		player.setPos( (Juego.GAME_WIDTH / 2) - (player.getSize().getWidth() / 2) );
				
		// Agregarlo al panel principal
		juego.getPanel().add( player.getSprite() );
		player.getSprite().setVisible(true);
	}
	
	
		
	public void actualizar( double msDesdeUltActualizacion )
	{
		actualizarJugador( msDesdeUltActualizacion );
		
		fondo.actualizar( msDesdeUltActualizacion );
		
		actualizarInformacion( msDesdeUltActualizacion );

		actualizarEntidades( msDesdeUltActualizacion );		
		
		controlarColisiones();
		borrarEntidades();
		agregarEntidades();
	}
	
}