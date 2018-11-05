package Logica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controladores.ContNivelesGenerico;
import Controladores.ControladorNiveles;
import Jugador.Jugador;

import javax.swing.JLabel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;



@SuppressWarnings("serial")
public class Juego extends JFrame
{	
	public static final int		GAME_WIDTH	= 450,
								GAME_HEIGHT	= (int) (GAME_WIDTH * 1.5),
								GAME_FPS	= 60;
	public static final String	GAME_TITLE = "Galaxian Trucho";


	
	private JPanel				panel;
	private JLabel				labelPuntaje;
	private Teclado				teclado;
	private ControladorNiveles	control;
	private MenuPrincipal		menu;


	
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
		
		menu = new MenuPrincipal( this );
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
		
		menu.gameFinished();
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
		panel.add(labelPuntaje);
	}


	
	private void crearLabel( )
	{
		labelPuntaje = new JLabel( );
		labelPuntaje.setBounds(5, 5, GAME_WIDTH, 30);
		labelPuntaje.setFont( new Font("Consolas", Font.BOLD, 12) );
		labelPuntaje.setForeground( new Color(255, 255, 255) );
		labelPuntaje.setVisible(true);
		
		panel.add(labelPuntaje);
	}


	
	public JPanel getPanel( )
	{
		return panel;
	}


	
	public void updateScoreLabel( String texto )
	{
		labelPuntaje.setText( texto );
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