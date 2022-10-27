package bloque;

import juego.*;

public abstract class Bloque {

	//Tipos de bloques posibles.
	//public static final int VACIO = -1;
	public static final int PLANTA = 0;
	public static final int ARBOL = 1;
	public static final int ARCILLA = 2;
	public static final int ALBERO = 3;
	public static final int HIERRO = 4;
	public static final int COBRE = 5;
	
	public static final int NUM_MATERIAS = 6; //Pues contamos desde 0.
	
	//Atributos
	private int x;
	private int y;
	private int z;
	
	public Bloque (int x, int y, int z){
		setX(x);
		setY(y);
		setZ(z);
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getZ() {
		return z;
	}


	public void setX (int x){
		this.x = x;
	}
	public void setY (int y){
		this.y = y;
	}
	public void setZ (int z){
		this.z = z;
	}
	
	public void cambiarCoords () {
		this.x = -1;
		this.y = -1;
		this.z = -1;
	}

	/**
	 * Metodo para destruir el bloque, abstracto porque la clase es abstracta
	 * @param herramienta
	 * @param jugador1
	 */
	public abstract void destruir(String herramienta, Jugador jugador1);
	
	/**
	 * Metodo para saber el tipo del bloque, abstracto porque la clase es abstracta
	 * @param herramienta
	 * @param jugador1
	 */
	public abstract int getTipo();

	@Override
	public String toString() {
		return "Bloque [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	
}
