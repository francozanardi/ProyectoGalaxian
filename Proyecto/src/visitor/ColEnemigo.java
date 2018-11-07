package visitor;

import Disparo.Disparo;



public class ColEnemigo extends Colisionador
{	
	public ColEnemigo()
	{
	}
	
	
	
	public void visit( Disparo disparo )
	{
		disparo.remove();
	}
}