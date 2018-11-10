package Tienda;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Logica.Juego;

public abstract class Tienda {
	protected JPanel tienda;
	protected JPanel contenedorItems;
	protected JPanel canvas;
	protected Item ultimoItemSeleccionado;
	protected JLabel precioItem;
	
	protected final int ANCHO_ITEM = 40;
	protected final int LARGO_ITEM = 40;
	protected final int DISTANCIA_ENTRE_ITEMS_X = 20;
	protected final int DISTANCIA_ENTRE_ITEMS_Y = 20;
	
	protected Item[][] itemsEnTienda;
	
	public JPanel getPanel() {
		return tienda;
	}
	
	public abstract Item getCompra();
	
	public void show(boolean toggle) {
		contenedorItems.setVisible(toggle);
		tienda.setVisible(toggle);
	}
	
	public void eliminarPaneles() {
		contenedorItems.removeAll();
		tienda.removeAll();
		
		canvas.repaint();
	}
	
	protected void inicializar(int c, int f) {
		crearTienda();
		crearContenedorItems(c, f);
		crearItemsEnTienda();
		iniciarLabel();
	}
	
	private void crearTienda() {
		tienda = new JPanel();
		tienda.setLayout(null);
		tienda.setBounds(30, 30, Juego.GAME_WIDTH-80, Juego.GAME_HEIGHT-200);
		tienda.setBorder(new LineBorder(Color.WHITE, 3));
		tienda.setBackground(Color.WHITE);
		tienda.setVisible(true);
		
		canvas.add(tienda);
	}
	
	private void crearContenedorItems(int colum, int fila) {
		//calculamos el ancho y el largo del contenedor en base a la cantidad de columnas y filas.
		int anchoContenedor = colum*ANCHO_ITEM + (colum+1)*DISTANCIA_ENTRE_ITEMS_X;
		int largoContenedor = fila*LARGO_ITEM + (fila+1)*DISTANCIA_ENTRE_ITEMS_Y;
		
		//si el ancho y el largo del contenedor supera el límite lo redimensionamos.

		if(anchoContenedor > tienda.getSize().getWidth()-100) 
			anchoContenedor = (int)tienda.getSize().getWidth()-100;
		
		if(largoContenedor > tienda.getSize().getHeight()-250) 
			largoContenedor = (int)tienda.getSize().getHeight()-250;
		
		
		//obtenemos la cantidad de columnas y filas válidas, en caso que se haya pasado el límite se obtiene el máximo posible.
		
		int cantColumnas = (anchoContenedor - DISTANCIA_ENTRE_ITEMS_X)/(ANCHO_ITEM + DISTANCIA_ENTRE_ITEMS_X) ;
		int cantFilas = (largoContenedor - DISTANCIA_ENTRE_ITEMS_Y)/(LARGO_ITEM+DISTANCIA_ENTRE_ITEMS_Y);
		
		itemsEnTienda = new Item[cantColumnas][cantFilas];
	
		contenedorItems = new JPanel();
		contenedorItems.setLayout(null);//(new GridLayout(colum, fila));
		contenedorItems.setBounds(50, 50, (int)tienda.getSize().getWidth()-100, (int)tienda.getSize().getHeight()-200);
		contenedorItems.setBorder(new LineBorder(Color.BLACK, 2));
		contenedorItems.setBackground(Color.GRAY);
		contenedorItems.setVisible(true);
		
		tienda.add(contenedorItems);
		
	}
		
	private void crearItemsEnTienda() {
		JButton botonItem;
		Item nuevoItem;
		for(int i = 0; i < itemsEnTienda.length; i++) {
			for(int j = 0; j < itemsEnTienda[i].length; j++) {
				nuevoItem = new Item();
				itemsEnTienda[i][j] = nuevoItem;
				botonItem = crearPanelItem(i+1, j+1, nuevoItem);
				nuevoItem.colocarContenedor(botonItem);
				
			}
		}
	}
	
	private JButton crearPanelItem(int x, int y, Item item) {
		JButton botonItem = new JButton();
		botonItem.setBounds((x-1)*ANCHO_ITEM + x*DISTANCIA_ENTRE_ITEMS_X, (y-1)*LARGO_ITEM + y*DISTANCIA_ENTRE_ITEMS_Y, ANCHO_ITEM, LARGO_ITEM);
		botonItem.setBorder(new LineBorder(Color.BLACK, 2, true));
		botonItem.addActionListener(new OyenteBotones(item));
		botonItem.setVisible(true);
		contenedorItems.add(botonItem);
		
		return botonItem;
	}
	
	private void iniciarLabel() {
		precioItem = new JLabel("Precio: ");
		precioItem.setOpaque(false);
		precioItem.setFont(new Font("Ubuntu", Font.BOLD, 13));
		precioItem.setForeground(Color.WHITE);
		precioItem.setVerticalAlignment(SwingConstants.TOP);
		precioItem.setBounds(contenedorItems.getX(), contenedorItems.getY()+contenedorItems.getHeight()+10, contenedorItems.getWidth(), 25);
		
		tienda.add(precioItem);
	}
	
	
	private class OyenteBotones implements ActionListener {
		
		private Item miItem;
		
		public OyenteBotones(Item miItem) {
			this.miItem = miItem;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			miItem.getContenedor().setBorder(new LineBorder(Color.YELLOW, 3, true));
			if(ultimoItemSeleccionado != null) {
				ultimoItemSeleccionado.getContenedor().setBorder(new LineBorder(Color.BLACK, 2, true));
			}
			
			precioItem.setText("Precio de '" + miItem.getNombre() + "': " + miItem.getPrecio() + " puntos");
			ultimoItemSeleccionado = miItem;
		}
		
	}
}
