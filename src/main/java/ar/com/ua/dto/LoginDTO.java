package ar.com.ua.dto;

import java.util.Date;
import java.util.List;

public class LoginDTO {
	
	private UsuarioDTO usuario;
	private String contrasena;
	private Date ultimaVezLogueado;
	private Date ultimaCambioContrasena;
	private int cantidadReintentos;
	private List<String> historicoContrasena;
	private boolean esBloqueado;

}
