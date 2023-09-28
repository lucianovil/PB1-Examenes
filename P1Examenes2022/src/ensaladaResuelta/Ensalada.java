package ensaladaResuelta;


public class Ensalada {

	private String nombreDeLaEnsalada;
	private Ingrediente ingredientes[] ;
	private Origen origen[];
	
	private final int CANTIDAD_MAXIMA_DE_INGREDIENTES = 50;
	//private final int CANTIDAD_MAXIMA_DE_ORIGENES = 5;

	public Ensalada () {
		ingredientes = new Ingrediente[CANTIDAD_MAXIMA_DE_INGREDIENTES];
		//origen = new Origen[CANTIDAD_MAXIMA_DE_ORIGENES];//origen.length
		this.nombreDeLaEnsalada = "";	
	}
	public Ensalada(String nombreDeLaEnsalada) {
		this.nombreDeLaEnsalada = nombreDeLaEnsalada;
		ingredientes = new Ingrediente[CANTIDAD_MAXIMA_DE_INGREDIENTES];
	}
	
	public String getNombreDeLaEnsalada() {
		return nombreDeLaEnsalada;
	}

	public Ingrediente[] getIngredientes() {
		return ingredientes;
	}
	
	
	public boolean agregarIngrediente(Ingrediente nuevo) {
		 // Incorpora un nuevo ingrediente a la ensalada
		 
		for (int i = 0 ; i < ingredientes.length ; i++) {
			if(ingredientes[i] == null) {
				ingredientes[i] = nuevo;
				return true;
			}
		}
		return false;
	}
	
	public boolean esAptoCeliaco() {
		/*
		 * Devuelve true si ning�n ingrediente es de origen TACC.
		 */
		for (int i = 0 ; i < ingredientes.length ; i++) {
			if(ingredientes[i] != null && ingredientes[i].getOrigen().equals(Origen.TACC)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean esAptoVegetariano() {
		/*
		 * Devuelve true si ning�n ingrediente es de origen ANIMAL
		 */
		for (int i = 0 ; i < ingredientes.length ; i++) {
			if(ingredientes[i] != null && ingredientes[i].getOrigen().equals(Origen.ANIMAL)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean esAptoVegano() {
		/*
		 * Devuelve true si ning�n ingrediente es de origen ANIMAL ni LECHE ni HUEVO
		 */
		for (int i = 0 ; i < ingredientes.length ; i++) {
			if(ingredientes[i] != null && ingredientes[i].getOrigen().equals(Origen.ANIMAL) &&ingredientes[i].getOrigen().equals(Origen.LECHE)&& ingredientes[i].getOrigen().equals(Origen.HUEVO)) {
				return false;
			}
		}
		return true;
	}

	public String toString() {
		/*
		 * Devuelve un String con el nombre de la ensalada y el detalle de los ingredientes que la componen
		 */
		return nombreDeLaEnsalada + ingredientes;
	}
	public double precio() {
		double precio = 0.0;
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i] != null) {
				precio += ingredientes[i].getPrecio();
			}
			
		}
		return precio;
	}

}
