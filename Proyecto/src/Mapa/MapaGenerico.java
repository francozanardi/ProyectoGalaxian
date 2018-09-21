package Mapa;

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
		this.entidades	= new CopyOnWriteArrayList<Entidad>();
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
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void controlarColisiones() {
		//Collection<Entidad[]> aColisionar = new CopyOnWriteArrayList<Entidad[]>();

		for(Entidad entidad1: entidades) {
			if(entidad1.obtenerPanel() != null) { //puede que haya sido eliminado cuando se llama a colisionar
				//por lo tanto debemos asegurarnos de que no sea null.
				//otra solucion es guardar en una lista las entidades colisionadas asi las borramos luego de este for-each
				for(Entidad entidad2: entidades) {
					if(entidad2.obtenerPanel() != null) { //idem anterior
						if(entidad1 != entidad2) {
							if(verificarColision(entidad1, entidad2)) {
								entidad1.colisionar(entidad2);
								entidad2.colisionar(entidad1);
								
								if(entidad1.obtenerPanel() == null) //puede que al colisionar la entidad1 desaparezca y sigamos buscando más colisiones
									break;
							}
						}
					}
				}
			}
		}
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
			
			juego.obtenerPanel().repaint();
			
		} else {
			juego.obtenerLabelPuntaje( ).setText("Perdiste en un juego que no está listo, jaja manco.");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////