package Entidad;

import java.util.LinkedList;
import java.util.List;

import Arma.Arma;
import Escudo.Escudo;



public abstract class EntidadConVida extends Entidad
{	
	protected double		vida;
	protected Arma			arma;
	protected List<Escudo>	escudo;
	private   List<Escudo>	escudosABorrar = new LinkedList<Escudo>( );	
	protected int			puntaje;


	
	protected void morir( )
	{
	}
	
	public void disparar( )
	{
	}


	
	public void setArma( Arma arma )
	{
		this.arma = arma;
		this.panel.add( arma.getPanel() );
	}
	
	public void changeArma( Arma nuevaArma )
	{
		double	multViejo		= nuevaArma.getMultDmg(),
				cadenciaVieja	= nuevaArma.getMultCadencia();
		
		if (arma != null)
		{
			multViejo		= arma.getMultDmg();
			cadenciaVieja	= arma.getMultCadencia();
		}
		
		nuevaArma.setMultDmg( multViejo );
		nuevaArma.setMultCadencia( cadenciaVieja );
		setArma( nuevaArma );
	}
	
	public Arma getArma( )
	{
		return arma;
	}


	
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



	public void givePuntaje( int p )
	{
		puntaje += p;
	}
	
	public int getPuntaje( )
	{
		return puntaje;
	}


	
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


	
	private void controlarEscudosABorrar( )
	{
		if (!escudosABorrar.isEmpty()) {
			for (Escudo e: escudosABorrar) {
				escudo.remove( e );
			}
		}
		
		escudosABorrar.clear();
	}


	
	protected void actualizarEscudos( double msDesdeUltActualizacion )
	{
		controlarEscudosABorrar( );
		
		for (Escudo e: escudo)
			e.actualizar(msDesdeUltActualizacion);
	}

	protected double utilizarEscudosExplosion( double dmg )
	{
		controlarEscudosABorrar( );
		
		for (Escudo e: escudo)
			dmg = e.modificarDmgExplosion( dmg );
		
		return dmg;
	}

	protected double utilizarEscudos( double dmg )
	{
		controlarEscudosABorrar( );
		
		for (Escudo e: escudo)
			dmg = e.modificarDmg( dmg );
		
		return dmg;
	}


	
	public void actualizar( double msDesdeUltAct )
	{
		actualizarEscudos( msDesdeUltAct );
	}
}