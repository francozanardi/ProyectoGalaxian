
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;




public class Juego extends JFrame
{
	public static final int	GAME_WIDTH	= 400,
							GAME_HEIGHT	= 600,
							GAME_FPS	= 100;
	
	private JPanel contentPane;
	
	private Juego j;
	private MainThread tiempo;

	/**
	 * Launch the application.
	 */
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


	public Juego()
	{
		addKeyListener(
			new KeyAdapter()
			{
				public void keyReleased(KeyEvent arg0)
				{
					mover(arg0);
				}
			}
		);
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, GAME_WIDTH, GAME_HEIGHT);
		setLocationRelativeTo( null );
		setResizable( false );

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Mapa mapa = new Mapa( this );
		tiempo = new MainThread(mapa, GAME_FPS);
		tiempo.start();
	}
	
	public JPanel obtenerPanel( )
	{
		return contentPane;
	}
	
	protected void mover(KeyEvent key){
				
		this.repaint();
	}
}
