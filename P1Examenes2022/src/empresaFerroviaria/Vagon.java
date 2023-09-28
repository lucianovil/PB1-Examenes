package empresaFerroviaria;

public class Vagon {

	private String idVagon = "ABC123";
	private String descripcion = "";
	private MarcaVagon marca;
	private double pesoMaximoSoportado=0.0;
	private double pesoDeCarga=0.0;
	private String nombreVagon = "";
	
	

	public Vagon(String idVagon, String nombreVagon, String descripcion, MarcaVagon marca, double pesoMaximoSoportado, double pesoDeCarga) {
		this.idVagon = idVagon;
		this.nombreVagon=nombreVagon;
		this.descripcion = descripcion;
		this.marca = marca;
		this.pesoMaximoSoportado = pesoMaximoSoportado;
		this.pesoDeCarga = pesoDeCarga;
	}
	
	@Override
	public String toString() {
		return "Vagon [idVagon=" + idVagon + ", descripcion=" + descripcion + ", marca=" + marca
				+ ", pesoMaximoSoportado=" + pesoMaximoSoportado + ", pesoDeCarga=" + pesoDeCarga + "]";
	}

	public String getIdVagon() {
		return idVagon;
	}

	public void setIdVagon(String idVagon) {
		this.idVagon = idVagon;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public MarcaVagon getMarca() {
		return marca;
	}

	public void setMarca(MarcaVagon marca) {
		this.marca = marca;
	}

	public double getPesoMaximoSoportado() {
		return pesoMaximoSoportado;
	}

	public void setPesoMaximoSoportado(double pesoMaximoSoportado) {
		this.pesoMaximoSoportado = pesoMaximoSoportado;
	}

	public double getPesoDeCarga() {
		return pesoDeCarga;
	}

	public void setPesoDeCarga(double pesoDeCarga) {
		this.pesoDeCarga = pesoDeCarga;
	}
	
	public String getNombreVagon() {
		return nombreVagon;
	}

	public void setNombreVagon(String nombreVagon) {
		this.nombreVagon = nombreVagon;
	}
	
	public static boolean validarIdentificadorDeVagon (String idVagon) {
		boolean validarIdVagon= false;
	
		int [] numero = {0, 1,2,3,4,5,6,7,8,9};
		if (idVagon.length()==6) {
			validarIdVagon=true;
		}
		return validarIdVagon;
	}
	
	
}
