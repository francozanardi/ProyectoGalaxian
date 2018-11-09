package Menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Logica.Juego;



public class MenuPrincipal extends Menu
{
	private MenuButton	botonNewGame,
						botonMaxScore,
						botonAbout,
						botonExit;
	private Juego		juego;
	
	
	
	public MenuPrincipal(Juego juego, MediadorMenu m)
	{
		this.juego	= juego;
		this.canvas	= juego.getPanel();
		this.mediador = m;
		
		crearBotones();
	}
	
	protected void eliminar() {
		show(false);
		canvas.remove(botonAbout);
		canvas.remove(botonNewGame);
		canvas.remove(botonMaxScore);
		canvas.remove(botonExit);
		canvas.repaint();
	}
	
	public void show( boolean toggle )
	{
		if (toggle)
			canvas.setBackground( Color.black );
		
		
		botonNewGame.setVisible( toggle );
		botonMaxScore.setVisible( toggle );
		botonAbout.setVisible( toggle );
		botonExit.setVisible( toggle );
	}


		
	private void crearBotones( )
	{
		int yBoton = Juego.GAME_HEIGHT - (DIST_BOTONES + BOTON_HEIGHT) - 80,
			xCentrado = (Juego.GAME_WIDTH / 2) - (BOTON_WIDTH / 2);

		botonExit = crearBoton( "Salir", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, new OyenteBotonExit() );
		
		yBoton -= (DIST_BOTONES + BOTON_HEIGHT);
		botonAbout = crearBoton( "Acerca de", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, new OyenteBotonAbout() );
		
		yBoton -= (DIST_BOTONES + BOTON_HEIGHT);
		botonMaxScore = crearBoton( "Mejores Puntajes", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, new OyenteBotonBestScores() );
		
		yBoton -= (DIST_BOTONES + BOTON_HEIGHT);
		botonNewGame = crearBoton( "Nueva Partida", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, new OyenteBotonStartGame() );
	}
	
	
	
	private class OyenteBotonStartGame implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			mediador.eliminarPilaMenues();
			juego.startGame();
		}
	}
	
	private class OyenteBotonBestScores implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) {
			mediador.avanzarMenu(mediador.menuBestScores());
		}
	}
	
	private class OyenteBotonExit implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			juego.dispose();
		}
	}
	
	private class OyenteBotonAbout implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			mediador.avanzarMenu(mediador.menuAbout());
		}
	}
}
