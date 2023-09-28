package srcSubsidio;

import srcSubsidio.Direccion;

public class Usuario {

	private String nombre;
	private Direccion direccion;
	private Double sueldo;
	private long dni=0;
	private String rol ="";
	private Subsidio [] subsidios = new Subsidio [3];

	public Usuario(String nombre, Direccion direccion, Double sueldo) {
		this.nombre= nombre;
		this.direccion=direccion;
		this.sueldo=sueldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public boolean AgregarSubsidio (Subsidio subsidio) {
		boolean pudoAgregar = false;
		int indice=0;
		//                verdadero          &&    verdadero
		while(indice < this.subsidios.length && !pudoAgregar) {
			if(this.subsidios[indice] == null) {
				this.subsidios[indice]= subsidio;
				pudoAgregar=true;
		}
			indice++;
		}
//		for (indice=0; (indice < this.subsidios.length && !pudoAgregar); indice++) {
//			if(this.subsidios[indice] == null) {
//				this.subsidios[indice]= subsidio;
//				pudoAgregar=true;
//				//break; una opcion
//			}
//		}
		return pudoAgregar;
	}

	public Subsidio buscarSubsidioPorIdentificador(int identificador) {
		Subsidio subsidioBuscado = null;
		boolean encontrado = false;
		int indice =0;
		while(indice < this.subsidios.length && !encontrado) {
			if(this.subsidios[indice] != null && this.subsidios[indice].getIdentificador().equals(identificador)) {
				subsidioBuscado= this.subsidios[indice];
				encontrado=true;
		}
			indice++;
		}
		
		return subsidioBuscado;
	}
	
	
	
}
