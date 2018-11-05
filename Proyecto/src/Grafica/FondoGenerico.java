package Grafica;

import java.awt.Color;
import javax.swing.JPanel;



/**
 * Este fondo titila entre dos colores especificados a una velocidad especificada.
 * 
 * @author Nicolas
 */
public class FondoGenerico extends Fondo
{	
	private double[] colActual;
	private int[]	colInicial, colFinal, colMax, colMin;
	private int		sign;
	private int		fadeTime;


	
	public FondoGenerico( JPanel componenteGrafico, int tiempoFadeMS, Color colorInicial, Color colorFinal )
	{	
		super( componenteGrafico );
		
		fadeTime	= tiempoFadeMS;
		colInicial	= new int[]{ colorInicial.getRed(), colorInicial.getGreen(), colorInicial.getBlue() };
		colFinal	= new int[]{ colorFinal.getRed(), colorFinal.getGreen(), colorFinal.getBlue() };
		colActual	= new double[]{ colorInicial.getRed(), colorInicial.getGreen(), colorInicial.getBlue() };
		sign = 1;
		
		colMax = new int[]{ Math.max(colInicial[0], colFinal[0]), Math.max(colInicial[1], colFinal[1]), Math.max(colInicial[2], colFinal[2]) };
		colMin = new int[]{ Math.min(colInicial[0], colFinal[0]), Math.min(colInicial[1], colFinal[1]), Math.min(colInicial[2], colFinal[2]) };
		
		actualizar( 1.0 );
	}


	
	public void actualizar( double msDesdeUltActualizacion  )
	{
		// Aumentar los colores segun el tiempo transcurrido
		colActual[0] += sign * (((colFinal[0] - colInicial[0]) * 1.0) / fadeTime) * msDesdeUltActualizacion;
		colActual[1] += sign * (((colFinal[1] - colInicial[1]) * 1.0) / fadeTime) * msDesdeUltActualizacion;
		colActual[2] += sign * (((colFinal[2] - colInicial[2]) * 1.0) / fadeTime) * msDesdeUltActualizacion;
		
		
		
		// Si algún número se excedió, invertir el signo para hacer fade hacia el otro color.
		if (colActual[0] < colMin[0] || colActual[0] > colMax[0] ||
			colActual[1] < colMin[1] || colActual[1] > colMax[1] ||
			colActual[2] < colMin[2] || colActual[2] > colMax[2])
		{
			sign *= -1;
		}
		
		
		
		// Corregir los números que se hayan excedido.
		if (colActual[0] > colMax[0])
			colActual[0] -= 2 * (colActual[0] - colMax[0]);
		else if (colActual[0] < colMin[0])
			colActual[0] += 2 * (colMin[0] - colActual[0]);
		
		
		if (colActual[1] > colMax[1])
			colActual[1] -= 2 * (colActual[1] - colMax[1]);
		else if (colActual[1] < colMin[1])
			colActual[1] += 2 * (colMin[1] - colActual[1]);
		
		
		if (colActual[2] > colMax[2])
			colActual[2] -= 2 * (colActual[2] - colMax[2]);
		else if (colActual[2] < colMin[2])
			colActual[2] += 2 * (colMin[2] - colActual[2]);
		
		
		
		canvas.setBackground( new Color((int) colActual[0], (int) colActual[1], (int) colActual[2]) );
	}
}