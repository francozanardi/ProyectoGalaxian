package Menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Controladores.ContNivelesGenerico;
import Controladores.ControladorNiveles;
import Logica.Juego;
import Tienda.Item;
import Tienda.Tienda;
import Tienda.TiendaDefault;



public class MenuNextLevel extends Menu
{
	private MenuButton	botonContinuar,
						botonTienda,
						botonExit;
	private ControladorNiveles	controlador;
	private Juego juego;
	private Item compra;
	
	
	
	public MenuNextLevel(Juego juego, MediadorMenu m) {
		this.canvas	= juego.getPanel();
		this.controlador = juego.getControladorNiveles();
		this.juego = juego;
		this.mediador = m;
		
		crearBotones();
	}
	
	protected void eliminar() {
		show(false);
		canvas.remove(botonContinuar);
		canvas.remove(botonTienda);
		canvas.remove(botonExit);
		canvas.repaint();
	}
	
	
	public void show(boolean toggle) {
		if (toggle)
			canvas.setBackground(Color.black);
		
		botonContinuar.setVisible(toggle);
		botonTienda.setVisible(toggle);
		botonExit.setVisible(toggle);
	}

	public void setCompra(Item item) {
		this.compra = item;
	}
	
	public Item getCompra() {
		return compra;
	}
		
	private void crearBotones() {
		int yBoton = Juego.GAME_HEIGHT - (DIST_BOTONES + BOTON_HEIGHT) - 130,
			xCentrado = (Juego.GAME_WIDTH / 2) - (BOTON_WIDTH / 2);

		botonExit = crearBoton( "Salir", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, new OyenteBotonExit() );
		
		yBoton -= (DIST_BOTONES + BOTON_HEIGHT);
		botonTienda = crearBoton( "Tienda", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, new OyenteBotonTienda() );
		
		yBoton -= (DIST_BOTONES + BOTON_HEIGHT);
		botonContinuar = crearBoton( "Continuar", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, new OyenteBotonContinuar() );
	}
	
	
	
	private class OyenteBotonTienda implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			MenuTienda menu = mediador.menuTienda();
			if(compra != null) {
				menu.deshabilitarCompra();
			}
			mediador.avanzarMenu(menu);
		}
	}
	
	private class OyenteBotonContinuar implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mediador.eliminarPilaMenues();
			controlador.siguienteNivel(compra);
		}
	}
	
	private class OyenteBotonExit implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			juego.dispose();
		}
	}
}
