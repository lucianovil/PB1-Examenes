package callCenter;

public class Empresa {

	/*
	 * Se deben incorporar los atributos necesarios.
	 */
	private int zonasDeCobertura[];
	private String nombre;
	private Contacto contactos[];
	
	private final int CANTIDAD_MAXIMA_DE_ZONAS_DE_COBERTURA = 100;
	private final int CANTIDAD_MAXIMA_DE_CONTACTOS = 10;
	
	//private int cantidadDeContactosActuales;
	
	public Empresa() {
		zonasDeCobertura = new int[CANTIDAD_MAXIMA_DE_ZONAS_DE_COBERTURA];
		inicializarZonasDeCoberturas();
		contactos = new Contacto[CANTIDAD_MAXIMA_DE_CONTACTOS];
		//this.cantidadDeContactosActuales = 0;
		
	}
	
	private void inicializarZonasDeCoberturas() {
		for(int i=0; i<zonasDeCobertura.length;i++) {
				zonasDeCobertura[i] = 0;
			}
	}
	
	public String getNombreEmpresa() {
		/*
		 * Devuelve el nombre de la empresa
		 */
		
		return this.nombre;
	}
	
	public boolean agregarNuevoContacto(Contacto nuevo) {
	
		/*
		 * Incorpora un nuevo contacto a la empresa
		 */
		// Opci�n 1
		/*if(cantidadDeContactosActuales<CANTIDAD_MAXIMA_DE_CONTACTOS) {
			contactos[cantidadDeContactosActuales++] = nuevo;
			return true;
		}
		else {
			return false;
		}*/
		// Opci�n 2
		for(int i=0; i<contactos.length; i++) {
			if(contactos[i]==null) {
				contactos[i] = nuevo;
				return true;
			}
		}
		return false;
	}
	
	public boolean agregarNuevaZonaDeCobertura(int codigoPostal) {
		/*
		 * Incorpora una nueva zona de cobertura (Las zonas de cobertura se identifican por el codigo postal)
		 */
		
		for(int i=0; i<zonasDeCobertura.length;i++) {
			if(zonasDeCobertura[i]==0) {
				zonasDeCobertura[i] = codigoPostal;
				return true;
			}
		}
		
		return false;
	}	
	
	private boolean elCodigoPostalEstaDentroDeLaZonaDeCobertura(int codigoPostal) {
		/*
		 * Determina si un c�digo postal est� dentro de la zona de cobertura
		 */
		for(int i=0; i<zonasDeCobertura.length; i++) {
			if(zonasDeCobertura[i]==codigoPostal) {
				return true;
			}
		}
		return false;
	}
	
	public Contacto buscarCandidato() {
		/*
		 * Para determinar qu� contacto el sistema debe mostrar, se debe realizar la siguiente b�squeda:
		 * 1.	El contacto NO debe ser cliente a�n.
		 * 2.	El contacto desea ser llamado o al menos no inform� lo contrario.
		 * 3.	El c�digo postal del contacto debe existir en las zonas de cobertura existente.
		 * 4.	Del conjunto de contactos resultante se debe seleccionar aleatoriamente el pr�ximo llamado.
		 */
		
		Contacto candidatos[] = new Contacto[contactos.length];
		int cantidadDeCandidatos = 0;

		for(int i=0; i<contactos.length; i++) {
			if(contactos[i]!=null && contactos[i].isDeseaSerLlamadoNuevamente() && !contactos[i].isEsCliente()) {
				candidatos[cantidadDeCandidatos++] = contactos[i];
			}
		}
		
		int candidatoAleatorio = (int)(Math.random()*cantidadDeCandidatos);
		return candidatos[candidatoAleatorio];
	}
	
	public Contacto buscarPorNombre(String nombreABuscar) {
		for(int i=0; i<contactos.length; i++) {
			if(contactos[i] != null && contactos[i].getNombreYApellido().equalsIgnoreCase(nombreABuscar)) {
				return contactos[i];
			}
		}
		return null;
	}
}
