package Arma;

import java.util.LinkedList;
import java.util.List;

import Colisiones.Colisionador;
import Colisiones.ColDisparo;
import Disparo.Disparo;
import Entidad.Entidad;
import Entidad.EntidadConVida;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Randomizador;



public abstract class Arma extends Entidad
{	
	protected double				cadenciaDisparo,	// determina cada cuantos MILISEGUNDOS se puede disparar.
									multDmg,
									multCadencia,
									anguloDisparo;
	protected long					tiempoUltimoDisparo;
	protected EntidadConVida 		owner;
	protected ColDisparo			colisionador;


	
	protected abstract List<Disparo> crearDisparo( );
	
	public void serChocado( Colisionador col )
	{
	}
	
	public void actualizar( double msDesdeUltActualizacion )
	{
	}


	
	public EntidadConVida getOwner( )
	{
		return this.owner;
	}


	
	public double getCadencia( )
	{
		return cadenciaDisparo;
	}
	
	public void setMultCadencia( double mult )
	{
		multCadencia = mult;
	}
	
	public double getMultCadencia( )
	{
		return multCadencia;
	}


	
	public void setMultDmg( double mult )
	{
		multDmg = mult;
	}
	
	public double getMultDmg( )
	{
		return multDmg;
	}


	
	/**
	 * Este método inicializa la variable tiempoUltimoDisparo con un delay aleatorio entre 0 y 1000 miliegundos,
	 * de esta forma nos aseguramos de que los enemigos no disparen todos a la vez.
	 */
	protected void inicializar( Sprite spr, Posicion offset, EntidadConVida tirador, ColDisparo miColisionador, double anguloDelDisparo, double cadenciaDeDisparo, double dmgMult )
	{
		owner				= tirador;
		colisionador		= miColisionador;
		anguloDisparo		= anguloDelDisparo;
		map					= tirador.getMapa();
		rand				= Randomizador.create( );
		
		setSprite( spr );
		
		pos =	new Posicion(
					(tirador.getSize().getWidth() / 2) - (spr.getSize().getWidth() / 2) + offset.getX(),
					(tirador.getSize().getHeight() / 2) - (spr.getSize().getHeight() / 2) + offset.getY()
				);
		
		cadenciaDisparo		= (1000.0 / cadenciaDeDisparo);
		multDmg				= dmgMult;
		multCadencia		= 1.0;
		tiempoUltimoDisparo = System.nanoTime() + (rand.nextInt(1000) * 1000000L);
	}



	protected double corregirAngulo( double angulo )
	{
		return -(angulo + anguloDisparo);
	}


	
	protected Posicion getPosicionLanzamiento( )
	{
		return
			new	Posicion(
				owner.getPos().getX() + this.pos.getX() + (this.tamano.getWidth() / 2),		// El disparo debe salir aproximadamente del centro del arma (horizontalmente).
				owner.getPos().getY() + this.pos.getY() + (this.tamano.getHeight() / 2)		// El dispará saldra aproximadamente desde la mitad del arma (verticalmente).
			);
	}


	
	public List<Disparo> lanzarDisparo( )
	{
		List<Disparo> lista = new LinkedList<Disparo>();
		
		long	tiempoActual	= System.nanoTime(),
				tiempoFinal		= (long) (tiempoUltimoDisparo + ((cadenciaDisparo * multCadencia) * 1000000));
		
		// Si entre el último disparo y este intento pasó el tiempo mínimo establecido por la cadencia de disparo, entonces disparar.
		if (tiempoActual >= tiempoFinal)
		{
			tiempoUltimoDisparo = System.nanoTime();
			
			lista = crearDisparo( );
		}
		
		return lista;
	}
}