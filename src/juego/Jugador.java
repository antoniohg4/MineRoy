package juego;

import bloque.Bloque;

/**
 * Clase que representa el jugador del MineMonroy
 * @author y0rg
 *
 */
public class Jugador {
	
	private static final int USOS_HERRAMIENTAS_POR_DEFECTO = 5;

	//Nombre del jugador
	String nombre;

	//Lista de materias primas del jugador
	int[] materiasPrimas = new int[Bloque.NUM_MATERIAS];
	
	//Coordendas
	int x;
	int y;
	int z;
	
	//Usos herramientas
	int usosHacha;
	int usosPico;
	int usosPala;

	public Jugador(String nombre, int x, int y, int z) {
		this.nombre = nombre;
		this.x = x;
		this.y = y;
		this.z = z;
		this.usosHacha = USOS_HERRAMIENTAS_POR_DEFECTO;
		this.usosPico = USOS_HERRAMIENTAS_POR_DEFECTO;
		this.usosPala = USOS_HERRAMIENTAS_POR_DEFECTO;
	}

	

	/**
	 * No hace falta explicarlo... o si?
	 */
	public String toString() {
		return this.nombre +
				coords() +
				"\nMaterias primas recolectadas: " +
				"\nPlantas: " + materiasPrimas[Bloque.PLANTA] + 
				"\nArboles: " + materiasPrimas[Bloque.ARBOL] +
				"\nArcilla: " + materiasPrimas[Bloque.ARCILLA] +
				"\nAlbero: "+ materiasPrimas[Bloque.ALBERO] +
				"\nHierro: " + materiasPrimas[Bloque.HIERRO] +
				"\nCobre: " + materiasPrimas[Bloque.COBRE];
	}
	
	public String coords() {
		return  "\nCoords: " + x + ", " + y + ", " + z;
	}

	
	/**
	 * Metodo que añade una unidad de una materia "tipo"
	 * @param tipo, entero que representa el tipo de Materia.
	 * @see bloque.Bloque.java
	 */
	public void sumaMateria(int tipo) {
		switch (tipo) {
		case Bloque.ALBERO: {
			materiasPrimas[Bloque.ALBERO]++;	
			break;
		}
		case Bloque.ARBOL: {
			materiasPrimas[Bloque.ARBOL]++;	
			break;
		}
		case Bloque.ARCILLA: {
			materiasPrimas[Bloque.ARCILLA]++;
			break;
		}
		case Bloque.COBRE: {
			materiasPrimas[Bloque.COBRE]++;
			break;
		}
		case Bloque.HIERRO: {
			materiasPrimas[Bloque.HIERRO]++;
			break;
		}
		case Bloque.PLANTA: {
			materiasPrimas[Bloque.PLANTA]++;	
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipo);
		}
		
	}
	
	
	/**
	 * Metodo que quita una unidad de una materia "tipo"
	 * @param tipo, entero que representa el tipo de Materia.
	 * @see bloque.Bloque.java
	 */
	public void restaMateria(int tipo) {
		switch (tipo) {
		case Bloque.ALBERO: {
			materiasPrimas[Bloque.ALBERO]--;	
			break;
		}
		case Bloque.ARBOL: {
			materiasPrimas[Bloque.ARBOL]--;	
			break;
		}
		case Bloque.ARCILLA: {
			materiasPrimas[Bloque.ARCILLA]--;
			break;
		}
		case Bloque.COBRE: {
			materiasPrimas[Bloque.COBRE]--;
			break;
		}
		case Bloque.HIERRO: {
			materiasPrimas[Bloque.HIERRO]--;
			break;
		}
		case Bloque.PLANTA: {
			materiasPrimas[Bloque.PLANTA]--;	
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipo);
		}
		
	}

	//Getters Y Setters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public int getUsosHacha() {
		return usosHacha;
	}

	public void setUsosHacha(int usosHacha) {
		this.usosHacha = usosHacha;
	}

	public int getUsosPico() {
		return usosPico;
	}

	public void setUsosPico(int usosPico) {
		this.usosPico = usosPico;
	}

	public int getUsosPala() {
		return usosPala;
	}

	public void setUsosPala(int usosPala) {
		this.usosPala = usosPala;
	}

	public String getNombre() {
		return nombre;
	}

}
