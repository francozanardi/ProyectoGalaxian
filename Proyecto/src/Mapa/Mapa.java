package Mapa;

import java.awt.Rectangle;
import java.util.Collection;
import java.util.List;

import Controladores.ControladorEnemigos;
import Controladores.ControladorNiveles;
import Enemigo.Enemigo;
import Entidad.Entidad;
import Grafica.Fondo;
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
	protected Jugador				player;
	protected Fondo					fondo;
	protected Collection<Entidad>	entidades;
	protected Collection<Entidad>	entidadesParaEliminar;
	protected Collection<Entidad>	entidadesParaAgregar;
	protected double				dificultad;
	protected String				nombre;
	protected ControladorEnemigos	controlEnemigos;
		
	

	public abstract void actualizar( double msDesdeUltActualizacion );
	
	public abstract void establecerJugador( );

	
	
	public void ganar( )
	{
		controlJuego.mapVictory( player );
		
		//juego.mapVictory();
	}
	
	public void perder( )
	{
		juego.updateScoreLabel("Perdiste en un juego que no está listo, jaja.");
		
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
		Rectangle boundsA = a.getPanel().getBounds();
		Rectangle boundsB = b.getPanel().getBounds();
		
		return	boundsA.contains(boundsB.getMinX(), boundsB.getMinY()) ||
				boundsA.contains(boundsB.getMinX(), boundsB.getMaxY()) ||
				boundsA.contains(boundsB.getMaxX(), boundsB.getMinY()) ||
				boundsA.contains(boundsB.getMaxX(), boundsB.getMaxY());
	}
	
	
	
	public void limpiarMapa()
	{
		/*
		for(Entidad e: entidades)
		{
			juego.getPanel().remove( e.getPanel() );
		}
		*/

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
		for(Entidad e: entidadesParaEliminar) {
			//juego.getPanel().remove(e.getPanel());
			e.getPanel().setVisible(false);
			entidades.remove(e);
			
			controlEnemigos.notificarMuerteEntidad( e );
		}
				
		entidadesParaEliminar.clear();
	}
	
	protected void agregarEntidades()
	{
		for(Entidad e: entidadesParaAgregar) {
			entidades.add(e);
			juego.getPanel().add(e.getPanel());
		}
		
		entidadesParaAgregar.clear();
	}



	public void mostrarAnuncio( String texto )
	{
		System.out.println( texto );
	}
		
	protected void actualizarLabelInformacion( double msDesdeUltActualizacion )
	{
		juego.updateScoreLabel(
			String.format( "Puntaje: %d   |   Vida: %.1f   |   FPS: %.0f",
				player.getPuntaje(),
				player.getVida(),
				1000.0 / msDesdeUltActualizacion
			)
		);
	}
	
	
	
	public List<Enemigo> enemigosEnJuego( )
	{
		return controlEnemigos.obtenerEnemigosVivos();
	}
	
	public Posicion getPlayerPos( )
	{
		return player.getPos().clone();
	}
}