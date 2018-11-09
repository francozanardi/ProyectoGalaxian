package Grafica;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Logica.Juego;



public class GUISimple extends GUI
{
	private final boolean	MAYUSCULA_ANUNCIOS	= true;

	private final Font		ANUNCIO_FONT		= new Font( "Ubuntu", Font.BOLD, 16 );
	private final Color		ANUNCIO_COLOR		= new Color( 255, 255, 255 );
	
	private final Font		FPS_FONT			= new Font( "Consolas", Font.BOLD, 12 );
	private final Color		FPS_COLOR			= new Color( 255, 255, 255 );
	
	private final Font		HP_FONT				= new Font( "Ubuntu", Font.BOLD, 12 );
	private final Color		HP_COLOR			= new Color( 0, 255, 0 );
	
	private final Font		HPC_FONT			= new Font( "Ubuntu", Font.BOLD, 12 );
	private final Color		HPC_COLOR			= new Color( 255, 255, 255 );
	
	private final Font		SCORE_FONT			= new Font( "Ubuntu", Font.BOLD, 12 );
	private final Color		SCORE_COLOR			= new Color( 255, 255, 0 );
	
	private final Font		SCOREC_FONT			= new Font( "Ubuntu", Font.BOLD, 12 );
	private final Color		SCOREC_COLOR		= new Color( 255, 255, 255 );
	
	
	
	private Timer	timerAnuncio,
					timerHPChange,
					timerScoreChange;
	private JLabel	lblAnuncio,
					lblFPS,
					lblHP,
					lblHPChange,
					lblScore,
					lblScoreChange;
	private double	lastHP = Double.MIN_VALUE,
					dmgAcumulado = 0;
	private int		lastScore = Integer.MIN_VALUE,
					scoreAcumulado = 0;
	
	
	
	public GUISimple( JPanel canvas )
	{
		this.canvas = canvas;
		
		createVisual( );
		
		show( false );
	}

	

	public void createVisual( )
	{
		crearVisualFPS();
		crearVisualHP();
		crearVisualScore();
		crearVisualAnuncio();
	}
	
	private void crearVisualFPS( )
	{		
		lblFPS = new JLabel();
		lblFPS.setOpaque(false);
		lblFPS.setHorizontalAlignment( SwingConstants.RIGHT );
		lblFPS.setVerticalAlignment( SwingConstants.TOP );
		lblFPS.setFont( FPS_FONT );
		lblFPS.setForeground( FPS_COLOR );
		lblFPS.setBounds( Juego.GAME_WIDTH - 100, 5, 90, 20 );
		
		canvas.add(lblFPS);
	}
	
	private void crearVisualHP( )
	{
		lblHP = new JLabel();
		lblHP.setOpaque(false);
		lblHP.setFont( HP_FONT );
		lblHP.setForeground( HP_COLOR );
		lblHP.setVerticalAlignment( SwingConstants.TOP );
		lblHP.setBounds( 5, 5, 100, 20 );
		
		lblHPChange = new JLabel();
		lblHPChange.setOpaque(false);
		lblHPChange.setFont( HPC_FONT );
		lblHPChange.setForeground( HPC_COLOR );
		lblHPChange.setVerticalAlignment( SwingConstants.TOP );
		lblHPChange.setBounds( 5, 30, 100, 20 );
		
		canvas.add(lblHP);
		canvas.add(lblHPChange);
	}
	
	private void crearVisualAnuncio( )
	{
		lblAnuncio = new JLabel( );
		lblAnuncio.setBounds(0, 50, Juego.GAME_WIDTH, 300);
		lblAnuncio.setHorizontalAlignment( SwingConstants.CENTER );
		lblAnuncio.setVerticalAlignment( SwingConstants.TOP );
		lblAnuncio.setFont( ANUNCIO_FONT );
		lblAnuncio.setForeground( ANUNCIO_COLOR );
		
		canvas.add(lblAnuncio);
	}
	
	private void crearVisualScore( )
	{
		lblScore = new JLabel();
		lblScore.setOpaque(false);
		lblScore.setFont( SCORE_FONT );
		lblScore.setForeground( SCORE_COLOR );
		lblScore.setVerticalAlignment( SwingConstants.TOP );
		lblScore.setHorizontalAlignment( SwingConstants.CENTER );
		lblScore.setBounds( (Juego.GAME_WIDTH / 2) - 50, 5, 100, 20 );
		
		lblScoreChange = new JLabel();
		lblScoreChange.setOpaque(false);
		lblScoreChange.setFont( SCOREC_FONT );
		lblScoreChange.setForeground( SCOREC_COLOR );
		lblScoreChange.setVerticalAlignment( SwingConstants.TOP );
		lblScoreChange.setHorizontalAlignment( SwingConstants.CENTER );
		lblScoreChange.setBounds( (Juego.GAME_WIDTH / 2) - 50, 30, 100, 20 );
		
		canvas.add(lblScore);
		canvas.add(lblScoreChange);
	}
	
	
	
	public void show( boolean toggle )
	{
		lblAnuncio.setVisible( toggle );
		lblFPS.setVisible( toggle );
		lblHP.setVisible( toggle );
		lblHPChange.setVisible( toggle );
		lblScore.setVisible( toggle );
		lblScoreChange.setVisible( toggle );
	}
	
	
	
	public void updateHP( double hp, double maxHP )
	{
		lblHP.setText( String.format("HP: %.0f", hp) );
		
		if (lastHP != Double.MIN_VALUE)
		{
			double change = hp - lastHP;
			dmgAcumulado += change;
			
			
			if (change != 0)
			{
				if (dmgAcumulado > 0)
				{
					lblHPChange.setText( String.format("+%.0f", dmgAcumulado) );
					lblHPChange.setForeground( Color.green );
				}
				else
				{
					lblHPChange.setText( String.format("%.0f", dmgAcumulado) );
					lblHPChange.setForeground( Color.red );
				}
			}
			
			
			if (change != 0)
			{
				if (timerHPChange != null)
				{
					timerHPChange.cancel();
					timerHPChange = null;
				}
				
				timerHPChange = new Timer(); 
				timerHPChange.schedule( new TimerChangeHP(), 2000 );
			}
		}
		
		lastHP = hp;
	}


	
	public void updateScore( int score )
	{
		lblScore.setText( String.format("<html>%06d</html>", score) );
		
		if (lastScore != Integer.MIN_VALUE)
		{
			int change = score - lastScore;
			scoreAcumulado += change;
			
			
			if (change != 0)
			{
				if (scoreAcumulado > 0)
				{
					lblScoreChange.setText( "+" + scoreAcumulado );
					lblScoreChange.setForeground( Color.green );
				}
				else
				{
					lblScoreChange.setText( "" + scoreAcumulado );
					lblScoreChange.setForeground( Color.red );
				}
			}
			
			if (change != 0)
			{
				if (timerScoreChange != null)
				{
					timerScoreChange.cancel();
					timerScoreChange = null;
				}
				
				timerScoreChange = new Timer(); 
				timerScoreChange.schedule( new TimerChangeScore(), 2000 );
			}
		}
		
		lastScore = score;
	}


	
	public void updateFPS(double fps)
	{
		lblFPS.setText( String.format("FPS: %.0f", fps) );
	}


	
	public void announce(String texto, int duracionMS)
	{		
		if (MAYUSCULA_ANUNCIOS)
			texto = texto.toUpperCase();
		
		lblAnuncio.setText( texto );

		if (timerAnuncio != null)
		{
			timerAnuncio.cancel();
			timerAnuncio = null;
		}
		
		timerAnuncio = new Timer(); 
		timerAnuncio.schedule( new TimerQuitarAnuncio(), duracionMS );
	}

	

	private class TimerQuitarAnuncio extends TimerTask
	{
		public void run()
		{
			lblAnuncio.setText("");
		}
	}
	
	private class TimerChangeHP extends TimerTask
	{
		public void run()
		{
			dmgAcumulado = 0;
			lblHPChange.setText("");
		}
	}
	
	private class TimerChangeScore extends TimerTask
	{
		public void run()
		{
			scoreAcumulado = 0;
			lblScoreChange.setText("");
		}
	}
}
