package Logica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controladores.ContNivelesGenerico;
import Controladores.ControladorNiveles;
import Grafica.GUI;
import Grafica.GUISimple;
import Jugador.Jugador;
import Menu.MediadorMenu;

import javax.swing.JLabel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;



@SuppressWarnings("serial")
public class Juego extends JFrame
{	
	public static final int		GAME_WIDTH			= 450,
								GAME_HEIGHT			= (int) (GAME_WIDTH * 1.5),
								GAME_FPS			= 60,
								GAME_BEST_SCORES	= 20;
	public static final String	GAME_TITLE = "Galaxian Trucho";
	

	
	private PanelMapa			panel;
	private Teclado				teclado;
	private ControladorNiveles	control;
	private MediadorMenu		mediadorMenu;
	private GUI					gui;


	
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



	private Juego()
	{
		super( GAME_TITLE );
		
		addKeyListener( new OyenteTeclado() );
		addMouseListener( new OyenteMouse() );
		addMouseMotionListener( new OyenteMouse() );
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//setBounds( 0, 0, GAME_WIDTH, GAME_HEIGHT );
		setPreferredSize( new Dimension(GAME_WIDTH, GAME_HEIGHT) );
		pack();
		setLocationRelativeTo( null );
		setResizable( false );

		crearPanel( );
		
		inicializarObjetos( );
		
		//startGame( );
	}
	
	
	
	private void inicializarObjetos( )
	{
		teclado			= new Teclado( );
		mediadorMenu	= new MediadorMenu( this );
		gui				= new GUISimple( getPanel() );
		
		mediadorMenu.menuPrincipal().show( true );
		gui.show( false );
	}


	
	public void startGame( )
	{
		// Esta método hace que el panel de fondo reciba el "foco", de lo contrario no se
		// registrarán apropiadamente los inputs del teclado.
		requestFocus();

		Jugador p = new Jugador();
		control = new ContNivelesGenerico( this, p );
		
		control.gameStart();
	}
	
	public void endGame( )
	{
		System.out.println("mostrar menu");
		
		panel.removeAllEntities();
		
		mediadorMenu = new MediadorMenu( this ); // SOLUCION TEMPORAL, NO SE DEBERIAN BORRAR LOS OBJETOS GRAFICOS YA CREADOS.

		mediadorMenu.menuPrincipal().show( true );
	}


	
	private void crearPanel( )
	{
		panel = new PanelMapa();
		panel.setLayout( null );
		setContentPane( panel );
	}


	
	public PanelMapa getPanel( )
	{
		return panel;
	}
	
	public GUI getGUI( )
	{
		return gui;
	}
	
	
	
	public Teclado getTeclado( )
	{
		return teclado;
	}


	
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
}