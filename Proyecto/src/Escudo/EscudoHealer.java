package Escudo;

import java.awt.Color;

import javax.swing.JPanel;

import Entidad.EntidadConVida;
import Utils.Posicion;
import Utils.Size;



public class EscudoHealer extends Escudo
{	
	private double	totalHPRegenerado,
					healPorSeg,
					healTotal;


	
	public EscudoHealer( EntidadConVida holder, double healSeg, double maxHeal )
	{
		this.pos	= new Posicion(2, 2);
		this.tamano	= new Size(10, 10);
		this.panel	= new JPanel();
		
		this.holder = holder;

		this.totalHPRegenerado	= 0;
		this.healPorSeg			= healSeg;
		this.healTotal			= maxHeal;
		
		this.actualizarPanel(true, Color.green);
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