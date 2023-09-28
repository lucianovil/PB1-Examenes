package sistema;

import java.util.Scanner;

import usuario.Usuario;

public class Sistema {

	static Scanner teclado= new Scanner (System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Usuario lucho = new Usuario (null, null, null, null, 0, false, false);
		String contrasenia =" ";
		System.out.println("ingrese una contrasenia");
		contrasenia=teclado.next();
		if (lucho.laContraseniaEsValida(contrasenia)) {
			System.out.println("La contrasenia es valida");
		}
		else {
			System.out.println("La contrasenia no es valida");
		}
		do {
		System.out.println("ingrese la nueva contrasenia");
		contrasenia= teclado.next();
		if (lucho.cambiarContrasenia(contrasenia)) {
			System.out.println("La contrasenia es valida");
		}
		else {
			System.out.println("La contrasenia no es valida");
		}
		}while (contrasenia!="salir");
	}

}
