package Menu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;



@SuppressWarnings("serial")
public class MenuButton extends JButton
{
	private final Font 	BOTON_FONT	= new Font("Ubuntu", Font.BOLD, 16);
	private final Color	COLOR_BG	= new Color(50, 50, 50),
						COLOR_FONT	= Color.white;
	
	
	
	public MenuButton( String texto )
	{
		super( texto );
		
		setText( texto );
		setFont( BOTON_FONT );
		setBackground( COLOR_BG );
		setForeground( COLOR_FONT );
		setVerticalAlignment( SwingConstants.CENTER );
		setHorizontalAlignment( SwingConstants.CENTER );
		setVisible( false );
	}
}
