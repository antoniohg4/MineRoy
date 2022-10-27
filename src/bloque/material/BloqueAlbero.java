package bloque.material;

import bloque.Bloque;
import bloque.categoria.BloqueTierra;
import juego.Jugador;

public class BloqueAlbero extends Bloque implements BloqueTierra {

	public BloqueAlbero(int x, int y, int z){
		super(x, y, z);
	}
	
	public void destruir(String herramienta, Jugador jugador) {
		if (herramienta.equals(BloqueTierra.HERRAMIENTA)) {
			jugador.sumaMateria(ALBERO);
		}
		super.cambiarCoords();
		
	}
	
	@Override
	public String toString() {
		return "Alb";
	}

	public int getTipo() {
		return Bloque.ALBERO;
	}


}
