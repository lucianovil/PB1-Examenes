package prueba;

import java.util.Scanner;

import src.Contacto;
import src.Empresa;
import src.Llamada;
import src.Provincia;

public class InterfazCallCenter {
	
	public static void main(String args[]) {
			
		char opcionIngresada = '\0';
		final char SALIR = '9', INCORPORAR_ZONA_DE_COBERTURA = '1', DAR_DE_ALTA_NUEVO_CONTACTO = '2', REALIZAR_NUEVA_LLAMADA = '3', VER_INFORMACION_DEL_CONTACTO = '4';
		Scanner teclado = new Scanner(System.in);
		Empresa oesteCableColor = new Empresa();
	
		do {
			mostrarMenu();
			opcionIngresada = teclado.next().charAt(0);
			switch(opcionIngresada) {
			case INCORPORAR_ZONA_DE_COBERTURA:
				incorporarZonaDeCobertura(teclado, oesteCableColor);
				break;
			case DAR_DE_ALTA_NUEVO_CONTACTO:
				darDeAltaNuevoContacto(teclado, oesteCableColor);
				break;
			case REALIZAR_NUEVA_LLAMADA:
				realizarNuevaLlamada(teclado, oesteCableColor);
				break;
			case VER_INFORMACION_DEL_CONTACTO:
				verInformacionDelContacto(teclado, oesteCableColor);
				break;
			}
			
		} while(opcionIngresada!=SALIR);

	}
	
	private static void incorporarZonaDeCobertura(Scanner teclado, Empresa actual) {
		/*
		 * Se registra un nuevo código postal dentro de la zona de cobertura de la empresa
		 */
		int nuevoCodigoDeCobertura = 0;
		boolean sePudoAgregar = false;
		System.out.println("Ingrese el nuevo código de cobertura");
		nuevoCodigoDeCobertura = teclado.nextInt();
		sePudoAgregar = actual.agregarNuevaZonaDeCobertura(nuevoCodigoDeCobertura);
		if(sePudoAgregar) {
			System.out.println("Se agregó la zona correctamente");
		}
		else {
			System.out.println("No se pudo agregar");
		}
		
	}
	
	private static void mostrarMenu() {
		System.out.println("Bienvenido al callcenter");
		System.out.println("************************");
		System.out.println("Menu de opciones\n");
		System.out.println("1 - Incorporar zona de cobertura");
		System.out.println("2 - Dar de alta un nuevo contacto");
		System.out.println("3 - Realizar nueva llamada");
		System.out.println("4 - Ver información del contacto");
		System.out.println("9 - Salir");
		System.out.println("************************");
	}
	
	private static void darDeAltaNuevoContacto(Scanner teclado, Empresa actual) {
		/*
		 * Registra un nuevo contacto en la empresa
		 */
		Contacto nuevo;
		String nombreYApellido;
		String celular;
		String eMail;
		String direccion;
		int codigoPostal;
		String localidad;
		int provinciaIngresada;
		Provincia provincia;
		
		System.out.println("Ingrese el nombre:");
		teclado.nextLine();
		nombreYApellido = teclado.nextLine();
		System.out.println("Ingrese el celular");
		celular = teclado.next();
		
		do {
			System.out.println("Ingrese el eMail");
			eMail = teclado.next();
		}while(!Contacto.esEmailValido(eMail));
		
		System.out.println("Ingrese la dirección");
		teclado.nextLine();
		direccion = teclado.nextLine();
		System.out.println("Ingrese el código postal");
		codigoPostal = teclado.nextInt();
		System.out.println("Ingrese la localidad");
		localidad = teclado.next();
		System.out.println("Ingrese el número de provincia" );
		mostrarElListadoDeProvincias();
		provinciaIngresada = teclado.nextInt();
		provincia = Provincia.values()[provinciaIngresada-1];
		
		nuevo = new Contacto(nombreYApellido, celular, eMail, direccion, codigoPostal, localidad, provincia);
		
		actual.agregarNuevoContacto(nuevo);
		
	}
	
	private static void mostrarElListadoDeProvincias() {
		System.out.println("1 - BUENOS_AIRES");
		System.out.println("2 - CABA");
		System.out.println("3 - CATAMARCA");
		System.out.println("4 - CHACO");
		System.out.println("5 - CHUBUT");
		System.out.println("6 - CORDOBA");
		System.out.println("7 - CORRIENTES");
		System.out.println("8 - ENTRE_RIOS");
		System.out.println("9 - FORMOSA");
		System.out.println("10 - JUJUY");
		System.out.println("11 - LA_PAMPA");
		System.out.println("12 - LA_RIOJA");
		System.out.println("13 - MENDOZA");
		System.out.println("14 - MISIONES");
		System.out.println("15 - NEUQUEN");
		System.out.println("16 - RIO_NEGRO");
		System.out.println("17 - SALTA");
		System.out.println("18 - SAN_JUAN");
		System.out.println("19 - SAN_LUIS");
		System.out.println("20 - SANTA_CRUZ");
		System.out.println("21 - SANTA_FE");
		System.out.println("22 - SANTIAGO_DEL_ESTERO");
		System.out.println("23 - TIERRA_DEL_FUEGO");
		System.out.println("24 - TUCUMAN");
	}
	
	private static void realizarNuevaLlamada(Scanner teclado, Empresa actual) {
		/*
		 * Busca un candidato,  muestra los datos del mismo, y permite almacenar el resultado de la llamada.
		 * 
		 * a.	Si la llamada fue exitosa (en ese caso el contacto pasa a ser cliente, y no se lo debe volver a 
		 * llamar).
		 * b.	Si el contacto no desea ser llamado nuevamente (la llamada pudo no haber sido exitosa, pero se haga 
		 * un nuevo intento en el futuro).
		 * c.	Observaciones: Texto libre donde el operador deja registro de lo conversado.
		 */
		Contacto candidato = actual.buscarCandidato();
		char llamadaExitosaIngresada, deseaSerLlamadoNuevamenteIngresado;
		boolean llamadaExitosa = false;
		String observaciones;
		Llamada nueva;
		
		System.out.println(candidato);
		
		System.out.println("La llamada fue exitosa? (S/N)");
		llamadaExitosaIngresada = teclado.next().charAt(0);
		if(llamadaExitosaIngresada=='S') {
			llamadaExitosa=true;
		}
		
		System.out.println("El contacto desea ser llamado nuevamente? (S/N)");
		deseaSerLlamadoNuevamenteIngresado = teclado.next().charAt(0);
		if(deseaSerLlamadoNuevamenteIngresado=='N') {
			candidato.setDeseaSerLlamadoNuevamente(false);
		}
		
		System.out.println("Ingrese las observaciones");
		teclado.nextLine();
		observaciones = teclado.nextLine();
		
		nueva = new Llamada(llamadaExitosa, observaciones);
		
		candidato.registrarNuevaLlamada(nueva);
	}
	
	private static void verInformacionDelContacto(Scanner teclado, Empresa actual) {
		/*
		 * Se visualiza la información del contacto, incluso el listado de las llamadas que se le hicieron
		 */
		String nombre = "";
		Contacto encontrado = null;
		System.out.println("Ingrese el nombre del contacto buscado:");
		teclado.nextLine();
		nombre  = teclado.nextLine(); 
		encontrado = actual.buscarPorNombre(nombre);
		if(encontrado != null) {
			System.out.println(encontrado);
		}
		else {
			System.out.println("Contacto no encontrado");
		}
	}
}
