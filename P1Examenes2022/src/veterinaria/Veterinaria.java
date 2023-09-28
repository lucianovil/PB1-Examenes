package veterinaria;

public class Veterinaria {

	private String nombre;
	private Atencion[] atenciones;
	private String nombreUsuario = "lucho";
	private String contrasenia = "1234";
	
	
	public Veterinaria(String nombre, Atencion[] atenciones) {
		this.nombre = nombre;
		this.atenciones =atenciones ;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Atencion[] getAtenciones() {
		return atenciones;
	}

	public void setAtenciones(Atencion[] atenciones) {
		this.atenciones = atenciones;
	}

	/**
	 * Agrega una atenciona al arreglo de atenciones
	 * 
	 * @param atencion Atencion	que se agregara
	 * @return true en caso de exito
	 * */
	public boolean registrarAtencion(Atencion atencion) {
		boolean pudoRegistrar= false;
		int i=0;
		while (i<atenciones.length && !pudoRegistrar) {
			if (atenciones[i]==null ) {
				atenciones[i]= atencion;
				pudoRegistrar=true;
			}
			i++;
		}
		
		return pudoRegistrar;
	}
	
	/**
	 * Obtiene una atencion por su identificador
	 * 
	 * @param id	Identificador de la atencion
	 * @return atencion o null en caso de no encontrarse
	 * */
	public Atencion buscarAtencionPorId(int id) {
		Atencion nuevaAtencion= null;
		for (int i=0; i<atenciones.length; i++) {
			if(atenciones[i]!=null && atenciones[i].getId()==id) {
				nuevaAtencion= atenciones[i];
				break;
			}
		}
		return nuevaAtencion;
	}
	
	/**
	 * Obtiene atenciones filtradas por la especie de la mascota
	 * 
	 * @return array de atenciones
	 * */
	public Atencion[] listarAtencionesPorEspecieDeMascota(Especie especieMascota){
		Atencion [] listarPorEspecieDeMascota= new Atencion[atenciones.length];
		int posicion=0;
		for (int i=0; i<atenciones.length; i++) {
			if(atenciones[i]!= null && atenciones[i].getEspecieMascota().equals(especieMascota)) {
				listarPorEspecieDeMascota[posicion++]=atenciones[i];
			}
		}
		
		return listarPorEspecieDeMascota;
	}
	
	/**
	 * Elimina una atencion por su identificador
	 * 
	 * @param id 	Identificador de la atencion
	 * @return true en caso de exito
	 * */
	public boolean eliminarAtencionPorId(int id) {
		boolean pudoEliminar= false;
		for (int i=0; i<atenciones.length; i++) {
			if (atenciones[i]!=null && atenciones[i].getId()==id) {
				atenciones[i]= null;
				pudoEliminar=true;
			}
		}
		
		return pudoEliminar;
	}
	
	/**
	 * Obtiene la cantidad de atenciones realizadas hasta el momento
	 * 
	 * @return cantidad de atenciones
	 * */
	public int obtenerCantidadDeAtencionesRealizadas() {
		int contador=0;
		
		for (int i=0; i<atenciones.length;i++) {
			if (atenciones[i]!=null) {
				contador++;
			}
		}
		
		return contador;
	}
	
	/**
	 * Obtiene la cantidad de atenciones disponibles
	 * 
	 * @return atenciones
	 * */
	public int obtenerCantidadDeAtencionesDisponibles(int atencionesRealizadas) {
		int cantidadAtencionesDisponibles=0;
		cantidadAtencionesDisponibles= atenciones.length - obtenerCantidadDeAtencionesRealizadas();
		
		return cantidadAtencionesDisponibles;
	}
	
	/**
	 * Calcula y devuelve el total de todas las atenciones realizadas
	 * 
	 * @return monto total
	 * */
	public double obtenerTotalDeAtenciones() {
		double montoTotal=0.0;
		
		for (int i=0; i<atenciones.length; i++) {
			if(atenciones[i]!=null) {
				montoTotal+= atenciones[i].getMonto();
			}
		}
		return montoTotal;
	}
	
	/**
	 * Obtiene atenciones ordenadas por monto descendente
	 * 
	 * @return atenciones
	 * */
	public void ordenarAtencionesPorMontoDescendente() {
		Atencion auxiliar= null;
		for (int i=0; i<atenciones.length; i++) {
			for (int j=0; j<atenciones.length-1; j++) {
				if(atenciones[j] !=null && atenciones[j+1]!=null) {
					if( atenciones[j].getMonto()<atenciones[j+1].getMonto()) {
				// atencion j vaso de coca con sprite dentro y atencion j+1 vaso de sprite con coca adentro
					auxiliar = atenciones[j];
					atenciones[j]= atenciones[j+1];
					atenciones [j+1] = auxiliar;
				}
			}
		}
		}
	}
	
	/**
	 * Valida las credenciales proporcionadas
	 * 
	 * @param nombreUsuario		Nombre de usuario del administrador
	 * @param contrasenia		Contrasenia del administrador
	 * @return verdadero en caso de exito
	 * */
	public boolean iniciarSesion(String nombreUsuario, String contrasenia) {
		boolean sePudoIniciarSesion=false;
		if (this.nombreUsuario.compareTo(nombreUsuario)==0 && this.contrasenia.compareTo(contrasenia)==0) {
			sePudoIniciarSesion=true;
		}
		return sePudoIniciarSesion;
	}
}
