package persistencia;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import modelo.entidades.Usuario;

public class DAOUsuarioWebTemplate implements DAOUsuario {
	private HashMap<String, String> listaUsuarios;

	public DAOUsuarioWebTemplate() {
		listaUsuarios = new HashMap<>();
		listaUsuarios.put("Guillermo", "1234abc");
		listaUsuarios.put("Beatriz", "9876zxy");
		listaUsuarios.put("Felix", "GOT2019");
	}
	
	public HashMap<String, String> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(HashMap<String, String> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean validarUsuario(Usuario usuario) {
		boolean result = false;
		Iterator it = listaUsuarios.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if(pair.getKey().equals(usuario.getNombre()) 
				&& pair.getValue().equals(usuario.getPassword())) 
			{
				result = true;
				it.remove();
			}
	    }
		return result;
	}
	
}
