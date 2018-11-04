package Escudo;

import java.awt.Color;

import javax.swing.JPanel;

import Entidad.EntidadConVida;
import Utils.Posicion;
import Utils.Size;



public class EscudoAbsoluto extends Escudo
{	
	private int disparosMitigados;


	
	public EscudoAbsoluto( EntidadConVida holder, int duracionEnDisparos )
	{
		this.pos				= new Posicion(2, 2);
		this.tamano				= new Size(10, 30);
		this.panel				= new JPanel();
		this.disparosMitigados	= duracionEnDisparos;
		
		this.holder				= holder;

		this.actualizarPanel(true, Color.yellow);
	}


	
	public double modificarDmg( double dmg )
	{
		disparosMitigados --;
		
		if (disparosMitigados == 0)
			remove( );
		
		return 0.0;
	}
}