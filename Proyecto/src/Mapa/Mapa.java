package Mapa;

import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Enemigo.Comun;
import Enemigo.Guiado;
import Entidad.Entidad;
import Entidad.EntidadConVida;
import Grafica.Fondo;
import Grafica.FondoGenerico;
import Grafica.Juego;
import Jugador.Jugador;
import Utils.Posicion;
import Utils.Randomizador;

import javax.swing.JLabel;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Mapa
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final int	CANTIDAD_ENEMIGOS = 10;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private Randomizador				rand;
	private Juego						juego;
	private Jugador						player;
	private Fondo						fondo;
	private Collection<Entidad>			entidades;
	private Set<Integer> teclasApretadas = new HashSet<Integer>(); //necesitamos una estructura que no pueda tener elementos repetidos, por eso set
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Mapa( Juego juego, Jugador player )
	{
		// Seleccionar un tipo de fondo especÃ­fico
		//this.fondo = new FondoEstatico( juego.obtenerPanel() );
		this.fondo = new FondoGenerico( juego.obtenerPanel() );
		
		// Inicializar objetos
		this.juego		= juego;
		this.player		= player;
		this.rand		= new Randomizador( );
		this.entidades	= new CopyOnWriteArrayList<Entidad>();
		this.entidades.add(player);
		
		//establecerFondo( );
		establecerJugador( );
		crearEnemigos( );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public void establecerJugador( )
	{
		// Centrar al jugador
		player.setPos( (Juego.GAME_WIDTH / 2) - (Jugador.PLAYER_WIDTH / 2) );
		
		// Agregarlo al panel principal
		juego.obtenerPanel().add( player.obtenerPanel() );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void crearEnemigos( )
	{
		final float DIFICULTAD = 1;
		
		for (int i = 0; i < this.CANTIDAD_ENEMIGOS; i ++)
		{
			Enemigo e = new Comun( this, DIFICULTAD );
			agregarEntidad(e);
			
			Enemigo e2 = new Guiado( this, DIFICULTAD );
			agregarEntidad(e2);

		}
		
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
	
	private void actualizarEntidades() {
		for(Entidad ent: entidades) {
			ent.actualizar();
		}
	}
	
	public void borrarEntidad(Entidad e) {
		entidades.remove(e);
	}
	
	public void agregarEntidad(Entidad e) {
		entidades.add(e);
		juego.obtenerPanel().add(e.obtenerPanel());
	}
	
	public void actualizar( )
	{
		if(player.getVida() > 0) {
			controlarTeclado();
			fondo.actualizar();
			
			JLabel lbl = juego.obtenerLabelPuntaje( );
			lbl.setText(
				String.format( "FPS: %d   |   Puntaje: %d   |   Vida: %.1f", Juego.GAME_FPS, player.getPuntaje(), player.getVida() )
			);
	
			actualizarEntidades();//si esto estuviera abajo de controlarColisiones lo que podría suceder es que
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
	
	private boolean verificarColision( Entidad a, Entidad b )
	{
		//System.out.println(a.toString() + " " + b.toString());
		double	ax1 = a.getPos().getX(),
				ay1 = a.getPos().getY(),
				bx = b.getPos().getX(),
				by = b.getPos().getY();
		int aSX = a.getSize().getWidth(),
			aSY = a.getSize().getHeight(),
			bSX = b.getSize().getWidth(),
			bSY = b.getSize().getHeight();
		
		return	rectanguloContienePunto( ax1, ay1, aSX, aSY, bx,       by ) ||
				rectanguloContienePunto( ax1, ay1, aSX, aSY, bx + bSX, by ) ||
				rectanguloContienePunto( ax1, ay1, aSX, aSY, bx + bSX, by + bSY ) ||
				rectanguloContienePunto( ax1, ay1, aSX, aSY, bx,       by + bSY );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private boolean rectanguloContienePunto( double x, double y, double sizeX, double sizeY, double pX, double pY )
	{
		pX -= x;
		pY -= y;
		
		return (0 < pX) && (pX < sizeX) && (0 < pY) && (pY < sizeY);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Posicion coordenadasDelJugador( )
	{
		return player.getPos();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Randomizador obtenerRandomizador( )
	{
		return rand;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void teclaApretada( KeyEvent t )	{
		teclasApretadas.add(t.getKeyCode());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void teclaSuelta(KeyEvent t) {
		teclasApretadas.remove(t.getKeyCode());
	}
	
	public void controlarTeclado() {
		if(teclasApretadas.contains(KeyEvent.VK_LEFT)) {
			if(player.getPos().getX() > player.getSize().getWidth()/2) {
				player.mover( -2 );
			}
		}
		if(teclasApretadas.contains(KeyEvent.VK_RIGHT)) {
			if(player.getPos().getX() < Juego.GAME_WIDTH - player.getSize().getWidth()*2) {
				player.mover( 2 );
			}
		}
		if(teclasApretadas.contains(KeyEvent.VK_SPACE)) {
			Disparo d = player.lanzarDisparo();
			if(d != null) {
				agregarEntidad(d);
			}
		}

	}
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////