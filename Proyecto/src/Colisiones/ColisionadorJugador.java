package Colisiones;

import Enemigo.Enemigo;
import Enemigo.Kamikaze;

public class ColisionadorJugador extends Colisionador
{
	
	public void afectar(Kamikaze kamikaze) {
		kamikaze.explotar();
	}
		
}
