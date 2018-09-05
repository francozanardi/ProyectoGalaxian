
public class Test
{
	public static void main(String[] args)
	{
		Enemigo[] e = new Enemigo[3];
		
		e[0] = new Jugador();
		e[1] = new Kamikaze();
		e[2] = new Gigante();
		
		e[0].atacar( e[1] );
	}
}
