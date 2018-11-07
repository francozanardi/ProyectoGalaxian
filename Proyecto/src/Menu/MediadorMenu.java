package Menu;

import javax.swing.JPanel;

import Logica.Juego;



public class MediadorMenu
{
	private Menu	menuPrincipal,
					menuAbout,
					menuBestScores;
	
	
	
	public MediadorMenu( Juego juego )
	{
		JPanel canvas = juego.getPanel();
		
		
		
		menuPrincipal = new MenuPrincipal( juego, canvas );
		menuPrincipal.setMediator( this );
		
		menuAbout = new MenuAbout( canvas );
		menuAbout.setMediator( this );
		
		menuBestScores = new MenuBestScores( canvas );
		menuBestScores.setMediator( this );
	}
	
	
	
	public Menu menuPrincipal( )
	{
		return menuPrincipal;
	}
	
	public Menu menuAbout( )
	{
		return menuAbout;
	}
	
	public Menu menuBestScores( )
	{
		return menuBestScores;
	}
}
