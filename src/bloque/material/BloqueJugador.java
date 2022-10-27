package bloque.material;

import bloque.Bloque;
import juego.Jugador;

public class BloqueJugador extends Bloque{

	public BloqueJugador(Jugador jugador){
		super(jugador.getX(), jugador.getY(), jugador.getZ());
	}
	
	public void destruir(String herramienta, Jugador jugador) {
		
	}
	
	@Override
	public String toString() {
		return "Jug";
	}

	@Override
	public int getTipo() {
		
		return 0;
	}

}
