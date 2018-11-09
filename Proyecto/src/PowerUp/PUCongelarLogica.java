package PowerUp;

import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;

import Arma.ArmaCongelada;
import Entidad.EntidadConVida;
import Inteligencia.IACongelado;



public class PUCongelarLogica {
	private static PUCongelarLogica instanciaUnica = null;
	private Hashtable<EntidadConVida, IACongelado> entidadesCongeladas;
	private final int	DURACION_CONGELADO_EN_SEG = 10;
	
	
	private PUCongelarLogica() {
		this.entidadesCongeladas = new Hashtable<EntidadConVida, IACongelado>();
	}
	
	public static PUCongelarLogica create() {
		if(instanciaUnica == null) {
			instanciaUnica = new PUCongelarLogica();
		}
	
		return instanciaUnica;
	}
	
	public void congelarEntidad(EntidadConVida ent) {
		IACongelado iaCongelada;
		ArmaCongelada armaNueva;
		iaCongelada = entidadesCongeladas.get(ent);
		if(iaCongelada == null) {
			armaNueva = new ArmaCongelada(ent.getArma());
			iaCongelada = new IACongelado(ent.getIA(), armaNueva);
			ent.setIA(iaCongelada);
			ent.setArma(armaNueva);
			entidadesCongeladas.put(ent, iaCongelada);
		} else {
			iaCongelada.getTimer().cancel();
		}
		
		Timer timer = new Timer(); 
	    timer.schedule(new TimerDescongelar(ent), DURACION_CONGELADO_EN_SEG * 1000L);
	    iaCongelada.setTimer(timer);

	}
	
	public void descongelarEntidad(EntidadConVida ent) {
		IACongelado iaCongelado = entidadesCongeladas.get(ent);
		if(iaCongelado == ent.getIA() && iaCongelado.getArmaNueva() == ent.getArma()){ //comparamos sino cambio de ia y arma.
			ent.setArma(iaCongelado.getArmaNueva().getArmaAntigua()); //restablecemos el arma original
			ent.setIA(iaCongelado.getInteligenciaAntigua()); //restablecemos la ia original
		}
		
		entidadesCongeladas.remove(ent);
		
	}
	
	private class TimerDescongelar extends TimerTask
	{
		private EntidadConVida entidad;
		
		public TimerDescongelar(EntidadConVida ent) {
			this.entidad = ent;
		}
		public void run()
		{
			descongelarEntidad(entidad);
		}
	}

}
