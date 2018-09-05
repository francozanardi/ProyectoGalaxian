import javax.swing.JPanel;

abstract class Entidad
{
	protected float vida;
	protected JPanel panel;
	protected int[] pos;
	protected int[] tamano;
	protected Mapa mapa;
	
	public JPanel obtenerPanel( )
	{
		return panel;
	}
	
	abstract void mover( );
}
