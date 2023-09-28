package empresaFerroviaria;

import java.util.Scanner;

public class mainEmpresaFerroviaria {

	private static final int SALIR = 9;
	static Scanner teclado= new Scanner (System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Locomotora primerLocomotora = new Locomotora (1, "Pepe", 10);
		int opcion=0;
		do {
		mostrarMenu();
		opcion= teclado.nextInt();
		switch (opcion) {
		case 1:
			
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
			
		default:
			break;
		}
		
		}while (opcion!=SALIR);
		
	}

	private static void mostrarMenu() {
		System.out.println("Bienvenido a QtrainQtrain");
		System.out.println("1. Agregar un vagon");
		System.out.println("2. Mostrar vagon de menor peso");
		System.out.println("3. Mostrar peso promedio de vagon por marca");
		System.out.println("4. Editar nombre de vagon");
		System.out.println("5. Ordenar vagones por Id");	
		
	}

}
