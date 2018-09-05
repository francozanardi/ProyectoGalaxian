
public interface Enemigo
{	
	public void atacar( Enemigo destino );
	public void recibirDmg( Enemigo source );
	public void morir();
	public void matar( Enemigo destino, String muerto );
	
	public void morir_porJugador();
	public void morir_porGigante();
	public void morir_porKamikaze();
}
