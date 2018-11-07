package Sprite;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class SpriteEditor
{
	private static SpriteEditor instancia;
	
	
	
	private SpriteEditor( )
	{
	}
	
	
	
	public static SpriteEditor create( )
	{
		if (instancia == null)
			instancia = new SpriteEditor();
		
		return instancia;
	}
	
	
	
	public void toBlackAndWhite( Sprite spr )
	{
		BufferedImage b = imageToBufferedImage( spr.getImage() );
		
		int w = b.getWidth(),
			h = b.getHeight(),
			x,
			y;
		int[] pixel;
		int grey;
		
		for (x = 0; x < w; x ++)
		{
			for (y = 0; y < h; y ++)
			{
				pixel = getRGBA( b.getRGB(x, y) );
				
				grey = (pixel[0] + pixel[1] + pixel[2]) / 3;
				
				b.setRGB(x, y, setRGBA(grey, grey, grey, pixel[3]));
			}
		}
		
		spr.setImage( b );
	}
	
	
	
	public void negative( Sprite spr )
	{
		BufferedImage b = imageToBufferedImage( spr.getImage() );
		
		int w = b.getWidth(),
			h = b.getHeight(),
			x,
			y;
		int[] pixel;
		
		for (x = 0; x < w; x ++)
		{
			for (y = 0; y < h; y ++)
			{
				pixel = getRGBA( b.getRGB(x, y) );
								
				b.setRGB(x, y, setRGBA(255 - pixel[0], 255 - pixel[1], 255 - pixel[2], pixel[3]));
			}
		}
		
		spr.setImage( b );
	}
	
	
	
	/*
	public void resize( Sprite spr, double escale )
	{
		Image img = spr.getImage();
		int newWidth	= (int) (img.getWidth(null) * escale),
			newHeight	= (int) (img.getHeight(null) * escale);
		
	    spr.setImage( img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH) );
	}
	*/
	
	
	
	private int[] getRGBA( int rgba )
	{
		return new int[]{ (rgba >> 16) & 0xFF, (rgba >> 8) & 0xFF, rgba & 0xFF, (rgba << 24) & 0xFF };
	}
	
	private int setRGBA( int r, int g, int b, int alpha )
	{
		return ((alpha & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 6) | (b & 0xFF);
	}
	
	
	
	
	private BufferedImage imageToBufferedImage( Image img )
	{   
		BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		bufferedImage.getGraphics().drawImage(img, 0, 0, null);
		
		return bufferedImage;
	}
}
