package Mapa;

import java.awt.Component;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import Enemigo.Borracho;
import Enemigo.Comun;
import Enemigo.Guiado;
import Entidad.Entidad;
import Grafica.FondoGenerico;
import Jugador.Jugador;
import Logica.Juego;
import Logica.Teclado;
import Utils.Randomizador;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class MapaGenerico extends Mapa
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final int CANTIDAD_TOTAL_ENEMIGOS = 30;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public MapaGenerico( Juego juego, Jugador player, String nombre, double dificultad )
	{
		// Seleccionar un tipo de fondo especÃ­fico
		this.fondo = new FondoGenerico( juego.obtenerPanel() );
		
		// Inicializar objetos
		this.juego		= juego;
		this.player		= player;
		this.rand		= new Randomizador( );
		this.entidades	= new LinkedList<Entidad>();
		this.entidadesParaEliminar = new LinkedList<Entidad>();
		this.entidadesParaAgregar = new LinkedList<Entidad>();
		this.entidades.add(player);
		
		this.nombre		= nombre;
		this.dificultad	= dificultad;
		
		juego.setTitle( Juego.GAME_TITLE + " - " + this.nombre );
		
		establecerJugador( );
		crearEnemigos( );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public void establecerJugador( )
	{
		// Centrar al jugador
		player.setPos( (Juego.GAME_WIDTH / 2) - (player.getSize().getWidth() / 2) );
		
		player.setVida( 1000 );
		
		// Agregarlo al panel principal
		juego.obtenerPanel().add( player.obtenerPanel() );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void crearEnemigos( )
	{
		int cantComun		= (int) (CANTIDAD_TOTAL_ENEMIGOS * 0.60),
			cantGuiado		= (int) (CANTIDAD_TOTAL_ENEMIGOS * 0.10),
			cantBorracho	= CANTIDAD_TOTAL_ENEMIGOS - cantGuiado - cantComun,
			i;
		
		for (i = 0; i < cantComun; i ++)
			agregarEntidad( new Comun( this, dificultad ) );
		
		for (i = 0; i < cantGuiado; i ++)
			agregarEntidad( new Guiado( this, dificultad ) );
		
		for (i = 0; i < cantBorracho; i ++)
			agregarEntidad( new Borracho( this, dificultad ) );
		
		agregarEntidades();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

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
			
			
			for(Component c: juego.obtenerPanel().getComponents()) {
				if(c==null) {
					System.out.println("HAY NULOOOOOOO");
				}
			}
			
			juego.obtenerPanel().repaint();
			
		} else {
			juego.obtenerLabelPuntaje( ).setText("Perdiste en un juego que no está listo, jaja.");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////