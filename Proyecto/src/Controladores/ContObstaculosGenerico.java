package Controladores;

import java.util.Random;

import Logica.Juego;
import Mapa.Mapa;
import Obstaculo.BarricadaComun;
import Obstaculo.Obstaculo;
import Obstaculo.ObstaculoComun;
import Sprite.Sprite;
import Utils.Posicion;
import Utils.Randomizador;



public class ContObstaculosGenerico extends ControladorObstaculos
{
	private final int	COLUMNA_WIDTH	= 75,
						COLUMNAS		= Juego.GAME_WIDTH / COLUMNA_WIDTH;
	
	
	
	protected double dificultad;
	
	
	
	public ContObstaculosGenerico( Mapa map, double dificultad )
	{
		this.dificultad	= dificultad;
		this.map		= map;
	}
	
	
	
	public void crearObstaculos()
	{
		int i,
			cant = (int) Math.min(dificultad, COLUMNAS);
				
		for (i = 1; i <= cant; i ++)
		{
			map.addEntity( crearObstaculo(i) );
		}
	}

	private Obstaculo crearObstaculo( int columna )
	{
		Randomizador rand = Randomizador.create();
		Obstaculo	 o;
		double		 chanceDestructible = rand.nextDouble();
		
		if (chanceDestructible <= Math.min(dificultad / 10.0, 1.0))
			o = new ObstaculoComun( map, new Posicion(COLUMNA_WIDTH * columna, rand.nextDouble(Juego.GAME_HEIGHT / 5, (Juego.GAME_HEIGHT / 3) * 2)) );
		else
			o = new BarricadaComun( map, new Posicion(COLUMNA_WIDTH * columna, rand.nextDouble(Juego.GAME_HEIGHT / 5, (Juego.GAME_HEIGHT / 3) * 2)) );
			
		
		return o;
	}
}
