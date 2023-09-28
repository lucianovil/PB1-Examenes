package ensaladaResuelta;

public class Ingrediente {
	
	private String nombre;
	private double precio;
	private Origen origen;
	
	public Ingrediente(String nombre, double precio, Origen origen) {
		this.nombre = nombre;
		this.precio = precio;
		this.origen = origen;
	}
	public double getPrecio() {
		return precio;
	}
	public String getNombre() {
		return nombre;
	}

	public Origen getOrigen() {
		return origen;
	}
  /*  switch(opcionElegida) {
    case '1':
	System.out.println("Ingredientes: ");
	System.out.println("Lechuga, tomate, queso, zanahoria, pollo");
	break;
    case '2':
    	System.out.println("Ingredientes: ");
    	System.out.println("Espinaca, palta, tomate, cebolla");
    	break;
    case '3':
    	System.out.println("Ingredientes: ");
    	System.out.println("Lechuga, tomate, queso, zanahoria, pollo");
    	break;	
} */
}



