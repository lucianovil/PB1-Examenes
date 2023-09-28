package srcEnsalada;

import java.util.Arrays;

public class Ensalada {

	private String nombreDeLaEnsalada;
	private Ingrediente ingredientes[] ;
	private double precio=0.0;
	
	
	
	public Ensalada(String nombreDeLaEnsalada, Ingrediente[] ingredientes, double precio) {
		this.nombreDeLaEnsalada = nombreDeLaEnsalada;
		this.ingredientes = ingredientes;
		this.precio = precio;
	}

	
	
	public String getNombreDeLaEnsalada() {
		return nombreDeLaEnsalada;
	}



	public void setNombreDeLaEnsalada(String nombreDeLaEnsalada) {
		this.nombreDeLaEnsalada = nombreDeLaEnsalada;
	}



	public Ingrediente[] getIngredientes() {
		return ingredientes;
	}



	public void setIngredientes(Ingrediente[] ingredientes) {
		this.ingredientes = ingredientes;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public double getPrecio() {
		for(int i=0; i<ingredientes.length; i++) {
			precio+= ingredientes[i].getPrecio();
		}
		return precio;
	}

	public boolean agregarIngrediente(Ingrediente nuevo) {
		/*
		 * Incorpora un nuevo ingrediente a la ensalada
		 */
		for (int i=0; i< ingredientes.length; i++) {
			if (ingredientes[i]== null) {
				ingredientes[i]= nuevo;
				return true;
			}
		}
		return false;
	}
	
	public boolean esAptoCeliaco() {
		/*
		 * Devuelve true si ning�n ingrediente es de origen TACC.
		 */
		boolean esCeliaco=true;
		for (int i=0; i<ingredientes.length; i++) {
			if (ingredientes[i].getOrigen()== Origen.TACC) {
				esCeliaco=false;
			}
		}
		return esCeliaco;
	}
	
	public boolean esAptoVegetariano() {
		/*
		 * Devuelve true si ning�n ingrediente es de origen ANIMAL
		 */
		boolean esVegetariano=true;
		for (int i=0; i<ingredientes.length; i++) {
			if (ingredientes[i].getOrigen()== Origen.ANIMAL) {
				esVegetariano=false;
			}
		}
		return esVegetariano;
	}
	
	public boolean esAptoVegano() {
		/*
		 * Devuelve true si ning�n ingrediente es de origen ANIMAL ni LECHE ni HUEVO
		 */
		boolean esVegano=true;
		for (int i=0; i<ingredientes.length; i++) {
			if (ingredientes[i].getOrigen()== Origen.ANIMAL && ingredientes[i].getOrigen()== Origen.HUEVO && ingredientes[i].getOrigen()== Origen.LECHE) {
				esVegano=false;
			}
		}
		return esVegano;
	}
	
	public String toString() {
		/*
		 * Devuelve un String con el nombre de la ensalada y el detalle de los ingredientes que la componen
		 */
		String resultado = "";
		int contador=1;
		for (int i=0; i<ingredientes.length;i++) {
			if (ingredientes[i] != null) {
				resultado += "\nIngrediente " + contador++ + " " + ingredientes[i].getNombre() + " precio: " + ingredientes[i].getPrecio() ;
			}
		}
		
		return resultado;
	}

	public void ordenarIngredientesPorMayorPrecio ( ) {
		Ingrediente auxiliar = null;
		
		for (int i=0; i<ingredientes.length; i++) {
			for (int j=0; j< ingredientes.length-1; j++) {
				if (ingredientes[j]!= null && ingredientes[j+1]!= null && ingredientes[j].getPrecio()<ingredientes[j+1].getPrecio()) {
					auxiliar = ingredientes[j+1];
					ingredientes[j+1]= ingredientes[j];
					ingredientes[j]= auxiliar;
					
				}
			}
		}	
	}
	
	public Ingrediente[] filtrarPorTipoOrigen (Origen tipoOrigen) {
		Ingrediente[] ingredienteFiltrado= new Ingrediente[ingredientes.length];
		int posicion=0;
		for (int i=0; i<ingredientes.length; i++) {
			if (ingredientes[i] !=null && ingredientes[i].getOrigen().equals(tipoOrigen)) {
				ingredienteFiltrado[posicion++]=ingredientes[i];
			}
		}
		
		return ingredienteFiltrado;
	}
	
	
}
