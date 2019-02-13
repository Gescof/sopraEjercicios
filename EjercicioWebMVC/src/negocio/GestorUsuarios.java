package negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import entidades.Usuario;

@Service
public class GestorUsuarios {
	private List<Usuario> listaUsuarios;

	public GestorUsuarios() {
		listaUsuarios = new ArrayList<>();
		listaUsuarios.add(new Usuario("Guille", "1234abc"));
		listaUsuarios.add(new Usuario("Bea", "9876zxy"));
		listaUsuarios.add(new Usuario("Felix", "got0"));
	}
	
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	public boolean buscarUsuario(Usuario usuario) {
		boolean result = false;
		for(Usuario usuarioAux : listaUsuarios) {
			if(usuarioAux.equals(usuario)) {
				result = true;
			}
		}
		return result;
	}
	
}
