package Mapa;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

import Controladores.ControladorEnemigos;
import Disparo.Disparo;
import Enemigo.Enemigo;
import Enemigo.Comun;
import Enemigo.Guiado;
import Entidad.Entidad;
import Entidad.EntidadConVida;
import Grafica.Fondo;
import Grafica.FondoGenerico;
import Jugador.Jugador;
import Logica.Juego;
import Logica.Teclado;
import PowerUp.PowerUp;
import Utils.Posicion;
import Utils.Randomizador;

import javax.swing.JLabel;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public abstract class Mapa
{	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected Randomizador			rand;
	protected Juego					juego;
	protected Jugador				player;
	protected Fondo					fondo;
	protected Collection<Entidad>	entidades;
	protected Collection<Entidad>	entidadesParaEliminar;
	protected Collection<Entidad>	entidadesParaAgregar;
	protected double				dificultad;
	protected String				nombre;
	protected ControladorEnemigos	controlEnemigos;
		
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void ganar( )
	{
		juego.mapVictory();
	}
	
	public void perder( )
	{
		juego.obtenerLabelPuntaje( ).setText("Perdiste en un juego que no está listo, jaja.");
		juego.mapDefeat();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void crearEnemigos( )
	{
		controlEnemigos.crearEnemigos( );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public double getDificultad( )
	{
		return this.dificultad;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getNombre( )
	{
		return this.nombre;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public abstract void actualizar( double msDesdeUltActualizacion );

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public abstract void establecerJugador( );

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void removeEntity(Entidad e)
	{
		entidadesParaEliminar.add(e);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void addEntity(Entidad e)
	{
		entidadesParaAgregar.add(e);
	}
	
	protected void controlarColisiones()
	{
		for(Entidad entidad1: entidades) {
			for(Entidad entidad2: entidades) {
				if(entidad1 != entidad2) {
					if(hayColision(entidad1, entidad2) || hayColision(entidad2, entidad1)) {
						entidad1.colisionar(entidad2);
					}
				}
			}
		}
	}
		
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected void actualizarJugador( double msDesdeUltActualizacion )
	{
		Teclado teclado = juego.obtenerTeclado( );
		
		if (teclado.disparando())
			player.disparar();
		
		player.setDireccion( teclado.direccionJugador() );
		
		player.actualizar( msDesdeUltActualizacion );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected void actualizarEntidades( double msDesdeUltActualizacion )
	{
		for(Entidad ent: entidades)
		{
			ent.actualizar( msDesdeUltActualizacion );
		}
	}
	
	protected void borrarEntidades() {
		for(Entidad e: entidadesParaEliminar) {
			//juego.getPanel().remove(e.getPanel());
			e.getPanel().setVisible(false);
			entidades.remove(e);
			
			controlEnemigos.notificarMuerteEntidad( e );
		}
				
		entidadesParaEliminar.clear();
	}
	
	protected void agregarEntidades() {
		for(Entidad e: entidadesParaAgregar) {
			entidades.add(e);
			juego.getPanel().add(e.getPanel());
		}
		
		entidadesParaAgregar.clear();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	protected void actualizarLabelInformacion( double msDesdeUltActualizacion )
	{
		juego.obtenerLabelPuntaje( ).setText(
			String.format( "Puntaje: %d   |   Vida: %.1f   |   FPS: %.0f",
				player.getPuntaje(),
				player.getVida(),
				1000.0 / msDesdeUltActualizacion
			)
		);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected boolean hayColision( Entidad a, Entidad b )
	{
		Rectangle boundsA = a.getPanel().getBounds();
		Rectangle boundsB = b.getPanel().getBounds();
		
		return	boundsA.contains(boundsB.getMinX(), boundsB.getMinY()) ||
				boundsA.contains(boundsB.getMinX(), boundsB.getMaxY()) ||
				boundsA.contains(boundsB.getMaxX(), boundsB.getMinY()) ||
				boundsA.contains(boundsB.getMaxX(), boundsB.getMaxY());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<Entidad> enemigosEnJuego( )
	{
		return controlEnemigos.obtenerEnemigosVivos();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Posicion getPlayerPos( )
	{
		return player.getPos();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Randomizador getRandomizador( )
	{
		return rand;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////