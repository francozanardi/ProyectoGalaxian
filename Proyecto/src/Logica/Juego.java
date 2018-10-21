package Logica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controladores.ContNivelesGenerico;
import Controladores.ControladorNiveles;
import Jugador.Jugador;
import Mapa.Mapa;
import Mapa.MapaGenerico;

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
	
	public static final int		GAME_WIDTH	= 450,
								GAME_HEIGHT	= (int) (GAME_WIDTH * 1.5),
								GAME_FPS	= 30;
	public static final String	GAME_TITLE = "Galaxian Trucho";

	////////////////////////////////////////////////w///////////////////////////////////////////////
	
	private JPanel				panel;
	private JLabel				labelPuntaje;
	private MainThread			tiempo;
	private Mapa				mapa;
	private Teclado				teclado;
	private ControladorNiveles	control;

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

	private Juego()
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
		
		teclado = new Teclado( );
		
		Jugador p = new Jugador();
		
		startGame( p );
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void startGame( Jugador p )
	{
		control = new ContNivelesGenerico( this, p );
		control.gameStart();
	}
	
	public void endGame( )
	{
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void crearPanel( )
	{
		panel = new JPanel();
		panel.setLayout( null );
		setContentPane( panel );
	}
	
	public void resetPanel( )
	{
		panel.removeAll();
		panel.add(labelPuntaje);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void crearLabel( )
	{
		labelPuntaje = new JLabel( );
		labelPuntaje.setBounds(5, 5, GAME_WIDTH, 30);
		labelPuntaje.setFont( new Font("Consolas", Font.BOLD, 12) );
		labelPuntaje.setForeground( new Color(255, 255, 255) );
		labelPuntaje.setVisible(true);
		
		panel.add(labelPuntaje);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public JPanel getPanel( )
	{
		return panel;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public JLabel obtenerLabelPuntaje( )
	{
		return labelPuntaje;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Teclado obtenerTeclado( )
	{
		return teclado;
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
			teclado.press( arg0.getKeyCode() );
		}

		public void keyReleased(KeyEvent arg0)
		{
			teclado.release( arg0.getKeyCode() );
		}

		public void keyTyped(KeyEvent arg0)
		{
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
