package Arma;

import javax.swing.JPanel;

import Colisiones.ColisionadorDisparo;
import Disparo.Disparo;
import Entidad.Entidad;
import Entidad.Personaje;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;
import Utils.Vector;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public abstract class Arma extends Entidad
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected int					cadenciaDisparo; // determina cada cuantos MILISEGUNDOS se puede disparar.
	protected double				multiplicadorDmg;
	protected long					tiempoUltimoDisparo;
	protected Personaje 			owner;
	protected ColisionadorDisparo	colisionador;
	protected double				anguloDisparo;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected abstract void crearDisparo( Personaje p );
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Personaje getOwner( )
	{
		return this.owner;
	}
	
	public void setOwner( Personaje p )
	{
		this.owner = p;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public int getCadenciaDisparo( )
	{
		return cadenciaDisparo;
	}
	
	public void setCadenciaDisparo( int tiempoEntreDisparosMS )
	{
		cadenciaDisparo = tiempoEntreDisparosMS;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setMultiplicadorDmg( double mult )
	{
		multiplicadorDmg = mult;
	}
	
	public double getMultiplicadorDmg( )
	{
		return multiplicadorDmg;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Este método inicializa la variable tiempoUltimoDisparo con un delay aleatorio entre 0 y 1000 miliegundos,
	 * de esta forma nos aseguramos de que los enemigos no disparen todos a la vez.
	 */
	protected void inicializar( Posicion posicion, Size size, Personaje tirador, ColisionadorDisparo miColisionador, Mapa mapa, double anguloDelDisparo, double cadenciaDeDisparo, double dmgMult )
	{
		owner				= tirador;
		colisionador		= miColisionador;
		anguloDisparo		= anguloDelDisparo;
		
		map					= mapa;
		rand				= new Randomizador( );
		panel				= new JPanel();
		tamano				= size;
		pos					= posicion;
		cadenciaDisparo		= (int) (1000.0 / cadenciaDeDisparo);
		multiplicadorDmg	= dmgMult;
		tiempoUltimoDisparo = System.nanoTime() + (rand.nextInt(1000) * 1000000L);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	protected double corregirAngulo( double angulo )
	{
		return -(angulo + anguloDisparo);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected Posicion getPosicionLanzamiento( Personaje p )
	{
		return
			new	Posicion(
				p.getPos().getX() + this.pos.getX(),
				p.getPos().getY() + this.pos.getY() + (this.tamano.getHeight() / 2)
			);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void lanzarDisparo(Personaje p)
	{
		long	tiempoActual	= System.nanoTime(),
				tiempoFinal		= tiempoUltimoDisparo + (cadenciaDisparo * 1000000L);
		
		// Si entre el último disparo y este intento pasó el tiempo mínimo establecido por la cadencia de disparo, entonces disparar.
		if (tiempoActual >= tiempoFinal)
		{
			tiempoUltimoDisparo = System.nanoTime();
			
			crearDisparo( p );
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actualizar( double msDesdeUltActualizacion )
	{
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////