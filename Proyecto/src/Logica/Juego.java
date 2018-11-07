package Logica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controladores.ContNivelesGenerico;
import Controladores.ControladorNiveles;
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
	

	
	private JPanel				panel;
	private JLabel				labelPuntaje;
	private JLabel				labelMensaje;
	private Teclado				teclado;
	private ControladorNiveles	control;
	private MediadorMenu		mediadorMenu;
	private Timer				timerAnuncio;


	
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
		setBounds( 0, 0, GAME_WIDTH, GAME_HEIGHT );
		setLocationRelativeTo( null );
		setResizable( false );

		crearPanel( );
		crearLabel( );
		
		inicializarObjetos( );
		
		//startGame( );
	}
	
	
	
	private void inicializarObjetos( )
	{
		teclado = new Teclado( );
		
		mediadorMenu = new MediadorMenu( this );
		
		mediadorMenu.menuPrincipal().show( true );
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
		
		resetPanel();
		mediadorMenu = new MediadorMenu( this ); // SOLUCION TEMPORAL, NO SE DEBERIAN BORRAR LOS OBJETOS GRAFICOS YA CREADOS.

		mediadorMenu.menuPrincipal().show( true );
	}


	
	private void crearPanel( )
	{
		panel = new JPanel();
		panel.setLayout( null );
		setContentPane( panel );
	}
	
	public void resetPanel( )
	{
		panel.removeAll();
		
		labelPuntaje.setText("");
		labelMensaje.setText("");
		
		panel.add(labelPuntaje);
		panel.add(labelMensaje);
	}


	
	private void crearLabel( )
	{
		labelPuntaje = new JLabel( );
		labelPuntaje.setBounds(5, 5, GAME_WIDTH, 30);
		labelPuntaje.setFont( new Font("Consolas", Font.BOLD, 12) );
		labelPuntaje.setForeground( new Color(255, 255, 255) );
		labelPuntaje.setVisible(true);
		
		panel.add(labelPuntaje);
		
		
		
		labelMensaje = new JLabel( );
		labelMensaje.setBounds(5, 30, GAME_WIDTH, 300);
		labelMensaje.setHorizontalAlignment( SwingConstants.CENTER );
		labelMensaje.setVerticalAlignment( SwingConstants.TOP );
		labelMensaje.setFont( new Font("Consolas", Font.BOLD, 16) );
		labelMensaje.setForeground( new Color(255, 255, 255) );
		labelMensaje.setVisible(true);
		
		panel.add(labelMensaje);
	}


	
	public JPanel getPanel( )
	{
		return panel;
	}


	
	public void updateScoreLabel( String texto )
	{
		labelPuntaje.setText( texto );
	}

	public void mostrarAnuncio( String texto, int duracionMS )
	{
		final boolean USAR_MAYUSCULAS = true;
		
		
		
		if (USAR_MAYUSCULAS)
			texto = texto.toUpperCase();
		
		labelMensaje.setText( texto );

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
			labelMensaje.setText("");
		}
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