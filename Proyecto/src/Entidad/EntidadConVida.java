package Entidad;

import java.util.LinkedList;
import java.util.List;

import Arma.Arma;
import Escudo.Escudo;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public abstract class EntidadConVida extends Entidad
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected double		vida;
	protected Arma			arma;
	protected List<Escudo>	escudo;
	private   List<Escudo>	escudosABorrar = new LinkedList<Escudo>( );
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void morir( )
	{
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setArma( Arma arma )
	{
		this.arma = arma;
		this.panel.add( arma.getPanel() );
	}
	
	public void changeArma( Arma nuevaArma )
	{
		double multViejo = 1.0;
		
		if (arma != null)
			multViejo = arma.getMultiplicadorDmg();
		
		nuevaArma.setMultiplicadorDmg( multViejo );
		setArma( nuevaArma );
	}
	
	public Arma getArma( )
	{
		return arma;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void addEscudo( Escudo e )
	{
		escudo.add( e );
		
		this.panel.add( e.getPanel() );
	}
	
	public void removeEscudo( Escudo e )
	{
		this.panel.remove( e.getPanel() );
		
		// Lo quitamos de la lista de escudos
		escudosABorrar.add( e );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setVida(double vida)
	{
		this.vida = vida;
		if (vida <= 0)
		{
			morir( );
			remove( );
		}
	}

	public double getVida()
	{
		return vida;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected void actualizarEscudos( double msDesdeUltActualizacion )
	{
		if (!escudosABorrar.isEmpty())
		{
			for (Escudo e: escudosABorrar)
				escudo.remove( e );
		}
		
		for (Escudo e: escudo)
			e.actualizar(msDesdeUltActualizacion);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected double utilizarEscudos( double dmg )
	{
		if (!escudosABorrar.isEmpty())
		{
			for (Escudo e: escudosABorrar)
				escudo.remove( e );
		}
		
		for (Escudo e: escudo)
			dmg = e.modificarDmg( dmg );
		
		return dmg;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void recibirDMG(double dmg)
	{
		dmg = utilizarEscudos( dmg );
		
		vida -= dmg;
		if (vida <= 0)
		{
			morir( );
			remove( );
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void actualizar( double msDesdeUltAct )
	{
		actualizarEscudos( msDesdeUltAct );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////