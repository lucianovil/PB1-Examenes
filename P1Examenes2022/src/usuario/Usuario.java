package usuario;

public class Usuario {

	private String usuario;
	private String contrasenia;
	private String nombre;
	private String apellido;
	private int edad;
	private boolean logueado;
	private boolean bloqueado;
	private int contadorDeCreaciones = 0;
	
	public Usuario(String usuario, String contrasenia, String nombre, String apellido, int edad, boolean logueado,
			boolean bloqueado) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.logueado = logueado;
		this.bloqueado = bloqueado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isLogueado() {
		return logueado;
	}

	public void setLogueado(boolean logueado) {
		this.logueado = logueado;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	
	public boolean laContraseniaEsValida (String contrasenia) {
		boolean esValida=false;
		if (contrasenia.length()>=8 && caracterNumerico(contrasenia) && tieneMayuscula(contrasenia) && tieneMinuscula(contrasenia) && tieneCaracterEspecial(contrasenia)) {
		esValida=true;
		}
		return esValida;
	}
	
	public boolean caracterNumerico (String contrasenia) {
		int contadorNumerico=0;
		for (int i=0; i<contrasenia.length(); i++) {
			if (Character.isDigit(contrasenia.charAt(i))) {
				contadorNumerico++;
			}
		}
		return contadorNumerico>=1;
	}
	
	public boolean tieneMayuscula (String contrasenia) {
		int contadorMayuscula=0;
		for (int i=0; i<contrasenia.length(); i++) {
			if (Character.isUpperCase(contrasenia.charAt(i))) {
				contadorMayuscula++;
			}
		}
		return contadorMayuscula>=1;
	}
	public boolean tieneMinuscula (String contrasenia) {
		int contadorMinuscula=0;
		for (int i=0; i<contrasenia.length(); i++) {
			if (Character.isLowerCase(contrasenia.charAt(i))) {
				contadorMinuscula++;
			}
		}
		return contadorMinuscula>=1;
	}
	public boolean tieneCaracterEspecial (String contrasenia) {
		int contadorCaracterEspecial=0;
		for (int i=0; i<contrasenia.length(); i++) {
			if (contrasenia.charAt(i)<=47) {
				contadorCaracterEspecial++;
			}
		}
		return contadorCaracterEspecial>=1;
	}
	
	
	public boolean cambiarContrasenia (String contrasenia) {
		boolean nuevaContrasenia=false;
		if (laContraseniaEsValida(contrasenia) ) {
		if (this.contrasenia.equals(contrasenia)) {
			nuevaContrasenia=false;
	
		}
		else if (this.contadorDeCreaciones>=5){
			this.setContrasenia(contrasenia);
			nuevaContrasenia=true;
		}
		}
		return nuevaContrasenia;
	}
	public boolean crearContrasenia (String contrasenia) {
       
        boolean pudoCrear = false;
        if (laContraseniaEsValida(contrasenia))
            this.setContrasenia(contrasenia);
           contadorDeCreaciones++;
        pudoCrear = true;

        return pudoCrear;
	}
}
