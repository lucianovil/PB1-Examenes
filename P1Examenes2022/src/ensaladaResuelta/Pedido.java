package ensaladaResuelta;

public class Pedido {
	private String nombreDelCliente;
	private Ensalada[] ensaladas;
	double importe = 0.0;;
	
	public Pedido(String nombre) {
		this.nombreDelCliente = nombre;
		this.ensaladas = new Ensalada[10];
	}
	public boolean agregarNuevaEnsalada(Ensalada nueva) {
		/*
		 * Se incorpora una nueva ensalada a la lista del pedido actual
		 */
		for(int i = 0 ; i < ensaladas.length; i++) {
			if(ensaladas[i] != null) {
				ensaladas[i] = nueva;
				return true;
			}
		}
		return false;
	}
	
	public double getImporte() {
		/*
		 * Calcula el importe en funci�n del precio de cada ingrediente
		 */
		for(int i = 0; i< ensaladas.length; i++) {
			if(ensaladas[i] != null) {
				importe += ensaladas[i].precio();
			}
			
		}
		return importe;
	}
}

