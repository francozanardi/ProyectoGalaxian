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
import Jugador.Jugador;
import Logica.Juego;
import Logica.Teclado;
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
	protected double				dificultad;
	protected String				nombre;
		
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setDificultad( double dif )
	{
		this.dificultad = dif;
	}
	
	public double getDificultad( )
	{
		return this.dificultad;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setNombre( String nombre )
	{
		this.nombre = nombre;
	}
	
	public String getNombre( )
	{
		return this.nombre;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public abstract void actualizar( double msDesdeUltActualizacion );

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected abstract void controlarColisiones( );
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public abstract void establecerJugador( );
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public abstract void crearEnemigos( );

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void borrarEntidad(Entidad e)
	{
		entidades.remove(e);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void agregarEntidad(Entidad e)
	{
		entidades.add(e);
		juego.obtenerPanel().add( e.obtenerPanel() );
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
	
	protected boolean verificarColision( Entidad a, Entidad b )
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
	
	protected boolean rectanguloContienePunto( double x, double y, double sizeX, double sizeY, double pX, double pY )
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
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////