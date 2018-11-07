package Escudo;

import Entidad.EntidadConVida;
import Sprite.Sprite;
import Utils.Posicion;



public class EscudoHealer extends Escudo
{	
	private double	totalHPRegenerado,
					healPorSeg,
					healTotal;


	
	public EscudoHealer( EntidadConVida holder, double healSeg, double maxHeal )
	{
		setSprite( new Sprite( "/GameSprites/Escudo.PNG" ) );
		
		this.pos	= new Posicion(2, 2);
		this.holder = holder;

		this.totalHPRegenerado	= 0;
		this.healPorSeg			= healSeg;
		this.healTotal			= maxHeal;
	}


	
	public void actualizar(double msDesdeUltActualizacion)
	{
		double curacion = conversionEnTiempo( healPorSeg, msDesdeUltActualizacion );
		
		// Verificar que no curemos de más
		if ((curacion + totalHPRegenerado) > healTotal)
			curacion = healTotal - totalHPRegenerado;
		
		totalHPRegenerado += curacion;
		
		holder.setVida( holder.getVida() + curacion );
		
		// Al haber curado toda la vida, destruir el escudo
		if (totalHPRegenerado == healTotal)
		{
			holder.getMapa().mostrarAnuncio( "Se terminó el escudo de regeneración" );
			
			remove();
		}
	}
}