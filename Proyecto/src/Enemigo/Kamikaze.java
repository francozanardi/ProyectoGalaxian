package Enemigo;

import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;

import Arma.ArmaCuadrado;
import Colisiones.Colisionador;
import Disparo.Disparo;
import Entidad.EntidadConVida;
import Grafica.Juego;
import Grafica.Posicion;
import Grafica.Size;
import Inteligencia.IAKamikaze;
import Jugador.Jugador;
import Mapa.Mapa;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Kamikaze extends Enemigo
{
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Kamikaze( Mapa map, float dificultad )
	{
		this.map = map;
		
		this.ia = new IAKamikaze( map );
		
		this.dificultad = dificultad;
		
		this.puntaje = (int) (dificultad * 50);
		
		rand = new Random();
		this.panel	= new JPanel( );
		this.pos	= new Posicion(rand.nextInt(Juego.GAME_WIDTH), rand.nextInt( Juego.GAME_HEIGHT ));
		this.tamano	= new Size(35, 20);
		this.arma = new ArmaCuadrado();
		this.vida = 100;
		
		actualizarPanel( true, new Color( 100, 0, 0 ) );
		
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


