package Tienda;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Logica.Juego;
import Mapa.Mapa;
import PowerUp.PowerUp;
import Utils.Posicion;

public class Item {
	private PowerUp contenido;
	private int precio;
	private JButton contenedor;
	private String nombreProducto;
	
	public Item() {
		precio = 0;
		contenido = null;
		nombreProducto = null;
	}
	
	public String getNombre() {
		if(nombreProducto != null)
			return nombreProducto;
		
		return "None";
	}
	
	public void colocarContenedor(JButton contenedor) {
		this.contenedor = contenedor;
	}
	
	public void darContenido(Mapa mapa) {
		if(contenido != null) {
			contenido.setMapa(mapa);
			contenido.caer(new Posicion(Juego.GAME_WIDTH/2, - contenido.getSize().getHeight()-10));
		}
	}
	
	public void setPrecio(int p) {
		precio = p;
	}
	
	public void ponerEnVenta(PowerUp powerup, int precio, String nombre) {
		contenido = powerup;
		this.precio = precio;
		this.nombreProducto = nombre;
		Image img = powerup.getSprite().getImage();
		contenedor.setIcon(new ImageIcon(img));
	}
	
	
	public JButton getContenedor() {
		return contenedor;
	}
	
	public int getPrecio() {
		return precio;
	}
}
