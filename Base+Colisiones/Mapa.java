package Proyecto;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Mapa
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final int	CANTIDAD_ENEMIGOS = 20;
	private final Color COLOR_FONDO = new Color( 10, 10, 10 );
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private Juego		juego;
	private Jugador		player;
	private Collection<Enemigo>	enemigos;
	private Collection<Disparo> disparos;
	private Collection<EntidadConVida> entidades;
	private Colisionador colisiones;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Mapa( Juego juego, Jugador player )
	{
		this.juego	= juego;
		this.player	= player;
		this.disparos = new CopyOnWriteArrayList<Disparo>();
		this.entidades = new CopyOnWriteArrayList<EntidadConVida>();
		this.enemigos = new CopyOnWriteArrayList<Enemigo>();
		this.colisiones = new Colisionador();
		
		establecerFondo( );
		crearEnemigos( );
		establecerJugador( );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void establecerFondo( )
	{
		juego.obtenerPanel().setBackground( COLOR_FONDO );
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
		JPanel panel = juego.obtenerPanel();
		
		for (int i = 0; i < this.CANTIDAD_ENEMIGOS; i ++)
		{
			Enemigo e = new EnemigoConcreto1();
			enemigos.add(e);
			
			panel.add(e.obtenerPanel());
			//panel.add( e[i].getArma().obtenerPanel());
		}
		
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actualizar( )
	{
		
		JPanel panel = juego.obtenerPanel();
		
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
		
		
		//control de colisiones con entidades con vida - enemigos
		for(Disparo d: disparos) {
			boolean choco = false;
			for(EntidadConVida ent: entidades) {
				if(ent.obtenerPanel().getBounds().contains(d.obtenerPanel().getBounds())) {
					d.getLanzador().hacerDMG(colisiones, ent, d);
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
					if(enemigo.obtenerPanel().getBounds().contains(d.obtenerPanel().getBounds())) {
						d.getLanzador().hacerDMG(colisiones, enemigo, d);
						
						if(enemigo.getVida() <= 0) {
							enemigo.eliminar();
							enemigos.remove(enemigo);
						}
						
						choco = true;
						break;
					}
				}
			}
			
			//avanzamos el disparo o lo eliminamos
			if(!choco) {
				d.avanzar();
			} else {
				d.eliminar();
				disparos.remove(d);
			}
			
		}
		
		
		
		panel.repaint();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actividadTeclado( KeyEvent t )
	{
		switch ( t.getKeyCode() )
		{
			case KeyEvent.VK_LEFT:
			{
				player.mover( -1 );
				break;
			}
			
			case KeyEvent.VK_RIGHT:
			{
				player.mover( 1 );
				break;
			}
			//funciona pero hay un error que creo que se debe por modificar la lista en el hilo principal y al mismo tiempo en el hilo creado.
			//posible solucion: crear una lista auxiliar para los disparos del jugador.
			//lo solucione con una estructura de datos adecuada para threads
			case KeyEvent.VK_SPACE:
				Disparo d = player.lanzarDisparo();
				disparos.add(d);
				juego.obtenerPanel().add(d.obtenerPanel());
				break;
		
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////