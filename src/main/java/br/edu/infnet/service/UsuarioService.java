package br.edu.infnet.service;

import br.edu.infnet.model.Usuario;
import br.edu.infnet.exception.UserNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UsuarioService {
    public Usuario criarUsuario(Usuario usuario) {
        Usuario.persist(usuario);
        return usuario;
    }

    public List<Usuario> findAll() {
        return Usuario.findAll()
                .list();
    }

    public Usuario findById(Long idUsuario) {
        return (Usuario) Usuario.findByIdOptional(idUsuario)
                .orElseThrow(UserNotFoundException::new);
    }

    public Usuario atualizarUsuario(Long idUsuario, Usuario atualizado) {
        var usuario = findById(idUsuario);

        usuario.nomeUsuario = atualizado.nomeUsuario;

        Usuario.persist(usuario);

        return usuario;
    }

    public void deleteById(Long idUsuario) {
        var usuario = findById(idUsuario);
        Usuario.deleteById(usuario.idUsuario);
    }
}
