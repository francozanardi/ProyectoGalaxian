package Enemigo;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import Arma.ArmaDefaultEnemigo;
import Colisiones.ColDispEnemigo;
import Colisiones.Colisionador;
import Colisiones.ColisionadorEnemigo;
import Enemigo.Estados.EstadoComun;
import Escudo.Escudo;
import Inteligencia.IAComun;
import Logica.Juego;
import Mapa.Mapa;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Camuflado extends Transformable
{
	
	public Camuflado(Mapa mapa, double dificultad) {
		this.map			= mapa;
		this.dificultad		= dificultad;
		
		this.rand			= new Randomizador();
		this.panel			= new JPanel( );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 3) );
		this.tamano 		= new Size(15, 15);
		this.escudo			= new LinkedList<Escudo>( );
		this.vida			= 200.0 * dificultad;
		this.puntaje		= (int) (dificultad * 30);

		actualizarPanel( true, new Color( rand.nextInt(128, 255), rand.nextInt(128, 255), rand.nextInt(128, 255) ) );
		
		this.estado 		= new EstadoComun(this);
	}

	public void serChocado(Colisionador col)
	{
		col.afectar(this);
	}

	@Override
	public void choque() {
		estado.choque();
	}
	
	public void recibirDMG(double dmg) {
		super.recibirDMG(dmg);
		estado.controlarTransformacion();
	}

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////