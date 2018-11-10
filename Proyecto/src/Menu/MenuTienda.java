	package Menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Controladores.ContNivelesGenerico;
import Jugador.Jugador;
import Logica.Juego;
import Tienda.Item;
import Tienda.Tienda;
import Tienda.TiendaDefault;



public class MenuTienda extends Menu
{
	private MenuButton	botonVolver,
						botonComprar;
	private Juego juego;
	private Tienda tienda;
	private Item compra;
	
	
	
	public MenuTienda(Juego juego, MediadorMenu m, Jugador jugador) {
		this.juego = juego;
		this.mediador = m;
		this.compra = null;
		
		tienda = new TiendaDefault(juego.getPanel(), jugador);
		canvas = tienda.getPanel();
		crearBotones();
	}
	
	protected void eliminar() {
		show(false);
		canvas.remove(botonComprar);
		canvas.remove(botonVolver);
		tienda.eliminarPaneles();
		juego.repaint();
	}
	
	public void show(boolean toggle) {
		if (toggle)
			canvas.setBackground(Color.black);
		
		botonVolver.setVisible(toggle);
		botonComprar.setVisible(toggle);
		tienda.show(toggle);
	}


		
	private void crearBotones() {
		int yBoton = canvas.getHeight()-60;
		int xCentrado = (canvas.getWidth() / 2) - (BOTON_WIDTH / 2);

		botonVolver = crearBoton( "Volver", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, new OyenteBotonVolver() );
		
		yBoton -= (DIST_BOTONES + BOTON_HEIGHT);
		botonComprar = crearBoton( "Comprar", xCentrado, yBoton, BOTON_WIDTH, BOTON_HEIGHT, new OyenteBotonComprar() );
	}
	
	public void deshabilitarCompra() {
		botonComprar.setEnabled(false);
	}
	

	
	private class OyenteBotonVolver implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(compra != null) {
				((MenuNextLevel)mediador.getMenuAnterior()).setCompra(compra);
			}
		
			mediador.retrocederMenu();
		}
	}
	
	private class OyenteBotonComprar implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			compra = tienda.getCompra();
			if(compra != null) {
				botonComprar.setEnabled(false);
			}
				
		}
	}
}
