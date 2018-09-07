package Proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
								GAME_FPS	= 100;
	public static final String	GAME_TITLE = "Galaxian Trucho";

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private JPanel		panel;
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
		
		Jugador p = new Jugador();
		mapa = new Mapa( this, p );
		
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
	
	public JPanel obtenerPanel( )
	{
		return panel;
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
			mapa.actividadTeclado( arg0 );
		}

		public void keyReleased(KeyEvent arg0)
		{
		}

		public void keyTyped(KeyEvent arg0)
		{
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
