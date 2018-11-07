package visitor;

import Enemigo.Kamikaze;



public class ColJugador extends Colisionador
{
	public ColJugador( )
	{
	}
	
	
	
	public void visit(Kamikaze kamikaze)
	{
		kamikaze.explotar();
	}
}
