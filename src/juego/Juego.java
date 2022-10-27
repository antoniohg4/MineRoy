package juego;

import java.util.Random;
import java.util.Scanner;

import bloque.*;
import bloque.material.*;
import bloque.categoria.*;

public class Juego {
	
	private static final int MATERIAS_NECESARIAS_PARA_GANAR = 7;

	public static Scanner kb = new Scanner(System.in);
	
	//Indica el tamano de cubos que contendra el mapa que vamos a crear
	public static final int TAMANO_MUNDO = 10;

	
	/**
	 * Metodo principal, ejecuta el juego
	 */
	public static void main(String[] args) {
		//Variables
		boolean encontrado = false;
		boolean haGanado = false;
		
		//Creamos el mapa del juego
		Bloque[][][] mundo3D = new Bloque[TAMANO_MUNDO][TAMANO_MUNDO][TAMANO_MUNDO];
		
		//Lo rellenamos de bloques aleatorios de cualquier tipo
		for (int z= 0; z <TAMANO_MUNDO; z++) {
			for (int y= 0; y <TAMANO_MUNDO; y++) {
				for (int x= 0; x <TAMANO_MUNDO; x++) {
					mundo3D[x][y][z] = generaBloqueAleatorio(x,y,z);
				}
			}
		}
		
		//Creamos el jugador en el primer BloqueVacio
		Jugador jugador1 = null;
		for (int z= 0; z <TAMANO_MUNDO && !encontrado; z++) {
			for (int y= 0; y <TAMANO_MUNDO && !encontrado; y++) {
				for (int x= 0; x <TAMANO_MUNDO && !encontrado; x++) {
					//Busca el primer bloque vacío que haya
					if (mundo3D[x][y][z] instanceof BloqueVacio) {
						jugador1 = new Jugador("Antonio", x, y, z);
						encontrado = true;
					}
				}
			}
		}
		
		//Bucle principal
		while (!haGanado) {
			menu(jugador1, mundo3D);
			haGanado = comprobarSiGana(jugador1);
		}//while
		
		if (haGanado) {
			System.out.println("EL JUGADOR " + jugador1.getNombre() + " HA GANADO");
		}

	}//main

	
	/**
	 * Metodo para generar bloques de tipo aleatorio
	 * @param x posicion x en la que se encuentra el bloque
	 * @param y posicion y en la que se encuentra el bloque
	 * @param z posicion z en la que se encuentra el bloque
	 * @return el bloque creado
	 */
	public static Bloque generaBloqueAleatorio(int x, int y, int z) {

		Bloque bloque = null;
		Random rd = new Random();
		
		
		//Si la altura es 0 o 1 (Los dos primeros niveles), no hay bloques vacios
		if (z == 0 || z == 1) {
			int tipo1 = rd.nextInt(Bloque.NUM_MATERIAS);
			switch (tipo1) {
				case Bloque.ALBERO: {
					bloque = new BloqueAlbero(x, y, z);
					break;
				}
				case Bloque.ARBOL: {
					bloque = new BloqueArbol(x, y, z);
					break;
				}
				case Bloque.ARCILLA: {
					bloque = new BloqueArcilla(x, y, z);
					break;
				}
				case Bloque.COBRE: {
					bloque = new BloqueCobre(x, y, z);
					break;
				}
				case Bloque.HIERRO: {
					bloque = new BloqueHierro(x, y, z);
					break;
				}
				case Bloque.PLANTA: {
					bloque = new BloquePlanta(x, y, z);
					break;
				}
			}
		}else {
			//Ponemos el numero de materias *3, se sale del rango (default)
			//para que los casos 7-18 que no estan contemplados, generen bloques vacios, cunmpliendose que la mitad del mundo estr� vac�o
			int tipo2 = rd.nextInt(Bloque.NUM_MATERIAS*3);

			switch (tipo2) {
				case Bloque.ALBERO: {
					bloque = new BloqueAlbero(x, y, z);
					break;
				}
				case Bloque.ARBOL: {
					bloque = new BloqueArbol(x, y, z);
					break;
				}
				case Bloque.ARCILLA: {
					bloque = new BloqueArcilla(x, y, z);
					break;
				}
				case Bloque.COBRE: {
					bloque = new BloqueCobre(x, y, z);
					break;
				}
				case Bloque.HIERRO: {
					bloque = new BloqueHierro(x, y, z);
					break;
				}
				case Bloque.PLANTA: {
					bloque = new BloquePlanta(x, y, z);
					break;
				}
				default: {
					bloque = new BloqueVacio(x, y, z);
				}
			}
		
		}
		return bloque;
	}
	
	
	/**
	 * Metodo menu, imprime las opciones
	 */
	public static void menu(Jugador jugador1, Bloque[][][] mundo3D) {
		System.out.println();
		System.out.println("1.- Mover");
		System.out.println("2.- Crear herramientas");
		System.out.println("3.- Estado");
		System.out.println("4.- Poner Bloque");
		System.out.print("Seleccione una opci�n: ");
		int opc = Integer.parseInt(kb.nextLine());
		
		tratarMenu(opc, jugador1, mundo3D);
	}
	
	
	/**
	 * Metodo que trata el menu, segun la opcion
	 * @param opc
	 * @param jugador1
	 * @param mundo3D
	 */
	public static void tratarMenu(int opc,  Jugador jugador1, Bloque[][][] mundo3D) {
		System.out.println();
		int opc2;
		
		try {
			switch (opc) {
			case 1: //Mover
				System.out.println();
				System.out.println("Mover");
				System.out.println("1.- Derecha");
				System.out.println("2.- Izquierda");
				System.out.println("3.- Adelante");
				System.out.println("4.- Atras");
				System.out.println("5.- Arriba");
				System.out.println("6.- Abajo");
				System.out.print("Seleccione una opci�n: ");
				opc2 = Integer.parseInt(kb.nextLine());
				
				moverJugador(opc2, jugador1, mundo3D);
				break;
				
			case 2: //Crear Herramienta
				System.out.println();
				System.out.println("1.- Crear Hacha");
				System.out.println("2.- Crear Pico");
				System.out.println("3.- Crear Pala");
				opc2 = Integer.parseInt(kb.nextLine());
				
				crearHerramienta(opc2, jugador1);
				break;
				
			case 3://Estado
				System.out.println(jugador1);
				break;
			
			case 4: //Opci�n inventada
				System.out.println();
				System.out.println("1.- A la derecha");
				System.out.println("2.- A la izquierda");
				System.out.println("3.- Delante");
				System.out.println("4.- Detras");
				System.out.println("5.- Arriba");
				System.out.println("6.- Abajo");
				opc2 = Integer.parseInt(kb.nextLine());
				
				ponerBloque(opc2, jugador1, mundo3D);
				break;
				
			case 5: //Opcion Secreta
				System.out.println();
				System.out.println("Opción secreta");
				mostrarMapaCompleto(mundo3D, jugador1);
				break;
			default:
				throw new JuegoException("Error: Opción inválida");
			}//switch
		} catch (JuegoException e) {
			System.out.println(e.getMessage());
		}
	}

	
	/**
	 * Método para mover al personaje y destruir el bloque si no es BloqueVacio
	 * @param opc
	 * @param jugador1
	 * @param mundo3D
	 */
	public static void moverJugador(int opc, Jugador jugador1, Bloque[][][] mundo3D) throws JuegoException{
		//Variables
		int x = jugador1.getX();
		int y = jugador1.getY();
		int z = jugador1.getZ();
		
		switch (opc) {
		case 1: //Derecha
			//Si el bloque a la derecha se sale del array, se pone a -1 para que pille el bloque 0
			if (x+1 >= TAMANO_MUNDO) {
				x = -1;
			}
			
			//Intenta mover el personaje
			
			//Si es un BloqueVacio, no se puede destruir, por tanto, solo se mueve.
			if (mundo3D[x+1][y][z] instanceof BloqueVacio || mundo3D[x+1][y][z] == null) {
				jugador1.setX(jugador1.getX() + 1);
				if (jugador1.getX() > TAMANO_MUNDO) {
					jugador1.setX(0);
				}
			}else {
				mundo3D[x+1][y][z].destruir(elegirHerramienta(jugador1), jugador1);
			}
			break;
			
		case 2: //Izquierda
			//Si el bloque a la izquierda se sale del array, se pone al tamanno + 1 para que pille el ultimo bloque
			if (x-1 < 0) {
				x = TAMANO_MUNDO + 1;
			}
			
			//Intenta mover el personaje
			
			//Si es un BloqueVacio, no se puede destruir, por tanto, solo se mueve.
			if (mundo3D[x-1][y][z] instanceof BloqueVacio || mundo3D[x-1][y][z] == null) {
				jugador1.setX(jugador1.getX() - 1);
				if (jugador1.getX() < 0) {
					jugador1.setX(TAMANO_MUNDO);
				}
			}else {
				mundo3D[x-1][y][z].destruir(elegirHerramienta(jugador1), jugador1);
			}
			break;
			
		case 3: //Adelante
			//Si el bloque de delante se sale del array, se pone a -1 para que pille el bloque 0
			if (y+1 >= TAMANO_MUNDO) {
				y = -1;
			}
			
			//Intenta mover el personaje
			
			//Si es un BloqueVacio, no se puede destruir, por tanto, solo se mueve.
			if (mundo3D[x][y+1][z] instanceof BloqueVacio || mundo3D[x][y+1][z] == null) {
				jugador1.setY(jugador1.getY() + 1);
				if (jugador1.getY() > TAMANO_MUNDO) {
					jugador1.setY(0);
				}
			}else {
				mundo3D[x][y+1][z].destruir(elegirHerramienta(jugador1), jugador1);
			}
			break;
			
		case 4: //Atras
			//Si el bloque de delante se sale del array, se pone al tamanno + 1 para que pille el ultimo bloque
			if (y-1 < 0) {
				y = TAMANO_MUNDO + 1;
			}
			
			//Intenta mover el personaje
			
			//Si es un BloqueVacio, no se puede destruir, por tanto, solo se mueve.
			if (mundo3D[x][y-1][z] instanceof BloqueVacio || mundo3D[x][y-1][z] == null) {
				jugador1.setY(jugador1.getY() - 1);
				if (jugador1.getY() < 0) {
					jugador1.setY(TAMANO_MUNDO);
				}
			}else {
				mundo3D[x][y-1][z].destruir(elegirHerramienta(jugador1), jugador1);
			}
			break;
			
		case 5: //Arriba
			//Si el bloque de arriba se sale del array, se pone a -1 para que pille el bloque 0
			if (z+1 >= TAMANO_MUNDO) {
				z = -1;
			}
			
			//Intenta mover el personaje
			
			//Si es un BloqueVacio, no se puede destruir, por tanto, solo se mueve.
			if (mundo3D[x][y][z+1] instanceof BloqueVacio || mundo3D[x][y][z+1] == null) {
				jugador1.setZ(jugador1.getZ() + 1);
				if (jugador1.getZ() > TAMANO_MUNDO) {
					jugador1.setZ(0);
				}
			}else {
				mundo3D[x][y][z+1].destruir(elegirHerramienta(jugador1), jugador1);
			}
			break;
			
		case 6: //Abajo
			//Si el bloque de delante se sale del array, se pone al tamanno + 1 para que pille el ultimo bloque
			if (z-1 < 0) {
				z = TAMANO_MUNDO + 1;
			}
			
			//Intenta mover el personaje
			
			//Si es un BloqueVacio, no se puede destruir, por tanto, solo se mueve.
			if (mundo3D[x][y][z-1] instanceof BloqueVacio || mundo3D[x][y][z-1] == null) {
				jugador1.setZ(jugador1.getZ() - 1);
				
				//Si sale del mundo, aparece por el otro extremo
				if (jugador1.getZ() < 0) {
					jugador1.setZ(TAMANO_MUNDO);
				}
			}else {
				mundo3D[x][y][z-1].destruir(elegirHerramienta(jugador1), jugador1);
			}
			break;

		default:
			throw new JuegoException("Error: Opción de movimiento inválida");
		}//switch
	}//moverJugador

	
	/**
	 * Método para elegir la herrameinta en el movimiento
	 * @return
	 * @throws JuegoException
	 */
	private static String elegirHerramienta(Jugador jugador1) throws JuegoException{
		int opc;
		String herramienta = null;
		
		//Menu
		System.out.println();
		System.out.println("Elige herramienta");
		System.out.println("1.- Hacha");
		System.out.println("2.- Pico");
		System.out.println("3.- Pala");
		System.out.print("Elección: ");
		opc = Integer.parseInt(kb.nextLine());
		
		switch (opc) {
		case 1: //Hacha
			//Si la herramienta tiene 0 usos, salta la excepci�n
			if (jugador1.getUsosHacha() <= 0) {
				throw new JuegoException("La herramienta no tiene mas usos, tienes que arreglarla");
			}
			herramienta = BloqueVegetal.HERRAMIENTA;
			break;
			
		case 2: //Pico
			if (jugador1.getUsosPico() <= 0) {
				throw new JuegoException("La herramienta no tiene mas usos, tienes que arreglarla");
			}
			herramienta = BloqueMineral.HERRAMIENTA;
			break;
			
		case 3: //Pala
			if (jugador1.getUsosPala() <= 0) {
				throw new JuegoException("La herramienta no tiene mas usos, tienes que arreglarla");
			}
			herramienta = BloqueTierra.HERRAMIENTA;
			break;
			
		default:
			throw new JuegoException("Error: Herramienta inválida");
		}
		return herramienta;
	}//elegirHerramienta
	
	
	/**
	 * Metodo para crear las herramientas
	 * @param opc2
	 * @param jugador1
	 * @param mundo3d
	 */
	private static void crearHerramienta(int opc2, Jugador jugador1) throws JuegoException{
		
		switch (opc2) {
		case 1: //Hacha
			//Pone los usos a 5 (El m�ximo)
			jugador1.setUsosHacha(5);
			
			//Resta los materiales necesarios
			jugador1.restaMateria(Bloque.ARBOL);
			jugador1.restaMateria(Bloque.HIERRO);
			break;
		case 2: //Pico
			jugador1.setUsosPico(5);
			jugador1.restaMateria(Bloque.ARBOL);
			jugador1.restaMateria(Bloque.ARBOL);
			jugador1.restaMateria(Bloque.HIERRO);
			jugador1.restaMateria(Bloque.HIERRO);
			break;
		case 3: //Pala
			jugador1.setUsosPala(5);
			jugador1.restaMateria(Bloque.ARBOL);
			jugador1.restaMateria(Bloque.ARBOL);
			jugador1.restaMateria(Bloque.HIERRO);
			jugador1.restaMateria(Bloque.COBRE);
			break;

		default:
			throw new JuegoException("Error: seleccion de herramienta inválida");
		}//switch
	}//crearHerramienta
	
	
	/**
	 * Metodo que muestra el mapa completo, la opción secreta.
	 * El resultado del metodo es un lío.
	 * Muestra el mapa por capas segun la Z, mostrando en cada valor de Y los TAMANO_MUNDO valores de X
	 * @param mundo3d
	 */
	private static void mostrarMapaCompleto(Bloque[][][] mundo3D, Jugador jugador) {
		
		//Se crea un BloqueJugador en las coordenadas actuales para poder representar su posicion en el mapa
		mundo3D[jugador.getX()][jugador.getY()][jugador.getZ()] = new BloqueJugador(jugador);
		
		//Para cada una de las capas (variable Z)
		for (int z= 0; z <TAMANO_MUNDO; z++) {
			System.out.println();
			//Se crea un cuadrado de X por Y, para representarlo.
			for (int y= 0; y <TAMANO_MUNDO; y++) {
				System.out.print("\n|");
				for (int x= 0; x <TAMANO_MUNDO; x++) {
					System.out.print(mundo3D[x][y][z] + "|");
				}//for x
			}//for y
		}//for z
		
		System.out.println();
	}//mostrarMapaCompleto
	
	
	/**
	 * Metodo que comprueba si el jugador gana
	 * @return
	 */
	private static boolean comprobarSiGana(Jugador jugador1) {
		boolean gana = true;
		
		//Recorre las materias del jugador
		for (int i = 0; i < jugador1.materiasPrimas.length && gana; i++) {
			
			//Si la materia correspondiente es mayor o igual a 7, gana
			if (jugador1.materiasPrimas[i] >= MATERIAS_NECESARIAS_PARA_GANAR) {
				gana = true;
			}else {
				//En caso contrario, no gana y sale del bucle
				gana = false;
			}
		}
		
		return gana;
	}

	/**
	 * Metodo inventado que pone un bloque aleatorio del inventario del jugador en el mundo, usando el metodo restaMateria
	 * si el bloque es BloqueVacio, lo pone sin más
	 * si el bloque es de otro tipo, lo destruye sin saber que tipo es y pone el bloque en esas coordenadas
	 * @param opc
	 * @param jugador1
	 */
	private static void ponerBloque(int opc, Jugador jugador1, Bloque[][][] mundo3D) throws JuegoException{
		//Variables
		int x = jugador1.getX();
		int y = jugador1.getY();
		int z = jugador1.getZ();
		
		Bloque bloqueAleatorio = new BloqueVacio(-1,-1,-1);
		
		//Genera el bloque que se va a poner, e impide que sea BloqueVacio
		while (bloqueAleatorio instanceof BloqueVacio) {
			bloqueAleatorio = generaBloqueAleatorio(x+1, y, z);
			
		}
		
		switch (opc) {
		case 1: //Derecha
			//Si el bloque a la derecha se sale del array, salta excepcion
			if (x+1 >= TAMANO_MUNDO) {
				throw new JuegoException("No se puede colocar un bloque ahí");
			}

			//Mira si el bloque es BloqueVacio
			if (mundo3D[x+1][y][z] instanceof BloqueVacio) {
				mundo3D[x+1][y][z] = bloqueAleatorio;
			}else {//Si no está vacio intenta destruirlo
				mundo3D[x+1][y][z].destruir(elegirHerramienta(jugador1), jugador1);
				
			}
			
			break;
		case 2: //Izquierda
			//Si el bloque a la izquierda se sale del array, salta excepcion
			if (x - 1 < 0) {
				throw new JuegoException("No se puede colocar un bloque ahí");
			}

			//Mira si el bloque es BloqueVacio
			if (mundo3D[x-1][y][z] instanceof BloqueVacio) {
				mundo3D[x-1][y][z] = bloqueAleatorio;
			}else {
				mundo3D[x-1][y][z].destruir(elegirHerramienta(jugador1), jugador1);
			}
			
			break;
		
		case 3: //Delante
			//Si el bloque de delante se sale del array, salta excepcion
			if (y+1 >= TAMANO_MUNDO) {
				throw new JuegoException("No se puede colocar un bloque ahí");
			}

			//Mira si el bloque es BloqueVacio
			if (mundo3D[x][y+1][z] instanceof BloqueVacio) {
				mundo3D[x][y+1][z] = bloqueAleatorio;
			}else {
				mundo3D[x][y+1][z].destruir(elegirHerramienta(jugador1), jugador1);
			}
			
			break;
		case 4: //Detras
			//Si el bloque de detras se sale del array, salta excepcion
			if (y-1 < 0) {
				throw new JuegoException("No se puede colocar un bloque ahí");
			}

			//Mira si el bloque es BloqueVacio
			if (mundo3D[x][y-1][z] instanceof BloqueVacio) {
				mundo3D[x][y-1][z] = bloqueAleatorio;
			}else {
				mundo3D[x][y-1][z].destruir(elegirHerramienta(jugador1), jugador1);
			}
			
			break;
		case 5: //Arriba
			//Si el bloque de arriba se sale del array, salta excepcion
			if (z+1 >= TAMANO_MUNDO) {
				throw new JuegoException("No se puede colocar un bloque ahí");
			}

			//Mira si el bloque es BloqueVacio
			if (mundo3D[x][y][z+1] instanceof BloqueVacio) {
				mundo3D[x][y][z+1] = bloqueAleatorio;
			}else {
				mundo3D[x][y][z+1].destruir(elegirHerramienta(jugador1), jugador1);
			}
			
			break;
		case 6: //Abajo
			//Si el bloque de debajo se sale del array, salta excepcion
			if (z-1 < 0) {
				throw new JuegoException("No se puede colocar un bloque ahí");
			}

			//Mira si el bloque es BloqueVacio
			if (mundo3D[x][y][z-1] instanceof BloqueVacio) {
				mundo3D[x][y][z-1] = bloqueAleatorio;
			}else {
				mundo3D[x][y][z-1].destruir(elegirHerramienta(jugador1), jugador1);
			}
			
			break;
		default:
			throw new JuegoException("Error: Opción inválida");
		}//switch
		
		jugador1.restaMateria(bloqueAleatorio.getTipo());
	}//ponerBloque
}//Juego
