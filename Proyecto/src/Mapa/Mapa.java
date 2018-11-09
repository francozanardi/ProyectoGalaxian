package Mapa;

import java.awt.Rectangle;
import java.util.Collection;

import Controladores.ControladorEnemigos;
import Controladores.ControladorNiveles;
import Controladores.ControladorObstaculos;
import Entidad.Entidad;
import Grafica.Fondo;
import Grafica.GUI;
import Jugador.Jugador;
import Logica.Juego;
import Logica.Teclado;
import Utils.Posicion;
import Utils.Randomizador;



public abstract class Mapa
{
	protected Randomizador			rand;
	protected Juego					juego;
	protected ControladorNiveles	controlJuego;
	protected ControladorEnemigos	controlEnemigos;
	protected ControladorObstaculos	controlObstaculos;
	protected Jugador				player;
	protected Fondo					fondo;
	protected Collection<Entidad>	entidades;
	protected Collection<Entidad>	entidadesParaEliminar;
	protected Collection<Entidad>	entidadesParaAgregar;
	protected double				dificultad;
	protected String				nombre;
	protected GUI					gui;
		
	

	public abstract void actualizar( double msDesdeUltActualizacion );
	
	public abstract void establecerJugador( );

	
	
	public void ganar( )
	{
		gui.show( false );
		
		controlJuego.mapVictory( player );
		
		//juego.mapVictory();
	}
	
	public void perder( )
	{
		gui.show( false );
		
		controlJuego.mapDefeat( player );
		
		//juego.mapDefeat();
	}
	
	
	
	public double getDificultad( )
	{
		return this.dificultad;
	}
	
	
	public String getNombre( )
	{
		return this.nombre;
	}
	
	
	
	protected void crearEnemigos( )
	{
		controlEnemigos.crearEnemigos( );
	}
	
	protected void crearObstaculos( )
	{
		controlObstaculos.crearObstaculos();
	}
	
	public void removeEntity(Entidad e)
	{
		entidadesParaEliminar.add(e);
	}
	
	public void addEntity(Entidad e)
	{
		entidadesParaAgregar.add(e);
	}
	
	protected void controlarColisiones()
	{
		for (Entidad entidad1: entidades)
			for (Entidad entidad2: entidades)
				if (entidad1 != entidad2)
					if (hayColision(entidad1, entidad2) || hayColision(entidad2, entidad1))
						entidad1.colisionar(entidad2);
	}
	
	private boolean hayColision( Entidad a, Entidad b )
	{
		Rectangle boundsA = a.getSprite().getBounds();
		Rectangle boundsB = b.getSprite().getBounds();
		
		return	boundsA.contains(boundsB.getMinX(), boundsB.getMinY()) ||
				boundsA.contains(boundsB.getMinX(), boundsB.getMaxY()) ||
				boundsA.contains(boundsB.getMaxX(), boundsB.getMinY()) ||
				boundsA.contains(boundsB.getMaxX(), boundsB.getMaxY());
	}
	
	
	
	public void limpiarMapa()
	{
		for(Entidad e: entidades)
		{
			if(e != player)
			{
				juego.getPanel().removeEntity(e.getSprite());
				e.getSprite().setVisible(false);
			}
		}
		
		for(Entidad e: entidadesParaEliminar)
		{
			juego.getPanel().removeEntity(e.getSprite());
			e.getSprite().setVisible(false);
		}
		
		for(Entidad e: entidadesParaAgregar)
		{
			juego.getPanel().removeEntity(e.getSprite());
			e.getSprite().setVisible(false);
		}
				
		entidades.clear();
		entidadesParaEliminar.clear();
		entidadesParaAgregar.clear();
	}

	
	
	protected void actualizarJugador( double msDesdeUltActualizacion )
	{
		Teclado teclado = juego.getTeclado( );
		
		if (teclado.disparando())
			player.disparar();
		
		player.setDireccion( teclado.direccionJugador() );
		
		player.actualizar( msDesdeUltActualizacion );
	}
	
	
	
	protected void actualizarEntidades( double msDesdeUltActualizacion )
	{
		for(Entidad ent: entidades)
		{
			ent.actualizar( msDesdeUltActualizacion );
		}
	}
	
	protected void borrarEntidades()
	{
		for(Entidad e: entidadesParaEliminar)
		{
			e.getSprite().setVisible(false);
			entidades.remove(e);
			
			controlEnemigos.notificarMuerteEntidad( e );
		}
				
		entidadesParaEliminar.clear();
	}
	
	protected void agregarEntidades()
	{
		for(Entidad e: entidadesParaAgregar)
		{
			entidades.add(e);
			juego.getPanel().addEntity( e.getSprite() );
		}
		
		entidadesParaAgregar.clear();
	}



	public void mostrarAnuncio( String texto )
	{
		gui.announce(texto, 4000);
	}
		
	protected void actualizarInformacion( double msDesdeUltActualizacion )
	{
		gui.updateFPS( 1000.0 / msDesdeUltActualizacion );
		gui.updateScore( player.getPuntaje() );
		gui.updateHP( player.getVida(), 1000.0 );
	}
	
	
	
	public Collection<Entidad> getEntidades( )
	{
		return entidades;
	}
	
	public Posicion getPlayerPos( )
	{
		return player.getPos().clone();
	}
}