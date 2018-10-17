package Enemigo;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import Arma.ArmaDefaultEnemigo;
import Arma.ArmaSniper;
import Colisiones.ColDispEnemigo;
import Colisiones.Colisionador;
import Colisiones.ColisionadorEnemigo;
import Colisiones.ColisionadorKamikaze;
import Enemigo.Estados.Estado;
import Enemigo.Estados.EstadoGuiado;
import Enemigo.Estados.EstadoKamikazeFragil;
import Escudo.Escudo;
import Inteligencia.IAComun;
import Inteligencia.IAKamikaze;
import Logica.Juego;
import Mapa.Mapa;
import PowerUp.PowerUpHeal;
import PowerUp.PowerUpMultiplicador;
import Utils.Posicion;
import Utils.Randomizador;
import Utils.Size;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class KamikazeFragil extends Transformable
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public KamikazeFragil( Mapa map, double dificultad )
	{	
		this.map			= map;
		this.dificultad		= dificultad;
		
		this.rand			= new Randomizador();
		this.panel			= new JPanel( );
		this.pos			= new Posicion( rand.nextInt(Juego.GAME_WIDTH), (rand.nextInt( Juego.GAME_HEIGHT ) / 8) );
		this.tamano			= new Size(30, 15);
		this.escudo			= new LinkedList<Escudo>( );
		
		this.puntaje		= (int) (dificultad * 50);
		this.vida			= 400 * dificultad;
		this.estado			= new EstadoGuiado(this);

		setArma( new ArmaSniper(map, this, new ColDispEnemigo(), 3.0 / 2.0 * Math.PI) );
		setPowerUp( new PowerUpMultiplicador(map) );
		
		actualizarPanel( true, new Color( 100, 100, 100 ) );	
	}
	

	public void serChocado(Colisionador col)
	{
		col.afectar(this);
	}

	public void recibirDMG(double dmg) {
		super.recibirDMG(dmg);
		estado.controlarTransformacion();
	}


	@Override
	public void choque() {
		estado.choque();		
	}
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
