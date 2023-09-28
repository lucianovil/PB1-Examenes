package mundial2022;

public class Album {

private static String selecciones[] = {"Qatar", "Ecuador", "Senegal", "Paises Bajos", "Inglaterra", "Irán", "EEUU", "Gales", "Argentina", "Arabia Saudita", "México", "Polonia", "Francia", "Australia", "Dinamarca", "Tunez", "España", "Costa Rica", "Alemania", "Japón", "Bélgica", "Canadá", "Marruecos", "Croacia", "Brasil", "Serbia", "Suiza", "Camerún", "Portugal", "Ghana", "Uruguay", "Corea del Sur"};
	
	private Figurita figuritasDisponibles[] = new Figurita[704];
	private Figurita figuritasActuales[];
	
	public Album() {
		/*
		 * El constructor debe generar las condiciones necesaias para garantizar el correcto funcionamiento de la app
		 */
		//this.selecciones = selecciones;
		//this.figuritasDisponibles= figuritasDisponibles;
	
		
	}
	
	public void inicializarCodigosDeFiguritas() {
		/*
		 * Por cada país debe generar 22 códigos de manera automática por ejemplo QAT1, URU12, COS10
		 */
		int posicionFiguritasDisponibles=0;
		String codigoFigurita= "";
		for (int i=0; i<selecciones.length; i++) {
			
			String caracterPais= (selecciones[i].substring(0, 3).toUpperCase());
			for (int j=1; j<23; j++) {
				codigoFigurita = caracterPais + j;
				figuritasDisponibles[posicionFiguritasDisponibles++] = new Figurita(codigoFigurita);
				
				//codigoFigurita;
			}
		}

	}
	
	public void actualizarDatosFigurita(String codigo, char grupo, String nombreJugador, double valor) {
		/*
		 * En función del código de figurita, se deben actualizar los datos de la misma en figuritasDisponibles 
		 */
	
		for (int i=0; i<figuritasDisponibles.length; i++) {
			if (figuritasDisponibles[i].getCodigo().equals(codigo)){
				figuritasDisponibles[i].setGrupo(grupo);
				figuritasDisponibles[i].setNombreJugador(nombreJugador);
				figuritasDisponibles[i].setValor(valor);
				
			}
			
		}
		
	
	}
	
	public Figurita getFigurita(String codigo) {
		/*
		 * En función del código de figurita, devuelve la figurita de figuritasDisponibles
		 */
		Figurita tengoFigurita = null;
		for (int i=0; i<figuritasDisponibles.length; i++) {
			if (figuritasDisponibles[i].getCodigo().equals(codigo)) {
				tengoFigurita = figuritasDisponibles[i];
			}
		}
		return tengoFigurita;
	}
	
	public Figurita[] comprarSobre() {
		/*
		 * Se debe calcular y devolver 5 códigos de figurita de manera aleatoria.
		 */
		Figurita sobre[] = new Figurita[5];
		
		for (int i=0; i<5; i++) {
			int figuCualquiera = (int) (Math.random()*704);
			sobre[i] = figuritasDisponibles[figuCualquiera];
		}
		
		return sobre;
	}
	
	public void agregarFigurita(Figurita nueva) {
		/*
		 * Agrega una nueva figurita al array figuritasActuales
		 */
	}
	
	public void ordenarFiguritasActuales() {
		/*
		 * Debe ordenar el array figuritasActuales
		 */
		
		Figurita auxiliar = null;
	
		for (int i=1; i<figuritasActuales.length; i++) {
			for (int j=0; j<figuritasActuales.length -1; j++) {
				if (figuritasActuales[j] !=null && figuritasActuales[j+1] != null) {
				if (figuritasActuales[j].getCodigo().compareTo(figuritasActuales[j+1].getCodigo()) >0){
						auxiliar = figuritasActuales [j+1];
						figuritasActuales[j+1]= figuritasActuales[j];
						figuritasActuales[j] = auxiliar;
						
					}
				}
			}
			
		}
	
	}
	
	public boolean elAlbumEstaCompleto() {
		/*
		 * Debe verificar que todas las figuritas disponibles estén presentes al menos una vez en las figuritas actuales 
		 */	
		
		
		return false;
	}
	
	public double calcularPorcentajeCompletado() {
		/*
		 * Debe calcular el porcentaje de figuritas del album que está completo. Para esto se debe basar en la información de las figuritasDisponibles en relación a las figuritasActuales que se tiene en el album.
		 */
		int acumuladorActuales=0;
		
			for (int i=0; i<figuritasActuales.length; i++) {
				if(figuritasActuales[i] != null) {
				acumuladorActuales++;
			}
		}
		double porcentaje= ((double)acumuladorActuales*100)/(double)figuritasDisponibles.length;
		
		return porcentaje;
	}

}
	
	
	
	
	

