package topMusic;

import utiles.Menu;
import utiles.Teclado;
/**
 * TopMusic. Implementa un programa que gestione una lista de las canciones más escuchadas. 
 * 
 * El usuario podrá:
 * 
 * a. Añadir una canción (en una posición) al TopMusic.
 * b. Sacar un elemento del TopMusic.
 * c. Subir un puesto en el TopMusic.
 * d. Bajar un puesto en el TopMusic.
 * e. Mostrar la lista TopMusic.
 * f. Mostrar la canción más escuchada.
 * 
 * Sobre la canción se almacenará el título, artista o grupo y año de grabación.
 * 
 * @author Rafael Delgado Peña
 * @version 1.0
 *
 */
public class TestTopMusic {
	/**
	 * Campo que recogera nuestras canciones
	 */
	private static TopMusic topMusic = new TopMusic();

	public static void main(String[] args) {
		Menu menuGeneral = new Menu("*** TOP MUSIC ***", new String[] { "Añadir cancion", "Eliminar cancion",
				"Subir puesto", "Bajar puesto", "Mostrar TopMusic", "Mostrar el nº1", "Salir" });
		int opcion;

		do {
			opcion = menuGeneral.gestionar();
			gestionarOpciones(opcion);
		} while (opcion != 7);
	}

	/**
	 * Gestiona las opciones del menu
	 * 
	 * @param opcion
	 *            escogida
	 */
	private static void gestionarOpciones(int opcion) {
		switch (opcion) {
		case 1:
			// Añadir cancion
			annadirCancion();
			break;
		case 2:
			// Eliminar cancion
			eliminarCancion();
			break;
		case 3:
			// Subir cancion
			subirCancion();
			break;
		case 4:
			// Bajar cancion
			bajarCancion();
			break;
		case 5:
			// Mostrar top
			// mostrarTop();
			break;
		case 6:
			// Mostrar nº1
			mostrarCima();
			break;
		case 7:
			// Salir
			System.out.println("Adios!");
			System.exit(0);
			break;
		}
		mostrarTop();
	}

	/**
	 * Muestra el nº 1 del top
	 */
	private static void mostrarCima() {
		if (!topMusic.isEmpty())
			System.out.println(topMusic.masEscuchada());
		else
			System.out.println("Top vacio!");
	}

	/**
	 * Muestra el top completo
	 */
	private static void mostrarTop() {
		if (!topMusic.isEmpty())
			System.out.println(topMusic.mostrarTopMusic());
		else
			System.out.println("Top vacio!");
	}

	/**
	 * Baja una cancion del top
	 */
	private static void bajarCancion() {
		if (!topMusic.isEmpty()) {
			if (!topMusic.bajar(topMusic.posicionValida(Teclado.leerEntero("Posicion:"))))
				System.out.println("No se pudo bajar la cancion");
			else
				System.out.println("Cancion bajada!");
		} else
			System.out.println("Top vacio!");
	}

	/**
	 * Sube una cancion del top
	 */
	private static void subirCancion() {
		if (!topMusic.isEmpty()) {
			if (!topMusic.subir(topMusic.posicionValida(Teclado.leerEntero("Posicion:"))))
				System.out.println("No se pudo subir la cancion");
			else
				System.out.println("Cancion subida!");
		} else
			System.out.println("Top vacio!");
	}

	/**
	 * Elimina una cancion del top
	 */
	private static void eliminarCancion() {
		if (!topMusic.isEmpty()) {
			if (!topMusic.sacar(Teclado.leerCadena("Titulo:")))
				System.out.println("No se pudo eliminar");
			else
				System.out.println("Cancion eliminada!");
		} else
			System.out.println("Top vacio!");
	}

	/**
	 * Añade una cancion al top
	 */
	private static void annadirCancion() {
		if (!topMusic.annadir(topMusic.posicionValida(Teclado.leerEntero("Posicion:")), Cancion.getInstance(Teclado.leerCadena("Introduce un título válido:"),Teclado.leerCadena("Introduce un artista válido:"),Teclado.leerEntero("Introduce el año de grabación(1900-2017):")))) {
			System.out.println("No se pudo añadir");
		} else
			System.out.println("Cancion añadida!");
	}

}
