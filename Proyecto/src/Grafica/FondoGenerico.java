package Grafica;

import java.awt.Color;
import javax.swing.JPanel;



public class FondoGenerico extends Fondo
{
	private final int	TIEMPO_FADE_MS = 1000,
						FADE_MINIMO = 0,
						FADE_MAXIMO = 50;


	
	private double	fade,
					suma;


	
	public FondoGenerico( JPanel panelDelJuego )
	{	
		super( panelDelJuego );
		
		fade = 0;
		suma = 1;
		
		actualizar( 1.0 );
	}


	
	public void actualizar( double msDesdeUltActualizacion  )
	{
		fade += suma * (msDesdeUltActualizacion / ((TIEMPO_FADE_MS * 1.0) / (FADE_MAXIMO - FADE_MINIMO)));
		
		if (fade <= FADE_MINIMO)
		{
			fade = FADE_MINIMO;
			suma = 1;
		}
		else if (fade >= FADE_MAXIMO)
		{
			fade = FADE_MAXIMO;
			suma = -1;
		}
		
		canvas.setBackground( new Color((int) fade, (int) fade, (int) fade) );
	}
}