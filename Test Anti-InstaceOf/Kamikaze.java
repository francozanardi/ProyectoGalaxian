
public class Kamikaze implements Enemigo
{
	private final String miNombre = "Kamikaze";
	
	public Kamikaze( )
	{
	}
	
	public void morir()
	{
		System.out.println(miNombre + " ha muerto.");	
	}

	public void morir_porJugador()
	{
		System.out.println(miNombre + ": 'me ha matado el Jugador'");
		
		morir();
	}

	public void morir_porGigante()
	{
		System.out.println(miNombre + ": 'me ha matado un gigante'");
		
		morir();
	}

	public void morir_porKamikaze()
	{
		System.out.println(miNombre + ": 'me ha matado un kamikaze'");
		
		morir();
	}


	public void atacar( Enemigo destino )
	{
		System.out.println(miNombre + " ataca.");
		
		destino.recibirDmg( this );
	}

	public void recibirDmg( Enemigo source )
	{
		System.out.println(miNombre + " recibe daño.");
		
		source.matar( this, "el Gigante" );
	}

	public void matar( Enemigo destino, String muerto )
	{
		System.out.println(miNombre + " asesinó a '" + muerto + "'.");
		
		destino.morir_porKamikaze();
	}
}
