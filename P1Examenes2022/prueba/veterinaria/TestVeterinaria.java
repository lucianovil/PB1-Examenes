package veterinaria;

import java.util.Scanner;
import veterinaria.Atencion;
import veterinaria.Veterinaria;
import veterinaria.Especie;

public class TestVeterinaria {

	private static final int SALIR= 9;
	private static final int CANTIDAD_MAXIMA_ATENCIONES = 5;
	private static int id=0;
	private static String nombreCliente="";
	private static String nombreMascota="";
	private static Especie Mascota=null;
	private static double monto=0.0;
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		String nombreVeterinaria = "UNLaM-Vet";
		mostrarMensaje("Bienvenido a " + nombreVeterinaria);
		
		Atencion [] CantidadMaximaAtencion = new Atencion [CANTIDAD_MAXIMA_ATENCIONES];
		
		Veterinaria veterinaria = new Veterinaria(nombreVeterinaria, CantidadMaximaAtencion);

		int opcion = 0;

		do {
			opcion = seleccionarOpcion(teclado);

			switch (opcion) {
			case 1:
				// Registra una atencion con los datos ingresados por el empleado e informa el resultado
				crearAtencion(teclado);
				Atencion nuevaAtencion = new Atencion (id, nombreCliente, nombreMascota, Mascota, monto);
				boolean sePudoCrear= veterinaria.registrarAtencion(nuevaAtencion);
				notificarSiSePudoCrear(sePudoCrear);
				
				break;
			case 2:
				mostrarMensaje("Ingrese el id");
				id=teclado.nextInt();
				Atencion atencionBuscada= veterinaria.buscarAtencionPorId(id);
				notificarSiEncontroPorID(atencionBuscada, id);
				// Se solicita el ingreso del id y se muestra la informacion de la atencion
				// encontrada. Si no se encuentra, mostrar un mensaje
				break;
			case 3:
				// Ingresar la especie de mascota para listar las atenciones que correspondan.
				// Si no hay atenciones indicar lo propio
				mostrarMensaje("Ingrese la especie");
				mostrarMensaje("1. Perro");
				mostrarMensaje("2. Gato");
				mostrarMensaje("3. Ave");
				
				opcion= teclado.nextInt();
				switch (opcion) {
				case 1: 
					Mascota= Especie.PERRO;
					mostrarMensaje("Elegiste Perro");
				break;
				case 2: 
					Mascota= Especie.GATO;
					mostrarMensaje("Elegiste Gato");
				break;
				case 3: 
					Mascota= Especie.AVE;
					mostrarMensaje("Elegiste Ave");
				break;
				default:
					mostrarMensaje("No se pudo ingresar el tipo de mascota");
					break;
				}
				
				Atencion[] filtrarPorEspecie = veterinaria.listarAtencionesPorEspecieDeMascota(Mascota);
				notificarSiEncontroPorEspecie(filtrarPorEspecie);
				break;
			case 4:
				// Se solicita el ingreso del id de la atencion y se elimina. Indicar el
				// resultado de la operacion
				mostrarMensaje("Ingrese el id");
				id=teclado.nextInt();
				boolean atencionAEliminar= veterinaria.eliminarAtencionPorId(id);
				notificarSiSePudoEliminar(atencionAEliminar);
				
				break;
			case 5:
				// Listar las atenciones realizadas y las disponibles
				mostrarMensaje("La cantidad de atenciones realizadas es de: " + veterinaria.obtenerCantidadDeAtencionesRealizadas());
				Atencion[] listarAtenciones = veterinaria.getAtenciones();
				mostrarAtencionesRealizadas(listarAtenciones);
				mostrarMensaje("La cantidad de atenciones disponibles es de: " + veterinaria.obtenerCantidadDeAtencionesDisponibles(0));
				break;
			case 6:
				// Informar el total de todas las atenciones realizadas. Debe inciar sesión para realizar esta operacion.
				// Si las credenciales son invalidas, indicarlo y volver al menu principal.
				boolean inicioSesion = false;
				while (inicioSesion==false) {
				mostrarMensaje("Ingrese su usuario");
				String nombreusuario = teclado.next();
				mostrarMensaje("Ingrese su contrasenia");
				String contrasenia = teclado.next();
				inicioSesion= veterinaria.iniciarSesion(nombreusuario, contrasenia);
				verificarSiPudoiniciarSesion(inicioSesion);
				
				if (inicioSesion==false) {
					break;
				}
				else {
					mostrarMensaje("El monto total es: " + veterinaria.obtenerTotalDeAtenciones());
				}
				}
				
				
				break;
			case 7:
				// Informar por pantalla atenciones ordenadas en forma decreciente. Si no hay atenciones mostrar un mensaje aclaratorio.
				// Si las credenciales son invalidas, indicarlo y volver al menu principal.
			
				for (int i=0; i< veterinaria.getAtenciones().length; i++ ) {
					if (veterinaria.getAtenciones() [i]!= null) {
						veterinaria.ordenarAtencionesPorMontoDescendente();
				mostrarMensaje("Las atenciones ordenadas en forma decreciente son: " + veterinaria.getAtenciones() [i] );
				}
				}
				break;
			case SALIR:
				mostrarMensaje("Gracias por utilizar el sistema");		
				break;
			}

		} while (opcion != SALIR);
	
		teclado.close();
	}


	private static void verificarSiPudoiniciarSesion(boolean inicioSesion) {
		if (inicioSesion) {
			mostrarMensaje("Se inicio sesion correctamente");
		}
		else {
			mostrarMensaje("No se pudo iniciar sesion.");
		}
		
	}


	private static void mostrarAtencionesRealizadas(Atencion[] listarAtenciones) {
		for (int i=0; i< listarAtenciones.length;i++) {
			if (listarAtenciones[i]!=null) {
			mostrarMensaje("1. " + listarAtenciones[i]);
			}
			else {
				mostrarMensaje("No se encontraron atenciones realizadas");
			}
		}
		
	}


	private static void notificarSiSePudoEliminar(boolean atencionAEliminar) {
		if (atencionAEliminar) {
			mostrarMensaje("La atencion se elimino");
		}
		else {
			mostrarMensaje("No se pudo eliminar la atencion");
		}
		
	}

	private static void notificarSiEncontroPorEspecie(Atencion[] filtrarPorEspecie) {
		if (filtrarPorEspecie!=null) {
			for (int i=0; i<filtrarPorEspecie.length; i++) {
				if(filtrarPorEspecie[i]!=null) {
			mostrarMensaje("Se encontro la atencion " + filtrarPorEspecie[i]);
		}
			}
		}
		else {
			mostrarMensaje("No se encontro la atencion ");
		}
			
	}

	private static void notificarSiEncontroPorID(Atencion atencionBuscada, int id) {
		if (atencionBuscada!=null) {
			mostrarMensaje("Atencion encontrada por ID " + atencionBuscada.toString());
		}
		else {
			mostrarMensaje("No se encontro la atencion del ID " + id);
		}
		
	}

	private static void notificarSiSePudoCrear(boolean sePudoCrear) {
		if (sePudoCrear) {
			mostrarMensaje("La atencion se registro correctamente");
		}
		else {
			mostrarMensaje("No se pudo registrar la atencion");
		}
		
	}

	/**
	 * Muestra el menu principal y solicita el ingreso de la funcionalidad deseada
	 * 
	 * @param teclado	Para el ingreso de datos
	 * @return opcion seleccionada
	 * */
	private static int seleccionarOpcion(Scanner teclado) {
		
		int opcionSeleccionada = 0;

		mostrarMensaje("\n************************");
		mostrarMensaje("Menu Principal\n");
		mostrarMensaje("1 - Registar una atencion ");
		mostrarMensaje("2 - Buscar atencion por su identificador unico");
		mostrarMensaje("3 - Listar atenciones por una especie determinada");
		mostrarMensaje("4 - Eliminar una atencion por su id");
		mostrarMensaje("5 - Informar la cantidad de atenciones realizadas y las disponibles");
		mostrarMensaje("6 - Infomar el total de todas las atenciones realizadas [Requiere iniciar sesion]");
		mostrarMensaje("7 - Listar atenciones por monto descendente [Requiere iniciar sesion]");
		mostrarMensaje("\n9 - Salir");
		mostrarMensaje("\n************************");
		mostrarMensaje("\nIngrese una opcion");

		opcionSeleccionada = teclado.nextInt();

		return opcionSeleccionada;
	}
	
	/**
	 * Solicita el ingreso de la informacion para crear una atencion y la crea
	 * @param teclado	Para el ingreso de datos
	 * */
	private static boolean crearAtencion(Scanner teclado) {
		boolean sePudoCrear=false;
		do {
		mostrarMensaje("El id es: " + ++id);
		mostrarMensaje("Ingrese nombre");
		nombreCliente= teclado.next();
		mostrarMensaje("Ingrese nombre de la mascota");
		nombreMascota= teclado.next();
		mostrarMensaje("Ingrese la especie");
		mostrarMensaje("1. Perro");
		mostrarMensaje("2. Gato");
		mostrarMensaje("3. Ave");
		
		int opcion= teclado.nextInt();
			switch (opcion) {
			case 1: 
				Mascota= Especie.PERRO;
				mostrarMensaje("Elegiste Perro");
			break;
			case 2: 
				Mascota= Especie.GATO;
				mostrarMensaje("Elegiste Gato");
			break;
			case 3: 
				Mascota= Especie.AVE;
				mostrarMensaje("Elegiste Ave");
			break;
			default:
				mostrarMensaje("No se pudo ingresar el tipo de mascota");
				break;
			}	
		
		mostrarMensaje("Ingrese el monto");
		monto= teclado.nextDouble();
		
		sePudoCrear=true;
		} while (sePudoCrear=false);
	
		return sePudoCrear;
	}
	
	private static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
