package srcEnsalada;

import java.util.Arrays;

public class Pedido {
	private String nombreDelCliente;
	private Ensalada[] ensaladas;
	
	
	
	public Pedido(String nombreDelCliente, Ensalada[] ensaladas) {
		this.nombreDelCliente = nombreDelCliente;
		this.ensaladas = ensaladas;
	}
	
	

	public String getNombreDelCliente() {
		return nombreDelCliente;
	}



	public void setNombreDelCliente(String nombreDelCliente) {
		this.nombreDelCliente = nombreDelCliente;
	}



	public Ensalada[] getEnsaladas() {
		return ensaladas;
	}



	public void setEnsaladas(Ensalada[] ensaladas) {
		this.ensaladas = ensaladas;
	}


	

	@Override
	public String toString() {
		return "Pedido [nombreDelCliente=" + nombreDelCliente + ", ensaladas=" + Arrays.toString(ensaladas) + "]";
	}



	public boolean agregarNuevaEnsalada(Ensalada nueva) {
		/*
		 * Se incorpora una nueva ensalada a la lista del pedido actual
		 */
		boolean incorporarEnsalada=false;
		int i=0;
		for (i=0; i<ensaladas.length; i++) {
			if (ensaladas == null) {
				ensaladas [i]= nueva;
				incorporarEnsalada= true;
			}
		}
		
		return incorporarEnsalada;
	}
	
	public double getImporte() {
		/*
		 * Calcula el importe en funci�n del precio de cada ingrediente
		 */
		double precio=0.0;
		for (int i=0; i< ensaladas.length; i++) {
			precio+= ensaladas[i].getPrecio();
		}
		
		return precio;
	}
}

