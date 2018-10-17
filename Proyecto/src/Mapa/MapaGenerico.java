package Mapa;

import java.awt.Component;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import Enemigo.Borracho;
import Enemigo.Camuflado;
import Enemigo.Comun;
import Enemigo.Guiado;
import Enemigo.KamikazeFragil;
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
	
	private final int CANTIDAD_TOTAL_ENEMIGOS = 20;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public MapaGenerico( Juego juego, Jugador player, String nombre, double dificultad )
	{
		// Seleccionar un tipo de fondo especÃ­fico
		this.fondo = new FondoGenerico( juego.getPanel() );
		
		// Inicializar objetos
		this.juego					= juego;
		this.player					= player;
		this.rand					= new Randomizador( );
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
	
	public void crearEnemigos( )
	{
		int cantComun		= (int) (CANTIDAD_TOTAL_ENEMIGOS * 0.60),
			cantGuiado		= (int) (CANTIDAD_TOTAL_ENEMIGOS * 0.10),
			cantCamuflado	= (int) (CANTIDAD_TOTAL_ENEMIGOS * 0.10),
			cantFragil		= (int) (CANTIDAD_TOTAL_ENEMIGOS * 0.10),
			cantBorracho	= CANTIDAD_TOTAL_ENEMIGOS - cantGuiado - cantComun - cantCamuflado - cantFragil,
			i;

		for (i = 0; i < cantComun; i ++)
			addEntity( new Comun( this, dificultad ) );
		
		for (i = 0; i < cantGuiado; i ++)
			addEntity( new Guiado( this, dificultad ) );
		
		for (i = 0; i < cantBorracho; i ++)
			addEntity( new Borracho( this, dificultad ) );
		
		for (i = 0; i < cantCamuflado; i ++)
			addEntity( new Camuflado(this, dificultad) );
		
		for (i = 0; i < cantFragil; i ++)
			addEntity( new KamikazeFragil(this, dificultad) );
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
		if (player.getVida() > 0)
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
			
			
			for(Component c: juego.getPanel().getComponents()) {
				if(c==null) {
					System.out.println("HAY NULOOOOOOO");
				}
			}
			
			//juego.getPanel().repaint();
			
		} else {
			juego.obtenerLabelPuntaje( ).setText("Perdiste en un juego que no está listo, jaja.");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////