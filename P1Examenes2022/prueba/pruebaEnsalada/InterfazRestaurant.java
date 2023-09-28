package pruebaEnsalada;

import java.util.Scanner;

import srcEnsalada.Ensalada;
import srcEnsalada.Ingrediente;
import srcEnsalada.Origen;
import srcEnsalada.Pedido;
import veterinaria.Especie;

public class InterfazRestaurant {
	
	static Scanner teclado= new Scanner (System.in);
	private static String nombreIngrediente= "";
	private static double precioIngredienteNuevo=0.0;
	private static Origen tipoOrigen=null;
	
	public static void main(String args[]) {
	
		final int CANTIDAD_MAXIMA_DE_INGREDIENTES = 50;
		final int CANTIDAD_MAXIMA_DE_ENSALADAS = 10;
		final int CANTIDAD_MAXIMA_DE_PEDIDOS_POR_DIA = 100;
		int opcion=0;
		Ingrediente ingredientesDisponibles[] = new Ingrediente[CANTIDAD_MAXIMA_DE_INGREDIENTES];
		Ensalada ensaladaPreEstablecidas[] = new Ensalada[CANTIDAD_MAXIMA_DE_ENSALADAS];
		Pedido pedidos[] = new Pedido[CANTIDAD_MAXIMA_DE_PEDIDOS_POR_DIA];
		
		Ensalada nuevaEnsalada = new Ensalada ("Cesar", ingredientesDisponibles, 80);
		Ingrediente nuevoIngrediente= null;
		System.out.println("Bienvenido al Verde");
		System.out.println("Ingrese una opcion");
		do {
		mostrarMenu();
		opcion = teclado.nextInt();
		int numero =0;
		switch (opcion) {
		case 1:
			incorporarNuevoIngrediente();
			nuevoIngrediente = new Ingrediente (nombreIngrediente, precioIngredienteNuevo, tipoOrigen);
			boolean seAgregoIngrediente=nuevaEnsalada.agregarIngrediente(nuevoIngrediente);
			notificarSiPudoAgregarIngrediente(seAgregoIngrediente);
			System.out.println(nuevoIngrediente.toString());
			
			break;
			
		case 2:
			

		case 4:
			
				System.out.println(nuevaEnsalada.toString());
				break;
		case 5:
			nuevaEnsalada.ordenarIngredientesPorMayorPrecio();
			System.out.println(nuevaEnsalada.toString());
			break;
		case 6: 
			System.out.println("Ingrese el origen del ingrediente");
			System.out.println("1. Vegetal");
			System.out.println("2. Animal");
			System.out.println("3. TACC");
			System.out.println("4. Leche");
			System.out.println("5. Huevo");
			opcion = teclado.nextInt();
			tipoOrigen= Origen.values()[opcion-1];
			Ingrediente [] filtrarPorIngrediente= nuevaEnsalada.filtrarPorTipoOrigen(tipoOrigen);
			notificarSiPudoFiltrarPorIngrediente (filtrarPorIngrediente);
			
		default:
			break;
		}
		} while (opcion!=9);
		/*
		 * En esta secci�n del c�digo se debe generar la interacci�n con el usuario. Se pueden incorporar tantos 
		 * m�todos como considere necesario. M�nimamente se debe invocar a los siguientes m�todos:
		 * 
		 * 	incorporarNuevoIngrediente
		 * 	crearUnNuevaEnsalada
		 * 	crearUnNuevoPedido
		 */

	}
		
	private static void notificarSiPudoFiltrarPorIngrediente(Ingrediente[] filtrarPorIngrediente) {
		if (filtrarPorIngrediente!= null) {
			for (int i=0; i<filtrarPorIngrediente.length;i++) {
				if (filtrarPorIngrediente[i]!=null) {
					System.out.println("Se encontraron los ingredientes " + filtrarPorIngrediente[i]);
				}
				else {
					System.out.println("No se encontraron ingredientes");
				}
			}
		}
		
	}

	private static void notificarSiPudoAgregarIngrediente(boolean seAgregoIngrediente) {
		if (seAgregoIngrediente) {
			System.out.println("Se agrego el ingrediente correctamente");
		}
		else {
			System.out.println("No se pudo agregar");
		}
		
	}

	private static void mostrarMenu() {
		System.out.println("1. incorporar un nuevo ingrediente");
		System.out.println("2. crear una ensalada");
		System.out.println("3. crear un pedido");
		System.out.println("4. Listar ingredientes disponibles");
		System.out.println("5. Ordenar ingredientes por mayor precio");
		System.out.println("6. Filtrar ingredientes por tipo origen");
	}

	private static boolean incorporarNuevoIngrediente() {

		/* Se crean nuevos ingredientes los cuales pueden ser utilizados en los platos */
		boolean seCreo=false;
		System.out.println("Ingrese el nombre del nuevo ingrediente");
		nombreIngrediente= teclado.next();
		System.out.println("Ingrese el precio");
		precioIngredienteNuevo= teclado.nextDouble();
		System.out.println("Ingrese el origen del ingrediente");
		System.out.println("1. Vegetal");
		System.out.println("2. Animal");
		System.out.println("3. TACC");
		System.out.println("4. Leche");
		System.out.println("5. Huevo");
		int opcion= 0;
		do {
		opcion= teclado.nextInt();
		tipoOrigen = Origen.values()[opcion-1];
		
		} while (opcion<1 || opcion>5);
		
		
		seCreo=true;
		return seCreo;
	}
	
	private static void crearUnNuevaEnsalada() {
		/* Se visualiza el listado de ingredientes disponibles y a partir de ah� se crean nuevos platos, los cuales 
		 * pueden ser solicitados por los clientes 
		 */
	}
	
	private static void crearUnNuevoPedido() {
		/*
		 * Se muestra el listado de ensaladas, y el cliente elige la ensalada deseada.
		 * Una vez elegida la ensalada el cliente puede incorporar nuevos ingredientes.
		 * Al finalizar informa el valor que debe abonar.
		 */
	}
}


