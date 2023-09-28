package src;

public class Contacto {
	
	/*
	 * Se deben incorporar los atributos necesarios.
	 * 
	 * �	Nombre y Apellido: No se aceptan n�meros.
	 * �	Celular: Compuesto del c�digo de pa�s + c�digo de �rea + n�mero de celular.
	 * �	E-Mail: Debe contener al menos el s�mbolo �@� y el caracter �.�.
	 * �	Direcci�n: Valor alfanum�rico.
	 * �	C�digo Postal: Valor num�rico.
	 * �	Localidad: Valor alfanum�rico.
	 * �	Provincia. Enumerador que contenga las 23 provincias argentinas.
	 * �	Es cliente (Si o No): Inicialmente se carga en �No�.
	 * �	Desea ser llamado nuevamente (Si o No): Inicialmente se carga en �Si�.
	 */
	private String nombreYApellido;
	public String getNombreYApellido() {
		return nombreYApellido;
	}

	private String celular;
	private String eMail;
	private String direccion;
	private int codigoPostal;
	private String localidad;
	private Provincia provincia;
	private boolean esCliente;
	public boolean isEsCliente() {
		return esCliente;
	}

	public void setEsCliente(boolean esCliente) {
		this.esCliente = esCliente;
	}

	private boolean deseaSerLlamadoNuevamente;
	
	public boolean isDeseaSerLlamadoNuevamente() {
		return deseaSerLlamadoNuevamente;
	}

	public void setDeseaSerLlamadoNuevamente(boolean deseaSerLlamadoNuevamente) {
		this.deseaSerLlamadoNuevamente = deseaSerLlamadoNuevamente;
	}

	private Llamada llamadasRecibidas[];
	private final int CANTIDAD_MAXIMA_DE_LLAMADOS_POR_CONTACTO;
	
	public Contacto(String nombreYApellido, String celular, String eMail, String direccion, int codigoPostal, String localidad, Provincia provincia) {
		this.nombreYApellido = nombreYApellido;
		this.celular = celular;
		//this.eMail = eMail;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.provincia = provincia;
		this.esCliente = false;
		this.deseaSerLlamadoNuevamente = true;
		this.CANTIDAD_MAXIMA_DE_LLAMADOS_POR_CONTACTO = 10;
		this.llamadasRecibidas = new Llamada[CANTIDAD_MAXIMA_DE_LLAMADOS_POR_CONTACTO];
		
	}
	
	public static boolean esEmailValido(String eMail) {
		/*
		 * Evalúa si un String determinado puede ser almacenado como E-MAIL.
		 */
		boolean tieneArroba = false, tienePunto = false;
		// 1. Hacer un array de char del String

		char eMailPropuesto[] = eMail.toCharArray();
		for(int i=0; i<eMailPropuesto.length; i++) {
			if(eMailPropuesto[i]=='@') {
				tieneArroba = true;
			}
			else if(eMailPropuesto[i]=='.') {
				tienePunto = true;
			}
		}
		if(tieneArroba && tienePunto) {
			return true;
		}
		else {
			return false;
		}
		
		// 2. Con el charAt
		/*for(int i=0; i<eMail.length(); i++) {
			if(eMail.charAt(i)=='@') {
				tieneArroba = true;
			}
			else if(eMail.charAt(i)=='.') {
				tienePunto = true;
			}
		}
		if(tieneArroba && tienePunto) {
			return true;
		}
		else {
			return false;
		}*/
		
		// 3. Con el método contains de String
		/*if(eMail.contains("@") && eMail.contains(".")) {
			return true;
		}
		else {
			return false;
		}*/
	}
	
	public boolean registrarNuevaLlamada(Llamada nueva) {
		/*
		 * Registra una nueva llamada asociada al contacto actual.
		 */
		for(int i=0; i<llamadasRecibidas.length; i++) {
			if(llamadasRecibidas[i]==null) {
				llamadasRecibidas[i] = nueva;
				return true;
			}
		}
		// Se llegó a la cantidad máxima de llamados, entonces actualizamos el atributo no desea ser llamado nuevamente
		this.deseaSerLlamadoNuevamente = false;
		return false;
	}
	
	public String toString() {
		/*
		 * Muestra los datos de un contacto, entre los que se debe incluir el registro de las llamadas realizadas.
		 */
		String resultado = "";
		
		resultado = this.nombreYApellido + "\n" + this.celular;
		
		for(int i = 0; i < llamadasRecibidas.length; i++) {
			if(llamadasRecibidas[i]!=null) {
				resultado += "\n" + "[" + i + "]" + llamadasRecibidas[i].getObservaciones();
			}
		}
		
		return resultado;
	}	
}
