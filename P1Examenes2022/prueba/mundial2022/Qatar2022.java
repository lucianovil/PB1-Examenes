package mundial2022;

import java.util.Scanner;
import mundial2022.Figurita;
import mundial2022.Album;

public class Qatar2022 {

private static final int ACTUALIZAR_DATOS_FIGURITA = 1, COMPRAR_SOBRE = 2, VISUALIZAR_FIGURITAS_ACTUALES = 3, CALCULAR_PORCENTAJE_DE_COMPLETADO = 4, SALIR = 9;
	
	public static void main(String[] args) {

	
		
		Album actual = new Album();
		actual.inicializarCodigosDeFiguritas();
		
		int opcionIngresada;
		Scanner teclado = new Scanner(System.in);

		System.out.println("Bienvenido album de figuritas Panini Virtual");

		do {
			mostrarMenu();
			opcionIngresada = teclado.nextInt();
			actual = determinarAccionARealizar(actual, opcionIngresada, teclado);
		}while (!actual.elAlbumEstaCompleto());
	}

	private static void mostrarMenu() {
		System.out.println("************************");
		System.out.println("Menu de opciones\n");
		System.out.println(ACTUALIZAR_DATOS_FIGURITA + " - Actualizar datos de la figurita");
		System.out.println(COMPRAR_SOBRE + " - Comprar sobre ");
		System.out.println(VISUALIZAR_FIGURITAS_ACTUALES + " - Visualizar figuritas actuale");
		System.out.println(SALIR + " - Salir");
		System.out.println("************************");
	}

	private static Album determinarAccionARealizar(Album actual, int opcionIngresada, Scanner teclado) {

		switch(opcionIngresada) {
		case ACTUALIZAR_DATOS_FIGURITA:
			actualizardatosFigurita(teclado, actual);
			break;
		case COMPRAR_SOBRE:
			comprarSobre(teclado, actual);
			break;
		case VISUALIZAR_FIGURITAS_ACTUALES:
			visualizarFiguritasActuales(teclado, actual);
			break;
		case CALCULAR_PORCENTAJE_DE_COMPLETADO:
			calcularElPorcentajeDeCompletado(teclado, actual);
			break;
		case SALIR:
			break;
		}
		return actual;
	}

	private static void actualizardatosFigurita(Scanner teclado, Album actual) {
		String codigo;
		char grupo;
		String seleccion;
		String nombreJugador;
		double valor;
		Figurita aActualizar;

		System.out.println("***************");
		System.out.println("Actualizar datos de figurita");
		System.out.println("***************"); 

		System.out.println("Ingrese el codigo a actualizar");
		codigo = teclado.next();
		aActualizar = actual.getFigurita(codigo);
		
		System.out.println("Selección: " + aActualizar.getSeleccion());
		
		System.out.println("Ingrese el grupo al que pertenece la selección");
		grupo = teclado.next().charAt(0);
		System.out.println("Ingrese el nombre del jugador");
		nombreJugador = teclado.next();
		System.out.println("Ingrese el valor");
		valor = teclado.nextDouble();

		actual.actualizarDatosFigurita(codigo, grupo, nombreJugador, valor);
	}

	private static void comprarSobre(Scanner teclado, Album actual) {
		Figurita compradas[] = actual.comprarSobre();
		
		System.out.println("Las figuritas son");

		for (int i=0; i<5; i++) {
			System.out.println(compradas[i].getCodigo());
		}
		/*
		 * Mostrar las figuritas obtenidas
		 */
		
		/* 
		 * Por cada figuria comprada, agregarlas al album actual actual.agregarFigurita(compradas[i]);
		 */
		
	}
	
	private static void visualizarFiguritasActuales(Scanner teclado, Album actual) {
		/*
		 * Se deben mostrar las figuritas que posee el usuario de manera ordenada.
		 */
	}
	
	private static void calcularElPorcentajeDeCompletado(Scanner teclado, Album actual) {
		System.out.println("El album está completo en un " + actual.calcularPorcentajeCompletado() + "%");
	}
}
