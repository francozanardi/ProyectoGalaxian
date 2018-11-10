package Menu;

import java.util.Stack;
import Jugador.Jugador;
import Logica.Juego;



public class MediadorMenu
{
	protected Juego juego;
	protected Jugador jugador;
	protected Stack<Menu> pilaDeMenues;
	
	public MediadorMenu( Juego juego, Jugador jugador)
	{
		this.juego = juego;		
		this.jugador = jugador;
		this.pilaDeMenues = new Stack<Menu>();
	}
	
	
	public void eliminarPilaMenues() {
		for(Menu p: pilaDeMenues) {
			p.eliminar();
		}
		
		pilaDeMenues.clear();
	}
	/*
	 * Si no hay menues en la pila, simplemente lo agrega y lo muestra. Si ya ha menues en la pila, oculta el último menú y muestra éste.
	 */
	public void avanzarMenu( Menu menu )
	{
		if(!pilaDeMenues.isEmpty()) {
			pilaDeMenues.lastElement().show(false);
		}
			
		pilaDeMenues.push(menu);
		menu.show(true);
	}
	
	public void retrocederMenu() {
		Menu menuAnterior = null;
		Menu menuActual = pilaDeMenues.pop(); //saco el menu actual de la pila

		if(!pilaDeMenues.isEmpty()) {
			menuAnterior = pilaDeMenues.lastElement();
			menuAnterior.show(true);
		}
		
		menuActual.eliminar();
	}
	
	public void iniciarNuevoMenu(Menu m) {
		eliminarPilaMenues();
		pilaDeMenues.push(m);
		m.show(true);
	}
	
	protected Menu getMenuAnterior() {
		return pilaDeMenues.get(pilaDeMenues.size()-2);
	}

	
	public MenuPrincipal menuPrincipal( )
	{
		return new MenuPrincipal(juego, this);
	}
	
	public MenuAbout menuAbout( )
	{
		return new MenuAbout(juego, this);
	}
	
	public MenuBestScores menuBestScores( )
	{
		return new MenuBestScores(juego, this);
	}
	
	public MenuPausa menuPausa()
	{
		return new MenuPausa(juego, this);
	}
	
	public MenuGameOver menuGameOver()
	{
		return new MenuGameOver(juego, this, jugador);
	}
	
	public MenuNextLevel menuNextLevel() {
		return new MenuNextLevel(juego, this);
	}
	
	public MenuTienda menuTienda() {
		return new MenuTienda(juego, this, jugador);
	}
}
