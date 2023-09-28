package subsidio;

import java.util.Scanner;

import srcSubsidio.Direccion;
import srcSubsidio.Subsidio;
import srcSubsidio.Usuario;

public class AdministracSubsidios {

	static Scanner teclado= new Scanner (System.in);
	
	public static void main(String[] args) {

		//composicion: meter objetos dentro de objetos
		//Wrapper Double, Integer, Character... etc.
		String nombre = "Juan";
	//	String direccion = "fv 1900";
		Double sueldo = 1000.0;
		
		sueldo.compareTo(500.0);
		//si es igual 0
		// sueldo es menor que 500 <0
		// sueldo es mayor que 500 >0
		System.out.println(sueldo.compareTo(1500.0));
		System.out.println(nombre.compareTo("Lorena")); // compara la J de juan con la L de lorena
		
		//aca empiezo con la clase de german
		String localidad = "san justo";
		String calle="fv";
		Integer numero= 1900;
		Direccion direccion = new Direccion (localidad, calle, numero);
		
		Usuario usuario = new Usuario (nombre, direccion, sueldo);
		
		System.out.println("El nombre es " + usuario.getNombre());
		System.out.println("La direccion es " + usuario.getDireccion().getCalle());
		System.out.println("La direccion es " + usuario.getDireccion()); // me da la direccion de memoria si no tengo el toString
		// como tengo el toString ahora si me da los atributos de la clase
		
		Direccion direccionNueva = new Direccion ("San Justo", "Arieta", 2500);
		usuario.setDireccion(direccionNueva);
		System.out.println("La direccion es " + usuario.getDireccion());
		
		Usuario userJuan= new Usuario ("Juan", new Direccion ("San Justo", "Arieta",200), 60000.0);
		
		int [] enteros = new int [11]; //arrays de 11 lugares
		
		enteros [0]=5;
		enteros [1]=6;
		enteros [2]=8;
		enteros [3]=-5;
		enteros [10]=-5;
		// enteros [11]=3; rompe el programa tengo 11 posiciones pero arranca desde 0 y llega hasta 10 
		
		for (int i = 0; i < enteros.length; i++) {
			System.out.println("posicion de " + i + " valor " + enteros[i]);
		}//imprimo por cada lugar del array
		
		Integer identificador =1;
		String nombreSubsidio = "Subsidio de Gas";
		Double porcentajeDescuento =10.5;
		String tipoSubsidio = "GAS";
		
		Subsidio subsidioGas = new Subsidio (identificador, nombreSubsidio, porcentajeDescuento, tipoSubsidio);

		identificador =2;
		nombreSubsidio = "Subsidio de Luz";
		porcentajeDescuento =20.5;
		tipoSubsidio = "LUZ";
		Subsidio subsidioLuz = new Subsidio (identificador, nombreSubsidio, porcentajeDescuento, tipoSubsidio);
		
		identificador =3;
		nombreSubsidio = "Subsidio de Agua";
		porcentajeDescuento =40.5;
		tipoSubsidio = "AGUA";
		Subsidio subsidioAgua = new Subsidio (identificador, nombreSubsidio, porcentajeDescuento, tipoSubsidio);
		
		identificador =4;
		nombreSubsidio = "Subsidio de Transporte";
		porcentajeDescuento =70.5;
		tipoSubsidio = "Transporte";
		Subsidio subsidioTransporte = new Subsidio (identificador, nombreSubsidio, porcentajeDescuento, tipoSubsidio);

		
		boolean pudoAgregar= usuario.AgregarSubsidio(subsidioGas);
		notificarSiElSubsidioFueAgregado(pudoAgregar);
		pudoAgregar = usuario.AgregarSubsidio(subsidioLuz);
		notificarSiElSubsidioFueAgregado(pudoAgregar);
		pudoAgregar= usuario.AgregarSubsidio(subsidioAgua);
		notificarSiElSubsidioFueAgregado(pudoAgregar);
		pudoAgregar= usuario.AgregarSubsidio(subsidioTransporte);
		notificarSiElSubsidioFueAgregado(pudoAgregar);
		
		Integer identificadorSubsidio=2;
		Subsidio subsidioBuscado= usuario.buscarSubsidioPorIdentificador(identificadorSubsidio);
		notificarSiElSubsidioFueBuscado(subsidioBuscado, identificador);
		
		
		//como adminisitrador registrar usuarios y subsidios, como usuario consultar subsidios
		
		System.out.println("Bienvenido al sistema de subsidios V2.0 ingrese una opcion:");
		System.out.println("1. para ingresar al sistema. \n2. para registrarse.");
		
		int opcion=0;
		do {
		opcion= teclado.nextInt();
		
		switch (opcion) {
		case 1:
			System.out.println("Ingrese dni y contraseña");
			
			break;
		case 2:
			System.out.println("Ingrese DNI");
			System.out.println("Ingrese Nombre");
			System.out.println("Ingrese Direccion");
			System.out.println("Ingrese Contraseña");
			System.out.println("Vuelva a ingresar contraseña");
			
			break;
			default:
				System.out.println("opcion incorrecta vuelva a ingresar una opcion");
				break;
		}
		} while (opcion !=1 || opcion!=2);
		
	}

	public static void notificarSiElSubsidioFueBuscado (Subsidio SubsidioBuscado, Integer identificador) {
		if(SubsidioBuscado!= null) {
			System.out.println("el subsidio buscado es " + SubsidioBuscado.toString());
		} else {
			System.out.println("no se encontro en subsidio el identificador");
		}
	}
	
	public static void notificarSiElSubsidioFueAgregado (boolean pudoAgregar) {
		if(pudoAgregar) {
			System.out.println("\nSubsidio agregado correctamente.");
		} else {
			System.out.println("\nNo fue posible agregar el subsidio");
		}
	}
}
