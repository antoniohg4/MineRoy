package bloque.material;

import bloque.Bloque;
import bloque.categoria.BloqueTierra;
import juego.Jugador;

public class BloqueArcilla extends Bloque implements BloqueTierra {

	public BloqueArcilla(int x, int y, int z){
		super(x, y, z);
	}
	
	public void destruir(String herramienta, Jugador jugador) {
		if (herramienta.equals(BloqueTierra.HERRAMIENTA)) {
			jugador.sumaMateria(ARCILLA);
		}
		super.cambiarCoords();
	}
	
	public int getTipo() {
		return Bloque.ARCILLA;
	}

	
	@Override
	public String toString() {
		return "Arc";
	}
}
