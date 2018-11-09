package Tienda;

import Jugador.Jugador;
import Logica.Juego;
import PowerUp.PUArmaTriple;
import PowerUp.PUCongelar;
import PowerUp.PUEscudoExplosion;
import PowerUp.PUHeal;
import PowerUp.PUMinigun;
import PowerUp.PUMultiplicador;
import PowerUp.PUVelocidadMovimiento;

public class TiendaDefault extends Tienda {
	private Jugador jugador;
	
	private int colum;
	private int fila;
	
	public TiendaDefault(Juego juego, Jugador jugador) {
		this.juego = juego;
		this.jugador = jugador;
		this.colum = 0;
		this.fila = 0;
		
		inicializar(5, 3);
		
		show(false);
		colocarItems();
		juego.getPanel().repaint();
	}
	
	private void colocarItems() {
		getSiguienteItem().ponerEnVenta(new PUArmaTriple(null), (int)(jugador.getPuntaje()*0.20), "Arma Triple");
		getSiguienteItem().ponerEnVenta(new PUCongelar(null), (int)(jugador.getPuntaje()*0.25), "Congelar");
		getSiguienteItem().ponerEnVenta(new PUEscudoExplosion(null), (int)(jugador.getPuntaje()*0.20), "Escudo anti-explosión");
		getSiguienteItem().ponerEnVenta(new PUHeal(null), (int)(jugador.getPuntaje()*0.18), "Heal");
		getSiguienteItem().ponerEnVenta(new PUMinigun(null), (int)(jugador.getPuntaje()*0.16), "Minigun");
		getSiguienteItem().ponerEnVenta(new PUMultiplicador(null), (int)(jugador.getPuntaje()*0.20), "Multiplicador");
		getSiguienteItem().ponerEnVenta(new PUVelocidadMovimiento(null), (int)(jugador.getPuntaje()*0.15), "Velocidad");
		
		while(colum != itemsEnTienda.length-1 || fila != itemsEnTienda[0].length-1) {
			getSiguienteItem().getContenedor().setEnabled(false);
		}
		getSiguienteItem().getContenedor().setEnabled(false);
	}
	
	private Item getSiguienteItem() {
		Item aRetornar = itemsEnTienda[colum][fila];

		if(colum+1 < itemsEnTienda.length) {
			colum++;
		} else {
			colum = 0;
			if(fila+1 < itemsEnTienda[0].length) {
				fila++;
			} else {
				fila = 0;
			}
		}
		
		return aRetornar;
	}

	@Override
	public Item getCompra() {
		if(ultimoItemSeleccionado != null) {
			if(jugador.getPuntaje() >= ultimoItemSeleccionado.getPrecio()) {
				jugador.givePuntaje(-ultimoItemSeleccionado.getPrecio());
				ultimoItemSeleccionado.getContenedor().setEnabled(false);
				return ultimoItemSeleccionado;
			}
		}
		
		return null;
	}
	
	

}
