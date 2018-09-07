package Proyecto;

import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class EnemigoConcreto2 extends Enemigo
{
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public EnemigoConcreto2()
	{
		rand = new Random();
		this.panel	= new JPanel( );
		this.pos	= new Posicion(rand.nextInt(Juego.GAME_WIDTH), rand.nextInt( Juego.GAME_HEIGHT ));
		this.tamano	= new Size(15, 15);
		this.arma = new ArmaCuadrado();
		this.vida = 50;
		
		panel.setOpaque(true);
		panel.setBackground(new Color(130, 130, 130));
		actualizarPosicion();
		panel.setVisible(true);
		
		panel.add(arma.obtenerPanel());
		

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


