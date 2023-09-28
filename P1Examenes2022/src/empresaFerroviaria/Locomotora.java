package empresaFerroviaria;

public class Locomotora {

	private int idLocomotora=0;
	private String nombre= "";
	private int cantidadMaximaDeVagones;
	private Vagon[] formacion;
	
	public Locomotora(int idLocomotora, String nombre, int cantidadMaximaDeVagones) {
		this.idLocomotora = idLocomotora;
		this.nombre = nombre;
		this.cantidadMaximaDeVagones = cantidadMaximaDeVagones;
		this.formacion = new Vagon [cantidadMaximaDeVagones];
	}

	public int getIdLocomotora() {
		return idLocomotora;
	}

	public void setIdLocomotora(int idLocomotora) {
		this.idLocomotora = idLocomotora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadMaximaDeVagones() {
		return cantidadMaximaDeVagones;
	}

	public void setCantidadMaximaDeVagones(int cantidadMaximaDeVagones) {
		this.cantidadMaximaDeVagones = cantidadMaximaDeVagones;
	}

	public Vagon[] getFormacion() {
		return formacion;
	}

	public void setFormacion(Vagon[] formacion) {
		this.formacion = formacion;
	}
	//agregar un vagon, no se puede agregar vagones repetidos(ya sea por idVagon o nombreVagon)
	public boolean agregarVagon (Vagon vagon) {
		boolean nuevoVagon = false;
		if(!existeVagon(vagon)) {
		for (int i=0; i< formacion.length; i++) {
			if (formacion[i] == null) {
				formacion[i] = vagon;
				nuevoVagon = true;
			}
		}
		}
		return nuevoVagon;
	}
	
	public boolean existeVagon (Vagon vagon) {
		boolean existe=false;
		int i=0;
		while (i<formacion.length && !existe) {
			if(this.formacion[i].getIdVagon().equals(vagon.getIdVagon()) || this.formacion[i].getNombreVagon().equals(vagon.getNombreVagon())) {
				existe=true;
			}
			i++;
		}
		return existe;
	}
	
	public Vagon obtenerVagonDeMenorPeso() {
		Vagon vagonMenorPeso =null;
		
		for (int i=0; i<formacion.length; i++) {
			if(vagonMenorPeso!= null && formacion[i]!=null) {
				vagonMenorPeso= formacion[i];
			}
			if (vagonMenorPeso!=null && formacion[i]!=null && formacion[i].getPesoDeCarga()<formacion[i+1].getPesoDeCarga() ) {
				vagonMenorPeso= formacion[i];
			}
					}
		return vagonMenorPeso;
	}
	
	public double obtenerPesoPromedioDeVagonesParaLaMarca (MarcaVagon Marca) {
		int acumulador=0, contador=0;
		for (int i=0; i<formacion.length; i++) {
			if (formacion[i]!= null && formacion[i].getMarca().equals(Marca)) {
				acumulador+= formacion[i].getPesoDeCarga();
				contador++;
			}
		}
		double promedio= acumulador/contador;
		
		return promedio;
	}
	
	public boolean editarNombreVagon (String idVagon, String nuevoNombreDeVagon) {
		boolean pudoEditar=false;
		for (int i=0; i< formacion.length && !pudoEditar; i++) {
			if(formacion[i]!= null && formacion[i].getIdVagon().equals(idVagon)) {
				formacion[i].setNombreVagon(nuevoNombreDeVagon);
				pudoEditar=true;
			}
		}
		
		return pudoEditar;
	}
	
	public void ordenarVagonesPorIDVagon () {
		Vagon auxiliar = null;
		
		for (int i=0; i<formacion.length; i++) {
			for (int j=0; j<formacion.length-1; j++) {
				if(formacion[j] !=null && formacion[j+1] !=null) {
					if (formacion[j].getIdVagon().compareTo(formacion[j+1].getIdVagon())>0) {
						auxiliar=formacion[j+1];
						formacion[j+1]=formacion[j];
						formacion[j]=auxiliar;
					}
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
