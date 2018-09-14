package Mapa;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

import Colisiones.Colisionador;
import Disparo.Disparo;
import Enemigo.Enemigo;
import Enemigo.EnemigoConcreto1;
import Enemigo.Kamikaze;
import Entidad.EntidadConVida;
import Grafica.Fondo;
import Grafica.FondoGenerico;
import Grafica.Juego;
import Grafica.Posicion;
import Jugador.Jugador;

import javax.swing.JLabel;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Mapa
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final int	CANTIDAD_ENEMIGOS = 10;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private Juego						juego;
	private Jugador						player;
	private Fondo						fondo;
	private Collection<Enemigo>			enemigos;
	private Collection<Disparo>			disparos;
	private Collection<EntidadConVida>	entidades;
	private Colisionador				colisiones;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Mapa( Juego juego, Jugador player )
	{
		// Seleccionar un tipo de fondo específico
		//this.fondo = new FondoEstatico( juego.obtenerPanel() );
		this.fondo = new FondoGenerico( juego.obtenerPanel() );
		
		// Inicializar objetos
		this.juego		= juego;
		this.player		= player;
		this.disparos	= new CopyOnWriteArrayList<Disparo>();
		this.entidades	= new CopyOnWriteArrayList<EntidadConVida>();
		this.enemigos	= new CopyOnWriteArrayList<Enemigo>();
		this.colisiones	= new Colisionador();
		
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
			
			Enemigo e2 = new Kamikaze( this, DIFICULTAD );
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
				if (player.obtenerPanel().getBounds().contains( d.obtenerPanel().getBounds() ) )
				{
					d.getLanzador().hacerDMG(colisiones, player, d);
					
					choco = true;
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
	
	public Posicion coordenadasDelJugador( )
	{
		return player.getPos();
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