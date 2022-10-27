package bloque.material;

import bloque.Bloque;
import bloque.categoria.BloqueMineral;
import juego.Jugador;

public class BloqueHierro extends Bloque implements BloqueMineral {

	public BloqueHierro(int x, int y, int z){
		super(x, y, z);
	}
	
	/**
	 * Metodo que destruye el bloque, da las materias al jugador si se rompe con la herramienta adecuada
	 * y cambia las coordenadas a -1,-1,-1
	 */
	public void destruir(String herramienta, Jugador jugador) {
		if (herramienta.equals(BloqueMineral.HERRAMIENTA)) {
			jugador.sumaMateria(HIERRO);
		}
		super.cambiarCoords();
	}
	
	public int getTipo() {
		return Bloque.HIERRO;
	}


	@Override
	public String toString() {
		return "Hie";
	}
}
