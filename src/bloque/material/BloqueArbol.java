package bloque.material;

import bloque.Bloque;
import bloque.categoria.BloqueVegetal;
import juego.Jugador;

public class BloqueArbol extends Bloque implements BloqueVegetal {

	public BloqueArbol(int x, int y, int z){
		super(x, y, z);
	}
	
	/**
	 * Metodo que destruye el bloque, da las materias al jugador si se rompe con la herramienta adecuada
	 * y cambia las coordenadas a -1,-1,-1
	 */
	public void destruir(String herramienta, Jugador jugador) {
		if (herramienta.equals(BloqueVegetal.HERRAMIENTA)) {
			jugador.sumaMateria(ARBOL);
		}
		super.cambiarCoords();
		
	}
	
	public int getTipo() {
		return Bloque.ARBOL;
	}

	@Override
	public String toString() {
		return "Arb";
	}
	
	

}
