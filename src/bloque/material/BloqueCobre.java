package bloque.material;

import bloque.Bloque;
import bloque.categoria.BloqueMineral;
import juego.Jugador;

public class BloqueCobre extends Bloque implements BloqueMineral {

	public BloqueCobre(int x, int y, int z){
		super(x, y, z);
	}
	
	public void destruir(String herramienta, Jugador jugador) {
		if (herramienta.equals(BloqueMineral.HERRAMIENTA)) {
			jugador.sumaMateria(COBRE);
		}
		super.cambiarCoords();
	}

	public int getTipo() {
		return Bloque.COBRE;
	}

	@Override
	public String toString() {
		return "Cob";
	}
}
