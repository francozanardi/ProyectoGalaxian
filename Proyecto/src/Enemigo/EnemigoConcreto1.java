package Enemigo;

import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;

import Arma.ArmaCuadrado;
import Colisiones.Colisionador;
import Disparo.Disparo;
import Entidad.EntidadConVida;
import Jugador.Jugador;
import Mapa.Mapa;
import Inteligencia.IAComun;
import Grafica.Juego;
import Grafica.Posicion;
import Grafica.Size;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class EnemigoConcreto1 extends Enemigo
{
	///////////////////////////////////////////////////////////////////////////////////////////////
		
	public EnemigoConcreto1( Mapa map, float dificultad )
	{
		this.map = map;
		
		this.ia = new IAComun( map );
		
		this.dificultad = dificultad;
		
		this.puntaje = (int) (dificultad * 30);
		
		rand = new Random();
		this.panel	= new JPanel( );
		this.pos	= new Posicion(rand.nextInt(Juego.GAME_WIDTH), rand.nextInt( Juego.GAME_HEIGHT ));
		this.tamano	= new Size(15, 15);
		this.arma = new ArmaCuadrado();
		this.vida = 50;

		
		actualizarPanel( true, new Color( rand.nextInt(256), rand.nextInt(256), rand.nextInt(256) ) );
		
		panel.add( arma.obtenerPanel() );
		

	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	

	@Override
	public void hacerDMG(Colisionador c, EntidadConVida receptor, Disparo disparo) {
		receptor.recibirDMG(c, this, disparo);
	}

	@Override
	public void recibirDMG(Colisionador c, Jugador lanzador, Disparo disparo) {
		c.huboColision(lanzador, this, disparo);
		
	}
	
	public void recibirDMG(Colisionador c, Enemigo lanzador, Disparo disparo) {
		c.huboColision(lanzador, this, disparo);
		
	}
}
