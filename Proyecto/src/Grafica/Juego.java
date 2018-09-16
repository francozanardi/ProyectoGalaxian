package Grafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Jugador.Jugador;
import Mapa.Mapa;

import javax.swing.JLabel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Juego extends JFrame
{
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static final int		GAME_WIDTH	= 400,
								GAME_HEIGHT	= 600,
								GAME_FPS	= 30;
	public static final String	GAME_TITLE = "Galaxian Trucho";

	////////////////////////////////////////////////w///////////////////////////////////////////////
	
	private JPanel		panel;
	private JLabel		labelPuntaje;
	private MainThread	tiempo;
	private Mapa		mapa;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Juego frame = new Juego();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	public Juego()
	{
		super( GAME_TITLE );
		
		addKeyListener( new OyenteTeclado() );
		addMouseListener( new OyenteMouse() );
		addMouseMotionListener( new OyenteMouse() );
				
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 0, 0, GAME_WIDTH, GAME_HEIGHT );
		setLocationRelativeTo( null );
		setResizable( false );

		crearPanel( );
		crearLabel( );
		
		Jugador p = new Jugador();
		mapa = new Mapa( this, p );
		
		p.setMapa(mapa); //Esto debemos hacerlo así, ya que de esta manera pasamos el objeto mapa. Sino le pasamos un null.
		p.getArma().setMapa(mapa); //Como ponemos el mapa ahora también debemos procurar que nuestra arma tenga el verdadero mapa.
		
		
		tiempo = new MainThread( mapa, GAME_FPS );
		tiempo.start( );
		
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void crearPanel( )
	{
		panel = new JPanel();
		panel.setLayout( null );
		setContentPane( panel );
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void crearLabel( )
	{
		labelPuntaje = new JLabel( );
		labelPuntaje.setBounds(5, 5, GAME_WIDTH, 30);
		labelPuntaje.setFont( new Font("Consolas", Font.BOLD, 12) );
		labelPuntaje.setForeground( new Color(255, 255, 255) );
		labelPuntaje.setVisible(true);
		
		panel.add(labelPuntaje);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public JPanel obtenerPanel( )
	{
		return panel;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public JLabel obtenerLabelPuntaje( )
	{
		return labelPuntaje;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private class OyenteMouse implements MouseListener, MouseMotionListener
	{
		public void mouseClicked(MouseEvent arg0)
		{			
		}

		public void mouseEntered(MouseEvent arg0)
		{
		}

		public void mouseExited(MouseEvent arg0)
		{			
		}

		public void mousePressed(MouseEvent arg0)
		{			
		}

		public void mouseReleased(MouseEvent arg0)
		{
		}
		
		public void mouseDragged(MouseEvent arg0)
		{
		}

		public void mouseMoved(MouseEvent arg0)
		{
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private class OyenteTeclado implements KeyListener
	{
		public void keyPressed(KeyEvent arg0)
		{
			mapa.teclaApretada( arg0 );
		}

		public void keyReleased(KeyEvent arg0)
		{
			mapa.teclaSuelta( arg0 );
		}

		public void keyTyped(KeyEvent arg0)
		{
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
