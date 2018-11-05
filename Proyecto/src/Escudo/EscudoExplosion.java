package Escudo;

import java.awt.Color;

import javax.swing.JPanel;

import Entidad.EntidadConVida;
import Utils.Posicion;
import Utils.Size;



public class EscudoExplosion extends Escudo
{	
	private int contExplosiones;


	
	public EscudoExplosion( EntidadConVida holder, int cantExplosiones )
	{
		this.pos				= new Posicion(2, 2);
		this.tamano				= new Size(10, 20);
		this.panel				= new JPanel();
		this.contExplosiones	= cantExplosiones;
		
		this.holder	 = holder;

		this.actualizarPanel(true, Color.pink);
	}


	
	public double modificarDmgExplosion(double dmg)
	{
		if (dmg > 0.0)
		{
			contExplosiones --;
			dmg = 0.0;
			
			if (contExplosiones == 0)
			{
				holder.getMapa().mostrarAnuncio("Se destruy� el escudo anti-kamikaze");

				remove();
			}
		}
		
		return dmg;
	}
}