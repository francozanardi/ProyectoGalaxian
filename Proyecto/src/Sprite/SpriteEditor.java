package Sprite;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;



public class SpriteEditor
{
	private final int	CRED	= 0,
						CBLUE	= 1,
						CGREEN	= 2,
						CALPHA	= 3;
	
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
				
				grey = (pixel[CRED] + pixel[CBLUE] + pixel[CGREEN]) / 3;
				
				b.setRGB(x, y, setRGBA(grey, grey, grey, pixel[CALPHA]));
			}
		}
		
		spr.setImage( b );
	}
	
	
	
	public void tintura( Sprite spr, Color mascara )
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
				
				b.setRGB(x, y,
					setRGBA(
						(pixel[CRED]   + mascara.getRed())   / 2,
						(pixel[CBLUE]  + mascara.getBlue())  / 2,
						(pixel[CGREEN] + mascara.getGreen()) / 2,
						pixel[CALPHA]
					)
				);
			}
		}
		
		spr.setImage( b );
	}

	
	
	public void amplifyColor( Sprite spr, double redMult, double greenMult, double blueMult, double alphaMult )
	{
		BufferedImage b = imageToBufferedImage( spr.getImage() );
		
		int w = b.getWidth(),
			h = b.getHeight(),
			x,
			y,
			i;
		int[] pixel;
		
		for (x = 0; x < w; x ++)
		{
			for (y = 0; y < h; y ++)
			{
				pixel = getRGBA( b.getRGB(x, y) );

				pixel[CRED]   *= redMult;
				pixel[CBLUE]  *= blueMult;
				pixel[CGREEN] *= greenMult;
				pixel[CALPHA] *= alphaMult;
				
				for (i = 0; i < pixel.length; i ++)
					pixel[i] = fix(pixel[i]);
				
				b.setRGB(x, y,
					setRGBA(
						pixel[CRED],
						pixel[CBLUE],
						pixel[CGREEN],
						pixel[CALPHA]
					)
				);
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
								
				b.setRGB(x, y, setRGBA(255 - pixel[CRED], 255 - pixel[CBLUE], 255 - pixel[CGREEN], pixel[CALPHA]));
			}
		}
		
		spr.setImage( b );
	}
	
	
	
	private int[] getRGBA( int rgba )
	{
		return new int[]{ (rgba >> 16) & 0xFF, (rgba >> 8) & 0xFF, rgba & 0xFF, (rgba >> 24) & 0xFF };
	}
	
	private int setRGBA( int r, int g, int b, int alpha )
	{
		return ((alpha & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | (b & 0xFF);
	}
	
	private int fix( int color )
	{
		int res = color;
		
		if (color > 255)
			color = 255;
		else if (color < 0)
			color = 0;

		return res;
	}
	
	
	
	
	private BufferedImage imageToBufferedImage( Image img )
	{   
		BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		bufferedImage.getGraphics().drawImage(img, 0, 0, null);
		
		return bufferedImage;
	}
}
