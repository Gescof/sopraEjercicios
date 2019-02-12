package modelo.negocio;

import modelo.entidades.Usuario;
import persistencia.DAOUsuarioWebTemplate;

public class GestorUsuarios {
	private static DAOUsuarioWebTemplate daoUsuario;
	
	static {
		daoUsuario = new DAOUsuarioWebTemplate();
	}
	
	public static DAOUsuarioWebTemplate getDaoUsuario() {
		return daoUsuario;
	}

	public static void setDaoUsuario(DAOUsuarioWebTemplate daoUsuario) {
		GestorUsuarios.daoUsuario = daoUsuario;
	}

	public boolean validarUsuario(Usuario usuario) {
		boolean result = false;
		result = daoUsuario.validarUsuario(usuario);
		return result;
	}
}
