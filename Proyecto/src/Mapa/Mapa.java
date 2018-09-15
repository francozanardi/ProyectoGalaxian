package Mapa;

import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

import Disparo.Disparo;
import Enemigo.Enemigo;
import Enemigo.EnemigoConcreto1;
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
	private Collection<Enemigo>			enemigos;
	private Collection<Disparo>			disparos;
	private Collection<EntidadConVida>	entidades;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Mapa( Juego juego, Jugador player )
	{
		// Seleccionar un tipo de fondo específico
		//this.fondo = new FondoEstatico( juego.obtenerPanel() );
		this.fondo = new FondoGenerico( juego.obtenerPanel() );
		
		// Inicializar objetos
		this.juego		= juego;
		this.player		= player;
		this.rand		= new Randomizador( );
		this.disparos	= new CopyOnWriteArrayList<Disparo>();
		this.entidades	= new CopyOnWriteArrayList<EntidadConVida>();
		this.enemigos	= new CopyOnWriteArrayList<Enemigo>();
		
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
		
		JPanel panel = juego.obtenerPanel();
		
		for (int i = 0; i < this.CANTIDAD_ENEMIGOS; i ++)
		{
			Enemigo e = new EnemigoConcreto1( this, DIFICULTAD );
			enemigos.add(e);
			panel.add(e.obtenerPanel());
			
			Enemigo e2 = new Guiado( this, DIFICULTAD );
			enemigos.add( e2 );
			panel.add( e2.obtenerPanel() );
			
			//panel.add( e[i].getArma().obtenerPanel());
		}
		
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actualizar( )
	{
		
		JPanel panel = juego.obtenerPanel();
		fondo.actualizar();
		
		JLabel lbl = juego.obtenerLabelPuntaje( );
		lbl.setText(
			String.format( "FPS: %d   |   Puntaje: %d   |   Vida: %.1f", Juego.GAME_FPS, player.getPuntaje(), player.getVida() )
		);
		
		
		for(Enemigo enemigo: enemigos) {
			enemigo.mover();
			//para probar vamos a hacer que disparen todos desde el mapa.
			Random rand = new Random();
			if(rand.nextInt(100) == 1) {
				Disparo d = enemigo.lanzarDisparo();
				disparos.add(d);
				panel.add(d.obtenerPanel());
			}
		}
		
		
		//control de colisiones con entidades con vida
		for(Disparo d: disparos) {
			boolean choco = false;
			
			
			for(EntidadConVida ent: entidades) {
				if( verificarColision(ent, d) ) {
					d.colisionar(ent);
					if(ent.getVida() <= 0) {
						ent.eliminar();
						entidades.remove(ent);
					}
					choco = true;
					break;
				}
			}
			
			//control de colisiones con enemigos
			if(!choco) {
				for(Enemigo enemigo: enemigos) {
					if( verificarColision(enemigo, d) ) {
						d.colisionar(enemigo);
						
						if(enemigo.getVida() <= 0) {
							
							// NUEVO (Y PROVISORIO) !!
							player.setPuntaje( player.getPuntaje() + enemigo.getPuntaje() );
						
							enemigo.eliminar();
							enemigos.remove(enemigo);
						}
						
						choco = true;
						break;
					}
				}
			}
			
			
			// control de colisiones con jugador
			if (!choco)
			{
				if ( verificarColision(player, d) )
				{
					d.colisionar(player);
					
					choco = true;
				}
			}
			
			
			//avanzamos el disparo o lo eliminamos
			if(!choco)
			{
				final int offset = 100;
				
				d.avanzar();
				
				// eliminar el disparo si se fue de la pantalla
				if ((d.getPos().getY() < (0 - offset)) ||
					(d.getPos().getY() > (Juego.GAME_HEIGHT + offset)) ||
					(d.getPos().getX() < (0 - offset)) ||
					(d.getPos().getX() > (Juego.GAME_WIDTH + offset)))
				{
					d.eliminar();
					disparos.remove(d);
				}
			}
			else
			{
				d.eliminar();
				disparos.remove(d);
			}
			
		}
		
		
		for(Enemigo e: enemigos) {
			if( verificarColision(player, e) ) {
				e.colisionar(player);
				player.colisionar( e );
				
				if (e.getVida() <= 0.0)
				{
					e.eliminar();
					enemigos.remove(e);
				}
			}
		}
		
		
		
		panel.repaint();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private boolean verificarColision( Entidad a, Entidad b )
	{
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
	
	public void actividadTeclado( KeyEvent t )
	{
		switch ( t.getKeyCode() )
		{
			case KeyEvent.VK_LEFT:
			{
				if(player.getPos().getX() > player.getSize().getWidth()/2) {
					player.mover( -2 );
				}
				break;
			}
			
			case KeyEvent.VK_RIGHT:
			{
				if(player.getPos().getX() < Juego.GAME_WIDTH - player.getSize().getWidth()*2) {
					player.mover( 2 );
				}
				break;
			}
			//funciona pero hay un error que creo que se debe por modificar la lista en el hilo principal y al mismo tiempo en el hilo creado.
			//posible solucion: crear una lista auxiliar para los disparos del jugador.
			//lo solucione con una estructura de datos adecuada para threads
			case KeyEvent.VK_SPACE:
			{
				Disparo d = player.lanzarDisparo();
				disparos.add(d);
				juego.obtenerPanel().add(d.obtenerPanel());
				break;
			}
		
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////