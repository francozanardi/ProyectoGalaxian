package Sprite;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Sprite extends JPanel
{
	private Image sprite;
	
	
	
	public Sprite( String url )
	{
		super();

		initialize( new ImageIcon( getClass().getResource(url) ).getImage() );
	}
		
	public Sprite( Image sprite )
	{
		super();

		initialize( sprite );
	}
	
	
	
	private void initialize( Image sprite )
	{
		setOpaque( false );
		setLayout( null );
		
		setImage( sprite );
		
		repaint();
	}
	
	
	public void paintComponent( Graphics g )
	{
		g.drawImage( sprite, 0, 0, null );
		
		super.paintComponent( g );
	}
	
	
	
	public void setImage( Image image )
	{
		if (image == null)
		{
			BufferedImage img = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
			
			Graphics g = img.getGraphics();
			g.setColor( Color.pink );
			g.fillRect(0, 0, 50, 50);
			g.dispose();
			
			image = img;
		}
		
		this.sprite = image;
		
		setBounds( 0, 0, image.getWidth(null), image.getHeight(null) );
	}
	
	public Image getImage( )
	{
		return this.sprite;
	}
}
