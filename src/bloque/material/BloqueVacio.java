package bloque.material;

import bloque.Bloque;
import juego.Jugador;

public class BloqueVacio extends Bloque {

	public BloqueVacio(int x, int y, int z){
		super(x, y, z);
	}

	@Override
	public void destruir(String herramienta, Jugador jugador1) {
	}

	public int getTipo() {
		return -1;
	}

	@Override
	public String toString() {
		return "   ";
	}
}
