package ensaladaResuelta;

import java.util.Scanner;

public class InterfazRestaurant {
	
	public static void main(String args[]) {
	
		final int CANTIDAD_MAXIMA_DE_INGREDIENTES = 50;
		final int CANTIDAD_MAXIMA_DE_ENSALADAS = 10;
		final int CANTIDAD_MAXIMA_DE_PEDIDOS_POR_DIA = 100;
		
		Ingrediente ingredientesDisponibles[] = new Ingrediente[CANTIDAD_MAXIMA_DE_INGREDIENTES];
		Ensalada ensaladaPreEstablecidas[] = new Ensalada[CANTIDAD_MAXIMA_DE_ENSALADAS];
		Pedido pedidos[] = new Pedido[CANTIDAD_MAXIMA_DE_PEDIDOS_POR_DIA];
		
		Scanner teclado = new Scanner(System.in);	
		char opcionIngresada = '\0';
		final char SALIR = '6', INCORPORARNUEVOINGREDIENTE = '1', CREARUNNUEVAENASALADA = '2', CREARUNNUEVOPEDIDO = '3';
		Ensalada Verde = new Ensalada ();
		
		do {
			mostrarMenu();
			opcionIngresada = teclado.next().charAt(0);
			switch(opcionIngresada) {
			case INCORPORARNUEVOINGREDIENTE:
			    incorporarNuevoIngrediente(teclado, ingredientesDisponibles, ensaladaPreEstablecidas);
			    break;
			case CREARUNNUEVAENASALADA:
	//			crearUnNuevaEnsalada(teclado, ingredientesDisponibles, pedidos);
				 break;
			case CREARUNNUEVOPEDIDO:
				crearUnNuevoPedido(teclado, ingredientesDisponibles, ensaladaPreEstablecidas);
				break;
			case SALIR:
				break;
			}
		} while(opcionIngresada != SALIR);
		
		
		/*
		 * En esta secci�n del c�digo se debe generar la interacci�n con el usuario. Se pueden incorporar tantos 
		 * m�todos como considere necesario. M�nimamente se debe invocar a los siguientes m�todos:
		 * 
		 * 	incorporarNuevoIngrediente
		 * 	crearUnNuevaEnsalada
		 * 	crearUnNuevoPedido
		 */

	}
		
	private static void incorporarNuevoIngrediente(Scanner teclado, Ingrediente ingredientesDisponibles[], Ensalada ensaladaPreEstablecidas[]) {

		/* Se crean nuevos ingredientes los cuales pueden ser utilizados en los platos */
	String IngredienteNuevo = "";
	IngredienteNuevo = teclado.next();
	boolean sePudoAgregar = false;
	System.out.println("Ingrese el nuevo ingrediente");
	Ingrediente NuevoIngrediente = null; 
	//sePudoAgregar = Ensalada.agregarIngrediente(NuevoIngrediente);
	if(sePudoAgregar) {
		System.out.println("Se agrego el nuevo ingrediente correctamente");
	}
	else {
		System.out.println("No se ha podido agregar, lo sentimos");
	}

	
	}
	
	private static void crearUnNuevaEnsalada(Scanner teclado, Ingrediente ingredientesDisponibles[], Pedido pedidos) {
		/* Se visualiza el listado de ingredientes disponibles y a partir de ah� se crean nuevos platos, los cuales 
		 * pueden ser solicitados por los clientes 
		 */
		pedidos = new Pedido ("Maria");
		Ensalada porCrear = new Ensalada();
		Ingrediente lechuga = new Ingrediente("lechuga", 20.0, Origen.VEGETAL);
		Ingrediente tomate = new Ingrediente("tomate", 34.0, Origen.VEGETAL);
		Ingrediente jamon = new Ingrediente("jamon", 50.0, Origen.ANIMAL);
		Ingrediente queso = new Ingrediente("queso", 47.1, Origen.ANIMAL);
		Ingrediente zanahoria = new Ingrediente("zanahoria", 11.9, Origen.VEGETAL);
		Ingrediente pollo = new Ingrediente("pollo", 108.0, Origen.ANIMAL);
		Ingrediente espinaca = new Ingrediente("espinaca", 53.0, Origen.VEGETAL);
		Ingrediente palta = new Ingrediente("palta", 89.9, Origen.VEGETAL);
		Ingrediente cebolla = new Ingrediente("cebolla", 33.9, Origen.VEGETAL);
		Ingrediente huevo = new Ingrediente("huevo", 77.9, Origen.HUEVO);
		
		System.out.println("Seleccione alguno de los ingredientes");
		
		int eleccion = 0;
		
		
		System.out.println("A continuacion le dejaremos los ingredientes disponibles: ");
		for(int i = 0; i < ingredientesDisponibles.length; i++) {
			if(ingredientesDisponibles[i] != null) {
				}
		}
	}
	
	private static void crearUnNuevoPedido(Scanner teclado, Ingrediente ingredientesDisponibles[], Ensalada ensaladaPreEstablecidas[]) {
		/*
		 * Se muestra el listado de ensaladas, y el cliente elige la ensalada deseada.
		 * Una vez elegida la ensalada el cliente puede incorporar nuevos ingredientes.
		 * Al finalizar informa el valor que debe abonar.
		 */
		System.out.println("Seleccione su pedido");
		for(int i = 0; i < ensaladaPreEstablecidas.length; i++) {
			if(ensaladaPreEstablecidas[i] != null) {
				System.out.println("El pedido seleccionado es: " + ensaladaPreEstablecidas[i].getNombreDeLaEnsalada());
				//System.out.println("El importe a abonar es de " + ensaladaPreEstablecidas[i].getImporte);
			}
		}
		
	}
	private static void mostrarMenu() {
		System.out.println("Bienvenido al Verde");
		System.out.println("Ingrese la opcion que desea realizar: \n");
		System.out.println(" 1 - incorporar un nuevo ingrediente \n 2 - crear una nueva ensalada \n 3 - crear un nuevo pedido \n 6 - salir del menu");
	}
}


