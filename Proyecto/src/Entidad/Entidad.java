package Entidad;

import Inteligencia.Inteligencia;
import Mapa.Mapa;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;
import visitor.ColEntidad;
import visitor.Colisionador;
import visitor.Visitor;



public abstract class Entidad
{	
	protected Sprite		sprite;
	protected Posicion		pos;
	protected Size			tamano;
	protected Mapa			map;
	protected Randomizador	rand;
	protected Colisionador	colisionador = new ColEntidad();
	protected Inteligencia	ia;



	public abstract void accept(Visitor col);
	
	public abstract void actualizar( double msDesdeUltActualizacion );


	public Inteligencia getIA() {
		return this.ia;
	}

	public void setSprite( Sprite spr )
	{
		if (this.sprite == null)
			this.sprite = spr;
		else
			this.sprite.setImage( spr.getImage() );
		/*
		 * Es necesario que hagamos setImage de getImage, debemos recordar que Sprite extiende a JPanel,
		 * el método este recibe un Sprite, por lo que si trabajacemos con el sprite recibido por parámetro,
		 * deberíamos añadirlo al JPanel del juego y remover el viejo, lo cual no es conveniente.
		 * De esta forma, sólo le cambiamos la imagen al que ya está añadido al juego y le ajustamos su tamaño.
		 */

		this.tamano = new Size( spr.getWidth(), spr.getHeight() );
	}
	
	public Sprite getSprite( )
	{
		return sprite;
	}
	
	public void setIA(Inteligencia ia)
	{
		this.ia = ia;
	}
	
	public Posicion getPos( )
	{
		return pos;
	}
		
	public void setPos( Posicion newPos )
	{
		pos.setX( newPos.getX() );
		pos.setY( newPos.getY() );
	}
	
	public Size getSize( )
	{
		return tamano;
	}
		
	public Mapa getMapa( )
	{
		return this.map;
	}
	
	public void setMapa( Mapa map )
	{
		this.map = map;
	}

	protected void actualizarPosicion()
	{
		sprite.setBounds(
			(int) Math.round( pos.getX() ),
			(int) Math.round( pos.getY() ),
			tamano.getWidth(),
			tamano.getHeight()
		);
		
		sprite.repaint();
	}

	protected double conversionEnTiempo( double unidadesPorSegundo, double tiempoTranscurrido )
	{
		return tiempoTranscurrido * (unidadesPorSegundo / 1000.0);
	}

	public void remove()
	{
		map.removeEntity(this);
	}
	
	public void colisionar(Entidad e)
	{
		e.accept(colisionador);
	}
}